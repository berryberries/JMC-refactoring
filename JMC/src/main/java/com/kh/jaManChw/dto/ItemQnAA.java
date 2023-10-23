package com.kh.jaManChw.dto;

import java.util.Date;

public class ItemQnAA {

	private int mgrItemno;
	private int itemQnano;
	private int userno;
	private String iaContent;
	private Date iaWriteDate;
	private String iaStatus;
	
	public ItemQnAA() {}

	public ItemQnAA(int mgrItemno, int itemQnano, int userno, String iaContent, String iaStatus, Date iaWriteDate) {
		super();
		this.mgrItemno = mgrItemno;
		this.itemQnano = itemQnano;
		this.userno = userno;
		this.iaContent = iaContent;
		this.iaStatus = iaStatus;
		this.iaWriteDate = iaWriteDate;
	}

	@Override
	public String toString() {
		return "ItemQnAA [mgrItemno=" + mgrItemno + ", itemQnano=" + itemQnano + ", userno=" + userno + ", iaContent="
				+ iaContent + ", iaStatus=" + iaStatus + ", iaWriteDate=" + iaWriteDate + "]";
	}

	public int getMgrItemno() {
		return mgrItemno;
	}

	public void setMgrItemno(int mgrItemno) {
		this.mgrItemno = mgrItemno;
	}

	public int getItemQnano() {
		return itemQnano;
	}

	public void setItemQnano(int itemQnano) {
		this.itemQnano = itemQnano;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getIaContent() {
		return iaContent;
	}

	public void setIaContent(String iaContent) {
		this.iaContent = iaContent;
	}

	public String getIaStatus() {
		return iaStatus;
	}

	public void setIaStatus(String iaStatus) {
		this.iaStatus = iaStatus;
	}

	public Date getIaWriteDate() {
		return iaWriteDate;
	}

	public void setIaWriteDate(Date iaWriteDate) {
		this.iaWriteDate = iaWriteDate;
	}
	
}
