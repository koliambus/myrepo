package com.github.koliambus.firstgame.core.ui.elements;

import playn.core.Surface;
import playn.scene.GroupLayer;
import playn.scene.Layer;

public abstract class Figure extends GroupLayer {

	protected int color;
	
	public Figure(int color, float rotate) {
		this.color = color;
	}

}
