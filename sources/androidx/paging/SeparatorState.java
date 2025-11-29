package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import okhttp3.internal.http.StatusLine;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: Separators.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\u00020\u0001B?\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012.\u0010\b\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\b\b\u0002\u0010\u0003*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013*\b\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0017\u001a\u00020\u0016\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u00020\u0016\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0018J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u001fH\u0086@¢\u0006\u0004\b \u0010!J$\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0086@¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R?\u0010\b\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R#\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u0017\u0010:\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010G\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR\"\u0010O\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u00101\u001a\u0004\bP\u00103\"\u0004\bQ\u00105R\"\u0010R\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00101\u001a\u0004\bS\u00103\"\u0004\bT\u00105¨\u0006U"}, d2 = {"Landroidx/paging/SeparatorState;", "", "R", "T", "Landroidx/paging/TerminalSeparatorType;", "terminalSeparatorType", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "generator", "<init>", "(Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)V", "Landroidx/paging/TransformablePage;", "originalPage", "transformablePageToStash", "(Landroidx/paging/TransformablePage;)Landroidx/paging/TransformablePage;", "Landroidx/paging/PageEvent;", "event", "onEvent", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Insert;", "asRType", "(Landroidx/paging/PageEvent$Insert;)Landroidx/paging/PageEvent$Insert;", "", "terminatesStart", "(Landroidx/paging/PageEvent$Insert;Landroidx/paging/TerminalSeparatorType;)Z", "terminatesEnd", "onInsert", "(Landroidx/paging/PageEvent$Insert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Drop;", "onDrop", "(Landroidx/paging/PageEvent$Drop;)Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "onLoadStateUpdate", "(Landroidx/paging/PageEvent$LoadStateUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$StaticList;", "onStaticList", "(Landroidx/paging/PageEvent$StaticList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/TerminalSeparatorType;", "getTerminalSeparatorType", "()Landroidx/paging/TerminalSeparatorType;", "Lkotlin/jvm/functions/Function3;", "getGenerator", "()Lkotlin/jvm/functions/Function3;", "", "pageStash", "Ljava/util/List;", "getPageStash", "()Ljava/util/List;", "endTerminalSeparatorDeferred", "Z", "getEndTerminalSeparatorDeferred", "()Z", "setEndTerminalSeparatorDeferred", "(Z)V", "startTerminalSeparatorDeferred", "getStartTerminalSeparatorDeferred", "setStartTerminalSeparatorDeferred", "Landroidx/paging/MutableLoadStateCollection;", "sourceStates", "Landroidx/paging/MutableLoadStateCollection;", "getSourceStates", "()Landroidx/paging/MutableLoadStateCollection;", "Landroidx/paging/LoadStates;", "mediatorStates", "Landroidx/paging/LoadStates;", "getMediatorStates", "()Landroidx/paging/LoadStates;", "setMediatorStates", "(Landroidx/paging/LoadStates;)V", "", "placeholdersBefore", "I", "getPlaceholdersBefore", "()I", "setPlaceholdersBefore", "(I)V", "placeholdersAfter", "getPlaceholdersAfter", "setPlaceholdersAfter", "footerAdded", "getFooterAdded", "setFooterAdded", "headerAdded", "getHeaderAdded", "setHeaderAdded", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SeparatorState<R, T extends R> {
    private boolean endTerminalSeparatorDeferred;
    private boolean footerAdded;
    private final Function3<T, T, Continuation<? super R>, Object> generator;
    private boolean headerAdded;
    private LoadStates mediatorStates;
    private final List<TransformablePage<T>> pageStash;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private final MutableLoadStateCollection sourceStates;
    private boolean startTerminalSeparatorDeferred;
    private final TerminalSeparatorType terminalSeparatorType;

    /* compiled from: Separators.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TerminalSeparatorType.values().length];
            try {
                iArr[TerminalSeparatorType.FULLY_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TerminalSeparatorType.SOURCE_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Separators.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {214, 216, 217}, m = "onEvent")
    /* renamed from: androidx.paging.SeparatorState$onEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C04911 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04911(SeparatorState<R, T> separatorState, Continuation<? super C04911> continuation) {
            super(continuation);
            this.this$0 = separatorState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onEvent(null, this);
        }
    }

    /* compiled from: Separators.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {StatusLine.HTTP_TEMP_REDIRECT, 370, 382, 388, 400, pjsip_status_code.PJSIP_SC_CONFLICT, 431, pjsip_status_code.PJSIP_SC_MAX_BREADTH_EXCEEDED, 453, 464}, m = "onInsert")
    /* renamed from: androidx.paging.SeparatorState$onInsert$1, reason: invalid class name and case insensitive filesystem */
    static final class C04921 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04921(SeparatorState<R, T> separatorState, Continuation<? super C04921> continuation) {
            super(continuation);
            this.this$0 = separatorState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onInsert(null, this);
        }
    }

    /* compiled from: Separators.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {564}, m = "onStaticList")
    /* renamed from: androidx.paging.SeparatorState$onStaticList$1, reason: invalid class name and case insensitive filesystem */
    static final class C04931 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04931(SeparatorState<R, T> separatorState, Continuation<? super C04931> continuation) {
            super(continuation);
            this.this$0 = separatorState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onStaticList(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Insert<R> asRType(PageEvent.Insert<T> insert) {
        Intrinsics.checkNotNullParameter(insert, "<this>");
        return insert;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SeparatorState(TerminalSeparatorType terminalSeparatorType, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> generator) {
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(generator, "generator");
        this.terminalSeparatorType = terminalSeparatorType;
        this.generator = generator;
        this.pageStash = new ArrayList();
        this.sourceStates = new MutableLoadStateCollection();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onEvent(androidx.paging.PageEvent<T> r7, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r8) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onEvent(androidx.paging.PageEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final <T> boolean terminatesStart(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadStates mediatorLoadStates;
        LoadState prepend;
        Intrinsics.checkNotNullParameter(insert, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.APPEND) {
            return this.startTerminalSeparatorDeferred;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[terminalSeparatorType.ordinal()];
        if (i == 1) {
            return insert.getSourceLoadStates().getPrepend().getEndOfPaginationReached() && ((mediatorLoadStates = insert.getMediatorLoadStates()) == null || (prepend = mediatorLoadStates.getPrepend()) == null || prepend.getEndOfPaginationReached());
        }
        if (i == 2) {
            return insert.getSourceLoadStates().getPrepend().getEndOfPaginationReached();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <T> boolean terminatesEnd(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadStates mediatorLoadStates;
        LoadState append;
        Intrinsics.checkNotNullParameter(insert, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.PREPEND) {
            return this.endTerminalSeparatorDeferred;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[terminalSeparatorType.ordinal()];
        if (i == 1) {
            return insert.getSourceLoadStates().getAppend().getEndOfPaginationReached() && ((mediatorLoadStates = insert.getMediatorLoadStates()) == null || (append = mediatorLoadStates.getAppend()) == null || append.getEndOfPaginationReached());
        }
        if (i == 2) {
            return insert.getSourceLoadStates().getAppend().getEndOfPaginationReached();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:30:0x022b, B:29:0x0229], limit reached: 256 */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0555 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x068a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0773 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x07ec  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x034c  */
    /* JADX WARN: Type inference failed for: r1v52, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x047d -> B:136:0x0484). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x068b -> B:17:0x00d4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:216:0x0774 -> B:217:0x0775). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onInsert(androidx.paging.PageEvent.Insert<T> r31, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent.Insert<R>> r32) {
        /*
            Method dump skipped, instructions count: 2146
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onInsert(androidx.paging.PageEvent$Insert, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Drop<R> onDrop(PageEvent.Drop<T> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.sourceStates.set(event.getLoadType(), LoadState.NotLoading.INSTANCE.getIncomplete$paging_common_release());
        LoadType loadType = event.getLoadType();
        LoadType loadType2 = LoadType.PREPEND;
        if (loadType == loadType2) {
            this.placeholdersBefore = event.getPlaceholdersRemaining();
            this.headerAdded = false;
        } else if (event.getLoadType() == LoadType.APPEND) {
            this.placeholdersAfter = event.getPlaceholdersRemaining();
            this.footerAdded = false;
        }
        if (this.pageStash.isEmpty()) {
            if (event.getLoadType() == loadType2) {
                this.startTerminalSeparatorDeferred = false;
            } else {
                this.endTerminalSeparatorDeferred = false;
            }
        }
        final IntRange intRange = new IntRange(event.getMinPageOffset(), event.getMaxPageOffset());
        CollectionsKt.removeAll((List) this.pageStash, (Function1) new Function1<TransformablePage<T>, Boolean>() { // from class: androidx.paging.SeparatorState.onDrop.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(TransformablePage<T> stash) {
                Intrinsics.checkNotNullParameter(stash, "stash");
                int[] originalPageOffsets = stash.getOriginalPageOffsets();
                IntRange intRange2 = intRange;
                int length = originalPageOffsets.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (intRange2.contains(originalPageOffsets[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
                return Boolean.valueOf(z);
            }
        });
        return event;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object onLoadStateUpdate(PageEvent.LoadStateUpdate<T> loadStateUpdate, Continuation<? super PageEvent<R>> continuation) {
        LoadStates loadStates = this.mediatorStates;
        if (Intrinsics.areEqual(this.sourceStates.snapshot(), loadStateUpdate.getSource()) && Intrinsics.areEqual(loadStates, loadStateUpdate.getMediator())) {
            Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
            return loadStateUpdate;
        }
        this.sourceStates.set(loadStateUpdate.getSource());
        this.mediatorStates = loadStateUpdate.getMediator();
        if (loadStateUpdate.getMediator() != null && loadStateUpdate.getMediator().getPrepend().getEndOfPaginationReached()) {
            if (!Intrinsics.areEqual(loadStates != null ? loadStates.getPrepend() : null, loadStateUpdate.getMediator().getPrepend())) {
                return onInsert(PageEvent.Insert.INSTANCE.Prepend(CollectionsKt.emptyList(), this.placeholdersBefore, loadStateUpdate.getSource(), loadStateUpdate.getMediator()), continuation);
            }
        }
        if (loadStateUpdate.getMediator() != null && loadStateUpdate.getMediator().getAppend().getEndOfPaginationReached()) {
            if (!Intrinsics.areEqual(loadStates != null ? loadStates.getAppend() : null, loadStateUpdate.getMediator().getAppend())) {
                return onInsert(PageEvent.Insert.INSTANCE.Append(CollectionsKt.emptyList(), this.placeholdersAfter, loadStateUpdate.getSource(), loadStateUpdate.getMediator()), continuation);
            }
        }
        Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return loadStateUpdate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0085 -> B:21:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onStaticList(androidx.paging.PageEvent.StaticList<T> r11, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.paging.SeparatorState.C04931
            if (r0 == 0) goto L13
            r0 = r12
            androidx.paging.SeparatorState$onStaticList$1 r0 = (androidx.paging.SeparatorState.C04931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.paging.SeparatorState$onStaticList$1 r0 = new androidx.paging.SeparatorState$onStaticList$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            int r11 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$3
            java.lang.Object r5 = r0.L$2
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$1
            androidx.paging.PageEvent$StaticList r6 = (androidx.paging.PageEvent.StaticList) r6
            java.lang.Object r7 = r0.L$0
            androidx.paging.SeparatorState r7 = (androidx.paging.SeparatorState) r7
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r4
            r4 = r11
            r11 = r6
            r6 = r9
            goto L88
        L3f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L47:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r2 = r11.getData()
            int r2 = r2.size()
            if (r2 < 0) goto L9a
            r4 = 0
            r7 = r10
            r5 = r12
        L5c:
            java.util.List r12 = r11.getData()
            int r6 = r4 + (-1)
            java.lang.Object r12 = kotlin.collections.CollectionsKt.getOrNull(r12, r6)
            java.util.List r6 = r11.getData()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.getOrNull(r6, r4)
            kotlin.jvm.functions.Function3<T extends R, T extends R, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r8 = r7.generator
            r0.L$0 = r7
            r0.L$1 = r11
            r0.L$2 = r5
            r0.L$3 = r6
            r0.I$0 = r4
            r0.I$1 = r2
            r0.label = r3
            java.lang.Object r12 = r8.invoke(r12, r6, r0)
            if (r12 != r1) goto L85
            return r1
        L85:
            r9 = r4
            r4 = r2
            r2 = r9
        L88:
            if (r12 == 0) goto L8d
            r5.add(r12)
        L8d:
            if (r6 == 0) goto L92
            r5.add(r6)
        L92:
            if (r2 == r4) goto L99
            int r12 = r2 + 1
            r2 = r4
            r4 = r12
            goto L5c
        L99:
            r12 = r5
        L9a:
            androidx.paging.PageEvent$StaticList r0 = new androidx.paging.PageEvent$StaticList
            androidx.paging.LoadStates r1 = r11.getSourceLoadStates()
            androidx.paging.LoadStates r11 = r11.getMediatorLoadStates()
            r0.<init>(r12, r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onStaticList(androidx.paging.PageEvent$StaticList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final <T> TransformablePage<T> transformablePageToStash(TransformablePage<T> originalPage) {
        int[] originalPageOffsets = originalPage.getOriginalPageOffsets();
        List listListOf = CollectionsKt.listOf(CollectionsKt.first((List) originalPage.getData()), CollectionsKt.last((List) originalPage.getData()));
        int hintOriginalPageOffset = originalPage.getHintOriginalPageOffset();
        List<Integer> hintOriginalIndices = originalPage.getHintOriginalIndices();
        Integer numValueOf = Integer.valueOf(hintOriginalIndices != null ? ((Number) CollectionsKt.first((List) hintOriginalIndices)).intValue() : 0);
        List<Integer> hintOriginalIndices2 = originalPage.getHintOriginalIndices();
        return new TransformablePage<>(originalPageOffsets, listListOf, hintOriginalPageOffset, CollectionsKt.listOf((Object[]) new Integer[]{numValueOf, Integer.valueOf(hintOriginalIndices2 != null ? ((Number) CollectionsKt.last((List) hintOriginalIndices2)).intValue() : CollectionsKt.getLastIndex(originalPage.getData()))}));
    }
}
