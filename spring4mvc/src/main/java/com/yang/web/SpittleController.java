package com.yang.web;

import com.yang.data.spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by CS on 2018/4/9.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    @Autowired
    @Qualifier("repository")
    private SpittleRepository repository;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String regist() {
        return "register";
    }
@RequestMapping(value = "/{sittleid}",method = RequestMethod.GET)
//@RequestParam(value = "max",defaultValue ="12" ) long max,
//@RequestParam(value = "count",defaultValue = "10") int count
    public String spittles(@PathVariable("sittleid") int count, Model model) {
    model.addAttribute("list",repository.findSpittles(Long.MAX_VALUE, count));
        return "spittle";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@Valid spitter spitter, Errors errors
            ) throws IOException {
        System.out.println(spitter);
        System.out.println(errors.hasErrors());
        if(errors.hasErrors()) return "register";
//        file.transferTo(new File("."+file.getOriginalFilename()));
        return "redirect:/spittles/"+spitter.getId();
    }
}
