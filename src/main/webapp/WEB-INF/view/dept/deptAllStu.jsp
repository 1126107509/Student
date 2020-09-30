<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前部门下的学生列表</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body >
<div class="layui-fluid ">
    <div class="layui-card">
        <div class="layui-card-body ">
            <table class="layui-table" id="test" lay-filter="test"
                   lay-data="{url:'/getStuBydeptId?deptId=${requestScope.deptId}',page: true, limit: 10, limits:[10,20,30,40,50],height:450}">
                <thead>
                <tr>
                    <div class="demoTable">
                        <div class="layui-inline" style="margin: 0 0 0 100px">
                            <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="请输入姓名">
                        </div>
                        <button class="layui-btn layui-btn-radius" data-type="reload" style="margin: 0 50px">
                            查 询
                            <i class="layui-icon-search"></i>
                        </button>
                    </div>

                </tr>
                <tr>
                    <th lay-data="{field:'stuId', width:60, sort:'true'}">Id</th>
                    <th lay-data="{field:'stuName', width:100}">学生姓名</th>
                    <th lay-data="{field:'sex', width:100}">性别</th>
                    <th lay-data="{field:'className', width:180}">毕业班级</th>
                    <c:forEach var="EvaluateDate" items="${requestScope.evaluateDates}">
                        <th lay-data="{field:'${EvaluateDate.dateId}'}">
                                ${EvaluateDate.dateName}
                        </th>
                    </c:forEach>
                    <th lay-data="{fixed: 'right', width: 100, align: 'center', toolbar: '#barDemo'}">操作</th>
                </tr>
                </thead>
            </table>

        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" id="comment">添加评价</a>

</script>
<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;


        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            var tr = obj.tr[0];
            var tds = $(tr).children();
            var tdlebgth = $(tr).children().length - 1;
            var index = 0;
            for (var i = 0; i < tdlebgth; i++) {
                var comment = $(tds[i]).children()[0].innerHTML;
                if (comment == '未评价') {
                    index = i;
                    break;
                }
            }
            if (index != 0) {
                var id = index - 3;
                index = index + 9;
                var thead = $('.layui-table thead tr:last-child th').eq(index);

                var title = thead.find('span')[0].innerHTML.trim();

                if (obj.event === 'edit') {
                    layer.open({
                        title: title,
                        area: ['500px', '500px'],
                        type: 2,
                        content: ['/deptCommand?stuId=' + data.stuId + '&dateId=' + id + '&stuName=' + data.stuName]//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    });
                }
            } else {
                layer.msg("无法评价");
                $('#comment').removeClass("layui-btn layui-btn-xs").addClass("layui-btn layui-btn-xs layui-btn-disabled")
            }
        });
    });
</script>
</body>
</html>
