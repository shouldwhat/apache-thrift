package app;

import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thrift.User;

public class TestTProtocol {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestTProtocol.class);

	public void test() throws TException {
		
		TSerializer serializer = null;
		
		{	/* binary serialize 테스트 */
			serializer = new TSerializer(new TBinaryProtocol.Factory());
			
			byte[] bytes = serializer.serialize(new User("wkkim"));
			LOG.debug("***** bytes = {}", bytes);
		}

		{	/* json serialize 테스트 */
			serializer = new TSerializer(new TSimpleJSONProtocol.Factory());
			
			String json = serializer.toString(new User("wkkim"));
			LOG.debug("***** json = {}", json);
		}
	}

	public static void main(String[] args) {
		
		try {
			new TestTProtocol().test();
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}
