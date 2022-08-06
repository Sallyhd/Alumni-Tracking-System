package miu.edu.AlumniTrackingSystem.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("storage")
public class StorageProperties {
    private static String location = "uploaded-files";

    public static String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

