package com.Pracrice.TableInfo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Address", nullable = false, length = 25)
    private String address;

    public Store() {
    }

    public Store(Integer id, String address, Set<Flower> flowers) {
        this.id = id;
        this.address = address;
        this.enrolledFlowers = flowers;
    }

    @ManyToMany
    @JoinTable(name = "store_has_flowers",
            joinColumns = @JoinColumn(name = "Store_ID"),
            inverseJoinColumns = @JoinColumn(name = "Flower_ID"))
    private Set<Flower> enrolledFlowers = new HashSet<>();


    public Set<Flower> getFlowers() {
        return enrolledFlowers;
    }

    public void setFlowers(Set<Flower> flowers) {
        this.enrolledFlowers = flowers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}