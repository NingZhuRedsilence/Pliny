package edu.rice.cs.todo.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Matt on 5/31/2016.
 */
public class TaskRepositoryInMemory implements TaskRepository
{
    private final Collection<Task> _tasks = new ArrayList<>(Arrays.asList(
            new Task("Feed cat.", false), new Task("Feed dog.", false), new Task("Feed rabbit.", true)));

    @Override
    public Collection<Task> getTasks()
    {
        return Collections.unmodifiableCollection(_tasks);
    }
}
