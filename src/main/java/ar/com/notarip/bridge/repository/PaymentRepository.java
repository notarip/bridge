package ar.com.notarip.bridge.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.notarip.bridge.model.Payment;


public interface PaymentRepository extends MongoRepository<Payment, String>{

	Payment findById(String id);

	List<Payment> findAllBy(TextCriteria criteria);

	Payment  findByExternalId(String id);

}
