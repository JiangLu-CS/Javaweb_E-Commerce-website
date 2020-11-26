package dao;

import entity.goodcount;

import java.util.List;

public interface goodCountDao {
    public int addgood(goodcount good);
    public List<goodcount> getAll();
    public goodcount findGood(goodcount good);
    public int findnum(goodcount good);
    public int findProfit(goodcount good);
}
