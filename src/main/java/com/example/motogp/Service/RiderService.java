package com.example.motogp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.motogp.Rider.Rider;
import com.example.motogp.Rider.RiderRepository;

import java.util.List;

@Service
public class RiderService {
    @Autowired
    private RiderRepository riderRepository;

    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }
}