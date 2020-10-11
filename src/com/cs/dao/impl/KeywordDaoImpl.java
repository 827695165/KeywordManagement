package com.cs.dao.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.KeywordDao;
import com.cs.entity.Keyword;
import javafx.beans.binding.ObjectExpression;

import java.security.Key;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KeywordDaoImpl extends BaseDao implements KeywordDao {
    //查询方法，查询所有关键词信息，查询结果按照创建时间降序排列
    @Override
    public List<Keyword> findBydateInfo() throws Exception {
        List<Keyword> list = new ArrayList<Keyword>();
        String sql = "select * from keyword order by creatDate desc";
        ResultSet rs = exeuQuery(sql,null);
        while (rs.next()){
            Keyword kw = new Keyword();
            kw.setId(rs.getInt(1));
            kw.setName(rs.getString(2));
            kw.setType(rs.getString(3));
            kw.setCreateDate(rs.getTimestamp(4));
            list.add(kw);
        }
        getClose();
        return list;
    }

    //查询方法，根据关键词名称查询关键词信息
    @Override
    public Keyword fingByname(String name) throws Exception {
        Keyword kw = null;
        String sql = "select * from keyword where `name`=?";
        Object obj[]={name};
        ResultSet rs = exeuQuery(sql,obj);
        while(rs.next()){
            kw = new Keyword();
            kw.setId(rs.getInt(1));
            kw.setName(rs.getString(2));
            kw.setType(rs.getString(3));
            kw.setCreateDate(rs.getTimestamp(4));
        }
        getClose();
        return kw;
    }

    //添加方法，将新的关键词保存到数据库
    @Override
    public int addKeyword(Keyword keyword) throws Exception {
        int index = -1;
        String sql = "insert into keyword(`name`,`type`,createDate) values(?,?,?)";
        Object obj[] = {keyword.getName(),keyword.getType(),keyword.getCreateDate()};
        index = exeuUpdate(sql,obj);
        getClose();
        return index;
    }

    //删除方法，将指定的关键词从数据库中删除
    @Override
    public int delKeyword(String name) throws Exception {
        int index = -1;
        String sql = "delete from keyword where `name` = ?";
        Object obj[] = {name};
        index = exeuUpdate(sql,obj);
        getClose();
        return index;
    }
}
