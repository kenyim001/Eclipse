package cn.tedu.ttms.common.web;

import java.io.Serializable;

public class PageObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int pageCurrent=1;
	
	private int rowCount;
	
	private int pageCount;
	
	private int pageSize=2;
	
	private int starIndex;
	
	public int getStartIndex(){
		return (pageCurrent-1)*pageSize;
		
	}
	
	public int getPageCount(){
		int pages=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pages+=1;
		}
		return pages;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStarIndex() {
		return starIndex;
	}

	public void setStarIndex(int starIndex) {
		this.starIndex = starIndex;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

	
}
