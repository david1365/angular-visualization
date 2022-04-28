package ir.caspco.visualization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("ir.caspco")
@PropertySource(ignoreResourceNotFound = true, value = "file:override.properties")
public class VisualizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualizationApplication.class, args);
    }

}
