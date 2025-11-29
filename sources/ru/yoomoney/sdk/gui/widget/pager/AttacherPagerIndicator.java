package ru.yoomoney.sdk.gui.widget.pager;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: AttacherPagerIndicator.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/gui/widget/pager/AttacherPagerIndicator;", "", "getCount", "", "setCurrentItem", "", "position", "setItemScrolledListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/yoomoney/sdk/gui/widget/pager/ScrollListener;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AttacherPagerIndicator {
    int getCount();

    void setCurrentItem(int position);

    void setItemScrolledListener(ScrollListener listener);
}
