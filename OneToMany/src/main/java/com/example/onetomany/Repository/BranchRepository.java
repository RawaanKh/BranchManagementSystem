package com.example.onetomany.Repository;

import com.example.onetomany.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Integer> {
    Branch findBranchById(Integer id);
}
