package com.haizhi.observer;

/* Created by Haiyang on 2018/2/28. */


import java.util.Observable;
import java.util.Observer;


public class Publish extends Observable {
    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!this.data.equals(data)){
            this.data = data;
            setChanged();    //改变通知者的状态
        }
        notifyObservers();    //调用父类Observable方法，通知所有观察者
    }


}
