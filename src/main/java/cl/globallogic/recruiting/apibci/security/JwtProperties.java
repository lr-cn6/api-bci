package cl.globallogic.recruiting.apibci.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    final static String TOKEN_PREFIX = "Bearer ";

    private String secret;

    private long exp;

    public String getSecret() {
        return secret;
    }

    public long getExp() {
        return exp;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }
}
