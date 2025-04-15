package com.discobird.discobird;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EbirdApiConfig {
    private final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public String getApiToken() {
        return dotenv.get("EBIRD_API_TOKEN");
    }

    public String getApiUrl() {
        return dotenv.get("EBIRD_API_URL", "https://api.ebird.org/v2/ref/taxonomy/ebird?fmt=json&locale=ko");
    }
}
