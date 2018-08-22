package regex.keyboard.domain.regexkeyboard.convertor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.domain.regexkeyboard.entity.AnswerE;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;
import regex.keyboard.domain.regexkeyboard.entity.UserE;
import regex.keyboard.domain.repository.AnswerRepository;
import regex.keyboard.domain.repository.UserRepository;
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
    private UserConvertor userConvertor;
    @Autowired
    private AnswerConvertor answerConvertor;

    @Override
    public QuestionE doToEntity(QuestionDO dataObject) {
        UserDO userDO = userRepository.findOne(dataObject.getQuestioner());
        System.out.println("before finduser"+userDO);
        UserE userE = userConvertor.doToEntity(userDO);
        System.out.println("after finduser");
        if (dataObject.getAcceptAnswer() == null) {
            return new QuestionE(dataObject.getId(), dataObject.getQuestionTitle(), dataObject.getQuestionContent(), userE, dataObject.getPutTime(), dataObject.getSolved(), null);
        }
        System.out.println("before findans"+dataObject);
        AnswerDO answerDO = answerRepository.findOne(dataObject.getAcceptAnswer());
        AnswerE answerE = answerConvertor.doToEntity(answerDO);

        return new QuestionE(dataObject.getId(), dataObject.getQuestionTitle(), dataObject.getQuestionContent(), userE, dataObject.getPutTime(), dataObject.getSolved(), answerE);
    }

    @Override
    public QuestionDO entityToDo(QuestionE entity) {
        if (entity.getAcceptAnswer() == null) {
            return new QuestionDO(entity.getId(), entity.getQuestionTitle(), entity.getQuestionContent(), entity.getQuestioner().getId(), entity.getPutTime(), entity.getSolved(), null);

        }
        return new QuestionDO(entity.getId(), entity.getQuestionTitle(), entity.getQuestionContent(), entity.getQuestioner().getId(), entity.getPutTime(), entity.getSolved(), entity.getAcceptAnswer().getId());
    }

    public OneForAllQuestionDTO DtoToForView(QuestionDTO dto) {

        QuestionE entity = dto.getQuestionE();
        //格式化时间
        DateFormat bf = new SimpleDateFormat("HH:mm MM-dd yyyy");
        String formatTime = bf.format(entity.getPutTime());
        //获取答案个数
        List<AnswerDO> byQuestionId = answerRepository.findByQuestionId(entity.getId());
        Integer answerNum = byQuestionId.size();
        return new OneForAllQuestionDTO(entity.getId(), entity.getQuestionTitle(), entity.getQuestionContent(), entity.getQuestioner(), formatTime, entity.getSolved(), answerNum);

    }

}
