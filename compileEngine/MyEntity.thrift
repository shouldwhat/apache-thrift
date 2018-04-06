include "ColorType.thrift"

namespace java entity

struct MyEntity
{
	1 : required string name;
	2 : optional ColorType.ColorType color;
}