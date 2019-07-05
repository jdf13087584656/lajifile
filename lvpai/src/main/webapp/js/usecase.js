window.onload=function(){
    //点击事件
    let num=0;
    let cishu=0;
    let cishu2=1;
    let other=1;
    document.querySelector(".imgLeft").onclick=function(){
        //获取两个imgbox 的自定义属性值
        if(cishu==0){
            document.getElementsByClassName("CaseImgBox")[num].className="CaseImgBox activeImg";
            document.getElementsByClassName("CaseImgBox")[other].className="CaseImgBox"
            num=1;
            cishu=1;
            other=0;
        }else if(cishu==1){
            document.getElementsByClassName("CaseImgBox")[num].className="CaseImgBox activeImg";
            document.getElementsByClassName("CaseImgBox")[other].className="CaseImgBox";
            num=0;
            cishu=0;
            other=1;
        }
    }
    document.querySelector(".imgRight").onclick=function(){
        if(cishu2==1){
            document.getElementsByClassName("CaseImgBox")[num].className="CaseImgBox activeImg";
            document.getElementsByClassName("CaseImgBox")[other].className="CaseImgBox";
            num=0;
            cishu2=0;
            other=1;
        }else if(cishu2==0){
            document.getElementsByClassName("CaseImgBox")[num].className="CaseImgBox activeImg";
            document.getElementsByClassName("CaseImgBox")[other].className="CaseImgBox"
            num=1;
            cishu2=1;
            other=0;
        }
    }
   let mySwiper = new Swiper ('.swiper-container', {
        loop: true, // 循环模式选项;
        autoplay: {
            delay: 3000,
            stopOnLastSlide: false,
            disableOnInteraction: false,
        },
        // 如果需要分页器
        pagination: {
            el: '.swiper-pagination',
            type: 'fraction',
        },

        // 如果需要前进后退按钮
        navigation: {
            nextEl: '.button-next',
            prevEl: '.button-prev',
        },
    })
    //返回顶端
    document.getElementById("callMe").onclick=function(e){
        e.preventDefault();
        let nowBodyHeight=document.body.offsetHeight;
        document.documentElement.scrollTop=nowBodyHeight
    }

    document.getElementsByClassName("pageUp")[0].onclick=function(){
        //获取当前滚动条高度
        document.documentElement.scrollTop=0;       
    }
    
    
    document.getElementById("rightExeTopBox").onclick=function(){
        document.querySelector(".Ask").style.display="block"
        document.querySelector(".bodyShow").style.display="block";
    }
    document.querySelector(".bodyShow").onclick=function(){
        this.style.display="none";
        document.querySelector(".Ask").style.display="none"
    }
    //以下代码必须放到最后
    //使用案例页面轮播图js
}