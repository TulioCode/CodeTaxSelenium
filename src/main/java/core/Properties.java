package core;

public class Properties {
	
	public static boolean CLOSE_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.CHROME;

	public static ExecutionType EXECUTION_TYPE = ExecutionType.GRID;

	public enum Browsers {
		CHROME,
		FIREFOX
	}

	public enum ExecutionType{
		LOCAL,
		GRID,
		NUVEM
	}
}
