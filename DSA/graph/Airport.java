package graph;

public class Airport {
    String name;
    Boolean visited = false; //this airport has been visited?
    public Airport(String name){
        this.name = name;
    }
    public boolean equals(Object obj){
        Airport other = (Airport)obj;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
