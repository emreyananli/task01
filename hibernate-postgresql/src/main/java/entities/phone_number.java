package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phone_number")
public class phone_number {
	
	
	
	public phone_number(int phoneNumberId, customer cust, String phoneNumberType, String phoneNumber) {
		super();
		this.phoneNumberId = phoneNumberId;
		this.cust = cust;
		this.phoneNumberType = phoneNumberType;
		this.phoneNumber = phoneNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="phone_number_id")
	private int phoneNumberId;
	
	@ManyToOne
    @JoinColumn(name="customer_id")
    private customer cust;
	
	@Column(name="phone_number_type")
	private String phoneNumberType;
	
	@Column(name="phone_number")
	private String phoneNumber;

	public int getPhoneNumberId() {
		return phoneNumberId;
	}

	public void setPhoneNumberId(int phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}

	public customer getCust() {
		return cust;
	}

	public void setCust(customer cust) {
		this.cust = cust;
	}

	public String getPhoneNumberType() {
		return phoneNumberType;
	}

	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
