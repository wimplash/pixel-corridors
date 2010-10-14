package pixelcorridors;

public enum MazeElement {
	E_WALL("e-wall"),
	FLOOR("floor"),
	N_WALL("n-wall"),
	NE_WALL("nw-wall"),
	NE_WALL_INSIDE("ne-wall-inside"),
	NW_WALL("nw-wall"),
	NW_WALL_INSIDE("nw-wall-inside"),
	ROOF("roof"),
	S_WALL("s-wall"),
	SE_WALL("sw-wall"),
	SE_WALL_INSIDE("se-wall-inside"),
	SW_WALL("sw-wall"),
	SW_WALL_INSIDE("sw-wall-inside"),
	W_WALL("w-wall");

	private final String key;

	private MazeElement(final String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}