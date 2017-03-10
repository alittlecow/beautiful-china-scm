Ext.define('app.view.base.BaseController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.base',
    init: function (view) {
        this.me = this;
    },

    /**
     * 重置
     * @param v
     */
    reset: function (v) {
        var form = v.up('form').getForm().reset();
    },

    /**
     * 获取国际化资源文件
     * @param param
     * @param viewModel
     */
    getInternationalPro: function (param, viewModel) {

        var params = param || {};
        var me = this;
        App.Ajax.req({
            params: params,
            url: basePath + '/main/properties',
            success: function (response, opts) {
                var result = Ext.JSON.decode(response.responseText);

                // 装载name:value 下拉框数据
                for (var p in result) {
                    var end = p.indexOf("_JSON");
                    if (end > -1) {
                        var data = result[p];
                        me.createCommonStore(p.substr(0, end), data);
                        delete result[p];
                    }
                }
                viewModel.setData(result);
            }
        });
    },

    /**
     * 根据key获取viewModel中的值
     * @param key
     * @param scope
     * @returns {*}
     */
    getData: function (key) {
        var data = this.getViewModel().data[key];
        return data;
    },

    /**
     * 请选择一条数据经行操作
     * @param record
     */
    oneSelectVali: function (record) {
        var ret = this.selectVali(record);
        if (ret == true && record.length > 1) {
            App.Msg.warn('', this.getData("mainMsg_101"));
            ret = false;
        }
        return ret;
    },

    /**
     * 是否选择行验证
     * @param record
     */
    selectVali: function (record) {
        if (record.length == 0) {
            App.Msg.warn('', this.getData("mainMsg_102"));
            return false;
        }
        return true;
    },

    /**
     * 查询
     * @param v
     */
    query: function (v) {

        // TODO 防止频繁点击刷新，禁用按钮
        var form = v.up('form');

        if (true != form.isValid()) {
            return;
        }
        var grid = form.nextSibling("grid");
        var store = grid.getStore();
        var params = form.getForm().getValues();
        // 删除空值
        Ext.Object.each(params, function (key, value, myself) {
            if (Ext.Object.isEmpty(value)) {
                delete params[key];
                if (store.proxy.extraParams[key]) {
                    delete store.proxy.extraParams[key];
                }
            }
        });
        Ext.apply(store.proxy.extraParams, params);
        store.load();
    },

    /**
     * 创建公共的Store
     * @param model
     * @param id
     * @param data
     */
    createCommonStore: function (id, data) {
        var store = Ext.create("Ext.data.Store", {
            fields: ["name", "value"],
            data: data,
            storeId: id
        });
    },

    /**
     * 表格值与显示转换
     * @param value
     * @param m
     * @returns {*|Object}
     * 需配置renderName:"normalStop",renderer: "render"
     * renderName现包含:
     * 1:normalStop 正常停用
     * 2:yesNO 是否
     */
    render: function (value, m) {
        var store = Ext.StoreMgr.lookup(m.column.renderName);
        var model = store.findRecord('value', value);
        var retValue = model.get('name');
        return retValue;
    },

    /**
     * 重复密码验证
     * @param field
     */
    validateField: function (field) {
        field.next().validate();
    },

    /**
     * 创建窗口
     * @param xtype
     * @param config
     */
    createWin: function (xtype, config, scope) {
        var win = Ext.widget(xtype, config);
        win.getViewModel().setData(scope.getViewModel().getData());
        return win;
    },

    // 多语言处理方法
    /**
     * 获取多语言表单数据
     * @param form
     */
    getFormValues: function (form) {
        form.getForm().getFields().getRange().forEach(
            function (item) {
                var fieldName = item.getName(), fieldValue = item.getValue();
                if (form.multiLanguage.indexOf(fieldName) !== -1) {
                    var object = form.down('language[target=' + fieldName + ']');
                    form.formValues.multiLanguage[object.getStateId()][fieldName] = fieldValue;
                } else {
                    form.formValues[fieldName] = fieldValue;
                }
            });
        form.formValues.multiLanguage = Ext.JSON.encode(form.formValues.multiLanguage);
        return form.formValues;
    },
    /**
     * 获取编辑时多语言表单数据
     * @param id 记录识别码
     * @param url 数据url
     * @param form 待编辑表单
     */
    getmultiLanguage: function (id, url, form) {
        form.formValues = {};
        App.Ajax.req({
            url: basePath + url,
            params: {id: id},
            success: function (response) {
                form.formValues.multiLanguage = Ext.JSON.decode(response.responseText).data;
            }
        });
    },
    /**
     * 设置表单多语言参数
     * @param form 待设置表单
     */
    setFormValues: function (form) {
        var countryList = [];
        //获取多语言信息
        App.Ajax.req({
            url: basePath + "/language/getCountry",
            async: false,
            success: function (response) {
                countryList = Ext.JSON.decode(response.responseText);
            }
        });
        var singleLanguage = form.multiLanguage, fields = form.getForm().getFields().getRange();
        // 表单添加formValues属性
        form.formValues = {multiLanguage: {}};
        for (var i = 0, len = countryList.length; i < len; i++) {
            form.formValues.multiLanguage[countryList[i]] = {};
            fields.forEach(
                function (item) {
                    //设置需要多语言字段值
                    if (singleLanguage.indexOf(item.getName()) !== -1) {
                        form.formValues.multiLanguage[countryList[i]][item.getName()] = '';
                    }
                });
        }
    }
});