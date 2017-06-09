package ar.com.notarip.bridge.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.notarip.bridge.model.PaymentTP;

public interface  PaymentTPRepository extends MongoRepository<PaymentTP, String>{

	PaymentTP findById(String id);

	List<PaymentTP> findAllBy(TextCriteria criteria);

	PaymentTP findByPreferenceId(String id);

	PaymentTP findByPaymentTpId(String id);

}