package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.VideoDTO.VideoCadDTO;
import com.planbtech.prostudy.DTO.VideoDTO.VideoDTO;
import com.planbtech.prostudy.DTO.VideoDTO.VideoFullDTO;
import com.planbtech.prostudy.entities.model.Video;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.repositories.VideoRepository;
import com.planbtech.prostudy.services.interfaces.IVideoServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VideosServices implements IVideoServices {
   @Autowired
   private VideoRepository videoRepository;

   @Autowired
   private CategoryReporitory categoryRepository;

   @Transactional
   @Override
   public VideoDTO findById(String id){
       return new VideoDTO(this.videoRepository.findByVideoId(id).orElseThrow(()-> new EntityNotFoundException("Não foi possível encontrar o vídeo")));
   }

   @Transactional
   @Override
   public void saveVideo(VideoCadDTO videoDTO) {
      Video videoToSave = Video.builder()
              .videoId(videoDTO.getVideoId())
              .videoTitle(videoDTO.getVideoTitle())
              .videoThumbnail(videoDTO.getThumb())
              .category(categoryRepository.findByCategoryName(videoDTO.getCategory()).orElseThrow(()-> new EntityNotFoundException("Category not found")))
              .build();
      videoRepository.save(videoToSave);
   }

   @Override
   public void deleteVideo(String id) {
      try{
      videoRepository.deleteById(id);
      }
      catch (Exception e){
            throw new RuntimeException("Não foi possivel deletar o video");
      }
   }

   @Override
   public void updateVideo(VideoFullDTO videoDTO) {
      Video videoToUpdate = videoRepository.findByVideoId(videoDTO.getVideoId()).orElseThrow(()-> new EntityNotFoundException("Não foi possível encontrar o vídeo"));
      videoToUpdate.setVideoTitle(videoDTO.getVideoTitle());
      videoToUpdate.setVideoThumbnail(videoDTO.getThumb());
      videoToUpdate.setCategory(categoryRepository.findByCategoryName(videoDTO.getCategory()).orElseThrow(() -> new EntityNotFoundException("Category not found")));
      videoRepository.save(videoToUpdate);
   }
}
