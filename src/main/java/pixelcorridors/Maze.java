package pixelcorridors;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The Maze class is a grid-like container for representing the static elements
 * of a single game screen.
 * 
 * @author ryan
 */
public final class Maze {

	/**
	 * A multi-dimensional array ([height][width]) of {@link MazeElement}
	 * references representing the contents of the {@link Maze}.
	 */
	private final MazeElement[][] grid;

	public Maze(final int width, final int height) {
		if (width <= 0) {
			throw new IllegalArgumentException("The width of a Maze must be"
					+ " a positive integer value.");
		}
		if (height <= 0) {
			throw new IllegalArgumentException("The height of a Maze must be"
					+ " a positive integer value.");
		}
		grid = new MazeElement[height][];
		for (int i = 0; i < height; i++) {
			grid[i] = new MazeElement[width];
			for (int j = 0; j < width; j++) {
				grid[i][j] = MazeElement.FLOOR;
			}
		}
	}

	private void checkBounds(final int row, final int column) {
		if (row < 0) {
			throw new IllegalArgumentException("Maze cells may not be found"
					+ " at a negative row index.");
		}
		if (row >= getHeight()) {
			throw new IllegalArgumentException("Row index out of bounds."
					+ "(" + row + " >= " + getHeight() + ")");
		}
		if (column < 0) {
			throw new IllegalArgumentException("Maze cells may not be found"
					+ " at a negative column index.");
		}
		if (column >= getWidth()) {
			throw new IllegalArgumentException("Column index out of bounds."
					+ "(" + column + " >= " + getWidth() + ")");
		}
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Maze) {
			final Maze that = (Maze) obj;
			return new EqualsBuilder()
				.append(grid, that.grid)
				.isEquals();
		} else {
			return false;
		}
	}

	public MazeElement getCell(final int row, final int column) {
		checkBounds(row, column);
		return grid[row][column];
	}

	public int getHeight() {
		return grid.length;
	}

	public int getWidth() {
		return grid[0].length;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1234, 17)
			.append(grid)
			.toHashCode();
	}

	public void setCell(final int row, final int column,
			final MazeElement element) {
		checkBounds(row, column);
		if (element == null) {
			throw new IllegalArgumentException("Maze cells may not be set to"
					+ "null.");
		}
		grid[row][column] = element;
	}
}