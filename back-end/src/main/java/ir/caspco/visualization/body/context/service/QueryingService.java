package ir.caspco.visualization.body.context.service;

import ir.caspco.visualization.body.context.vo.QueryResultVO;

import java.sql.SQLException;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

public interface QueryingService {
    QueryResultVO query(String queryIn) throws SQLException;
}
