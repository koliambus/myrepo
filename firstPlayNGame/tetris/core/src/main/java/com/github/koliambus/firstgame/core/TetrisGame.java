package com.github.koliambus.firstgame.core;

import org.eclipse.swt.custom.AnimatedProgress;

import com.github.koliambus.firstgame.core.ui.BoardView;
import com.github.koliambus.firstgame.core.ui.elements.Figure;
import com.github.koliambus.firstgame.core.ui.elements.LineFigure;

import playn.core.Audio;
import playn.core.Clock;
import playn.core.Exec;
import playn.core.Graphics;
import playn.core.Image;
import playn.core.Input;
import playn.core.Json;
import playn.core.Log;
import playn.core.Net;
import playn.core.Platform;
import playn.core.Storage;
import playn.core.Platform.Type;
import playn.java.JavaPlatform;
import playn.scene.ImageLayer;
import playn.scene.Layer;
import playn.scene.SceneGame;
import pythagoras.f.Dimension;
import pythagoras.f.IDimension;
import react.Slot;

public class TetrisGame extends SceneGame {

	private int lastTime = 0;

  public TetrisGame (Platform plat) {
    super(plat, 1000); // update our "simulation" 33ms (30 times per second)
    if(plat instanceof JavaPlatform){
    	JavaPlatform jPlat = (JavaPlatform)plat;
    	jPlat.graphics().setSize(1280, 720, false);
    	jPlat.setTitle("Tetris");
    }
    // create and add background image layer
    Image bgImage = plat.assets().getImage("images/bg.png");
    ImageLayer bgLayer = new ImageLayer(bgImage);
    // scale the background to fill the screen
    bgLayer.setSize(plat.graphics().viewSize);
    rootLayer.add(bgLayer);
    
    initMainElements();
  }
  
  private void initMainElements(){
  	rootLayer.add(new BoardView());
  	final Figure line = new LineFigure(0xFF33FF33, 0.5f);
	rootLayer.addAt(line, 150, 100);
	paint.connect(new Slot<Clock>() {
		@Override
		public void onEmit(Clock event) {
			if(event.tick > lastTime + 1000){
				line.setVisible(!line.visible());
				lastTime = event.tick;
			}
		}
	});
  }
}
