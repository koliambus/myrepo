package com.github.koliambus.firstgame.core;

import org.eclipse.swt.custom.AnimatedProgress;

import com.github.koliambus.firstgame.core.grid.GameGrid;
import com.github.koliambus.firstgame.core.ui.BoardView;
import com.github.koliambus.firstgame.core.ui.elements.Figure;
import com.github.koliambus.firstgame.core.ui.elements.LineFigure;
import com.github.koliambus.firstgame.core.ui.elements.Piece;

import playn.core.Audio;
import playn.core.Clock;
import playn.core.Exec;
import playn.core.Graphics;
import playn.core.Image;
import playn.core.Input;
import playn.core.Json;
import playn.core.Keyboard;
import playn.core.Keyboard.KeyEvent;
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
	  GameGrid grid = new GameGrid(rootLayer);
	  rootLayer.add(new BoardView());
	  grid.addFigure(new LineFigure(0xFF33FF33, 0.0f), 5, 11);
	  
	final Figure line = new LineFigure(0xFF33FF33, 0.0f);
	rootLayer.addAt(line, 150, 150);
	paint.connect(new Slot<Clock>() {
		@Override
		public void onEmit(Clock event) {
			Layer lastFigure = rootLayer.childAt(rootLayer.children()-1);
			if(event.tick > (lastTime + 1000)){
				if(lastFigure.ty() < 500){
					lastFigure.setTranslation(lastFigure.tx(), lastFigure.ty() + Piece.PIXEL_SIZE);
					lastTime = event.tick;
				}else{
					rootLayer.addAt(new LineFigure(0xFF33FF33, 0.0f), 150, 150);
				}
			}
		}
	});
	plat.input().keyboardEvents.connect(new Keyboard.KeySlot() {
		
		@Override
		public void onEmit(KeyEvent event) {
			if(event.down){
				Layer lastFigure = rootLayer.childAt(rootLayer.children()-1);
				System.out.println(lastFigure);
				switch (event.key) {
				case LEFT:
					lastFigure.setTranslation(lastFigure.tx()-Piece.PIXEL_SIZE, lastFigure.ty());
					System.out.println("Left Key");
					break;
				case RIGHT:
					lastFigure.setTranslation(lastFigure.tx()+Piece.PIXEL_SIZE, lastFigure.ty());
					System.out.println("Right Key");
					break;
				case DOWN:
					lastFigure.setTranslation(lastFigure.tx(), 500);
					break;
				case UP:
					lastFigure.setRotation(lastFigure.rotation() + (float)Math.PI/2);
					break;
	
				default:
					break;
				}
			}
			
		}
	});
	for (int i = 0; i < rootLayer.children()-1; i++) {
		System.out.println("[" + i + "] " + rootLayer.childAt(i));
	}
  }
}
