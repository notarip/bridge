package ar.com.notarip.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.notarip.bridge.model.Incremental;
import ar.com.notarip.bridge.repository.IncrementalRepository;


@Service(value = "incrementalService")
public class IncrementalService {

	@Autowired
	IncrementalRepository incRepo;
	
	
	public Integer getNext(String name) {

		Incremental inc  = incRepo.findByName(name);
		
		if(inc == null){
			inc = new Incremental();
			inc.setName(name);
			inc.setLast(1);
		}else{
			inc.inc();	
		}
		
		incRepo.save(inc);
		
		return inc.getLast();
	}

}
