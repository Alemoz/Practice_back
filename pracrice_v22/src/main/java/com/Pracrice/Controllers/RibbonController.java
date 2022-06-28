package com.Pracrice.Controllers;

import com.Pracrice.Services.RibbonService;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Ribbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/ribbon")
public class RibbonController {
    private final RibbonService ribbonService;

    @Autowired
    public RibbonController(RibbonService ribbonService){
        this.ribbonService = ribbonService;
    }

    @GetMapping()
    public List<Ribbon> getRibbon(){
        return ribbonService.getRibbon();
    }

    //add new Ribbon
    //    {
//        "name": "gfghh",
//        "size": "opihg",
//        "color": "red",
//        "amount": "758",
//        "cost": "654"
//    }
    @PostMapping
    public void registerNewRibbon(@RequestBody Ribbon ribbon){
        ribbonService.addNewRibbon(ribbon);
    }

    //deleting ribbon by id, example: DELETE http://localhost:8080/api/v1/ribbon/1
    @DeleteMapping(path="{id}")
    public void deleteRibbon(
            @PathVariable("id") Integer id)
    {
        ribbonService.deleteRibbon(id);
    }

    //ribbon updating request example:PUT http://localhost:8080/api/v1/ribbon
    @PutMapping(path = "{id}")
    public void updateRibbon(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer amount,
            @RequestParam(required = false) Integer cost,
            @RequestParam(required = false) Set<Boquet> boquet
    ) {
        ribbonService.updateRibbon(id, name, size, color, amount, cost, boquet);
    }

}
