package com.gokhan.northwind.core.utilities;

public class ErrorResult extends Result {

    public ErrorResult(String message) {
        super(false, message);
    }

    public ErrorResult() {
        super(false);
    }
}
