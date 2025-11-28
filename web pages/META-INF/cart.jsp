<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<h2>Your Cart</h2>
<c:choose>
    <c:when test="${empty cart}">
        <p>No items in cart.</p>
    </c:when>
    <c:otherwise>
        <table border="1">
            <tr>
                <th>Product</th><th>Quantity</th><th>Price</th><th>Total</th>
            </tr>
            <c:set var="grandTotal" value="0"/>
            <c:forEach var="entry" items="${cart}">
                <c:set var="item" value="${entry.value}"/>
                <tr>
                    <td>${item.product.name}</td>
                    <td>${item.quantity}</td>
                    <td>${item.product.price}</td>
                    <td>${item.totalPrice}</td>
                </tr>
                <c:set var="grandTotal" value="${grandTotal + item.totalPrice}"/>
            </c:forEach>
        </table>
        <p>Grand Total: ${grandTotal}</p>
        <form method="post" action="checkout">
            <button type="submit">Checkout</button>
        </form>
    </c:otherwise>
</c:choose>
<jsp:include page="footer.jsp" />
