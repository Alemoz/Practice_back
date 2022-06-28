package com.Pracrice.Services;

import com.Pracrice.Repositories.PackageRepository;
import com.Pracrice.Repositories.PackgeTypeRepository;
import com.Pracrice.TableInfo.Boquet;
import com.Pracrice.TableInfo.Package;
import com.Pracrice.TableInfo.PackageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class PackageService {
    @Autowired
    private final PackageRepository packageRepository;

    @Autowired
    private PackgeTypeRepository packgeTypeRepository;
    @Autowired
    public PackageService(PackageRepository packageRepository){
        this.packageRepository=packageRepository;
    }

    public List<Package> getPackage(){
        return packageRepository.findAll();
    }

    public void addNewPackage(Package _package){
        packageRepository.save(_package);
        System.out.println("packahe: "+_package.getName()+"is add to table");

    }

    public void deletePackage(int id){
        //if no exists
        if(!packageRepository.existsById(id)){
            throw new IllegalStateException("Package with id: "+id+" does not exists");
        }
        packageRepository.deleteById(id);
    }

    @Transactional
    public void updatePackage(int id, String name, String size, String color, int cost, PackageType packageType, Set<Boquet> boquets){
        Package _package = packageRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("Package with id: "+id+" does not exists"));

         if (name != null &&
            name.length() > 0 &&
            !Objects.equals(_package.getName(), name)
            ) {
             _package.setName(name);
        }
         if (size != null &&
                size.length() > 0 &&
                !Objects.equals(_package.getSize(), size)
                ) {
            _package.setSize(size);
        }
         if (color != null &&
                color.length() > 0 &&
                !Objects.equals(_package.getColor(), color)
                ) {
            _package.setColor(color);
        }
         if (cost > 0 &&
                !Objects.equals(_package.getCost(), cost)
                ) {
            _package.setCost(cost);
        }
         if(!Objects.equals(_package.getPackageType(), packageType)){
             _package.setPackageType(packageType);
         }

         _package.setBoquets(boquets);
    }

    public void assignPackTypeToPackage(Integer packageid, Integer packagetypeid) {
        Package _package = packageRepository.findById(packageid)
                .orElseThrow(()-> new IllegalStateException("Package with id:"+packageid+" does not exists"));
        PackageType packageType = packgeTypeRepository.findById(packagetypeid)
                .orElseThrow(()-> new IllegalStateException("PackageType with id:"+packagetypeid+" does not exists"));
        _package.assignPackType(packageType);
        packageRepository.save(_package);
    }
}
