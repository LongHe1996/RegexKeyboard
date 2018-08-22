package regex.keyboard.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.CollectionDTO;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexkeyboard.entity.UserE;

@Service
public interface UserServiceV {
    UserDTO login(String userName, String ssapdrow);

    UserDTO logout(UserE userE);

    UserDTO signUp(UserE userE);

    List<OneForAllQuestionDTO> getSomeonesCollection(Long userId);

    UserDTO updateUser(UserE userE);

    String cancelOrCreateCol(Long userId ,Long questionId);
}
