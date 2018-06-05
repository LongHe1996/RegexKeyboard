package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.domain.regexkeyboard.convertor.QuestionConvertor;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;
import regex.keyboard.domain.repository.QuestionRepository;
import regex.keyboard.domain.service.QuestionService;
import regex.keyboard.infra.dataobject.QuestionDO;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionConvertor questionConvertor;

    @Override
    public QuestionDTO create(QuestionE questionE) {
        QuestionDO questionDO = questionConvertor.entityToDo(questionE);
        QuestionDO saveQuestionDO = questionRepository.save(questionDO);
        return new QuestionDTO(questionConvertor.doToEntity(saveQuestionDO), "success.create.question:" + saveQuestionDO.getQuestionContent(), true);
    }

    @Override
    public QuestionDTO deleteById(Long id) {
        //1.question不存在
        if (questionRepository.findOne(id) == null) {
            return new QuestionDTO(null, "error.delete.question.not.exist.id:" + id, false);
        }
        questionRepository.delete(id);
        return new QuestionDTO(null, "success.delete.question.id:" + id, true);
    }

    @Override
    public QuestionDTO updateIfSolved(QuestionE questionE, Long acceptAnswer) {
        QuestionDO questionDO = questionConvertor.entityToDo(questionE);
        //1.question不存在
        if (questionRepository.findOne(questionDO.getId()) == null) {
            return new QuestionDTO(null, "error.update.question.accept.answer.not.exist." + questionDO.getId(), false);
        }
        questionDO.setAcceptAnswer(acceptAnswer);
        QuestionDO updateQuestionDO = questionRepository.save(questionDO);
        return new QuestionDTO(questionConvertor.doToEntity(updateQuestionDO), "success.update.question.accept.answer:" + updateQuestionDO, true);
    }

    @Override
    public QuestionDTO selectById(Long id) {
        QuestionDO questionDO = questionRepository.findOne(id);
        if (questionDO == null) {
            return new QuestionDTO(null, "error.select.question.not.exist.id:" + id, false);
        }
        return new QuestionDTO(questionConvertor.doToEntity(questionDO), "success.select.question.id:" + questionDO, true);
    }

    @Override
    public List<QuestionDTO> selectByQuestioner(Long questioner) {
        List<QuestionDTO> selectByQuestioner = new ArrayList<>();
        List<QuestionDO> byQuestioner = questionRepository.findByQuestioner(questioner);
        if (byQuestioner.isEmpty()) {
            selectByQuestioner.add(new QuestionDTO(null, "error.select.question.not.exist.questioner" + questioner, false));
            return selectByQuestioner;
        }
        for (QuestionDO questionDO : byQuestioner
                ) {
            QuestionE questionE = questionConvertor.doToEntity(questionDO);
            selectByQuestioner.add(new QuestionDTO(questionE, "success.select.question.by.questioner:" + questioner, true));
        }
        return selectByQuestioner;
    }

    @Override
    public List<QuestionDTO> selectAllSort() {
        List<QuestionDTO> selectByOrderByPutTimeDesc = new ArrayList<>();
        List<QuestionDO> byOrderByPutTimeDesc = questionRepository.findByOrderByPutTimeDesc();
        if (byOrderByPutTimeDesc.isEmpty()) {
            selectByOrderByPutTimeDesc.add(new QuestionDTO(null, "error.selecy.all.question.", false));
            return selectByOrderByPutTimeDesc;
        }
        for (QuestionDO questionDO : byOrderByPutTimeDesc) {
            QuestionE questionE = questionConvertor.doToEntity(questionDO);
            selectByOrderByPutTimeDesc.add(new QuestionDTO(questionE, "success.select.all.question.", true));
        }
        return selectByOrderByPutTimeDesc;
    }
}
