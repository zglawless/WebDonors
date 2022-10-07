package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="charities")
public class Charities {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	
	public Charities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Charities(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Charities(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Charities [id=" + id + ", name=" + name + "]";
	}

	
	

}
