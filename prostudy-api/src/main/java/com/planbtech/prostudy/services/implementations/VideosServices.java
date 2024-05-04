package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.VideoDTO.VideoDTO;
import com.planbtech.prostudy.repositories.VideoRepository;
import com.planbtech.prostudy.services.interfaces.IVideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VideosServices implements IVideoServices {
   @Autowired
   private VideoRepository videoRepository;

   @Transactional
   public VideoDTO findById(String id){
      new VideoDTO(this.videoRepository.findByVideoId(id));
       return new VideoDTO(this.videoRepository.findByVideoId(id));
   }
}
