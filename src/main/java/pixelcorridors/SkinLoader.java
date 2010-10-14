package pixelcorridors;

import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class SkinLoader {

	public Map<MazeElement, Image> loadImages() {
		final Map<MazeElement, Image> r = new HashMap<MazeElement, Image>();
		r.put(MazeElement.NW_WALL, loadImage("/skins/mono/NW-wall.png"));
		r.put(MazeElement.N_WALL, loadImage("/skins/mono/N-wall.png"));
		r.put(MazeElement.NE_WALL, loadImage("/skins/mono/NE-wall.png"));
		r.put(MazeElement.W_WALL, loadImage("/skins/mono/W-wall.png"));
		r.put(MazeElement.ROOF, loadImage("/skins/mono/roof.png"));
		r.put(MazeElement.E_WALL, loadImage("/skins/mono/E-wall.png"));
		r.put(MazeElement.SW_WALL, loadImage("/skins/mono/SW-wall.png"));
		r.put(MazeElement.S_WALL, loadImage("/skins/mono/S-wall.png"));
		r.put(MazeElement.SE_WALL, loadImage("/skins/mono/SE-wall.png"));
		r.put(MazeElement.FLOOR, loadImage("/skins/mono/floor.png"));
		r.put(MazeElement.NW_WALL_INSIDE,
				loadImage("/skins/mono/NW-wall-inside.png"));
		r.put(MazeElement.NE_WALL_INSIDE,
				loadImage("/skins/mono/NE-wall-inside.png"));
		r.put(MazeElement.SW_WALL_INSIDE,
				loadImage("/skins/mono/SW-wall-inside.png"));
		r.put(MazeElement.SE_WALL_INSIDE,
				loadImage("/skins/mono/SE-wall-inside.png"));
		return r;
	}

	private Image loadImage(final String fileName) {
		final URL url = getClass().getResource(fileName);
		try {
			return ImageIO.read(url);
		} catch (final Exception e) {
			System.out.println(e);
			return null;
		}
	}
}