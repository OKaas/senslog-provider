package cz.hsrs.maplog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by OK on 6/9/2017.
 */
@SpringBootApplication
@PropertySource("senslog-app.properties")
@ComponentScan("cz.hsrs.maplog")
@EntityScan("cz.hsrs.maplog.db.entity")
@EnableJpaRepositories("cz.hsrs.maplog.db")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


