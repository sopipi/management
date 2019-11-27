

var data2=[];//对象数组
$(document).ready(function () {
	var html = "";
	html += "";
	 var data3 = {};
	    data3["flag"] = 5;//封装一个对象
	 
	console.log("加载成功")
	
	$.ajax({
        url: '/management/admin_Club_showRandClub?', // 请求的Controller
        type: 'post', // 请求方式
        dataType: 'json', // 发送的数据类型
        crossDomain: true,
        data: JSON.stringify(data3),// 要提交给服务端的数据
        success: function (json) { // 请求成功后如何处理结果?，json其实就是服务端返回的响应内容
            console.log(json); // 打印到控制看一看
            //数据样例
            /**
             * {
    "club": {
        "bulidTime": null,
        "chairman": "201731104180",
        "cid": 1,
        "cintro": "new introduction!",
        "cname": "Computer Science",
        "vicechairman": "201731104180"
    }
}
             */
            
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
            goodclub();
           
        }
    });
	
});

function goodclub(){	
	console.log('传递的数据');
	console.log(data2.length);
	var count = data2.length;
	var html = "";
	$("div#goodclub").empty();
	html += "";
	//上部分
	html += "<div class=\"row mt-lg-5\">"
		+ "<div class=\"col-xl-4 col-lg-4 col-md-6 col-sm-12 mb-md-0 mb-4\">"
		+ "<h4 class=\"heading mt-3 ml-3\">2019年 <br/>西南民族大学 <br/> 优秀社团展示</h4>"
		+ "</div>";
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
	//底部
	html += "</div>";
	//拼接数据
	/**
	 * 		
			<div class="col-xl-4 col-lg-4 col-md-6 col-sm-12">
			  <a href="about.html" class="a_url" id = "cid_1">
				<div class="our-services-wrapper mb-60">
					<div class="services-inner">
						<div class="our-services-icon">
							<span class="fa fa-ship" aria-hidden="true"><img src="picture/acm.jpg" /></span>
						</div>
						<div class="our-services-text">
							<h4>SMUACM俱乐部</h4>
							<p>自2005年组建ACM集训队，由谈文蓉、校景中、周绪川老师任教练，于同年参加第29届ACM国际大学生程序竞赛亚洲区决赛，目前已连续参加15届。</p>
						</div>
					</div>
				</div>
			 </a>
			</div>
	 */
	
	
	//写入
	$("div#goodclub").html(html);
}
