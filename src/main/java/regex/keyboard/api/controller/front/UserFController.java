package regex.keyboard.api.controller.front;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import regex.keyboard.api.controller.back.UserBController;
import regex.keyboard.infra.dataobject.UserDO;

@Controller
public class UserFController {
    @Autowired
    private UserBController userBController;

}
