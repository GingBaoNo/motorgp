package com.example.motogp.Rider;


import com.example.motogp.Team.Team;  // Đảm bảo import lớp Team

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "riders")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(name = "rider_number", nullable = false)
    private Integer riderNumber;

    // Constructor rỗng
    public Rider() {
    }

    // Constructor với tham số
    public Rider(String name, String country, Team team, Integer riderNumber) {
        this.name = name;
        this.country = country;
        this.team = team;
        this.riderNumber = riderNumber;
    }

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getRiderNumber() {
        return riderNumber;
    }

    public void setRiderNumber(Integer riderNumber) {
        this.riderNumber = riderNumber;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", team=" + (team != null ? team.getTeamName() : "null") +
                ", riderNumber=" + riderNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rider rider = (Rider) o;
        return id.equals(rider.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
