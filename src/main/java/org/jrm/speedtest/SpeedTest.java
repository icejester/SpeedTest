package org.jrm.speedtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeedTest
{
    @RequestMapping("/SpeedTest")
    public String index()
    {
        return "Greetings from Spring Boot!";
    }
}
