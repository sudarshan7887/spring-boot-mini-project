package com.sudarshan.StudentMgnt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudarshan.StudentMgnt.Domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>
{
	
}
