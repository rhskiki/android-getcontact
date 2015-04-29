package com.rhskiki.getcontact.library;

import java.util.List;

/**
 * TODO comments
 */
public abstract class BaseGetContact<T> {
    public abstract List<String> getSimple(int contactId);
    public abstract List<T> getDetails(int contactId);
}
