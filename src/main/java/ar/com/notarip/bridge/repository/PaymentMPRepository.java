package ar.com.notarip.bridge.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.notarip.bridge.model.PaymentMP;

public interface  PaymentMPRepository extends MongoRepository<PaymentMP, String>{

	PaymentMP findById(String id);

	List<PaymentMP> findAllBy(TextCriteria criteria);

	PaymentMP findByPreferenceId(String id);

}