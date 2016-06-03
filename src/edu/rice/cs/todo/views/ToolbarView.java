package edu.rice.cs.todo.views;


import edu.rice.cs.lib.Event;
import edu.rice.cs.lib.EventController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarView extends JPanel
{
    JButton _listButton = new JButton("List");

    JButton _totalsButton = new JButton("Totals");

    private final EventController<Void> _onListClickedController = new EventController<>();

    public final Event<Void> OnListClicked = _onListClickedController;

    private final EventController<Void> _onTotalsClickedController = new EventController<>();

    public final Event<Void> OnTotalsClicked = _onTotalsClickedController;

    public ToolbarView()
    {
        super.add(_listButton);
        super.add(_totalsButton);
        //doesn't do much?
        _listButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _onListClickedController.fireEvent(null);
            }
        });

        _totalsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _onTotalsClickedController.fireEvent(null);
            }
        });
    }
}
