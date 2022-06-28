package com.Pracrice.Repositories;

import com.Pracrice.TableInfo.PackageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackgeTypeRepository
        extends JpaRepository<PackageType, Integer> {
}
