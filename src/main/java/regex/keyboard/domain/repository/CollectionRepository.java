package regex.keyboard.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import regex.keyboard.infra.dataobject.CollectionDO;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionDO, Long> {
    List<CollectionDO> findByQuestionId(Long questionId);

    List<CollectionDO> findByCollector(Long collector);
}
