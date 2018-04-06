include "MathException.thrift"

namespace java services

service CalculatorService
{
	i32 add (1 : i32 num1, 2 : i32 num2)
	i32 subtract (1 : i32 num1, 2 : i32 num2)
	double divide (1 : double num1, 2 : double num2) throws (1 : MathException.MathException e)
}