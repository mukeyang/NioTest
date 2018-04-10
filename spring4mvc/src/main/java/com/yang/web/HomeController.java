package com.yang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CS on 2018/4/3.
 */
@Controller
@RequestMapping("/")
public class HomeController {


    @RequestMapping(method = RequestMethod.GET)
    public String test() {
//        model.addAttribute("spittleList",repository.findSpittles(Long.MAX_VALUE, 20));
        return "home";
    }
//    @RequestMapping(method = RequestMethod.GET)
//    public String test(Map model) {
//        model.put("spittleList",repository.findSpittles(Long.MAX_VALUE, 20));
//        return "home";
//    }
//    @RequestMapping(method = RequestMethod.GET)
//    public List<spittle> test() {
//        return repository.findSpittles(Long.MAX_VALUE,20);
//    }
}
