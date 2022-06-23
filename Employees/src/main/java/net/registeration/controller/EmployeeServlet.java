package net.registeration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.registeration.dao.EmployeeDao;
import net.registeration.model.employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private EmployeeDao employeeDao = new EmployeeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/views/emplyeeregister.jsp");
		dispatch.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String Employee_id = request.getParameter("id");
		
		employee emp = new employee();
		emp.setName(name);
		emp.setEmployee_id(Employee_id);
		
		try {
		employeeDao.registerEmployee(emp);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/views/emplyeeDetails.jsp");
			dispatch.forward(request,response);
	}

}
