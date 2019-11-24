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
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->

<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" action="./sendbook" method="post" enctype="multipart/form-data">
            <div class="layui-form-item">
                <input type="number" name="id" hidden value="<% out.print(request.getParameter("id"));%>">
                <label for="L_email" class="layui-form-label">
                    <span class="x-red">*</span>领书时间</label>
                <div class="layui-input-inline">
                    <input type="text" id="L_email" name="time" required="" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>请认真填写领书时间 如:2019-1-1 8:00
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">
                    <span class="x-red">*</span>领书地点</label>
                <div class="layui-input-inline">
                    <input type="text" id="L_username" name="place" required=""
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"></label>
                <button class="layui-btn" type="submit">发布</button>
            </div>
        </form>
    </div>
</div>
<script>
    <% String message=(String) request.getAttribute("message");
    if (message!=null){%>
    alert("发布成功");
    // window.location.reload();
    xadmin.close();
    location.reload();
    <% }%>
</script>
</body>

</html>