package com.volkruss.tutorialstudy.validatingforminput.controller;

import com.volkruss.tutorialstudy.validatingforminput.form.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SampleController {
    @GetMapping("/form")
    public String showForm(PersonForm personForm){
        return "form";
    }

    @PostMapping("/form")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/results";
    }
    @GetMapping("/results")
    public String results(){
        return "results";
    }

}
