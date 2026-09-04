<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.restaurant.Restaurant" %>

<%
List<Restaurant> restaurants =
(List<Restaurant>) request.getAttribute("reastaurants");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuickBite</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
}

body{
    background:#0b0c10; /* Deep premium black */
    color: #eeeeee;
}

/* Header */

.header{
    height:75px;
    background:#1f2833; /* Dark slate header */
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 50px;
    box-shadow:0 4px 20px rgba(0,0,0,.4);
    position: sticky;
    top: 0;
    z-index: 1000;
    border-bottom: 1px solid rgba(255, 255, 255, 0.05);
}

.logo{
    font-size:28px;
    font-weight:bold;
    color:#ff4757; /* Neon vivid red */
    letter-spacing: -0.5px;
}

.nav{
    display:flex;
    align-items:center;
    gap:30px;
}

.nav a{
    text-decoration:none;
    color:#c5a880; /* Elegant muted cream/silver tone */
    font-size:16px;
    font-weight:bold;
    transition:.25s ease;
}

.nav a:hover{
    color:#ff4757;
}

.register-btn{
    background:#ff4757;
    color:white !important;
    padding:10px 22px;
    border-radius:25px;
    box-shadow: 0 4px 15px rgba(255, 71, 87, 0.3);
}

.register-btn:hover{
    background:#e23744;
    transform: translateY(-1px);
    box-shadow: 0 6px 20px rgba(255, 71, 87, 0.5);
}

/* Section Title Container */
.headline-section {
    width: 90%;
    max-width: 1200px;
    margin: 40px auto 10px auto;
}

.headline-section h2 {
    font-size: 28px;
    font-weight: 700;
    color: #ffffff;
}

/* Restaurant Cards */

.container{
    width:90%;
    max-width:1200px;
    margin:20px auto 50px auto;
    display:grid;
    grid-template-columns:repeat(auto-fill,minmax(290px,1fr));
    gap:30px;
}

.restaurant-link{
    text-decoration:none;
    color:inherit;
}

.card{
    background:#1f2833; /* Smooth dark surface */
    border-radius:18px;
    overflow:hidden;
    transition: transform 0.3s cubic-bezier(0.25, 0.8, 0.25, 1), box-shadow 0.3s ease;
    cursor:pointer;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.5);
    border: 1px solid rgba(255, 255, 255, 0.03);
}

.card:hover{
    transform:translateY(-8px);
    box-shadow: 0 15px 35px rgba(255, 71, 87, 0.15); /* Soft neon red glow on hover */
    border-color: rgba(255, 71, 87, 0.3);
}

.img-container {
    width: 100%;
    height: 200px;
    overflow: hidden;
    position: relative;
}

.card img{
    width:100%;
    height:100%;
    object-fit:cover;
    transition: transform 0.5s ease;
}

.card:hover img{
    transform: scale(1.06);
}

.content{
    padding:20px;
}

.name{
    font-size:21px;
    font-weight:bold;
    color: #ffffff;
    margin-bottom: 8px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

.meta-info-group {
    display: flex;
    flex-direction: column;
    gap: 6px;
    margin-bottom: 15px;
}

.cuisine{
    color:#a8b2c1;
    font-size: 14px;
    display: flex;
    align-items: center;
    gap: 6px;
}

.card-divider {
    height: 1px;
    background: rgba(255, 255, 255, 0.08);
    margin-bottom: 15px;
}

.bottom{
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.rating{
    background: rgba(46, 213, 115, 0.15);
    color:#2ed573; /* Vibrant bright green text */
    padding:6px 12px;
    border-radius:8px;
    font-size:14px;
    font-weight: bold;
    border: 1px solid rgba(46, 213, 115, 0.3);
    display: flex;
    align-items: center;
    gap: 4px;
}

.delivery{
    font-weight:bold;
    color:#eeeeee;
    font-size: 14px;
    background: rgba(255, 255, 255, 0.05);
    padding: 6px 12px;
    border-radius: 8px;
}

</style>

</head>

<body>

<!-- Header -->

<div class="header">

    <div class="logo">
        🍔 QuickBite
    </div>

    <div class="nav">

        <a href="<%=request.getContextPath()%>/reastaurants">
            Home
        </a>

           <a href="<%=request.getContextPath()%>/cart.jsp">
          🛒 Cart
         </a>

        <a href="<%=request.getContextPath()%>/login.html">
            Login
        </a>

        <a class="register-btn"
           href="<%=request.getContextPath()%>/register.html">
            Register
        </a>

    </div>

</div>

<!-- Welcome Section Header -->
<div class="headline-section">
    <h2>Premium Cuisines Near You</h2>
</div>

<!-- Restaurant List -->

<div class="container">

<%
if(restaurants != null){
    for(Restaurant r : restaurants){
%>

<a class="restaurant-link"
href="<%=request.getContextPath()%>/MenuServlet?restaurantid=<%=r.getRestaurantid()%>">

    <div class="card">

        <div class="img-container">
            <img
            src="<%=request.getContextPath()%>/restaurantImage?id=<%=r.getRestaurantid()%>"
            alt="<%=r.getName()%>">
        </div>

        <div class="content">

            <div class="name">
                <%=r.getName()%>
            </div>

            <div class="meta-info-group">
                <div class="cuisine">
                    🍽️ <%=r.getCuisine_type()%>
                </div>

                <div class="cuisine">
                    📍 <%=r.getAddress()%>
                </div>
            </div>

            <div class="card-divider"></div>

            <div class="bottom">

                <div class="rating">
                    ⭐ <%=r.getRating()%>
                </div>

                <div class="delivery">
                    🚴 <%=r.getDelivery_time()%> mins
                </div>

            </div>

        </div>

    </div>

</a>

<%
    }
}
%>

</div>

</body>
</html>