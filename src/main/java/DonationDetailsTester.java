import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.DonationDetailsHelper;
import model.Charities;
import model.DonationDetails;
import model.Donors;



public class DonationDetailsTester {

	public static void main(String[] args) {
		Charities redCross = new Charities("Red Cross");
		
		//ShopperHelper sh = new ShopperHelper();
		//sh.insertShopper(cameron);
		Donors zak = new Donors("Zak", 5000);
		Donors drew = new Donors("Drew", 5544);
		
		List<Donors> donorItems = new ArrayList<Donors>();
		donorItems.add(zak);
		donorItems.add(drew);
		
		DonationDetailsHelper ldh = new DonationDetailsHelper(); 
		
		DonationDetails redCrossList = new DonationDetails(redCross, LocalDate.now(), zak);
		redCrossList.setListOfDonors(donorItems);
		ldh.insertNewDonationDetails(redCrossList);
		
		
		List<DonationDetails> allLists = ldh.getLists();
		
		for(DonationDetails a : allLists) {
			System.out.println(a.toString());
		}

	}

}
 