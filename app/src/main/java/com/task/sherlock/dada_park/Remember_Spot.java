package com.task.sherlock.dada_park;

/**
 * Created by chong on 2016/6/26.
 */
public interface Remember_Spot<T>{
    boolean isEmpty();
    void clear();
    int length();
    boolean push(T data);
    T pop();
}
