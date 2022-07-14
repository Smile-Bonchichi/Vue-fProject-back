package kstu.kg.VuefProjectBack.service.database;

import kstu.kg.VuefProjectBack.entity.Journal;
import kstu.kg.VuefProjectBack.service.base.CrudService;

import java.util.List;

public interface JournalService extends CrudService<Journal> {
    List<Journal> getAllJournalUsers(Long id);
}
