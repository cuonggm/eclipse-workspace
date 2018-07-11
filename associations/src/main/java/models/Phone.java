package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PHONES")
public class Phone {
	
	@Id
	@GeneratedValue
	@Column(name="PHONE_ID")
	private Long id;
	
	@Column(name="PHONE_NUMBER")
	private Long number;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="OWNER_ID")
	private Person owner;
	
	public Phone() {
		
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
}
