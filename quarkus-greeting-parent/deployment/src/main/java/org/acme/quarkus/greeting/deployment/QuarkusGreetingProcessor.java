package org.acme.quarkus.greeting.deployment;

import org.acme.quarkus.greeting.GreetingServlet;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.undertow.deployment.ServletBuildItem;

class QuarkusGreetingProcessor {

    private static final String FEATURE = "quarkus-greeting";

    //このアノテーションをつけることで、Quarkusアプリケーションのビルド時に対象として処理される
    @BuildStep
    FeatureBuildItem feature() {
    	//ここのFEATUREがアプリケーションの起動時にログに表示され、どんな機能なのかを表す
    	//BuildItemはQuarkusの拡張機能を表す
        return new FeatureBuildItem(FEATURE);
        //ServletBuildItem Servlet用
        //BeanContainerBuildItem DIコンテナに登録して利用することを表すもの
    }
    
    @BuildStep
    public ServletBuildItem createServlet() {
    	ServletBuildItem servletBuildItem = ServletBuildItem.builder("greeting", GreetingServlet.class.getName())
    											.addMapping("/greeting")
    											.build();
    	return servletBuildItem;
    }

}
