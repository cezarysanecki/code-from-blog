package pl.devcezz.batchdemo;

public record PatientRow(
        Integer personalNumber,
        String firstName,
        String lastName
) {}
