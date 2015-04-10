package com.github.koliambus.firstgame.core.ui.elements;

import playn.core.Surface;
import playn.scene.Layer;

public class Piece extends Layer {
	public static final int PIXEL_SIZE = 40;
	private int color;
	private float x;
	private float y;
	
	public Piece(float x, float y ,int color) {
		this.color = color;
		this.x = x;
		this.y = y;
		System.out.println(this);
	}

	@Override
	protected void paintImpl(Surface surf) {
		surf.setFillColor(color);
		surf.fillRect(x, y, PIXEL_SIZE, PIXEL_SIZE);
		surf.setFillColor(0xAA808080);
		surf.drawLine(x, y, x, y + PIXEL_SIZE, 1);
		surf.drawLine(x, y + PIXEL_SIZE, x + PIXEL_SIZE, y + PIXEL_SIZE, 1);
		surf.drawLine(x + PIXEL_SIZE, y + PIXEL_SIZE, x + PIXEL_SIZE, y, 1);
		surf.drawLine(x + PIXEL_SIZE, y, x, y, 1);
	}
	
	@Override
	public String toString() {
		return "Piece: " + "color = " + color + "; x = " + x +"; y = " + y;
	}
}
