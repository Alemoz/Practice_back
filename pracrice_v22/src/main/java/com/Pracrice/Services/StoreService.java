package com.Pracrice.Services;

import com.Pracrice.Repositories.FlowerRepository;
import com.Pracrice.Repositories.StoreRepository;
import com.Pracrice.TableInfo.Flower;
import com.Pracrice.TableInfo.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
//@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    @Autowired
    private FlowerRepository flowerRepository;


   public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }


    public void FlowerService(FlowerRepository flowerRepository){
        this.flowerRepository = flowerRepository;
    }

    public List<Store> getStore(){
        return storeRepository.findAll();
    }

    public void addNewStore(Store store) {
        storeRepository.save(store);
        System.out.println("store:"+store.getId()+" is add to table");
    }

    public void deleteStore(Integer id) {
        //if store not exists
        if(!storeRepository.existsById(id)){
            throw new IllegalStateException("Store with id: "+id+" does not exists");
        }
        storeRepository.deleteById(id);
        System.out.println("store: "+id+" was delete from table");

    }

    @Transactional
    public void updateStore(Integer id, String address, Set<Flower> flower) {
        Store store = storeRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("store with id"+id+"does not exist"));
        if (address != null &&
                address.length() > 0 &&
                !Objects.equals(store.getAddress(), address)
        ) {
            store.setAddress(address);
        }
        store.setFlowers(flower);
        //example
//        if(email !=null&&
//                email.length()>0&&
//                !Objects.equals(student.getEmail(), email)){
//            Optional<Student> studentOptional=sudentRepository
//                    .findStudentByEmail(email);
//            if(studentOptional.isPresent()){
//                throw new IllegalStateException("email taken");
//            }
//            student.setEmail(email);
//        }
    }

    @Transactional
    public void enrollFlowerToStore(Integer storeid, Integer flowerid){
       Store store = storeRepository.findById(storeid)
               .orElseThrow(()->new IllegalStateException("store with id"+storeid+"does not exist"));

       Flower flower= flowerRepository.findById(flowerid)
               .orElseThrow(()-> new IllegalStateException("Flower with id:"+flowerid+" does not exists"));
        store.enrollFlower(flower);
        storeRepository.save(store);
    }
}
