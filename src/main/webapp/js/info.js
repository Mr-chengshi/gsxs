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

        if ($('#card-sex').text()=="男"){
            $('#man').attr({"checked":true});
        }
        if($('#card-sex').text()=="女"){
            $('#woman').attr({"checked":true});
        }
        $('#introduction').val($('#card-introduction').text());
        $('#interests').val($('#card-interests').text());
        $('#email').val($('#card-email').text());


    })

    //更新信息
    $('#model-btn').click(function (){
        let flag=true;
        //获取值
        let name = $('#input-name').val();//""
        let sex = $("input[name='radio']:checked").val();//undefined
        let introduction = $('#introduction').val();//""
        let interests = $('#interests').val( );
        let email = $('#email').val();


        if (name==""){
            flag=false;
        }


        //退出模态框
        if (judgeEmail(email)&&flag){

            //发送请求
            $.ajax({
                type:'post',
                url:'http://localhost:8080/modifyInfo',
                data:{
                    name:name,
                    sex:sex,
                    introduction:introduction,
                    interests:interests,
                    email:email
                },
                success:function (data) {

                    if (data=="true"){

                        //修改数据
                        if (name!=""){
                            $('#card-name').text(name);
                        }
                        if (sex!=undefined){
                            if (sex==0){
                                $('#card-sex').text('女');
                            }else {
                                $('#card-sex').text('男');
                            }
                        }
                        if (introduction!=""){
                            $('#card-introduction').text(introduction);
                        }
                        if (interests!=""){
                            $('#card-interests').text(interests);
                        }
                        if (email!=""){
                            $('#card-email').text(email);
                        }
                    }else{
                        console.log(data);
                        alert("更新失败");
                    }

                }
            })
            $('#myModal').modal('hide');

        }



    })

});

