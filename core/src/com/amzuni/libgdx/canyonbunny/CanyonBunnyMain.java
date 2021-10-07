package com.amzuni.libgdx.canyonbunny;

import com.amzuni.libgdx.canyonbunny.game.Assets;
import com.amzuni.libgdx.canyonbunny.game.WorldController;
import com.amzuni.libgdx.canyonbunny.game.WorldRenderer;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class CanyonBunnyMain extends ApplicationAdapter {
	private static final String TAG = CanyonBunnyMain.class.getName();
	
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	
	@Override
	public void create () {
		Assets.instance.init(new AssetManager());
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
	}

	@Override
	public void render () {
		// TODO Auto-generated method stub
		worldController.update(Gdx.graphics.getDeltaTime());
		// Sets the clear screen color to: Cornflower Blue
		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
		// Clears the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// Render game world to screen
		worldRenderer.render();
	}
	
	@Override
	public void dispose () {
		worldRenderer.dispose();
	}
}
