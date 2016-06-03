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
    private final EventController<Void> _onAddTaskBtnClick = new EventController<>();
    public final Event<Void> OnAddTaskBtnClicked = _onAddTaskBtnClick;

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
                _onAddTaskBtnClick.fireEvent(null);
            }
        });
    }


    //method to add a task
    private void get(String _taskName)
    {
        //call controller or have an adapter to controller?

    }
}

/*
    //textField for user input
    //button for user behavior
    _inputBox.setText("Enter a task here");
    _btnAddTask.setText("Add task");
    _btnAddTask.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String taskName = _inputBox.getText();
            //send data to Model or viewModel?
            //to Controller --> single point of control
            addTask(taskName);
            //viewModel + view make a observer-observable pattern
            //http://www.vogella.com/tutorials/DesignPatternObserver/article.html
        }
    }*/