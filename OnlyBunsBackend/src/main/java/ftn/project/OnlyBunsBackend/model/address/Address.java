package ftn.project.OnlyBunsBackend.model.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@SequenceGenerator(name = "address_id_generator", sequenceName = "address_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	private long id;

	@Column(name = "latitude", nullable = false)
	private double latitude;

	@Column(name = "longitude", nullable = false)
	private double longitude;

	@Column(name = "street_and_number", nullable = false)
	private String streetAndNumber;

	@Column(name = "postal_code", nullable = false)
	private String postalCode;

	@Column(name = "populated_place", nullable = false)
	private String populatedPlace;

	@Column(name = "country", nullable = false)
	private String country;

	public Address() {}

	public Address(long id, double latitude, double longitude, String streetAndNumber, 
			String postalCode, String populatedPlace, String country) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.streetAndNumber = streetAndNumber;
		this.postalCode = postalCode;
		this.populatedPlace = populatedPlace;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
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
}
