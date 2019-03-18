package io.pivotal.pal.tracker;

import io.micrometer.core.instrument.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {


    @Value("${SPRING_DATASOURCE_URL}")
    private String dataSourceUrl;

   // @Value("${VCAP_APPLICATION}")
   // private String vcapApplication;


    @Override
    public void contribute(Info.Builder builder) {
        Map<String,String> map = new HashMap<>();
        map.put("Url",dataSourceUrl);
        builder.withDetail("data base url",map);
    }
}
