package com.geektcp.alpha.design.pattern.mediator;

/**
 * Created by TangHaiyang on 2019/9/21.
 */
public class Sprinkler extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("sprinkler");
    }

    public void doSprinkler() {
        System.out.println("doSprinkler()");
    }
}
