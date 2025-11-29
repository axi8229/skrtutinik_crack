package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;

/* loaded from: classes5.dex */
public final class s extends Lambda implements Function2 {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ SnackbarHostState h;
    public final /* synthetic */ NoticeService i;
    public final /* synthetic */ int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(String str, boolean z, String str2, Function0 function0, boolean z2, Function0 function02, Function0 function03, SnackbarHostState snackbarHostState, NoticeService noticeService, int i) {
        super(2);
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = function0;
        this.e = z2;
        this.f = function02;
        this.g = function03;
        this.h = snackbarHostState;
        this.i = noticeService;
        this.j = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        u.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.j | 1));
        return Unit.INSTANCE;
    }
}
