package system;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class RuntimeTest {
	@Test
	public void testProcess() throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("notepad");
		process.waitFor(10, TimeUnit.SECONDS);
	}
}
