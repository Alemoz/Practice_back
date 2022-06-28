package com.Pracrice.TableInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "packages")
//@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 25)
    private String name;

    @Column(name = "Size", nullable = false, length = 15)
    private String size;

    @Column(name = "Color", nullable = false, length = 25)
    private String color;

    @Column(name = "Cost", nullable = false)
    private Integer cost;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PackageType_ID", referencedColumnName = "ID")
    private PackageType packageType;

    @JsonIgnore
    @OneToMany(mappedBy = "_package")
    private Set<Boquet> boquets = new HashSet<>();

    public Set<Boquet> getBoquets() {
        return boquets;
    }

    public void setBoquets(Set<Boquet> boquets) {
        this.boquets = boquets;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
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

    public void assignPackType(PackageType packageType) {
        this.packageType=packageType;
    }
}