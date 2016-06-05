package edu.rice.cs.todo.models;

import java.util.Collection;

public interface TaskRepository
{
    Collection<Task> getTasks();
    boolean addTask(String description);
    // return Collection, void or return true (like some add/remove method in Java interface)?
    // return value is to give some information about the data structure that are a result of this method
    // which isn't known to the user before this change. For example, in add/remove, returning boolean tells
    // whether the operation was successful, add may not happen if there is duplicate in the DS already,
    // remove may not happen when the element to remove is not in the DS
    // Or, I can return the size of the DS
}
