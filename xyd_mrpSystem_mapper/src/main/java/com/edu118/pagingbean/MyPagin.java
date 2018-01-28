package com.edu118.pagingbean;

import java.io.Serializable;
import java.util.List;

public class MyPagin implements Serializable {
	/**
	 * 默认的序列化版本 id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分页查询开始索引.
	 */
	private int startIndex;
	/**
	 * 分页查看下结束索引.
	 */
	private int endIndex;
	/**
	 * 每页显示记录数.
	 */
	private int pageSize = 5;
	/**
	 * 查询结果总记录数.
	 */
	private long totalRecords;
	/**
	 * 当前页码.
	 */
	private int currPage;
	/**
	 * 总共页数.
	 */
	private int pageCount;

	/**
	 * 上一页
	 */
	private Integer prevPage;

	/**
	 * 下一页
	 */
	private Integer nextPage;

	/**
	 * 末页
	 */
	private Integer endPage;

	/**
	 * 页面上要显示的数据
	 */
	private List<?> data;

	public MyPagin() {
	}

	public MyPagin(Integer currPage, Integer pageSize, Integer totalRecords, List<?> data) {
		this.currPage = currPage;
		this.totalRecords = totalRecords;
		this.data = data;
		this.pageSize = pageSize;

		// 末页
		endPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
		// 上一页
		prevPage = currPage - 1 > 0 ? currPage - 1 : 1;
		// 下一页
		nextPage = currPage + 1 > endPage ? endPage : currPage + 1;
	}

	public MyPagin(int startIndex, int pageSize) {
		this.startIndex = startIndex;
		this.pageSize = pageSize;
		this.endIndex = this.startIndex + this.pageSize;
		this.currPage = (int) Math.floor((this.startIndex * 1.0d) / this.pageSize) + 1;
		// 上一页
		prevPage = currPage - 1 > 0 ? currPage - 1 : 1;
		// 下一页
		if (endPage != null)
			nextPage = currPage + 1 > endPage ? endPage : currPage + 1;
	}

	/**
	 * @param startIndex
	 * @param pageSize
	 * @param count
	 */
	public MyPagin(int startIndex, int pageSize, int totalRecords) {
		this(startIndex, pageSize);
		this.totalRecords = totalRecords;
		// 末页
		endPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
	}

	/**
	 * 设置页数，自动计算数据范围.
	 */
	public MyPagin(int currPage) {
		this.currPage = currPage;
		currPage = currPage > 0 ? currPage : 1;
		this.startIndex = this.pageSize * (currPage - 1);
		this.endIndex = this.pageSize * currPage;
		// 上一页
		prevPage = currPage - 1 > 0 ? currPage - 1 : 1;
		// 下一页
		nextPage = currPage + 1 > endPage ? endPage : currPage + 1;
	}

	/**
	 * 设置查询到的数据数量和每页显示的数据量
	 * 
	 * @param totalRecords
	 *            查询到的数据总量
	 * @param pageSize
	 *            每页显示的数据数量
	 */
	public void setCouonAndPageSize(Integer totalRecords, Integer pageSize) {
		this.totalRecords = totalRecords;
		this.pageSize = pageSize;
		this.endPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
		// 末页
		endPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
		if (this.pageSize != 0) {
			this.currPage = (int) Math.floor((this.startIndex * 1.0d) / this.pageSize) + 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		if (this.startIndex != 0) {
			this.currPage = (int) Math.floor((this.startIndex * 1.0d) / this.pageSize) + 1;
		}
	}

	/**
	 * @return 获取查询数据数量
	 */
	public long getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords
	 *            设置查询数据数量
	 */
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
		this.pageCount = (int) Math.floor((this.totalRecords * 1.0d) / this.pageSize);
		if (this.totalRecords % this.pageSize != 0) {
			this.pageCount++;
		}
		// 末页
		this.endPage = (int)(this.totalRecords % this.pageSize == 0 ? this.totalRecords / this.pageSize : this.totalRecords / this.pageSize + 1);
		
		//下一页
		this.nextPage = this.currPage + 1 > endPage ? endPage : this.currPage + 1;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
		currPage = currPage > 0 ? currPage : 1;
		this.startIndex = this.pageSize * (currPage - 1);
		this.endIndex = this.pageSize * currPage;

		this.prevPage = currPage - 1 > 0 ? currPage - 1 : 1;
		
		if (endPage != null) 
			this.nextPage = currPage + 1 > endPage ? endPage : currPage + 1;
	}

	public int getPageCount() {
		if (pageCount == 0) {
			return 1;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MyPagin [startIndex=" + startIndex + ", endIndex=" + endIndex + ", pageSize=" + pageSize
				+ ", totalRecords=" + totalRecords + ", currPage=" + currPage + ", pageCount=" + pageCount
				+ ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", endPage=" + endPage + ", data=" + data + "]";
	}

}
