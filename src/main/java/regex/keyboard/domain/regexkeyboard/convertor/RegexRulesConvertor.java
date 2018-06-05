package regex.keyboard.domain.regexkeyboard.convertor;

import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesE;
import regex.keyboard.infra.dataobject.RegexRulesDO;

/**
 * @Description: regex rules convertor.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 15:23
 */
@Component
public class RegexRulesConvertor implements ConvertorI<RegexRulesDO, RegexRulesE> {
    @Override
    public RegexRulesE doToEntity(RegexRulesDO dataObject) {
        return new RegexRulesE(dataObject.getId(), dataObject.getRuleContent(), dataObject.getRuleDescribe(), dataObject.getRuleNature());
    }

    @Override
    public RegexRulesDO entityToDo(RegexRulesE entity) {
        return new RegexRulesDO(entity.getId(), entity.getRuleContent(), entity.getRuleDescribe(), entity.getRuleNature());
    }
}
