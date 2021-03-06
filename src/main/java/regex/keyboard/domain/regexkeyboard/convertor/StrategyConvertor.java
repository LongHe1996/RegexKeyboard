package regex.keyboard.domain.regexkeyboard.convertor;

import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexkeyboard.entity.StrategyE;
import regex.keyboard.infra.dataobject.StrategyDO;

/**
 * @Description: strategy convertor.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/29 23:19
 */
@Component
public class StrategyConvertor implements ConvertorI<StrategyDO, StrategyE> {
    @Override
    public StrategyE doToEntity(StrategyDO dataObject) {
        return new StrategyE(dataObject.getId(), dataObject.getStrategyRegex(), dataObject.getStrategyUse(), dataObject.getStrategyType());
    }

    @Override
    public StrategyDO entityToDo(StrategyE entity) {
        return new StrategyDO(entity.getId(), entity.getStrategyRegex(), entity.getStrategyUse(), entity.getStrategyType());
    }
}
