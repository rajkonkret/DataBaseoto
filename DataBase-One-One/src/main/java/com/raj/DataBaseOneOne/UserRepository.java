package com.raj.DataBaseOneOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
//public interface UserRepository extends JpaRepository<User, Integer> {
    /* generuje metody takie jak save,findall,count, czyli zapytania w bazie danych

     */
}
