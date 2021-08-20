package com.avroproducer.producer;

import com.local.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	private KafkaProducer kafkaProducer;
	@Bean
	public CommandLineRunner demo(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				User user = User.newBuilder().setFirstName("Abhishek").setLastName("Paithane").setEmail("abhishekpaithane@gmail.com")
				.build();
				ProducerRecord record = new ProducerRecord("test12345","key123", user);
				kafkaProducer.send(record);
			}
		};
	}
}
