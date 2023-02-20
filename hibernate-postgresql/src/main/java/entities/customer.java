package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class customer {
	
	
	
	public customer() {
	}

	public customer(int customerId, String firstName, String lastName, int tcNo, java.util.Date date,
			String emailAddress) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tcNo = tcNo;
		this.dateOfBirth = (Date) date;
		this.emailAddress = emailAddress;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="tc_no")
	private int tcNo;
	
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@OneToMany(mappedBy = "customer")
	private List<account> accounts;

	@OneToMany(mappedBy = "customer")
	private List<home_address> addresses;

	@OneToMany(mappedBy = "customer")
	private List<phone_number> phones;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTcNo() {
		return tcNo;
	}

	public void setTcNo(int tcNo) {
		this.tcNo = tcNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<account> accounts) {
		this.accounts = accounts;
	}

	public List<home_address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<home_address> addresses) {
		this.addresses = addresses;
	}

	public List<phone_number> getPhones() {
		return phones;
	}

	public void setPhones(List<phone_number> phones) {
		this.phones = phones;
	}
	
	
}
