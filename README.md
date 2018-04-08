# apache-thrift

* **Apache-Thrift 프레임워크로 빠르게 서버와 서비스 인터페이스 구성하기**

* **Apache Thrift**
```
	*. software framework for scalable cross language service development. 
	
	*. It combines software stack with a code generation engine to build services that work efficiently and seamlessly
	
	*. 이 기종 간 통신 방식으로 RPC(Remote Procedure Call)를 이용하는 소프트웨어 프레임워크.
	
	*. Thrift-Compiler 로 각 프로그래밍 언어에 맞는 서비스 Interface를 Generation.

	*. Generation한 Interface와 Thrift 프레임워크(RPC, Serialization)을 이용하여 서버를 구성.
	
	*. 클라이언트는 Generation Interface(service api stub)을 참조하여 RPC 방식으로 서버의 API를 호출.
```
---

* **이용 방법**
```
	1. Thrift Description 파일 작성 (.thrift)
	
	2. Thrift-Compiler를 실행하여 프로그래밍 언어에 맞는 서비스 인터페이스 Generation.
	
	3. Generation 한 서비스 인터페이스를 참조하여 구현체 개발.
```
---

* **Thrift-Compiler Download**
```
	-. https://thrift.apache.org/download
```
---

