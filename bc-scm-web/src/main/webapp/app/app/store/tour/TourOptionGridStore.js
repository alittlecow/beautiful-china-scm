/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-11
 */
Ext.define('app.store.tour.TourOptionGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.touroptiongridstore',
    autoLoad: false,
    storeId: 'tourOptionGridStore',
    listeners: {
        load: function (e, r) {
            e.removeAll();
            var datas = [];
            for (var i = 0, len = r.length; i < len; i++) {
                var data = r[i].getData();
                var priceList = data.optionValuePriceList,
                    valueNameList = data.optionValueNameList,
                    defaultsList = data.defaults;
                var br = '';
                for (var j = 0, length = priceList.length - 1; j < length; j++) {
                    br += '<br>'
                }
                datas.push({
                    optionName: br + data.optionName,
                    optionValueName: valueNameList.join('<hr>'),
                    price: priceList.join('<hr>'),
                    idList: data.idList,
                    optionId: data.optionId,
                    defaults: function () {
                        var defaults = [];
                        for (var i = 0, len = defaultsList.length; i < len; i++) {
                            if (defaultsList[i] === 0) {
                                defaults.push('N');
                            } else {
                                defaults.push('Y');
                            }
                        }
                        return defaults.join('<hr>');
                    }()
                });
            }
            e.add(datas);
        }
    },
    proxy: {
        type: 'ajax',
        url: basePath + '/tour/getTourOption',
        actionMethods: {
            read: "POST"
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    }
});