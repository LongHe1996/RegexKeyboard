package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.domain.regexKeyboard.convertor.QuestionConvertor;
import regex.keyboard.domain.regexKeyboard.entity.QuestionE;
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
        QuestionDO questionDO=questionConvertor.entityToDo(questionE);
        QuestionDO saveQuestionDO = questionRepository.save(questionDO);
        return new QuestionDTO(questionConvertor.doToEntity(saveQuestionDO),"success.create.question:"+saveQuestionDO.getQuestionContent());
    }

    @Override
    public String deleteById(Long id) {
        //1.question不存在
        if(questionRepository.findOne(id)==null){
            return "error.delete.question.not.exist.id:" + id;
        }
        questionRepository.delete(id);
        return "success.delete.question.id:" + id;
    }

    @Override
    public QuestionDTO updateIfSolved(QuestionE questionE, Long acceptAnswer) {
        QuestionDO questionDO = questionConvertor.entityToDo(questionE);
        //1.question不存在
        if(questionRepository.findOne(questionDO.getId())==null){
            return new QuestionDTO(null, "error.update.question.accept.answer.not.exist." + questionDO.getId());
        }
        questionDO.setAcceptAnswer(acceptAnswer);
        QuestionDO updateQuestionDO = questionRepository.save(questionDO);
        return new QuestionDTO(questionConvertor.doToEntity(updateQuestionDO),"success.update.question.accept.answer:"+updateQuestionDO);
    }

    @Override
    public QuestionDTO selectById(Long id) {
        QuestionDO questionDO = questionRepository.findOne(id);
        if(questionDO==null){
            return new QuestionDTO(null, "error.select.question.not.exist.id:" + id);
        }
        return new QuestionDTO(questionConvertor.doToEntity(questionDO),"success.select.question.id:"+questionDO);
    }

    @Override
    public List<QuestionDTO> selectByUserId(Long questioner) {
        List<QuestionDTO> selectByQuestioner=new ArrayList<>();
        List<QuestionDO> byQuestioner = questionRepository.findByQuestioner(questioner);
        if(byQuestioner.isEmpty()){
            selectByQuestioner.add(new QuestionDTO(null,"error.select.question.not.exist.questioner"+questioner));
            return selectByQuestioner;
        }
        for (QuestionDO questionDO : byQuestioner
                ) {
            QuestionE questionE=questionConvertor.doToEntity(questionDO);
            selectByQuestioner.add(new QuestionDTO(questionE,"success.select.question.by.questioner:"+questioner));
        }
        return selectByQuestioner;
    }
}
