package com.enstax.cesarcano.hellogas.ui.helper.base;

/**
 * Created by cesarcanojmz@gmail.com
 */


public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}