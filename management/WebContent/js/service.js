var data2 = [];
$(document).ready(function () {
	var html = "";
	html += "";
	console.log("加载成功")
	$.ajax({
        url: '/management/admin_Root_showClubs?', // 请求的Controller
        type: 'post', // 请求方式
        dataType: 'json', // 发送的数据类型
        crossDomain: true,
        data: JSON.stringify(),// 要提交给服务端的数据
        success: function (json) { // 请求成功后如何处理结果?，json其实就是服务端返回的响应内容
            console.log(json); // 打印到控制看一看
            //数据样例
            
            //解析json
            console.log("遍历数组");
            $.each(json, function (index, item) {
            	 $.each(item, function (i, obj ) {
            		 var data1=[];
            		 data1["cid"] = obj.cid;
                 	data1["cintro"] = obj.cintro;
                 	data1["cname"] = obj.cname;
                 	data2[index] = data1;
                 });
            });
            setHtml();
            }
	});
});

function setHtml(){
	/**
	 * <section class="services py-5 bg-clr" id="services">
      <div class="container py-lg-5">
    <div class="row mt-lg-3">
          <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-md-0 mb-4">
        <h4 class="heading mt-3 ml-3">西南民族大学</br>
              社团一览表</h4>
      </div>
          <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12"> <a href="about.html" class="a_url">
            <div class="our-services-wrapper mb-60">
            <div class="services-inner">
                <div class="our-services-icon"> <span class="fa fa-ship" aria-hidden="true"><img src="picture/acm.jpg" /></span> </div>
                <div class="our-services-text">
                <h4>SMUACM俱乐部</h4>
                <p>自2005年组建ACM集训队，由谈文蓉、校景中、周绪川老师任教练，于同年参加第29届ACM国际大学生程序竞赛亚洲区决赛，目前已连续参加15届。</p>
              </div>
              </div>
          </div>
            </a> </div>
	 */
	
	$('section#services').empty();
	var html = "";
	//前半部分
	html+="<div class=\"container py-lg-5\">" +
    "<div class=\"row mt-lg-3\">" +
          "<div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-md-0 mb-4\">" +
        "<h4 class=\"heading mt-3 ml-3\">西南民族大学</br>" +
              "社团一览表</h4>" +
      "</div>";
	
	//数据部分
	$.each(data2, function (index, item) {
		
	var cid = item.cid;//社团号
	var cname = item.cname;//社团名称 
	var cintro = item.cintro;//社团简介
        html += "<div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12\">" +
        "<a href=\"about.html?cid=" + cid + "\"  class=\"a_url\" id = \"cid_"+ cid +"\">" +
        "<div class=\"our-services-wrapper mb-60\">" +
        "<div class=\"services-inner\">" +
        "<div class=\"our-services-icon\">" +
        "<span class=\"fa fa-ship\" aria-hidden=\"true\"><img src=\"picture/acm.jpg\" /></span>" +
        "</div>" +
        "<div class=\"our-services-text\">" +
        "<h4>"+ cname +"</h4>" +
        "<p>"+cintro+"</p>\n" +
        "</div>" +
        "</div>" +
        "</div>" +
        "</a>" +
        "</div>";
	});

    	//写入
        $('section#services').html(html);
}