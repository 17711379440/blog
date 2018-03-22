var Index = function () {
    var pageInfo = $('.pagination');
    var pagination = $('ul.pagination');
    var prevPage = pagination.children('li:first');
    var nextPage = pagination.children('li:last');
    var blogInfo = $('div.blogInfo');
    var pages;
    var data_list = $('.data_list');
    var ajaxList = function (data) {
        $.ajax({
            url: '/blog/pageList',
            type: 'post',
            dataType: 'json',
            data: data,
            success: function (pageList) {
                pages = pageList;
                var list = pageList.list;
                if (!$.isEmptyObject(blogInfo)) {
                    $('div.blogInfo').remove();
                }
                for (var i = 0, len = list.length; i < len; i++) {
                    $('<div />', {class: 'col-md-12 blogInfo'})
                        .append($('<h3 />', {class: 'col-md-12'}).append($('<a />', {
                            target: "_blank",
                            text: list[i].title,
                            class: 'title',
                            id: list[i].id
                        })))
                        .append($('<span />', {class: "summary", text: list[i].summary}))
                        .append(
                            $('<div />', {class: 'info'})
                                .append($('<span />', {
                                    class: 'createDate',
                                    text: '发表于 ' + list[i].createDate + '　'
                                }))
                                .append($('<span />', {
                                    class: 'readling_times',
                                    text: '阅读(' + list[i].readlingTimes + ')' + '　'
                                }))
                                .append($('<span />', {class: 'comments', text: '评论(' + list[i].comments + ')'}))
                        ).appendTo($('.col-md-9 ').children('div.row'));
                }
                if (pages.isFirstPage) {
                    prevPage.addClass('disabled');
                } else {
                    prevPage.removeClass('disabled');
                }
                if (pages.isLastPage) {
                    nextPage.addClass('disabled');
                } else {
                    nextPage.removeClass('disabled');
                }
            }
        });
    }
    //翻页
    var page = function () {
        $('.pageNum').click(function () {
            var $li = $(this);
            $li.siblings().removeClass('active');
            $li.addClass('active')
            //把单击的页码选中
            ajaxList({'pageIndex': $(this).text()});
        });

        prevPage.click(function () {

            var no = parseInt($('li.active').text()) - 1;
            $(this).loadingbar({

                replaceURL: false,
                direction: "right",

                /* Default Ajax Parameters.  */
                async: true,
                complete: function(xhr, text) {
                },
                cache: true,
                error: function(xhr, text, e) {},
                global: true,
                headers: {},
                statusCode: {},
                success: function(data, text, xhr) {},
                dataType: "html",
                done: function(data) {}
            });
            if (no > 0) {

                ajaxList({'pageIndex': no});
            }
            bindClass(no);
        });
        nextPage.click(function () {
            var no = parseInt($('li.active').text()) + 1;

            $(this).loadingbar({

                replaceURL: false,
                direction: "right",

                /* Default Ajax Parameters.  */
                async: true,
                complete: function(xhr, text) {
                },
                cache: true,
                error: function(xhr, text, e) {},
                global: true,
                headers: {},
                statusCode: {},
                success: function(data, text, xhr) {},
                dataType: "html",
                done: function(data) {}
            });
            if (no <= $('.pageTotal').val()){
                console.info(no);
                ajaxList({'pageIndex': no});
            }
            bindClass(no);
        });

    }

    function bindClass(pageNum) {
        $('.pageNum').each(function (index, ele) {
            if (pageNum == $(ele).text()) {
                $(this).siblings().removeClass('active');
                $(this).addClass('active')
            }
        })
    }

    //博文详情
    var blogDetails = function () {
        data_list.children('.col-md-9 ').on('click', 'a.title', function (ele) {
            var loadingbar = $("#loadingbar");
            if (loadingbar.length === 0) {
                $("body").append("<div id='loadingbar'></div>")
                loadingbar.addClass("waiting").append($("<dt/><dd/>"));
            }
            $("#loadingbar").delay(1200).animate({
                    width: "100%"
                },
                2500, function () {
                    location.href = '/blog/detail?id=' + ele.target.id;
                });
        });
    }
    return {
        init: function () {
            page();
            blogDetails();
        }
    }
}
();
$(function () {
    Index.init();
});