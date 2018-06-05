package regex.keyboard.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.RegexResultDTO;
import regex.keyboard.app.service.RegexServiceV;
import regex.keyboard.domain.util.ReplaceUtil;

@Service
public class RegexServiceVImpl implements RegexServiceV {
    @Autowired
    private ReplaceUtil replaceUtil;

    @Override
    public RegexResultDTO buildRegex(String regexDescribe) {
        String[] split = regexDescribe.split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s = replaceUtil.replaseSelfUtil(split[i]);
            String x = replaceUtil.replaceNTimes(s);
            String m = replaceUtil.replaceLTimes(x);
            result.append(replaceUtil.replasceNMTimes(m));
        }
        return new RegexResultDTO(result.toString(), "替换完成", true);
    }
}
