package pl.devcezz.notnullexample;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository clientRepository;

    ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    ClientDto validateClient(@RequestBody ClientDto client) {
        return client;
    }

    @PostMapping("/factory")
    ClientDto validateClientWithFactory(@RequestBody ClientDto client) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        validator.validate(client)
                .forEach(System.out::println);

        return client;
    }

    @PostMapping("/valid")
    ClientDto validateClientWithValid(@RequestBody @Valid ClientDto client) {
        return client;
    }

    @PostMapping("/save")
    ClientDto saveClient(@RequestBody ClientDto dto) {
        Client client = new Client();
        client.setFirstname(dto.firstname());
        client.setSurname(dto.surname());

        BankBalance bankBalance = new BankBalance();
        bankBalance.setValue(dto.bankBalance());
        client.setBankBalance(bankBalance);

        clientRepository.save(client);

        CardDto cardDto = new CardDto("1234", dto, null);

        return dto;
    }
}

record ClientDto(@NotNull String firstname,
                 @NotNull String surname,
                 @NotNull Integer bankBalance) {
}
