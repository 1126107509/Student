//JavaScript代码区域


$.ajax({
    url: '/menu',
    type: 'post',
    dataType: 'json',
    success: function (data) {
        var datas = data.data;
        //展示主菜单

        var str = '';

        for (var json of datas) {

            str = str + '<li class="layui-nav-item">\n' +
                '    <a href="javascript:;"  lay-direction="2">\n' +
                '        <i class="layui-icon ' + json.imageShow + '"></i>\n' +
                '        <cite class="font-color">' + json.menuName + '</cite>\n' +
                '    </a>';


            //迭代子菜单

            var sonstr = sonMenu(json.sonMenus, '');
            str = str + sonstr + '</li>';

        }


        $('#LAY-system-side-menu').html(str);
    }
})

function sonMenu(sonmenus) {
    if (sonmenus.length == 0) {
        return;
    } else {
        var str = '<dl class="layui-nav-child">';
        for (var json of sonmenus) {
            if (json.sonMenus.length == 0) {
                str = str + '<dd class="hoverevent" data-name="content"><a href="javascript:;">' + json.menuName + '</a>';
            }else {
                str = str + '<dd class="unhover" data-name="content"><a href="javascript:;">' + json.menuName + '</a>';
            }
            var sonstr = '';
            if (json.sonMenus.length != 0) {
                sonstr = sonMenu(json.sonMenus);

            }
            str = str + sonstr + ' </dd>';
        }

        str = str + '</dl>';
        return str;
    }


}
