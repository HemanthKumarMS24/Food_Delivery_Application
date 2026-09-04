
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.cart.Cart"%>
<%@ page import="com.cart.CartItems"%>
<%@ page import="java.math.BigDecimal"%>

<%
Cart cart = (Cart) session.getAttribute("cart");
Integer restaurantid =(Integer)session.getAttribute("restaurantid");

if(cart == null || cart.getItems().isEmpty()){
    response.sendRedirect("cart.jsp");
    return;
}

BigDecimal itemTotal = BigDecimal.ZERO;
BigDecimal deliveryFee = new BigDecimal("20");
BigDecimal platformFee = new BigDecimal("5");

for(CartItems item : cart.getItems().values()){
    BigDecimal total = item.getPrice().multiply(BigDecimal.valueOf(item.getQuanity()));
    itemTotal = itemTotal.add(total);
}

BigDecimal grandTotal = itemTotal.add(deliveryFee).add(platformFee);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- Font Awesome Icons CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            /* Rich deep space gradient */
            background: radial-gradient(circle at 50% 50%, #1e1b4b 0%, #0f0720 100%);
            min-height: 100vh;
        }
        /* Custom scrollbar for order items list */
        .custom-scrollbar::-webkit-scrollbar {
            width: 6px;
        }
        .custom-scrollbar::-webkit-scrollbar-track {
            background: rgba(255, 255, 255, 0.05);
            border-radius: 10px;
        }
        .custom-scrollbar::-webkit-scrollbar-thumb {
            background: #ff6b35;
            border-radius: 10px;
        }
    </style>
</head>
<body class="font-sans antialiased text-slate-100">

    <div class="max-w-6xl mx-auto px-4 py-10">
        
        <!-- Page Heading with Glowing Accents -->
        <div class="text-center mb-10">
            <h1 class="text-4xl sm:text-5xl font-extrabold tracking-tight bg-gradient-to-r from-orange-400 via-pink-500 to-indigo-400 bg-clip-text text-transparent drop-shadow-md">
                Secure Checkout
            </h1>
            <p class="mt-3 text-slate-400 max-w-md mx-auto text-sm sm:text-base">
                Review your items and complete your order inside our highly secure portal.
            </p>
        </div>

        <!-- Two-Column Layout -->
        <div class="grid grid-cols-1 lg:grid-cols-12 gap-8 items-start">
            
            <!-- Left Side: Delivery Details Form (Translucent Obsidian Card) -->
            <div class="lg:col-span-7 bg-slate-900/60 backdrop-blur-xl p-6 sm:p-8 rounded-3xl border border-slate-800 shadow-2xl shadow-indigo-950/50">
                <h2 class="text-2xl font-bold text-[#ff6b35] mb-6 flex items-center gap-3">
                    <i class="fa-solid fa-truck-fast drop-shadow-[0_0_8px_rgba(255,107,53,0.4)]"></i> Delivery Details
                </h2>
                
                <form action="<%=request.getContextPath()%>/OrderServlet" method="post" class="space-y-5">
                
                <input type="hidden"
       name="restaurantid"
       value="<%=restaurantid%>">


<input type="hidden"
       name="totalamount"
       value="<%=grandTotal%>">
      
      
      
