import { Component, Inject, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ModalTest } from '../../class/model/modal-test';
import { Test } from '../../class/test';
import { TestService } from '../../service/controller/test.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-message-modal',
  templateUrl: './message-modal.component.html',
  styleUrl: './message-modal.component.css'
})
export class MessageModalComponent {
  constructor(public dialogRef: MatDialogRef<MessageModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ModalTest,
    private testService:TestService,
    private router:Router
  ){}

  close(): void {
    this.testService.concluirTest(this.data.testId)
    this.router.navigate(['/testCatalog']);
    this.dialogRef.close();
  }

}
