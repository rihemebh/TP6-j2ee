package article;



import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.articleDAO;


/**
 * Servlet implementation class Controlleur
 */
@WebServlet("/Controleur")
public class RechercheArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GetArticles metier;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheArticle() {  
    	super();
    	metier = new GetArticles();
      
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
		String mc=request.getParameter("name");  
		
		int mc1;
		try {
			mc1= Integer.parseInt(request.getParameter("code"));  
		}catch (NumberFormatException e) {
			mc1=0;
			
		}
		
	
		List<Article> articles;
		try {
			articles = metier.getProduitsParMotCle(mc1,mc);
			if(articles.isEmpty()) {
				request.getRequestDispatcher("ArticleInexistant.jsp").forward(request,response);
			}
			else {
		
			request.setAttribute("articles", articles);
			Cookie cookie=new Cookie ("cookie", URLEncoder.encode("l’article recherché existe", "UTF-8")) ;
			response.addCookie(cookie) ;
			request.getRequestDispatcher("Articles.jsp").forward(request,response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
