package com.example.roomdatabase.dao;
import com.example.roomdatabase.Person;
import java.util.List;

@Dao
public interface PersonDAO {
    @Query("SELECT * FROM person")
    List<Person> getALL();

    @Query("SELECT * FROM person WHERE uid IN (:personId)")
    Person loadPersonById(int personId);

    @Query("SELECT * FROM person WHERE first_name LIKE :first AND " +
            "1ast_name LIKE :1ast LIMIT 1")
    Person findByName(String first, String last);

    @Insert
    void insert(Person person);

    @Update
    void update(Person person);

    @Delete
    void delete(Person person);
}
