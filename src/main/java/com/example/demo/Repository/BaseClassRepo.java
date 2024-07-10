package com.example.demo.Repository;

import com.example.demo.Model.BaseClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseClassRepo extends JpaRepository<BaseClass,Long> {
}
