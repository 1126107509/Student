$(function () {
    $('input[name=tname]').blur(function () {
        if ($(this).val().trim() == '') {
            layer.msg('姓名不能为空');
            $(this).select().addClass('warn');
        } else {
            $(this).removeClass('warn');
        }
    })

    $('input[name=idCard]').blur(function () {
        var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if ($(this).val().trim() == '') {
            layer.msg('身份证号不能为空');
            $(this).select().addClass('warn');
            return false;
        } else if (reg.test($(this).val()) == false) {
            layer.msg('身份证号不合法');
            $(this).select().addClass('warn');
            return false;
        } else {
            $(this).removeClass('warn');
        }
    })
    $('input[name=phone]').blur(function () {
        var reg = /^1[3|4|5|7|8][0-9]{9}$/;
        if ($(this).val().trim() == '') {
            layer.msg('联系方式不能为空');
            $(this).select().addClass('warn');
            return false;
        } else if (reg.test($(this).val()) == false) {
            layer.msg('手机号不合法');
            $(this).select().addClass('warn');
            return false;
        } else {
            $(this).removeClass('warn');

        }
    })
    $('input[name=email]').blur(function () {
        var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (reg.test($(this).val()) == false) {
            layer.msg('邮箱不合法');
            $(this).select().addClass('warn');
            return false;
        } else {
            $(this).removeClass('warn');

        }
    })
    $('input[name=university]').blur(function () {
        if ($(this).val().trim() == '') {
            layer.msg('毕业院校不能为空');
            $(this).select().addClass('warn');
        } else {
            $(this).removeClass('warn');
        }
    })

    $('input[name=major]').blur(function () {
        if ($(this).val().trim() == '') {
            layer.msg('专业不能为空');
            $(this).select().addClass('warn');
        } else {
            $(this).removeClass('warn');
        }
    })

    $('input[name=birthPlace]').blur(function () {
        if ($(this).val().trim() == '') {
            layer.msg('专业不能为空');
            $(this).select().addClass('warn');
        } else {
            $(this).removeClass('warn');
        }
    })



})


/* if (tname == '') {
                layer.msg('姓名不能为空');
                $('input[name=tname]').select().addClass('warn');
                return false;
            }

            if (phone == '') {
                layer.msg('联系电话不能为空');
                $('input[name=phone]').select().addClass('warn');
                return false;
            } else if (phonereg.test($('input[name=phone]').val()) == false) {
                layer.msg('手机号不合法');
                $('input[name=phone]').select().addClass('warn');
                return false;
            }

            if (idCard == '') {
                layer.msg('身份证号不能为空');
                $('input[name=idCard]').select().addClass('warn');
                return false;
            } else if (cardreg.test($('input[name=idCard]').val()) == false) {
                layer.msg('身份证号不合法');
                $('input[name=idCard]').select().addClass('warn');
                return false;
            }
*/