package lk.ijse.gdse.studentmanagementsystem.Model;

import lk.ijse.gdse.studentmanagementsystem.DbConnection.DbConnection;
import lk.ijse.gdse.studentmanagementsystem.Dto.CourseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseModel {
      public boolean saveCourse(CourseDto courseDto) throws SQLException, ClassNotFoundException {
          Connection connection = DbConnection.getInstance().getConnection();
          String sql = "insert into course values(?,?,?,?,?)";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);

          preparedStatement.setString(1, courseDto.getCourseId());
          preparedStatement.setString(2, courseDto.getCourseName());
          preparedStatement.setString(3, courseDto.getCoursePayment());
          preparedStatement.setString(4, courseDto.getCourseDiuration());
          preparedStatement.setString(5, courseDto.getStudentId());

           int i = preparedStatement.executeUpdate();
           boolean isSave = i > 0;
           return isSave;
      }

    public boolean updateCourse(CourseDto courseDto) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "update course set course_name = ?,course_payment = ?,course_diuration = ?, student_id = ?, where course_id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, courseDto.getCourseName());
        preparedStatement.setString(2, courseDto.getCoursePayment());
        preparedStatement.setString(3, courseDto.getCourseDiuration());
        preparedStatement.setString(4, courseDto.getStudentId());
        preparedStatement.setString(5, courseDto.getCourseId());

        int i = preparedStatement.executeUpdate();
        boolean isSave = i > 0;
        return isSave;
    }

    public boolean deleteCourse(String courseDto) throws SQLException, ClassNotFoundException {
          Connection connection = DbConnection.getInstance().getConnection();
          String sql = "delete from course where course_id = ?";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setString(1, courseDto.getCourseId());

          int i = preparedStatement.executeUpdate();
          boolean isSave = i > 0;
          return isSave;
    }

    public ArrayList<CourseDto> getAllCourse() throws SQLException, ClassNotFoundException {
          Connection connection = DbConnection.getInstance().getConnection();
          String sql = "select * from course";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          ResultSet resultSet = preparedStatement.executeQuery();

          ArrayList<CourseDto> courseDtos = new ArrayList<>();

          while (resultSet.next()) {
              CourseDto courseDto = new CourseDto();
              courseDto.setCourseId(resultSet.getString("course_id"));
              courseDto.setCourseName(resultSet.getString("course_name"));
              courseDto.setCoursePayment(resultSet.getString("course_payment"));
              courseDto.setCourseDiuration(resultSet.getString("course_diuration"));
              courseDto.setStudentId(resultSet.getString("student_id"));
              courseDtos.add(courseDto);
          }
          return courseDtos;
    }

}
