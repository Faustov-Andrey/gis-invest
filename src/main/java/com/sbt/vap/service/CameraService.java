package com.sbt.vap.service;

import com.sbt.vap.model.Camera;
import com.sbt.vap.repository.CameraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    @Autowired
    private CameraRepo cameraRepo;

    public Camera saveCamera(final Camera camera) {
        Camera cam = this.cameraRepo.saveAndFlush(camera);
        return  cam;
    }

    public List<Camera> findAll() {
        return this.cameraRepo.findAll();
    }

    public List<Camera> findByBankUnit(Long bankUnitId) {
        List<Camera> cameraList = this.cameraRepo.findByBankUnit(bankUnitId);
        int i=0;
        return cameraList;
    }

    public Camera findCameraByID(Long id){
        return this.cameraRepo.getOne(id);
    }

    public void deleteCamera(final Camera camera){
        this.cameraRepo.delete(camera);
    }


}
