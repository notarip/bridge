package ar.com.notarip.bridge.util;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.notarip.bridge.ServiceTPConfig;
import ar.com.todopago.api.ElementNames;
import ar.com.todopago.api.TodoPagoConector;


@Service
public class TPHelper {
	
	
	@Autowired
	ServiceTPConfig serviceConfig;
	
	public TPHelper() {
		// TODO Auto-generated constructor stub
	}

	
	public TodoPagoConector getConnector(){
		
		TodoPagoConector tpc = null;
		try {
			
			tpc = new TodoPagoConector(TodoPagoConector.developerEndpoint, getAuthorization());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tpc;

	}
	

	private Map<String, List<String>> getAuthorization() {
		Map<String, List<String>> parameters = new HashMap<String, List<String>>();
		parameters.put(ElementNames.Authorization,
				Collections.singletonList(serviceConfig.getApiKey()));
		return parameters;
	}

}
