package com.nordcloud.kafkademo.services;

import com.nordcloud.kafkademo.entity.DemoEntity;
import com.nordcloud.kafkademo.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    @Override
    public long saveData(String data) {
        DemoEntity save = demoRepository.save(DemoEntity.builder().data(data).build());

        return save.getId();
    }

    @Override
    public long saveAll(List<String> dataList) {
        List<DemoEntity> collect = dataList.stream().map(this::toMap).collect(Collectors.toList());

        List<DemoEntity> demoData = demoRepository.saveAll(collect);
        return demoData.size();
    }

    private DemoEntity toMap(String data) {
        return DemoEntity.builder().data(data).build();
    }
}
