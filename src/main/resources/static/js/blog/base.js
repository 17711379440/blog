var Base = function () {
    var scrollTop = $('#scrollTop');
    var nav = $('.navbar-nav');
    var bgColor = $('li.bgColor');
    var unfold = $('.unfold');
    //控制返回顶部的显示和隐藏
    var scrollUp = function () {
        $(window).scroll(function () {
            if ($(window).scrollTop() >= 70) {

                scrollTop.fadeIn(1500);

            } else {
                scrollTop.fadeOut(1500);
            }
        });
    }

    //单击返回顶部
    var clickScrollTop = function () {
        scrollTop.click(function () {

            $('html,body').animate({
                scrollTop: 0
            }, 1000);
            $(this).animate({
                rotate: "+=180deg"
            }, 200);
        });
    }

    //隐藏右侧导航栏项大于5的列
    var hidelistItem = function (ele) {
        $(ele).parent('div').find('a.list-group-item:gt(5)').hide();
        $(ele).show();
    }
    var initHandler = function () {
        /*  listGroup.find('a.list-group-item:gt(5)').hide("slow");
          unfold.show("slow");*/
        var item = $('.list-group').each(function (index, ele) {
            if ($(ele).find('a').length < 8) {
                $(ele).children('a:last').remove();
            }
        });
    }
    //展开右侧导航栏
    var unfoldOrShrink = function () {
        var flag = false;
        unfold.click(function (event) {
            event.preventDefault();
            $(this).toggleClass('fa-angle-double-down');
            if (flag) {
                hidelistItem($(this));
                flag = false;
            } else {
                $(this).siblings(':not(a:first)').show("slow");
                flag = true;
            }
            /* $(this).animate({
                 rotate:"+=180deg"
             },500);*/
        });
    }

    //鼠标移动到某个导航栏上被选中
    var mouseMove = function () {
        var position;
        var nWidth
        nav.find('a').hover(function () {
            var $li = $(this).parent();
            position = $li.position();
            nWidth = $li.width();

            bgColor.stop().animate({
                position: 'absolute',
                left: position.left + 'px',
                width: nWidth
            }, 200);
        });
    };

    //首页选中
    var initPosition = function () {
        var first = nav.find(":not(li.bgColor):first");
        bgColor.css({
            "position": 'absolute',
            'top': 0,
            'left': first.position().left + "px",
            width: first.width(),
            display: "block"
        });
    };
    //加载进度条
    var showLoading = function () {
        if ($("#loadingbar").length === 0) {
            $("body").append("<div id='loadingbar'></div>")
            $("#loadingbar").addClass("waiting").append($("<dt/><dd/>"));
        }
        $("#loadingbar").animate({
            width: (100 + "%")
        }, 2500);
    }
    return {
        init: function () {
            scrollUp();
            clickScrollTop();
            unfoldOrShrink();
            hidelistItem(unfold);
            initHandler();
            initPosition();
            mouseMove();
            // showLoading();
        }
    }
}();
$(function () {
    Base.init();
});