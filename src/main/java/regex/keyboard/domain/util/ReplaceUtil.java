package regex.keyboard.domain.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.StrategyDTO;
import regex.keyboard.domain.service.StrategyService;

@Service
public class ReplaceUtil {
    @Autowired
    private StrategyService strategyService;

    public String replaseSelfUtil(String str) {
        List<StrategyDTO> strategyDTOS = strategyService.selectAllSelf();
        for (StrategyDTO dto : strategyDTOS
                ) {
            String regex = dto.getStrategyE().getStrategyRegex();
            String replaceStr = dto.getStrategyE().getStrategyUse();
            str = str.replaceAll(regex, replaceStr);
        }
        return str;
    }

    public String replaceNTimes(String str) {
        List<StrategyDTO> strategyDTOS = strategyService.selectDeterminedNTimes();
        for (StrategyDTO dto : strategyDTOS
                ) {
            String regex1 = dto.getStrategyE().getStrategyRegex();
            String regex2 = dto.getStrategyE().getStrategyUse();
            str = str.replaceAll(regex1, "{");
            str = str.replaceAll(regex2, "}");
        }
        return str;
    }

    public String replaceLTimes(String str) {
        List<StrategyDTO> strategyDTOS = strategyService.selectLeastNTimes();
        for (StrategyDTO dto : strategyDTOS
                ) {
            String regex1 = dto.getStrategyE().getStrategyRegex();
            String regex2 = dto.getStrategyE().getStrategyUse();
            str = str.replaceAll(regex1, "{");
            str = str.replaceAll(regex2, "\\,}");
        }
        return str;
    }

    public String replasceNMTimes(String str) {
        List<StrategyDTO> strategyDTOS = strategyService.selectNtoMTimes();
        for (StrategyDTO dto : strategyDTOS
                ) {
            String regex1 = dto.getStrategyE().getStrategyRegex();
            String regex2 = dto.getStrategyE().getStrategyUse();
            str = str.replaceAll(regex1, "{");
            str = str.replaceAll(regex2, "}");

        }
        return str;
    }
}
