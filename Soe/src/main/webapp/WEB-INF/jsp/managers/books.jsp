<%@ page import="com.se.pojo.ClassLeader" %>
<%@ page import="java.util.List" %>
<%@ page import="com.se.pojo.Order" %>
<%@ page import="com.se.pojo.GrantBooks" %>
<%@ page import="com.se.pojo.Book" %>
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
                    <button class="layui-btn layui-btn-sm" onclick="xadmin.open('增加新图书','./addnewbook',600,400)"
                            href="javascript:;">
                        <i class="layui-icon">&#xe642;</i>
                        增加新图书
                    </button>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>图书编号</th>
                            <th>图书名称</th>
                            <th>图书剩余数量</th>
                            <th>出版社</th>
                            <th>图书单价</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% List<Book> books = (List<Book>) request.getAttribute("books");
                            int i = 1;
                            if (books != null) {
                                for (Book book : books) {
                        %>
                        <tr>
                            <td id="username<% out.print(i);%>"><%out.print(book.getId()); %></td>
                            <td><%out.print(book.getBookName());%></td>
                            <td><%out.print(book.getBookQuantity()); %></td>
                            <td><%out.print(book.getPress()); %></td>
                            <td><%out.print(book.getPrice()); %></td>

                            </td>
                            <td class="td-manage">
                                <a title="修改图书数量" onclick="xadmin.open('修改图书数量','./getchangenumPage?id=<% out.print(book.getId());%>',600,400)"
                                   href="javascript:;">
                                    <i class="layui-icon">&#xe642;</i>
                                </a>
                                <a title="删除图书" onclick="member_del(this,'<% out.print(book.getId());%>')"
                                   href="javascript:;">
                                    <i class="layui-icon">&#xe640;</i>
                                </a>
                                    <% }
                            }%>
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


    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function () {
            //发异步删除数据
            $.ajax({
                type: "POST",
                url: "./delete",
                dataType: "json",
                data: {"id": id, "kind": "books"},
                success: success(this),
                complete: success(this),
                error: fail(),
            });

            function success(obj) {
                layer.msg('删除成功!', {icon: 1, time: 1000});
                $(obj).parents("tr").remove();
            }
        });
    }

</script>
</html>