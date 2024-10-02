package com.example.motogp.Service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import com.example.motogp.Rider.Rider;
import com.example.motogp.Rider.RiderRepository;

@Service
public class RiderService {
    @Autowired
    private RiderRepository riderRepository;

    public String getTeamNameByRiderId(int riderId) {
        
        Rider rider = riderRepository.findById(riderId).orElse(null);
        
        if (rider != null && rider.getTeam() != null) {
            return rider.getTeam().getTeamName();
        }
        return null;
    }

    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }
}
