package com.example.petya.tinkofffintech;

public interface BasePresenter<T> {

    void takeView(T view);

    void dropView();

}
