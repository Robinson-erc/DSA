package list;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String name;
    private int id;
    
    //constructor
    public Student(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || getClass() != obj.getClass()){
            return false;
        }
        Student student=(Student) obj;
        return id == student.id;
    }
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", id=" + id +
               '}';
    }
}
