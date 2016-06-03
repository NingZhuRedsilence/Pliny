/**
 * Created by Matt on 5/31/2016.
 */

package edu.rice.cs.lib;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class EventController<T> implements Event<T>
{
    private final List<Consumer<T>> _listeners = new LinkedList<>();

    @Override
    public void addListener(Consumer<T> listener)
    {
        _listeners.add(listener);
    }

    public void fireEvent(T message)
    {
        for(Consumer<T> listener : _listeners)
            listener.accept(message);
    }
}
