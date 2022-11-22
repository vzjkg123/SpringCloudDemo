package property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties("jwt")
public class JwtProperties {
    private String secretKey;
}
