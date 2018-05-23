package regex.keyboard.domain.regexKeyboard.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexKeyboard.entity.AnswerE;
import regex.keyboard.domain.regexKeyboard.entity.QuestionE;
import regex.keyboard.domain.regexKeyboard.entity.UserE;
import regex.keyboard.domain.repository.UserRepository;
import regex.keyboard.domain.repository.AnswerRepository;
import regex.keyboard.infra.dataobject.AnswerDO;
import regex.keyboard.infra.dataobject.QuestionDO;
import regex.keyboard.infra.dataobject.UserDO;

/**
 * @Description: quesrion convertor.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 15:26
 */
@Component
public class QuestionConvertor implements ConvertorI<QuestionDO, QuestionE> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private  UserConvertor userConvertor;
    @Autowired
    private AnswerConvertor answerConvertor;
    @Override
    public QuestionE doToEntity(QuestionDO dataObject) {
        UserDO userDO = userRepository.findOne(dataObject.getQuestioner());
        UserE userE = userConvertor.doToEntity(userDO);
        AnswerDO answerDO = answerRepository.findOne(dataObject.getAcceptAnswer());
        AnswerE answerE = answerConvertor.doToEntity(answerDO);
        return new QuestionE(dataObject.getId(), dataObject.getQuestionId(), dataObject.getQuestionContent(), userE, dataObject.getPutTime(), dataObject.getSolved(), answerE);
    }

    @Override
    public QuestionDO entityToDo(QuestionE entity) {
        return new QuestionDO(entity.getId(), entity.getQuestionId(), entity.getQuestionContent(), entity.getQuestioner().getId(), entity.getPutTime(), entity.getSolved(), entity.getAcceptAnswer().getId());
    }

}
