package com.sbt.vap.service;

import com.sbt.vap.model.VideoServer;
import com.sbt.vap.repository.VideoServerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbt.vap.repository.UserRepo;

import java.util.List;

@Service
public class VideoServerService {

    @Autowired
    private VideoServerRepo videoServerRepo;

    public void saveVideoServer(final VideoServer videoServer) {
        this.videoServerRepo.saveAndFlush(videoServer);
    }

    public List<VideoServer> findAll() {
        return this.videoServerRepo.findAll();
    }

    public VideoServer getVideoServerByID(final long id){
        return this.videoServerRepo.getOne(id);
    }

    public void deleteVideoServer(final VideoServer videoServer){
        this.videoServerRepo.delete(videoServer);
    }

}
