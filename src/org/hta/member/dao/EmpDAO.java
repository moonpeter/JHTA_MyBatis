package org.hta.member.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hta.member.domain.Emp;
import org.hta.member.domain.Join;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class EmpDAO {
    private SqlSession getSession(){
        SqlSession session = null;
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("org/hta/mybatis/config/sqlMapConfig.xml");
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
            session = sf.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

    public List<Emp> getTermList(Map<String, String> m) {
        List<Emp> list = null;
        SqlSession session = null;

        try{
            session = getSession();
            list = session.selectList("org.hta.mybatis.mapper.termList", m);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return list;
    }

    public List<Emp> getTermList2(Map<String, String> m) {
        List<Emp> list = null;
        SqlSession session = null;

        try{
            session = getSession();
            list = session.selectList("termList2", m);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return list;
    }

    public List<Emp> getCheck(Map<String, Object> map) {
        List<Emp> list =null;
        SqlSession session = null;

        return null;
    }

    public List<Join> getJoin(String name) {
        List<Join> list = null;
        SqlSession session = null;
        try{
            session = getSession();
            list = session.selectList("join", name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null)
                session.close();
        }
        return list;
    }
}
