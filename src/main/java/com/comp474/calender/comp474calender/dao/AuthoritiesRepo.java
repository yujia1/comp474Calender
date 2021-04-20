package com.comp474.calender.comp474calender.dao;

import com.comp474.calender.comp474calender.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepo extends JpaRepository<Authorities, String> {
}
