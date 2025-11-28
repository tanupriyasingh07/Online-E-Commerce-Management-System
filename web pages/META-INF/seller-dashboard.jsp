<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<h2>Seller Dashboard</h2>
<h3>Add Product</h3>
<form method="post" action="products">
    <label>Name:</label><input type="text" name="name" required/><br/>
    <label>Description:</label><input type="text" name="description" required/><br/>
    <label>Price:</label><input type="number" step="0.01" name="price" required/><br/>
    <label>Stock:</label><input type="number" name="stock" required/><br/>
    <button type="submit">Add Product</button>
</form>
<jsp:include page="footer.jsp" />
