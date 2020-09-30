$(function () {
    var width = $(window).width() + +'px';
    var height = $(window).height() + 'px';

    $('.contain').css("width", width);
    $('.contain').css("height", height);

    $(window).resize(function () {
        var width = $(window).width() + 'px';
        var height = $(window).height() + 'px';
        $('.contain').css("width", width);
        $('.contain').css("height", height);
    })


    var circleheight = parseFloat($('.circle-body').css('height'));
    var font0height = parseFloat($('.font0').css('height'));
    var font_common_height = parseFloat($('.font-common').css('height'));
    var circlewidth = parseFloat($('.circle-body').css('width'));
    var font0width = parseFloat($('.font0').css('width'));
    var font_common_width = parseFloat($('.font-common').css('width'));


    $('.font0').css('left', (circlewidth / 2 - font0width / 2 + 11) + 'px')
    $('.font0').css('top', (circleheight / 2 - font0height / 2 - 8) + 'px')

    $('.font-common').css('top', (circleheight / 2 - font0height / 2 - font_common_height - 8) + 'px')
    $('.font-common').css('left', (circlewidth / 2 - font_common_width / 2 + 11) + 'px')

    var originx = parseFloat($('.font-common').css('width')) / 2 + parseFloat($('.font0').css('width')) / 2 + 'px';
    var originy = parseFloat($('.font-common').css('height')) + parseFloat($('.font0').css('height')) / 2 + 'px';

    $($('.font-common')[1]).addClass('font-img-rotate60');
    $($('.font-common')[1]).css('transform-origin', '33px  ' + originy);

    $($('.font-common')[2]).addClass('font-img-rotate120');
    $($('.font-common')[2]).css('transform-origin', '33px  ' + originy);
    $($('.font-common')[3]).addClass('font-img-rotate180');
    $($('.font-common')[3]).css('transform-origin', '33px  ' + originy);
    $($('.font-common')[4]).addClass('font-img-rotate240');
    $($('.font-common')[4]).css('transform-origin', '33px  ' + (parseFloat(originy) + 3 + 'px'));
    $($('.font-common')[5]).addClass('font-img-rotate300');
    $($('.font-common')[5]).css('transform-origin', '29px  ' + (parseFloat(originy) + 3 + 'px'));

    /*初始动态显示介绍*/
    $('.active dt').css('color', '#444');
    $('.active dd').css('color', '#444');

    $('.bg1-img').hover(function () {
        $('.bg1-inner').css('animation', 'rotation 10s linear infinite')

    }, function () {
        $('.bg1-inner').css('animation', '')
    })


    $('.bg2-img').hover(function () {
        $('.bg2-inner').css('animation', 'rotation 10s linear infinite');
    }, function () {
        $('.bg2-inner').css('animation', '')
    })


    $('.bg3-img').hover(function () {
        $('.bg3-inner').css('animation', 'rotation 10s linear infinite')
    }, function () {
        $('.bg3-inner').css('animation', '')
    })

    $('.bg4-img').hover(function () {
        $('.bg4-inner').css('animation', 'rotation 10s linear infinite')
    }, function () {
        $('.bg4-inner').css('animation', '')
    })


    $('.flag').hover(function () {
        $('.content dl').removeClass('active');
        var dlElement = $('.content dl')[$(this).index() - 1];
        $(dlElement).toggleClass('active');
        $('.active dt').css('color', '#444');
        $('.active dd').css('color', '#444')
    })


    var step = 0;
    var length = $('.font-common img').length;
    var imgs = $('.font-common img');

    function changefont() {

        for (var i = 0; i < length; i++) {

            if (step + i == length) {
                setTimeout(' ', 150);
                var path = '../../static/images/zi-' + (i) + '.png';
                $(imgs[length - 1]).prop('src', path);
                for (var j = 0; j < step; j++) {


                    var path = '../../static/images/zi-' + (i + j + 1) + '.png';
                    $(imgs[j]).prop("src", path);
                    setTimeout(' ', 150);

                }
                break;

            } else {
                setTimeout('', 150);
                var path = '../../static/images/zi-' + (i + 1) + '.png';
                $(imgs[step + i]).prop('src', path);
            }

        }
        step++;
        if (step == 6) {
            step = 0;
        }

    }

    var timeid = 0;
    $('.font0').hover(function () {
        timeid = setInterval(changefont, 1000);
    }, function () {
        clearInterval(timeid)
    })


    /*账号验证*/
    $('input[name=username]').blur(function () {
        var username = $(this).val();
        if ($.trim(username) == '') {
            /*alert("用户名不能为空");*/

            $(this).parent().css('border-bottom-color', 'red');
            $('.name_err_msg').html('用户名不能为空');
            $('#name_err_msg').css('visibility', 'visible')
            $(this).select();
        } /*else if (username.length < 4) {
            /!*  alert("用户名长度最低4位");*!/

            $(this).parent().css('border-bottom-color', 'red');
            $('.name_err_msg').html('用户名长度最低4位');
            $('#name_err_msg').css('visibility', 'visible')
            $(this).select();
        }*/ else {
            $(this).parent().css('border-bottom-color', '#cccccc');
            $('#name_err_msg').css('visibility', 'hidden')


        }
    })
    $('input[name=password]').blur(function () {
        var password = $(this).val();
        if ($.trim(password) == '') {
            /*alert("密码不能为空");*/
            $(this).parent().css('border-bottom-color', 'red');
            $('.pwd_err_msg').html('密码不能为空');
            $('#pwd_err_msg').css('visibility', 'visible')
            $(this).select();
        } else if (password.length < 4) {
            /*  alert("密码长度最低4位");*/
            $(this).parent().css('border-bottom-color', 'red');
            $('.pwd_err_msg').html('密码长度最低4位');
            $('#pwd_err_msg').css('visibility', 'visible')
            $(this).select();
        } else {
            $('#pwd_err_msg').css('visibility', 'hidden');
            $(this).parent().css('border-bottom-color', '#cccccc');
        }
    })


})