$(function () {

    //轮播图设置
    $('.banner').terseBanner({
        btn:true,
        animation:'fade',
        adaptive:true,
    });

    $('nav').load("http://localhost:8080/header");
    $('footer').load("http://localhost:8080/footer");
})

