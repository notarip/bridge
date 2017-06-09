package ar.com.notarip.bridge.model;

import org.springframework.data.annotation.Id;

public class Incremental {
	
	
	@Id
	private String id;
	
	private String name;

	private Integer last;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}
	
	public void inc(){
		this.setLast(getLast()+1);
	}
	

}
