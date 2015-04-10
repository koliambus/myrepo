package com.github.koliambus.firstgame.core.ui;

import playn.core.Surface;
import playn.scene.GroupLayer;
import playn.scene.Layer;

public class BoardView extends GroupLayer {

	
	private static final int BOARD_WIDTH = 12;
	private static final int BOARD_HEIGHT = 20;
	
	public BoardView() {
		initStaticElements();
	}
	protected void initStaticElements(){
		add(new Layer() {
			@Override
			protected void paintImpl(Surface surf) {
				surf.setFillColor(0xFF000000);
				surf.fillRect(100, 100, 1000, 500);
			}
		});
	}

}
