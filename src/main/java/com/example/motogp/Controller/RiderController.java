package com.example.motogp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motogp.Rider.Rider;
import com.example.motogp.Service.RiderService;

@RestController
@RequestMapping("/riders")
public class RiderController {
    
    @Autowired
    private RiderService riderService;

    @GetMapping("/{id}/team")
    public ResponseEntity<String> getTeamName(@PathVariable int id) {
        String teamName = riderService.getTeamNameByRiderId(id);
        if (teamName != null) {
            return ResponseEntity.ok(teamName);
        }
        return ResponseEntity.notFound().build();
    }

    
    @GetMapping
    public ResponseEntity<List<Rider>> getAllRiders() {
        List<Rider> riders = riderService.getAllRiders();
        
    
        if (riders.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        
        return ResponseEntity.ok(riders); 
    }
}