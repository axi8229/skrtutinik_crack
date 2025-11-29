package ru.yoomoney.sdk.gui.widget.pager;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewPager2AttacherPagerIndicator.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/gui/widget/pager/ViewPager2AttacherPagerIndicator;", "Lru/yoomoney/sdk/gui/widget/pager/AttacherPagerIndicator;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "(Landroidx/viewpager2/widget/ViewPager2;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/yoomoney/sdk/gui/widget/pager/ScrollListener;", "getCount", "", "setCurrentItem", "", "position", "setItemScrolledListener", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPager2AttacherPagerIndicator implements AttacherPagerIndicator {
    private ScrollListener listener;
    private final ViewPager2 viewPager;

    public ViewPager2AttacherPagerIndicator(ViewPager2 viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.viewPager = viewPager;
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: ru.yoomoney.sdk.gui.widget.pager.ViewPager2AttacherPagerIndicator.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int state) {
                ScrollListener scrollListener = ViewPager2AttacherPagerIndicator.this.listener;
                if (scrollListener != null) {
                    scrollListener.onItemScrollStateChanged(state);
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ScrollListener scrollListener = ViewPager2AttacherPagerIndicator.this.listener;
                if (scrollListener != null) {
                    scrollListener.onItemScrolled(position, positionOffset);
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                ScrollListener scrollListener = ViewPager2AttacherPagerIndicator.this.listener;
                if (scrollListener != null) {
                    scrollListener.onItemSelected(position);
                }
            }
        });
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator
    public int getCount() {
        RecyclerView.Adapter adapter = this.viewPager.getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator
    public void setItemScrolledListener(ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator
    public void setCurrentItem(int position) {
        this.viewPager.setCurrentItem(position);
    }
}
