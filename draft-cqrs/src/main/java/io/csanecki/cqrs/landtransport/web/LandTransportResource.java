package io.csanecki.cqrs.landtransport.web;

import io.csanecki.cqrs.draft.DraftId;
import io.csanecki.cqrs.landtransport.api.FormOfTransport;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class LandTransportResource {

  DraftId draftId;

  FormOfTransport formOfTransport;

  public LandTransportResource(
      DraftId draftId,
      FormOfTransport formOfTransport
  ) {
    this.draftId = draftId;
    this.formOfTransport = formOfTransport;
  }

  public DraftId getDraftId() {
    return draftId;
  }

  public void setDraftId(DraftId draftId) {
    this.draftId = draftId;
  }

  public FormOfTransport getFormOfTransport() {
    return formOfTransport;
  }

  public void setFormOfTransport(FormOfTransport formOfTransport) {
    this.formOfTransport = formOfTransport;
  }
}
