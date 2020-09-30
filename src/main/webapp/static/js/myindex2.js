//JavaScript代码区域


$.ajax({
    url: '/adminmenu',
    type: 'post',
    dataType: 'json',
    success: function (data) {
        var datas = data.data;
        //展示主菜单
        console.log(datas)
        var str = '';

        for (var json of datas) {

            str = str + '<li class="layui-nav-item layui-nav-itemed">\n' +
                '    <a href="javascript:;">\n' +
                '        <i class="layui-icon ' + json.imageShow + '"></i>\n' +
                '        <cite class="font-color">' + json.menuName + '</cite>\n' +
                '    </a>';


            //迭代子菜单

            var sonstr = sonMenu(json.sonMenus);
            str = str + sonstr + '</li>';

        }
        //console.log(str)

        $('#LAY-system-side-menu').html(str);

    }
})

function sonMenu(sonmenus) {
    //一级菜单无子元素
    if (sonmenus.length == 0) {
        return;
    } else {
        //一级菜单有子元素
        var str = '<dl class="layui-nav-child layui-nav-itemed">';


        for (var json of sonmenus) {
            //无子元素
            if (json.sonMenus.length == 0) {
                str = str + '<dd><a lay-href="' + (json.url == '' ? '' : json.url) + '">' + json.menuName + '</a> </dd>'
            } else {
                //有子元素
                str = str + '<dd><a href="javascript:;">' + json.menuName + '</a> '
                var menu = sonMenu(json.sonMenus);
                str = str + menu + ' </dd>';
            }


        }

        str = str + '</dl>';
        return str;
    }

}


/* str = str + '<dd><a href="' + (json.url == '' ? "javascript:;" : json.url) + '"' + (json.url == '' ? "" : 'target="frame"') + ' >' + json.menuName + '</a>';*/