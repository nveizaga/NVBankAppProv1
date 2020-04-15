package org.controller.interfaces;

public interface IInfoProvider<TInfo, TId> {
    TInfo get(TId id);
}
