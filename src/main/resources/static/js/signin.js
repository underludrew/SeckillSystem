function do_login() {
    var salt="1a2s3d4f"
    var loading = weui.loading('正在加载');
    var pass = $("#password").val();

    var fpass = salt.charAt(0)+salt.charAt(3)+pass+salt.charAt(5)+salt.charAt(6);
    console.log(fpass);
    var p = hex_md5(fpass);
    console.log(p)
    $.ajax({
        url:"/login/do_login",
        type:"POST",
        async:"false",
        data:{nickname:$("#username").val(),formedpass:p},
        success:function(data){
            // console.log(data);
            // console.log(data.code.statusCode);
            if(data.code.statusCode==10000){
                loading.hide();
                console.log(data);
                window.location.href="/goods/home";
                // getGoodslistPage();
            }else{
                loading.hide();
                alert(data.code.msg);
            }
        },
        error:function () {
            alert("服务器请求错误");
        }
    })
}

function getGoodslistPage() {
    $.ajax({
        url: "/goods/home",
        type: "GET",
        success: function (data) {
            if(data.state==-1){
                alert("登录失效")
            }else{
                alert("11111")
            }

        },error: function () {
        }
    })
    }