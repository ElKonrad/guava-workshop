package base;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Getter;

import static base.Student.Status.STUDENT;

@Builder
@Getter
public class Student {

    public enum Status {
        STUDENT, GRADUATE
    }

    private String firstName;
    private String lastName;
    private Group group;
    private Status status;

//    public String getGroup() {
//        if (this.status != Status.STUDENT)
//            throw new IllegalStateException("This student doesn't have the student status");
//
//        return this.group;
//    }

    public Group getGroup() {
        Preconditions.checkState(status.equals(STUDENT), "This student doesn't have the student status");
        return this.group;
    }
}
