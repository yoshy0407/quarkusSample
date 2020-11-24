package org.acme;

import org.acme.init.MyApp;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * 基本的にこのmainクラスはquarkusが自動生成してくれるらしい。
 * ただ、こうやってメインクラスとして存在するとIDEとかから実行しやすくなる
 * 
 * @author 9800111
 *
 */
@QuarkusMain
public class Main {

	public static void main(String[] args) {
		System.out.println("Running main method");
		//Quarkusアプリケーションの実行
		Quarkus.run(args);
		
		//QuarkusApplicationを実装したクラスを渡すことでも特定のクラスを起動できる
		//Quarkus.run(MyApp.class, args);
	}
}
