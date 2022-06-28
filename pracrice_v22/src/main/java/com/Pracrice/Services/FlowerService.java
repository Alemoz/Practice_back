package com.Pracrice.Services;

import com.Pracrice.Repositories.FlowerRepository;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Flower;
import com.Pracrice.TableInfo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlower(){
        return flowerRepository.findAll();
    }

    public void addNewFlower(Flower flower) {
        flowerRepository.save(flower);
        System.out.println("flower:"+flower.getName()+" is add to table");
    }

    public void deleteFlower(Integer id) {
        //if flower not exists
        boolean exists = flowerRepository.existsById(id);
        if(!exists){
            throw  new IllegalStateException("Flower with id:"+id+" does not exists");
        }
        else {
        flowerRepository.deleteById(id);
        System.out.println("flower with id"+id+"was delete");
        }
    }

    @Transactional
    public void updateFlower(int id, String name, String countryOfOrigin, int amount, int cost, Set<Boquet> boquets, Set<Store> stores){
        Flower flower= flowerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Flower with id:"+id+" does not exists"));
        if(name!=null&&
            name.length()>0&&
                !Objects.equals(flower.getName(), name)
        ){
            flower.setName(name);
        }
        if(countryOfOrigin!=null&&
            countryOfOrigin.length()>0&&
                !Objects.equals(flower.getCountryOfOrigin(), countryOfOrigin)
        ){
            flower.setCountryOfOrigin(countryOfOrigin);
        }
        if(amount>0&&
                !Objects.equals(flower.getAmount(), amount)
        ){
            flower.setAmount(amount);
        }
        if(cost>0&&
                !Objects.equals(flower.getCost(), cost)
        ){
            flower.setCost(cost);
        }
        flower.setBoquets(boquets);
        flower.setStores(stores);

    }
}
