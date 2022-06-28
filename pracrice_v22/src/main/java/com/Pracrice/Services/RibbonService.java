package com.Pracrice.Services;

import com.Pracrice.Repositories.RibbonRepository;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Ribbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class RibbonService {
    private final RibbonRepository ribbonRepository;

    @Autowired
    public RibbonService(RibbonRepository ribbonRepository){
        this.ribbonRepository=ribbonRepository;
    }

    public List<Ribbon> getRibbon(){
        return ribbonRepository.findAll();
    }

    public void addNewRibbon(Ribbon ribbon){
        ribbonRepository.save(ribbon);
        System.out.println("ribbon:"+ribbon.getName()+" is add to table");
    }

    public void deleteRibbon(int id){
    //if ribbon exists
        if (ribbonRepository.existsById(id)) {
            throw new IllegalStateException("Package with id:"+id+" does not exists");
        }
        ribbonRepository.deleteById(id);
        System.out.println("ribbon:"+id+" was delete from table");
    }

    @Transactional
    public void updateRibbon(int id, String name, String size, String color, int amount, int cost, Set<Boquet> boquet){
        Ribbon ribbon= ribbonRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Package with id:"+id+" does not exists"));
        if(name!=null&&
                name.length()>0&&
                !Objects.equals(ribbon.getName(), name))
        {
            ribbon.setName(name);
        }
        if(size!=null&&
                size.length()>0&&
                !Objects.equals(ribbon.getSize(), size))
        {
            ribbon.setSize(size);
        }
        if(color!=null&&
                color.length()>0&&
                !Objects.equals(ribbon.getColor(), color))
        {
            ribbon.setColor(color);
        }

        if(amount>0&&
                !Objects.equals(ribbon.getAmount(), amount))
        {
            ribbon.setAmount(amount);
        }
        if(cost>0&&
                !Objects.equals(ribbon.getCost(), cost))
        {
            ribbon.setCost(cost);
        }
        ribbon.setBoquets(boquet);
    }

}
