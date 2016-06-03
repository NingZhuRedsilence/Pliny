package edu.rice.cs.lib;

import java.util.function.Consumer;

/**
 * Created by Matt on 5/31/2016.
 */
public interface Event<T>
{
    void addListener(Consumer<T> listener);
}
