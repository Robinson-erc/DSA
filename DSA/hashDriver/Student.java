package hashDriver;

public class Student {
    String name;
    int id;
    double gpa;
    String email;
    public Student(String name, int id, double gpa, String email){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public double getGpa(){
        return gpa;
    }
    public String getEmail(){
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return name + " " + id + " " + gpa + " " + email;
    }
    /** @return true iff obj is a Student and is equal to this Student */
    public boolean equals (Object obj)
    {      if (! (obj instanceof Student))
        return false;
        Student other = (Student) obj;     // Cast the parameter as Student
        return name.equals(other.name) && id == other.id && email.equals (other.email);
    }
    public int hashCode(){
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + id;
        result = 31 * result + email.hashCode();
        return result;
    }
}
