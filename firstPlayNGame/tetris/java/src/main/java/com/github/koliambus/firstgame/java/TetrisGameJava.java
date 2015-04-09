package com.github.koliambus.firstgame.java;

import playn.java.LWJGLPlatform;

import com.github.koliambus.firstgame.core.TetrisGame;

public class TetrisGameJava {

  public static void main (String[] args) {
    LWJGLPlatform.Config config = new LWJGLPlatform.Config();
    // use config to customize the Java platform, if needed
    LWJGLPlatform plat = new LWJGLPlatform(config);
    new TetrisGame(plat);
    plat.start();
  }
}
