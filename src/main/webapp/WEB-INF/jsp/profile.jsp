<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>个人设置|六度空间</title>
    <link rel="stylesheet" type="text/css" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link href="../../css/custom.css" rel="stylesheet">

</head>
<body ontouchstart>
    <!-- Your Code -->
<div id="container" class="container">
    <div class="">
        <h1 class="title">六度空间</h1>
    </div>
    <div class="weui-cells__title">个人资料</div>
    <div class="weui-flex">
            <div class="weui-flex__item">
                <div class="placeholder">weui</div>
            </div>
            <div class="weui-flex__item" style="width: 50%">
                <div class="placeholder">
                    <form action="" method="get" enctype="multipart/form-data" name="upload_form">
                        <label for="file"><img class="avatar" src="../../icon/avatar.png" id = "preview" alt=""></label>
                        <input name="imgfile" id ="file" type="file" accept="image/jpeg, image/png,image/jpg" onchange="imgPreview(this)" style="display: none;" />
                        <input name="upload-image" class="upload-image"type="submit" value="上传" />
                    </form>
                </div>
            </div>
        </div>
    <div class="weui-footer">
            <p class="weui-footer__links">
                <a href="javascript:void(0);" class="weui-footer__link">六度空间</a>
                <a href="../../index.jsp" class="weui-footer__link">返回首页</a>
            </p>
            <p class="weui-footer__text">Copyright © Reserved </p>
    </div>
</div>
<script type="text/javascript">
    function imgPreview(fileDom){
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }

        //获取文件
        var file = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(file.type)) {
            alert("请选择图片！");
            return;
        }
        //读取完成
        reader.onload = function(e) {
            //获取图片dom
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
</script>
</body>
</html>