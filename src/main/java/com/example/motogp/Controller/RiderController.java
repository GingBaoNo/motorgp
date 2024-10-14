package com.example.motogp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motogp.Rider.Rider;
import com.example.motogp.Service.RiderService;

import jakarta.annotation.PostConstruct;


@RestController
public class RiderController {

    @Autowired
    private RiderService riderService;

    @PostConstruct
    public void init() {
        // Hiển thị dữ liệu ra terminal
        riderService.getAllRiders().forEach(rider -> {
            System.out.println("Rider ID: " + rider.getId() + ", Name: " + rider.getName() + ", Country: " + rider.getCountry());
        });
    }

    @GetMapping(".\\main\\resources\\templates\\riders.html")
    public String showRiders(Model model) {
    List<Rider> riders = riderService.getAllRiders(); // Lấy danh sách tay đua từ service
    model.addAttribute("riders", riders); // Thêm danh sách tay đua vào mô hình
    return "riders"; // Trả về tên file HTML
}
}