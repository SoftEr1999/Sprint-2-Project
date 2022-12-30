package net.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sms.springboot.model.student;

@Repository
public interface studentRepository extends JpaRepository<student, Long>{

}
