package lk.ijse.gdse.studentmanagementsystem.Dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String CourseId;
    private String CourseName;
    private String CoursePayment;
    private String CourseDiuration;
    private String StudentId;
}
