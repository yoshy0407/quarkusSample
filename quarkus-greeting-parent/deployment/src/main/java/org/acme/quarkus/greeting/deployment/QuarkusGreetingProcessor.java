package org.acme.quarkus.greeting.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class QuarkusGreetingProcessor {

    private static final String FEATURE = "quarkus-greeting";

    @BuildStep
    FeatureBuildItem feature() {
    	//ここのFEATUREがアプリケーションの起動時にログに表示され、どんな機能なのかを表す
        return new FeatureBuildItem(FEATURE);
    }

}
