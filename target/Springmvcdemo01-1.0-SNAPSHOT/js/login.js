

$(function () {
    $("#id").blur(function (){

        let id = this.value;
        if (id){
            $("#xid_warn").hide();
        }else{
            $("#xid_warn").show();
        }

        btn();
    })


    $("#password").blur(function (){
        let password = this.value;
        if (password){
            $("#password_warn").hide();
        }else{
            $("#password_warn").show();
        }

        btn();
    })


    btn();
    function btn() {
        if ($("#id").val()==""||$("#password").val()==""){
            $("#btn").attr({"disabled":"disabled","background-color":"#c3c3c3"});
        }else{
            $("#btn").removeAttr("disabled");
            $("#btn").attr({"background-color":"dodgerblue"});
        }
    }
    


    $('footer').load("http://localhost:8080/footer");
});
