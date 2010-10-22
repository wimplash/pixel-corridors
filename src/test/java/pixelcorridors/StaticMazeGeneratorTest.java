package pixelcorridors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StaticMazeGeneratorTest {

	@Test
	public void testGenerate() {
		final MazeGenerator cut = new StaticMazeGenerator();
		assertThat(cut.generate(), is(equalTo(generateSimpleMaze())));
	}

	protected Maze generateSimpleMaze() {
		final Maze maze = new Maze(10, 10);
		maze.setCell(0, 0, MazeElement.SE_WALL_INSIDE);
		maze.setCell(0, 1, MazeElement.S_WALL);
		maze.setCell(0, 2, MazeElement.S_WALL);
		maze.setCell(0, 3, MazeElement.S_WALL);
		maze.setCell(0, 4, MazeElement.S_WALL);
		maze.setCell(0, 5, MazeElement.S_WALL);
		maze.setCell(0, 6, MazeElement.S_WALL);
		maze.setCell(0, 7, MazeElement.S_WALL);
		maze.setCell(0, 8, MazeElement.S_WALL);
		maze.setCell(0, 9, MazeElement.SW_WALL_INSIDE);
		maze.setCell(1, 0, MazeElement.E_WALL);
		maze.setCell(1, 9, MazeElement.W_WALL);
		maze.setCell(2, 0, MazeElement.E_WALL);
		maze.setCell(2, 9, MazeElement.W_WALL);
		maze.setCell(3, 0, MazeElement.E_WALL);
		maze.setCell(3, 9, MazeElement.W_WALL);
		maze.setCell(4, 0, MazeElement.E_WALL);
		maze.setCell(4, 9, MazeElement.W_WALL);
		maze.setCell(5, 0, MazeElement.E_WALL);
		maze.setCell(5, 9, MazeElement.W_WALL);
		maze.setCell(6, 0, MazeElement.E_WALL);
		maze.setCell(6, 9, MazeElement.W_WALL);
		maze.setCell(7, 0, MazeElement.E_WALL);
		maze.setCell(7, 9, MazeElement.W_WALL);
		maze.setCell(8, 0, MazeElement.E_WALL);
		maze.setCell(8, 9, MazeElement.W_WALL);
		maze.setCell(9, 0, MazeElement.NE_WALL_INSIDE);
		maze.setCell(9, 1, MazeElement.N_WALL);
		maze.setCell(9, 2, MazeElement.N_WALL);
		maze.setCell(9, 3, MazeElement.N_WALL);
		maze.setCell(9, 4, MazeElement.N_WALL);
		maze.setCell(9, 5, MazeElement.N_WALL);
		maze.setCell(9, 6, MazeElement.N_WALL);
		maze.setCell(9, 7, MazeElement.N_WALL);
		maze.setCell(9, 8, MazeElement.N_WALL);
		maze.setCell(9, 9, MazeElement.NW_WALL_INSIDE);
		return maze;
	}
}