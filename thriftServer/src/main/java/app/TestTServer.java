package app;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import thrift.CalculatorService;
import thrift.CalculatorServiceImpl;
import thrift.HelloWorld;
import thrift.HelloWorldImpl;

public class TestTServer
{
	private void test() throws TTransportException
	{
		Factory portFactory = new TBinaryProtocol.Factory(true, true);
		
		TServerSocket serverTransport = new TServerSocket(8000);
		
		CalculatorService.Processor<CalculatorService.Iface> processor = new CalculatorService.Processor<CalculatorService.Iface>(new CalculatorServiceImpl());
		
		org.apache.thrift.server.TThreadPoolServer.Args args = new org.apache.thrift.server.TThreadPoolServer.Args(serverTransport);
		args.processor(processor);
		args.protocolFactory(portFactory);
		
		TServer server = new TThreadPoolServer(args);
		
		System.out.println("Starting server on port 8000 ...");
		
		server.serve();
	}
	
	public static void main(String[] args)
	{
		try
		{
			new TestTServer().test();
		}
		catch (TTransportException e)
		{
			e.printStackTrace();
		}
	}
}
