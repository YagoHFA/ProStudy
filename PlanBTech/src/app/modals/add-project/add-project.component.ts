import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ProjectService } from '../../service/controller/project.service';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.css']
})
export class AddProjectComponent implements OnInit {
  projectForm: FormGroup = this.fb.group({
    title: ['', Validators.required],
    description: ['', Validators.required],
    tools: ['', Validators.required],
    githubLink: ['', Validators.required]
  });

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<AddProjectComponent>,
    private projectService: ProjectService
  ) {}

  ngOnInit(): void {
    // O código aqui pode ser removido se você inicializar `projectForm` na declaração
  }

  onSubmit(): void {
    if (this.projectForm.valid) {
      this.projectService.createProject(this.projectForm.value["title"],this.projectForm.value["description"], this.projectForm.value["githubLink"]);
    } else {
      this.projectForm.markAllAsTouched(); // Mark all fields as touched to show validation errors
    }
  }

  onCancel(): void {
    this.dialogRef.close();
  }
}
