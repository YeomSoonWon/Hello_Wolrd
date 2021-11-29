package screen;

import java.awt.event.KeyEvent;

import engine.Cooldown;
import engine.Core;

public class SettingScreen extends Screen {
	
	private static final int SELECTION_TIME = 200;
	
	private Cooldown selectionCooldown;

	public SettingScreen(final int width, final int height, final int fps) {
		super(width, height, fps);
		
		this.returnCode = 1;
		this.selectionCooldown = Core.getCooldown(SELECTION_TIME);
		this.selectionCooldown.reset();
	}

	public final int run() {
		super.run();
		
		return this.returnCode;
	}
	
	private void draw() {
		drawManager.initDrawing(this);
		drawManager.drawSettingTitle(this);
		drawManager.drawSetting(this);
		drawManager.completeDrawing(this);
	}
	
	protected final void update() {
		super.update();
		
		draw();
		if (inputManager.isKeyDown(KeyEvent.VK_SPACE) && this.inputDelay.checkFinished())
			this.isRunning = false;
	}
}
