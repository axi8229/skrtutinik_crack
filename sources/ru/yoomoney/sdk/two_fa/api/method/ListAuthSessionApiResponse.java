package ru.yoomoney.sdk.two_fa.api.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApi;

/* compiled from: ListAuthSessionApiResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/method/ListAuthSessionApiResponse;", "", "activeSessions", "", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApi;", "(Ljava/util/List;)V", "getActiveSessions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListAuthSessionApiResponse {
    public static final int $stable = 8;
    private final List<ActiveSessionApi> activeSessions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListAuthSessionApiResponse copy$default(ListAuthSessionApiResponse listAuthSessionApiResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listAuthSessionApiResponse.activeSessions;
        }
        return listAuthSessionApiResponse.copy(list);
    }

    public final List<ActiveSessionApi> component1() {
        return this.activeSessions;
    }

    public final ListAuthSessionApiResponse copy(@JsonProperty("activeSessions") List<? extends ActiveSessionApi> activeSessions) {
        Intrinsics.checkNotNullParameter(activeSessions, "activeSessions");
        return new ListAuthSessionApiResponse(activeSessions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ListAuthSessionApiResponse) && Intrinsics.areEqual(this.activeSessions, ((ListAuthSessionApiResponse) other).activeSessions);
    }

    public int hashCode() {
        return this.activeSessions.hashCode();
    }

    public String toString() {
        return "ListAuthSessionApiResponse(activeSessions=" + this.activeSessions + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListAuthSessionApiResponse(@JsonProperty("activeSessions") List<? extends ActiveSessionApi> activeSessions) {
        Intrinsics.checkNotNullParameter(activeSessions, "activeSessions");
        this.activeSessions = activeSessions;
    }

    public final List<ActiveSessionApi> getActiveSessions() {
        return this.activeSessions;
    }
}
