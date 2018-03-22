var Index = function () {
    var unfold = $('.unfold');
    var publishButton = $('.publishButton');
    var commentInfos = $('.commentInfos');
    var textarea = $('.textarea');
    //记录被回复者的ip
    var userIp;
    //标识是从评论是上回复还是回复上再进行回复
    var isRevert;




    //检查文本域内容的长度
    function checkTextareaLenth(ele) {
        if (ele.val().length > 500) {
            alert(ele.val().length);
            ele.removeClass('primitiveColor').addClass('error');
            ele.val("评论最大为500字符....");
            return false;
        }
        return true;
    }

    //发表评论
    var publishComment = function () {
        publishButton.click(function () {
            textarea.addClass('primitiveColor');
            if (textarea.val() == '') {
                textarea.removeClass('primitiveColor').addClass('error');
            } else {
                if (!checkTextareaLenth($('.publishComment .textarea'))) {
                    return;
                }
                ;
                $.ajax({
                    url: '/comment/publishComment',
                    type: 'post',
                    dataType: 'json',
                    data: {"id": $('.blogId').val(), "commentStr": textarea.val()},
                    success: function (comment) {
                        if (!$.isEmptyObject(comment)) {
                            textarea.val('');
                            var no = $('.commentInfo:last').find('span:first').text();
                            var tempText = no != '' ? parseInt(no) + 1 + '#' : '1#';
                            $('<p />', {class: 'commentInfo'})
                                .append($('<span />', {
                                    class: 'no',
                                    text: tempText
                                }))
                                .append($('<input />', {class: 'id', type: 'hidden', value: comment.id}))
                                .append($('<span />', {class: 'userIp', text: comment.userIp + "："}))
                                .append($('<span />', {class: 'commentContent', text: comment.content}))
                                .append($('<br>'))
                                .append($('<span />', {class: 'commentDate', text: comment.commentDate}))
                                .append($('<span />', {class: 'revert'}).append($('<a />', {
                                    text: '回复',
                                    href: 'javascript:void(0);'
                                })))
                                .appendTo(commentInfos);

                        }
                    }
                });
            }
        });
    }
    var cleanTextarea = function () {
        textarea.focus(function () {
            textarea.val('');
            textarea.removeClass('error');
        });
    }
    var backPrevious = function () {
        $('a.title').click(function () {
          history.back();
        });
    }
    //生成回复文本域
    var generateRevert = function () {
        commentInfos.on('click', '.revert a', function (event) {

            isRevert = $(event.target).parent().prev().is('span.commentDate');
            if (isRevert) {
                userIp = $(event.target).parent().siblings('.userIp').text();
            } else {
                userIp = $(event.target).parent().siblings('.revertUserIp').text();
            }
          /*  var ff = $(event.target).parents('.commentInfo');
            $(".commentInfo:not(ff)").remove();*/

              $('.revertComment').remove();
            $('<div />', {class: 'revertComment'})
                .append($('<textarea />', {class: 'textarea', placeholder: "来说两句吧..."}))
                .append($('<p />', {class: 'revertButton'}).append($('<button />', {
                    type: 'button',
                    class: 'btn btn-primary',
                    text: '回复评论'
                })))
                .insertAfter($(event.target).parents('p').find('span:last'));
        });
    }

    //回复评论
    var revertComment = function () {
        commentInfos.on('click', '.revertButton button', function (event) {
            var currentTextarea = $(event.target).parent().siblings('textarea');
            currentTextarea.addClass('primitiveColor');
            var rid = isRevert ? '' : currentTextarea.parent().siblings('.id').val();
            console.info('id：' + currentTextarea.parents().siblings('.id').val());
            console.info('内容：' + currentTextarea.val());

            if (currentTextarea.val() == '') {
                currentTextarea.removeClass('primitiveColor').addClass('error');
                return;
            }
            if (!checkTextareaLenth(currentTextarea)) {
                return;
            }

            $.ajax({
                url: '/answer/revertComment',
                type: 'post',
                dataType: 'json',
                data: {
                    "id": currentTextarea.parents().siblings('.id').val(),
                    "content": currentTextarea.val(),
                    "rid": rid,
                    "revertUserIp": userIp
                },
                success: function (answer) {
                    if (!$.isEmptyObject(answer)) {

                        textarea.html('');
                        $('<span />', {class: 'revertContent',display:'block'})
                            .append($('<br>'))
                            .append($('<input />', {type: 'hidden', value: answer.id}))
                            .append($('<span />', {class: 'revertUserIp', text: answer.userIp}))
                            .append($('<span />', {text: ' 回复 '}))
                            .append($('<span />', {class: 'userIp', text: userIp+' '}))
                            .append($('<span />', {text: answer.content}))
                            .append($('<br>'))
                            .append($('<span />', {class: 'revertDate', text: answer.revertDate+' '}))
                            .append($('<span />', {class: 'revert'}).append($('<a />', {
                                text: '回复',
                                href: 'javascript:void(0);'
                            })))
                            .insertBefore(currentTextarea.parents('div.revertComment'));

                    }
                }
            });
        });
    }
    return {
        init: function () {
            publishComment();
            revertComment();
            cleanTextarea();
            generateRevert();
            backPrevious();
        }
    }
}();
$(function () {
    Index.init();
});