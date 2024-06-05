import { Component, Input, OnInit } from '@angular/core';
import { Test } from '../../class/test';
import { MatDialog } from '@angular/material/dialog';
import { ContractTestComponent } from '../../modals/contract-test/contract-test.component';
import { UserlocalstorageService } from '../../service/localstorage/userlocalstorage.service';
import { PermissionNeededComponent } from '../../modals/permission-needed/permission-needed.component';

@Component({
  selector: 'app-test-show',
  templateUrl: './test-show.component.html',
  styleUrl: './test-show.component.css'
})
export class TestShowComponent implements OnInit {
  constructor(private dialogRef:MatDialog,
              private userLocalStorage: UserlocalstorageService
  ) { }
  ngOnInit(): void {

  }
  @Input() test: Test = new Test();

  openContractDialog(){
    if(this.userLocalStorage.getUserName() == null || this.userLocalStorage.getUserName() == ''){
      this.dialogRef.open(PermissionNeededComponent)
    }
    else{
    this.dialogRef.open(ContractTestComponent,{
      data : this.test
    });
    }
  }
}
