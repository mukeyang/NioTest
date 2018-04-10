package com.yang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CS on 2018/4/9.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    @Autowired
    @Qualifier("repository")
    private SpittleRepository repository;
@RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
    model.addAttribute("list",repository.findSpittles(Long.MAX_VALUE, 20));
        return "spittle";
    }
}
