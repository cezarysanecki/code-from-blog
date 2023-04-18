package pl.devcezz.batchdemo;

class PatientService {

    public boolean isPatientInsured(PatientRow patientRow) {
        return patientRow.personalNumber() % 2 == 0;
    }
}
