<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" type="text/css" href="/ bootstrap/bootstrap.min.css">


    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.8.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.8.1/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.8.1/demo.css">

    <script type="text/javascript" src="/jquery-easyui-1.8.1/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.8.1./jquery.easyui.min.js"></script>

    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>




    <style>

            .yongyin {

                width:100px;

                text-align:center;

                line-height:100%;

                padding:0.3em;

                font:16px Arial,sans-serif bold;

                font-style:normal;

                text-decoration:none;

                margin:2px;

                vertical-align:text-bottom;

                zoom:1;

                outline:none;

                font-size-adjust:none;

                font-stretch:normal;

                border-radius:50px;

                box-shadow:0px 1px 2px rgba(0,0,0,0.2);

                text-shadow:0px 1px 1px rgba(0,0,0,0.3);

                color:#fefee9;

                border:0.2px solid #2299ff;

                background-repeat:repeat;

                background-size:auto;

                background-origin:padding-box;

                background-clip:padding-box;

                background-color:#3399ff;

                background: linear-gradient(to bottom, #eeeff9 0%,#3399ff 100%);

            }



            .yongyin:hover {

                background: #268DFF;

            }

        </style>

</head>




<head>




<body >




<div class="easyui-layout" fit="true">
		
		
		<div data-options="region:'east',split:true" title="用户信息" style="width:180px;">
         <div  style="width:400px; height:120px; padding-left:50px; padding-top:10px; background-color:#FFFFFF;">
           <div   style="width: 74px; height: 74px; float:left; border-radius: 50%; border: 3px solid #eee; overflow: hidden;"> 

          <img src="/images/tx1.JPG" width="80" height="80" />

         </div> 

 </div>  
			<div id="sm" class="easyui-sidemenu" data-options="data:data"></div>
	<script type="text/javascript">
		var data = [{
	        text: '个人信息',
	        iconCls: 'icon-sum',
	        state: 'open',
	        children: [{
	            text: '基本信息'
	        },{
	            text: '修改查询'
	        },{
	            text: '工资查询',
	            children: [{
	                text: '上班打卡情况'
	            },{
	                text: '实发工资'
	            }]
	        }]
	    },{
	        text: '修改信息',
	        iconCls: 'icon-more',
	        children: [{
	            text: '修改基本信息'
	        },{
	            text: '申请工资调整'
	        }]
	    }];
 
		function toggle(){
			var opts = $('#sm').sidemenu('options');
			$('#sm').sidemenu(opts.collapsed ? 'expand' : 'collapse');
			opts = $('#sm').sidemenu('options');
			$('#sm').sidemenu('resize', {
				width: opts.collapsed ? 60 : 200
			})
		}
	</script>

		</div>
		<div data-options="region:'west',split:true" title="商品管理" style="width:200px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="查询商品"  data-options="selected:true" style="padding:10px;">
                    <a id="btn2" href="javascript:void(0)" class="easyui-linkbutton"  data-options="plain:true,iconCls:'icon-search'" style="height:30px;width:150px;" iconAlign="left"  onclick="addPanel()">按进货日期查询</a>
                    <a id="btn3" href="javascript:void(0)" class="easyui-linkbutton"  data-options="plain:true,iconCls:'icon-search'" style="height:30px;width:150px;"  iconAlign="left" onclick="addPanel()">按价格区间查询</a>
                </div>
				<div title="添加商品"  style="padding:10px;">
					 <a   class="easyui-linkbutton" href="http://localhost:8080/add" data-options="iconCls:'icon-add'" style="height:30px;width:150px;"  >添加商品</a>
				</div>
                <div title="修改商品信息" style="padding:10px">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="height:30px;width:150px;" >修改信息</a>
				</div>
				<div title="添加备注" style="padding:10px">
					 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="height:30px;width:150px;" >添加备注</a>
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'功能区',iconCls:'icon-ok'">
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="信息展示"  style="padding:5px">
                    <div class="easyui-panel" style="width:100%;max-width:400px;padding:30px 60px;">
                        <input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:100%">
                    </div>
                    <script>
                        function doSearch(value){
                            window.location.href = "http://localhost:8080/find/"+value;
                        }
                    </script>
                   <#list users>
        <table class="table table-hover table-success table-bordered table-condensed table-striped" >
            <thead>
            <tr>
                <th>#</th>
                <th>姓名</th>
                <th>密码</th>
				<th>修改</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
                <#items as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
					<td>
                        <a class="yongyin btn"   href="http://localhost:8080/edit/${user.id}">编辑</a>
                    </td>
                    <td>
                        <a class="yongyin btn"   href="http://localhost:8080/delete/${user.id}">删除</a>
                    </td>

                </tr>
				</#items>
            </tbody>
        </table>

				   </#list>
            </div>
			</div>
		</div>
	</div>

</body>
</html>