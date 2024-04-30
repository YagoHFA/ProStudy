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
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { LoginComponent } from './pages/login/login.component';
import { SecondHeaderComponent } from './components/second-header/second-header.component';
import { RegisterComponent } from './pages/register/register.component';
import { VideopageComponent } from './pages/videopage/videopage.component';
import { LandingpageComponent } from './pages/landingpage/landingpage.component';
import { TestPageComponent } from './pages/test-page/test-page.component';
import { TestListComponent } from './components/test-list/test-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MainHeaderComponent,
    VideoListComponent,
    HomepageComponent,
    VideoComponent,
    CategoryComponent,
    CategoryListComponent,
    LoginComponent,
    SecondHeaderComponent,
    RegisterComponent,
    VideopageComponent,
    LandingpageComponent,
    TestPageComponent,
    TestListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    YouTubePlayerModule,
    HttpClientModule,
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
