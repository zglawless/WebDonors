package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Donors;

/**
 * Servlet implementation class addDonorServlet
 */
@WebServlet("/addDonorServlet")
public class addDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDonorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String amount = request.getParameter("amount");
		double amt = Double.parseDouble(amount);
		
		
		Donors d = new Donors(name, amt);
		DonorHelper dh = new DonorHelper();
		dh.insertAmount(d);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
