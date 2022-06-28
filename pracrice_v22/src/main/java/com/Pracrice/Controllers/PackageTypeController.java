package com.Pracrice.Controllers;

import com.Pracrice.Services.PackageTypeService;
import com.Pracrice.TableInfo.PackageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/packagetype")
public class PackageTypeController {

    private final PackageTypeService packageTypeService;

    @Autowired
    public PackageTypeController(PackageTypeService packageTypeService){
        this.packageTypeService = packageTypeService;
    }

    @GetMapping
    public List<PackageType> getPackageType(){
        return packageTypeService.getPackageType();
    }

    //add new packageType
    //    {
//        "name": "gfghh",
//        "countryOfOrigin": "opihg",
//        "amount": "758",
//        "cost": "654"
//    }
    @PostMapping
    public void registerNewPackageType(@RequestBody PackageType packageType){
        packageTypeService.addNewPackageType(packageType);
    }

    //deleting PackageType by id, example: DELETE http://localhost:8080/api/v1/packageType/1
    @DeleteMapping(path = "{id}")
    public void deletePackageType(
            @PathVariable("id") Integer id)
    {
        packageTypeService.deletePackageType(id);
    }

    @Transactional
    @PutMapping(path = "{id}")
    public void updatePackageType(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String name
    ){
        packageTypeService.updateBoquetType(id, name);
    }
}
