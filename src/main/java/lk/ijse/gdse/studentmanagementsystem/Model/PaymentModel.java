package lk.ijse.gdse.studentmanagementsystem.Model;

import lk.ijse.gdse.studentmanagementsystem.DbConnection.DbConnection;
import lk.ijse.gdse.studentmanagementsystem.Dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentModel {
    public boolean savePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
         Connection connection = DbConnection.getInstance().getConnection();
         String query = "INSERT INTO payment VALUES(?,?,?,?,?)";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, paymentDto.getPaymentId());
         preparedStatement.setString(2, paymentDto.getAttendentDate());
         preparedStatement.setString(3, paymentDto.getAmount());
         preparedStatement.setString(4, paymentDto.getDiscount());
         preparedStatement.setString(5, paymentDto.getStudentId());

        int i = preparedStatement.executeUpdate();
        boolean issave = i>0;
        return issave;
    }

    public boolean updatePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "UPDATE payment SET attendent_date=?,amount=?,discount=? ,student_id=?  WHERE payment_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, paymentDto.getAttendentDate());
        preparedStatement.setString(2, paymentDto.getAmount());
        preparedStatement.setString(3, paymentDto.getDiscount());
        preparedStatement.setString(4, paymentDto.getStudentId());
        preparedStatement.setString(5, paymentDto.getPaymentId());

        int i = preparedStatement.executeUpdate();
        boolean issave = i>0;
        return issave;
    }

    public boolean deletePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "DELETE FROM payment WHERE payment_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, paymentDto.getPaymentId());

        int i = preparedStatement.executeUpdate();
        boolean issave = i>0;
        return issave;
    }

    public ArrayList<PaymentDto> getAllPayment() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "SELECT * FROM payment";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<PaymentDto> paymentDtos = new ArrayList<>();
        while (resultSet.next()) {
            PaymentDto paymentDto = new PaymentDto();
            paymentDto.setPaymentId(resultSet.getString("payment_id"));
            paymentDto.setAttendentDate(resultSet.getString("attendent_date"));
            paymentDto.setAmount(resultSet.getString("amount"));
            paymentDto.setDiscount(resultSet.getString("discount"));
            paymentDto.setStudentId(resultSet.getString("student_id"));
            paymentDtos.add(paymentDto);

        }
        return paymentDtos;
    }
}
