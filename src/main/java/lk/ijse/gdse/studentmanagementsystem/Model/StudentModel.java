package lk.ijse.gdse.studentmanagementsystem.Model;

import lk.ijse.gdse.studentmanagementsystem.DbConnection.DbConnection;
import lk.ijse.gdse.studentmanagementsystem.Dto.StudentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    public boolean saveStudent(StudentDto studentDto) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "insert into student values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, studentDto.getStudentId());
        preparedStatement.setString(2, studentDto.getStudentName());
        preparedStatement.setString(3, studentDto.getStudentAddress());
        preparedStatement.setString(4, studentDto.getStudentBdy());
        preparedStatement.setString(5, studentDto.getStudentAge());
        preparedStatement.setString(6, studentDto.getStudentPhoneNumber());

        int i = preparedStatement.executeUpdate();
        boolean issave = i>0;
        return issave;
    }

    public boolean updateStudent(StudentDto studentDto) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "update student set student_name=?,student_address=?,student_birth_day=? ,student_age=?, student_phone_number=? where student_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, studentDto.getStudentName());
        preparedStatement.setString(2, studentDto.getStudentAddress());
        preparedStatement.setString(3, studentDto.getStudentBdy());
        preparedStatement.setString(4, studentDto.getStudentAge());
        preparedStatement.setString(5, studentDto.getStudentPhoneNumber());
        preparedStatement.setString(6, studentDto.getStudentId());

        int i = preparedStatement.executeUpdate();
        boolean issave = i>0;
        return issave;
    }

    public boolean deleteStudent(String studentid) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "delete from student where student_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, studentid);

        int i = preparedStatement.executeUpdate();
        boolean issave = i>0;
        return issave;
    }

    public  ArrayList<StudentDto> getAllStudent() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<StudentDto> studentDtos = new ArrayList<>();

        while (resultSet.next()) {
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(resultSet.getString("student_id"));
            studentDto.setStudentName(resultSet.getString("student_name"));
            studentDto.setStudentAddress(resultSet.getString("student_address"));
            studentDto.setStudentBdy(resultSet.getString("student_birth_day"));
            studentDto.setStudentAge(resultSet.getString("student_age"));
            studentDto.setStudentPhoneNumber(resultSet.getString("student_phone_number"));

            studentDtos.add(studentDto);
        }
        return studentDtos;
    }

}
