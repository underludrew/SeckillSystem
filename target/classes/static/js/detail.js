function miaosha() {
    var id = $("#goods").val();
    $.ajax({
        url:"doMiaosha",
        method:"POST",
        data:{"goods_id":id},
        success:function (data) {
            if(data=="success"){
                alert("秒杀成功");
            }else {
                alert("秒杀失败");
            }
        },error:function () {
            alert("服务器请求失败");
        }
    })
}