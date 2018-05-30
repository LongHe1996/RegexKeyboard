package regex.keyboard.domain.service;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexKeyboard.entity.UserE;

@Service
public interface UserService {
    UserDTO create(UserE userE);
    UserDTO deleteById(Long id);
    UserDTO update(UserE userE);
    UserDTO selectById(Long id);
    UserDTO selectByUserName(String userName);
    UserDTO selectByEmail(String email);
    UserDTO selectByUserNameAndDrowssap(String userName,String drowssap);
}
