package com.example.demo.repository;

import com.example.demo.beans.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<Coffee,String> {
}
