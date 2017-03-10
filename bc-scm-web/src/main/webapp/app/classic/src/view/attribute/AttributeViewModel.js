/**
 * Created by Intellij IDEA 14.
 *User:fengbaitong
 *Date:2015/12/26
 *Time:11:05
 *Project:bc-scm
 */

Ext.define('app.view.attribute.AttributeViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.attribute',

    requires: [
        'app.store.attribute.AttributeGridStore',
        'app.store.category.CategoryTreeStore',
        'app.store.attribute.AttrValueGridStore'
    ],

    stores: {
        attributeGridStore:{
            type:'attributegridstore'
        },
        treeStore: {
            type: 'categorytreestore'
        },
        attrValueGridStore:{
            type: 'attrvaluegridstore'
        }

    }
});
