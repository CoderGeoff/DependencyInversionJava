package siemens.plm.dependencyinversion.snakesandladdersdependencyinversion;

public interface IBoard {
	public Integer tryGetSnakeTailWithHeadAt(int square);
	public int getLastSquare();

}