package androidx.paging;

import androidx.paging.PageEvent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: PagingData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0016BC\b\u0000\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000b¢\u0006\u0002\u0010\rJ\u0015\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0000¢\u0006\u0002\b\u0015R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/paging/PagingData;", "T", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "uiReceiver", "Landroidx/paging/UiReceiver;", "hintReceiver", "Landroidx/paging/HintReceiver;", "cachedPageEvent", "Lkotlin/Function0;", "Landroidx/paging/PageEvent$Insert;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/UiReceiver;Landroidx/paging/HintReceiver;Lkotlin/jvm/functions/Function0;)V", "getFlow$paging_common_release", "()Lkotlinx/coroutines/flow/Flow;", "getHintReceiver$paging_common_release", "()Landroidx/paging/HintReceiver;", "getUiReceiver$paging_common_release", "()Landroidx/paging/UiReceiver;", "cachedEvent", "cachedEvent$paging_common_release", "Companion", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagingData<T> {
    private final Function0<PageEvent.Insert<T>> cachedPageEvent;
    private final Flow<PageEvent<T>> flow;
    private final HintReceiver hintReceiver;
    private final UiReceiver uiReceiver;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UiReceiver NOOP_UI_RECEIVER = new UiReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_UI_RECEIVER$1
        @Override // androidx.paging.UiReceiver
        public void retry() {
        }
    };
    private static final HintReceiver NOOP_HINT_RECEIVER = new HintReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_HINT_RECEIVER$1
        @Override // androidx.paging.HintReceiver
        public void accessHint(ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public PagingData(Flow<? extends PageEvent<T>> flow, UiReceiver uiReceiver, HintReceiver hintReceiver, Function0<PageEvent.Insert<T>> cachedPageEvent) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(uiReceiver, "uiReceiver");
        Intrinsics.checkNotNullParameter(hintReceiver, "hintReceiver");
        Intrinsics.checkNotNullParameter(cachedPageEvent, "cachedPageEvent");
        this.flow = flow;
        this.uiReceiver = uiReceiver;
        this.hintReceiver = hintReceiver;
        this.cachedPageEvent = cachedPageEvent;
    }

    public final Flow<PageEvent<T>> getFlow$paging_common_release() {
        return this.flow;
    }

    /* renamed from: getUiReceiver$paging_common_release, reason: from getter */
    public final UiReceiver getUiReceiver() {
        return this.uiReceiver;
    }

    /* renamed from: getHintReceiver$paging_common_release, reason: from getter */
    public final HintReceiver getHintReceiver() {
        return this.hintReceiver;
    }

    public /* synthetic */ PagingData(Flow flow, UiReceiver uiReceiver, HintReceiver hintReceiver, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(flow, uiReceiver, hintReceiver, (i & 8) != 0 ? new Function0() { // from class: androidx.paging.PagingData.1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        } : function0);
    }

    /* compiled from: PagingData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/paging/PagingData$Companion;", "", "<init>", "()V", "T", "", RemoteMessageConst.DATA, "Landroidx/paging/PagingData;", RemoteMessageConst.FROM, "(Ljava/util/List;)Landroidx/paging/PagingData;", "Landroidx/paging/UiReceiver;", "NOOP_UI_RECEIVER", "Landroidx/paging/UiReceiver;", "getNOOP_UI_RECEIVER$paging_common_release", "()Landroidx/paging/UiReceiver;", "Landroidx/paging/HintReceiver;", "NOOP_HINT_RECEIVER", "Landroidx/paging/HintReceiver;", "getNOOP_HINT_RECEIVER$paging_common_release", "()Landroidx/paging/HintReceiver;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UiReceiver getNOOP_UI_RECEIVER$paging_common_release() {
            return PagingData.NOOP_UI_RECEIVER;
        }

        public final HintReceiver getNOOP_HINT_RECEIVER$paging_common_release() {
            return PagingData.NOOP_HINT_RECEIVER;
        }

        @JvmStatic
        public final <T> PagingData<T> from(final List<? extends T> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new PagingData<>(FlowKt.flowOf(new PageEvent.StaticList(data, null, null)), getNOOP_UI_RECEIVER$paging_common_release(), getNOOP_HINT_RECEIVER$paging_common_release(), new Function0<PageEvent.Insert<T>>() { // from class: androidx.paging.PagingData$Companion$from$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final PageEvent.Insert<T> invoke() {
                    return PageEvent.Insert.INSTANCE.Refresh(CollectionsKt.listOf(new TransformablePage(0, data)), 0, 0, LoadStates.INSTANCE.getIDLE(), null);
                }
            });
        }
    }

    public final PageEvent.Insert<T> cachedEvent$paging_common_release() {
        return this.cachedPageEvent.invoke();
    }
}
