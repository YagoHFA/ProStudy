package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.entities.model.Video;
import com.planbtech.prostudy.repositories.VideoRepository;
import com.planbtech.prostudy.services.interfaces.IVideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideosServices implements IVideoServices {
   @Autowired
   private VideoRepository videoRepository;

   @Transactional
   public Video findById(String id){
       System.out.println("teste de pego o valor: " + videoRepository.getReferenceById(id).getVideoTitle());
       return videoRepository.getReferenceById(id);
   }
}
