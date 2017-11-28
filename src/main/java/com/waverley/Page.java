package com.waverley;

public interface Page {
    Page navigateTo();

    default String url(){
        return "http://localhost";
    }
}
