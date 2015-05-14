package com.test.web.controllers;

import com.test.web.models.Human;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alekseydudchenko on 06/05/15.
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String sayHello(Model model) {

        Human human = new Human();

        human.setName("Serega");
        human.setAge(27);

        model.addAttribute("human", human);

        return "hello";
    }

}
