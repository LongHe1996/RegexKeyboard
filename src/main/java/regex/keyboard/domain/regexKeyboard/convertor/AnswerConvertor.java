package regex.keyboard.domain.regexKeyboard.convertor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import regex.keyboard.api.dto.AnswerDTO;
import regex.keyboard.api.dto.OneForAllAnswersDTO;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.domain.regexKeyboard.entity.AnswerE;
import regex.keyboard.domain.regexKeyboard.entity.QuestionE;
import regex.keyboard.domain.regexKeyboard.entity.UserE;
import regex.keyboard.domain.repository.QuestionRepository;
import regex.keyboard.domain.repository.UserRepository;
import regex.keyboard.infra.dataobject.AnswerDO;
import regex.keyboard.infra.dataobject.QuestionDO;
import regex.keyboard.infra.dataobject.UserDO;

/**
 * @Description: answer convertor.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 20:07
 */
@Component
public class AnswerConvertor implements ConvertorI<AnswerDO, AnswerE> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionConvertor questionConvertor;
    @Autowired
    private UserConvertor userConvertor;

    @Override
    public AnswerE doToEntity(AnswerDO dataObject) {
        UserDO userDO = userRepository.findOne(dataObject.getRespondent());
        UserE userE = userConvertor.doToEntity(userDO);
        QuestionDO questionDO = questionRepository.findOne(dataObject.getQuestionId());
        QuestionE questionE = questionConvertor.doToEntity(questionDO);
        return new AnswerE(dataObject.getId(),dataObject.getAnswerContent(), userE, questionE, dataObject.getPutTime(), dataObject.getAccepted());
    }

    @Override
    public AnswerDO entityToDo(AnswerE entity) {
        return new AnswerDO(entity.getId(), entity.getAnswerContent(), entity.getRespondent().getId(), entity.getQuestion().getId(), entity.getPutTime(), entity.getAccepted());
    }
    public OneForAllAnswersDTO DtoToForView(AnswerDTO dto){
        AnswerE entity = dto.getAnswerE();
        //格式化时间
        DateFormat bf = new SimpleDateFormat("HH:mm MM-dd yyyy");
        String formatTime = bf.format(entity.getPutTime());
        return new OneForAllAnswersDTO(entity.getId(),entity.getAnswerContent(),entity.getRespondent().getNickName(),entity.getQuestion().getId(),formatTime,entity.getAccepted());
    }

}
