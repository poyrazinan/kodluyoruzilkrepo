package dev.patika.siniflar;

public class Main {

    public static void main(String[] args)
    {

        Course mat = new Course("Matematik", "MAT101", "MAT", 80);
        Course fizik = new Course("Fizik", "FZK101", "FZK", 60);
        Course kimya = new Course("Kimya", "KMY101", "KMY", 50);

        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
        Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "FZK");
        Teacher t3 = new Teacher("Ali Veli", "90550000002", "KMY");

        mat.addTeacher(t1);
        fizik.addTeacher(t2);
        kimya.addTeacher(t3);

        Student s1 = new Student("İnek Şaban", 4, "140144015", mat, fizik, kimya);
        s1.addBulkNote(50,20,40, "exam");
        s1.addBulkNote(100,100,100, "performance");
        s1.isPass();

        Student s2 = new Student("Güdük Necmi", 4, "2211133", mat, fizik, kimya);
        s2.addBulkNote(100,50,40, "exam");
        s1.addBulkNote(100,50,40, "performance");
        s2.isPass();

        Student s3 = new Student("Hayta İsmail", 4, "221121312", mat, fizik, kimya);
        s3.addBulkNote(50,20,40, "exam");
        s1.addBulkNote(50,20,40, "performance");
        s3.isPass();

    }
}
