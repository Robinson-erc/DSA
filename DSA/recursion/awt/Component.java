package recursion.awt;
import list.*;
/**
 * Write a description of class Component here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Component
{
    String name;

    public Component(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    /** @return a List of all the Widgets making up this Component
     *  (and all Widgets in its Containers) in any order */
    public abstract List<Widget> getAllWidgets();
}
