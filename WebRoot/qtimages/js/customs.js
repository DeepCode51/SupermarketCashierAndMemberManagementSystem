// 幻灯片
$(function() {
    $('#slides').slidesjs({
        width: 1182,
        height: 432,
        play: {
            active: true,
            auto: true,
            interval: 4000,
            swap: true
        }
    });
});

// 响应式菜单
function createMobileMenu(menu_id, mobile_menu_id) {
    // 创建下拉选项
    jQuery("<select />").appendTo(menu_id);
    jQuery(menu_id).find('select').first().attr("id", mobile_menu_id);

    // 填充下拉选项
    jQuery(menu_id).find('a').each(function() {
        var el = jQuery(this);

        var selected = '';
        if (el.parent().hasClass('current-menu-item') == true) {
            selected = "selected='selected'";
        }

        var depth = el.parents("ul").size();
        var space = '';
        if (depth > 1) {
            for (i = 1; i < depth; i++) {
                space += '&nbsp;&nbsp;';
            }
        }

        jQuery("<option " + selected + " value='" + el.attr("href") + "'>" + space + el.text() + "</option>").appendTo(jQuery(menu_id).find('select').first());
    });
    jQuery(menu_id).find('select').first().change(function() {
        window.location = jQuery(this).find("option:selected").val();
    });
}

jQuery(document).ready(function() {
    if (jQuery('.header-menu').length > 0) {
        createMobileMenu('.header-menu', 'responsive-nav');
    };
});


// 暗窗弹出
$(function(){
    $('.boxer').boxer({
        requestKey: 'abc123',
        labels: {
            close: "关闭",
            count: "/",
            next: "下一个",
            previous: "上一个"
        }
    });
});


//回顶部
$(window).scroll(function() {
    if ($(window).scrollTop() > 400) {
        $("#back-to-top").fadeIn(200);
    } else {
        $("#back-to-top").fadeOut(200);
    }
});

$('#back-to-top, .back-to-top').click(function() {
    $('html, body').animate({
        scrollTop: 0
    }, '800');
    return false;
});

//友情链接图标显示
$("#link-page a").each(function(e){
$(this).prepend("<img src=other/.com/s2/favicons?domain="+this.href.replace(/^(http:\/\/[^\/]+).*$/, '$1').replace( 'http://', '' )+">");
});


// 字体大小写切换
jQuery(document).ready(function($){
//调节字体大小
     $('#font-change span').click(function() {
         // 选择器
         var selector='.entry,.entry p';
         // 每次增加字体大小
         var increment=1;
         // 默认字体大小
         var font_size = 13; 
         // 获取当前字体大小和单位
         var fs_css = $(selector).css('fontSize');
         var fs_css_c = parseFloat( fs_css, 10);
         var fs_unit = fs_css.slice(-2);        
         var id = $(this).attr('id');
         switch(id) {
         case 'font-dec': fs_css_c -= increment; break;
         case 'font-inc': fs_css_c += increment; break;
         default: fs_css_c = font_size;      
         }
         $(selector).css('fontSize', fs_css_c + fs_unit);
         return false;
     });
});


// 简码中的开关盒
jQuery(document).ready(function(){    
    // Toggle Box
    jQuery("ul.gdl-toggle-box li").each(function(){
        jQuery(this).children(".toggle-box-content").not(".active").css('display','none');
        
        jQuery(this).children(".toggle-box-head").bind("click", function(){
            jQuery(this).children().addClass(function(){
                if(jQuery(this).hasClass("active")){
                    jQuery(this).removeClass("active");
                    return "";
                }
                return "active";
            });
            jQuery(this).siblings(".toggle-box-content").slideToggle();
        });
    });
});



// 在新窗口打开评论者链接
function externallinks() 
{ 
if (!document.getElementsByTagName) return; 
var anchors = document.getElementsByTagName("a"); 
for (var i=0; i<anchors.length; i++) 
 { 
var anchor = anchors[i]; 
if (anchor.getAttribute("href") && anchor.getAttribute("rel") == "external nofollow") 
 { 
 anchor.target = "_blank"; 
 } 
 } 
} 
window.onload = externallinks;



