package org.acme.quarkus.greeting.deployment;

import static org.hamcrest.CoreMatchers.containsString;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusUnitTest;
import io.restassured.RestAssured;

/**
 * Quarkusの拡張機能のテストクラス
 * Processorの記載方法で正しく機能がQuarkusにextensionとして登録されるかチェックする
 *
 */
class GreetingTest {

	//これを記載することでQuarkusとともに、拡張機能を起動する
	@RegisterExtension
	static final QuarkusUnitTest config = new QuarkusUnitTest()
			.setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class));
	
	
	@Test
	void test() {
		RestAssured.
		when().get("/greeting")
		.then().statusCode(200)
		.body(containsString("Hello"));
	}

}
