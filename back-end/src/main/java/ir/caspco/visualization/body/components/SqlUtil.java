package ir.caspco.visualization.body.components;

import ir.caspco.visualization.body.context.model.Column;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Component
public class SqlUtil {
    private Messages messages;

    public SqlUtil(Messages messages) {
        this.messages = messages;
    }

    public Connection connection(EntityManager entityManager) {
        return entityManager.unwrap(SessionImpl.class).connection();
    }

    public ResultSetMetaData metaData(Connection connection, String queryString) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(queryString);

        return ps.getMetaData();
    }

    public Column[] columnNames(EntityManager entityManager, String queryString) throws SQLException {
        Connection connection = connection(entityManager);
        ResultSetMetaData resultSetMetaData = metaData(connection, queryString);

        int columnCount = resultSetMetaData.getColumnCount();
        Column[] columnNames = new Column[columnCount];
        for (int index = 1; index <= columnCount; index++) {
            String name = resultSetMetaData.getColumnName(index);
            columnNames[index - 1] = Column.builder()
                    .header(messages.getMessage(name))
                    .field(name)
                    .build();
        }

        return columnNames;
    }
}
