package regex.keyboard.app.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.CollectionDTO;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.api.dto.QuestionDTO;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.app.service.UserServiceV;
import regex.keyboard.domain.regexkeyboard.convertor.QuestionConvertor;
import regex.keyboard.domain.regexkeyboard.entity.CollectionE;
import regex.keyboard.domain.regexkeyboard.entity.QuestionE;
import regex.keyboard.domain.regexkeyboard.entity.UserE;
import regex.keyboard.domain.service.CollectionService;
import regex.keyboard.domain.service.UserService;

@Service
public class UserServiceVImpl implements UserServiceV {
    @Autowired
    private UserService userService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private QuestionConvertor questionConvertor;
    @Override
    public UserDTO login(String userName, String drowssap) {
        UserDTO userDTO = userService.selectByUserName(userName);
        if (userDTO.getSuccess()) {
            if (!drowssap.equals(userDTO.getUserE().getDrowssap())) {
                userDTO.setSuccess(false);
                userDTO.setMessage("用户名与密码不匹配！");
            }
            return userDTO;
        }
        userDTO.setMessage("该用户尚未注册！");
        return userDTO;
    }

    @Override
    public UserDTO logout(UserE userE) {
        return userService.deleteById(userE.getId());
    }

    @Override
    public UserDTO signUp(UserE userE) {
        if (userService.selectByUserName(userE.getUserName()).getSuccess()) {
            return new UserDTO(null, "该用户名已被注册", false);
        }
        if (userService.selectByEmail(userE.getEmail()).getSuccess()) {
            return new UserDTO(null, "该邮箱已被注册", false);
        }
        userE.setRegisterTime(new Date());
        return userService.create(userE);
    }

    @Override
    public List<OneForAllQuestionDTO> getSomeonesCollection(Long userId) {
        List<OneForAllQuestionDTO> allQuestionDTOS=new ArrayList<>();
        List<CollectionDTO> collectionDTOList = collectionService.selectByCollector(userId);
        for (CollectionDTO collectionDTO:collectionDTOList
             ) {
            CollectionE collectionE = collectionDTO.getCollectionE();
            //格式化时间
            DateFormat bf = new SimpleDateFormat("HH:mm MM-dd yyyy");
            String formatTime = bf.format(collectionE.getCollectionTime());
            QuestionE question = collectionE.getQuestion();
            OneForAllQuestionDTO oneForAllQuestionDTO = questionConvertor.DtoToForView(new QuestionDTO(question, "", true));
            oneForAllQuestionDTO.setPutTime(formatTime);
            oneForAllQuestionDTO.setId(collectionE.getQuestion().getId());
            allQuestionDTOS.add(oneForAllQuestionDTO);
        }
        return allQuestionDTOS;
    }

    @Override
    public UserDTO updateUser(UserE userE) {
        if (userE.getEmail()!=null && userService.selectByEmail(userE.getEmail()).getSuccess()) {
            return new UserDTO(null, "该邮箱已被注册", false);
        }
        UserDTO userDTO = userService.selectById(userE.getId());

        UserE userE1 = userDTO.getUserE();
        if(userE.getEmail()==null){
            userE.setEmail(userE1.getEmail());
        }
        userE.setRegisterTime(userE1.getRegisterTime());
        userE.setUserName(userE1.getUserName());
        return userService.update(userE);
    }

    @Override
    public String cancelOrCreateCol(Long userId, Long questionId) {
        CollectionDTO collectionDTO = collectionService.selectByCollectorAndQuestion(userId, questionId);
        if(collectionDTO.getSuccess()){
            System.out.println("删除"+collectionDTO.getCollectionE().getId());
            collectionService.deleteById(collectionDTO.getCollectionE().getId());
            return "已取消收藏";
        }else {
            UserE userE=new UserE();
            userE.setId(userId);
            QuestionE questionE=new QuestionE();
            questionE.setId(questionId);
            collectionService.create(new CollectionE(null,questionE,userE,new Date()));
            return  "已收藏";
        }
    }
}
