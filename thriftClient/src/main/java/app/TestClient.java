package app;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thrift.CalculatorService;

public class TestClient {
	
	private static final Logger logger = LoggerFactory.getLogger(TestClient.class);

	private void test() throws TException {
		
		TTransport transport = new TSocket("localhost", 8000);
		TProtocol protocol = new TBinaryProtocol(transport);

		CalculatorService.Client client = new CalculatorService.Client(protocol);

		transport.open();

		int addResult = client.add(5, 5);
		logger.debug("***** remote [add] procedure call !!! => result = {}", addResult);

		int subResult = client.subtract(10, 7);
		logger.debug("***** remote [substract] procedure call !!! => result = {}", subResult);

		double divideResult = client.divide(15, 0);
		logger.debug("***** remote [divide] procedure call !!! => result = {}", divideResult);

		transport.close();
	}

	public static void main(String[] args) {
		
		try {
			new TestClient().test();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

}
