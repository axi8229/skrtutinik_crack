package ru.yoomoney.sdk.gui.base;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* compiled from: BaseNoTitleDialogFragment.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/gui/base/BaseNoTitleDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "themeId", "", "getThemeId", "()I", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseNoTitleDialogFragment extends DialogFragment {
    private final int themeId;

    protected int getThemeId() {
        return this.themeId;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, getThemeId());
    }
}
