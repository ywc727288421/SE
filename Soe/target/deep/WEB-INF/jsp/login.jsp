<%--
  Created by IntelliJ IDEA.
  User: 10129
  Date: 2019/10/31
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>教材征订与发放管理系统</title>
    <link rel="stylesheet" href="assets/css/auth.css">
</head>

<body>
<div class="lowin">
    <div class="lowin-brand">
        <img src="assets/image/kodinger.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form name="form" accept-charset="UTF-8" method="post"
                      enctype="application/x-www-form-urlencoded" action="${pageContext.request.contextPath}/log">
                    <p>登录以继续</p>
                    <div class="lowin-group">
                        <label>用户身份 </label>
                        <select class="lowin-input" name="identity">
                            <option value="管理员">管理员</option>
                            <option value="老师">老师</option>
                            <option value="班长">班长</option>
                        </select>
                    </div>
                    <div class="lowin-group">
                        <label>用户名 </label>
                        <input type="text" name="username" class="lowin-input">
                    </div>
                    <div class="lowin-group password-group">
                        <label>密码 <a class="forgot-link"></a></label>
                        <input type="password" name="password" autocomplete="current-password" class="lowin-input">
                    </div>
                    <button class="lowin-btn" type="submit">
                        登录
                    </button>

                    <div class="text-foot">
                        没有帐户? <a href="./register" class="register-link">注册</a>
                    </div>

                </form>
            </div>

        </div>

    </div>
    <footer class="lowin-footer">
    </footer>
</div>
<%
    String err = (String) request.getAttribute("error");
    if (err != null) {
%>
<script>
    alert("<%=err%>");
    window.location.href = "./login"
</script>
<%
    }%>
</body>
</html>