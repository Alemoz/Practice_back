package com.Pracrice.TableInfo;

import com.Pracrice.TableInfo.Boquet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ribbons")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ribbon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "size", nullable = false, length = 25)
    private String size;

    @Column(name = "Color", nullable = false, length = 25)
    private String color;

    @Column(name = "Amount", nullable = false)
    private Integer amount;

    @Column(name = "Cost", nullable = false)
    private Integer cost;

    @JsonIgnore
    @OneToMany(mappedBy = "ribbon")
    private Set<Boquet> boquets = new LinkedHashSet<>();

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}