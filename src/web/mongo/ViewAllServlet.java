package web.mongo;

import java.io.IOException;
import java.util.LinkedList;

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
import web.mongo.db.modal.VisitorInfo;

/**
 * Servlet implementation class ViewAllServlet
 */
@WebServlet("/ViewAllServlet")
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("hostvisitor");
		MongoCollection<Document> collection = db.getCollection("visitorinfo");
		
		LinkedList<VisitorInfo> dataList = new LinkedList<>();

		MongoCursor<Document> cursor = collection.find().iterator();

		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();
				VisitorInfo v = new VisitorInfo(d.getString("VisitorId"),d.getString("VisitorName"), d.getString("VisitorEmail"), d.getString("VisitorPhone"), d.getString("CheckInTime"), d.getString("CheckOutTime"));
				dataList.add(v);
			}
		
		request.setAttribute("list", dataList);
	
		request.getRequestDispatcher("viewall.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
