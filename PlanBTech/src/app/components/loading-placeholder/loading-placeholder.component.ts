import { Component } from '@angular/core';

@Component({
  selector: 'app-loading-placeholder',
  templateUrl: './loading-placeholder.component.html',
  styleUrl: './loading-placeholder.component.css'
})
export class LoadingPlaceholderComponent {

  listOfItens1 = [1, 2, 3, 4];
  listOfCategory= [this.listOfItens1,this.listOfItens1]
}

class itemPlaceholder{

}
