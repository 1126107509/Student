<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/21
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生展示页面</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
    <script src="../../static/layui/layui.js"></script>
</head>
<body>
    <div>
        <table class="layui-table" lay-even lay-skin="nob" >
            <colgroup>
                <col width="200">
                <col width="200">
                <col width="200">
            </colgroup>
            <thead>
                <tr>
                    <th colspan="3" style="text-align: center"><span style="font-size: 20px">个人基本信息</span></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><span style="font-size: 15px;font-weight: bold">姓名:</span>${student.stuName}</td>
                    <td><span style="font-size: 15px;font-weight: bold">性别:</span>${student.sex}</td>
                    <td><span style="font-size: 15px;font-weight: bold">出生日期:</span>${student.birthday}</td>
                </tr>
                <tr>
                    <td><span style="font-size: 15px;font-weight: bold">电话:</span>${student.telephone}</td>
                    <td><span style="font-size: 15px;font-weight: bold">邮箱:</span>${student.email}</td>
                    <td><span style="font-size: 15px;font-weight: bold">身份证号:</span>${student.idCard}</td>
                </tr>
                <tr>
                    <td><span style="font-size: 15px;font-weight: bold">民族:</span>${student.nation}</td>
                    <td><span style="font-size: 15px;font-weight: bold">籍贯:</span>${student.birthPlace}</td>
                    <td><span style="font-size: 15px;font-weight: bold">婚姻状态:</span>${student.marry}</td>
                </tr>
                <tr>
                    <td><span style="font-size: 15px;font-weight: bold">学校:</span>${student.university}</td>
                    <td><span style="font-size: 15px;font-weight: bold">专业:</span>${student.major}</td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;
    });
</script>
</html>
