package io.csanecki.draft.landtransport.web;

import io.csanecki.draft.landtransport.api.FormOfTransport;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Value
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class LandTransportResource {

  FormOfTransport formOfTransport;

}
