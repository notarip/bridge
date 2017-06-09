package ar.com.notarip.bridge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.notarip.bridge.model.Incremental;

public interface  IncrementalRepository extends MongoRepository<Incremental, String>{

	Incremental  findByName(String name);

}