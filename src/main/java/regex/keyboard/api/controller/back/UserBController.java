package regex.keyboard.api.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.app.service.UserServiceV;
import regex.keyboard.domain.regexkeyboard.entity.UserE;

@RestController
public class UserBController {
    @Autowired
    private UserServiceV userServiceV;

    public UserDTO login(String userName, String drowssap) {
        return userServiceV.login(userName, drowssap);
    }

    public UserDTO signup(UserE userE) {
        return userServiceV.signUp(userE);
    }
}
