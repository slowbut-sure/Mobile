package com.example.roomdatabase.db;

import com.example.roomdatabase.Person;
import com.example.roomdatabase.dao.PersonDAO;

import c

@Database(entities = {Person.class}, version = 1)
public abstract class  AppDatabase extends RoomDatabase{
    public  abstract PersonDAO personDao();
}
