package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Trimestre;

public interface DaoTrimestre extends JpaRepository<Trimestre, Integer> {

}
