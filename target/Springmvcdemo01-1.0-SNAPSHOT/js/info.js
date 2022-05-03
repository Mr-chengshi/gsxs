$(function () {
    $('nav').load("http://localhost:8080/header");
    $('footer').load("http://localhost:8080/footer");

    //判断输入框
    $('.form-control-name').blur(function () {
        let value = this.value;
        if (value.length<=0){
            $('#form-control-input-error-name').fadeIn();
        }else {
            $('#form-control-input-error-name').fadeOut();
        }
    })

    //判断是否email格式
    function judgeEmail(email) {
        if(email != "") {
            let reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
            //调用正则验证test()函数
            isok = reg.test(email);
            if (!isok) {
                $('#form-control-input-error-email').fadeIn();
                return false;
            }else {
                $('#form-control-input-error-email').fadeOut();
                return true;
            }
        }
        return true;
    }

    //向模态框加载信息
    $('#card-btn').click(function (){


        $('#input-name').val($('#card-name').text());

        if ($('#card-sex').text()==="男"){
            $('#man').attr({"checked":true});
        }
        if($('#card-sex').text()==="女"){
            $('#woman').attr({"checked":true});
        }
        $('#introduction').val($('#card-introduction').text());
        $('#interests').val($('#card-interests').text());
        $('#email').val($('#card-email').text());


    })

    //点击模态框按钮时更新信息
    $('#model-btn').click(function (){
        let flag=true;
        //获取输入框中的值
        let username = $('#input-name').val();//""
        let sex = $("input[name='radio']:checked").val();//undefined
        let introduction = $('#introduction').val();//""
        let interests = $('#interests').val( );
        let email = $('#email').val();
        let xid = $('#card-xid').html();


        if (username===""){
            flag=false;
        }
        if (sex==="1"){
            sex='男';
        }else{
            sex='女';
        }
        console.log(sex)

        //退出模态框时，是否发送修改请求
        if (judgeEmail(email)&&flag){

            //发送请求
            $.ajax({
                type:'post',
                url:'http://localhost:8080/modifyInfo',
                data:{
                    username:username,
                    sex:sex,
                    introduction:introduction,
                    interests:interests,
                    email:email,
                    xid:xid
                },
                success:function (data) {
                    if (JSON.parse(data).boolean){

                        //修改数据
                        if (username!==""){
                            $('#card-name').text(username);
                        }
                        if (sex!==undefined){
                            $('#card-sex').text(sex);
                        }
                        if (introduction!==""){
                            $('#card-introduction').text(introduction);
                        }
                        if (interests!==""){
                            $('#card-interests').text(interests);
                        }
                        if (email!==""){
                            $('#card-email').text(email);
                        }
                        //更新导航栏
                        $('#nav-user').html("hello"+username+"~ ~");
                    }else{
                        console.log(JSON.parse(data).bool);
                        alert("更新失败");
                    }

                }
            })
            $('#myModal').modal('hide');

        }



    })

    //加载界面时，从session中取出信息加载到页面上
    $.ajax({
        type:'post',
        url:"http://localhost:8080/getUserInfo",
        success:function (data) {
            let parse = JSON.parse(data);
            $('#card-name').html(parse.username);
            $('#card-introduction').html(parse.introduction)
            $('#card-score').html(parse.score);
            $('#card-sex').html(parse.sex);
            $('#card-interests').html(parse.interests);
            $('#card-status').html(parse.status);
            $('#card-email').html(parse.email);
            $('#card-xid').html(parse.xid);
            $('#card-sid').html(parse.sid);
        }

    })

});

