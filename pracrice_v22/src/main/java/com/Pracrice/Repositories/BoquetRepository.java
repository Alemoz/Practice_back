package com.Pracrice.Repositories;

import com.Pracrice.TableInfo.Boquet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoquetRepository
        extends JpaRepository<Boquet, Integer> {
}
