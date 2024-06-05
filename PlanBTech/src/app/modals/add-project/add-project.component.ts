import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrl: './add-project.component.css'
})
export class AddProjectComponent {
  project = {
    title: '',
    description: '',
    tools: '',
    githubLink: ''
  };

  constructor(public dialogRef: MatDialogRef<AddProjectComponent>) {}

  onSubmit(): void {
    console.log('Project data:', this.project);
    this.dialogRef.close();
  }

  onCancel(): void {
    this.dialogRef.close();
  }
}
