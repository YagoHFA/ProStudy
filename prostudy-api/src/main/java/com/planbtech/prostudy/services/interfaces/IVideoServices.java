package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.entities.model.Video;

import java.util.List;

public interface IVideoServices {
    List<List<Video>> listOfVideosbyCategory();
}
