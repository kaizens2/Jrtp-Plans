package in.kaizens.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "plan-api")
@Component
public class AppProperties {
    private Map<String,String> message = new HashMap<>();
}
