package org.yoshioka.quarkus.getting.started.producer;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * Producer機能
 * Springで言う、Configurationクラスに似た概念。
 * このクラスを作成して、プログラムチックにBeanの生成ができる
 * 
 * @author 9800111
 *
 */
@ApplicationScoped
public class ProducerSample {

	//変数だけでBeanのように定義することも可能
	//単純にインスタンス化するだけであれば、これで十分
	@Produces
	String producerStr = "Producer String!";
	
	
	//少し追加で生成したインスタンスに設定を追加したい場合、
	//メソッドで定義してもOK
	@Produces
	public List<String> names(){
		List<String> lists = new ArrayList<>();
		lists.add("john");
		lists.add("tom");
		return lists;
	}
}
