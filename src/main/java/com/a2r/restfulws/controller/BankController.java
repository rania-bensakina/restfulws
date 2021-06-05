package com.a2r.restfulws.controller;

import com.a2r.restfulws.model.Banque;
import com.a2r.restfulws.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class BankController {

    BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementExceptionHandler(NoSuchElementException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllBanks")
    public List<Banque> getAllBanks(){
        return bankService.getAllBanks();
    }

    @PatchMapping("/editBank")
    public void editBank(@RequestBody Banque bank){
         bankService.editBank( bank);
    }
    @PostMapping("/addBank")
    public void addBank(@RequestBody Banque bank){
        bankService.addBank( bank);
    }
    @DeleteMapping("/deletetBank")
    public void deletetBank(@RequestBody Long id){
        bankService.deleteBank(id);
    }
    @GetMapping("/{bankid}")
    public Banque findBankById(@PathVariable Long bankid){
        return bankService.findBankById(bankid);
    }
}

