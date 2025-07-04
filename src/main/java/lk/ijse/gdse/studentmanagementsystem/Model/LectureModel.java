package lk.ijse.gdse.studentmanagementsystem.Model;

import lk.ijse.gdse.studentmanagementsystem.DbConnection.DbConnection;
import lk.ijse.gdse.studentmanagementsystem.Dto.LectureDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LectureModel {


      public boolean saveLecture(LectureDto lectureDto) throws SQLException, ClassNotFoundException {
          Connection connection = DbConnection.getInstance().getConnection();
          String sql = "INSERT INTO lectures VALUES(?,?,?,?,?,?)";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setString(1,lectureDto.getLectureId());
          preparedStatement.setString(2,lectureDto.getLectureName());
          preparedStatement.setString(3,lectureDto.getLectureAge());
          preparedStatement.setString(4,lectureDto.getLectureAdress());
          preparedStatement.setString(5,lectureDto.getLecturePhone());
          preparedStatement.setString(6,lectureDto.getCouresId());

          int i = preparedStatement.executeUpdate();
          boolean isSaved = i > 0 ;
          return isSaved ;
      }

    public boolean updateLecture(LectureDto lectureDto) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE lectures SET lectures_name=?, lectures_age=?, lectures_address=?, lecture_phone=?, coures_id=? WHERE lecture_id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,lectureDto.getLectureId());
        preparedStatement.setString(2,lectureDto.getLectureName());
        preparedStatement.setString(3,lectureDto.getLectureAge());
        preparedStatement.setString(4,lectureDto.getLectureAdress());
        preparedStatement.setString(5,lectureDto.getLecturePhone());
        preparedStatement.setString(6,lectureDto.getCouresId());

        int i = preparedStatement.executeUpdate();
        boolean isSaved = i > 0 ;
        return isSaved ;
    }

    public boolean deleteLecture(String lectureId) throws SQLException, ClassNotFoundException {
          Connection connection = DbConnection.getInstance().getConnection();
          String sql = "DELETE FROM lectures WHERE lecture_id=?";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setString(1,lectureId);

          int i = preparedStatement.executeUpdate();
          boolean isSaved = i > 0 ;
          return isSaved;
    }

    public ArrayList<LectureDto> getAllLectures() throws SQLException, ClassNotFoundException {
          Connection connection = DbConnection.getInstance().getConnection();
          String sql = "SELECT * FROM lectures";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          ResultSet resultSet = preparedStatement.executeQuery();
          ArrayList<LectureDto> lectureDtos = new ArrayList<>();

          while (resultSet.next()) {
              LectureDto lectureDto = new LectureDto();
              lectureDto.setLectureId(resultSet.getString("lectures_id"));
              lectureDto.setLectureName(resultSet.getString("lectures_name"));
              lectureDto.setLectureAge(resultSet.getString("lectures_age"));
              lectureDto.setLectureAdress(resultSet.getString("lectures_address"));
              lectureDto.setLecturePhone(resultSet.getString("lectures_phone_number"));
              lectureDto.setCouresId(resultSet.getString("course_id"));
              lectureDtos.add(lectureDto);
          }
          return lectureDtos;
    }
}
