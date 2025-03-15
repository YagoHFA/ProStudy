import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Video } from '../../class/video';
import { ActivatedRoute } from '@angular/router';
import { map, Observable, switchMap } from 'rxjs';
import { enviroment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VideoService {
  apiUrl:string = enviroment.apiUrl;
  constructor(private http:HttpClient, private route:ActivatedRoute) {
  }
  getVideoById(): Observable<Video> {
    return this.route.params.pipe(
      switchMap(params => {
        const videoId = params['v'];
        const url = `${this.apiUrl}video/find/${videoId}`;
        return this.http.get<Video>(url);
      })
    );
  }
}
