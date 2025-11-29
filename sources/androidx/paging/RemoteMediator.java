package androidx.paging;

import kotlin.Metadata;

/* compiled from: RemoteMediator.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Landroidx/paging/RemoteMediator;", "", "Key", "Value", "InitializeAction", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RemoteMediator<Key, Value> {

    /* compiled from: RemoteMediator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/paging/RemoteMediator$InitializeAction;", "", "(Ljava/lang/String;I)V", "LAUNCH_INITIAL_REFRESH", "SKIP_INITIAL_REFRESH", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum InitializeAction {
        LAUNCH_INITIAL_REFRESH,
        SKIP_INITIAL_REFRESH
    }
}
