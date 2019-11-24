<%@ page import="com.se.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <blockquote class="layui-elem-quote">欢迎
                        <span class="x-red"><% User user = (User) request.getSession().getAttribute("session");
                            out.print(user.getUsername());%></span>当前时间:<% java.text.SimpleDateFormat formatter =
                                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            java.util.Date currentTime = new java.util.Date();//得到当前系统时间
                            String str_date1 = formatter.format(currentTime); //将日期时间格式化
                            String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式
                            out.print(str_date2);%>
                    </blockquote>
                </div>
            </div>
        </div>
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">系统信息</div>
                <div class="layui-card-body ">
                    <table class="layui-table">
                        <tbody>
                        <tr>
                            <th>教材征订系统版本</th>
                            <td>1.0</td>
                        </tr>
                        <tr>
                            <th>服务器地址</th>
                            <td>deepblue.datsec.cn:8002</td>
                        </tr>
                        <tr>
                            <th>操作系统</th>
                            <td>Windows</td>
                        </tr>
                        <tr>
                            <th>运行环境</th>
                            <td>Tomcat 9.0.27</td>
                        </tr>
                        <tr>
                            <th>MYSQL版本</th>
                            <td>5.5.53</td>
                        </tr>
                        <tr>
                            <th>上传附件限制</th>
                            <td>2M</td>
                        </tr>
                        <tr>
                            <th>Session时间限制</th>
                            <td>30 m</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">开发团队</div>
                <div class="layui-card-body ">
                    <table class="layui-table">
                        <tbody>
                        <tr>
                            <th>版权所有</th>
                            <td>DeepBlue
                        </tr>
                        <tr>
                            <th>开发者</th>
                            <td>李凯凯-1707004732 杜晓峥-1707004304 马雅竹-1707004302 张劭航-1707004243</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <style id="welcome_style"></style>
    </div>
</div>
</div>
</body>
</html>