package recursion.awt;
import list.*;

/**
 * Write a description of class Widget here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Widget extends Component
{
    public WidgetType type;

    public Widget(String name, WidgetType type){
        super(name);
        this.type=type;
    }
    public WidgetType getType(){
        return type;
    }
    public List<Widget> getAllWidgets(){
        List<Widget> result= new ArrayList();
        result.add(this);
        return result;
    }
    public String toString(){
        return type +" named "+ name;
    }
}
