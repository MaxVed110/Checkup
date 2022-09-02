import java.util.Comparator;

public class ComparatorHeight implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getHeight(), s2.getHeight());
    }
}
