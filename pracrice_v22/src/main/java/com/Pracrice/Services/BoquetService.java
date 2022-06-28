package com.Pracrice.Services;

import com.Pracrice.Repositories.BoquetRepository;
import com.Pracrice.Repositories.FlowerRepository;
import com.Pracrice.Repositories.PackageRepository;
import com.Pracrice.Repositories.RibbonRepository;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Flower;
import com.Pracrice.TableInfo.Package;
import com.Pracrice.TableInfo.Ribbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoquetService {
    @Autowired
    private final BoquetRepository boquetRepository;

    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private PackageRepository pacakgeRepository;

    @Autowired
    private RibbonRepository ribbonRepository;

    @Autowired
    public BoquetService(BoquetRepository boquetRepository){
        this.boquetRepository=boquetRepository;
    }

    public void FlowerService(FlowerRepository flowerRepository){
        this.flowerRepository=flowerRepository;
    }

    public List<Boquet> getBoquet(){
        return boquetRepository.findAll();
    }

    public void addNewBoquet(Boquet boquet){
        boquetRepository.save(boquet);
        System.out.println("boquet:"+boquet.getId()+" is add to table");
    }

    public void deleteBoquet(Integer id){
        boolean exists= boquetRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Boquet with id:"+id+" does not exists");
        }
        else {
            boquetRepository.deleteById(id);
            System.out.println("boquet with id"+id+"was delete");
        }
    }

    @Transactional
    public void updateBoquet(int id, Package _package, Ribbon ribbon){
        Boquet boquet= boquetRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Boquet with id:"+id+" does not exists"));
        boquet.set_package(_package);
        boquet.setRibbon(ribbon);
    }

    @Transactional
    public void enrollFlowerToBoquet(Integer boquetid, Integer flowerid){
        Boquet boquet = boquetRepository.findById(boquetid)
                .orElseThrow(()-> new IllegalStateException("Boquet with id:"+boquetid+" does not exists"));
        Flower flower= flowerRepository.findById(flowerid)
                .orElseThrow(()-> new IllegalStateException("Flower with id:"+flowerid+" does not exists"));
        boquet.enrollFlower(flower);
        boquetRepository.save(boquet);
    }

    //assign packege to Boquet
    public void assignPackageToBoquet(Integer boquetid, Integer packageid) {
        Boquet boquet = boquetRepository.findById(boquetid)
                .orElseThrow(()-> new IllegalStateException("Boquet with id:"+boquetid+" does not exists"));
        Package _package= pacakgeRepository.findById(packageid)
                .orElseThrow(()-> new IllegalStateException("Package with id:"+packageid+" does not exists"));

        boquet.assignPackage(_package);
        boquetRepository.save(boquet);
    }

    public void assignRibbonToBoquet(Integer boquetid, Integer ribbonid) {
        Boquet boquet = boquetRepository.findById(boquetid)
                .orElseThrow(()-> new IllegalStateException("Boquet with id:"+boquetid+" does not exists"));
        Ribbon ribbon = ribbonRepository.findById(ribbonid)
                .orElseThrow(()-> new IllegalStateException("Ribbon with id:"+ribbonid+" does not exists"));
        boquet.assignRibbon(ribbon);
        boquetRepository.save(boquet);
    }
}
