import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-login-permission',
  templateUrl: './login-permission.component.html',
  styleUrl: './login-permission.component.css'
})
export class LoginPermissionComponent {
  constructor(public dialogRef: MatDialogRef<LoginPermissionComponent>){}

  close(): void {
    this.dialogRef.close();
  }
}
