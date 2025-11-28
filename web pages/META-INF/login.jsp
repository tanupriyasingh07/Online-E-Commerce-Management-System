<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<h2>Login</h2>
<form method="post" action="login">
    <label>Email:</label><input type="email" name="email" required/><br/>
    <label>Password:</label><input type="password" name="password" required/><br/>
    <button type="submit">Login</button>
</form>
<p style="color:red;">
    ${error}
</p>
<jsp:include page="footer.jsp" />
