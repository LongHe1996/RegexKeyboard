package regex.keyboard.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.StrategyDTO;

@Service
public interface StrategyService {
    List<StrategyDTO> selectAllStrategy();
}
