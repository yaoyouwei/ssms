
MenuTreePanel = function(loader,targetTabPanel) {
	/*this.toolBar = new Ext.Toolbar({
		items:[{
				iconCls:'x-tbar-loading',
		        id : 'refreshCountBtn',
		        text : "更新所有任务", 
		        handler: this.taskMenuUpdate,
		        scope: this
		    }]
	});*/
	this.targetTabPanel = targetTabPanel;
	MenuTreePanel.superclass.constructor.call(this, {
		title:"Web系统通用管理",
 	    region:'west',
        animate:true,
        trackMouseOver:false,//是否只有叶子节点可选  
        collapsible:true,
        enableDD:true,//不仅可以拖动,还可以通过Drag改变节点的层次结构(drap和drop)
        enableDrag:true,//树的节点可以拖动,注意不是Draggable  
        rootVisible:true,
        autoScroll:true,
        //autoHeight:true,
        lines:true,//树的虚线
        //useArrows:true,
        width:200,
        minSize: 175,
        maxSize: 400,
        split:true,
        //tbar: this.toolBar,
        loader:loader
    });
	
	var root=new Ext.tree.AsyncTreeNode({//根节点
        id:"root",
        text:"根",
        expanded:true
    });
    this.setRootNode(root);
    this.getSelectionModel().on({
    	
        'beforeselect' : function(node,e){
             //console.log(node);
        },
        'selectionchange' : function(sm, node){
        },
        scope:this
    });
    //this.addEvents({feedselect:true});

    this.on('click', this.addTab, this);    
};

Ext.extend(MenuTreePanel, Ext.tree.TreePanel, {
    showWindow : function(btn){
    	
    },
    addTab:function(node){
    	//console.log(node);
    	this.targetTabPanel.add({
    		id:'tab-'+node.id,
            title: node.text,
            iconCls: 'tabs',
			html:'<iframe src="'+node.attributes.url+'" name="ifrmname" id="ifrm-'+node.id+'"  target="_top" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>',
            closable:true
        }).show();
    }
});