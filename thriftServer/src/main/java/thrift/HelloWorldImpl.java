package thrift;

import org.apache.thrift.TException;

public class HelloWorldImpl implements HelloWorld.Iface
{

	@Override
	public void hello(String name) throws TException
	{
		long time = System.currentTimeMillis();
		
		System.out.println("Current time : " + time);
		System.out.println("Hello " + name);
	}
}
