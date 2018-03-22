
$(function () {
    $('button').click(function () {
        var content = insertCodeElement($('.java').html());
        $('.java').html('').html(content);
    });

    function insertCodeElement(content) {
        var element = $(content).find('img[src]').parent();
        var newContent='';
        for (var i=0,len=element.length; i < len;i++){
            var ele = element[i];
            newContent += content.replace(element[i],'');
        }
        console.info(newContent);
        return newContent;
/*        var element = $(content).find('pre');
        var $div=$('<div />');
        $.each(element.prevObject,function (index, el){
            var $el = $(el);
            var html = $el.html();
            var code = $('<code />', {'class': 'java', text: html});
            var $pre = $('<pre />',{html:code});
            $div.append($pre);
        });
        return $div.html();*/
    }
});