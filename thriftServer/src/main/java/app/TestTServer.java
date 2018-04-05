package app;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thrift.CalculatorService;
import thrift.CalculatorServiceImpl;

public class TestTServer
{
	private static final Logger LOG = LoggerFactory.getLogger(TestTServer.class);
	
	private void test() throws TTransportException {
		
		TServerSocket serverTransport = new TServerSocket(8000);
		
		CalculatorService.Processor<CalculatorService.Iface> processor = new CalculatorService.Processor<CalculatorService.Iface>(new CalculatorServiceImpl());
		Factory portFactory = new TBinaryProtocol.Factory(true, true);
		
		Args args = new Args(serverTransport);
		args.processor(processor);
		args.protocolFactory(portFactory);
		
		TServer server = new TThreadPoolServer(args);
		server.serve();
		
		LOG.debug("*** Starting server on port 8000 ...");
	}
	
	public static void main(String[] args) {
		
		try {
			new TestTServer().test();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
