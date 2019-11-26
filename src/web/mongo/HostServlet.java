package web.mongo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import web.mongo.db.ConnectionManager;
import web.mongo.db.modal.Hostinfo;


/**
 * Servlet implementation class HostServlet
 */
@WebServlet("/HostServlet")
public class HostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostServlet() {
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
		// TODO Auto-generated method stub
		String hostName= request.getParameter("hostname");
		String hostEmail= request.getParameter("hostemail");
		String hostPhone= request.getParameter("hostphone");
		
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("hostvisitor");
		MongoCollection<Document> collection = db.getCollection("hostinfo");
		
		Document d1= new Document("HostName", hostName).append("HostEmail", hostEmail).append("HostPhone", hostPhone);
		
		collection.insertOne(d1);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
