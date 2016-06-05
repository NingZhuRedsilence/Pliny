package edu.rice.cs.todo.views;

import edu.rice.cs.todo.view_models.TaskListViewModel;

import javax.swing.*;

/**
 * Created by Matt on 5/31/2016.
 */
public class ListTasksView extends JPanel
{
    JTextArea _tasksTextArea = new JTextArea();
    TaskListViewModel _vm;
    String changes;
    public ListTasksView(TaskListViewModel vm)
    {
        _vm = vm;
        displayDataFromVM(_vm);
        _vm.OnChange.addListener(this::handleChangeInVM);

    }

    public void update(){

    }

    private void handleChangeInVM(String message)
    {
        //System.out.println("Controller got message from View: " + message );
        _tasksTextArea.append("\n" + message);
    }

    private void displayDataFromVM(TaskListViewModel vm){
        //JTextArea can't interpret html?
        //String list = String.join("<br>", vm.getTasks());
        //_tasksTextArea.setText("<html>" + list + "</html>");
        String list = String.join("\n", vm.getTasks());
        _tasksTextArea.setText( list);
        super.add(_tasksTextArea);


    }
}
