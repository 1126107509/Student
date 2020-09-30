<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../../../static/css/admin/add.css">
    <style>
        body {
            background-image: url("../../../static/images/overlap.png");
        }

        body {
            height: 500px;
        }

        #demo1 {
            width: 113px;
            height: 140px;
        }

        .layui-upload-list {
            /*display: none;*/
        }

        .item-label:before {
            display: inline-block;
            margin-right: 4px;
            content: "*";
            font-family: SimSun;
            color: red;
        }

        #main .warn {
            border-color: red !important;
        }
    </style>
</head>
<body>
    <div class="layui-form" style="width: 80%; margin: 0 auto">
        <table class="layui-table" align="center">
            <tr>
                <td>
                    <div class="layui-form-item">
                        <label class="layui-form-label font item-label">编号：</label>
                        <div class="layui-input-block ">
                            <input type="text" name="teacherId"
                                   autocomplete="off" disabled style="border: none"
                                   value="${teacher.teacherId}" class="layui-input">
                        </div>
                    </div>
                </td>
                <td>
                    <div class="layui-form-item">
                        <label class="layui-form-label font item-label">姓名：</label>
                        <div class="layui-input-block ">
                            <input type="text" name="tname" placeholder="请输入教师姓名"
                                   autocomplete="off"
                                   value="${teacher.tname}" class="layui-input">
                        </div>
                    </div>
                </td>
                <td rowspan="3" align="center">
                    <input type="hidden" name="photo" id="photo" value="${teacher.photo}">
                    <div class="layui-form-item">
                        <button type="button" class="layui-btn layui-btn-warm" id="test7"><i
                                class="layui-icon"></i>选择头像
                        </button>
                        <div class="layui-upload-list">
                            <img class="layui-upload-img" id="demo1"
                                 src='../../../static/${teacher.photo == null?"img/default.png":teacher.photo}'>
                            <p id="demoText"></p>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别：</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sex" value="男"
                                   title="男" ${teacher.sex == "男"?"checked":""}>
                            <input type="radio" name="sex" value="女"
                                   title="女" ${teacher.sex == "女"?"checked":""}>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="layui-form-item">
                        <label class="layui-form-label">出生年月：</label>
                        <div class="layui-input-block">
                            <input type="text" name="birthday" id="birthday" lay-verify="date"
                                   value="${teacher.birthday}" placeholder="yyyy-MM-dd"
                                   autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="layui-form-item">
                        <label class="layui-form-label font item-label">电话：</label>
                        <div class="layui-input-block">
                            <input type="text" name="phone" placeholder="请输入联系方式"
                                   autocomplete="off"
                                   value="${teacher.phone}" class="layui-input">
                        </div>
                    </div>
                </td>
                <td>
                    <div class="layui-form-item">
                        <label class="layui-form-label font item-label">身份证：</label>
                        <div class="layui-input-block">
                            <input type="text" name="idCard" placeholder="请输入身份证号"
                                   autocomplete="off"
                                   value="${teacher.idCard}" class="layui-input">
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="button"
                                    class="layui-btn layui-btn-radius layui-btn-normal"
                                    lay-submit
                                    id="submit">&nbsp;&nbsp;修&nbsp;&nbsp;&nbsp;&nbsp;改&nbsp;&nbsp;
                            </button>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</body>
<script src="../../../static/layui/layui.all.js"></script>
<script src="../../../static/js/jquery.min.js"></script>
<script src="../../../static/js/verify.js"></script>
<script>
    var ele = window.parent.document.getElementById('parent');
    var parentHeight = $(ele).css('height');
    var currentHeight = $('body').css('height');
    if (currentHeight > parentHeight) {
        $(ele).prop('scrolling', 'yes');
    }

    layui.use(['upload', 'jquery', 'laydate'], function () {
        var $ = layui.jquery;
        var upload = layui.upload;
        var laydate = layui.laydate;
        laydate.render({
            elem: '#birthday',
            trigger: 'click'
        });

        $('#submit').click(function () {
            var tname = $('input[name=tname]').val();
            var idCard = $('input[name=idCard]').val();
            var phone = $('input[name=phone]').val();

            if (tname != '' && idCard != '' && phone != '') {
                $.ajax({
                    url: "updateTeacherById",
                    type: 'post',
                    data: {
                        teacherId: $('input[name=teacherId]').val(),
                        tname: $('input[name=tname]').val(),
                        sex: $('input[type=radio]:checked').val(),
                        birthday: $('input[name=birthday]').val(),
                        phone: $('input[name=phone]').val(),
                        idCard: $('input[name=idCard]').val(),
                        photo: $('#photo').val(),
                    },
                    success: function (data) {
                        layer.msg(data);
                    },
                    error: function () {
                        layer.msg("执行失败")
                    }
                })
            }
        });

        upload.render({
            elem: '#test7'
            , url: 'saveTeacherImg' //改成您自己的上传接口
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('.layui-upload-list').show();
                    $('#demo1').attr('src', result);
                });
            }
            , done: function (res) {
                $('#photo').val(res.img)
            }
        });
    });
</script>
</html>
