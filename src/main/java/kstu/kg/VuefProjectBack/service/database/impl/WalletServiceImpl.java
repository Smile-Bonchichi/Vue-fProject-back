package kstu.kg.VuefProjectBack.service.database.impl;

import kstu.kg.VuefProjectBack.entity.Wallet;
import kstu.kg.VuefProjectBack.repository.WalletRepository;
import kstu.kg.VuefProjectBack.service.base.impl.CrudServiceImpl;
import kstu.kg.VuefProjectBack.service.database.WalletService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletServiceImpl extends CrudServiceImpl<Wallet> implements WalletService {
    final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        super(walletRepository);
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet getByUser(Long userId) {
        return walletRepository.getByUserId(userId);
    }
}
