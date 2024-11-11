$(function(){
	window.onscroll = function(){
		var h = $(document).scrollTop();
		if(h > 200){
			$("#img11").addClass("animation11");
			$("#img12").addClass("animation12");
			//$("#an13").addClass("animation13");	
		}
		if(h > 500){
			$("#img21").addClass("animation21");
			$("#img22").addClass("animation22");
			//$("#an23").addClass("animation23");	
		}
		if(h > 700){
			$("#img31").addClass("animation31");
			$("#img32").addClass("animation32");
			//$("#an33").addClass("animation13");	
		}
		if(navigator.userAgent.indexOf("Mac OS X")>0) {
			$(".hbg,.banner").css('background-position-y', -h * .2);
		}
	}
	if($(window).width()>767){
		window.onload = window.onresize = function(){
		var h = $(window).height();
		$('.banner').height(h - 75);
		};
		$(".nav li").hover(function(){
		var num=$(this).children("dl").children("dd").length;
			if(num>0){
				$(this).children("dl").stop(true, true);
				$(this).children("dl").slideDown(100);
			};
		}, function(){
			$(this).children("dl").slideUp(100);
		});
		
	}else{
	//设置导航条样式
	function setNav(){
		var url = window.location.href,
			navA = $('.nav li a'),
			nameHtml = url.split("/"),
			name = nameHtml[nameHtml.length - 1],
			name1 = name.split("."),
			filtName = name1[0].split("_");
			navA.removeClass('check');
			switch(filtName[0]){
				case "index":navA.eq(0).addClass('check');
				break;
				case "about":navA.eq(10).addClass('check');
				break;
				case "media":navA.eq(11).addClass('check');
				break;
				case "market":navA.eq(12).addClass('check');
				break;
				case "joint":navA.eq(13).addClass('check');
				break;
				case "serve":
					var str1 = "plat",
						str2 = "spread brand mobile manage",
						str3 = "story media other";
					if(str1.match(filtName[1])){
						navA.eq(2).addClass('check');
					}else if(str2.match(filtName[1])){
						navA.eq(3).addClass('check');
					}else if(str3.match(filtName[1])){
						navA.eq(4).addClass('check');
					}
				break;
			}
	};
		setNav();
		
	}
	var d = document.location.href;
	if(d == 'http://www.bokecc.com/' || d.match("index.shtml")){
		$(".nav li dl").addClass("index");
		$(".hbg").css('background-attachment', 'fixed');	
	}
	
	$('.box_pic').hover(function(){
		$(".cover", this).stop().animate({top:'0px'},{queue:false,duration:160});
	}, function() {
		$(".cover", this).stop().animate({top:'-69px'},{queue:false,duration:160});
	});
	
	$("#wxico").hide();
	$(".ico_wx").hover(function(){
		$("#wxico").show();	
	})
	$("#wxico").mouseout(function(){
		$(this).hide();	
	})
	
	$("#tags li").click(function(){
		var index = $("#tags li").index(this);
		$(this).addClass("selecttag").siblings().removeClass("selecttag");
		$("#tagcontent > div").eq(index).show().siblings().hide();
		if(myScroll){
			 myScroll.refresh();//重新计算滚动条区域
		}
		
	})
	//控制导航的显示
	$(document).ready(function() {
		$('.menu').sidr();
	});

	$('body').touchwipe({
		wipeLeft: function() {
			$.sidr('close', 'sidr');
		},
		wipeRight: function() {
			$.sidr('open', 'sidr');
		},
		preventDefaultEvents: false
	});
	
	//融资发布会*/
	$('#v_01').click(function(){
		$('#v_box').show();
		overlay();//遮罩高宽计算
		var videohtml = videoHtml("cc_14CF5D7F9C3209FA","http://union.bokecc.com/flash/list/9822164826E2E283_14CF5D7F9C3209FA_list_true_58314F82EEEECD96_2/player.swf");
		$('#v_box').append(videohtml);
	});
	//开·合·云端开放战略发布会*/
	$('#v_02').click(function(){
		$('#v_box2').show();
		overlay();//遮罩高宽计算
		var videohtml = videoHtml("cc_88BF19B45A5F679A","http://union.bokecc.com/flash/list/9822164826E2E283_88BF19B45A5F679A_list_true_58314F82EEEECD96_2/player.swf");
		$('#v_box2').append(videohtml);
	});
	//远程教育技术创新与应用论坛*/
	$('#v_03').click(function(){
		$('#v_box3').show();
		overlay();//遮罩高宽计算
		var videohtml = videoHtml("cc_D43A08C60C775626","http://union.bokecc.com/flash/list/9822164826E2E283_D43A08C60C775626_list_true_58314F82EEEECD96_2/player.swf",
		'cc_14CF5D7F9C3209FA');
		$('#v_box3').append(videohtml);
	});
	//全媒体时代技术创新与应用研讨会
	$('#v_04').click(function(){
		$('#v_box4').show();
		overlay();//遮罩高宽计算
		var videohtml = videoHtml("cc_26DA3F668C906C39","http://union.bokecc.com/flash/list/9822164826E2E283_26DA3F668C906C39_list_true_58314F82EEEECD96_2/player.swf");
		$('#v_box4').append(videohtml);
	});
	//2013（第二届）中国远程教育技术创新与应用论坛
	$('#v_05').click(function(){
		$('#v_box5').show();
		overlay();//遮罩高宽计算
		var videohtml = videoHtml("cc_54B06EA81DDDDED69C33DC5901307461","http://union.bokecc.com/flash/single/9822164826E2E283_54B06EA81DDDDED69C33DC5901307461_true_C280448C06EA3B8A_2/player.swf");
		$('#v_box5').append(videohtml);
	});
	//视频中的关闭事件*/
	$('.close_v').click(function(){
		$('#overlay').hide();
		$(this).parent().hide();
		$(this).parent().children('object').remove();
		});
	function bodyInf(){
		var w = $('body').outerWidth(true),
			h = $('body').outerHeight(true);
		return [w,h];
	};
	//遮罩高宽计算
	 function overlay(){
		var data = bodyInf();
		$('#overlay').show();
		$('#overlay').css({
			width: data[0],
			height: data[1]
		});
	};
	//video视频代码
	 function videoHtml(id,src,name){
		var videohtml = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="750" height="490" id="'+id+'">'+
						'<param name="movie" value="'+src+'" />'+
						'<param name="allowFullScreen" value="true" />'+
						'<param name="allowScriptAccess" value="always" />'+
						'<embed src="'+src+'" width="750" height="490" name="'+id+'" allowFullScreen="true" allowScriptAccess="always" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash"/>'+
						'</object>';
		return videohtml;
	}; 

})