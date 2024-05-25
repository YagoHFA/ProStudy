import { isPlatformBrowser } from '@angular/common';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { Video } from '../../class/video';

@Injectable({
  providedIn: 'root'
})
export class VideolocalstorageService {

  constructor(@Inject(PLATFORM_ID) private plataformId: object) {

  }

  setRecomendation(videos:Video[]){
    if(isPlatformBrowser(this.plataformId)){
      let jsonVideos =  JSON.stringify(videos)
      localStorage.setItem('recomendation',jsonVideos)
    }
  }

  getRecomendation():Video[]{
    if(isPlatformBrowser(this.plataformId)){
      let jsonVideos =  localStorage.getItem('recomendation')
      return jsonVideos ? JSON.parse(jsonVideos) : [];
    }
    return [];
  }
}
