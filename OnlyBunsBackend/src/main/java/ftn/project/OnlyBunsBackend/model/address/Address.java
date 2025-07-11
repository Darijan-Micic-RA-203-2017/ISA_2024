package ftn.project.OnlyBunsBackend.model.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ftn.project.OnlyBunsBackend.model.user.User;

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@SequenceGenerator(name = "address_id_generator", sequenceName = "address_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	private long id;

	@Column(name = "street_and_number", nullable = false)
	private String streetAndNumber;

	@Column(name = "postal_code", nullable = false)
	private String postalCode;

	@Column(name = "populated_place", nullable = false)
	private String populatedPlace;

	@Column(name = "country", nullable = false)
	private String country;
	
	@OneToOne(mappedBy = "residenceAddress", fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Address() {}

	public Address(long id, String streetAndNumber, String postalCode, String populatedPlace, 
			String country, User user) {
		this.id = id;
		this.streetAndNumber = streetAndNumber;
		this.postalCode = postalCode;
		this.populatedPlace = populatedPlace;
		this.country = country;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPopulatedPlace() {
		return populatedPlace;
	}

	public void setPopulatedPlace(String populatedPlace) {
		this.populatedPlace = populatedPlace;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
