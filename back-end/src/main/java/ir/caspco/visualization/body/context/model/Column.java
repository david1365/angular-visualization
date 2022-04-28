package ir.caspco.visualization.body.context.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Data
@Builder
public class Column {
    private String header;
    private String field;
}
