package io.csanecki.draft.tripdestination.web;

import io.csanecki.draft.tripdestination.api.Country;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Value
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class TripDestinationResource {

  Country destination;

}
