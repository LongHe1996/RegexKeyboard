package regex.keyboard.app.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.app.service.UserServiceV;
import regex.keyboard.domain.regexKeyboard.entity.UserE;
import regex.keyboard.domain.service.UserService;
@Service
public class UserServiceVImpl implements UserServiceV {
    @Autowired
    private UserService userService;
    @Override
    public UserDTO login(String userName, String drowssap) {
        UserDTO userDTO = userService.selectByUserName(userName);
        if(userDTO.getSuccess()){
            if (!drowssap.equals(userDTO.getUserE().getDrowssap())){
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
        if(userService.selectByUserName(userE.getUserName()).getSuccess()){
            return  new UserDTO(null,"该用户名已被注册",false);
        }
        if(userService.selectByEmail(userE.getEmail()).getSuccess()){
            return new UserDTO(null,"该邮箱已被注册",false);
        }
        userE.setRegisterTime(new Date());
        UserDTO userDTO = userService.create(userE);
        return userDTO;
    }
}
