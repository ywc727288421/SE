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

<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>用户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" value="<% out.print(request.getAttribute("username"));%>"
                           required="" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red"></span>
                </div>
            </div>
            <div class="layui-form-item">

                <label class="layui-form-label">
                    <span class="x-red"></span>更改系别</label>
                <div class="layui-input-inline">
                    <input type="text" name="department" value="<% out.print(request.getAttribute("department"));%>"
                           required="" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red"></span>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>更改邮箱</label>
                <div class="layui-input-inline">
                    <input type="email" name="email" required="" lay-verify="email"
                           value="<% out.print(request.getAttribute("email"));%>"
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red"></span>更改所属班级</label>
                <div class="layui-input-inline">
                    <input type="text"  name="classid" required=""
                           value="<% out.print(request.getAttribute("classid"));%>"
                           autocomplete="off" class="layui-input"></div>
                <input name="po" value="1" hidden>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"></label>
                <button class="layui-btn" lay-filter="*" lay-submit="">修改</button>
            </div>
        </form>
    </div>
</div>
<% if (request.getAttribute("message") != null) {%>
<script>
    alert("<%out.print(request.getAttribute("message")); %>")
</script>
<% }%>
</body>

</html>