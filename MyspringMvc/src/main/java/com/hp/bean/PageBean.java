package com.hp.bean;

import java.util.List;
import java.util.Map;

public class PageBean {
	private List list;
	private int allRow;
	private int totalPage;
	private  int currentPage;
	private int pageize;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageize() {
		return pageize;
	}
	public void setPageize(int pageize) {
		this.pageize = pageize;
	}
	
	public static int countTotalPage(final int pageSize,final int allRow){
		int  totalPage= allRow % pageSize ==0 ? allRow / pageSize : allRow / pageSize+1; 
		return totalPage;
	}
	public static int countOffset(final int pageSize,final int correntPage){
		final int offset = pageSize * (correntPage - 1);
		return offset;
	}
	public static int countCurrentPage(int page){
		final int curPage = (page == 0 ? 1: page);
		return curPage;
	}
	@Override
	public String toString() {
		return "PageBean [list=" + list + ", allRow=" + allRow + ", totalPage=" + totalPage + ", currentPage="
				+ currentPage + ", pageize=" + pageize + "]";
	}
	
}
