package com.example.formdemo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.formdemo.model.FormData;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

	 private List<String[]> formDataList = new ArrayList<>();
    
    @RequestMapping("/demo")
    public void Demo() {
    	System.out.println("Demo content....");
    }

 // Show form on GET request
    @GetMapping("/")
    public String showForm(Model model) {
    	System.out.println("Load Page...");
        model.addAttribute("formDataList", formDataList);
        return "index";
    }

    // Handle form submission on POST request
    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
//                             @RequestParam("email") String email,
                             Model model) {
    	System.out.println("firstName:"+firstName + "\n"+ "lastName:"+lastName);
        // Add the submitted form data to the list
//        formDataList.add(new String[]{firstName, lastName, email});
        formDataList.add(new String[]{firstName, lastName});
        
        model.addAttribute("formDataList", formDataList);
        return "index";
    }
}

