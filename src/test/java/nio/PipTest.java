package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

import org.junit.Test;

public class PipTest {
	@Test
	public void testPip() {
		try {
			Pipe pipe = Pipe.open();
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			buf.put("管道管道管管道".getBytes());
			buf.flip();
			
			SinkChannel sink = pipe.sink();
			sink.write(buf);
			
			ByteBuffer result = ByteBuffer.allocate(1024);
			SourceChannel source = pipe.source();
			source.read(result);
			
			System.out.println(new String(result.array(),0,result.limit()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
