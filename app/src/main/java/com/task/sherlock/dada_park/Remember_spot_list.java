package com.task.sherlock.dada_park;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by chong on 2016/6/26.
 */
public class Remember_spot_list<T> extends Application implements Remember_Spot{
    private Node top;
    private int size;

    public Remember_spot_list() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        top=null;
        size=0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(Object data) {
        Node node = new Node();
        node.data = (T) data;
        node.pre = top;
        // 改变栈顶指针
        top = node;
        size++;
        return true;
    }

    @Override
    public Object pop() {
        if (top != null) {
            Node node = top;
            // 改变栈顶指针
            top = top.pre;
            size--;
            return node.data;
        }
         return null;
    }

    private final class Node{
        private Node pre;
        private T data;
    }
}
