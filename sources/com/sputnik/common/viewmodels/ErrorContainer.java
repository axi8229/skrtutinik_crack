package com.sputnik.common.viewmodels;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.empty.DomainEmpty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallCodeViewModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/sputnik/common/viewmodels/ErrorContainer;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "parsedError", "<init>", "(Ljava/lang/Exception;Lcom/sputnik/domain/entities/empty/DomainEmpty;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Exception;", "getError", "()Ljava/lang/Exception;", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "getParsedError", "()Lcom/sputnik/domain/entities/empty/DomainEmpty;", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ErrorContainer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Exception error;
    private final DomainEmpty parsedError;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorContainer)) {
            return false;
        }
        ErrorContainer errorContainer = (ErrorContainer) other;
        return Intrinsics.areEqual(this.error, errorContainer.error) && Intrinsics.areEqual(this.parsedError, errorContainer.parsedError);
    }

    public int hashCode() {
        Exception exc = this.error;
        int iHashCode = (exc == null ? 0 : exc.hashCode()) * 31;
        DomainEmpty domainEmpty = this.parsedError;
        return iHashCode + (domainEmpty != null ? domainEmpty.hashCode() : 0);
    }

    public String toString() {
        return "ErrorContainer(error=" + this.error + ", parsedError=" + this.parsedError + ")";
    }

    public ErrorContainer(Exception exc, DomainEmpty domainEmpty) {
        this.error = exc;
        this.parsedError = domainEmpty;
    }

    public final Exception getError() {
        return this.error;
    }

    public final DomainEmpty getParsedError() {
        return this.parsedError;
    }

    /* compiled from: CallCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/viewmodels/ErrorContainer$Companion;", "", "()V", "toErrorContainer", "Lcom/sputnik/common/viewmodels/ErrorContainer;", RemoteMessageConst.DATA, "Lcom/sputnik/common/viewmodels/CallCodeViewState;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorContainer toErrorContainer(CallCodeViewState data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new ErrorContainer(data.getError(), data.getParsedError());
        }
    }
}
