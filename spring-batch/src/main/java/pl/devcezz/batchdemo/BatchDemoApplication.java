package pl.devcezz.batchdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.RecordFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

@SpringBootApplication
public class BatchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchDemoApplication.class, args);
	}

}

@Configuration(proxyBeanMethods = false)
@EnableBatchProcessing
class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	PatientService patientService() {
		return new PatientService();
	}

	@Bean
	PatientJobListener listener() {
		return new PatientJobListener();
	}

	@Bean
	FlatFileItemReader<PatientRow> reader() {
		return new FlatFileItemReaderBuilder<PatientRow>()
				.name("patientItemReader")
				.resource(new ClassPathResource("2021_07_19_patients.csv"))
				.delimited()
				.names("personalNumber", "firstName", "lastName")
				.fieldSetMapper(new RecordFieldSetMapper<>(PatientRow.class))
				.build();
	}

	@Bean
	PatientItemProcessor processor(PatientService patientService) {
		return new PatientItemProcessor(patientService);
	}

	@Bean
	public JdbcBatchItemWriter<Patient> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Patient>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql(
					"INSERT INTO patient " +
						"(personal_number, first_name, last_name, insured, admitted_at) " +
					"VALUES " +
						"(:personalNumber, :firstName, :lastName, :insured, :registered)")
				.dataSource(dataSource)
				.build();
	}

	@Bean
	public Job job(PatientJobListener listener, Step step) {
		return jobBuilderFactory.get("patientJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step)
				.end()
				.build();
	}

	@Bean
	public Step step(
			FlatFileItemReader<PatientRow> reader,
			PatientItemProcessor processor,
			JdbcBatchItemWriter<Patient> writer
	) {
		return stepBuilderFactory.get("patientStep")
				.<PatientRow, Patient> chunk(10)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
}