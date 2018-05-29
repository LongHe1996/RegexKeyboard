package regex.keyboard.domain.regexKeyboard.convertor;

import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexKeyboard.entity.RegexE;
import regex.keyboard.infra.dataobject.RegexDO;

/**
 * @Description:   regex convertor.
 * @Author:    Eugen
 * @Mail:    longhe1996@foxmail.com
 * @CreateDate:     2018/5/21 15:24
*/
@Component
public class RegexConvertor implements ConvertorI<RegexDO,RegexE> {

    @Override
    public RegexE doToEntity(RegexDO dataObject) {
        return new RegexE(dataObject.getId(),dataObject.getRegexContent(),dataObject.getRegexDescribe());
    }

    @Override
    public RegexDO entityToDo(RegexE entity) {
        return new RegexDO(entity.getId(),entity.getRegexContent(),entity.getRegexDescribe());
    }
}
