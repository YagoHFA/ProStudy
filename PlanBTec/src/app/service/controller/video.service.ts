import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Video } from '../../class/video';
import { ActivatedRoute } from '@angular/router';
import { map, Observable, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VideoService {
  constructor(private http:HttpClient, private route:ActivatedRoute) {

  }
  getVideoById(): Observable<Video> {
    return this.route.queryParams.pipe(
      switchMap(params => {
        const videoId = params['v'];
        const url = `http://localhost:8080/video/${videoId}`;
        return this.http.get<Video>(url);
      })
    );
  }


}
