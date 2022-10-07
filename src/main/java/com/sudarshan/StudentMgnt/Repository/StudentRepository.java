package com.sudarshan.StudentMgnt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudarshan.StudentMgnt.Domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	@Query(value = "select student.id,student.stname,Course.cname FROM student INNER JOIN Course ON student.id = Course.id",nativeQuery=true)
	List<Object[]>findStudent();
}
