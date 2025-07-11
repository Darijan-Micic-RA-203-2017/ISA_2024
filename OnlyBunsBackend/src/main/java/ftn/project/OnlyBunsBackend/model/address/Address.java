package ftn.project.OnlyBunsBackend.model.address;

public class Address {
	private long id;
	private String streetAndNumber;
	private String postalCode;
	private String populatedPlace;
	private String country;

	public Address() {}

	public Address(long id, String streetAndNumber, String postalCode, String populatedPlace, 
			String country) {
		this.id = id;
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
