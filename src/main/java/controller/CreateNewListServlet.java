package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Charities;
import model.DonationDetails;
import model.Donors;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonorHelper lih = new DonorHelper();
		//String charityName = request.getParameter("charityName");
		Charities charityName = new Charities();
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String donorName = request.getParameter("donorName");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedDonors = request.getParameterValues("allDonorsToAdd");
		List<Donors> selectedDonorsInList = new ArrayList<Donors>();
		
		if(selectedDonors != null && selectedDonors.length > 0){
			for(int i = 0; i<selectedDonors.length; i++) {
				Donors c = lih.searchForDonorById(Integer.parseInt(selectedDonors[i]));
				selectedDonorsInList.add(c);
			}
		}
		
		Donors donor = new Donors();
		
		DonationDetails sld = new DonationDetails(charityName, ld, donor);
		
		sld.setListOfDonors(selectedDonorsInList);
		
		DonationDetailsHelper slh = new DonationDetailsHelper();
		slh.insertNewDonationDetails(sld);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
