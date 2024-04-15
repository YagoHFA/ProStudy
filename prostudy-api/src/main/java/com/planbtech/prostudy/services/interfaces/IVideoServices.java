package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.VideoDTO;
import com.planbtech.prostudy.entities.model.Video;

import java.util.List;

public interface IVideoServices {
    VideoDTO findById(String id);
}
