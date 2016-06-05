package edu.rice.cs.todo.view_models;

import edu.rice.cs.lib.Event;
import edu.rice.cs.lib.EventController;
import edu.rice.cs.todo.models.Task;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matt on 5/31/2016.
 */
public class TaskListViewModel
{
    private final List<String> _tasks = new LinkedList<>();
    private final EventController<String> _onChange = new EventController<>();
    public final Event<String> OnChange = _onChange;

    public TaskListViewModel(Iterable<String> tasks)
    {
        for(String task : tasks)
            _tasks.add(task);
    }

    public TaskListViewModel(){
    }

    public List<String> getTasks()
    {
        return Collections.unmodifiableList(_tasks);
    }

    public boolean addTask(String description) {
        if (_tasks.contains(description)){
            return false;
        }
        //fire an event in the views when change happens
        _onChange.fireEvent(description);

        return _tasks.add(description);
    }

}
