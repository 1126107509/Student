<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
    <input type="text" id="userPwd" value="${requestScope.user.pwd}" hidden>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">请输入旧密码</label>
            <div class="layui-input-inline">
                <input type="password" name="oldPwd" id="oldPwd" required  lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">请输入新密码</label>
            <div class="layui-input-inline">
                <input type="password" name="newPwd" id="newPwd" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">请再次输入新密码</label>
            <div class="layui-input-inline">
                <input type="password" name="reNewPwd" id="reNewPwd" required lay-verify="required" placeholder="请再次输入新密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="modify" lay-submit lay-filter="formDemo">修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <script>
        layui.use(['form','layer'], function(){
            var form = layui.form
                ,$ = layui.jquery
                ,layer = layui.layer;

            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg(JSON.stringify(data.field));
                return false;
            });

            $("#oldPwd").blur(function () {
                if ($("#oldPwd").val() != $("#userPwd").val()) {
                    layer.msg("密码错误");
                    document.getElementById("oldPwd").focus();
                    document.getElementById("oldPwd").select();
                    $("#modify").addClass("layui-btn-disabled");
                } else {
                    $("#modify").removeClass("layui-btn-disabled");
                }
            });

            $("#reNewPwd").blur(function () {
                if ($("#reNewPwd").val() != $("#newPwd").val) {
                    layer.msg("两次密码不一致");
                    $("#modify").addClass("layui-btn-disabled");
                } else {
                    $("#modify").removeClass("layui-btn-disabled");
                }
            });
        });
    </script>
</body>
</html>
