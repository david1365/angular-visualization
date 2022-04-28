package ir.caspco.visualization.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Configuration
@EnableJpaRepositories("ir.caspco.visualization.body.repository")
@EntityScan("ir.caspco.visualization.body.context.domain")
public class JpaConfiguration {
}
