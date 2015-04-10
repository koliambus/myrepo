package com.github.koliambus.firstgame.core.ui.elements;

public class LineFigure extends Figure {
	
	public static final int SIZE = 4;
	
	public LineFigure(int color, float rotate) {
		super(color, rotate);
		addPieces();
		this.setOrigin(Piece.PIXEL_SIZE/2, Piece.PIXEL_SIZE * SIZE / 2);
		this.setRotation((float) (Math.PI/2));
	}
	
	private void addPieces(){
		for (int i = 0; i < SIZE; i++) {
			this.add(new Piece(0 , i * Piece.PIXEL_SIZE, color));
		}
	}
}
