package com.cs.service;

import com.cs.entity.Keyword;

import java.util.List;

public interface KeywordService {
    //查询方法，查询所有关键词信息，查询结果按照创建时间降序排列
    public List<Keyword> findBydateInfo() throws Exception;

    //查询方法，根据关键词名称查询关键词信息
    public Keyword fingByname(String name) throws Exception;

    //添加方法，将新的关键词保存到数据库
    public boolean addKeyword(Keyword keyword) throws Exception;

    //删除方法，将指定的关键词从数据库中删除
    public boolean delKeyword(String name) throws Exception;
}
