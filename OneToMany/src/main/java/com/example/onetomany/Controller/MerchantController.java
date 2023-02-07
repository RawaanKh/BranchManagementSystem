package com.example.onetomany.Controller;

import com.example.onetomany.Api.ApiException;
import com.example.onetomany.Model.Merchant;
import com.example.onetomany.Service.BranchService;
import com.example.onetomany.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/Merchant")
public class MerchantController {

private final MerchantService merchantService;
    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        List<Merchant> merchants=merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchants);
    }
    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant){

        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant Added");
    }
    @PutMapping("/Update/{ID}")
    public ResponseEntity updateMerchant(@PathVariable Integer ID,@Valid@RequestBody Merchant merchant){
        boolean isUpdate= merchantService.updateMerchant(ID,merchant);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Merchant Updated");
        }
        throw new ApiException("Invalid Merchant Id");
    }
    @DeleteMapping("/Delete/{ID}")
    public  ResponseEntity deleteMerchant(@PathVariable Integer ID){
        boolean isDelete= merchantService.deleteMerchant(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Merchant Deleted");
        }
        throw new ApiException("Invalid Merchant Id");
    }




}
