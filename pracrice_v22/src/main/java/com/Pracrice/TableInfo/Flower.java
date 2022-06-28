package com.Pracrice.TableInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

//@Setter
//@Getter
@Entity
@Table(name = "flowers")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer flowerid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "countryOfOrigin", nullable = false, length = 45)
    private String countryOfOrigin;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledFlowers")
//    @JoinTable(name = "boquets_has_flowers",
//            joinColumns = @JoinColumn(name = "Flower_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Boquet_ID"))
    private Set<Boquet> boquets = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledFlowers")
//    @JoinTable(name = "store_has_flowers",
//            joinColumns = @JoinColumn(name = "Flower_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Store_ID"))
    private Set<Store> stores = new HashSet<>();

    public Flower() {
    }

    public Flower(Integer flowerid, String name, String countryOfOrigin, Integer amount, Integer cost, Set<Boquet> boquets, Set<Store> stores) {
        this.flowerid = flowerid;
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.amount = amount;
        this.cost = cost;
        this.boquets = boquets;
        this.stores = stores;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<Boquet> getBoquets() {
        return boquets;
    }

    public void setBoquets(Set<Boquet> boquets) {
        this.boquets = boquets;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlowerid() {
        return flowerid;
    }

    public void setFlowerid(Integer flowerid) {
        this.flowerid = flowerid;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "flowerid=" + flowerid +
                ", name='" + name + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                ", boquets=" + boquets +
                ", stores=" + stores +
                '}';
    }
}