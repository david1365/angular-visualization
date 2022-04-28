package ir.caspco.visualization.body.context.vo;

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
public class CurrentUserVO {
    private AccountVO accountVO;
    private String token;
}
