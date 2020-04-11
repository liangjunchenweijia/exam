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
			url: '/applyExam/queryStuExamAll',
			data: JSON.stringify({
				pageNo:pageNo,pageSize:10,
				obj:{
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
							str += '<tr data-id="' + item.id + '" data-subjectId="' + item.subjectId + '">' +
							'<td>' + i+ '</td>'+
							'<td>'+item.subjectName+'</td>'+
							'<td>'+item.examName+'</td>'+
							'<td>'+dateFormat(item.startTime)+'</td>'+
							'<td>'+dateFormat(item.endTime)+'</td>'+
							'<td class="td-manage">'+
							'<a title="去考试" onclick="member_test('+ item.id+')" href="javascript:;"><i class="layui-icon">&#xe609;</i>去考试</a>'+
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
	window.member_test = function (id) {
		$.ajax({
			url: '/applyExam/queryExamRule',
			data:{
				id:id
			},
			type: "get",
			dataType: "json",
			contentType:'application/json;charset=utf-8',
			success:function (res) {
				if(res.success){
					WeAdminEdit('考试规则','./rules.html',id,600,400);
				}else{
					layer.msg(res.errorMsg,{
						time: 1000
					});
				}
			}
		})
	}
});