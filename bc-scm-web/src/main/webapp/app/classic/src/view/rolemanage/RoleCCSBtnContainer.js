/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 角色管理右全选，清除，保存按钮
 */
Ext.define('app.view.rolemanage.RoleCCSBtnContainer',{
    extend:'Ext.container.Container',
    xtype:'rolesavebtn',
    height:60,
    layout:{
        type:'hbox',
        align: 'middle',
        pack:'end'
    },
    defaultType:'button',
    defaults:{
        height:30,
        width:75,
        margin:'0 20 0 0'
    },
    items: [
        {
            bind:{
                text:'{save}'
            },
            handler:'save'
        }
    ]
});