package ru.yoomoney.sdk.guiCompose.views.form;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmCodeInputView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016JP\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/form/EmptyTextToolbar;", "Landroidx/compose/ui/platform/TextToolbar;", "()V", UpdateKey.STATUS, "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class EmptyTextToolbar implements TextToolbar {
    public static final EmptyTextToolbar INSTANCE = new EmptyTextToolbar();
    private static final TextToolbarStatus status = TextToolbarStatus.Hidden;

    @Override // androidx.compose.ui.platform.TextToolbar
    public void hide() {
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    private EmptyTextToolbar() {
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public TextToolbarStatus getStatus() {
        return status;
    }
}
