# apache-thrift-server

* **Thrift-Compiler 다운로드**
```
	*. https://thrift.apache.org/download
```
---

* **이용 방법**
```
	1. Interface Description 파일 작성 (.thrift)
	
	2. 작성한 Descrption 컴파일 (# thrift --gen $LANGUAGE $DESCRIPTION_FILE)
```

* **.지원 타입**
```
	*. bool : Boolean (1byte)
	
	*. byte : byte
	
	*. i16 : short (2byte-integer)
	
	*. i32 : int (4byte-integer)
	
	*. i64 : long (8byte-integer)
	
	*. double : double (8byte-floating point)
	
	*. string : string
	
	*. list<type> : List<type>
	
	*. set<type> : Set<type>
	
	*. map<key, value> : Map<key, value>
```
---