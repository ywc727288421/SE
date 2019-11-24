<%@ page import="com.se.pojo.ClassLeader" %>
<%@ page import="java.util.List" %>
<%@ page import="com.se.pojo.Order" %>
<%@ page import="com.se.pojo.GrantBooks" %>
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
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% List<GrantBooks> grantBooks = (List<GrantBooks>) request.getAttribute("grant");
                            int i = 1;
                            if (grantBooks != null) {
                                for (GrantBooks grantBook : grantBooks) {
                        %>
                        <tr>
                            <td id="username<% out.print(i);%>"><%out.print(grantBook.getId()); %></td>
                            <td><%out.print(grantBook.getBookName());%></td>
                            <td><%out.print(grantBook.getTeacherName()); %></td>
                            <td><%out.print(grantBook.getQuantity()); %></td>
                            <td><%out.print(grantBook.getClassId()); %></td>
                            <td><%out.print(grantBook.getPrice()); %></td>
                            <td><%out.print(grantBook.getQuantity()*grantBook.getPrice()); %></td>
                            <td class="td-manage">
                                <a title="发放图书" onclick="xadmin.open('发放图书','./sendbook?id=<%out.print(grantBook.getId());%>',600,400)"
                                   href="javascript:;">
                                    <i class="layui-icon">&#xe642;</i>
                                </a>
                                <% }
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
<script>
    layui.use(['laydate', 'form'], function () {
        var laydate = layui.laydate;
        var form = layui.form;
    });

    function pass(obj, id,state) {
        layer.confirm('确认审批？', function (index) {
            //发异步删除数据
            $.ajax({
                type: "POST",
                url: "./approval",
                dataType: "json",
                data: {"id": id, "state": state},
                success: success1(),
                error: fail1(),
            });

            function success1() {
                layer.msg('修改状态成功!', {icon: 1, time: 1000});
                location.reload();
            }

            function fail1() {
                layer.msg("修改状态成功！", {icon: 1, time: 1000})
                location.reload();
            }
        });
    }

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $.ajax({
                type: "POST",
                url: "./delete",
                dataType: "json",
                data: {"id": id, "kind": "approval"},
                success: success(this),
                complete: success(this),
                error: fail(),
            });

            function success(obj) {
                layer.msg('删除成功!', {icon: 1, time: 1000});
                $(obj).parents("tr").remove();
            }

            function fail() {
                layer.msg("删除失败！", {icon: 1, time: 1000})
            }
        });
    }

</script>
</html>