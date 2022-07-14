package kstu.kg.VuefProjectBack.repository;

import kstu.kg.VuefProjectBack.entity.Journal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM journal_record t WHERE t.user_id = :userId")
    List<Journal> getAllByUserId(@Param("userId") Long userId);
}
