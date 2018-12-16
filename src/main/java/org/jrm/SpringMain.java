package org.jrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class model for starting up a springboot application. This is essentially generated code
 * which will end up loading DoRecord and SpeedTest as REST endpoints
 * @author Jared R Mallas
 * @version 1.0
 */
@SpringBootApplication
public class SpringMain
{
    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class, args);
    }
}
