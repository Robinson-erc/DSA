package recursion.awt;
import list.*;
/**
 * Write a description of class Container here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Container extends Component

{
    List<Component> components=new ArrayList();

    public Container(String name){
        super(name);


    }

    /** Add the given Component to this Container */
    public void addComponent (Component component){
        components.add(component);
    }

    public List<Widget> getAllWidgets(){
        List<Widget> allWidgets = new ArrayList<>();
        for(int i=0; i<components.size(); i++){
            allWidgets.addAll(components.get(i).getAllWidgets());
        }
        return allWidgets;
    }
}
