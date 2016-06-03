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

    public ToDoAppController(TaskRepository repos)
    {
        /**
         * Translate model to view model.
         */
        TaskListViewModel vm;
        {
            List<String> taskDescriptions = new LinkedList<>();

            for (Task task : repos.getTasks())
            {
                if (!task.Completed)
                    taskDescriptions.add(task.Description);
            }
            vm = new TaskListViewModel(taskDescriptions);
        }


        /**
         * Create views.
         */
        ToolbarView toolbarView = new ToolbarView();
        _addTaskView = new AddTaskView();
        _totalsTaskView = new TotalTasksView(vm);
        _listTasksView = new ListTasksView(vm);
        _masterView = new MasterView(toolbarView, _listTasksView, _addTaskView);

        /**
         * Wire-up views to respond to user actions.
         */
        toolbarView.OnListClicked.addListener(this::handleListButtonClicked);
        toolbarView.OnTotalsClicked.addListener(this::handleTotalsButtonClicked);

        _addTaskView.OnAddTaskBtnClicked.addListener(this::handleAddButtonClicked);
    }

    public void start()
    {
        _masterView.showView();
    }

    private void handleAddButtonClicked(Void forget)
    {
        //this is probably a hack-y implementation. Violates information hiding
        //should have an event hub in AddTaskView for the controller to call?
        System.out.println("Controller got message from View: " + _addTaskView.get_taskName() );
    }

    private void handleListButtonClicked(Void forget)
    {
        _masterView.setDisplayView(_listTasksView);
    }

    private void handleTotalsButtonClicked(Void forget)
    {
        _masterView.setDisplayView(_totalsTaskView);
    }
}
