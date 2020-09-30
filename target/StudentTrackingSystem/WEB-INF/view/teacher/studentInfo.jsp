<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员信息</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
    <style>
        body {
            background-image: url("../../../static/images/overlap.png");
        }
        td {
            text-align: center;
        }
        input {
            border: none;
            height: 35px;
            width: 120px;
            text-align: center;
        }
        textarea {
            border: none;
        }
        .fontStyle {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div align="center">
        <h2 align="center">金桥学员成长跟踪表</h2>
        <input type="text" id="stuId" value="${requestScope.student.stuId}" hidden>
        <input type="text" id="evaluateId" value="${requestScope.school.evaluateId}" hidden>
        <table style="width: 80%" class="layui-table">
            <tr>
                <td class="fontStyle">姓名</td>
                <td>${requestScope.student.stuName}</td>
                <td class="fontStyle">性别</td>
                <td>${requestScope.student.sex}</td>
                <td class="fontStyle">民族</td>
                <td>${requestScope.student.nation}</td>
                <td rowspan="4"><img src="../../../static/img/photo1.jpg" alt="" height="155" width="115"></td>
            </tr>
            <tr>
                <td class="fontStyle">出生年月</td>
                <td>${requestScope.student.birthday}</td>
                <td class="fontStyle">籍贯</td>
                <td>${requestScope.student.birthPlace}</td>
                <td class="fontStyle">婚否</td>
                <td>${requestScope.student.marry}</td>
            </tr>
            <tr>
                <td class="fontStyle">练习电话</td>
                <td colspan="2">${requestScope.student.telephone}</td>
                <td class="fontStyle">身份证号码</td>
                <td colspan="2">${requestScope.student.idCard}</td>
            </tr>
            <tr>
                <td class="fontStyle">毕业学校</td>
                <td colspan="2">${requestScope.student.university}</td>
                <td class="fontStyle">专业</td>
                <td colspan="2">${requestScope.student.major}</td>
            </tr>
            <tr>
                <td class="fontStyle">备注</td>
                <td colspan="6">${requestScope.student.note}</td>
            </tr>
        </table>

        <table style="width: 80%" class="layui-table">
            <tr>
                <td colspan="${requestScope.courseList.size() + 4}" class="fontStyle">培训学校评价</td>
            </tr>
            <tr>
                <td rowspan="2" class="fontStyle">培训学校</td>
                <td rowspan="2" class="fontStyle">班期</td>
                <td rowspan="2" class="fontStyle">评价人</td>
                <td colspan="${requestScope.courseList.size()}" class="fontStyle">培训期间测试成绩</td>
                <td rowspan="2" class="fontStyle">整体评价分数</td>
            </tr>
            <tr>
                <c:forEach var="course" items="${requestScope.courseAndScore[1]}">
                    <td>${course}</td>
                </c:forEach>
            </tr>
            <tr>
                <td class="fontStyle">学习评价</td>
                <td>${requestScope.classInfo.className}</td>
                <td id="evaluatePerson">${requestScope.teacherName}</td>
                <c:forEach var="score" items="${requestScope.courseAndScore[2]}">
                    <td>${score}</td>
                </c:forEach>
                <td>
                    <c:if test="${requestScope.school.evaluateScore == 0}">
                        <input type="text" value=""  id="evaluateScore">
                    </c:if>
                    <c:if test="${requestScope.school.evaluateScore != 0}">
                        <input type="text" value="${requestScope.school.evaluateScore}"  id="evaluateScore">
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="fontStyle">评价(包括主要优点及缺点)</td>
                <td colspan="${requestScope.courseList.size() + 3}">
                    <textarea name="evaluateContent" id="evaluateContent" cols="120" rows="4">${requestScope.school.evaluateContent}</textarea>
                </td>
            </tr>
        </table>
        <button type="button" class="layui-btn" id="schoolEvaluate">评价</button>
    </div>
    <script>
        layui.use(['layer'], function() {
            var layer = layui.layer
                , $ = layui.jquery;
            
            $("#schoolEvaluate").click(function () {
                var evaluateId;
                if ($("#evaluateId").val() == "") {
                    evaluateId = '0'
                } else {
                    evaluateId = $("#evaluateId").val()
                }
                if ($("#evaluateScore").val() < 0 || $("#evaluateScore").val() > 5) {
                    layer.msg("整体评价分数为5分制");
                    document.getElementById("evaluateScore").focus();
                } else {
                    $.ajax({
                        type: "post",
                        url: "schoolEvaluate",
                        data: {
                            evaluateId: evaluateId,
                            stuId: $("#stuId").val(),
                            evaluatePerson: $("#evaluatePerson").val(),
                            evaluateScore: $("#evaluateScore").val(),
                            evaluateContent: $("#evaluateContent").val()
                        },
                        success: function (data) {
                            layer.msg(data)
                        },
                        error: function () {
                            layer.msg("执行失败")
                        }
                    })
                }
            })
        })
    </script>
</body>
</html>
