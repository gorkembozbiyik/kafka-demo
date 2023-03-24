package com.nordcloud.kafkademo.exception;

public class KafkaRetryException extends RuntimeException {

    public KafkaRetryException(String message) {
        super(message);
    }
}
