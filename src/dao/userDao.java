package dao;
import java.util.List;
import entity.User;
import entity.userbuy;
import entity.userlook;
public interface userDao {
    public int insert(User user);
    public int update(User user);
    public int delete(User user);
    public List<User> getAll();   //查询全部
    public User findUser(User user);
    public List<User> getUserByName(String user);


}
