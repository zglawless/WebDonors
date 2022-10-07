package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DonationDetails {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Charities charityName;
	private LocalDate donationDate;
	private Donors donor;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Donors> listOfDonors;
	
	public DonationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonationDetails(int id, Charities charityName, LocalDate donationDate, Donors donor, List <Donors> listOfDonors) {
		super();
		this.id = id;
		this.charityName = charityName;
		this.donationDate = donationDate;
		this.donor = donor;
		this.listOfDonors = listOfDonors;
		
	}
	
    public DonationDetails(Charities charityName, LocalDate donationDate, Donors donor, List <Donors> listOfDonors) {
		super();
		this.charityName = charityName;
		this.donationDate = donationDate;
		this.donor = donor;
		this.listOfDonors = listOfDonors;
    	
    }
		
	public DonationDetails(Charities charityName, LocalDate donationDate, Donors donor) {
		super();
		this.charityName = charityName;
		this.donationDate = donationDate;
		this.donor = donor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Charities getCharityName() {
		return charityName;
	}

	public void setCharityName(Charities charityName) {
		this.charityName = charityName;
	}

	public LocalDate getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}

	public Donors getDonor() {
		return donor;
	}
	
	public void setDonor(Donors donor) {
		this.donor = donor;
	}

	public void setCharity(Donors donor) {
		this.donor = donor;
	}

	public List<Donors> getListOfDonors() {
		return listOfDonors;
	}

	public void setListOfDonors(List<Donors> listOfDonors) {
		this.listOfDonors = listOfDonors;
	}

	@Override
	public String toString() {
		return "DonationDetails [id=" + id + ", charityName=" + charityName + ", donationDate=" + donationDate
				+ ", donor name=" + donor.getName()  + ", Donor Amount=" + donor.getAmount()+ ", listOfDonors=" + listOfDonors + "]";
	}
	
	
}
