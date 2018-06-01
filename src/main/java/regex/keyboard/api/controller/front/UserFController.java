package regex.keyboard.api.controller.front;

import java.util.HashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import regex.keyboard.api.controller.back.UserBController;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexKeyboard.entity.UserE;

@Controller
public class UserFController {
    @Autowired
    private UserBController userBController;

    @RequestMapping("/dologin")
    public String login(String userName, String drowssap,HashMap<String, Object> map,HttpServletResponse response){
        UserDTO login = userBController.login(userName, drowssap);
        if (!login.getSuccess()){
            map.put("error",login.getMessage());
            return "/index";
        }
        Cookie cookie=new Cookie("LoginUserName",login.getUserE().getUserName());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        return "/home";
    }
    @RequestMapping("/dosignup")
    public String signup(UserE userE,String drowssap2, HashMap<String, Object> map){
        if(userE.getDrowssap()!=drowssap2){
            map.put("error","两次密码输入不一致！");
            return "/signup";
        }
        UserDTO signup = userBController.signup(userE);
        if(!signup.getSuccess()){
            System.out.println(signup.getMessage());
            map.put("error",signup.getMessage());
            return "/signup";
        }
        return "/index";
    }

}
