/*
 * @Author: https://github.com/WangEn
 * @Author: https://gitee.com/lovetime/
 * @Date:   2018-03-27
 * @lastModify 2018-3-28
 * +----------------------------------------------------------------------
 * | WeAdmin 表格table中多个删除等操作公用js
 * | 有改用时直接复制到对应页面也不影响使用
 * +----------------------------------------------------------------------
 */
layui.extend({
	admin: '{/}../../../static/js/admin'
});
layui.use(['laypage', 'jquery', 'admin','form'], function() {
	var laypage = layui.laypage,
		$ = layui.jquery,
		form = layui.form;
	admin = layui.admin;
	var pageNo=1;
	// 查询所有套题
	function getAll(pageNo){
		$.ajax({
			url: '/testPaper/queryTestPaperNameAll',
			data: JSON.stringify({
				pageNo:pageNo,pageSize:10,
				obj:{
					testPaperName:$('.testPaperName').val()
				}
			}),
			type: "POST",
			dataType: "json",
			contentType:'application/json;charset=utf-8',
			success:function (res) {
				if(res.success){
					pageNo = res.pageNo
					var str = '';
					if(res.obj.length>0){
						res.obj.forEach((item,index) =>{
							var i = res.pageSize*(res.pageNo-1) + 1 + index;
							str += '<tr data-id="' + item.id + '">' +
							'<td>'+
							'<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id="'+item.id+'"><i class="layui-icon">&#xe605;</i></div>'+
							'</td>'+
							'<td>' + i+ '</td>'+
							'<td>'+item.testPaperName+'</td>'+
							'<td class="td-manage">'+
							'<a title="题目录入" onclick="WeAdminEdit(\'题目录入\',\'./addInfo.html\','+ item.id+')" href="javascript:;"><i class="layui-icon">&#xe63c;</i>题目录入</a>'+
							'<a title="发布考试" onclick="WeAdminEdit(\'发布考试\',\'./release.html\','+ item.id+')" href="javascript:;"><i class="layui-icon">&#xe609;</i>发布考试</a>'+
							'<a title="修改" onclick="WeAdminEdit(\'修改\',\'./edit.html\','+ item.id+',480,300)" href="javascript:;"><i class="layui-icon">&#xe642;</i>修改</a>'+
							'<a title="删除" onclick="member_del('+ item.id+')" href="javascript:;"><i class="layui-icon">&#xe640;</i>删除</a>'+
							'</td>'+
							'</tr>'
						})
						laypage.render({
							elem: 'page'
							,count: res.total //数据总数
							,curr: res.pageNo
							,layout: ['count', 'prev', 'page', 'next']
							,limit:res.pageSize
							,jump: function(obj,first){
								if(!first){
									getAll(obj.curr)
								}
							}
						});
					}else {
						str = '暂无数据'
					}
					$('#memberList').empty().append(str);
					// 分页
				}else{
					layer.msg(res.errorMsg,{
						time: 1000
					});
				}
			}
		})
	}
	getAll(pageNo);
	function dateFormat(v){
		var date = new Date(v);
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		m = m<10?'0'+m:m;
		var d = date.getDate();
		d = d<10?("0"+d):d;
		var h = date.getHours();
		h = h<10?("0"+h):h;
		var M = date.getMinutes();
		M = M<10?("0"+M):M;
		var str = y+"-"+m+"-"+d+" "+h+":"+M;
		return str;
	}
	$('.sreach').click(function () {
		getAll(pageNo);
		return false
	})

	/*用户-删除*/
	window.member_del = function (id) {
		layer.confirm('确认要删除吗？', function(index) {
			delData([id])
		});
	}
	function delData(id){
		$.ajax({
			url: '/testPaper/batchDelTestPaperNameById',
			data: JSON.stringify({
				ids:id
			}),
			type: "POST",
			dataType: "json",
			contentType:'application/json;charset=utf-8',
			success:function (res) {
				if(res.success){
					getAll(pageNo);
					layer.msg('删除成功!', {
						icon: 1,
						time: 1000
					});
				}else{
					layer.msg(res.errorMsg,{
						time: 1000
					});
				}
			}
		})
	}

	window.delAll = function (argument) {
		var data = tableCheck.getData().splice(',');
		if(data.length<=0){
			layer.msg('请选择需要删除的套题！',{
				time: 1000
			});
			return false;
		}
		layer.confirm('确认要删除吗？', function(index) {
			delData(data)
		});
	}

	$('body').on('click', '.layui-form-checkbox',function (event) {
		if($(this).hasClass('header')) {
			return false
		}
		if($(this).hasClass('layui-form-checked')) {
			$(this).removeClass('layui-form-checked');
			if($(this).hasClass('header')) {
				event.stopPropagation()
				$(".layui-form-checkbox").removeClass('layui-form-checked');
			}
		} else {
			$(this).addClass('layui-form-checked');
			if($(this).hasClass('header')) {
				$(".layui-form-checkbox").addClass('layui-form-checked');
			}
		}
	});
});