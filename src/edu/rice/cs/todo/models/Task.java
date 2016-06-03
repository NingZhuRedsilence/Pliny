package edu.rice.cs.todo.models;

/**
 * Created by Matt on 5/31/2016.
 */
public class Task
{
    public final String Description;

    public final boolean Completed;

    public Task(String description, boolean completed)
    {
        Description = description;
        Completed = completed;
    }
}
