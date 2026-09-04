<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.cart.Cart" %>
<%@ page import="com.cart.CartItems" %>
<%@ page import="java.math.BigDecimal" %>

<%
BigDecimal grandTotal = BigDecimal.ZERO;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>

<style>
:root {
    --primary-color: #ff6b35;
    --primary-hover: #e65a2b;
    --secondary-color: #007bff;
    --secondary-hover: #0056b3;
    --success-color: #28a745;
    --success-hover: #218838;
    --danger-color: #dc3545;
    --danger-hover: #bd2130;
    --text-main: #2d3748;
    --text-muted: #718096;
    --bg-main: #f7fafc;
}

body {
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: var(--bg-main);
    color: var(--text-main);
}

.container {
    width: 85%;
    max-width: 1200px;
    margin: 50px auto;
    background: white;
    padding: 40px;
    border-radius: 16px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.05);
}

h1 {
    text-align: center;
    color: #1a202c;
    font-size: 2.5rem;
    font-weight: 700;
    margin-bottom: 40px;
    position: relative;
}

h1::after {
    content: '';
    display: block;
    width: 60px;
    height: 4px;
    background: var(--primary-color);
    margin: 10px auto 0;
    border-radius: 2px;
}

table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 0;
    margin-bottom: 30px;
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 4px 15px rgba(0,0,0,0.02);
}

th {
    background: #1a202c;
    color: white;
    padding: 18px;
    font-weight: 600;
    text-transform: uppercase;
    font-size: 0.85rem;
    letter-spacing: 1px;
    text-align: center;
}

td {
    padding: 20px;
    text-align: center;
    border-bottom: 1px solid #edf2f7;
    color: var(--text-main);
    font-size: 0.95rem;
}

tr:last-child td {
    border-bottom: none;
}

tr:hover td {
    background: #f8fafc;
}

/* Quantity adjustment controls */
.qty-container {
    display: inline-flex;
    align-items: center;
    background: #f1f5f9;
    padding: 4px;
    border-radius: 30px;
}

.qty-btn {
    width: 32px;
    height: 32px;
    border: none;
    background: white;
    color: #1a202c;
    font-size: 16px;
    font-weight: bold;
    border-radius: 50%;
    cursor: pointer;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    transition: all 0.2s ease;
    display: flex;
    align-items: center;
    justify-content: center;
}

.qty-btn:hover {
    background: var(--primary-color);
    color: white;
    transform: scale(1.05);
}

.qty {
    font-size: 16px;
    font-weight: 600;
    margin: 0 15px;
    min-width: 20px;
    display: inline-block;
}

/* Delete / Remove button styling */
.remove-btn {
    background: #fee2e2;
    color: var(--danger-color);
    border: none;
    padding: 8px 16px;
    border-radius: 20px;
    font-weight: 600;
    font-size: 0.85rem;
    cursor: pointer;
    transition: all 0.2s ease;
}

.remove-btn:hover {
    background: var(--danger-color);
    color: white;
    transform: translateY(-1px);
}

/* Total price display styling */
.total {
    text-align: right;
    font-size: 24px;
    margin-top: 30px;
    font-weight: 700;
    color: #1a202c;
}

.total span {
    color: var(--primary-color);
}

/* Action alignment container */
.actions-container {
    display: flex;
    justify-content: flex-end;
    gap: 15px;
    margin-top: 30px;
}

/* Base button animations and styling */
.btn, .btn-add {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    padding: 14px 28px;
    text-decoration: none;
    font-weight: 600;
    border-radius: 30px;
    transition: all 0.2s ease;
    font-size: 0.95rem;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

.btn {
    color: white;
    background: var(--success-color);
}

.btn:hover {
    background: var(--success-hover);
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(40, 167, 69, 0.3);
}

.btn-add {
    color: white;
    background: var(--secondary-color);
}

.btn-add:hover {
    background: var(--secondary-hover);
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(0, 123, 255, 0.3);
}

/* Empty State Styling */
.empty {
    text-align: center;
    padding: 60px 0;
}

.empty h2 {
    color: var(--text-muted);
    font-size: 1.8rem;
    margin-bottom: 20px;
}

.inline-form {
    display: inline;
}
</style>

</head>
<body>

<div class="container">

<h1>Your Cart</h1>


<%

Cart cart = (Cart)session.getAttribute("cart");
Integer restaurantid =(Integer)session.getAttribute("restaurantid");



if(cart == null || cart.getItems().isEmpty()){

%>




<div class="empty">

<h2>Your Cart is Empty</h2>

<p style="color: var(--text-muted); margin-bottom: 30px;">Looks like you haven't added anything to your cart yet.</p>

<a href="reastaurants" class="btn-add">
Continue Shopping
</a>

</div>

<%
}
else {
%>

<table>

<tr>
<th>Menu ID</th>
<th>Item Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Total</th>
<th>Remove</th>
</tr>

<%
for(CartItems item : cart.getItems().values()){
    BigDecimal total = item.getPrice().multiply(BigDecimal.valueOf(item.getQuanity()));
    grandTotal = grandTotal.add(total);
%>

<tr>

<td style="font-weight: 600; color: var(--text-muted);">#<%=item.getMenuid()%></td>

<td style="font-weight: 600; text-align: left; padding-left: 40px;"><%=item.getName()%></td>

<td style="font-weight: 600;">₹ <%=item.getPrice()%></td>

<td>
    <div class="qty-container">
        
        
        <form action="<%=request.getContextPath()%>/cartServlet"
              method="post"
              class="inline-form">

            <input type="hidden" name="action" value="update">
            <input type="hidden" name="menuid" value="<%=item.getMenuid()%>">
            <input type="hidden" name="quantity" value="<%=item.getQuanity()-1%>">
            <input type="hidden" name="restaurantId" value="<%=restaurantid%>">

            <button type="submit" class="qty-btn">-</button>

        </form>
        
        
        
        <span class="qty">
        <%=item.getQuanity()%>
        </span>
        
         <form action="<%=request.getContextPath()%>/cartServlet"
              method="post"
              class="inline-form">

            <input type="hidden" name="action" value="update">
            <input type="hidden" name="menuid" value="<%=item.getMenuid()%>">
            <input type="hidden" name="quantity" value="<%=item.getQuanity()+1%>">
            <input type="hidden" name="restaurantId" value="<%=restaurantid%>">

            <button type="submit" class="qty-btn">+</button>

        </form>
        
        
        
    </div>
</td>

<td style="font-weight: 700; color: #1a202c;">
₹ <%=total%>
</td>

<td>
<form action="<%=request.getContextPath()%>/cartServlet"
      method="post"
      style="margin: 0;">

    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="menuid" value="<%=item.getMenuid()%>">
    <input type="hidden" name="restaurantId" value="<%=restaurantid%>">

    <button type="submit" class="remove-btn">
        Remove
    </button>

</form>
</td>

</tr>

<%
}
%>

</table>

<div class="total">
Total Price: <span>₹ <%=grandTotal%></span>
</div>

<!-- Action Buttons -->
<div class="actions-container">

<a href="MenuServlet?restaurantid=<%=restaurantid%>" class="btn-add">
    Add More Items
</a>

<a href="checkout.jsp" class="btn">
Proceed to Checkout
</a>

</div>

<%
}
%>

</div>

</body>
</html>