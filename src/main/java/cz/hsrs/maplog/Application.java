package cz.hsrs.maplog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

/**
 * Created by OK on 6/9/2017.
 */
@SpringBootApplication
@ComponentScan("cz.hsrs.maplog")
@EntityScan("cz.hsrs.maplog.db.entity")
// TODO probably not necessary
@EnableJpaRepositories("cz.hsrs.maplog.db")
@PropertySource("senslog-app.properties")
public class Application {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UCT"));
        SpringApplication.run(Application.class, args);
    }
}


