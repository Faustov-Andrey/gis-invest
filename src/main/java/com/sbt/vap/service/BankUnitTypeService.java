package com.sbt.vap.service;
import com.sbt.vap.model.BankUnitType;
import com.sbt.vap.repository.BankUnitTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankUnitTypeService {

    @Autowired
    private BankUnitTypeRepo bankUnitTypeRepo;

    public List<BankUnitType> findAll() {
        return this.bankUnitTypeRepo.findAll();
    }
}
