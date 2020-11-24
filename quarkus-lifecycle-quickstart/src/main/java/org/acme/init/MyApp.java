package org.acme.init;

import javax.inject.Inject;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.CommandLineArguments;

public class MyApp implements QuarkusApplication {

	//コマンドラインで渡された引数をインジェクトすることも可能
	@Inject
	@CommandLineArguments
	String[] injArgs;
	
	@Override
	public int run(String... args) throws Exception {
		System.out.println("Do startup logic here");
		System.out.println(injArgs);
		Quarkus.waitForExit();
		return 0;
	}

}
