package pl.devcezz.batchdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

class PatientItemProcessor implements ItemProcessor<PatientRow, Patient> {

    private static final Logger log = LoggerFactory.getLogger(PatientItemProcessor.class);

    private final PatientService patientService;

    PatientItemProcessor(final PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public Patient process(final PatientRow patientRow) {
        log.info("Processing patient of personal number: " + patientRow.personalNumber());

        boolean insured = patientService.isPatientInsured(patientRow);

        return new Patient(
                patientRow.personalNumber(),
                patientRow.firstName(),
                patientRow.lastName(),
                insured,
                LocalDate.now());
    }
}
