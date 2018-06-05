package regex.keyboard.api.controller.front;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import regex.keyboard.api.controller.back.LearnMoreBController;
import regex.keyboard.api.dto.OneForAllAnswersDTO;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesE;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesNatureE;

@Controller
public class LearnMoreFController {
    @Autowired
    private LearnMoreBController learnMoreBController;
    @GetMapping("learnmorerules")
    @ResponseBody
    public String  getLearnMoreInfo(Map<String, Object> map){
        List<RegexRulesE> allRegexRules = learnMoreBController.getAllRegexRules();
        List<RegexRulesNatureE> allRegexRulesNature = learnMoreBController.getAllRegexRulesNature();
        map.put("allNatures", allRegexRulesNature);
        map.put("allRules",allRegexRules);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
}
