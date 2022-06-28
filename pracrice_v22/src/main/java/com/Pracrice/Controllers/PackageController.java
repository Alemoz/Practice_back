package com.Pracrice.Controllers;

import com.Pracrice.Services.PackageService;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Package;
import com.Pracrice.TableInfo.PackageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/packages")
public class PackageController {
    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService){
        this.packageService=packageService;
    }

    @GetMapping
    public List<Package> getPackage(){
        return packageService.getPackage();
    }

    //add new package
 //   {
//        "name": "eqweqd",
//        "size": "123*231vv",
//        "color": "red",
//        "cost": "654"
//    }
    @PostMapping
    public void registerNewPackage(@RequestBody Package packages){
        packageService.addNewPackage(packages);
    }

    //deleting package by id, example: DELETE http://localhost:8080/api/v1/package/1
    @DeleteMapping(path = "{id}" )
    public void deletePackage(
            @PathVariable("id") Integer id)
    {
        packageService.deletePackage(id);
    }

    //package updating request example:PUT http://localhost:8080/api/v1/package
    @PutMapping(path = "{id}")
    public void updatePackage(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer cost,
            @RequestParam(required = false) PackageType packageType,
            @RequestParam(required = false) Set<Boquet> boquet

    ){
        packageService.updatePackage(id, name, size, color, cost, packageType, boquet);
    }

    @PutMapping(path = "{packageid}/packagetype/{packagetypeid}")
    public void assignPackTypeToPackage(
            @PathVariable Integer packageid,
            @PathVariable Integer packagetypeid
    )
    {
        packageService.assignPackTypeToPackage(packageid,packagetypeid);
    }
}
