package com.Pracrice.Controllers;

import com.Pracrice.Services.BoquetService;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Package;
import com.Pracrice.TableInfo.Ribbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/boquet")
public class BoquetController {
    private final BoquetService boquetService;

    @Autowired
    public BoquetController(BoquetService boquetService){
        this.boquetService=boquetService;
    }

    @GetMapping
    public List<Boquet>getBoquets(){
        return boquetService.getBoquet();
    }

//    {
//        "name": "gfghh",
//        "countryOfOrigin": "opihg",
//        "amount": "758",
//        "cost": "654"
//    }
    @PostMapping
    public void registerNewBoquet(@RequestBody Boquet boquet){
        boquetService.addNewBoquet(boquet);
    }

    //deleting boquet by id, example: DELETE http://localhost:8080/api/v1/boquet/1
    @DeleteMapping(path = "{id}")
    public void deleteBoquet(
            @PathVariable("id") Integer id)
    {
        boquetService.deleteBoquet(id);
    }

    //boquet updating request example:PUT http://localhost:8080/api/v1/boquet/1?name=kdasjdl
    @PutMapping(path = "{id}")
    public void updateBoquet(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) Ribbon ribbon,
            @RequestParam(required = false) Package _package
    )
    {
        boquetService.updateBoquet(id, _package, ribbon);
    }

    @PutMapping(path = "{boquetid}/flower/{flowerid}")
    public void enrollFlowerToBoquet(
            @PathVariable Integer boquetid,
            @PathVariable Integer flowerid
    )
    {
        boquetService.enrollFlowerToBoquet(boquetid,flowerid);
    }

    //assign Package To Boquet
    @PutMapping(path = "{boquetid}/package/{packageid}")
    public void assignPackageToBoquet(
            @PathVariable Integer boquetid,
            @PathVariable Integer packageid
    )
    {
        boquetService.assignPackageToBoquet(boquetid,packageid);
    }
    //assign Package To Boquet
    @PutMapping(path = "{boquetid}/ribbon/{ribbonid}")
    public void assignRibbonToBoquet(
            @PathVariable Integer boquetid,
            @PathVariable Integer ribbonid
    )
    {
        boquetService.assignRibbonToBoquet(boquetid,ribbonid);
    }
}
