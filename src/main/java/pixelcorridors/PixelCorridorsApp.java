package pixelcorridors;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelCorridorsApp extends JFrame {

	private class MazePanel extends JPanel {

		private static final long serialVersionUID = -2784043459880893727L;

		public void paintComponent(final Graphics g) {
			super.paintComponent(g);
			final Image i = getRenderer().draw(maze);
			if (i != null) {
				g.drawImage(i, 0, 0, this);
			}
		}
	}

	public static final int DEFAULT_TILE_SIZE = 32;

	private static final long serialVersionUID = 8539512956698343302L;

	public static void main(final String[] args) {
		new PixelCorridorsApp();
	}

	private SkinLoader imageLoader;

	private Maze maze;

	private MazeRenderer renderer;

	private int tileSize;

	public PixelCorridorsApp() {
		this(null);
	}

	public PixelCorridorsApp(final MazeRenderer renderer) {
		setRenderer(renderer);
		maze = new StaticMazeGenerator().generate();
		setTitle("Pixel Corridors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		add(new MazePanel());
		show();
	}

	private SkinLoader getImageLoader() {
		if (imageLoader == null) {
			imageLoader = new SkinLoader();
		}
		return imageLoader;
	}

	private MazeRenderer getRenderer() {
		if (renderer == null) {
			final Map<MazeElement, Image> images = getImageLoader().loadImages();
			renderer = new MazeRenderer(images, getTileSize());
		}
		return renderer;
	}

	private int getTileSize() {
		return tileSize == 0 ? DEFAULT_TILE_SIZE : tileSize;
	}

	private void setRenderer(final MazeRenderer renderer) {
		this.renderer = renderer;
	}
}