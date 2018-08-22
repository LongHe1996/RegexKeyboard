package regex.keyboard.api.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.CollectionDTO;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.app.service.UserServiceV;

@RestController
public class CollectionBController {
    @Autowired
    private UserServiceV userServiceV;

    public List<OneForAllQuestionDTO> getSomeonesCollection(Long userId) {
       return  userServiceV.getSomeonesCollection(userId);
    }
    public String cancelOrCreateCol(Long userId,Long questionId){
        return userServiceV.cancelOrCreateCol(userId,questionId);
    }
}
