package regex.keyboard.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import regex.keyboard.infra.dataobject.QuestionDO;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionDO, Long> {
   List<QuestionDO> findByQuestioner(Long questioner);
   List<QuestionDO> findByOrderByPutTimeDesc();
}
