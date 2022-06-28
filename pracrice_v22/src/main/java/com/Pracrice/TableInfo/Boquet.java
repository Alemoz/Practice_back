package com.Pracrice.TableInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "boquets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Boquet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 25)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Package_ID", referencedColumnName = "ID")
    private Package _package;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ribbon_ID", referencedColumnName = "ID")
    private Ribbon ribbon;


    @ManyToMany
    @JoinTable( name = "boquets_has_flowers",
            joinColumns = @JoinColumn(name = "Boquet_id"),
            inverseJoinColumns = @JoinColumn(name = "Flower_ID"))
    private Set<Flower> enrolledFlowers = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Set<Flower> getEnrolledFlowers() {
        return enrolledFlowers;
    }

    public void setEnrolledFlowers(Set<Flower> enrolledFlowers) {
        this.enrolledFlowers = enrolledFlowers;
    }

    public Ribbon getRibbon() {
        return ribbon;
    }

    public void setRibbon(Ribbon ribbon) {
        this.ribbon = ribbon;
    }

    public Package get_package() {
        return _package;
    }

    public void set_package(Package _package) {
        this._package = _package;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void enrollFlower(Flower flower) {
        enrolledFlowers.add(flower);
    }

    public void assignPackage(Package _package) {
        this._package = _package;
    }

    public void assignRibbon(Ribbon ribbon) {
        this.ribbon= ribbon;
    }

    // Reverse Engineering! Migrate other columns to the entity
}