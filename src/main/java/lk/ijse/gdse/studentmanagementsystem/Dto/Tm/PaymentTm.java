package lk.ijse.gdse.studentmanagementsystem.Dto.Tm;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTm {
    private String paymentId;
    private String attendentDate;
    private String amount;
    private String discount;
    private String studentId;
}
