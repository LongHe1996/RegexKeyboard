package regex.keyboard.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import regex.keyboard.infra.dataobject.AnswerDO;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerDO, Long> {
    List<AnswerDO> findByRespondent(Long respondent);
    List<AnswerDO> findByQuestionId(Long questionId);
}
