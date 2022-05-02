$(function () {
    $("#xid").blur(function(){
        //获取参数名称的值
        var xid = this.value;
        $.ajax({
            type:'post',
            url:'http://localhost:8080/registerServlet', //注册
            data:{
                xid:xid
            },
            success:function (data){

                if (data=='false'){
                    //用户已存在
                    $('#xid_warn').show();
                }else{
                    //用户不存在
                    $('#xid_warn').hide();
                }
            }
        })
        btn();
    })


    $("#sid").blur(function(){
        //获取参数名称的值
        var sid = this.value;
        $.ajax({
            type:'post',
            url:'http://localhost:8080/registerServlet',
            data:{
                sid:sid
            },
            success:function (data){
                if (data=='false'){
                    //用户已存在
                    $('#sid-warn').show();
                }else{
                    //用户不存在
                    $('#sid-warn').hide();
                }
            }
        })

        btn();
    })

    btn();

    function btn() {
        if ($("#xid").val()==""||$("#password").val()==""||$("#sid").val()==""){
            $("#btn").attr({"disabled":"disabled"});
        }else{
            $("#btn").removeAttr("disabled");
        }
    }

    $('footer').load("http://localhost:8080/footer");
})