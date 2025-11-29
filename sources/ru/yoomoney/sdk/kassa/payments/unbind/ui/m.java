package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.kassa.payments.metrics.F;

/* loaded from: classes5.dex */
public final class m extends Lambda implements Function2 {
    public final /* synthetic */ F a;
    public final /* synthetic */ w b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ SnackbarHostState e;
    public final /* synthetic */ NoticeService f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(F f, w wVar, Function0 function0, Function1 function1, SnackbarHostState snackbarHostState, NoticeService noticeService, int i) {
        super(2);
        this.a = f;
        this.b = wVar;
        this.c = function0;
        this.d = function1;
        this.e = snackbarHostState;
        this.f = noticeService;
        this.g = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        u.a(this.a, this.b, this.c, this.d, this.e, this.f, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.g | 1));
        return Unit.INSTANCE;
    }
}
