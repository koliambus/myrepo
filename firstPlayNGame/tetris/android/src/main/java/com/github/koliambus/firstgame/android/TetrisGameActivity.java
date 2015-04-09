package com.github.koliambus.firstgame.android;

import playn.android.GameActivity;

import com.github.koliambus.firstgame.core.TetrisGame;

public class TetrisGameActivity extends GameActivity {

  @Override public void main () {
    new TetrisGame(platform());
  }
}
