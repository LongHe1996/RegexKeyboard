package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.AnswerDTO;
import regex.keyboard.domain.regexkeyboard.convertor.AnswerConvertor;
import regex.keyboard.domain.regexkeyboard.entity.AnswerE;
import regex.keyboard.domain.repository.AnswerRepository;
import regex.keyboard.domain.service.AnswerService;
import regex.keyboard.infra.dataobject.AnswerDO;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private AnswerConvertor answerConvertor;

    @Override
    public AnswerDTO create(AnswerE answerE) {
        AnswerDO answerDO = answerConvertor.entityToDo(answerE);
        AnswerDO saveAnswerDO = answerRepository.save(answerDO);
        return new AnswerDTO(answerConvertor.doToEntity(saveAnswerDO), "success.create.answer:" + saveAnswerDO.getAnswerContent(), true);
    }

    @Override
    public String deleteById(Long id) {
        //1.answer不存在
        if (answerRepository.findOne(id) == null) {
            return "error.delete.answer.not.exist.id:" + id;
        }
        answerRepository.delete(id);
        return "success.delete.answer.id:" + id;
    }

    @Override
    public AnswerDTO updateIfAccepted(Long answerId) {
        AnswerDO answerDO = answerRepository.findOne(answerId);
        //1.answer不存在
        if (answerRepository.findOne(answerDO.getId()) == null) {
            return new AnswerDTO(null, "error.update.answer.accept.not.exist." + answerDO.getId(), false);
        }
        answerDO.setAccepted(true);
        AnswerDO updateAnswerDO = answerRepository.save(answerDO);
        return new AnswerDTO(answerConvertor.doToEntity(updateAnswerDO), "success.update.answer.accept:" + updateAnswerDO, true);
    }

    @Override
    public List<AnswerDTO> selectByRespondent(Long respondent) {
        List<AnswerDTO> selectByRespondent = new ArrayList<>();
        List<AnswerDO> byRespondent = answerRepository.findByRespondent(respondent);
        if (byRespondent.isEmpty()) {
            selectByRespondent.add(new AnswerDTO(null, "error.select.answer.by.respondent.not.exist:" + respondent, false));
            return selectByRespondent;
        }
        for (AnswerDO answerDO : byRespondent
                ) {
            AnswerE answerE = answerConvertor.doToEntity(answerDO);
            selectByRespondent.add(new AnswerDTO(answerE, "success.select.answer.by.respondent:" + respondent, true));
        }
        return selectByRespondent;
    }

    @Override
    public List<AnswerDTO> selectByQuestionId(Long questionId) {
        List<AnswerDTO> selectByQuestionId = new ArrayList<>();
        List<AnswerDO> byQuestionId = answerRepository.findByQuestionId(questionId);
        if (byQuestionId.isEmpty()||byQuestionId==null || byQuestionId.size()==0) {
            selectByQuestionId.add(new AnswerDTO(null, "error.select.answer.by.question.id.not.exist:" + questionId, false));
            return selectByQuestionId;
        }
        for (AnswerDO answerDO : byQuestionId
                ) {
            System.out.println("a:"+answerDO.getId()+","+answerDO.getRespondent());
            AnswerE answerE = answerConvertor.doToEntity(answerDO);
            selectByQuestionId.add(new AnswerDTO(answerE, "success.select.answer.by.question.id.:" + questionId, true));
        }
        return selectByQuestionId;
    }
}
