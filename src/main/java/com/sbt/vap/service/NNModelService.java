package com.sbt.vap.service;

import com.sbt.vap.model.NNModel;
import com.sbt.vap.repository.NNModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbt.vap.repository.UserRepo;

import java.util.List;

@Service
public class NNModelService {

    @Autowired
    private NNModelRepo nnModelRepo;

    public NNModel saveNNModel(final NNModel nnModel) {
        return this.nnModelRepo.saveAndFlush(nnModel);
    }

    public List<NNModel> findAll() {
        return this.nnModelRepo.findAll();
    }

    public NNModel getNNModelByID(final long id){
        return this.nnModelRepo.getOne(id);
    }

    public void deleteNNModel(final NNModel nnModel){ this.nnModelRepo.delete(nnModel); }


}