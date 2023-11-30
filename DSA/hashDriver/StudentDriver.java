package hashDriver;

import hash.HashTable;

public class StudentDriver {
    public static void main(String[] args) {
        HashTable<Student> students = new HashTable<>();
        students.put(new Student("s1", 1, 3.5, "s1@gmail.com"));
        students.put(new Student("s2", 2, 2.5, "s2@gmail.com"));
        students.put(new Student("s3", 3, 4.5, "s3@gmail.com"));
        students.put(new Student("s4", 4, 3.5, "s4@gmail.com"));
        students.put(new Student("s5", 5, 2.5, "s5@gmail.com"));
        students.put(new Student("s6", 6, 4.5, "s6@gmail.com"));
        students.put(new Student("s7", 7, 3.5, "s7@gmail.com"));
        students.put(new Student("s8", 8, 2.5, "s8@gmail.com"));
        students.put(new Student("s9", 9, 4.5, "s9@gmail.com"));
        students.put(new Student("s10", 10, 3.5, "s10@gmail.com"));
        System.out.println(students);

        //check for collisions
        for (int i = 0; i < students.size()-1 ; i++) {
            int hash = students.getList(i).hashCode();
            for (int j = students.size()-1 ; j > i; j--) {
                int hash2 = students.getList(j).hashCode();
                if (hash == hash2) {
                    System.out.println("Collision detected");
                }
            }
        }


    }
}
