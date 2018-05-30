package regex.keyboard.app.service;

import javax.security.auth.login.LoginContext;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexKeyboard.entity.UserE;
@Service
public interface UserServiceV {
    UserDTO login(String userName, String ssapdrow);
    UserDTO logout(UserE userE);
    UserDTO signUp(UserE userE);
}
