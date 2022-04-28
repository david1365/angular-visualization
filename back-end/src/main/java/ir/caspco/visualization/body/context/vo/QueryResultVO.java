package ir.caspco.visualization.body.context.vo;

import ir.caspco.visualization.body.context.model.Column;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Data
@Builder
public class QueryResultVO {
    private Column[] columnNames;
    private List<?> resultList;
}
