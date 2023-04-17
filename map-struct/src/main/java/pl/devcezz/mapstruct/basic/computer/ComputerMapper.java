package pl.devcezz.mapstruct.basic.computer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComputerMapper {

    ComputerMapper INSTANCE = Mappers.getMapper(ComputerMapper.class);

    ComputerDto computerToComputerDto(Computer computer);

    Computer computerDtoToComputer(ComputerDto computer);
}
