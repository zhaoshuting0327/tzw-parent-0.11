package com.tzw.common.jqGrid;

import com.github.pagehelper.PageInfo;
/*import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;*/

import java.util.List;

/**
 * 
 *
 */
public class JqGridReturnedData<T> {
	/**
	 * 当前第几页
	 */
	private int page;

	/**
	 * 数据总数
	 */
	private int records;

	/**
	 * 返回的list
	 */
	private List<T> rows;

	/**
	 * 总页数
	 */
	private int total;

	/**
	 * 返回的额外数据，在自定义footer时使用
	 */
	private Object userdata;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getUserdata() {
		return userdata;
	}

	public void setUserdata(Object userdata) {
		this.userdata = userdata;
	}

	public JqGridReturnedData() {
	}



	public JqGridReturnedData(PageInfo params) {
		this.page = params.getPageNum();
		this.records = new Long(params.getTotal()).intValue();
		this.total = params.getPages();
		this.rows = params.getList();
	}

}
