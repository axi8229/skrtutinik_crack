package ru.yoomoney.sdk.gui.widgetV2.dialog;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* compiled from: YmBaseBottomSheetDialogFragment.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/DialogVisibleListener;", "", "onDismiss", "", RemoteMessageConst.Notification.TAG, "", "onShow", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DialogVisibleListener {

    /* compiled from: YmBaseBottomSheetDialogFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onDismiss(DialogVisibleListener dialogVisibleListener, String str) {
        }

        public static void onShow(DialogVisibleListener dialogVisibleListener, String str) {
        }
    }

    void onDismiss(String tag);

    void onShow(String tag);
}
