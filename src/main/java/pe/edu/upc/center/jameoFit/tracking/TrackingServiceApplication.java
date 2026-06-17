package pe.edu.upc.center.jameoFit.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "pe.edu.upc.center.jameoFit")
@EnableJpaAuditing
public class TrackingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackingServiceApplication.class, args);
    }
}
