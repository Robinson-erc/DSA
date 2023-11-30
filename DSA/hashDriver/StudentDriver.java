package hashDriver;

import hash.HashTable;

import java.util.Random;

public class StudentDriver {
    public static void main(String[] args) {
        HashTable<Student> students = new HashTable<>();
        int random = new Random().nextInt(1000), random2 = new Random().nextInt(1000), random3 = new Random().nextInt(1000);

        Student s1 = new Student("student1", random, 3.5, "s1@gmail.com");
        Student s2 = new Student("student2", random2, 2.5, "s2@gmail.com");
        Student s3 = new Student("student3", random3, 4.5, "s3@gmail.com");

        students.put(s1);
        students.put(s2);
        students.put(s3);

        System.out.println(students);

        System.out.println("HashTable Contains s1: " + students.containsKey(s1));
        System.out.println("HashTable Contains s2: " + students.containsKey(s2));
        System.out.println("HashTable Contains s3: " + students.containsKey(s3));

        //check for collisions
        for (int i = 0; i < students.size()-1 ; i++) {
            int hash = students.getList(i).hashCode();
            for (int j = students.size()-1 ; j > i; j--) {
                int hash2 = students.getList(j).hashCode();
                if (hash == hash2) System.out.println("Collision detected");
            }
        }


    }
}
