import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { VideopageComponent } from './pages/videopage/videopage.component';
import { LandingpageComponent } from './pages/landingpage/landingpage.component';
import { TestPageComponent } from './pages/test-page/test-page.component';
import { TesthomeComponent } from './pages/testhome/testhome.component';
import { ResultpageComponent } from './pages/resultpage/resultpage.component';
import { ContractpageComponent } from './pages/contractpage/contractpage.component';
import { ProfilepageComponent } from './pages/profilepage/profilepage.component';

const routes: Routes = [{path: "homepage", component: HomepageComponent},
{path: "", redirectTo: "landingpage", pathMatch: 'full'},
{path: "login", component: LoginComponent},
{path: "register", component: RegisterComponent},
{path: "videopage/watch", component: VideopageComponent},
{path: "landingpage", component:LandingpageComponent},
{path: "testpage", component:TestPageComponent},
{path: "testCatalog", component:TesthomeComponent},
{path: "resultpage", component:ResultpageComponent},
{path: "contractpage", component:ContractpageComponent},
{path: "profilepage", component:ProfilepageComponent},
{path: "**", redirectTo: "landingpage", pathMatch: 'full'}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
