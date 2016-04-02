package li.fyunli.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by fyunli on 16/4/1.
 */
@Controller
public class HelloController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/hello")
    public String welcome(ModelMap model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "hello";
    }

}
