package com.example.motogp.Rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.motogp.Team.Team;

import java.util.List;
import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer> {
    List<Rider> findByName(String name);
    Optional<Rider> findById(Integer id);
    List<Rider> findByTeam(Team team);
}