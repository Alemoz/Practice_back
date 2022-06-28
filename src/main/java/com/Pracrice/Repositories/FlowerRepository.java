package com.Pracrice.Repositories;

import com.Pracrice.TableInfo.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository
        extends JpaRepository<Flower, Integer> {
}
