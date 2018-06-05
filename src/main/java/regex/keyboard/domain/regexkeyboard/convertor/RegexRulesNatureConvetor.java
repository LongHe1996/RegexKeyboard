package regex.keyboard.domain.regexkeyboard.convertor;

import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexkeyboard.entity.RegexRulesNatureE;
import regex.keyboard.infra.dataobject.RegexRulesNatureDO;

/**
 * @Description: regex rules nature convertor.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/29 23:21
 */
@Component
public class RegexRulesNatureConvetor implements ConvertorI<RegexRulesNatureDO, RegexRulesNatureE> {
    @Override
    public RegexRulesNatureE doToEntity(RegexRulesNatureDO dataObject) {
        return new RegexRulesNatureE(dataObject.getId(), dataObject.getNature());
    }

    @Override
    public RegexRulesNatureDO entityToDo(RegexRulesNatureE entity) {
        return new RegexRulesNatureDO(entity.getId(), entity.getNature());
    }
}
