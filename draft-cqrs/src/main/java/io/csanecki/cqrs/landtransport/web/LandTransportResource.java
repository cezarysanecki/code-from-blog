package io.csanecki.cqrs.landtransport.web;

import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Getter
@ResponseBody
public class LandTransportResource {

  FormOfTransport formOfTransport;

  public LandTransportResource(FormOfTransport formOfTransport) {
    this.formOfTransport = formOfTransport;
  }
}
