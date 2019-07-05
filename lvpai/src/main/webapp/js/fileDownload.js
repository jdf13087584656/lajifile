window.onload=function(){
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
	document.getElementsByClassName("pageUp")[0].onclick=function(e){
		//获取此前的高度
		let nowBodyTop=window.document.body.scrollTop
	}
	
	document.getElementById("rightExeTopBox").onclick=function(){
		document.querySelector(".Ask").style.display="block"
		document.querySelector(".bodyShow").style.display="block";
	}
	document.querySelector(".bodyShow").onclick=function(){
		this.style.display="none";
		document.querySelector(".Ask").style.display="none"
	}

	document.querySelector("#see_more").onclick=function(e){
		e.preventDefault();
		document.querySelector("#FileBox").style.height="100%";
		document.querySelector(".upList").style.display="block"

	}
	document.querySelector(".upList").onclick=function(){
		//判断此时窗口大小
		let nowBodyWd=document.body.offsetWidth;
		console.log(nowBodyWd);
		if(nowBodyWd<700){
			document.querySelector("#FileBox").style.height="864px";
		}else{
			document.querySelector("#FileBox").style.height="488px";
		}
		this.style.display="none";

	}
	window.onresize=function(){
		 let nowBodyWd=document.body.offsetWidth;
		if(nowBodyWd<700){
			document.querySelector("#FileBox").style.height="864px";
		}else{
			document.querySelector("#FileBox").style.height="488px";
		}
	};
	document.getElementById("callMe").onclick=function(e){
		e.preventDefault();
		let nowBodyHeight=document.body.offsetHeight;
		document.documentElement.scrollTop=nowBodyHeight
	}

	document.getElementsByClassName("pageUp")[0].onclick=function(){
		//获取当前滚动条高度
		document.documentElement.scrollTop=0;		
	}
	document.getElementsByClassName("subBtn")[0].onclick=function(){
			document.querySelector(".bodyShow").style.display="none";
			document.querySelector(".Ask").style.display="none"
		}
}