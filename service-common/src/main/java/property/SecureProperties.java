package property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全参数绑定类
 */
@Data
@ConfigurationProperties("secure")
public class SecureProperties {

    /**
     * 安全类型：jwt, oauth2, none
     */
    private String type;

    /**
     * secret key
     */
    private String secretKey;

    /**
     * AES密码
     */
    private String aesPassword;

    /**
     * AES 盐
     */
    private String aesSalt;

    /**
     * 密钥库密码
     */
    private String keystorePassword;

}
