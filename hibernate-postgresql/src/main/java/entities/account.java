package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class account {

	
	
	public account(int accountNumber, customer cust, String accountType, int balance, Date date_opened) {
		super();
		this.accountNumber = accountNumber;
		this.cust = cust;
		this.accountType = accountType;
		this.balance = balance;
		this.date_opened = date_opened;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_number")
	private int accountNumber;
	
	@ManyToOne
    @JoinColumn(name="customer_id")
    private customer cust;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="balance")
	private int balance;
	
	@Column(name="date_opened")
	private Date date_opened;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public customer getCust() {
		return cust;
	}

	public void setCust(customer cust) {
		this.cust = cust;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getDate_opened() {
		return date_opened;
	}

	public void setDate_opened(Date date_opened) {
		this.date_opened = date_opened;
	}

	
}
