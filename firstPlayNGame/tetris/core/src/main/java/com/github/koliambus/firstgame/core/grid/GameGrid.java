package com.github.koliambus.firstgame.core.grid;

import playn.scene.GroupLayer;
import playn.scene.Layer;

import com.github.koliambus.firstgame.core.ui.elements.Figure;
import com.github.koliambus.firstgame.core.ui.elements.LineFigure;
import com.github.koliambus.firstgame.core.ui.elements.Piece;

public class GameGrid {
	private int width;
	private int height;
	private GroupLayer rootLayer;
	
	private Piece[][] grid; 
	
	public GameGrid(GroupLayer rootLayer, int width, int height) {
		this.rootLayer = rootLayer;
		this.setWidth(width);
		this.setHeight(height);
		grid = new Piece[width][height];
	}
	
	public GameGrid(GroupLayer rootLayer) {
		this(rootLayer, 12, 20);
	}

	public void addFigure(Figure figure, int x, int y) {
		switch (figure.type) {
		case LineFigure:
			for (int i = 0; i < LineFigure.SIZE; i++) {
				grid[x][y - i] = new Piece(x, y - i, figure.getColor());
			}
			break;

		default:
			break;
		}
		
		updateScreen();
	}
	
	
	private void updateScreen() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				Piece piece = grid[i][j];
				if(piece != null){
					int x = 125 + i * Piece.PIXEL_SIZE;
					int y = 100 + j * Piece.PIXEL_SIZE;
					System.out.println(x + " " + y);
					rootLayer.addAt(piece, x, y);
				}
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
