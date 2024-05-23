import { Component, Inject, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ModalTest } from '../../class/model/modal-test';

@Component({
  selector: 'app-message-modal',
  templateUrl: './message-modal.component.html',
  styleUrl: './message-modal.component.css'
})
export class MessageModalComponent {
  constructor(public dialogRef: MatDialogRef<MessageModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ModalTest
  ){}

  close(): void {
    this.dialogRef.close();
  }

  invokeCustomFunction() {

  }
}
