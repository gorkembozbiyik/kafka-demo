package com.nordcloud.kafkademo.services;

import java.util.List;

public interface DemoService {

    long saveData(String data);
    long saveAll(List<String> dataList);
}
