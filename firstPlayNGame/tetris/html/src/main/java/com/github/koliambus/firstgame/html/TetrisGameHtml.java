package com.github.koliambus.firstgame.html;

import com.google.gwt.core.client.EntryPoint;
import playn.html.HtmlPlatform;
import com.github.koliambus.firstgame.core.TetrisGame;

public class TetrisGameHtml implements EntryPoint {

  @Override public void onModuleLoad () {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform plat = new HtmlPlatform(config);
    plat.assets().setPathPrefix("tetris/");
    new TetrisGame(plat);
    plat.start();
  }
}
