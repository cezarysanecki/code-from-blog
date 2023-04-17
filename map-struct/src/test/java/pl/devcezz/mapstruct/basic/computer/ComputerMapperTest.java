package pl.devcezz.mapstruct.basic.computer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerMapperTest {

    @Test
    void should_map_computer_to_computer_dto() {
        Computer computer = new Computer(
                ProcessorProducer.INTEL,
                "PNY Quadro RTX 5000 16GB GDDR6",
                32
        );

        ComputerDto computerDto = ComputerMapper.INSTANCE.computerToComputerDto(computer);

        assertThat(computerDto.getProcessor()).isEqualTo(ProcessorProducer.INTEL);
        assertThat(computerDto.getGraphicCard()).isEqualTo("PNY Quadro RTX 5000 16GB GDDR6");
        assertThat(computerDto.getRamGb()).isEqualTo(32);
    }

    @Test
    void should_map_computer_dto_to_computer() {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setProcessor(ProcessorProducer.AMD);
        computerDto.setGraphicCard("GIGABYTE GeForce RTX 3080 Turbo LHR 10GB");
        computerDto.setRamGb(64);

        Computer computer = ComputerMapper.INSTANCE.computerDtoToComputer(computerDto);

        assertThat(computer.getProcessor()).isEqualTo(ProcessorProducer.AMD);
        assertThat(computer.getGraphicCard()).isEqualTo("GIGABYTE GeForce RTX 3080 Turbo LHR 10GB");
        assertThat(computer.getRamGb()).isEqualTo(64);
    }
}
