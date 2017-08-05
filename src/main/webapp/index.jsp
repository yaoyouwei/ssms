<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
  <title>首页</title>
	<jsp:include page="include.jsp"></jsp:include><!-- 位于head标签之间 -->
	<script type="text/javascript" src="./library/ext-2.0.2/custom/MenuTreePanel.js"></script>
    <!--<script language="javascript" src="/grid/PropsGrid.js"></script>-->
	<style type="text/css">
	html, body {
        font:normal 12px verdana;
        margin:0;
        padding:0;
        border:0 none;
        overflow:hidden;
        height:100%;
    }
    .settings {
        background-image:url(./resources/image/shared/icons/fam/folder_wrench.png);
    }
    .nav {
        background-image:url(./resources/image/shared/icons/fam/folder_go.png);
    }
    </style>
	<script type="text/javascript">
	
    Ext.onReady(function(){
    	
    	
       Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
       
       var southPanel = new Ext.BoxComponent({
           region:'south',
           el: 'south',
           height:20
       });
       
       var northPanel =  new Ext.BoxComponent({ // raw
           region:'north',
           el: 'north',
           height:32
       });
       
       
       var centerTabPanel = new Ext.TabPanel({
    	   region:'center',
    	   activeTab:0,
           //renderTo:'tabs',
           deferredRender:false,
           resizeTabs:true, // turn on tab resizing
           minTabWidth: 115,
           tabWidth:135,
           enableTabScroll:true,
           width:600,
           height:250,
           defaults: {autoScroll:true}
           //plugins: new Ext.ux.TabCloseMenu()
       });
       centerTabPanel.add({
   		   id:'tab-default',
           title: "首页",
           iconCls: 'tabs',
		   //html:'<iframe src="/login.jsp" name="ifrmname" id="ifrm-tab-default" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>',
		   html:'',
           closable:true
       }).show();
     //菜单树定义start===================================================================================
    	 var treeLoader= new Ext.tree.TreeLoader({//获取取数据
           dataUrl:"treedata.js"
       });
       var menuTreePanel = new MenuTreePanel(treeLoader,centerTabPanel);
       //menuTreePanel.render();
       //菜单树定义end=====================================================================================

       // tab generation code
       
       
       //布局
       var viewport = new Ext.Viewport({
            layout:'border',
            items:[ northPanel, southPanel, menuTreePanel, centerTabPanel]
        });
    });
	</script>
</head>
<body>
  <div id="treePanel"> </div>
  <div id="west">
  </div>
  <div id="north"></div>
  <div id="props-panel" style="width:200px;height:200px;overflow:hidden;">
  </div>
  <div id="south" style="text-align:center"> <p>Copyright© 2017-2020 YaoYouWei Corp</p> </div>

 </body>
</html>

