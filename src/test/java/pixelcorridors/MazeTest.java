package pixelcorridors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MazeTest {

	@Test
	public void constructorCreatesMazeWithDesiredHeight() {
		final Maze cut = new Maze(1, 2);
		assertThat(cut.getHeight(), is(equalTo(2)));
	}

	@Test
	public void constructorCreatesMazeWithDesiredWidth() {
		final Maze cut = new Maze(2, 1);
		assertThat(cut.getWidth(), is(equalTo(2)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void constructorDoesNotAllowNegativeHeight() {
		new Maze(10, -1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void constructorDoesNotAllowNegativeWidth() {
		new Maze(-1, 10);
	}

	@Test(expected=IllegalArgumentException.class)
	public void constructorDoesNotAllowZeroHeight() {
		new Maze(10, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void constructorDoesNotAllowZeroWidth() {
		new Maze(0, 10);
	}

	@Test
	public void constructorInitializesToFloor() {
		final Maze cut = new Maze(2, 2);
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 2; col++) {
				assertThat(cut.getCell(row, col),
						is(equalTo(MazeElement.FLOOR)));
			}
		}
	}

	@Test
	public void equalsAllowsNull() {
		assertThat(new Maze(2, 2).equals(null), is(false));
	}

	@Test
	public void equalsHandlesEquality() {
		final Maze cut = new Maze(2, 2);
		final Maze that = new Maze(2, 2);
		assertThat(cut.equals(that), is(true));
	}

	@Test
	public void equalsHandlesIdentity() {
		final Maze cut = new Maze(2, 2);
		assertThat(cut.equals(cut), is(true));
	}

	@Test
	public void equalsHandlesNonMaze() {
		final Maze cut = new Maze(2, 2);
		assertThat(cut.equals("BAD"), is(false));
	}

	@Test
	public void getCellAllowsZeroColumn() {
		final Maze cut = new Maze(2, 2);
		assertThat(cut.getCell(1, 0), is(equalTo(MazeElement.FLOOR)));
	}

	@Test
	public void getCellAllowsZeroRow() {
		final Maze cut = new Maze(2, 2);
		assertThat(cut.getCell(0, 1), is(equalTo(MazeElement.FLOOR)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void getCellDoesNotAllowNegativeColumn() {
		new Maze(2, 2).getCell(1, -1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void getCellDoesNotAllowNegativeRow() {
		new Maze(2, 2).getCell(-1, 1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void getCellDoesNotAllowTooLargeColumn() {
		new Maze(2, 2).getCell(1, 2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void getCellDoesNotAllowTooLargeRow() {
		new Maze(2, 2).getCell(2, 1);
	}

	@Test
	public void setCellAllowsZeroColumn() {
		final Maze cut = new Maze(2, 2);
		cut.setCell(1, 0, MazeElement.NE_WALL_INSIDE);
		assertThat(cut.getCell(1, 0), is(equalTo(MazeElement.NE_WALL_INSIDE)));
	}

	@Test
	public void setCellAllowsZeroRow() {
		final Maze cut = new Maze(2, 2);
		cut.setCell(0, 1, MazeElement.SW_WALL_INSIDE);
		assertThat(cut.getCell(0, 1), is(equalTo(MazeElement.SW_WALL_INSIDE)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void setCellDoesNotAllowNegativeColumn() {
		new Maze(2, 2).setCell(1, -1, MazeElement.FLOOR);
	}

	@Test(expected=IllegalArgumentException.class)
	public void setCellDoesNotAllowNegativeRow() {
		new Maze(2, 2).setCell(-1, 1, MazeElement.FLOOR);
	}

	@Test(expected=IllegalArgumentException.class)
	public void setCellDoesNotAllowNullElement() {
		new Maze(2, 2).setCell(1, 1, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void setCellDoesNotAllowTooLargeColumn() {
		final Maze cut = new Maze(2, 2);
		cut.setCell(1, 2, MazeElement.FLOOR);
	}

	@Test(expected=IllegalArgumentException.class)
	public void setCellDoesNotAllowTooLargeRow() {
		final Maze cut = new Maze(2, 2);
		cut.setCell(2, 1, MazeElement.FLOOR);
	}
}