package regex.keyboard.api.controller.front;

import java.util.Map;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import regex.keyboard.api.controller.back.RegexBController;
import regex.keyboard.api.dto.RegexResultDTO;

@Controller
public class RegexFController {
    @Autowired
    private RegexBController regexBController;

    @PostMapping("buildRegex")
    @ResponseBody
    public String keyboard(String str, Map<String, Object> map) {
        System.out.println(str);
        RegexResultDTO regexByStr = regexBController.getRegexByStr(str);
        System.out.println(regexByStr.getRegexStr());
        String regexStr = regexByStr.getRegexStr().replace(" ", "");
        System.out.println(regexStr);
        map.put("regex", regexStr);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();

    }
}
