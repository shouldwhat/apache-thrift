package app;

import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thrift.User;

public class TestTProtocol
{
	Logger logger = LoggerFactory.getLogger(TestTProtocol.class);
	
	public void test() throws TException
	{
		TSerializer binarySerializer = new TSerializer(new TBinaryProtocol.Factory());
		
		byte[] bytes = binarySerializer.serialize(new User("wkkim"));
		
		logger.debug("***** bytes = {}", bytes);
		
		
		TSerializer jsonSerializer = new TSerializer(new TSimpleJSONProtocol.Factory());
		
		String json = jsonSerializer.toString(new User("wkkim"));
		
		logger.debug("***** json = {}", json);
	}
	
	public static void main(String[] args)
	{
		try
		{
			new TestTProtocol().test();
		}
		catch (TException e)
		{
			e.printStackTrace();
		}
	}
}
