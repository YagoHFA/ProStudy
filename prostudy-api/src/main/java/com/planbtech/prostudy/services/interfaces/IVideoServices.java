package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.VideoDTO.VideoCadDTO;
import com.planbtech.prostudy.DTO.VideoDTO.VideoDTO;

public interface IVideoServices {

    VideoDTO findById(String id);

    void saveVideo(VideoCadDTO videoDTO);

    void deleteVideo(String id);
}