<%
for(CartItems item : cart.getItems().values()) {
%>

<input type="hidden"
       name="menuid"
       value="<%=item.getMenuid()%>">


<input type="hidden"
       name="quantity"
       value="<%=item.getQuanity()%>">


<input type="hidden"
       name="price"
       value="<%=item.getPrice()%>">


<%
}
%>



                    
                    <div>
                        <label class="block text-xs font-semibold uppercase tracking-wider text-slate-400 mb-1.5">Full Name</label>
                        <input type="text" name="name" required placeholder="John Doe"
                               class="w-full px-4 py-3 bg-slate-950/60 border border-slate-700/80 rounded-xl focus:ring-2 focus:ring-[#ff6b35]/70 focus:border-transparent text-white placeholder-slate-500 outline-none transition">
                    </div>

                    <div>
                        <label class="block text-xs font-semibold uppercase tracking-wider text-slate-400 mb-1.5">Phone Number</label>
                        <input type="text" name="phone" required placeholder="+91 XXXXX XXXXX"
                               class="w-full px-4 py-3 bg-slate-950/60 border border-slate-700/80 rounded-xl focus:ring-2 focus:ring-[#ff6b35]/70 focus:border-transparent text-white placeholder-slate-500 outline-none transition">
                    </div>

                    <div>
                        <label class="block text-xs font-semibold uppercase tracking-wider text-slate-400 mb-1.5">Delivery Address</label>
                        <textarea rows="3" name="address" required placeholder="Flat, House no., Building, Company, Apartment"
                                  class="w-full px-4 py-3 bg-slate-950/60 border border-slate-700/80 rounded-xl focus:ring-2 focus:ring-[#ff6b35]/70 focus:border-transparent text-white placeholder-slate-500 outline-none transition resize-none"></textarea>
                    </div>

                    <div class="grid grid-cols-1 sm:grid-cols-2 gap-4">
                        <div>
                            <label class="block text-xs font-semibold uppercase tracking-wider text-slate-400 mb-1.5">City</label>
                            <input type="text" name="city" required placeholder="Bengaluru"
                                   class="w-full px-4 py-3 bg-slate-950/60 border border-slate-700/80 rounded-xl focus:ring-2 focus:ring-[#ff6b35]/70 focus:border-transparent text-white placeholder-slate-500 outline-none transition">
                        </div>
                        <div>
                            <label class="block text-xs font-semibold uppercase tracking-wider text-slate-400 mb-1.5">Pincode</label>
                            <input type="text" name="pincode" required placeholder="560001"
                                   class="w-full px-4 py-3 bg-slate-950/60 border border-slate-700/80 rounded-xl focus:ring-2 focus:ring-[#ff6b35]/70 focus:border-transparent text-white placeholder-slate-500 outline-none transition">
                        </div>
                    </div>

                    <div>
                        <label class="block text-xs font-semibold uppercase tracking-wider text-slate-400 mb-1.5">Payment Method</label>
                        <div class="relative">
                            <select name="paymentmode" 
                                    class="w-full px-4 py-3 bg-slate-950/60 border border-slate-700/80 rounded-xl focus:ring-2 focus:ring-[#ff6b35]/70 focus:border-transparent text-white outline-none transition appearance-none cursor-pointer">
                                <option value="Cash On Delivery" class="bg-slate-950 text-white">💵 Cash On Delivery</option>
                                <option value="UPI" class="bg-slate-950 text-white">📱 UPI</option>
                                <option value="Credit Card" class="bg-slate-950 text-white">💳 Credit Card</option>
                                <option value="Debit Card" class="bg-slate-950 text-white">💳 Debit Card</option>
                            </select>
                            <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-4 text-slate-400">
                                <i class="fa-solid fa-chevron-down text-xs"></i>
                            </div>
                        </div>
                    </div>

                    <!-- Vibrant Emerald Action Button -->
                    <button class="w-full mt-8 bg-gradient-to-r from-emerald-500 to-teal-600 hover:from-emerald-600 hover:to-teal-700 text-white font-extrabold py-4 px-4 rounded-2xl shadow-lg shadow-emerald-950/60 hover:shadow-emerald-900/50 transition transform hover:-translate-y-0.5 active:translate-y-0 flex items-center justify-center gap-2 text-lg tracking-wide">
                        <i class="fa-solid fa-circle-check"></i> Place Order
                    </button>
                    
                </form>
            </div>

            <!-- Right Side: Order Summary Card (Contrast Neon Blue Container) -->
            <div class="lg:col-span-5 bg-gradient-to-b from-slate-900/80 to-slate-950/90 backdrop-blur-xl rounded-3xl border border-indigo-950/80 shadow-2xl overflow-hidden">
                <div class="p-6 sm:p-8 border-b border-slate-800/80 bg-slate-900/40">
                    <h2 class="text-2xl font-bold text-[#ff6b35] flex items-center gap-3 m-0">
                        <i class="fa-solid fa-basket-shopping drop-shadow-[0_0_8px_rgba(255,107,53,0.4)]"></i> Order Summary
                    </h2>
                </div>
                
                <div class="p-6 sm:p-8 space-y-6">
                    
                    <!-- Dynamic Cart Items Loop -->
                    <div class="divide-y divide-slate-800 max-h-[250px] overflow-y-auto pr-2 custom-scrollbar">
                        <%
                        for(CartItems item : cart.getItems().values()){
                        BigDecimal total = item.getPrice().multiply(BigDecimal.valueOf(item.getQuanity()));
                        %>
                        <div class="py-4 flex justify-between items-center first:pt-0 last:pb-0">
                            <div>
                                <h4 class="font-bold text-slate-200 tracking-wide"><%=item.getName()%></h4>
                                <p class="text-xs text-[#ff6b35] font-medium mt-0.5">Quantity: <%=item.getQuanity()%></p>
                            </div>
                            <span class="font-extrabold text-indigo-300">₹ <%=total%></span>
                        </div>
                        <%
                        }
                        %>
                    </div>

                    <!-- Pricing Details -->
                    <div class="border-t border-slate-800 pt-4 space-y-3.5">
                        <div class="flex justify-between text-sm text-slate-400">
                            <span>Item Total</span>
                            <span class="font-semibold text-slate-200">₹ <%=itemTotal%></span>
                        </div>
                        <div class="flex justify-between text-sm text-slate-400">
                            <span>Delivery Fee</span>
                            <span class="font-semibold text-slate-200">₹ <%=deliveryFee%></span>
                        </div>
                        <div class="flex justify-between text-sm text-slate-400">
                            <span>Platform Fee</span>
                            <span class="font-semibold text-slate-200">₹ <%=platformFee%></span>
                        </div>
                        
                        <!-- Grand Total Glowing Row -->
                        <div class="flex justify-between text-2xl font-black border-t border-slate-800 pt-5 text-[#ff6b35] drop-shadow-[0_0_12px_rgba(255,107,53,0.2)]">
                            <span>Grand Total</span>
                            <span>₹ <%=grandTotal%></span>
                        </div>
                    </div>

                    <!-- Trust Seal -->
                    <div class="flex items-center gap-2 text-[11px] uppercase tracking-wider text-slate-500 justify-center bg-slate-950/40 py-2.5 rounded-xl border border-slate-800/50">
                        <i class="fa-solid fa-shield-halved text-emerald-500 text-sm"></i>
                        <span>100% Secure Checkout Session</span>
                    </div>

                </div>
            </div>
            
        </div>
    </div>

</body>
</html>