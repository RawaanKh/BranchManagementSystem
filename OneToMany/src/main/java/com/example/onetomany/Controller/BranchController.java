package com.example.onetomany.Controller;

import com.example.onetomany.Api.ApiException;
import com.example.onetomany.Model.Branch;
import com.example.onetomany.Model.Merchant;
import com.example.onetomany.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/Branch")
public class BranchController {
    private final BranchService branchService;
    @GetMapping("/get")
    public ResponseEntity getBranch(){
        List<Branch> branches=branchService.getBranch();
        return ResponseEntity.status(200).body(branches);
    }
    @PostMapping("/add")
    public ResponseEntity addBranch(@Valid @RequestBody Branch branch){

        branchService.addBranch(branch);
        return ResponseEntity.status(200).body("Branch Added");
    }
    @PutMapping("/Update/{ID}")
    public ResponseEntity updateBranch(@PathVariable Integer ID,@Valid@RequestBody Branch branch){
        boolean isUpdate= branchService.updateBranch(ID,branch);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Branch Updated");
        }
        throw new ApiException("Invalid Branch Id");
    }
    @DeleteMapping("/Delete/{ID}")
    public  ResponseEntity deleteBranch(@PathVariable Integer ID){
        boolean isDelete= branchService.deleteBranch(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Branch Deleted");
        }
        throw new ApiException("Invalid Branch Id");
    }
    @PutMapping("/{merchant_id/branchName/{branch_id}")
   public ResponseEntity assignMerchantToBranch(@PathVariable Integer merchant_id,@PathVariable Integer branch_id){
        branchService.assignMerchantToBranch(merchant_id,branch_id);
        return ResponseEntity.status(200).body("assign merchant to branch");

    }


}
