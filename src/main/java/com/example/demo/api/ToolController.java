package com.example.demo.api;

import com.example.demo.business.service.ToolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/tools/")
@AllArgsConstructor
public class ToolController {

    private ToolService toolService;

    @GetMapping("all")
    public String findTools(Model model) {
        model.addAttribute("tools", toolService.getAllTools());
        return "viewAllTools";
    }

    @GetMapping("{id}")
    public String getToolById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("tool", toolService.getToolById(id));
        return "viewATool";
    }
}
