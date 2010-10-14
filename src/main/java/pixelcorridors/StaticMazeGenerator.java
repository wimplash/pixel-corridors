package pixelcorridors;

public class StaticMazeGenerator implements MazeGenerator {

	@Override
	public Maze generate() {
		final Maze maze = new Maze(10, 10);
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
		return maze;
	}
}