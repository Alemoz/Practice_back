package com.Pracrice.Controllers;

import com.Pracrice.Services.FlowerService;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Flower;
import com.Pracrice.TableInfo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/flower")
public class FlowerController {

    private  final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService){
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getFlower(){
        return flowerService.getFlower();
    }

    //add new flower
    //    {
//        "name": "gfghh",
//        "countryOfOrigin": "opihg",
//        "amount": "758",
//        "cost": "654"
//    }
    @PostMapping
    public void registerNewFlower(@RequestBody Flower flower){
        flowerService.addNewFlower(flower);
    }

    //deleting flower by id, example: DELETE http://localhost:8080/api/v1/flower/1
    @DeleteMapping(path = "{id}")
    public void deleteFlower(
            @PathVariable("id") Integer id
    ){
        flowerService.deleteFlower(id);
    }

    //flower updating request example:PUT http://localhost:8080/api/v1/flower/1?name=kdasjdl&AMOUNT=&
    @PutMapping(path = "{id}")
    public void updateFlower(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String countryOfOrigin,
            @RequestParam(required = false) Integer amount,
            @RequestParam(required = false) Integer cost,
            @RequestParam(required = false) Set<Boquet> boquets,
            @RequestParam(required = false) Set<Store> stores
    ){
        flowerService.updateFlower(id, name, countryOfOrigin, amount, cost, boquets, stores);
    }


}
