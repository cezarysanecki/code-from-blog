import {Component} from '@angular/core';
import {RepeatableService} from "./repeatable.service";
import {RepeatResponse, SaveToRepeatRequest} from "./app.component.type";
import {SocketClientService} from "./socket-client.service";
import {SocketClientState} from "./app.connection-state-enum";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  webSocketConnected: boolean = false;
  repeatResponses: RepeatResponse[] = [];

  constructor(private service: RepeatableService) {
    SocketClientService.connectionState$.subscribe(state => {
      this.webSocketConnected = state === SocketClientState.CONNECTED;
    })
  }

  connect(): void {
    this.service.connect();
    this.service.getRepeatResponse()
      .subscribe(repeatResponse => this.repeatResponses.push(repeatResponse));
  }

  disconnect(): void {
    this.service.disconnect();
    this.repeatResponses = [];
  }

  createRequest(request: SaveToRepeatRequest): void {
    this.service.save(request);
  }
}
