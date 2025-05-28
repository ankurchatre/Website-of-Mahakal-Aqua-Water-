<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            width: 100%;
            text-align: center;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        ul li {
            background-color: #e8f5e9;
            margin: 10px 0;
            padding: 10px;
            border-radius: 5px;
            font-size: 16px;
            color: #2e7d32;
        }
        p {
            font-size: 18px;
            color: #333;
            margin-top: 20px;
        }
        @media (max-width: 600px) {
            .container {
                padding: 15px;
            }
            h1 {
                font-size: 24px;
            }
            ul li {
                font-size: 14px;
            }
            p {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <% 
            String name = (String) session.getAttribute("name");
            String address = (String) session.getAttribute("address");
            String phone = (String) session.getAttribute("phone");
            String quantity = (String) session.getAttribute("quantity");
            String date = (String) session.getAttribute("date");
            String deliverytime = (String) session.getAttribute("deliverytime");
            String event = (String) session.getAttribute("event");
        %>
        <h1>Thank You for Your Booking!</h1>
        <p>Here are your booking details:</p>
        <ul>
            <li>Name: <%= name %></li> 
            <li>Address: <%= address %></li>
            <li>Phone: <%= phone %></li>
            <%
                if (event != null) {
                    out.println("<li>Event for: " + event + " Jars</li>");
                }
            %>
            <li>Quantity: <%= quantity %> Jars</li>
            <li>Date: <%= date %></li>
            <li>Delivery Time: <%= deliverytime %></li>
        </ul>
        <p>We've received your order and will deliver your water on time.</p>
    </div>
</body>
</html>