package com.a2r.restfulws.service;

import com.a2r.restfulws.model.Banque;
import com.a2r.restfulws.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }
    public List<Banque> getAllBanks(){
        return bankRepository.findAll();
    }

   public void addBank(Banque bank){
      bankRepository.save(bank);
   }
    public void editBank(Banque bank){
             bankRepository.saveAndFlush(bank);
    }
    public void deleteBank(Long id){
        bankRepository.deleteById(id);
    }
    public Banque findBankById(Long id){
        return bankRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Element not found !"));
    }
}
