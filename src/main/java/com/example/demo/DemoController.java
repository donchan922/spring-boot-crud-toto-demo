package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final DemoMapper demoMapper;

    @GetMapping("/tasks")
    public String index(Model model) {
        model.addAttribute("tasks", demoMapper.findAll());
        return "index";
    }

    @PostMapping("/tasks")
    public String create(Task task) {
        demoMapper.insert(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/new")
    public String add(Model model) {
        model.addAttribute("task", new Task());
        return "add";
    }

    @GetMapping("/tasks/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("task", demoMapper.findById(id));
        return "edit";
    }

    @PostMapping("/tasks/update")
    public String update(Task task) {
        demoMapper.update(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String delete(@PathVariable long id) {
        demoMapper.delete(id);
        return "redirect:/tasks";
    }
}
