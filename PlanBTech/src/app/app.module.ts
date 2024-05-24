import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainHeaderComponent } from './components/main-header/main-header.component';
import { VideoListComponent } from './components/video-list/video-list.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { VideoComponent } from './components/video/video.component';
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
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CategoryTestComponent } from './components/category-test/category-test.component';
import { TesthomeComponent } from './pages/testhome/testhome.component';
import { MainFooterComponent } from './components/main-footer/main-footer.component';
import { QuestionComponent } from './components/question/question.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { ResultpageComponent } from './pages/resultpage/resultpage.component';
import { ContractpageComponent } from './pages/contractpage/contractpage.component';
import { BoxresultpageComponent } from './components/boxresultpage/boxresultpage.component';
import { BoxcontractpageComponent } from './components/boxcontractpage/boxcontractpage.component';
import { MatDialogModule} from '@angular/material/dialog'
import { RouterModule } from '@angular/router';
import { TestShowComponent } from './components/test-show/test-show.component';
import { UserlocalstorageService } from './service/localstorage/userlocalstorage.service';
import { CategorylocalstorageService } from './service/localstorage/categorylocalstorage.service';
import { TestlocalstorageService } from './service/localstorage/testlocalstorage.service';
import { VideolocalstorageService } from './service/localstorage/videolocalstorage.service';
import { EmailService } from './service/controller/email.service';
import { TestService } from './service/controller/test.service';
import { HomepageConfigService } from './service/controller/homepageconfig.service';
import { UserService } from './service/controller/user.service';
import { VideoService } from './service/controller/video.service';
import { ProfilepageComponent } from './pages/profilepage/profilepage.component';
import { MessageModalComponent } from './modals/message-modal/message-modal.component';
import {MatButtonModule} from '@angular/material/button';
import { TestFailedComponent } from './modals/test-failed/test-failed.component';



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
    TestListComponent,
    CategoryTestComponent,
    TesthomeComponent,
    MainFooterComponent,
    QuestionComponent,
    ResultpageComponent,
    ContractpageComponent,
    BoxresultpageComponent,
    BoxcontractpageComponent,
    TestShowComponent,
    ProfilepageComponent,
    MessageModalComponent,
    TestFailedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    RouterModule,
    MatButtonModule
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch()),
    provideAnimationsAsync(),
    UserlocalstorageService,
    CategorylocalstorageService,
    TestlocalstorageService,
    VideolocalstorageService,
    EmailService,
    HomepageConfigService,
    TestService,
    UserService,
    VideoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
