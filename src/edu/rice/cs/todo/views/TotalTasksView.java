package edu.rice.cs.todo.views;

import edu.rice.cs.todo.view_models.TaskListViewModel;

import javax.swing.*;

/**
 * Created by Matt on 5/31/2016.
 */
public class TotalTasksView extends JPanel
{
    public TotalTasksView(TaskListViewModel vm)
    {
        JLabel totalsLabel = new JLabel();
        totalsLabel.setText(vm.getTasks().size() + " tasks");

        this.add(totalsLabel);
    }

}
