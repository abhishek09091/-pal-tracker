package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String PORT;
    private String MEMORY_LIMIT;
    private String CF_INSTANCE_INDEX;
    private String CF_INSTANCE_ADDR;

    public EnvController(@Value("${cf.instance.index.port:NOT SET}") String port,
                         @Value("${cf.instance.index.port.memory_limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index.cf_instance_index:NOT SET}") String cfInstanceIndex,
                         @Value("${cf.instance.index.cf_instance_addr:NOT SET}") String cfInstanceAddr){

        this.PORT = port;
        this.MEMORY_LIMIT = memoryLimit;
        this.CF_INSTANCE_INDEX = cfInstanceIndex;
        this.CF_INSTANCE_ADDR = cfInstanceAddr;

    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){

        Map<String,String> envMap = new HashMap<>();
        envMap.put("PORT",PORT);
        envMap.put("MEMORY_LIMIT",MEMORY_LIMIT);
        envMap.put("CF_INSTANCE_INDEX",CF_INSTANCE_INDEX);
        envMap.put("CF_INSTANCE_ADDR",CF_INSTANCE_ADDR);

        return envMap;
    }

}
