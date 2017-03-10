/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 角色管理左新增，修改按钮
 */
Ext.define('app.view.rolemanage.RoleAEBtnContainer',{
    extend:'Ext.container.Container',
    xtype:'rolemodifybtn',
    height:60,
    layout:{
        type:'hbox',
        align: 'middle',
        pack:'end'
    },
    items: [
        {
            xtype:'addbtn',
            bind:{
                text:'{add}'
            },
            handler:'add'
        },
        {
            xtype:'editbtn',
            bind:{
                text:'{edit}'
            },
            handler:'edit'
        }
    ]

});