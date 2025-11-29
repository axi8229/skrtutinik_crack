package ru.yoomoney.sdk.gui.widget.pager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$styleable;

/* compiled from: CirclePageIndicator.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001IB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J8\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\bH\u0002J\u0010\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0002J\u0010\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\bH\u0016J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\u000fH\u0016J\u0010\u00108\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\bH\u0016J\u0018\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0014J\u0010\u0010<\u001a\u00020\u001f2\u0006\u00104\u001a\u00020=H\u0016J\n\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010?\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\bH\u0002J\u001a\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010.\u001a\u00020\bH\u0007J\u001a\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010.\u001a\u00020\bH\u0007J\u001a\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020H2\b\b\u0002\u0010.\u001a\u00020\bH\u0007R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lru/yoomoney/sdk/gui/widget/pager/CirclePageIndicator;", "Landroid/view/View;", "Lru/yoomoney/sdk/gui/widget/pager/ScrollListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activePointerId", "attacherPagerIndicator", "Lru/yoomoney/sdk/gui/widget/pager/AttacherPagerIndicator;", "currentPage", "gapSize", "", "isCentered", "", "isDragging", "isSnap", "lastMotionX", "pageOffset", "paintFill", "Landroid/graphics/Paint;", "paintPageFill", "paintStroke", "radius", "scrollState", "snapPage", "touchSlop", "actionDown", "", "event", "Landroid/view/MotionEvent;", "actionMove", "actionPointerDown", "actionPointerUp", "drawCircles", "canvas", "Landroid/graphics/Canvas;", "count", "longOffset", "shortOffset", "threeRadius", "pageFillRadius", "init", "initialPosition", "measureLong", "measureSpec", "measureShort", "onDraw", "onItemScrollStateChanged", "state", "onItemScrolled", "position", "positionOffset", "onItemSelected", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "Landroid/os/Parcelable;", "onSaveInstanceState", "onTouchEvent", "setCurrentItem", "item", "setRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setViewPager", "view", "Landroidx/viewpager/widget/ViewPager;", "Landroidx/viewpager2/widget/ViewPager2;", "SavedState", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class CirclePageIndicator extends View implements ScrollListener {
    private int activePointerId;
    private AttacherPagerIndicator attacherPagerIndicator;
    private int currentPage;
    private float gapSize;
    private boolean isCentered;
    private boolean isDragging;
    private boolean isSnap;
    private float lastMotionX;
    private float pageOffset;
    private final Paint paintFill;
    private final Paint paintPageFill;
    private final Paint paintStroke;
    private float radius;
    private int scrollState;
    private int snapPage;
    private final int touchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        setRecyclerView$default(this, recyclerView, 0, 2, null);
    }

    public final void setViewPager(ViewPager view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewPager$default(this, view, 0, 2, (Object) null);
    }

    public final void setViewPager(ViewPager2 view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewPager$default(this, view, 0, 2, (Object) null);
    }

    public /* synthetic */ CirclePageIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_PageIndicatorLight_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        this.paintPageFill = paint;
        Paint paint2 = new Paint(1);
        this.paintStroke = paint2;
        Paint paint3 = new Paint(1);
        this.paintFill = paint3;
        this.lastMotionX = -1.0f;
        this.activePointerId = -1;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_PageIndicator, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.isCentered = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_PageIndicator_ym_centered, false);
        Paint.Style style = Paint.Style.FILL;
        paint3.setStyle(style);
        paint3.setColor(typedArrayObtainStyledAttributes.getColor(R$styleable.ym_PageIndicator_ym_fill_color, 0));
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(style);
        paint.setColor(typedArrayObtainStyledAttributes.getColor(R$styleable.ym_PageIndicator_ym_page_color, 0));
        this.radius = typedArrayObtainStyledAttributes.getDimension(R$styleable.ym_PageIndicator_ym_radius, 0.0f);
        this.isSnap = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_PageIndicator_ym_snap, true);
        this.gapSize = typedArrayObtainStyledAttributes.getDimension(R$styleable.ym_PageIndicator_ym_gap, 0.0f);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ym_PageIndicator_android_background);
        if (drawable != null) {
            setBackground(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.touchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        AttacherPagerIndicator attacherPagerIndicator = this.attacherPagerIndicator;
        int count = attacherPagerIndicator != null ? attacherPagerIndicator.getCount() : 0;
        if (count == 0) {
            return;
        }
        if (this.currentPage >= count) {
            setCurrentItem(count - 1);
            return;
        }
        float f = (this.radius * 3.0f) + this.gapSize;
        float paddingTop = getPaddingTop() + this.radius;
        float paddingLeft = getPaddingLeft();
        float f2 = this.radius;
        float width = paddingLeft + f2;
        if (this.isCentered) {
            width += (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (((count * f) - f2) - this.gapSize)) / 2.0f;
        }
        float strokeWidth = this.radius;
        if (this.paintStroke.getStrokeWidth() > 0.0f) {
            strokeWidth -= this.paintStroke.getStrokeWidth() / 2.0f;
        }
        drawCircles(canvas, count, width, paddingTop, f, strokeWidth);
    }

    private final void drawCircles(Canvas canvas, int count, float longOffset, float shortOffset, float threeRadius, float pageFillRadius) {
        for (int i = 0; i < count; i++) {
            float f = (i * threeRadius) + longOffset;
            if (this.paintPageFill.getAlpha() > 0) {
                canvas.drawCircle(f, shortOffset, pageFillRadius, this.paintPageFill);
            }
            float f2 = this.radius;
            if (pageFillRadius != f2) {
                canvas.drawCircle(f, shortOffset, f2, this.paintStroke);
            }
        }
        boolean z = this.isSnap;
        float f3 = (z ? this.snapPage : this.currentPage) * threeRadius;
        if (!z) {
            f3 += this.pageOffset * threeRadius;
        }
        canvas.drawCircle(longOffset + f3, shortOffset, this.radius, this.paintFill);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = super.onTouchEvent(r9)
            r1 = 1
            if (r0 == 0) goto Ld
            return r1
        Ld:
            ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator r0 = r8.attacherPagerIndicator
            r2 = 0
            if (r0 == 0) goto L17
            int r0 = r0.getCount()
            goto L18
        L17:
            r0 = r2
        L18:
            if (r0 != 0) goto L1b
            return r2
        L1b:
            int r2 = r9.getAction()
            r2 = r2 & 255(0xff, float:3.57E-43)
            if (r2 == 0) goto L88
            r3 = 3
            if (r2 == r1) goto L3e
            r4 = 2
            if (r2 == r4) goto L3a
            if (r2 == r3) goto L3e
            r0 = 5
            if (r2 == r0) goto L36
            r0 = 6
            if (r2 == r0) goto L32
            goto L8b
        L32:
            r8.actionPointerUp(r9)
            goto L8b
        L36:
            r8.actionPointerDown(r9)
            goto L8b
        L3a:
            r8.actionMove(r9)
            goto L8b
        L3e:
            boolean r4 = r8.isDragging
            if (r4 != 0) goto L8b
            int r4 = r8.getWidth()
            float r4 = (float) r4
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            int r5 = r8.getWidth()
            float r5 = (float) r5
            r6 = 1086324736(0x40c00000, float:6.0)
            float r5 = r5 / r6
            int r6 = r8.currentPage
            if (r6 <= 0) goto L6d
            float r6 = r9.getX()
            float r7 = r4 - r5
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L6d
            if (r2 == r3) goto L6c
            ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator r9 = r8.attacherPagerIndicator
            if (r9 == 0) goto L6c
            int r0 = r8.currentPage
            int r0 = r0 - r1
            r9.setCurrentItem(r0)
        L6c:
            return r1
        L6d:
            int r6 = r8.currentPage
            int r0 = r0 - r1
            if (r6 >= r0) goto L8b
            float r9 = r9.getX()
            float r4 = r4 + r5
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 <= 0) goto L8b
            if (r2 == r3) goto L87
            ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator r9 = r8.attacherPagerIndicator
            if (r9 == 0) goto L87
            int r0 = r8.currentPage
            int r0 = r0 + r1
            r9.setCurrentItem(r0)
        L87:
            return r1
        L88:
            r8.actionDown(r9)
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.gui.widget.pager.CirclePageIndicator.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private final void actionDown(MotionEvent event) {
        this.activePointerId = event.getPointerId(0);
        this.lastMotionX = event.getX();
    }

    private final void actionMove(MotionEvent event) {
        float x = event.getX(event.findPointerIndex(this.activePointerId)) - this.lastMotionX;
        if (this.isDragging || Math.abs(x) <= this.touchSlop) {
            return;
        }
        this.isDragging = true;
    }

    private final void actionPointerUp(MotionEvent event) {
        int actionIndex = event.getActionIndex();
        if (event.getPointerId(actionIndex) == this.activePointerId) {
            this.activePointerId = event.getPointerId(actionIndex == 0 ? 1 : 0);
        }
        this.lastMotionX = event.getX(event.findPointerIndex(this.activePointerId));
    }

    private final void actionPointerDown(MotionEvent event) {
        int actionIndex = event.getActionIndex();
        this.lastMotionX = event.getX(actionIndex);
        this.activePointerId = event.getPointerId(actionIndex);
    }

    public static /* synthetic */ void setViewPager$default(CirclePageIndicator circlePageIndicator, ViewPager viewPager, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setViewPager");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        circlePageIndicator.setViewPager(viewPager, i);
    }

    public final void setViewPager(ViewPager view, int initialPosition) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getAdapter();
        throw new IllegalArgumentException("ViewPager does not have adapter instance.");
    }

    public static /* synthetic */ void setViewPager$default(CirclePageIndicator circlePageIndicator, ViewPager2 viewPager2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setViewPager");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        circlePageIndicator.setViewPager(viewPager2, i);
    }

    public final void setViewPager(ViewPager2 view, int initialPosition) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getAdapter() == null) {
            throw new IllegalArgumentException("ViewPager2 does not have adapter instance.");
        }
        this.attacherPagerIndicator = new ViewPager2AttacherPagerIndicator(view);
        init(initialPosition);
    }

    public static /* synthetic */ void setRecyclerView$default(CirclePageIndicator circlePageIndicator, RecyclerView recyclerView, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRecyclerView");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        circlePageIndicator.setRecyclerView(recyclerView, i);
    }

    public final void setRecyclerView(RecyclerView recyclerView, int initialPosition) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (recyclerView.getAdapter() == null) {
            throw new IllegalArgumentException("RecyclerView does not have adapter instance.");
        }
        boolean z = recyclerView.getLayoutManager() instanceof LinearLayoutManager;
        this.attacherPagerIndicator = new RecyclerViewAttacherPagerIndicator(recyclerView);
        init(initialPosition);
    }

    private final void init(int initialPosition) {
        AttacherPagerIndicator attacherPagerIndicator = this.attacherPagerIndicator;
        if (attacherPagerIndicator != null) {
            attacherPagerIndicator.setItemScrolledListener(this);
        }
        invalidate();
        setCurrentItem(initialPosition);
    }

    private final void setCurrentItem(int item) {
        AttacherPagerIndicator attacherPagerIndicator = this.attacherPagerIndicator;
        if (attacherPagerIndicator != null) {
            attacherPagerIndicator.setCurrentItem(item);
        }
        this.currentPage = item;
        invalidate();
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.ScrollListener
    public void onItemScrolled(int position, float positionOffset) {
        this.currentPage = position;
        this.pageOffset = positionOffset;
        invalidate();
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.ScrollListener
    public void onItemSelected(int position) {
        if (this.isSnap || this.scrollState == 0) {
            this.currentPage = position;
            this.snapPage = position;
            invalidate();
        }
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.ScrollListener
    public void onItemScrollStateChanged(int state) {
        this.scrollState = state;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureLong(widthMeasureSpec), measureShort(heightMeasureSpec));
    }

    private final int measureLong(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == 1073741824) {
            return size;
        }
        AttacherPagerIndicator attacherPagerIndicator = this.attacherPagerIndicator;
        int count = attacherPagerIndicator != null ? attacherPagerIndicator.getCount() : 0;
        float f = this.radius;
        int paddingLeft = (int) (getPaddingLeft() + getPaddingRight() + (count * 2.0f * f) + ((count - 1) * f) + 1.0f);
        return mode == Integer.MIN_VALUE ? RangesKt.coerceAtMost(paddingLeft, size) : paddingLeft;
    }

    private final int measureShort(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.radius * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? RangesKt.coerceAtMost(paddingTop, size) : paddingTop;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPage = savedState.getCurrentPage();
        this.snapPage = savedState.getCurrentPage();
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            return null;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setCurrentPage(this.currentPage);
        return savedState;
    }

    /* compiled from: CirclePageIndicator.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/gui/widget/pager/CirclePageIndicator$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "currentPage", "", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "writeToParcel", "", "dest", "flags", "CREATOR", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SavedState extends View.BaseSavedState {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private int currentPage;

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public final int getCurrentPage() {
            return this.currentPage;
        }

        public final void setCurrentPage(int i) {
            this.currentPage = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            Intrinsics.checkNotNullParameter(superState, "superState");
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPage = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPage);
        }

        /* compiled from: CirclePageIndicator.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/gui/widget/pager/CirclePageIndicator$SavedState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lru/yoomoney/sdk/gui/widget/pager/CirclePageIndicator$SavedState;", "()V", "createFromParcel", "in", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lru/yoomoney/sdk/gui/widget/pager/CirclePageIndicator$SavedState;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* renamed from: ru.yoomoney.sdk.gui.widget.pager.CirclePageIndicator$SavedState$CREATOR, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator<SavedState> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new SavedState(in, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }
    }
}
