package regex.keyboard.api.controller.back;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexKeyboard.entity.UserE;
import regex.keyboard.domain.service.UserService;
import regex.keyboard.domain.service.impl.UserServiceImpl;

@RestController
public class UserBController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserByUserId")
    public UserDTO getAllUsers() {
        return userService.selectByUserId(1L);
    }

    @RequestMapping("/createUser")
    public UserDTO saveTes() {
        return userService.create(new UserE(null, 4L, "sss", "DSFA", new Date()));
    }

    @RequestMapping("/deleteById")
    public String ddTes() {
        return userService.deleteById(1L);
    }

    @RequestMapping("/updateUser")
    public UserDTO uod() {
        return userService.update(new UserE(3L, 4L, "sss", "DSFA", new Date()));
    }
}
