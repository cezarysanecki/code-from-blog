import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SocketClientState} from "../app.connection-state-enum";
import {SocketClientService} from "../socket-client.service";

@Component({
  selector: 'app-save-word-to-repeat',
  templateUrl: './save-word-to-repeat.component.html',
  styleUrls: ['./save-word-to-repeat.component.css']
})
export class SaveWordToRepeatComponent {

  form: FormGroup = this.formBuilder.group({
    value: ['', Validators.required]
  });

  @Output()
  onRequest: EventEmitter<any> = new EventEmitter();

  constructor(private formBuilder: FormBuilder) {
    this.form.disable();
    SocketClientService.connectionState$.subscribe(state => {
      state === SocketClientState.CONNECTED ? this.form.enable() : this.form.disable();
    })
  }

  onSubmit(): void {
    this.onRequest.emit({value: this.form.controls['value'].value});
    this.form.reset();
  }

}
