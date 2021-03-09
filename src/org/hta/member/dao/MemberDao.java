package org.hta.member.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hta.member.domain.Member;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MemberDao {
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

    public int chk(Member member) {
        int result = 0; // 아이디가 없는 경
        SqlSession session = null;
        try {
            session = getSession();

            // 조회 결과가 없는 경우 mem은 null
            Member mem = (Member) session.selectOne("org.hta.mybatis.member.select", member.getId());
            if(mem != null){
                if(mem.getId().equals(member.getId())){
                    result = -1; // 아이디는 같고 비번이 다른 경우
                    if(mem.getPassword().equals(member.getPassword())) {
                        result = 1; //아이디 비번이 같은 경우
                    }
                }
            } else {
                System.out.println("chk() 결과 = null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null)
                session.close(); // SqlSession을 닫아 자원을 해제합니다.
        }
        return result;
    }

    public int insert(Member member) {
        int result = 0;
        SqlSession session = null;
        try{
            session = getSession();
            result = session.insert("org.hta.mybatis.member.insert", member);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session !=null)
                session.close();
        }
        return result;
    }


    public List<Member> list() {
        List<Member> list = null;
        SqlSession session = null;
        try{
            session = getSession();
            list = session.selectList("list");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
        }
        return list;
    }

    public Member select(String id) {
        Member mem = null;
        SqlSession session = null;
        try{
            session = getSession();
            mem = (Member) session.selectOne("select", id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if(session != null)
                session.close();
        }
        return mem;
    }

    public int update(Member mem) {
        int result = 0;
        SqlSession session = null;
        try{
            session = getSession();
            result = session.update("update", mem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            if(session != null)
                session.close();
        }
        return result;
    }

    public int delete(String id) {
        int result = 0;
        SqlSession session = null;
        try{
            session = getSession();
            result = session.delete("delete", id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if(session != null)
                session.close();        }
        return result;
    }
}
