package pixelcorridors;

public class Maze {
	private MazeElement[][] grid;

	public Maze(final int width, final int height) {
		grid = new MazeElement[height][];
		for (int i = 0; i < height; i++) {
			grid[i] = new MazeElement[width];
			for (int j = 0; j < width; j++) {
				grid[i][j] = MazeElement.FLOOR;
			}
		}
	}

	public MazeElement getCell(final int row, final int column) {
		return grid[row][column];
	}

	public int getColumns() {
		return grid[0].length;
	}

	public int getRows() {
		return grid.length;
	}

	public void setCell(final int row, final int column,
			final MazeElement element) {
		grid[row][column] = element;
	}
}