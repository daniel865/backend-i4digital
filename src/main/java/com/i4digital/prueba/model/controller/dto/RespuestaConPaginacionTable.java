package com.i4digital.prueba.model.controller.dto;

public class RespuestaConPaginacionTable<T>{
	
	protected int draw;
	
	protected int recordsTotal;
	
	protected int recordsFiltered;
	
	protected T data;
	
	public RespuestaConPaginacionTable() {
	}
		
	public RespuestaConPaginacionTable(int draw, int recordsTotal, int recordsFiltered, T data) {
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
}
