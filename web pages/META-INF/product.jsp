<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<h2>Products</h2>
<table border="1">
    <tr>
        <th>Name</th><th>Description</th><th>Price</th><th>Stock</th><th>Action</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
            <td>
                <form method="post" action="cart">
                    <input type="hidden" name="productId" value="${p.id}"/>
                    <button type="submit">Add to Cart</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp" />
