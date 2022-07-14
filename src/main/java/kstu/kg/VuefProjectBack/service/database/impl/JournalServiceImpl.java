package kstu.kg.VuefProjectBack.service.database.impl;

import kstu.kg.VuefProjectBack.entity.Journal;
import kstu.kg.VuefProjectBack.repository.JournalRepository;
import kstu.kg.VuefProjectBack.service.base.impl.CrudServiceImpl;
import kstu.kg.VuefProjectBack.service.database.JournalService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JournalServiceImpl extends CrudServiceImpl<Journal> implements JournalService {
    final JournalRepository journalRepository;

    @Autowired
    public JournalServiceImpl(JournalRepository journalRepository) {
        super(journalRepository);
        this.journalRepository = journalRepository;
    }

    @Override
    public List<Journal> getAllJournalUsers(Long id) {
        return journalRepository.getAllByUserId(id);
    }
}
