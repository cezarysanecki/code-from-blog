package pl.devcezz.batchdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

class PatientJobListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(PatientJobListener.class);

    @Override
    public void beforeJob(final JobExecution jobExecution) {
        log.info("-----> Job has started <-----");
    }

    @Override
    public void afterJob(final JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("-----> Job has ended successfully <-----");
        } else {
            log.info("-----> Job has ended with error <-----");
        }
    }
}
