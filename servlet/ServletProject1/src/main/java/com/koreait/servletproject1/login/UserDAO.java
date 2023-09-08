package com.koreait.servletproject1.login;

import java.sql.*;

// DAO : Data Access Object. 데이터의 접근, 공유 담당.
// DB와 JAVA의 접점. 데이터를 주고받는 중간 역할.
// Controller와 DB와의 연계를 위함
public class UserDAO {
    private Connection connection;
    public UserDAO() {
        // DAO 객체 생성 시 최초 DB와 Connection 후 Connection 객체를 가지고 있음
        System.out.println("DB connection...");
        connection = new DBConnection().get_connection();
    }

    public UserVO get_user(String id, String pw) {
        // DAO는 받은 데이터로 DB에 해당되는 정보를 조회.
        String select = "SELECT * FROM `users_tbl` WHERE id = ? AND pw = ?";
        try (PreparedStatement statement = connection.prepareStatement(select)) {
            statement.setString(1, id);
            statement.setString(2, pw);
            // 유저에게서 받은 데이터로 DB 조회 쿼리 전송
            ResultSet set = statement.executeQuery();
            set.next();
            // DB에서 조회 결과 가져옴
            String nick = set.getString("nickname");
            // id, pw가 틀리면 nickname을 가져오지 못함
            if(nick == null) {
                // 3-2 일치하는 정보가 없음 -> 로그인 실패, null 반환
                return null;
            }
            else {
                // 3-1 일치하는 정보가 있음 -> 로그인 성공, 찾은 객체 반환
                UserVO vo = new UserVO(id, pw, nick);
                return vo;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getLocalizedMessage());
            // 3-2 일치하는 정보가 없음 -> 로그인 실패, null 반환
            return null;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

    }

}



//DAO: Data Access Object. 데이터의 접근, 공유 담당.
//DB와 JAVA의 접점. 데이터를 주고받는 중간 역할.
//Controller와 DB와의 연계를 위함
//public class UserDAO {
//    private final Connection connection;
//    //DAO 객체 생성 시 최초 DB와 Connection 후 Connection 객체를 가지고 있음
//    public UserDAO(){
//        connection = new DBConnection().get_connection();
//    }
//
//    // Controller에서 받은 id, pw, nickName 정보로 DB에서 조회해서 데이터를 반환
//    public UserVO get_user(String id, String pw){
//        //DAO는 받은 데이터로 DB에 해당되는 정보를 조회한다
//        String selectSQL = "SELECT * FROM `users_tbl` WHERE id = ? AND pw = ?";
//        try(PreparedStatement statement = connection.prepareStatement(selectSQL);){
//            statement.setString(1, id);
//            statement.setString(2, pw);
//            // 유저에게서 받아온 데이터로 DB 조회 쿼리를 전송한다
//            ResultSet set = statement.executeQuery();
//            set.next();
//            // DB에서 조회 결과를 가져온다
//            String nickName = set.getString("nickName");
//            // nickName을 못가져 왔다면 id나 pw가 틀렸다는 얘기
//            if(nickName == null){
//                // 3-2)=> 일치하는게 없다 == 로그인 실패
//                return null;
//            }else{
//                //3-1)=> 일치하는게 있다 == 로그인 성공
//                //id와 pw, nickNAme을 가지는 User객체를 만들고 반환
//                return new UserVO(id, pw, nickName);
//            }
//        }catch (SQLException e){
//            System.out.println(e);
//            System.out.println(e.getMessage());
//            // 3-2)=> 일치하는게 없다 == 로그인 실패
//            return null; // 찾은 객체가 없으니 null 반환
//        }
//    }
//}






