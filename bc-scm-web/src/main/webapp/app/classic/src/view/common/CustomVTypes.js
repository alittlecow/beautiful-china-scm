/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * 自定义验证
 * @author: chenghuanhuan
 * date: 15/12/25
 */
Ext.define('app.view.common.CustomVTypes', {
    override: 'Ext.form.field.VTypes',

    /**
     * 时间范围验证
     * @param val
     * @param field
     * @returns {boolean}
     */
    daterange: function(val, field) {
        var date = field.parseDate(val);

        if (!date) {
            return false;
        }
        if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = field.up('form').down('#' + field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
        }
        else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = field.up('form').down('#' + field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
        }

        return true;
    },

    daterangeText: 'Start date must be less than end date',
    /**
     * 重复密码验证
     * @param val
     * @param field
     * @returns {boolean}
     */
    password: function(val, field) {
        if (field.initialPassField) {
            var pwd = field.up('form').down('#' + field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText: 'Passwords do not match',

    /**
     * 电话号码验证
     * @param val
     * @param field
     * @returns {boolean}
     */
    telephone: function(val, field) {
        return /^((\d{3}-)?(\d{7})|^(\d{7}))$/.test(val);
    },
    telephoneText: 'Telephone number format is not supported',

    /**
     * 图片格式验证（jpg，jpeg，gif，png，bmp）
     * @param val
     * @param field
     * @returns {boolean}
     */
    image: function (val, field) {
        return /\.([jJ][pP][gG]){1}$|\.([jJ][pP][eE][gG]){1}$|\.([gG][iI][fF]){1}$|\.([pP][nN][gG]){1}$|\.([bB][mM][pP]){1}$/.test(val);
    },
    imageText: 'Must be an image'
});