package ir.caspco.visualization.body.service;

import ir.caspco.visualization.body.components.SqlUtil;
import ir.caspco.visualization.body.context.model.Column;
import ir.caspco.visualization.body.context.service.QueryingService;
import ir.caspco.visualization.body.context.vo.QueryResultVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Service
@Component
public class QueryingServiceImpl implements QueryingService {

    private final EntityManager entityManager;
    private final SqlUtil sqlUtil;

    public QueryingServiceImpl(EntityManager entityManager, SqlUtil sqlUtil) {
        this.entityManager = entityManager;
        this.sqlUtil = sqlUtil;
    }

    @Override
    public QueryResultVO query(String queryString) throws SQLException {
        List<?> resultList = entityManager.createNativeQuery(queryString).getResultList();
        Column[] columnNames = sqlUtil.columnNames(entityManager, queryString);

        return QueryResultVO.builder()
                .columnNames(columnNames)
                .resultList(resultList)
                .build();
    }
}
