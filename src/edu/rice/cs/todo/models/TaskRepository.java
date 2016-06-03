package edu.rice.cs.todo.models;

import java.util.Collection;

public interface TaskRepository
{
    Collection<Task> getTasks();
}
