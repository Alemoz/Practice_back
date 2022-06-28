package com.Pracrice.Controllers;

import com.Pracrice.Services.StoreService;
import com.Pracrice.TableInfo.Flower;
import com.Pracrice.TableInfo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/store")
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){
        this.storeService=storeService;
    }

    @GetMapping
    public List<Store> getStore(){
        return storeService.getStore();
    }

    //add new store
    //    {
//        "name": "gfghh",
//        "countryOfOrigin": "opihg",
//        "amount": "758",
//        "cost": "654"
//    }
    @PostMapping
    public void registerNewStore(@RequestBody Store store){
        storeService.addNewStore(store);
    }

    //deleting store by id, example: DELETE http://localhost:8080/api/v1/store/1
    @DeleteMapping(path = "{id}")
    public void deleteStore(
            @PathVariable("id")Integer id){
        storeService.deleteStore(id);
    }

    //updating store request example:PUT http://localhost:8080/api/v1/store/1?address=Melburn&email=dwedwoiej
    @PutMapping(path = "{id}")
    public void updateStore(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Set<Flower> flower){
        storeService.updateStore(id, address, flower);
    }

    @PutMapping(path="{id}/store/{flowerid}")
    public void enrollFlowerToStore(
            @PathVariable Integer id,
            @PathVariable Integer flowerid
    ){
        storeService.enrollFlowerToStore(id,flowerid);
    }

}
