package com.example.onetomany.Service;

import com.example.onetomany.Api.ApiException;
import com.example.onetomany.Model.Branch;
import com.example.onetomany.Model.Merchant;
import com.example.onetomany.Repository.BranchRepository;
import com.example.onetomany.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final MerchantRepository merchantRepository;
    private final BranchRepository branchRepository;

    public List<Branch> getBranch(){
        return branchRepository.findAll();
    }
    public void addBranch(Branch branch){
        branchRepository.save(branch);
    }
    public boolean updateBranch(Integer id,Branch branch){
        Branch oldBranch=branchRepository.findBranchById(id);
        if(oldBranch==null){
            return false;
        }
        oldBranch.setArea(branch.getArea());
        oldBranch.setNumber(branch.getNumber());
        branchRepository.save(oldBranch);
        return true;
    }
    public boolean deleteBranch(Integer id){
        Branch oldBranch=branchRepository.findBranchById(id);
        if(oldBranch==null){
            return false;
        }
        branchRepository.delete(oldBranch);
        return true;
    }
    public void assignMerchantToBranch(Integer merchant_id,Integer branch_id){
        Merchant merchant=merchantRepository.findMerchantsById(merchant_id);
        Branch branch=branchRepository.findBranchById(branch_id);
        if(merchant==null|| branch==null){
            throw new ApiException("id not found");
        }
        branch.setMerchant(merchant);
    }

}
