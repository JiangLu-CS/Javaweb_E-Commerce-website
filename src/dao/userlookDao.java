package dao;

import entity.userlook;

import java.util.List;

public interface userlookDao {
    public int adduserlook (userlook userlook);
    public List<userlook> getAll();
}
