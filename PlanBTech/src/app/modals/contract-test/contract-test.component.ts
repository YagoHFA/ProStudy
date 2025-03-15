import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Test } from '../../class/test';
import { Router } from '@angular/router';


@Component({
  selector: 'app-contract-test',
  templateUrl: './contract-test.component.html',
  styleUrls: ['./contract-test.component.css']
})
export class ContractTestComponent {
  constructor(public dialogRef: MatDialogRef<ContractTestComponent>,
    private router:Router,
    @Inject(MAT_DIALOG_DATA) public test: Test,
  ) {}

  redirect(): void {
      this.router.navigate(['/testpage'],{queryParams:{t:this.test.testId}});
    this.dialogRef.close();
  }
}
