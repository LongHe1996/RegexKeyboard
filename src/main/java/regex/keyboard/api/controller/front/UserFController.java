package regex.keyboard.api.controller.front;

import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import regex.keyboard.api.controller.back.UserBController;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexkeyboard.entity.UserE;

@Controller
public class UserFController {
    private static final String ERROR = "error";
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
        Cookie cookie2 = new Cookie("LoginUserId", login.getUserE().getId().toString());
        Cookie cookie3 = new Cookie("LoginNickName", login.getUserE().getNickName());
        Cookie cookie4 = new Cookie("LoginEmail", login.getUserE().getEmail());
        Cookie cookie5 = new Cookie("LoginBio", login.getUserE().getBio());
        cookie.setMaxAge(60 * 60);
        cookie2.setMaxAge(60 * 60);
        cookie3.setMaxAge(60 * 60);
        cookie4.setMaxAge(60 * 60);
        cookie5.setMaxAge(60 * 60);
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
        response.addCookie(cookie5);
        return "/home";
    }

    @RequestMapping("/dosignup")
    public String signup(UserE userE, String drowssap2, Map<String, Object> map) {
        if (!userE.getDrowssap().equals(drowssap2)) {
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

    @RequestMapping("/updateuser")
    public String updateUser(UserE userE, String pwd1, String pwd2, Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(userE);
        UserDTO login = userBController.login(userE.getUserName(), pwd1);
        if (login.getUserE().getEmail().equals(userE.getEmail())) {
            userE.setEmail(null);
        }
        if (!login.getSuccess()) {
            System.out.println("error");
            map.put(ERROR, "原密码错误");
            return "profile";
        }
        UserDTO userDTO = userBController.updateUser(userE, pwd2);
        if (!userDTO.getSuccess()) {
            map.put(ERROR, userDTO.getMessage());
            return "profile";
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookieold : cookies) {
            cookieold.setMaxAge(0);
            response.addCookie(cookieold);

        }
        Cookie cookie = new Cookie("LoginUserName", userDTO.getUserE().getUserName());
        Cookie cookie2 = new Cookie("LoginUserId", userDTO.getUserE().getId().toString());
        Cookie cookie3 = new Cookie("LoginNickName", userDTO.getUserE().getNickName());
        Cookie cookie4 = new Cookie("LoginEmail", userDTO.getUserE().getEmail());
        Cookie cookie5 = new Cookie("LoginBio", userDTO.getUserE().getBio());
        cookie.setMaxAge(60 * 60);
        cookie2.setMaxAge(60 * 60);
        cookie3.setMaxAge(60 * 60);
        cookie4.setMaxAge(60 * 60);
        cookie5.setMaxAge(60 * 60);
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
        response.addCookie(cookie5);
        return "profile";
    }

}
