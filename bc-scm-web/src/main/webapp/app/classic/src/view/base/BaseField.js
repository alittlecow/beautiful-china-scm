/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 15/12/25
 */
Ext.define('app.view.base.BaseField', {
    override: 'Ext.form.field.Base',
    initComponent:function(){
        if(this.allowBlank!==undefined && !this.allowBlank){
            var bind = this.getBind();
            if(bind && bind.fieldLabel){
                if(bind.fieldLabel.stub){
                    this.setBind({fieldLabel:"{"+bind.fieldLabel.stub.name+"}<span style='color:red;font-weight:bold'>*</span>"});
                }
            }
        }
        this.callParent(arguments);
    }
});