package pixelcorridors;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Map;

public class MazeRenderer implements ImageObserver {

	private final Map<MazeElement, Image> elements;

	private final int tileSize;

	public MazeRenderer(final Map<MazeElement, Image> elements,
			final int tileSize) {
		this.elements = elements;
		this.tileSize = tileSize;
	}

	public Image draw(final Maze maze) {
		final int width = maze.getColumns() * tileSize;
		final int height = maze.getRows() * tileSize;
		final Image img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		final Graphics g = img.getGraphics();
		for (int i = 0; i < maze.getRows(); i++) {
			for (int j = 0; j < maze.getColumns(); j++) {
				final Image elImage = elements.get(maze.getCell(i, j));
				g.drawImage(elImage, j * tileSize, i * tileSize, this);
			}
		}
		return img;
	}

	public boolean imageUpdate(final Image ignored, final int infoflags,
			final int x, final int y, final int width, final int height) {
		return !((infoflags & (ERROR | FRAMEBITS | ALLBITS)) != 0);
	}
}