package com.sputnik.domain.common;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.domain.entities.empty.DomainEmpty;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Resource.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0019*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0005\u0019\u001a\u001b\u001c\u001dB5\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ&\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0000\"\u0004\b\u0001\u0010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00160\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0003\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/sputnik/domain/common/Resource;", "T", "", UpdateKey.STATUS, "Lcom/sputnik/domain/common/Resource$Status;", RemoteMessageConst.DATA, "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorMsg", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/Object;Ljava/lang/Exception;Lcom/sputnik/domain/entities/empty/DomainEmpty;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getError", "()Ljava/lang/Exception;", "getErrorMsg", "()Lcom/sputnik/domain/entities/empty/DomainEmpty;", "getStatus", "()Lcom/sputnik/domain/common/Resource$Status;", "map", "R", "mapper", "Lkotlin/Function1;", "Companion", "Error", "Loading", "Status", "Success", "Lcom/sputnik/domain/common/Resource$Error;", "Lcom/sputnik/domain/common/Resource$Loading;", "Lcom/sputnik/domain/common/Resource$Success;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Resource<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T data;
    private final Exception error;
    private final DomainEmpty errorMsg;
    private final Status status;

    /* compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/common/Resource$Status;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "LOADING", "NONE", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Status {
        SUCCESS,
        ERROR,
        LOADING,
        NONE
    }

    public /* synthetic */ Resource(Status status, Object obj, Exception exc, DomainEmpty domainEmpty, DefaultConstructorMarker defaultConstructorMarker) {
        this(status, obj, exc, domainEmpty);
    }

    private Resource(Status status, T t, Exception exc, DomainEmpty domainEmpty) {
        this.status = status;
        this.data = t;
        this.error = exc;
        this.errorMsg = domainEmpty;
    }

    public /* synthetic */ Resource(Status status, Object obj, Exception exc, DomainEmpty domainEmpty, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(status, obj, exc, (i & 8) != 0 ? null : domainEmpty, null);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final T getData() {
        return this.data;
    }

    public final Exception getError() {
        return this.error;
    }

    public final DomainEmpty getErrorMsg() {
        return this.errorMsg;
    }

    /* compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sputnik/domain/common/Resource$Loading;", "T", "Lcom/sputnik/domain/common/Resource;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading<T> extends Resource<T> {
        public Loading() {
            super(Status.LOADING, null, null, null, 8, null);
        }
    }

    /* compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/sputnik/domain/common/Resource$Error;", "T", "Lcom/sputnik/domain/common/Resource;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorMsg", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "(Ljava/lang/Exception;Lcom/sputnik/domain/entities/empty/DomainEmpty;)V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Error<T> extends Resource<T> {
        public Error(Exception exc, DomainEmpty domainEmpty) {
            super(Status.ERROR, null, exc, domainEmpty, null);
        }
    }

    /* compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/domain/common/Resource$Success;", "T", "Lcom/sputnik/domain/common/Resource;", RemoteMessageConst.DATA, "(Ljava/lang/Object;)V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Success<T> extends Resource<T> {
        public Success(T t) {
            super(Status.SUCCESS, t, null, null, 8, null);
        }
    }

    /* compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u000e\u0010\u0003\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\f\u001a\u0002H\u0005¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/sputnik/domain/common/Resource$Companion;", "", "()V", "error", "Lcom/sputnik/domain/common/Resource;", "T", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorMsg", "Lcom/sputnik/domain/entities/empty/DomainEmpty;", "loading", "success", RemoteMessageConst.DATA, "(Ljava/lang/Object;)Lcom/sputnik/domain/common/Resource;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Resource<T> success(T data) {
            return new Success(data);
        }

        public final <T> Resource<T> error(Exception error, DomainEmpty errorMsg) {
            return new Error(error, errorMsg);
        }

        public final <T> Resource<T> loading() {
            return new Loading();
        }
    }

    public final <R> Resource<R> map(Function1<? super T, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        if (this instanceof Success) {
            Companion companion = INSTANCE;
            T t = this.data;
            Intrinsics.checkNotNull(t);
            return companion.success(mapper.invoke(t));
        }
        if (this instanceof Error) {
            return INSTANCE.error(this.error, this.errorMsg);
        }
        if (this instanceof Loading) {
            return INSTANCE.loading();
        }
        throw new NoWhenBranchMatchedException();
    }
}
