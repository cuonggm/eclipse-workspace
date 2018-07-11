package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="HUMAN")
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name="PERSON_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
//	@JoinTable(name="PERSON_HAS_BIKES", joinColumns=@JoinColumn(
//				name="P_ID",
//				referencedColumnName="PERSON_ID"
//			), inverseJoinColumns=@JoinColumn(
//					name="B_ID",
//					referencedColumnName="BIKE_ID"
//			))
	@OneToMany(mappedBy="owner")
	private List<Bike> bikes = new ArrayList<>();
	
	public Person() {
		
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bike> getBikes() {
		return bikes;
	}
	
	public void addBike(Bike b) {
		bikes.add(b);
		b.setOwner(this);
	}
	
	public void removeBike(Bike b) {
		bikes.remove(b);
		b.setOwner(null);
	}
	
}
