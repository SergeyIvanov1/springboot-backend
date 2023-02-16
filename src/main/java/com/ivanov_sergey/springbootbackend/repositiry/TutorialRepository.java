package com.ivanov_sergey.springbootbackend.repositiry;

import java.util.List;

import com.ivanov_sergey.springbootbackend.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}
