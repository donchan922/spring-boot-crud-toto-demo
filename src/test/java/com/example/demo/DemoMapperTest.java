package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
class DemoMapperTest {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    void findAll() {
        List<Task> taskList = demoMapper.findAll();
        assertAll(
                () -> assertEquals(3, taskList.size()),
                () -> assertEquals(1, taskList.get(0).getId()),
                () -> assertEquals(2, taskList.get(1).getId()),
                () -> assertEquals(3, taskList.get(2).getId()),
                () -> assertEquals("Bring an umbrella", taskList.get(0).getTitle()),
                () -> assertEquals("Buy spring water", taskList.get(1).getTitle()),
                () -> assertEquals("Go to the gym", taskList.get(2).getTitle())
        );
    }

    @Test
    void findById() {
        Task task = demoMapper.findById(1);
        assertAll(
                () -> assertEquals(1, task.getId()),
                () -> assertEquals("Bring an umbrella", task.getTitle())
        );
    }

    @Test
    void insert() {
        int result = demoMapper.insert(new Task(4, "Running"));
        assertAll(
                () -> assertEquals(1, result)
        );
    }

    @Test
    void update() {
        int result = demoMapper.update(new Task(1, "Swimming"));
        assertAll(
                () -> assertEquals(1, result)
        );
    }

    @Test
    void delete() {
        int result = demoMapper.delete(1);
        assertAll(
                () -> assertEquals(1, result)
        );
    }
}
