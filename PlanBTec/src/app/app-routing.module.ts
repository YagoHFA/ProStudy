import { NgModule } from '@angular/core';
import { provideRouter, RouterModule, Routes, withComponentInputBinding } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { VideopageComponent } from './pages/videopage/videopage.component';

export const routes: Routes = [{path: "homepage", component: HomepageComponent},
{path: "", redirectTo: "homepage", pathMatch: 'full'},
{path: "login", component: LoginComponent},
{path: "register", component: RegisterComponent},
{path: "videopage/:id", component: VideopageComponent}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers:[provideRouter(routes, withComponentInputBinding())]
})
export class AppRoutingModule {

}
