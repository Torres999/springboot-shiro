package com.torres999.sprintboot.shiro.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author t9
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("hello", "T9!");
        return modelAndView;
    }

    @RequestMapping("/403")
    public String t9Error() {
        return "403";
    }
}
