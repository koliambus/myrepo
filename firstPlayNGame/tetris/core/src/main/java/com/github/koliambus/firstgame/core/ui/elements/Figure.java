package com.github.koliambus.firstgame.core.ui.elements;

import playn.core.Surface;
import playn.scene.GroupLayer;
import playn.scene.Layer;

public abstract class Figure extends GroupLayer {

	public Figures type;
	protected int color;
	
	public Figure(int color, float rotate) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
