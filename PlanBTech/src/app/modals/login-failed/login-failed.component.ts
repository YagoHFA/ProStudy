import { Component } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-login-failed',
  templateUrl: './login-failed.component.html',
  styleUrl: './login-failed.component.css'
})
export class LoginFailedComponent {
  constructor(public dialogRef: MatDialogRef<LoginFailedComponent>){}

  close(): void {
    this.dialogRef.close();
  }
}
