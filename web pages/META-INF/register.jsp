<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<h2>Register as Buyer</h2>
<form method="post" action="register">
    <label>Name:</label><input type="text" name="name" required/><br/>
    <label>Email:</label><input type="email" name="email" required/><br/>
    <label>Password:</label><input type="password" name="password" required/><br/>
    <button type="submit">Register</button>
</form>
<jsp:include page="footer.jsp" />
