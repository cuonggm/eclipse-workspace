package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="BIKES")
public class Bike {
	
	@Id
	@GeneratedValue
	@Column(name="BIKE_ID")
	private Long id;
	
	@Column(name="BIKE_NAME")
	private String name;
	
	@Column(name="COLOR")
	private String Color;

	@ManyToOne()
	@JoinColumn(name="owner")
	private Person owner;
	
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

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

}
