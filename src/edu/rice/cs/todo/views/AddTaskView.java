package edu.rice.cs.todo.views;

import edu.rice.cs.lib.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nz9 on 6/2/2016.
 */
public class AddTaskView extends JPanel {
    //textField for user input
    //button for user behavior
    private JTextField _inputBox = new JTextField();
    private JButton _btnAddTask = new JButton();

    //changed type parameter from Void to String to solve type conflict
    private final EventController<String> _onAddTaskRequest = new EventController<>();
    public final Event<String> OnAddTaskRequest = _onAddTaskRequest;

    public String get_taskName() {
        return _taskName;
    }

    public void set_taskName(String _taskName) {
        this._taskName = _taskName;
    }

    private String _taskName;

    public AddTaskView() {
        super.add(_inputBox);
        super.add(_btnAddTask);

        _inputBox.setText("Enter a task here");
        _btnAddTask.setText("Add task");

        _btnAddTask.addActionListener(new ActionListener()
        {
            //can't resolve _taskName here?
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _taskName = _inputBox.getText();
                _onAddTaskRequest.fireEvent(_taskName);
            }
        });
    }


}
