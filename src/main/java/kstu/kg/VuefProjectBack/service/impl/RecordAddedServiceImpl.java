package kstu.kg.VuefProjectBack.service.impl;

import kstu.kg.VuefProjectBack.dto.request.RecordDtoRequest;
import kstu.kg.VuefProjectBack.dto.response.RecordDtoResponse;
import kstu.kg.VuefProjectBack.entity.Journal;
import kstu.kg.VuefProjectBack.entity.User;
import kstu.kg.VuefProjectBack.entity.Wallet;
import kstu.kg.VuefProjectBack.service.RecordAddedService;
import kstu.kg.VuefProjectBack.service.database.JournalService;
import kstu.kg.VuefProjectBack.service.database.UserService;
import kstu.kg.VuefProjectBack.service.database.WalletService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecordAddedServiceImpl implements RecordAddedService {
    final JournalService journalService;

    final WalletService walletService;

    final UserService userService;

    @Autowired
    public RecordAddedServiceImpl(JournalService journalService,
                                  WalletService walletService,
                                  UserService userService) {
        this.journalService = journalService;
        this.walletService = walletService;
        this.userService = userService;
    }

    @Override
    public RecordDtoResponse addedNewRecord(RecordDtoRequest recordDtoRequest) {
        User user = userService.findByLogin(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        );

        journalService.saveOrUpdate(
                Journal.builder()
                        .type(recordDtoRequest.getType())
                        .amount(recordDtoRequest.getAmount())
                        .description(recordDtoRequest.getDescription())
                        .user(user)
                        .build()
        );

        Wallet wallet = walletService.getByUser(user.getId());
        wallet.setAmount(
                recordDtoRequest.getType().equals("income") ?
                        wallet.getAmount().add(recordDtoRequest.getAmount()) :
                        wallet.getAmount().subtract(recordDtoRequest.getAmount())
        );
        walletService.saveOrUpdate(wallet);

        return RecordDtoResponse.builder()
                .amount(wallet.getAmount())
                .build();
    }
}
