package ir.caspco.visualization.body.controller;

import ir.caspco.visualization.body.context.service.QueryingService;
import ir.caspco.visualization.body.context.vo.QueryResultVO;
import ir.caspco.visualization.body.context.vo.QueryVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.sql.SQLException;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */


@RestController
@RequestMapping("/querying")
public class QueryingController {

    private final QueryingService queryingService;

    public QueryingController(QueryingService queryingService) {
        this.queryingService = queryingService;
    }

    @PostMapping("/query")
    public QueryResultVO query(@NotNull @RequestBody QueryVO queryVO) throws SQLException {
        return queryingService.query(queryVO.getQuery());
    }
}
