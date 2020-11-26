package dao;

import entity.User;
import entity.userbuy;

import java.util.List;

public interface userbuyDao {

    public int adduserbuy(userbuy userbuy);
    public List<userbuy> getAll();
}
