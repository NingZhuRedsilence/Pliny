package edu.rice.cs.todo.views;

import edu.rice.cs.todo.view_models.TaskListViewModel;

import javax.swing.*;

/**
 * Created by Matt on 5/31/2016.
 */
public class ListTasksView extends JPanel
{
    JLabel _tasksLabel = new JLabel();

    public ListTasksView(TaskListViewModel vm)
    {
        String list = String.join("<br>", vm.getTasks());
        _tasksLabel.setText("<html>" + list + "</html>");

        super.add(_tasksLabel);
    }
}
