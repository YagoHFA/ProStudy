package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.VideoDTO.VideoDTO;

public interface IVideoServices {
    VideoDTO findById(String id);
}
