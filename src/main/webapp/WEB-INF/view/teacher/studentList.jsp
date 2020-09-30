
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
    <input type="text" id="teacherName" value="${requestScope.teacherName}" hidden>
    <div class="demoTable" align="center">
        <div class="layui-inline">
            <input class="layui-input" name="stuName" id="stuName" autocomplete="off" placeholder="请输入学员姓名">
        </div>
        <button class="layui-btn" data-type="reload">查询</button>
        <table class="layui-table" lay-data="{height:490,width:615+120*${requestScope.courseList.size()}, url:'getStuByTeacher?teacherId=${requestScope.teacherId}&classState=${requestScope.classState}', page: true, limit: 10, limits:[10,20,30,40,50], id:'studentList'}" lay-filter="studentEvent">
            <thead>
            <tr>
                <th lay-data="{field:'stuId', width:40}" rowspan="2">ID</th>
                <th lay-data="{field:'stuName', width:85, event: 'studentInfo', templet: '#setName'}" rowspan="2">姓名</th>
                <th lay-data="{field:'sex', width:60}" rowspan="2">性别</th>
                <th lay-data="{field:'university', width:140}" rowspan="2">学校</th>
                <th lay-data="{field:'birthPlace', width:100}" rowspan="2">籍贯</th>
                <th lay-data="{field:'className', width:75}" rowspan="2">班期</th>
                <th lay-data="{align:'center'}" colspan="${requestScope.courseList.size()}">培训期间测试成绩</th>
                <th lay-data="{field:'schoolEvaluation', width:100, templet: '#setState', event: 'studentInfo'}" rowspan="2">学校评价</th>
            </tr>
            <tr>
                <c:forEach var="course" items="${requestScope.courseList}">
                    <th lay-data="{field:'${course.courseId}', width:120, edit: 'text'}">${course.courseName}</th>
                </c:forEach>
            </tr>
            </thead>
        </table>

    </div>
    <script type="text/html" id="setState">
        {{#  if(d.schoolEvaluation === '未评价'){ }}
        <span style="color: red;">{{ d.schoolEvaluation }}</span>
        {{#  } else { }}
        {{ d.schoolEvaluation }}
        {{#  } }}
    </script>
    <script type="text/html" id="setName">
        <span style="color: blue;">{{ d.stuName }}</span>
    </script>
    <script>
        layui.use(['table', 'layer'], function(){
            var table = layui.table
                ,layer = layui.layer
                ,$ = layui.jquery;

            //监听单元格编辑，添加成绩
            table.on('edit(studentEvent)', function(obj){
                var value = obj.value //得到修改后的值
                    ,data = obj.data //得到所在行所有键值
                    ,field = obj.field; //得到字段
                if (value < 0 || value > 100) {
                    layer.msg("成绩需在0-100之间");
                } else {
                    $.ajax({
                        type: "post",
                        url: "editScore",
                        data: {
                            stuId: data.stuId,
                            courseId: field,
                            score: value
                        },
                        success:function (data) {
                            layer.msg(data);
                        },
                        error:function () {
                            layer.msg("执行失败")
                        }
                    })
                }
            });

            //监听单元格事件
            //跳转到学生信息界面
            table.on('tool(studentEvent)', function(obj){
                var data = obj.data;
                var teacherName = $("#teacherName").val();
                if(obj.event === 'studentInfo'){
                    location.href = "getStuByStuId?stuId=" + data.stuId + "&teacherName=" + teacherName;
                }
            });

            var active = {
                reload: function(){
                    //获取查询框的值
                    var stuName = $('#stuName').val();

                    //执行重载
                    table.reload('studentList', {
                        method:'post',
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                            stuName: stuName
                        }
                    }, 'data');
                }
            };
            $('.layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
        });
    </script>
</body>
</html>