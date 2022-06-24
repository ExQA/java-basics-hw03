import java.util.ArrayList;

public class Student {

  private static final ArrayList<Student> allStudents = new ArrayList<>();

  public static void main(String[] args) {

    Student volodia = new Student();
    volodia.setName("Volodia");
    volodia.setRating(5);

    Student dima = new Student();
    dima.setName("Dima");
    dima.setRating(1);

    Student anna = new Student();
    anna.setName("Anna");
    anna.setRating(6);

  }


 // состояние (поля класса)
  private int rating;
  private String name;
  // you MUST initialize "final" field in constructors, and you CAN'T change it after
  // private final String name;

  public Student(String name) {     // and constructor with parameters!
    // initialize name
    this.name = name;
    allStudents.add(this);  //this это обращение обькта, явная ссылка самого на себя
  }

  public Student() { // дефолтный конструктор без параметров  !default constructor
    allStudents.add(this);
  }

  public static double getAvgRating() {
    int numberOfStudents = allStudents.size();

    if ( numberOfStudents == 0 ) {
      return 0;
    }

    double totalRating = 0;
    for (int index = 0; index < numberOfStudents; index++) {
      int stRating = allStudents.get(index).getRating();
      totalRating += stRating;
    }
    return totalRating / numberOfStudents;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) { // обьявление функции. Возвращает String
    this.name = name;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    // initialize rating;
    this.rating = rating;

  }

  public boolean betterStudent(Student student) {
      // return the result of comparing this.student's rating with the student's rating
    if (rating > student.getRating()) {
      return true;
    } else {
      return false;
    }
  }

  public void changeRating(int rating) {
    setRating(rating);
  }

  public static void removeStudent(Student student) {
    //  remove student
    allStudents.remove(student);
  }


  @Override
  public String toString() {  //toString - to output information about student
    return "Student{" +
            "rating=" + rating +
            ", name='" + name + '\'' +
            '}';
  }
}
