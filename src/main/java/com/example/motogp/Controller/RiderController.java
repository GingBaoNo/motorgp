package com.example.motogp.Controller; // Chú ý chữ thường

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class RiderController {
    @Autowired
    private com.example.motogp.Service.RiderService riderService;

    @GetMapping("/riders-list") // Thay đổi URL
    public String getAllRiders(Model model) {
        List<com.example.motogp.Rider.Rider> riders = riderService.getAllRiders();
        model.addAttribute("riders", riders);
        return "riders"; // Tên của trang HTML (Thymeleaf template)
    }
}