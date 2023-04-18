package pl.devcezz.notnullexample;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BankBalance {

    @NotNull
    private Integer value;

    public Integer getValue() {
        return value;
    }

    void setValue(Integer value) {
        this.value = value;
    }
}
