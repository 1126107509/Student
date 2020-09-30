<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/28
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门评价页面</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
    <form class="layui-form layui-form-pane"
          action="/insertCommand?dateId=${requestScope.dateId}&stuId=${requestScope.stuId}"
          style="width: 480px" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">评价人</label>
            <div class="layui-input-block">
                <input type="text" name="evaluatePerson" required  lay-verify="required" placeholder="请输入评价人" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名</label>
            <div class="layui-input-block">
                <input type="text" name="stuName" required  lay-verify="required" placeholder="${requestScope.stuName}" autocomplete="off" class="layui-input">
            </div>
        </div>
            <c:forEach  items="${requestScope.jobEvaluateOptionList}" var="JobEvaluateOption">
                <div class="layui-form-item">
                    <label class="layui-form-label">${JobEvaluateOption.optionName}</label>
                    <div class="layui-input-block">
                        <input type="text" name="${JobEvaluateOption.optionId}" required  lay-verify="required" placeholder="请输入评分" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </c:forEach>
        <div class="layui-form-item">
            <label class="layui-form-label">总评价分数</label>
            <div class="layui-input-block">
                <input type="text" name="totalScore" required  lay-verify="required" placeholder="请输入评分" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-">
            <label class="layui-form-label">评价</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" class="layui-textarea" name="jobEvaluateContent"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">评价</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
</form>

<script>
    //Demo
    layui.use(['form','table'], function(){
        var form = layui.form;
        var table = layui.table;

        //监听提交
        form.on('submit(formDemo)', function(data){
            console.log(data.field);
            layer.msg("评价成功");
        });
    });
</script>
</body>
</html>
