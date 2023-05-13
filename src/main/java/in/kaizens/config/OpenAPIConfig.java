package in.kaizens.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI().info(new Info().title("PLAN-API").description("Create Project for Different types of plan with category").version("v1").contact(new Contact().name("Ronak chaudhary").email("chaudharyronak291@gmail.com")));
    }
}
