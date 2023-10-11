package recursion.awt;
import list.*;

/**
 * Creating a Graphical User Interface.
 *
 * @author (sdb)
 * @version (2020)
 */
public class GUI
{    
      public static void main(String [] args)
    {   Container actionPane = new Container ("Actions");
        actionPane.addComponent(new Widget("GoButton", WidgetType.BUTTON));
        actionPane.addComponent(new Widget("Go", WidgetType.LABEL));
        actionPane.addComponent(new Widget("OK", WidgetType.CHECKBOX));
        Container errorPane = new Container ("Error Panel");
        errorPane.addComponent (new Widget ("Abort",WidgetType.LABEL));
        errorPane.addComponent (new Widget("Exception", WidgetType.LABEL));
        Container diagnosticPane = new Container("Diagnostics");
        diagnosticPane.addComponent (new Widget("RunTime Exception", WidgetType.LABEL));
        errorPane.addComponent (diagnosticPane);
        Container inputPane = new Container ("Input");
        inputPane.addComponent (new Widget ("Provide Input", WidgetType.BUTTON));
        inputPane.addComponent (new Widget ("Finished", WidgetType.CHECKBOX));
              
        Container contentPane = new Container ("Content Pane");
        contentPane.addComponent (actionPane);
        contentPane.addComponent (errorPane);
        contentPane.addComponent (inputPane);
        contentPane.addComponent (new Widget ("Close",WidgetType.BUTTON));
      
        List<Widget> all = contentPane.getAllWidgets();
        System.out.println (all.size() + " widgets in the GUI: " + all);
        // System.out.println ("\nContainer details: \n");
        // contentPane.show();
    }
}
