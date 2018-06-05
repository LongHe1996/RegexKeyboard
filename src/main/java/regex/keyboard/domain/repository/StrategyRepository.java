package regex.keyboard.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import regex.keyboard.infra.dataobject.StrategyDO;

@Repository
public interface StrategyRepository extends JpaRepository<StrategyDO, Long> {
    List<StrategyDO> findByStrategyType(Long stategyType);
}
