package com.example.corejava8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class CoreJava8Application {

    public static void main(String[] args) {
//        SpringApplication.run(CoreJava8Application.class, args);
        try{
            ConfigurableApplicationContext application = SpringApplication.run(CoreJava8Application.class, args);
            Environment env = application.getEnvironment();
            String port = env.getProperty("server.port");
            log.info("\n=========== (♥◠‿◠)ﾉﾞ  >>>>>>>> 启动成功 <<<<<<<<   ლ(´ `)ლﾞ ===========\n" +
                    "Application is running! Access URLs:\n" +
                    "Local:       http://localhost:" + port + "/doc.html\n" +
                    "=======================================================================");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
