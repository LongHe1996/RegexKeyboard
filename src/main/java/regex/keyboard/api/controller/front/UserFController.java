package regex.keyboard.api.controller.front;

import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import regex.keyboard.api.controller.back.UserBController;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexkeyboard.entity.UserE;

@Controller
public class UserFController {
    private static final String ERROR = "errot";
    @Autowired
    private UserBController userBController;

    @RequestMapping("/dologin")
    public String login(String userName, String drowssap, Map<String, Object> map, HttpServletResponse response) {
        UserDTO login = userBController.login(userName, drowssap);
        if (!login.getSuccess()) {
            map.put(ERROR, login.getMessage());
            return "/index";
        }
        Cookie cookie = new Cookie("LoginUserName", login.getUserE().getUserName());
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return "/home";
    }

    @RequestMapping("/dosignup")
    public String signup(UserE userE, String drowssap2, Map<String, Object> map) {
        if (userE.getDrowssap() != drowssap2) {
            map.put(ERROR, "两次密码输入不一致！");
            return "/signup";
        }
        UserDTO signup = userBController.signup(userE);
        if (!signup.getSuccess()) {
            map.put(ERROR, signup.getMessage());
            return "/signup";
        }
        return "/index";
    }

}
