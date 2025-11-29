package ru.yoomoney.sdk.guiCompose.views.notice;

import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.SnackbarResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;

/* compiled from: NoticeCommon.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0010\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/notice/NoticeService;", "", "Landroidx/compose/material/SnackbarHostState;", "hostState", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Landroidx/compose/material/SnackbarHostState;Lkotlinx/coroutines/CoroutineScope;)V", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice$Type;", "type", "", "text", "action", "Lkotlin/Function0;", "", "onClick", "showNotice", "(Lru/yoomoney/sdk/guiCompose/views/notice/Notice$Type;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showAlertNotice", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lru/yoomoney/sdk/guiCompose/views/notice/Notice;", "notice", "(Lru/yoomoney/sdk/guiCompose/views/notice/Notice;)V", "Landroidx/compose/material/SnackbarHostState;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MutableState;", "noticeType", "Landroidx/compose/runtime/MutableState;", "getNoticeType$guiCompose_release", "()Landroidx/compose/runtime/MutableState;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NoticeService {
    public static final int $stable = 8;
    private final SnackbarHostState hostState;
    private Job job;
    private final MutableState<Notice.Type> noticeType;
    private final CoroutineScope scope;

    public NoticeService(SnackbarHostState hostState, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(hostState, "hostState");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.hostState = hostState;
        this.scope = scope;
        this.noticeType = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Notice.Type.NORMAL, null, 2, null);
    }

    public final MutableState<Notice.Type> getNoticeType$guiCompose_release() {
        return this.noticeType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showAlertNotice$default(NoticeService noticeService, String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        noticeService.showAlertNotice(str, str2, function0);
    }

    public final void showAlertNotice(String text, String action, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(text, "text");
        showNotice(Notice.Type.ALERT, text, action, onClick);
    }

    public final void showNotice(Notice notice) {
        Intrinsics.checkNotNullParameter(notice, "notice");
        showNotice(notice.getType(), notice.getText(), notice.getAction(), notice.getOnClick());
    }

    private final void showNotice(Notice.Type type, String text, String action, Function0<Unit> onClick) {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.noticeType.setValue(type);
        this.job = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(text, action, onClick, null), 3, null);
    }

    /* compiled from: NoticeCommon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.guiCompose.views.notice.NoticeService$showNotice$2", f = "NoticeCommon.kt", l = {104}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.guiCompose.views.notice.NoticeService$showNotice$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $action;
        final /* synthetic */ Function0<Unit> $onClick;
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$text = str;
            this.$action = str2;
            this.$onClick = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoticeService.this.new AnonymousClass2(this.$text, this.$action, this.$onClick, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function0<Unit> function0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SnackbarHostState snackbarHostState = NoticeService.this.hostState;
                String str = this.$text;
                String str2 = this.$action;
                SnackbarDuration snackbarDuration = (str2 == null || str2.length() == 0) ? SnackbarDuration.Long : SnackbarDuration.Indefinite;
                this.label = 1;
                obj = snackbarHostState.showSnackbar(str, str2, snackbarDuration, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((SnackbarResult) obj) == SnackbarResult.ActionPerformed && (function0 = this.$onClick) != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }
}
