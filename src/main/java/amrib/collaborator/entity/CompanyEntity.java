package amrib.collaborator.entity;

import org.springframework.stereotype.Component;

@Component
public class CompanyEntity {

	private AddressEntity address;

    public CompanyEntity(AddressEntity address) {
        this.address = address;
    }

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
    
}
