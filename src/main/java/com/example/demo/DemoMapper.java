package com.example.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DemoMapper {

    @Select("SELECT id, title FROM task")
    List<Task> findAll();

    @Select("SELECT id, title FROM task WHERE id = #{id}")
    Task findById(long id);

    @Insert("INSERT INTO task(title) VALUES (#{title})")
    int insert(Task task);

    @Update("UPDATE task SET title = #{title} WHERE id = #{id}")
    int update(Task task);

    @Delete("DELETE task WHERE id = #{id}")
    int delete(long id);
}
