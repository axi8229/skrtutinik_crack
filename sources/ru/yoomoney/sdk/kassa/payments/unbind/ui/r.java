package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.kassa.payments.metrics.F;

/* loaded from: classes5.dex */
public final class r extends Lambda implements Function2 {
    public final /* synthetic */ F a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ SnackbarHostState c;
    public final /* synthetic */ NoticeService d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(F f, Function0 function0, SnackbarHostState snackbarHostState, NoticeService noticeService, int i) {
        super(2);
        this.a = f;
        this.b = function0;
        this.c = snackbarHostState;
        this.d = noticeService;
        this.e = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        u.a(this.a, this.b, this.c, this.d, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.e | 1));
        return Unit.INSTANCE;
    }
}
