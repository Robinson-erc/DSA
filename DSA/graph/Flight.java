package graph;

public class Flight {
    Airport origin, destination;
    public Flight(Airport o, Airport d) {
        this.origin = o;
        this.destination = d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Flight) {
            Flight other = (Flight) obj;
            return this.origin.equals(other.origin) && this.destination.equals(other.destination);
        }
        return false;
    }

    @Override
    public String toString() {
        return origin + " -> " + destination;
    }
}
