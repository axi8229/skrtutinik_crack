package androidx.paging;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* compiled from: PagingSource.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\f\u0010\u000bJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¦@¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Landroidx/paging/PagingSource;", "", "Key", "Value", "<init>", "()V", "", "invalidate", "Lkotlin/Function0;", "onInvalidatedCallback", "registerInvalidatedCallback", "(Lkotlin/jvm/functions/Function0;)V", "unregisterInvalidatedCallback", "Landroidx/paging/PagingSource$LoadParams;", "params", "Landroidx/paging/PagingSource$LoadResult;", "load", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PagingState;", "state", "getRefreshKey", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "Landroidx/paging/InvalidateCallbackTracker;", "invalidateCallbackTracker", "Landroidx/paging/InvalidateCallbackTracker;", "", "getJumpingSupported", "()Z", "jumpingSupported", "getKeyReuseSupported", "keyReuseSupported", "LoadParams", "LoadResult", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagingSource<Key, Value> {
    private final InvalidateCallbackTracker<Function0<Unit>> invalidateCallbackTracker = new InvalidateCallbackTracker<>(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.paging.PagingSource$invalidateCallbackTracker$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
            invoke2((Function0<Unit>) function0);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function0<Unit> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.invoke();
        }
    }, null, 2, 0 == true ? 1 : 0);

    public boolean getJumpingSupported() {
        return false;
    }

    public boolean getKeyReuseSupported() {
        return false;
    }

    public abstract Key getRefreshKey(PagingState<Key, Value> state);

    public abstract Object load(LoadParams<Key> loadParams, Continuation<? super LoadResult<Key, Value>> continuation);

    /* compiled from: PagingSource.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0012*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0004\u0013\u0012\u0014\u0015B\u0019\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00018\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0003\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Landroidx/paging/PagingSource$LoadParams;", "", "Key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(IZ)V", "I", "getLoadSize", "()I", "Z", "getPlaceholdersEnabled", "()Z", "getKey", "()Ljava/lang/Object;", "key", "Companion", "Append", "Prepend", "Refresh", "Landroidx/paging/PagingSource$LoadParams$Append;", "Landroidx/paging/PagingSource$LoadParams$Prepend;", "Landroidx/paging/PagingSource$LoadParams$Refresh;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadParams<Key> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int loadSize;
        private final boolean placeholdersEnabled;

        public /* synthetic */ LoadParams(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z);
        }

        public abstract Key getKey();

        private LoadParams(int i, boolean z) {
            this.loadSize = i;
            this.placeholdersEnabled = z;
        }

        public final int getLoadSize() {
            return this.loadSize;
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Refresh;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Refresh<Key> extends LoadParams<Key> {
            private final Key key;

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }

            public Refresh(Key key, int i, boolean z) {
                super(i, z, null);
                this.key = key;
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Append;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Append<Key> extends LoadParams<Key> {
            private final Key key;

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Append(Key key, int i, boolean z) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.key = key;
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Prepend;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Prepend<Key> extends LoadParams<Key> {
            private final Key key;

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Prepend(Key key, int i, boolean z) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.key = key;
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0003\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Companion;", "", "()V", "create", "Landroidx/paging/PagingSource$LoadParams;", "Key", "loadType", "Landroidx/paging/LoadType;", "key", "loadSize", "", "placeholdersEnabled", "", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZ)Landroidx/paging/PagingSource$LoadParams;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {

            /* compiled from: PagingSource.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LoadType.values().length];
                    try {
                        iArr[LoadType.REFRESH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LoadType.PREPEND.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[LoadType.APPEND.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final <Key> LoadParams<Key> create(LoadType loadType, Key key, int loadSize, boolean placeholdersEnabled) {
                Intrinsics.checkNotNullParameter(loadType, "loadType");
                int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
                if (i == 1) {
                    return new Refresh(key, loadSize, placeholdersEnabled);
                }
                if (i == 2) {
                    if (key != null) {
                        return new Prepend(key, loadSize, placeholdersEnabled);
                    }
                    throw new IllegalArgumentException("key cannot be null for prepend");
                }
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (key != null) {
                    return new Append(key, loadSize, placeholdersEnabled);
                }
                throw new IllegalArgumentException("key cannot be null for append");
            }
        }
    }

    /* compiled from: PagingSource.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/paging/PagingSource$LoadResult;", "", "Key", "Value", "<init>", "()V", "Error", "Page", "Landroidx/paging/PagingSource$LoadResult$Error;", "Landroidx/paging/PagingSource$LoadResult$Page;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadResult<Key, Value> {
        public /* synthetic */ LoadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private LoadResult() {
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Error;", "", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult;", "", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Error<Key, Value> extends LoadResult<Key, Value> {
            private final Throwable throwable;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.throwable, ((Error) other).throwable);
            }

            public int hashCode() {
                return this.throwable.hashCode();
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable throwable) {
                super(null);
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.throwable = throwable;
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Error(\n                    |   throwable: " + this.throwable + "\n                    |) ", null, 1, null);
            }
        }

        /* compiled from: PagingSource.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 &*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00042\b\u0012\u0004\u0012\u00028\u00050\u0005:\u0001&B=\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00050\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0004\u0012\b\b\u0003\u0010\u000b\u001a\u00020\n\u0012\b\b\u0003\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eB+\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00050\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0004¢\u0006\u0004\b\r\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u0010H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00050\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00018\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00018\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b\"\u0010!R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010\u0017R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b%\u0010\u0017¨\u0006'"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page;", "", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult;", "", "", RemoteMessageConst.DATA, "prevKey", "nextKey", "", "itemsBefore", "itemsAfter", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "", "iterator", "()Ljava/util/Iterator;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getData", "()Ljava/util/List;", "Ljava/lang/Object;", "getPrevKey", "()Ljava/lang/Object;", "getNextKey", "I", "getItemsBefore", "getItemsAfter", "Companion", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Page<Key, Value> extends LoadResult<Key, Value> implements Iterable<Value>, KMappedMarker {
            private static final Page EMPTY = new Page(CollectionsKt.emptyList(), null, null, 0, 0);
            private final List<Value> data;
            private final int itemsAfter;
            private final int itemsBefore;
            private final Key nextKey;
            private final Key prevKey;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Page)) {
                    return false;
                }
                Page page = (Page) other;
                return Intrinsics.areEqual(this.data, page.data) && Intrinsics.areEqual(this.prevKey, page.prevKey) && Intrinsics.areEqual(this.nextKey, page.nextKey) && this.itemsBefore == page.itemsBefore && this.itemsAfter == page.itemsAfter;
            }

            public int hashCode() {
                int iHashCode = this.data.hashCode() * 31;
                Key key = this.prevKey;
                int iHashCode2 = (iHashCode + (key == null ? 0 : key.hashCode())) * 31;
                Key key2 = this.nextKey;
                return ((((iHashCode2 + (key2 != null ? key2.hashCode() : 0)) * 31) + Integer.hashCode(this.itemsBefore)) * 31) + Integer.hashCode(this.itemsAfter);
            }

            public final List<Value> getData() {
                return this.data;
            }

            public final Key getPrevKey() {
                return this.prevKey;
            }

            public final Key getNextKey() {
                return this.nextKey;
            }

            public final int getItemsBefore() {
                return this.itemsBefore;
            }

            public final int getItemsAfter() {
                return this.itemsAfter;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Page(List<? extends Value> data, Key key, Key key2, int i, int i2) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
                this.prevKey = key;
                this.nextKey = key2;
                this.itemsBefore = i;
                this.itemsAfter = i2;
                if (i != Integer.MIN_VALUE && i < 0) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative");
                }
                if (i2 != Integer.MIN_VALUE && i2 < 0) {
                    throw new IllegalArgumentException("itemsAfter cannot be negative");
                }
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Page(List<? extends Value> data, Key key, Key key2) {
                this(data, key, key2, Integer.MIN_VALUE, Integer.MIN_VALUE);
                Intrinsics.checkNotNullParameter(data, "data");
            }

            @Override // java.lang.Iterable
            public Iterator<Value> iterator() {
                return this.data.listIterator();
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Page(\n                    |   data size: " + this.data.size() + "\n                    |   first Item: " + CollectionsKt.firstOrNull((List) this.data) + "\n                    |   last Item: " + CollectionsKt.lastOrNull((List) this.data) + "\n                    |   nextKey: " + this.nextKey + "\n                    |   prevKey: " + this.prevKey + "\n                    |   itemsBefore: " + this.itemsBefore + "\n                    |   itemsAfter: " + this.itemsAfter + "\n                    |) ", null, 1, null);
            }
        }
    }

    public final void invalidate() {
        if (this.invalidateCallbackTracker.invalidate$paging_common_release()) {
            PagingLogger pagingLogger = PagingLogger.INSTANCE;
            if (pagingLogger.isLoggable(3)) {
                pagingLogger.log(3, "Invalidated PagingSource " + this, null);
            }
        }
    }

    public final void registerInvalidatedCallback(Function0<Unit> onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.registerInvalidatedCallback$paging_common_release(onInvalidatedCallback);
    }

    public final void unregisterInvalidatedCallback(Function0<Unit> onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.unregisterInvalidatedCallback$paging_common_release(onInvalidatedCallback);
    }
}
