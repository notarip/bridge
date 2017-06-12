package ar.com.notarip.bridge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.notarip.bridge.model.SmartPayment;

public interface  SmartPaymentRepository extends MongoRepository<SmartPayment, String>{

	SmartPayment  findByName(String name);

}