<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
   <title>Dream Jeju</title>
  <link rel="stylesheet" href="css/style.css">
  <%@ include file="../common/commonfiles.jsp" %>
  <script>
   function call2(){
 	 $.ajax({
 		 url:"picAjax.do",
 		 //data:"",
 		 method:"get",
 		 success:function(responseData){
 			 //2)JSON받기 
 			 var datas = JSON.parse(responseData);  
   			 var arr = datas.picList;
   			 console.log(arr);
   			 var output =`<h2>갤러리 내용입니다.</h2>
   						<ul>`                         
   		     var nameArr  = [];
   			 $.each(arr, function(index, item){ 
   				 var path = "${path}";
   				 nameArr.push(item.mname);
   				 output +="<li><img src='" + path + "/uploads/" + item.pic + 
   				           "' width='100' height='100'></li>";  
   			 });
   						
   			 $("#gallery").html(output + "</ul>");
   			 
 			 //1) HTML로 받은경우 
 			 /*
 			 $("#gallery").html(responseData);*/
 	 		 
 	 		 
 	 		$("#gallery ul li img").each(function(index, item){
 	 			var img = $(item).attr("src");
 	 			
 	 			$("#quick-icon"+(index+1))
 	 			      .css("background-image","url(" + img + ")");
 	 			console.log(nameArr[index]);
 	 			$("#quick-icon"+(index+1)+ " ~ p").text(nameArr[index]);
 	 			
 	 		});
 	 
 	 
 		 },
 		 error:function(message){
 			 alert("오류" +  message);
 			 console.log(message);
 		 }
 	 });
  }
  
     function call(){
    	 alert("a누름");
    	 $.ajax({
    		 url:"jobsAjax.do",
    		 //data:"",
    		 method:"get",
    		 success:function(responseData){
    			 //2)JSON으로 받은data처리 
    			 var datas = JSON.parse(responseData); //{"jobList":[{"job_id":'IT'},{},{}   ]}
    			 var arr = datas.jobList;
    			 var output = '<ul>';
    			 
    			 $.each(arr.slice(0,5) , function(index, item){ 				 
    				 output+=`<li>${"${item['job_id']}"}****${"${item['job_title']}"}</li>`;
    			 	 //
    			 	 //output+=`<li>${item['job_id']}</li>`;  
    			 	 //${aa}
    			 	 /* output+=`<li>${"${item['job_id']}"}</li>`;  */
    			 });
    			 $("#here").html(output + "</ul>");
    			 
    			  
    			 
    			 
    			 //1) HTML로 받은경우 
    			 //$("#here").html(responseData);
    		 },
    		 error:function(message){
    			 alert("오류" +  message);
    			 console.log(message);
    		 }
    	 });
     }
  </script>
</head>
<body>
  <div id="container">    
    <header>
      <div id="logo">
        <a href="index.html">
          <h1>Dream Jeju</h1>
        </a>
      </div>
      <nav>
        <ul id="topMenu">
          <li><a href="#">단체 여행 <span>▼</span></a>
            <ul>
              <li><a href="#">회사 연수</a></li>
              <li><a href="#">수학 여행</a></li>
            </ul>
          </li>
          <li><a href="#">맞춤 여행  <span>▼</span></a>
            <ul>
              <li><a href="#">4.3 평화 기행</a></li>
              <li><a href="#">곶자왈 체험</a></li>
              <li><a href="#">힐링 워크샵</a></li>
            </ul>
          </li>
          <li><a href="javascript:call2()">갤러리</a></li>
          <li><a href="javascript:call()">문의하기</a></li>
        </ul>
      </nav>
    </header>
    <div id="slideShow">
      <div id="slides">
        <img src="images/photo-1.jpg" alt="">
        <img src="images/photo-2.jpg" alt="">
        <img src="images/photo-3.jpg" alt="">
        <button id="prev">&lang;</button>
        <button id="next">&rang;</button>
      </div>
    </div>
    <div id="contents">
      <div id="tabMenu">
        <input type="radio" id="tab1" name="tabs" checked>
        <label for="tab1">공지사항</label>
        <input type="radio" id="tab2" name="tabs">
        <label for="tab2">갤러리</label>      
        <div id="notice" class="tabContent">
          <h2>공지사항 내용입니다.</h2>
          <div id="here">
	          <ul>            
	            <li>사무실을 이전했습니다</li>
	            <li>[참가 모집] 카약 체험에 초대합니다.</li>
	            <li>[참가 모집] 여름 방학 기간, 오름 체험단을 모집합니다.</li>
	            <li>겨울, 추천 여행지</li>
	            <li>가을, 추천 여행지</li>            
	          </ul>
          </div>
        </div>
        <div id="gallery" class="tabContent">
          <h2>갤러리 내용입니다.</h2>
          <ul>
            <li><img src="images/img-1.jpg"></li>
            <li><img src="images/img-2.jpg"></li>
            <li><img src="images/img-3.jpg"></li>
            <li><img src="images/img-1.jpg"></li>
            <li><img src="images/img-2.jpg"></li>
            <li><img src="images/img-3.jpg"></li>                     
          </ul>
        </div>        
      </div>
      <div id="links">
        <ul>
          <li>
            <a href="#">
              <span id="quick-icon1"></span>
              <p class="adminname">평화기행</p>
            </a>
          </li>
          <li>
            <a href="#">
              <span id="quick-icon2"></span>
              <p class="adminname">힐링 워크샵</p>
            </a>            
          </li>
          <li>
            <a href="#">
              <span id="quick-icon3"></span>
              <p class="adminname">문의하기</p>
            </a>            
          </li>
        </ul>
      </div>
    </div>  
    <footer>    
      <div id="bottomMenu">
        <ul>
          <li><a href="#">회사 소개</a></li>
          <li><a href="#">개인정보처리방침</a></li>
          <li><a href="#">여행약관</a></li>
          <li><a href="#">사이트맵</a></li>
        </ul>
        <div id="sns">
          <ul>
            <li><a href="#"><img src="images/sns-1.png"></a></li>
            <li><a href="#"><img src="images/sns-2.png"></a></li>
            <li><a href="#"><img src="images/sns-3.png"></a></li>
          </ul>
        </div>
      </div>
      <div id="company">
        <p>제주특별자치도 ***동 ***로 *** (대표전화) 123-456-7890</p> 
      </div>     
    </footer>  
  </div> 

  <script src="js/slideshow.js"></script>
</body>
</html>