package app;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thrift.CalculatorService;
import thrift.CalculatorServiceImpl;

public class TestTNonBlockingServer {

	private static final Logger LOG = LoggerFactory.getLogger(TestTNonBlockingServer.class);
	
	private void test() throws TTransportException {
		
		TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(8000);
		
		CalculatorService.Processor<CalculatorService.Iface> processor = new CalculatorService.Processor<CalculatorService.Iface>(new CalculatorServiceImpl());
		
		TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).processor(processor));
		server.serve();
		
		LOG.debug("*** Starting server on port 8000 ...");
	}
	
	public static void main(String[] args) {
		
		try {
			new TestTNonBlockingServer().test();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
		
	}

}
