var category = 1;//活动类别
var data2 = [];
var cateName = "运营活动";//标题
//ajax	
function selectByCategory() {
	 var data3 = {};
	 category = ""+category; 
	    data3["category"] = category;//封装一个对象
		$.ajax({
	        url: '/management/admin_Action_selectByCategory?', // 请求的Controller
	        type: 'post', // 请求方式
	        dataType: 'json', // 发送的数据类型
	        crossDomain: true,
	        data: JSON.stringify(data3),// 要提交给服务端的数据
	        success: function (json) {
	        	
	        	console.log("chenggong");
	        	console.log(json);
	        	console.log("遍历数组");
	            $.each(json, function (index, item) {
	            	 $.each(item, function (i, obj ) {
	            		 var data1=[];
	            		 data1["aid"] = obj.aid;
	                 	data1["aintro"] = obj.aintro;
	                 	data1["aname"] = obj.aname;
	                 	data2[index] = data1;
	                 });
	            });
	            console.log(data2);
	            showActivity();
	        	}
	        });
	}


//外部点击获取catrgory
$(document).ready(function () {
//	获取cid参数
function getid(name) {
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);//匹配目标参数
if (r != null) return unescape(r[2]);//返回参数值
return null;
};
   category = getid('aid');
console.log(category);

selectByCategory();
});

//页面内实现跳转 获取 category
function getPageCategory_1() { category = 1;cateName = "运营活动";selectByCategory();}

function getPageCategory_2() { category = 2;cateName = "志愿活动";selectByCategory();}

function getPageCategory_3() { category = 3;cateName = "教育活动";selectByCategory();}

function getPageCategory_4() { category = 4;cateName = "党建活动";selectByCategory();}

function getPageCategory_5() { category = 5;cateName = "体育活动";selectByCategory();}

function showActivity() {
	console.log("xuanran");
	console.log(data2);
	var no = 1;//活动编号
	var sub = "新学期，民大重点做好这“四件大事”！ ";//简介
	var xiangqing = "民大下半年工作的重点已划好！8月29日上午，我校召开2019年下半年工作部署会议。会上总结了我校上半年各项工作取得的成果，并对下半年的工作任务进行部署。上半年取得的阶段性成果为我们继续奋进奠定了坚实基础 回顾一下，新学期再出发！爬坡上坎、负重前行民大以优异的成绩向中华人民共和国成立70周年献礼！"//详情
	//内容渲染
	var html = "";
	$('div.right').empty();
	//活动名称
	html += "<div class=\"right_Title\">"+
    "<div class=\"right_Title_1\">"+cateName+"</div>" +
     "</div>";
	//活动详情
	$.each(data2, function (index, item) {
		var aid = item.aid - (category-1)*3;//活动序号
      	var aintro = item.aintro;//活动详情
      	var aname = item.aname;//活动名称
      	console.log("chuanshu");
      	console.log(item);
	html += "<div class=\"right_div\">" +
	"<div class=\"right_div_left\">" +
			"<img style=\"height: 270px ; width:500px;\" src=\"picture/act_"+category+"_"+aid+".jpg\"></img></div>" +
			"<div class=\"right_div_right\">"+
			"<div>" +
			"<div class=\"right_biaoti\">"+aname+"</div>" +
			" <div class=\"right_xiangqing\">"+aintro+"</div></div></div></div>";
	}); 
	//写入
	$('div.right').html(html);
	data2=[];
}

