package com.sputnik.data.mappers.cameras;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataCameraToDomainCameraMapper_Factory implements Factory<DataCameraToDomainCameraMapper> {

    private static final class InstanceHolder {
        private static final DataCameraToDomainCameraMapper_Factory INSTANCE = new DataCameraToDomainCameraMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataCameraToDomainCameraMapper get() {
        return newInstance();
    }

    public static DataCameraToDomainCameraMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataCameraToDomainCameraMapper newInstance() {
        return new DataCameraToDomainCameraMapper();
    }
}
