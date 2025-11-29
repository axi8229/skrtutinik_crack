package ru.yoomoney.sdk.two_fa.api.method;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApiType;

/* compiled from: ListAuthSessionApiRequest.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/method/ListAuthSessionApiRequest;", "", "sessionTypes", "", "Lru/yoomoney/sdk/two_fa/api/model/ActiveSessionApiType;", "(Ljava/util/List;)V", "getSessionTypes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListAuthSessionApiRequest {
    public static final int $stable = 8;
    private final List<ActiveSessionApiType> sessionTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListAuthSessionApiRequest copy$default(ListAuthSessionApiRequest listAuthSessionApiRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listAuthSessionApiRequest.sessionTypes;
        }
        return listAuthSessionApiRequest.copy(list);
    }

    public final List<ActiveSessionApiType> component1() {
        return this.sessionTypes;
    }

    public final ListAuthSessionApiRequest copy(@JsonProperty("sessionTypes") List<? extends ActiveSessionApiType> sessionTypes) {
        Intrinsics.checkNotNullParameter(sessionTypes, "sessionTypes");
        return new ListAuthSessionApiRequest(sessionTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ListAuthSessionApiRequest) && Intrinsics.areEqual(this.sessionTypes, ((ListAuthSessionApiRequest) other).sessionTypes);
    }

    public int hashCode() {
        return this.sessionTypes.hashCode();
    }

    public String toString() {
        return "ListAuthSessionApiRequest(sessionTypes=" + this.sessionTypes + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListAuthSessionApiRequest(@JsonProperty("sessionTypes") List<? extends ActiveSessionApiType> sessionTypes) {
        Intrinsics.checkNotNullParameter(sessionTypes, "sessionTypes");
        this.sessionTypes = sessionTypes;
    }

    public final List<ActiveSessionApiType> getSessionTypes() {
        return this.sessionTypes;
    }
}
