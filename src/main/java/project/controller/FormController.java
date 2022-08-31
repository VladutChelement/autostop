package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.entity.Form;
import project.repository.FormRepository;

public class FormController {
    @Autowired
    private FormRepository formRepository;

    @GetMapping("/saveForm")
    public String Form(Model model) {
        model.addAttribute("formObject", new Form());
        return "saveForm";
    }

    @PostMapping("/saveForm")
    public String Submit(@ModelAttribute Form form, Model model) {
        model.addAttribute("formObject", form);
        formRepository.save(form);
        return "redirect:/index";
    }
}
