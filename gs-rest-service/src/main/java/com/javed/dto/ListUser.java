/**
 * 
 */
package com.javed.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Mohd Javed
 *
 */
@Component
public class ListUser {

	public Integer page;
	public Integer per_page;
	public Integer total;
	public Integer total_pages;
	public List<User> data;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

}
