package com.cs.service.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.KeywordDao;
import com.cs.dao.impl.KeywordDaoImpl;
import com.cs.entity.Keyword;
import com.cs.service.KeywordService;

import java.util.List;

public class KeywordServiceImpl extends BaseDao implements KeywordService {
    KeywordDaoImpl kdi = new KeywordDaoImpl();
    @Override
    public List<Keyword> findBydateInfo() throws Exception {
        return kdi.findBydateInfo();
    }

    @Override
    public Keyword fingByname(String name) throws Exception {
        return kdi.fingByname(name);
    }

    @Override
    public boolean addKeyword(Keyword keyword) throws Exception {
        int i = kdi.addKeyword(keyword);
        if(i>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean delKeyword(String name) throws Exception {
        int i = kdi.delKeyword(name);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }
}
