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

	private static final long serialVersionUID = 8539512956698343302L;

	private class MazePanel extends JPanel {

		private static final long serialVersionUID = -2784043459880893727L;

		public void paintComponent(final Graphics g) {
			super.paintComponent(g);
			final Image i = RENDERER.draw(maze);
			if (i != null) {
				g.drawImage(i, 0, 0, this);
			}
		}
	}

	public static void main(final String[] args) {
		new PixelCorridorsApp();
	}

	private final Maze maze = new Maze(10, 10);

	private MazeRenderer RENDERER;

	public PixelCorridorsApp() {
		this(null);
	}

	public PixelCorridorsApp(final MazeRenderer renderer) {
		if (renderer == null) {
			RENDERER = new MazeRenderer(new SkinLoader().loadImages(), 32);
		} else {
			RENDERER = renderer;
		}
		initMaze();
		setTitle("Pixel Corridors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		add(new MazePanel());
		show();
	}

	private void initMaze() {
		maze.setCell(0, 0, MazeElement.SE_WALL_INSIDE);
		for (int i = 1; i < 9; i++) {
			maze.setCell(0, i, MazeElement.S_WALL);
		}
		maze.setCell(0, 9, MazeElement.SW_WALL_INSIDE);
		for (int i = 1; i < 9; i++) {
			maze.setCell(i, 0, MazeElement.E_WALL);
			maze.setCell(i, 9, MazeElement.W_WALL);
		}
		maze.setCell(9, 0, MazeElement.NE_WALL_INSIDE);
		for (int i = 1; i < 9; i++) {
			maze.setCell(9, i, MazeElement.N_WALL);
		}
		maze.setCell(9, 9, MazeElement.NW_WALL_INSIDE);
	}
}