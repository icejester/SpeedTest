package org.jrm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(SpringMain.class);

    public static void main(String[] args)
    {
        logger.trace("Trace message");
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
        SpringApplication.run(SpringMain.class, args);
    }
}
