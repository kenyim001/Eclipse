package cn.tedu.hotel.common.web;

public class PageObject {

	/**当前页*/
	private int pageCurrent=1;
	/**一页的记录数*/
	private int pageSize=6;
	/**总记录数*/
	private int rowCount;
	/**总页数*/
	private int pageCount;
	/**当前页数据的起始记录*/
	private int startIndex;
	/**当前页数据的最后一条记录*/
	private int endIndex;
	
	
	/**计算总页数*/
	public int getPageCount(){
		int pages=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pages++;
		}
		return pages;
	}
	
	/**下一页数据的起始记录*/
	public int getStartIndex(){
		return (pageCurrent-1)*pageSize+1;
	}
	
	/**下一页数据的最后一条记录*/
	public int getEndIndex(){
		return pageCurrent*pageSize;
	}
	
	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	
}
