package com.test.mall3.boardcomment.service;

public class BoardComment {

	private int commentNo;
	private String commentContent;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	@Override
	public String toString() {
		return "BoardComment [commentNo=" + commentNo + ", commentContent=" + commentContent + "]";
	}
}
