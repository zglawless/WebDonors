package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Donors;
/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		String act = request.getParameter("doThisToDonor");
		String path = "/viewAllDonorsServlet";
		DonorHelper dh = new DonorHelper();

		
		if(act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Donors donorToDelete = dh.searchForDonorById(tempId);
			dh.deleteDonor(donorToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a donor");
			}
		}
		else if(act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Donors donorToEdit = dh.searchForDonorById(tempId);
			request.setAttribute("donorToEdit", donorToEdit);
			path = "/edit-donor.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a donor");
				
			}
		}
		else if(act.equals("add")) {	
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
		}
	}

