package lk.ijse.gdse.studentmanagementsystem.Dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private String paymentId;
    private String attendentDate;
    private String amount;
    private String discount;
    private String studentId;
}
