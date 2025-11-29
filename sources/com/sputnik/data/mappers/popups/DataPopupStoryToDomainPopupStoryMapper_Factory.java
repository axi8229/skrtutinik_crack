package com.sputnik.data.mappers.popups;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPopupStoryToDomainPopupStoryMapper_Factory implements Factory<DataPopupStoryToDomainPopupStoryMapper> {

    private static final class InstanceHolder {
        private static final DataPopupStoryToDomainPopupStoryMapper_Factory INSTANCE = new DataPopupStoryToDomainPopupStoryMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPopupStoryToDomainPopupStoryMapper get() {
        return newInstance();
    }

    public static DataPopupStoryToDomainPopupStoryMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPopupStoryToDomainPopupStoryMapper newInstance() {
        return new DataPopupStoryToDomainPopupStoryMapper();
    }
}
