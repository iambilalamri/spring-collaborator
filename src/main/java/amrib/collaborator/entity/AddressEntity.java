package amrib.collaborator.entity;

public class AddressEntity {

	private String street;
	private int number;

	public AddressEntity(String street, int number) {
		this.street = street;
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
