package lk.ijse.gdse.studentmanagementsystem.Model;

import lk.ijse.gdse.studentmanagementsystem.DbConnection.DbConnection;
import lk.ijse.gdse.studentmanagementsystem.Dto.PaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
