package homework_jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer implements java.io.Serializable{
	@Id
	@Column(name = "cust_num")
	private BigDecimal custNum;
	private String company;
	@Column(name = "cust_rep")
	private BigDecimal custRep;
	@Column(name = "credit_limit")
	private BigDecimal creditLimit;
	
	public Customer() {
	}
	
	public Customer(BigDecimal custNum) {
		this.custNum = custNum;
	}
	
	public Customer(BigDecimal custNum, String company, BigDecimal custRep, BigDecimal creditLimit) {
		this.custNum = custNum;
		this.company = company;
		this.custRep = custRep;
		this.creditLimit = creditLimit;
	}

	public BigDecimal getCustNum() {
		return custNum;
	}
	public void setCustNum(BigDecimal custNum) {
		this.custNum = custNum;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public BigDecimal getCustRep() {
		return custRep;
	}
	public void setCustRep(BigDecimal custRep) {
		this.custRep = custRep;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((creditLimit == null) ? 0 : creditLimit.hashCode());
		result = prime * result + ((custNum == null) ? 0 : custNum.hashCode());
		result = prime * result + ((custRep == null) ? 0 : custRep.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (creditLimit == null) {
			if (other.creditLimit != null)
				return false;
		} else if (!creditLimit.equals(other.creditLimit))
			return false;
		if (custNum == null) {
			if (other.custNum != null)
				return false;
		} else if (!custNum.equals(other.custNum))
			return false;
		if (custRep == null) {
			if (other.custRep != null)
				return false;
		} else if (!custRep.equals(other.custRep))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [custNum=" + custNum + ", company=" + company + ", custRep=" + custRep + ", creditLimit="
				+ creditLimit + "]";
	}
	
	
}
