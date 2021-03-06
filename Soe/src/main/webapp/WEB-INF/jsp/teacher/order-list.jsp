<%@ page import="com.se.pojo.ClassLeader" %>
<%@ page import="java.util.List" %>
<%@ page import="com.se.pojo.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%>
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
</head>
<body>
<div class="x-nav">
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <button class="layui-btn layui-btn-sm" onclick="xadmin.open('增加新图书','./addneworder',600,400)"
                            href="javascript:;">
                        <i class="layui-icon">&#xe642;</i>
                        增加新订单
                    </button>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>图书名称</th>
                            <th>申请老师</th>
                            <th>申请数量</th>
                            <th>申请班级</th>
                            <th>图书单价</th>
                            <th>图书总价</th>
                            <th>是否通过</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% List<Order> orders = (List<Order>) request.getAttribute("orders");
                            int i = 1;
                            if (orders != null) {
                                for (Order order : orders) {
                        %>
                        <tr>
                            <td id="username<% out.print(i);%>"><%out.print(order.getId()); %></td>
                            <td><%out.print(order.getBookName());%></td>
                            <td><%out.print(order.getTeacherName()); %></td>
                            <td><%out.print(order.getQuantity()); %></td>
                            <td><%out.print(order.getClassId()); %></td>
                            <td><%out.print(order.getPrice()); %></td>
                            <td><%out.print(order.getQuantity() * order.getPrice()); %></td>
                            <td><%
                                switch (order.getPass()) {
                                    case 3:
                                        out.print("发放完毕");
                                        break;
                                    case 0:
                                        out.print("未通过审批,请联系管理员");
                                        break;
                                    case 1:
                                        out.print("通过审批,正在准备发放");
                                        break;
                                    default:
                                        out.print("未审批,请等待管理员审批");
                                }
                            %></td>
                            <% }
                            %>
                            <%
                                }%>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>