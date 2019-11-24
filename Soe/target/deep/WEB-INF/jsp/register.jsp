<%--
  Created by IntelliJ IDEA.
  User: 10129
  Date: 2019/10/31
  Time: 13:35
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
        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <p>创建账户</p>
                <div class="lowin-group">
                    <form id="form" name="register" action="${pageContext.request.contextPath}/register" method="post"
                          accept-charset="UTF-8"
                          enctype="application/x-www-form-urlencoded">
                        <label>用户身份</label>
                        <div class="lowin-group">
                            <select id="select" class="lowin-input" name="identity">
                                <option value="管理员">管理员</option>
                                <option value="老师">老师</option>
                                <option value="班长">班长</option>
                            </select>
                        </div>
                        <div id="xxxxx">
                            <div class="lowin-group">
                                <label>用户名</label>
                                <input type="text" name="username" autocomplete="name" class="lowin-input">
                            </div>
                            <div class="lowin-group">
                                <label>邮箱</label>
                                <input type="email" autocomplete="email" name="email" class="lowin-input">
                            </div>
                            <div class="lowin-group">
                                <label>密码</label>
                                <input type="password" name="password" autocomplete="current-password"
                                       class="lowin-input">
                            </div>
                            <div class="lowin-group">
                                <label>确认密码</label>
                                <input type="password" name="password2" autocomplete="current-password"
                                       class="lowin-input">
                            </div>
                            <button class="lowin-btn" type="submit">
                                注册
                            </button>
                        </div>
                    </form>
                    <div class="text-foot">
                        已经有帐户? <a href="./login" class="login-link">登录</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="lowin-footer">
    </footer>
</div>
<%--<script>--%>
<%--    var xx = document.getElementById("select");--%>
<%--    xx.addEventListener("change", function (ev) {--%>
<%--        var from = document.getElementById("xxxxx");--%>
<%--        if (xx.value == "班长") {--%>
<%--            from.innerHTML = "<div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>用户名</label>\n" +--%>
<%--                "                                <input type=\"text\" name=\"username\" autocomplete=\"name\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>班级</label>\n" +--%>
<%--                "                                <input type=\"text\" autocomplete=\"text\" name=\"classid\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>邮箱</label>\n" +--%>
<%--                "                                <input type=\"email\" autocomplete=\"email\" name=\"email\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>密码</label>\n" +--%>
<%--                "                                <input type=\"password\" name=\"password\" autocomplete=\"current-password\"\n" +--%>
<%--                "                                       class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>确认密码</label>\n" +--%>
<%--                "                                <input type=\"password\" name=\"password2\" autocomplete=\"current-password\"\n" +--%>
<%--                "                                       class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <button class=\"lowin-btn\" type=\"submit\">\n" +--%>
<%--                "                                注册\n" +--%>
<%--                "                            </button>";--%>
<%--        } else if (xx.value == "老师") {--%>
<%--            from.innerHTML = "<div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>用户名</label>\n" +--%>
<%--                "                                <input type=\"text\" name=\"username\" autocomplete=\"name\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>班级</label>\n" +--%>
<%--                "                                <input type=\"text\" autocomplete=\"text\" name=\"classid\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>邮箱</label>\n" +--%>
<%--                "                                <input type=\"email\" autocomplete=\"email\" name=\"email\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>密码</label>\n" +--%>
<%--                "                                <input type=\"password\" name=\"password\" autocomplete=\"current-password\"\n" +--%>
<%--                "                                       class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>确认密码</label>\n" +--%>
<%--                "                                <input type=\"password\" name=\"password2\" autocomplete=\"current-password\"\n" +--%>
<%--                "                                       class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <button class=\"lowin-btn\" type=\"submit\">\n" +--%>
<%--                "                                注册\n" +--%>
<%--                "                            </button>";--%>
<%--        } else {--%>
<%--            from.innerHTML = "<div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>用户名</label>\n" +--%>
<%--                "                                <input type=\"text\" name=\"username\" autocomplete=\"name\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>邮箱</label>\n" +--%>
<%--                "                                <input type=\"email\" autocomplete=\"email\" name=\"email\" class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>密码</label>\n" +--%>
<%--                "                                <input type=\"password\" name=\"password\" autocomplete=\"current-password\"\n" +--%>
<%--                "                                       class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <div class=\"lowin-group\">\n" +--%>
<%--                "                                <label>确认密码</label>\n" +--%>
<%--                "                                <input type=\"password\" name=\"password2\" autocomplete=\"current-password\"\n" +--%>
<%--                "                                       class=\"lowin-input\">\n" +--%>
<%--                "                            </div>\n" +--%>
<%--                "                            <button class=\"lowin-btn\" type=\"submit\">\n" +--%>
<%--                "                                注册\n" +--%>
<%--                "                            </button>";--%>
<%--        }--%>
<%--    });--%>
<%--</script>--%>

<%
    String err = (String) request.getAttribute("error");
    if (err != null) {
%>
<script>
    alert("<%=err%>");
    window.location.href = "./register"
</script>
<%
    }%>
</body>
</html>