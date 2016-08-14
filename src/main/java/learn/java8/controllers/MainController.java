package learn.java8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class MainController
 * <p>
 * Created by Starostin Konstantin
 * on 14.08.2016.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("startPage");
        model.addObject("message", "Hello Spring MVC Framework!");
        return model;
    }
}
