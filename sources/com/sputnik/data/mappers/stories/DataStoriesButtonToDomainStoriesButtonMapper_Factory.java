package com.sputnik.data.mappers.stories;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataStoriesButtonToDomainStoriesButtonMapper_Factory implements Factory<DataStoriesButtonToDomainStoriesButtonMapper> {

    private static final class InstanceHolder {
        private static final DataStoriesButtonToDomainStoriesButtonMapper_Factory INSTANCE = new DataStoriesButtonToDomainStoriesButtonMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataStoriesButtonToDomainStoriesButtonMapper get() {
        return newInstance();
    }

    public static DataStoriesButtonToDomainStoriesButtonMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataStoriesButtonToDomainStoriesButtonMapper newInstance() {
        return new DataStoriesButtonToDomainStoriesButtonMapper();
    }
}
