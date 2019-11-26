package web.mongo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/VisitorServlet")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vId= request.getParameter("vid");
		String vName = request.getParameter("vname");
		String vEmail = request.getParameter("vemail");
		String vPhone = request.getParameter("vphone");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    String checkInTime= formatter.format(date);
	    
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("hostvisitor");
		MongoCollection<Document> collection = db.getCollection("visitorinfo");
		
		MongoCursor<Document> cursor1 = collection.find().iterator();
		String idcursor= null;
		if(cursor1.hasNext()== true){
			while(cursor1.hasNext()){
				Document d= (Document) cursor1.next();
				idcursor= d.getString("VisitorId");
			}
		}else{
			idcursor="0";
		}
		
		String recipient =vPhone;
		String message = "Visitor's info:  Visitor Name: "+vName+" Email ID: "+vEmail+" Phone no.: "+vPhone;
		String username = "admin";
		String password = "abc123";
		String originator = "+918109759764";
		String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
		 "username=" + URLEncoder.encode(username, "UTF-8") +
		 "&password=" + URLEncoder.encode(password, "UTF-8") +
		 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
		 "&messagetype=SMS:TEXT" +
		 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
		 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
		 "&serviceprovider=GSMModem1" +
		 "&responseformat=html";
		URL url = new URL(requestUrl);	
		HttpURLConnection uc = (HttpURLConnection)url.openConnection();
		System.out.println(uc.getResponseMessage());
		uc.disconnect();
		
		int t= Integer.parseInt(idcursor)+1;
		String updatedId= String.valueOf(t);
		
		Document d1 = new Document("VisitorId", updatedId).append("VisitorName", vName).append("VisitorEmail", vEmail).append("VisitorPhone", vPhone).append("CheckInTime", checkInTime).append("CheckOutTime", null);

		collection.insertOne(d1);

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

}
