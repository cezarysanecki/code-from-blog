package io.csanecki.draft.section;

public enum SectionAvailability {

  READ_ONLY,
  EDITABLE;

  public boolean isEditable() {
    return this == EDITABLE;
  }

  public boolean isReadOnly() {
    return this == READ_ONLY;
  }

}
