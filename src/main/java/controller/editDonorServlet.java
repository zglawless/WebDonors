package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Donors;

/**
 * Servlet implementation class editDonorServlet
 */
@WebServlet("/editDonorServlet")
public class editDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editDonorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DonorHelper dh = new DonorHelper();
		
		String name = request.getParameter("name");
		String amount = request.getParameter("amount");
		double amt = Double.parseDouble(amount);
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Donors donorToUpdate = dh.searchForDonorById(tempId);
		donorToUpdate.setName(name);
		donorToUpdate.setAmount(amt);
		dh.updateDonor(donorToUpdate);
		getServletContext().getRequestDispatcher("/donor-list.jsp").forward(request, response);
	}

}
