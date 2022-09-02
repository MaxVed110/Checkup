import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Nurse implements Speaker, Iterator<Student> {
    private ArrayList<Student> students;
    private Map<String, Integer> pillows;
    private int item;

    public Nurse(ArrayList<Student> students, Map<String, Integer> pillows) {
        this.students = students;
        this.pillows = pillows;
        this.item = 0;
    }

    public ArrayList<Student> getStudents() {
        while (this.hasNext()) {
            Student buf = this.next();
            System.out.print(buf.getName() + buf.getHeight() + " ");
        }
        item = 0;
        return students;
    }

    public Map<String, Integer> getPillows() {
        return pillows;
    }

    @Override
    public void goToCheckup() {
        while (this.hasNext()) {
            Student buf = this.next();
            if (buf.isIllness()) {
                System.out.println(buf.getName() + " беги на медосмотр");
            }
        }
        item = 0;
    }

    @Override
    public void goToMeasuringHeight() {
        while (this.hasNext()) {
            Student buf = this.next();
            if (buf.getHeight() == 0) {
                System.out.println(buf.getName() + " пора измерять рост");
                measuringHeight(buf);
                System.out.println(buf.getName() + " измерил рост");
            }
        }
        item = 0;
        addToGrowthAccountingBook();
    }

    @Override
    public void measuringHeight(Student student) {
        student.setHeight((int) (Math.random() * (199 - 168) + 168));
    }

    @Override
    public void addToGrowthAccountingBook() {
        this.students.sort(new ComparatorHeight());
    }


    @Override
    public boolean hasNext() {
        return item < students.size();
    }

    @Override
    public Student next() {
        return students.get(item++);
    }
}
