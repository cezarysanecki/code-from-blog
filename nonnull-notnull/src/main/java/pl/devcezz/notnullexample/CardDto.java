package pl.devcezz.notnullexample;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static lombok.AccessLevel.PACKAGE;

@Setter(PACKAGE)
@Getter
public class CardDto {

    @NonNull
    private String cardNumber;
    @NonNull
    private ClientDto owner;
    private Integer CVV;

    public CardDto(@NonNull String cardNumber, @NonNull ClientDto owner) {
        this.cardNumber = cardNumber;
        this.owner = owner;
    }

    public CardDto(@NonNull String cardNumber, @NonNull ClientDto owner, @org.springframework.lang.NonNull Integer CVV) {
        this.cardNumber = cardNumber;
        this.owner = owner;
        this.CVV = CVV;
    }
}
