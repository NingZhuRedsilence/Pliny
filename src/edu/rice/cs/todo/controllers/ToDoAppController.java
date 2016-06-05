package edu.rice.cs.todo.controllers;

import edu.rice.cs.todo.models.Task;
import edu.rice.cs.todo.models.TaskRepository;
import edu.rice.cs.todo.view_models.TaskListViewModel;
import edu.rice.cs.todo.views.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matt on 5/31/2016.
 */
public class ToDoAppController
{
    private final TotalTasksView _totalsTaskView;

    private final ListTasksView _listTasksView;

    private final MasterView _masterView;

    private final AddTaskView _addTaskView;

    private final TaskRepository _repos;

    private final TaskListViewModel _vm;

    public ToDoAppController(TaskRepository repos)
    {
        _repos = repos;
        /**
         * Translate model to view model.
         */
        _vm = translateToVM(repos);

        /**
         * Create views.
         */
        ToolbarView toolbarView = new ToolbarView();
        _addTaskView = new AddTaskView();
        _totalsTaskView = new TotalTasksView(_vm);
        _listTasksView = new ListTasksView(_vm);
        _masterView = new MasterView(toolbarView, _listTasksView, _addTaskView);

        /**
         * Wire-up views to respond to user actions. Observer-observable
         */
        toolbarView.OnViewListRequest.addListener(this::handleListButtonClicked);
        toolbarView.OnViewTotalRequest.addListener(this::handleTotalsButtonClicked);
        // why :: ?
        _addTaskView.OnAddTaskRequest.addListener(this::handleAddTaskRequest);
    }

    public void start()
    {
        _masterView.showView();
    }
    //Void is void, has only once instance -- null
    private void handleAddTaskRequest(String message)
    {
        //System.out.println("Controller got message from View: " + message );
        addTask(message);
    }

    private void handleListButtonClicked(Void forget)
    {
        _masterView.setDisplayView(_listTasksView);
    }

    private void handleTotalsButtonClicked(Void forget)
    {
        _masterView.setDisplayView(_totalsTaskView);
    }

    private void addTask(String taskDescription) {
        //create a task and add to the domain model
        _repos.addTask(taskDescription);

        //change in dm triggers update of the data-to-vm & vm in controller
        //doesn't need observer-observable pattern 'cos controller itself is doing all the work
        //and don't need to observe itself
        _vm.addTask(taskDescription);

        //update vm triggers update view by observer-observable
        //only implemented in ListTaskView for now
    }

    private TaskListViewModel translateToVM(TaskRepository repos) {
        List<String> taskDescriptions = new LinkedList<>();
        // Should make the list a field in controller or not? Don't think so
        // the data is save in view model
        for (Task task : repos.getTasks())
        {
            if (!task.Completed)
                taskDescriptions.add(task.Description);
        }
        return new TaskListViewModel(taskDescriptions);
    }




}
