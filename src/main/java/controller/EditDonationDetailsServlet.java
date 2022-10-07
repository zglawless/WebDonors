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
 * Servlet implementation class EditDonationDetailsServlet
 */
@WebServlet("/editDonationDetailsServlet")
public class EditDonationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDonationDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonationDetailsHelper dao = new DonationDetailsHelper();
		DonorHelper dof = new DonorHelper();
		CharityHelper ch = new CharityHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		DonationDetails listToUpdate = dao.searchForDonationDetailsById(tempId);

		String newDonationName = request.getParameter("donationName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String charityName = request.getParameter("charityName");
		int donorId = Integer.parseInt(request.getParameter("donorId"));
		//find our add the new shopper
		Charities newCharity = ch.findCharity(charityName);
		Donors newDonor = dof.searchForDonorById(donorId);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			//items are selected in list to add
			String[] selectedDonors = request.getParameterValues("allDonorsToAdd");
			List<Donors> selectedDonorsInList = new ArrayList<Donors>();

			for (int i = 0; i < selectedDonors.length; i++) {
				System.out.println(selectedDonors[i]);
				Donors d = dof.searchForDonorById(Integer.parseInt(selectedDonors[i]));
				selectedDonorsInList.add(d);

			}
			listToUpdate.setListOfDonors(selectedDonorsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Donors> selectedDonorsInList = new ArrayList<Donors>();
			listToUpdate.setListOfDonors(selectedDonorsInList);
		}

		listToUpdate.setCharityName(newCharity);
		listToUpdate.setDonationDate(ld);
		listToUpdate.setDonor(newDonor);

		dao.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllDonorsServlet").forward(request, response);
	}

}
