package com.example.demo.repository;

import com.example.demo.entity.Demo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ashutoshpandey on 11/05/18.
 */
@Repository
public interface DemoRepository extends PagingAndSortingRepository<Demo, Long> {

    Demo findByExternalId(String externalId);

}
