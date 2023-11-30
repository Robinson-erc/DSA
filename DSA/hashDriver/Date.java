package hashDriver;

import java.util.Objects;

public class Date {

    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Date) {
            Date date = (Date) obj;
            return day == date.day && month == date.month && year == date.year;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day, year);
    }
    @Override
    public String toString() {
        return "[" + month + "/" + day + "/" + year + "]";
    }

}