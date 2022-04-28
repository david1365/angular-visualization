package ir.caspco.visualization.body.service;

import com.google.gson.Gson;
import ir.caspco.visualization.body.context.domain.BusinessTransactionFact;
import ir.caspco.visualization.body.context.service.BusinessTransactionFactService;
import ir.caspco.visualization.body.repository.BusinessTransactionFactRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Service
public class BusinessTransactionFactServiceImpl implements BusinessTransactionFactService {

    private final BusinessTransactionFactRepository businessTransactionFactRepository;
    private final EntityManager entityManager;
    private final Gson gson;

    public BusinessTransactionFactServiceImpl(BusinessTransactionFactRepository businessTransactionFactRepository,
                                              EntityManager entityManager,
                                              Gson gson) {

        this.businessTransactionFactRepository = businessTransactionFactRepository;
        this.entityManager = entityManager;
        this.gson = gson;
    }

    @Override
    public Optional<BusinessTransactionFact> findById(Long id) {
        return businessTransactionFactRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<BusinessTransactionFact> findAll() {
        return null;
    }

    @Override
    public Iterable<BusinessTransactionFact> findAllById(Iterable<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
