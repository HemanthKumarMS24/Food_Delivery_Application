<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Integer orderid = (Integer) session.getAttribute("orderid");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    background:#f4f4f4;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.container{
    width:450px;
    background:#fff;
    padding:40px;
    border-radius:10px;
    box-shadow:0 5px 15px rgba(0,0,0,0.2);
    text-align:center;
}

.icon{
    font-size:70px;
    color:green;
}

h2{
    margin-top:20px;
    color:#333;
}

p{
    margin-top:15px;
    color:#555;
    font-size:17px;
}

.orderid{
    font-size:18px;
    font-weight:bold;
    color:#ff5722;
    margin-top:15px;
}

.btn{
    display:inline-block;
    margin-top:30px;
    background:#ff5722;
    color:white;
    text-decoration:none;
    padding:12px 30px;
    border-radius:5px;
}

.btn:hover{
    background:#e64a19;
}

</style>

</head>
<body>

<div class="container">

    <div class="icon">✔</div>

    <h2>Order Placed Successfully!</h2>

    <p>Thank you for ordering with us.</p>

    <p>Your delicious food is being prepared.</p>

    <% if(orderid != null){ %>
        <p class="orderid">
            Order ID : <%= orderid %>
        </p>
    <% } %>

    <p>Status : <b>Pending</b></p>

    <a href="reastaurants" class="btn">Continue Ordering</a>

</div>

</body>
</html>