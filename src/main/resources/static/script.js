$(function() {
    $(window).on('scroll', function () {
        if ($(window).scrollTop()) {
            $('nav').addClass('inbody');
        } else {
            $('nav').removeClass('inbody');
        }
    })
})
