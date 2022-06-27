package com.example.demo.api;

import com.example.demo.business.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "api/stores/")
@AllArgsConstructor
public class StoreController {

    private StoreService storeService;

    @RequestMapping("all")
    public String getAll(Model model) {
        model.addAttribute("stores", storeService.getAllStores());
        return "viewAllStores";
    }

    @RequestMapping("{id}")
    public String getByStoreId(@PathVariable(value = "id")Long id, Model model) {
        model.addAttribute("store", storeService.getStoreById(id));
        return "viewAStore";
    }
}
