package regex.keyboard.app.service;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexkeyboard.entity.UserE;

@Service
public interface UserServiceV {
    UserDTO login(String userName, String ssapdrow);

    UserDTO logout(UserE userE);

    UserDTO signUp(UserE userE);
}