/*作品集图片滚动*/
jQuery.extend(jQuery.easing,{
    easeInSine: function (x, t, b, c, d) {
        return -c * Math.cos(t/d * (Math.PI/2)) + c + b;
    }
});
(function($){   
    $.fn.xslider=function(settings){
        settings=$.extend({},$.fn.xslider.defaults,settings);
        this.each(function(){
            var scrollobj=settings.scrollobj || $(this).find("ul");
            var maxlength=settings.maxlength || (settings.dir=="H" ? scrollobj.parent().width() : scrollobj.parent().height());//length of the wrapper visible;
            var scrollunits=scrollobj.find("li");//units to move;
            var unitlen=settings.unitlen || (settings.dir=="H" ? scrollunits.eq(0).outerWidth() : scrollunits.eq(0).outerHeight());
            var unitdisplayed=settings.unitdisplayed;//units num displayed;
            var nowlength=settings.nowlength || scrollunits.length*unitlen;//length of the scrollobj;
            var offset=0;
            var sn=0;
            var movelength=unitlen*settings.movelength;
            var moving=false;//moving now?;
            var btnright=$(this).find("a.aright");
            var btnleft=$(this).find("a.aleft");
            
            if(settings.dir=="H"){
                scrollobj.css("left","0px");
            }else{
                scrollobj.css("top","0px");
            }
            if(nowlength>maxlength){
                btnleft.addClass("agrayleft");
                btnright.removeClass("agrayright");
                offset=nowlength-maxlength;
            }else{
                btnleft.addClass("agrayleft");
                btnright.addClass("agrayright");
            }

            btnleft.click(function(){
                if($(this).is("[class*='agrayleft']")){return false;}
                if(!moving){
                    moving=true;
                    sn-=movelength;
                    if(sn>unitlen*unitdisplayed-maxlength){
                        jQuery.fn.xslider.scroll(scrollobj,-sn,settings.dir,function(){moving=false;});
                    }else{
                        jQuery.fn.xslider.scroll(scrollobj,0,settings.dir,function(){moving=false;});
                        sn=0;
                        $(this).addClass("agrayleft");
                    }
                    btnright.removeClass("agrayright");
                }
                return false;
            });
            btnright.click(function(){
                if($(this).is("[class*='agrayright']")){return false;}
                if(!moving){
                    moving=true;
                    sn+=movelength;
                    if(sn<offset-(unitlen*unitdisplayed-maxlength)){
                        jQuery.fn.xslider.scroll(scrollobj,-sn,settings.dir,function(){moving=false;});
                    }else{
                        jQuery.fn.xslider.scroll(scrollobj,-offset,settings.dir,function(){moving=false;});//滚动到最后一个位置;
                        sn=offset;
                        $(this).addClass("agrayright");
                    }
                    btnleft.removeClass("agrayleft");
                }
                return false;
            });
            
            if(settings.autoscroll){
                jQuery.fn.xslider.autoscroll($(this),settings.autoscroll);
            }
            
        })
    }
})(jQuery);

jQuery.fn.xslider.defaults = {
    maxlength:0,
    scrollobj:null,
    unitlen:0,
    nowlength:0,
    dir:"H",
    autoscroll:null
};
jQuery.fn.xslider.scroll=function(obj,w,dir,callback){
    if(dir=="H"){
        obj.animate({
            left:w
        },500,"easeInSine",callback);
    }else{
        obj.animate({
            top:w
        },500,"easeInSine",callback);   
    }
}
jQuery.fn.xslider.autoscroll=function(obj,time){
    var  vane="right";
    function autoscrolling(){
        if(vane=="right"){
            if(!obj.find("a.agrayright").length){
                obj.find("a.aright").trigger("click");
            }else{
                vane="left";
            }
        }
        if(vane=="left"){
            if(!obj.find("a.agrayleft").length){    
                obj.find("a.aleft").trigger("click");
            }else{
                vane="right";
            }
        }
    }
    var scrollTimmer=setInterval(autoscrolling,time);
    obj.hover(function(){
        clearInterval(scrollTimmer);
    },function(){
        scrollTimmer=setInterval(autoscrolling,time);
    });
}

$(function(){
//默认状态下左右滚动
$("#por").xslider({
    unitdisplayed:4,
    movelength:1,
    autoscroll:5000
});

})


// 边栏随窗口移动
$.fn.extend({
    scrollFollow: function(d) {
        d = d || {};
        d.container = d.container || $(this).parent();
        d.bottomObj = d.bottomObj || '';
        d.bottomMargin = d.bottomMargin || 0;
        d.marginTop = d.marginTop || 0;
        d.marginBottom = d.marginBottom || 0;
        d.zindex = d.zindex || 10;
        var e = $(window);
        var f = $(this);
        if (f.length <= 0) {
            return false
        }
        var g = f.position().top;
        var h = d.container.height();
        var i = f.css("position");
        if (d.bottomObj == '' || $(d.bottomObj).length <= 0) {
            var j = false
        } else {
            var j = true
        }
        e.scroll(function(a) {
            var b = f.height();
            if (f.css("position") == i) {
                g = f.position().top
            }
            scrollTop = e.scrollTop();
            topPosition = Math.max(0, g - scrollTop);
            if (j == true) {
                var c = $(d.bottomObj).position().top - d.marginBottom - d.marginTop;
                topPosition = Math.min(topPosition, (c - scrollTop) - b)
            }
            if (scrollTop > g) {
                if (j == true && (g + b > c)) {
                    f.css({
                        position: i,
                        top: g
                    })
                } else {
                    if (window.XMLHttpRequest) {
                        f.css({
                            position: "fixed",
                            top: topPosition + d.marginTop,
                            'z-index': d.zindex
                        })
                    } else {
                        f.css({
                            position: "absolute",
                            top: scrollTop + topPosition + d.marginTop + 'px',
                            'z-index': d.zindex
                        })
                    }
                }
            } else {
                f.css({
                    position: i,
                    top: g
                })
            }
        });
        return this
    }
});


$(document).ready(function() {
    $(".sidebar .move").scrollFollow({
        bottomObj: '.footer',
        marginTop: 20,
        marginBottom: 42
    })
});