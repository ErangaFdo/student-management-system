package lk.ijse.gdse.studentmanagementsystem.Dto.Tm;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseTm {
    private String CourseId;
    private String CourseName;
    private String CoursePayment;
    private String CourseDiuration;
    private String StudentId;
}
