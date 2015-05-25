import javax.script.ScriptEngineManager;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws Exception {
		new ScriptEngineManager().getEngineByName("nashorn").eval(new FileReader("hello.js"));
	}

}
