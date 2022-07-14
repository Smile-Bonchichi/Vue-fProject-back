package kstu.kg.VuefProjectBack.service.impl;

import kstu.kg.VuefProjectBack.dto.response.HistoryDtoResponse;
import kstu.kg.VuefProjectBack.entity.Journal;
import kstu.kg.VuefProjectBack.entity.User;
import kstu.kg.VuefProjectBack.service.HistoryService;
import kstu.kg.VuefProjectBack.service.database.JournalService;
import kstu.kg.VuefProjectBack.service.database.UserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryServiceImpl implements HistoryService {
    final JournalService journalService;

    final UserService userService;

    @Autowired
    public HistoryServiceImpl(JournalService journalService,
                              UserService userService) {
        this.journalService = journalService;
        this.userService = userService;
    }

    @Override
    public List<HistoryDtoResponse> getAllRecordsUser() {
        User user = userService.findByLogin(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        );

        List<Journal> journals = journalService.getAllJournalUsers(user.getId());
        List<HistoryDtoResponse> historyDtoResponses = new ArrayList<>();

        for (int i = 0; i < journals.size(); i++) {
            historyDtoResponses.add(
                    HistoryDtoResponse.builder()
                            .rowNumber((long) (i + 1))
                            .amount(journals.get(i).getAmount())
                            .recordDate(journals.get(i).getCreateTime())
                            .description(journals.get(i).getDescription())
                            .type(journals.get(i).getType().equals("income") ? "Доход" : "Расход")
                            .build()
            );
        }

        return historyDtoResponses;
    }
}
