package com.example.LibraryManagement;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookJpaRepository extends JpaRepository<Book, Long>{

}
