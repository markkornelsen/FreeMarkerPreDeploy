package com.example.freemarkerpredeploy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/hello")
    public String hello(Model model, @RequestParam(value="msg", required=false, 
            defaultValue="Freemarker") String msg) {
        
        model.addAttribute("message", msg);
        return "hello";
    }    

    @GetMapping("/form")
    public String formGet() {
        return "form";
    }

    @PostMapping("/form")
    public String formPost(User user, Model model) {
        model.addAttribute("user", user);
        return "form";
    }
}
