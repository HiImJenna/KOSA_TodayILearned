package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.Memo;
import kr.or.kosa.utils.SingletonHelper;

/*
DB 연결
CRUD 함수 생성 >> memo
1. 전체조회   : select id, email, content from memo
2. 조건 조회  : select id, email, content from memo where id = ? // 제약 id > pk
3. 삽입      : insert into memo(id, email, content) values(?,?,?)
4. 삭제      : delete from memo where id = ?
5. 수정      : update memo set email = ?, content = ? where id = ?
알파 ... LIKE 검색 where email like '%naver%'

자바로 함수를 생성 ... 처리 ... 거의 똑같아요
ArrayList
HashMap
제너릭 ....
*/

public class MemoDao {
   Connection conn = null;
   
   public MemoDao() {
      conn = SingletonHelper.getConnection("oracle");
   }
   
   // 전체조회
   public List<Memo> getMemoList() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<Memo> memoList = new ArrayList<Memo>();
      try {
         String sql = "select id, email, content from memo";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            Memo memo = new Memo();
            memo.setId(rs.getString("id"));
            memo.setEmail(rs.getString("email"));
            memo.setContent(rs.getString("content"));
            memoList.add(memo);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         SingletonHelper.close(rs);
         SingletonHelper.close(pstmt);
      }
      return memoList;
   }
   
   // 조건 조회
   public Memo getMemoByMemoId(String memoId) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Memo memo = null;
      
      try {
         String sql = "select id, email, content from memo where id = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, memoId);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            memo = new Memo(); // 하나의 row 담기 위한 객체
            memo.setId(rs.getString("id"));
            memo.setEmail(rs.getString("email"));
            memo.setContent(rs.getString("content"));
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         SingletonHelper.close(rs);
         SingletonHelper.close(pstmt);
      }
      
      return memo;
   }
   
   // 삽입
   public int insertMemo(Memo memo) {
      PreparedStatement pstmt = null;
      int rowcount = 0;
      
      try {
         String sql = "insert into memo(id, email, content) values(?,?,?)";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, memo.getId());
         pstmt.setString(2, memo.getEmail());
         pstmt.setString(3, memo.getContent());
         rowcount = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
         System.out.println(e.getMessage());
      } finally {
         SingletonHelper.close(pstmt);
      }
      
      return rowcount;
   }
   
   // 삭제
   public int deleteMemo(String memoId) {
      
      PreparedStatement pstmt = null;
      int rowcount = 0;

      try {
         String sql = "delete from memo where id = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, memoId);
         rowcount = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println(e.getMessage());
      } finally {
         SingletonHelper.close(pstmt);
      }

      return rowcount;
   }
   
   //수정
   public int updateMemo(Memo memo) {
      PreparedStatement pstmt = null;
      int rowcount = 0;

      try {
         String sql = "update memo set email = ?, content = ? where id = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, memo.getEmail());
         pstmt.setString(2, memo.getContent());
         pstmt.setString(3, memo.getId());

         rowcount = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
         System.out.println(e.getMessage());
      } finally {
         SingletonHelper.close(pstmt);
      }

      return rowcount;
   }
}