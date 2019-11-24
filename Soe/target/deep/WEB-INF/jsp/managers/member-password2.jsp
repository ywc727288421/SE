<%@ page import="com.se.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <%--    <script type="text/javascript" src="../js/xadmin.js"></script>--%>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
</head>

<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" method="post" action="./changepassword">
            <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="hidden" name="kind" value="classleader">
                    <input type="text" id="L_username" name="username" required="" lay-verify="required"
                           value="<%
                           String username=(String) request.getAttribute("username");
                           out.print(username);
                    %>" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>旧密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="L_repass" name="oldpass" required="" lay-verify="required"
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">
                    <span class="x-red">*</span>新密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="L_pass" name="newpass" required="" lay-verify="required"
                           autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>确认密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="repass" name="repass" required="" lay-verify="required"
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label"> </label>
                <button class="layui-btn" lay-filter="save" lay-submit="">修改</button>
            </div>
        </form>
    </div>
</div>

    <%
    String mess=(String)request.getAttribute("message");
    if (mess!=null){
    %>
    <script>
    alert("<%out.print(mess);%>")
        xadmin.close();
    </script>
    <%
}%>
</body>

</html>