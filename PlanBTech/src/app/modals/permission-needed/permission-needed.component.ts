import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-permission-needed',
  templateUrl: './permission-needed.component.html',
  styleUrl: './permission-needed.component.css'
})
export class PermissionNeededComponent {
  constructor(public dialogRef: MatDialogRef<PermissionNeededComponent>,
              private router: Router
  ) { }

  closeDialog() {
    this.router.navigate(['/login']);
    this.dialogRef.close();
  }
}
