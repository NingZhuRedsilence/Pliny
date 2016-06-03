package edu.rice.cs.todo;

import edu.rice.cs.todo.controllers.ToDoAppController;
import edu.rice.cs.todo.models.TaskRepository;
import edu.rice.cs.todo.models.TaskRepositoryInMemory;

import javax.swing.*;

public class ToDoApp
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                TaskRepository repos = new TaskRepositoryInMemory();
                new ToDoAppController(repos).start();
            }
        });


    }
}
