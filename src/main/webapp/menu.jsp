<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.menu.Menu" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>

<style>
:root {
    --primary-color: #ff6b35;
    --primary-hover: #e65a2b;
    --text-main: #2d3748;
    --text-muted: #718096;
    --bg-main: #f7fafc;
    --success-color: #28a745;
    --danger-color: #dc3545;
}

body {
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: var(--bg-main);
    color: var(--text-main);
}

.container {
    width: 90%;
    max-width: 1200px;
    margin: 50px auto;
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

/* Grid Layout for Cards */
.menu-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
    gap: 30px;
    margin-top: 20px;
}

/* Premium Card Styles */
.card {
    background: white;
    border-radius: 16px;
    overflow: hidden;
    box-shadow: 0 10px 25px rgba(0,0,0,0.05);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    display: flex;
    flex-direction: column;
    position: relative;
}

.card:hover {
    transform: translateY(-8px);
    box-shadow: 0 15px 35px rgba(0,0,0,0.1);
}

/* Image Container and Hover Zoom */
.image-container {
    width: 100%;
    height: 240px;
    overflow: hidden;
    position: relative;
}

.card img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.5s ease;
}

.card:hover img {
    transform: scale(1.08);
}

/* Status Badge Overlays */
.status-badge {
    position: absolute;
    top: 15px;
    right: 15px;
    padding: 6px 14px;
    border-radius: 20px;
    font-size: 0.75rem;
    font-weight: 700;
    text-transform: uppercase;
    letter-spacing: 0.5px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.15);
    z-index: 10;
}

.status-badge.available {
    background: var(--success-color);
    color: white;
}

.status-badge.notavailable {
    background: var(--danger-color);
    color: white;
}

/* Category Tag Overlay */
.category-badge {
    position: absolute;
    bottom: 15px;
    left: 15px;
    background: rgba(26, 32, 44, 0.85);
    color: white;
    padding: 4px 12px;
    border-radius: 30px;
    font-size: 0.75rem;
    font-weight: 600;
}

/* Card Content Details */
.content {
    padding: 24px;
    display: flex;
    flex-direction: column;
    flex-grow: 1;
}

.card h2 {
    margin: 0 0 10px;
    font-size: 1.35rem;
    color: #1a202c;
    font-weight: 600;
    line-height: 1.4;
}

.card .description {
    color: var(--text-muted);
    font-size: 0.9rem;
    line-height: 1.6;
    margin: 0 0 15px;
    flex-grow: 1;
}

.price-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: auto;
    padding-top: 15px;
    border-top: 1px solid #edf2f7;
}

.price {
    color: #1a202c;
    font-weight: 700;
    font-size: 1.35rem;
}

/* Add to Cart Action Button */
.add-btn {
    width: 100%;
    padding: 12px 20px;
    background: var(--primary-color);
    color: white;
    border: none;
    border-radius: 30px;
    font-weight: 600;
    font-size: 0.95rem;
    cursor: pointer;
    transition: all 0.2s ease;
    margin-top: 15px;
    box-shadow: 0 4px 12px rgba(255, 107, 53, 0.2);
}

.add-btn:hover {
    background: var(--primary-hover);
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(255, 107, 53, 0.35);
}

/* Styles for Unavailable State Button */
.add-btn:disabled {
    background: #cbd5e1;
    color: #94a3b8;
    cursor: not-allowed;
    box-shadow: none;
    transform: none;
}

/* Empty State Design */
.empty-menu {
    text-align: center;
    padding: 80px 0;
    background: white;
    border-radius: 16px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.05);
}

.empty-menu h2 {
    color: var(--text-muted);
    font-size: 1.8rem;
    margin-bottom: 10px;
}
</style>

</head>

<body>

<div class="container">

<h1>Our Delicious Menu</h1>

<%
List<Menu> menus = (List<Menu>)request.getAttribute("menus");

if(menus != null && !menus.isEmpty()){
%>

<div class="menu-grid">

<%
    for(Menu menu : menus){
%>

<div class="card">

    <div class="image-container">
        <!-- Availability Badges -->
        <% if(menu.getIsavailable()){ %>
            <div class="status-badge available">Available</div>
        <% } else { %>
            <div class="status-badge notavailable">Unavailable</div>
        <% } %>

        <!-- Category Tag -->
        <div class="category-badge">
            <%=menu.getCategory()%>
        </div>

        <img src="<%=request.getContextPath()%>/MenuImageServlet?id=<%=menu.getMenuid()%>"
             alt="<%=menu.getItemname()%>">
    </div>

    <div class="content">

        <h2><%=menu.getItemname()%></h2>

        <p class="description"><%=menu.getDescription()%></p>

        <div class="price-row">
            <span style="font-size: 0.9rem; color: var(--text-muted); font-weight: 500;">Price</span>
            <span class="price">₹ <%=menu.getPrice()%></span>
        </div>

        <form action="<%=request.getContextPath()%>/cartServlet" method="post" style="margin: 0; width: 100%;">
            <input type="hidden" name="menuid" value="<%= menu.getMenuid() %>">
            <input type="hidden" name="restaurantId" value="<%= menu.getRestaurantid() %>">
            <input type="hidden" name="quantity" value="1">
            <input type="hidden" name="action" value="add">

            <% if(menu.getIsavailable()){ %>
                <button type="submit" class="add-btn">Add to Cart</button>
            <% } else { %>
                <button type="button" class="add-btn" disabled>Sold Out</button>
            <% } %>
        </form>

    </div>

</div>

<%
    }
%>

</div>

<%
}
else{
%>

<div class="empty-menu">
    <h2>No Menu Items Found</h2>
    <p style="color: var(--text-muted);">Please check back later or explore other options!</p>
</div>

<%
}
%>

</div>

</body>
</html>