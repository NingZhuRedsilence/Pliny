package edu.rice.cs.todo.view_models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matt on 5/31/2016.
 */
public class TaskListViewModel
{
    private final List<String> _tasks = new LinkedList<>();

    public TaskListViewModel(Iterable<String> tasks)
    {
        for(String task : tasks)
            _tasks.add(task);
    }

    public List<String> getTasks()
    {
        return Collections.unmodifiableList(_tasks);
    }
}
