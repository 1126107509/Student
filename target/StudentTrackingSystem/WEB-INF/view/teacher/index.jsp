<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师首页</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
    <input type="text" id="userId" value="${requestScope.user.userId}" hidden>
    <ul class="layui-nav">
        <li class="layui-nav-item">
            <a href="/studentList?classState=0&teacherId=${requestScope.user.peopleId}&teacherName=${requestScope.user.userName}" target="main_iframe">本期班级</a>
        </li>
        <li class="layui-nav-item">
            <a href="/studentList?classState=1" target="main_iframe">往期班级</a>
        </li>
        <li class="layui-nav-item">
            <a href="/getTeacherById?teacherId=${requestScope.user.peopleId}" target="main_iframe">个人中心</a>
        </li>
        <li class="layui-nav-item" lay-unselect="">
            <a href="javascript:;">我</a>
            <dl class="layui-nav-child">
                <dd><button type="button" class="layui-btn layui-btn-primary" data-type="modify" style="border: none">修改密码</button></dd>
                <dd><button type="button" class="layui-btn layui-btn-primary" data-type="quit" style="border: none">退出</button></dd>
            </dl>
        </li>
    </ul>
    <iframe src="/studentList?classState=0&teacherId=${requestScope.user.peopleId}&teacherName=${requestScope.user.userName}" name="main_iframe" frameborder="0" height="90%" width="100%"></iframe>
    <script>
        layui.use(['element', 'layer'], function(){
            var element = layui.element //导航的hover效果、二级菜单等功能，需要依赖element模块
                ,$ = layui.jquery
                ,layer = layui.layer;

            //监听导航点击
            element.on('nav(demo)', function(elem){
                //console.log(elem)
                layer.msg(elem.text());
            });

            var active = {
                modify:function () {
                    layer.open({
                        type:2,  //基本层类型
                        title:'修改密码',
                        content:'/modifyPwdForward?userId=' + $("#userId").val(),
                        area: ['455px', '370px'],   //设置弹框高度
                        shadeClose:true //点击是否关闭遮罩
                    })
                },
                quit: function () {
                    location.href = "toLogin";
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
