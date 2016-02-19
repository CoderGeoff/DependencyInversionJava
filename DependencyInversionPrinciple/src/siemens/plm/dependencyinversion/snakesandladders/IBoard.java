package siemens.plm.dependencyinversion.snakesandladders;

public interface IBoard {
	public Integer tryGetSnakeTailWithHeadAt(int square);
	public int getLastSquare();

}