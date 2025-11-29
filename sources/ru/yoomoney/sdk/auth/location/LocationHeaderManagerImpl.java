package ru.yoomoney.sdk.auth.location;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/location/LocationHeaderManagerImpl;", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "()V", "locationHeader", "", "getLocationHeader", "updateLocationHeader", "", "header", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocationHeaderManagerImpl implements LocationHeaderManager {
    private static final String EMPTY_VALUE = "";
    private String locationHeader = "";

    @Override // ru.yoomoney.sdk.auth.location.LocationHeaderManager
    public String getLocationHeader() {
        return this.locationHeader;
    }

    @Override // ru.yoomoney.sdk.auth.location.LocationHeaderManager
    public void updateLocationHeader(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        this.locationHeader = header;
    }
}
