(()=>{
//定义一个函数，可以将其连接为java中的类
		var ajax=function(){}
		//在变量ajax指向的类中添加成员，例如doAjaxGet函数，doAjaxPost函数
		ajax.prototype={
		   doAjaxGet:function(url,params,callback){
			      //创建XMLHttpRequest对象，基于此对象发送请求
			      const xhr=new XMLHttpRequest();
			      //设置状态监听(监听客户端与服务端通讯的状态)
			      xhr.onreadystatechange=function(){//回调函数，事件处理函数
			          if(xhr.readyState==4&&xhr.status==200){
			             //console.log(xhr.responseText);
			             callback(xhr.responseText);//jsonStr
			          }
			      };
			      //建立连接(请求方式为Get,请求url,异步还是同步-true表示异步)
			      xhr.open("GET",url+"?"+params,true);
			      //发送请求
			      xhr.send(null);//GET请求send方法不写内容
			    },
			    
		      doAjaxPost:function(url,params,callback){
			      //创建XMLHttpRequest对象，基于此对象发送请求
			      const xhr=new XMLHttpRequest();
			      //设置状态监听(监听客户端与服务端通讯的状态)
			      xhr.onreadystatechange=function(){//回调函数，事件处理函数
			          if(xhr.readyState==4&&xhr.status==200){
			             //console.log(xhr.responseText);
			             callback(xhr.responseText);//jsonStr
			          }
			      };
			      //建立连接(请求方式为POST,请求url,异步还是同步-true表示异步)
			      xhr.open("POST",url,true);
			      //pos
			      xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			      xhr.send(params);
		      }
		}
		
		window.Ajax=new ajax();
})();	