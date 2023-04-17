import {Injectable} from '@angular/core';
import {SocketClientService} from "./socket-client.service";
import {Observable} from "rxjs";
import {RepeatResponse, SaveToRepeatRequest} from "./app.component.type";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class RepeatableService {

  constructor(private socketClient: SocketClientService) {
  }

  connect(): void {
    this.socketClient.connect();
  }

  disconnect(): void {
    this.socketClient.disconnect();
  }

  save(request: SaveToRepeatRequest) {
    return this.socketClient.send(environment.requestEndpoint, request);
  }

  getRepeatResponse(): Observable<RepeatResponse> {
    return this.socketClient.onMessage(environment.topicEndpoint);
  }
}
