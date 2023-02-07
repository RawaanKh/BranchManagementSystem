package com.example.onetomany.Repository;

import com.example.onetomany.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Integer> {
    Merchant findMerchantsById(Integer id);
}
