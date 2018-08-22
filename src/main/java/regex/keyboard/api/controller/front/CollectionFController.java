package regex.keyboard.api.controller.front;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import regex.keyboard.api.controller.back.CollectionBController;
import regex.keyboard.api.dto.CollectionDTO;
import regex.keyboard.api.dto.OneForAllAnswersDTO;
import regex.keyboard.api.dto.OneForAllQuestionDTO;
import regex.keyboard.domain.regexkeyboard.entity.CollectionE;

@Controller
public class CollectionFController {
    @Autowired
    private CollectionBController collectionBController;
    @GetMapping("someonesCollection")
    @ResponseBody
    public String getMyCol(Long userId, Map<String, Object> map) {
        List<OneForAllQuestionDTO> someonesCollection = collectionBController.getSomeonesCollection(userId);
        if(someonesCollection==null||someonesCollection.isEmpty()){
            map.put("error","尚未有收藏哦！");
        }else {
            map.put("error", "0");
            map.put("collection",someonesCollection);
        }
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @GetMapping("colop")
    @ResponseBody
    public String cancelCol(String uqstr,Map<String, Object> map){
        String user = uqstr.substring(0, uqstr.indexOf("a"));
        Long userId=new Long(user);
        String question = uqstr.substring(uqstr.indexOf("a") + 1);
        Long questionId=new Long(question);
        System.out.println(userId+",q:"+questionId);
        String s = collectionBController.cancelOrCreateCol(userId, questionId);
        map.put("msg",s);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
}
