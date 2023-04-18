package pl.devcezz.notnullexample;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Client {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private String firstname;

    @NotNull
    private String surname;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "bankBalance"))
    )
    @Valid
    private BankBalance bankBalance;

    public String getFirstname() {
        return firstname;
    }

    void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    public BankBalance getBankBalance() {
        return bankBalance;
    }

    void setBankBalance(BankBalance bankBalance) {
        this.bankBalance = bankBalance;
    }
}
