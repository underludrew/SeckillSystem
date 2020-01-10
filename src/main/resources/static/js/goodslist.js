function toDetail(goods_id) {
    $.ajax({
        url:"/detailpage",
        type:"GET",
        success:function (data) {
            if(data=="success"){
                window.location.href = "/detail?goods_id="+goods_id;
            }else {
                window.location.href ="login/login";
            }
        },error:function (data) {
            alert("服务器请求错误");
            console.log(data)
        }
    })
}