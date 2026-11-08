package lab.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
import java.io.PrintWriter; 
/**
 * Servlet implementation class StudList
 */

public class StudList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudList() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)     
    throws ServletException, IOException { 

    request.setCharacterEncoding("utf-8"); 

    String name = request.getParameter("name"); 

    response.setContentType("text/html;charset=UTF-8"); 

    PrintWriter out = response.getWriter(); 
            try { 
                out.println("<html>"); 
                out.println("<head><title>Список абитуриентов</title></head>"); 
                out.println("<body>"); 
                out.println("<h1>Список абитуриентов " + (name != null ? name : "без имени") + "</h1>"); 
                out.println("<table border='1'>"); 
                out.println("<tr><td><b>ФИО</b></td><td><b>Факультет</b></td><td><b>Зачислен</b></td></tr>"); 
                out.println("<tr><td>Иванов И. И.</td><td>ФКТИ</td><td>Да</td></tr>"); 
                out.println("<tr><td>Петров П. П.</td><td>ФРТ</td><td>Нет</td></tr>"); 
                out.println("</table>"); 
                out.println("</body>"); 
                out.println("</html>"); 
            } finally { 
                out.close(); 
            } 
        }
    
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
