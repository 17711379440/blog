var Login = function () {
    var left_hand = $('#left_hand');
    var right_hand = $('#right_hand');
    //登录检查
    var loginCheck = function () {
        $('form').bootstrapValidator({
            //验证图标定制
            feedbackIcons: {
                //验证通过的图标
                valid: "glyphicon glyphicon-ok",
                //验证失败的图标
                invalid: "glyphicon glyphicon-remove",
                //验证过程中(AJAX验证)的图标
                validating: "glyphicon glyphicon-refresh"
            },
            fields: {
                userName: {
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            max: 10,
                            message: '用户名长度不能超过%s个字符'
                        }
                    }
                },
                passWord: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            max: 32,
                            message: '密码长度不能超过%s个字符'
                        }
                    }
                }
            }
        });
    }
    var initialStat = function () {
        $('.username').focus(function () {
            $(this).parent().siblings('label').remove();
        });
        $('.password').focus(function () {
            // console.info($('.left_hand').offset());
            $(this).parent().siblings('label').remove();
            left_hand.stop().animate({
                    top: '-38px',
                    left: '205px'

                },
                {
                    step: function () {

                        if (parseInt(left_hand.css('left')) > 140) {
                            left_hand.removeClass('left_hand').addClass('left_handing');
                        }
                    }
                }, 5000);
            right_hand.stop().animate({
                    top: '-38px',
                    left: '247px'

                },
                {
                    step: function () {

                        if (parseInt(right_hand.css('left')) > 140) {
                            right_hand.removeClass('right_hand').addClass('right_handing');
                        }
                    }
                }, 5000);
        });

        $('.password').blur(function () {
            left_hand.stop().animate({
                left: '126px',
                top: '-15px'

            }, {
                step: function () {
                    if (parseInt(left_hand.css('left')) < 180) {
                        left_hand.removeClass('left_handing').addClass('left_hand');
                    }
                }
            }, 'fast');
            right_hand.stop().animate({
                left: '330px',
                top: '-15px'
            }, {
                step: function () {
                    if (parseInt(right_hand.css('left')) > 290) {
                        right_hand.removeClass('right_handing').addClass('right_hand');
                    }
                }
            }, 'fast');
        });
    }
    return {
        init: function () {
            loginCheck();
            initialStat();
        }
    }
}();
$(function () {
    Login.init();
})