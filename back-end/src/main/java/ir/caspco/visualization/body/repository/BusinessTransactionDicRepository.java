package ir.caspco.visualization.body.repository;

import ir.caspco.visualization.body.context.domain.BusinessTransactionDic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Repository
public interface BusinessTransactionDicRepository extends CrudRepository<BusinessTransactionDic, Integer> {
}
