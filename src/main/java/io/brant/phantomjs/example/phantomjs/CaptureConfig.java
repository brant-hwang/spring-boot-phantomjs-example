package io.brant.phantomjs.example.phantomjs;

public class CaptureConfig {

	private int x;

	private int y;

	private int width;

	private int height;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static CaptureConfig defaultConfig() {
		CaptureConfig captureConfig = new CaptureConfig();
		captureConfig.setX(0);
		captureConfig.setY(0);
		captureConfig.setWidth(-1);
		captureConfig.setHeight(-1);

		return captureConfig;
	}
}
