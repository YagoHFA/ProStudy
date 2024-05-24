import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-test-failed',
  templateUrl: './test-failed.component.html',
  styleUrl: './test-failed.component.css'
})
export class TestFailedComponent {

  constructor(public dialogRef:MatDialogRef<TestFailedComponent>,
              @Inject(MAT_DIALOG_DATA) public data: string,
              private router:Router
  ) { }

  //function to try again
  tryAgain(){
    this.router.navigate(['/testCatalog']);
    this.dialogRef.close();
  }
}
