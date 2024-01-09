package com.broadcom.observabilitydemo.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manoj Ramakrishnan (rmanoj@vmware.com).
 * @since 1/4/24 3:31 PM
 */
@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello World";
    }


}
