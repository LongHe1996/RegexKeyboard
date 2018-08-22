package regex.keyboard.api.controller.front;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/29 17:24
 */
@Controller
public class HtmlDefaultController {
    @GetMapping("/")
    public String getIndexDefault() {
        return "/index";
    }

    @GetMapping("/index")
    public String getIndex() {
        return "/index";
    }

    @GetMapping("home")
    public String getHomeDefault() {
        return "/home";
    }

    @GetMapping("readme")
    public String getReadMeDefault() {
        return "/readme";
    }

    @GetMapping("learnmore")
    public String getLearnMoreDefault() {
        return "/learnmore";
    }

    @GetMapping("keyboard")
    public String getKeyboardDefault() {
        return "/keyboard";
    }

    @GetMapping("qanda")
    public String getQAndADefault() {

        return "/qanda";
    }

    @GetMapping("test")
    public String getTestDefault() {
        return "/test";
    }

    @GetMapping("profile")
    public String getProfileDefault() {
        return "/profile";
    }

    @GetMapping("myanswer")
    public String getMyAnswerDefault() {
        return "/myanswer";
    }

    @GetMapping("myquestion")
    public String getMyQuestionDefault() {
        return "/myquestion";
    }

    @GetMapping("signup")
    public String getSignUpDefault() {
        return "/signup";
    }

    @GetMapping("collection")
    public String getCollection() {
        return "/collection";
    }

    @RequestMapping("/hello")
    public String helloHtml(Map<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "/demo1";
    }
}
