import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainHeaderComponent } from './components/main-header/main-header.component';
import { VideoListComponent } from './components/video-list/video-list.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { VideoComponent } from './components/video/video.component';
import { YouTubePlayerModule } from '@angular/youtube-player';
import { CategoryComponent } from './components/category/category.component';
import { CategoryListComponent } from './components/category-list/category-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MainHeaderComponent,
    VideoListComponent,
    HomepageComponent,
    VideoComponent,
    CategoryComponent,
    CategoryListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    YouTubePlayerModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
