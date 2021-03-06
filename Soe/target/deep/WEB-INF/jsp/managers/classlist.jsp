<%@ page import="java.util.List" %>
<%@ page import="com.se.pojo.ClassLeader" %><%--
  Created by IntelliJ IDEA.
  User: 10129
  Date: 2019/11/5
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <th>用户名</th>
                            <th>所属班级</th>
                            <th>邮箱</th>
                            <th>所属院系</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% List<ClassLeader> classLeaders = (List<ClassLeader>) request.getAttribute("classLeader");
                            int i = 1;
                            if (classLeaders!=null) {
                                for (ClassLeader classLeader : classLeaders) {
                        %>
                        <tr>
                            <td id="username<% out.print(i);%>"><%out.print(classLeader.getUsername()); %></td>
                            <td><%out.print(classLeader.getClassId());%></td>
                            <td><%out.print(classLeader.getEmail()); %></td>
                            <td><%out.print(classLeader.getDepartment()); %></td>
                            <td class="td-manage">
                                <a title="编辑" onclick="xadmin.open('编辑','./classleaderinfo?username=<%out.print(classLeader.getUsername());%>&&classid=<%out.print(classLeader.getClassId());%>&&department=<%out.print(classLeader.getDepartment());%>&&email=<%out.print(classLeader.getEmail());%>',600,400)"
                                   href="javascript:;">
                                    <i class="layui-icon">&#xe642;</i>
                                </a>
                                <a onclick="xadmin.open('修改密码','./member-password2?username=<%out.print(classLeader.getUsername());%>',600,400)"
                                   title="修改密码"
                                   href="javascript:;">
                                    <i class="layui-icon">&#xe631;</i>
                                </a>
                                <a title="删除" onclick="member_del(this,'<% out.print(classLeader.getUsername());%>')"
                                   href="javascript:;">
                                    <i class="layui-icon">&#xe640;</i>
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


    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $.ajax({
                type: "POST",
                url: "./delete",
                dataType: "json",
                data: {"id": id,"kind":"classleader"},
                success: success(obj),
                complete: success(obj),
                error: fail(),
            });
            function success(obj) {
                layer.msg('删除成功!', {icon: 1, time: 1000});
                $(obj).parents("tr").remove();
            }

            function fail() {
                layer.msg("删除成功！", {icon: 1, time: 1000})
            }
        });
    }

</script>
</html>