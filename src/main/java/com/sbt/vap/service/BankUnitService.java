package com.sbt.vap.service;

import com.sbt.vap.model.BankUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbt.vap.repository.BankUnitRepo;

import java.util.List;

@Service
public class BankUnitService {


    @Autowired
    private BankUnitRepo bankUnitRepo;

    public void addNewBankUnit (final BankUnit bankUnit) { this.bankUnitRepo.saveAndFlush(bankUnit); }

    public BankUnit saveBankUnit (final BankUnit bankUnit) {
        return this.bankUnitRepo.saveAndFlush(bankUnit);
    }

    public List<BankUnit> findAll() {
        return this.bankUnitRepo.findAll();
    }

    public List<BankUnit> findByParentId(Long parentId) {
        List<BankUnit> bankUnitList = this.bankUnitRepo.findByParentId(parentId);
        return bankUnitList;
    }

    public BankUnit getBankUnitByID(final long id){ return this.bankUnitRepo.getOne(id); }

    public void deleteBankUnit(final BankUnit bankUnit){ this.bankUnitRepo.delete(bankUnit); }


}
