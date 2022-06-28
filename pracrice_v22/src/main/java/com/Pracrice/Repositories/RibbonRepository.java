package com.Pracrice.Repositories;

import com.Pracrice.TableInfo.Ribbon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RibbonRepository
        extends JpaRepository<Ribbon, Integer> {
}
