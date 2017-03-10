/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 属性值操作窗口
 * @author: fengbaitong
 * date: 2015-12-15
 */
Ext.define('app.view.attribute.AttrValueWindow', {
    extend: 'app.view.base.BaseWindow',
    xtype:'attrvaluewindow',
    controller:'attributewin',
    viewModel: {
        type: 'attribute'
    },
    width:600,
    height:400,
    requires: [
        'app.view.attribute.AttrValueGrid'
    ],
    items:[{
        xtype:'attrvaluegrid'
    }]
});