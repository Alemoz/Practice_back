package com.Pracrice.Services;

import com.Pracrice.Repositories.PackgeTypeRepository;
import com.Pracrice.TableInfo.PackageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PackageTypeService {
    private final PackgeTypeRepository packgeTypeRepository;

    @Autowired
    public PackageTypeService(PackgeTypeRepository packgeTypeRepository){
        this.packgeTypeRepository=packgeTypeRepository;
    }

    public List<PackageType> getPackageType(){
        return packgeTypeRepository.findAll();
    }

    public void addNewPackageType(PackageType packageType){
        packgeTypeRepository.save(packageType);
        System.out.println("PackageType:"+packageType.getName()+" is add to table");
    }

    public void deletePackageType(Integer id){
        //if packageType not exists
        if(packgeTypeRepository.existsById(id)){
            throw new IllegalStateException("PackageType with id:"+id+" does not exists");
        }
        packgeTypeRepository.deleteById(id);
    }

    @Transactional
    public void updateBoquetType(Integer id, String name){
        PackageType packageType=packgeTypeRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("PackageType with id:"+id+" does not exists"));
        if(name!=null&&
                name.length()>0&&
                !Objects.equals(packageType.getName(), name)
        ){
            packageType.setName(name);
        }
    }
}
