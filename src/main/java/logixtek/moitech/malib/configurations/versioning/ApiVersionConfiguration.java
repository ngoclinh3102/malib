package logixtek.moitech.malib.configurations.versioning;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ApiVersionConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ApiVersionRegistrations apiVersionWebMvcRegistrations() {
        return new ApiVersionRegistrations();
    }
}