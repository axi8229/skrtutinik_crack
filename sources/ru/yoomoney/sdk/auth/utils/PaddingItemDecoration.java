package ru.yoomoney.sdk.auth.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "startPadding", "", "endPadding", "(Landroid/content/Context;II)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "Separated", "ValueSeparated", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaddingItemDecoration extends RecyclerView.ItemDecoration {
    private final Drawable drawable;
    private final int endPadding;
    private final int startPadding;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b`\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration$Separated;", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Separated {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration$ValueSeparated;", "Lru/yoomoney/sdk/auth/utils/PaddingItemDecoration$Separated;", "startPaddingDivider", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ValueSeparated extends Separated {
        int startPaddingDivider();
    }

    public PaddingItemDecoration(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.startPadding = i;
        this.endPadding = i2;
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.line_divider);
        if (drawable == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(drawable, "requireNotNull(...)");
        this.drawable = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        outRect.set(0, 0, 0, this.drawable.getIntrinsicHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt != null) {
                RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(childAt);
                RecyclerView.Adapter adapter = parent.getAdapter();
                if ((childViewHolder instanceof Separated) && adapter != null && childViewHolder.getAdapterPosition() < adapter.getItemCount() - 1) {
                    ValueSeparated valueSeparated = childViewHolder instanceof ValueSeparated ? (ValueSeparated) childViewHolder : null;
                    int translationY = (int) (childAt.getTranslationY() + 0.5f);
                    this.drawable.setBounds(childAt.getLeft() + (valueSeparated != null ? valueSeparated.startPaddingDivider() : this.startPadding), childAt.getBottom() + translationY, childAt.getRight() - this.endPadding, this.drawable.getIntrinsicHeight() + childAt.getBottom() + translationY);
                    this.drawable.draw(c);
                }
            }
        }
    }

    public /* synthetic */ PaddingItemDecoration(Context context, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}
