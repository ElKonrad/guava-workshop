package base;

import org.testng.annotations.Test;

import static base.Student.Status.GRADUATE;
import static base.Student.Status.STUDENT;

public class PreconditionsTest {

    @Test(expectedExceptions = IllegalStateException.class,
            expectedExceptionsMessageRegExp = "This student doesn't have the student status")
    public void shouldThrowIllegalState() {
        Student student = Student.builder()
                                 .firstName("Jan")
                                 .lastName("Kowalski")
                                 .group(Group.builder().name("A").build())
                                 .status(GRADUATE)
                                 .build();

        student.getGroup();
    }

    @Test(expectedExceptions = NullPointerException.class,
            expectedExceptionsMessageRegExp = "Group name cannot be null")
    public void shouldNotAcceptNullGroupName() {
        Student student = Student.builder()
                                 .firstName("Jan")
                                 .lastName("Kowalski")
                                 .group(Group.builder().name("A").build())
                                 .status(STUDENT)
                                 .build();

        student.getGroup().updateGroupName(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Group name cannot be longer than 3 characters")
    public void shouldNotAcceptGroupNameLongerThan3Characters() {
        Student student = Student.builder()
                                 .firstName("Jan")
                                 .lastName("Kowalski")
                                 .group(Group.builder().name("A").build())
                                 .status(STUDENT)
                                 .build();

        student.getGroup().updateGroupName("A123");
    }
}