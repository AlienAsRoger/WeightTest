package com.developer4droid.weight_test.views;

/**
 * PieceItem class
 *
 * @author alien_roger
 * @created at: 08.03.12 8:00
 */
public class PieceItem {
	public static final int Q = 0;
	public static final int R = 1;
	public static final int B = 2;
	public static final int N = 3;
	public static final int P = 4;
	public static final int K = 5;

	private int code;


	private String stringCode;
	private boolean isWhite;

	private int layersCnt;

	/*
	* Used to find piece in captured piece layout
	* */
	private int pieceId;
	private int pieceFrameId;


	private int currentLevel;


	public String getStringCode() {
		return stringCode;
	}

	public void setStringCode(String stringCode) {
		this.stringCode = stringCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean white) {
		isWhite = white;
	}

	public int getPieceId() {
		return pieceId;
	}

	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
	}

	public int getPieceFrameId() {
		return pieceFrameId;
	}

	public void setPieceFrameId(int pieceFrameId) {
		this.pieceFrameId = pieceFrameId;
	}

	public int getLayersCnt() {
		return layersCnt;
	}

	public void setLayersCnt(int layersCnt) {
		this.layersCnt = layersCnt;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
}
