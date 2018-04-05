package thrift;

import org.apache.thrift.TException;

public class CalculatorServiceImpl implements CalculatorService.Iface {

	@Override
	public int add(int num1, int num2) throws TException {
		return num1 + num2;
	}

	@Override
	public int subtract(int num1, int num2) throws TException {
		return num1 - num2;
	}

	@Override
	public double divide(double num1, double num2) throws MathException, TException {

		if (num2 == 0) {
			throw new MathException();
		}

		return num1 / num2;
	}
}
