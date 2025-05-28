package Website;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class Order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String add = req.getParameter("address");
        String quantity = req.getParameter("quantity");
        String event = req.getParameter("event");
        String dateString = req.getParameter("date");

        // Check if the date parameter is not null or empty
       
            LocalDate date = LocalDate.parse(dateString);
            // Format the date to dd/MM/yyyy
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = date.format(formatter);
            String deliverytime= req.getParameter("delivery-time");

            // Display the formatted date and other details
//            resp.setContentType("text/html");
//            PrintWriter out = resp.getWriter();
//            out.println("<html><body>");
//            out.println("<h1>Booking from: " + name + "</h1>");
//            out.println("<h1>Address: " + add + "</h1>");
//            out.println("<h1>Mobile No: " + phone + "</h1>");
//            out.println("<h1>Event: " + event + "</h1>");
//            out.println("<h1>Event Date: " + formattedDate + "</h1>");
//            out.println("<h1>Quantity Required: " + quantity + " Jars</h1>");
//            out.println("</body></html>");
            
            //Sending mail     
            //sendEmail(String message, String subject, String from, String to)
             String massageString="Hello Admin you got order based on 'EVENT TYPE ORDER'\r\n"
             		+"Booking from: " + name + "\r\n"
             		+ "Address: " + add +" \r\n"
             		+ "Mobile No: " + phone+"\r\n"
             		+ "Event:"+event+ "\r\n"
             		+ "Event Date: " + formattedDate +"\r\n"
             		+ "delivery-time : " + deliverytime +"\r\n"
             		+ "Quantity Required: " + quantity + " jars";
             
             String Subject= "YOU GOT EVENT ORDER...";
             String from = "sender@gmail.com";
             String to = "reciver@gmail.com";
             
           SendMail.sendEmail(massageString,Subject,from,to);
           
           HttpSession session=req.getSession();
           session.setAttribute("name",name);
          session.setAttribute("address", add);
          session.setAttribute("phone", phone);
          session.setAttribute("quantity", quantity);
          session.setAttribute("eventname",event);
          session.setAttribute("date", formattedDate);
          session.setAttribute("deliverytime", deliverytime);
         
           // 5. Forward to the JSP (this is the KEY change)
         RequestDispatcher dispatcher=req.getRequestDispatcher("/confirmation.jsp");
         dispatcher.include(req, resp);

        
       
    }
}
