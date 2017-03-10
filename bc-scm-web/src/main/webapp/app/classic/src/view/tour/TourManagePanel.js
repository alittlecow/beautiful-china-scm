/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管理主界面
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.view.tour.TourManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'tourmanage',
    controller: 'tour',
    viewModel: {
        type: 'tour'
    },
    requires: [
        'app.view.tour.TourController',//线路控制器
        'app.view.tour.TourWinController',//线路窗体控制器
        'app.view.tour.DetailWinController',//线路详情窗体控制器
        'app.view.tour.TourDateWinController',//出团日期窗体控制器
        'app.view.tour.OptionSelectWinController',//选项窗体控制器

        'app.view.tour.TourViewModel',//主viewModel

        'app.view.tour.TourQueryForm',//线路查询表单
        'app.view.tour.TourGrid',//线路表格
        'app.view.tour.TourInfoWin',//线路窗体
        'app.view.tour.ImageFormPanel',//添加图片表单
        'app.view.tour.BaseInfoFormPanel',//线路基本信息表单
        'app.view.tour.TourDetailGrid',//线路详情表格
        'app.view.tour.TourDetailInfoWin',//线路详情窗体
        'app.view.tour.TourOptionGrid',//可选项表格
        'app.view.tour.OptionSelectWin',//可选项窗体
        'app.view.tour.TourDateGrid',//出团日期表格
        'app.view.tour.TourDateQueryForm',//出团日期查询表单
        'app.view.tour.TourDateInfoWin',//出团日期窗体
        'app.view.tour.BaseHtmlEditor',//带插入图片编辑器
        'app.view.tour.AddImage'//添加图片初始图片
    ],
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [
        {
            xtype: 'tourqueryform'
        }, {
            xtype: 'tourgrid',
            flex: 1
        }]
});