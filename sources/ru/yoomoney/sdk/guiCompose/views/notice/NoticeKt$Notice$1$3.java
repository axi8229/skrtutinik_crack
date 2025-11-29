package ru.yoomoney.sdk.guiCompose.views.notice;

import androidx.compose.material.SnackbarData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: Notice.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class NoticeKt$Notice$1$3 extends FunctionReferenceImpl implements Function0<Unit> {
    NoticeKt$Notice$1$3(Object obj) {
        super(0, obj, SnackbarData.class, "performAction", "performAction()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((SnackbarData) this.receiver).performAction();
    }
}
