package com.example.onetomany.Service;

import com.example.onetomany.Api.ApiException;
import com.example.onetomany.Model.Merchant;
import com.example.onetomany.Repository.BranchRepository;
import com.example.onetomany.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
      private final MerchantRepository merchantRepository;
      private final BranchRepository branchRepository;

    public List<Merchant> getMerchant(){
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }
    public boolean updateMerchant(Integer id,Merchant merchant){
        Merchant oldMerchant=merchantRepository.findMerchantsById(id);
        if(oldMerchant==null){
            return false;
        }
        oldMerchant.setName(merchant.getName());
        merchantRepository.save(oldMerchant);
        return true;
    }
    public boolean deleteMerchant(Integer id){
        Merchant oldMerchant=merchantRepository.findMerchantsById(id);
        if(oldMerchant==null){
            return false;
        }
        merchantRepository.delete(oldMerchant);
        return true;
    }

}
