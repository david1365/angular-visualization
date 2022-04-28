package ir.caspco.visualization.body.controller;

import ir.caspco.visualization.body.context.exception.BusinessTransactionFactNotFoundException;
import ir.caspco.visualization.body.context.domain.BusinessTransactionFact;
import ir.caspco.visualization.body.context.service.BusinessTransactionFactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */


@RestController
public class BusinessTransactionFactController {

    private final BusinessTransactionFactService businessTransactionFactService;

    public BusinessTransactionFactController(BusinessTransactionFactService businessTransactionFactService) {
        this.businessTransactionFactService = businessTransactionFactService;
    }

    @GetMapping("/fact/{id}")
    BusinessTransactionFact one(@PathVariable Long id) {

        return businessTransactionFactService.findById(id)
                .orElseThrow(() -> new BusinessTransactionFactNotFoundException());
    }
}
