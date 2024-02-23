package dk.favrholdt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class StudentInfo {

    String fullName;

    @Id

    int studentId;
    String thisSemesterName;
    String thisSemesterDescription;

    public StudentInfo(String fullName, int studentId, String thisSemesterName, String thisSemesterDescription) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.thisSemesterName = thisSemesterName;
        this.thisSemesterDescription = thisSemesterDescription;
    }

    //return a list of all Students  encapsulated as StudentInfo
   public StudentInfo getAllStudentInfo(int id) {
        return new StudentInfo(getFullName(), getStudentId(), getThisSemesterName(), getThisSemesterDescription());
    }
}

