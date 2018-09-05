package com.torres999.sprintboot.shiro.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author t9
 */
@RestController
public class TestController {

    @GetMapping("/hi")
    public String findList(Integer id) throws Exception {
        System.out.println("Begin ........");
        System.out.println(LocalDate.now() + " " + LocalTime.now().toString());
        System.out.println("End .......");

        return "Hello World!";
    }
}
