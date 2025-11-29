package sputnik.axmor.com.sputnik.ui.main.profile.family.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sputnik.common.entities.invites.FamilyInvite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeHelper.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ=\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0016¢\u0006\u0004\b,\u0010+JG\u00101\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020!H\u0016¢\u0006\u0004\b1\u00102J/\u00105\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u0013032\u0006\u00104\u001a\u00020\u001aH\u0016¢\u0006\u0004\b5\u00106R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00107R(\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u001dR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0013038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00109R\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010=R\u0016\u0010J\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR&\u0010M\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0013030L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00060O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006U"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/adapter/SwipeHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "buttonWidth", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;I)V", "", "attachSwipe", "()V", "recoverSwipedItem", "Landroid/graphics/Canvas;", "c", "Landroid/view/View;", "itemView", "", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/adapter/MyButton;", "buffer", "pos", "", "translationX", "drawButton", "(Landroid/graphics/Canvas;Landroid/view/View;Ljava/util/List;IF)V", "Lcom/sputnik/common/entities/invites/FamilyInvite;", "list", "updateList", "(Ljava/util/List;)V", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "target", "", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getSwipeThreshold", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)F", "defaultValue", "getSwipeEscapeVelocity", "(F)F", "getSwipeVelocityThreshold", "dX", "dY", "actionState", "isCurrentlyActive", "onChildDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V", "", "item", "instantiateMyButton", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;Lcom/sputnik/common/entities/invites/FamilyInvite;)V", "Landroidx/recyclerview/widget/RecyclerView;", "currentList", "Ljava/util/List;", "getCurrentList", "()Ljava/util/List;", "setCurrentList", "I", "getButtonWidth", "()I", "setButtonWidth", "(I)V", "buttonList", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "gestureListener", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "swipePosition", "swipeThreshold", "F", "", "buttonBuffer", "Ljava/util/Map;", "Ljava/util/Queue;", "removeQueue", "Ljava/util/Queue;", "Landroid/view/View$OnTouchListener;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SwipeHelper extends ItemTouchHelper.SimpleCallback {
    private final Map<Integer, List<MyButton>> buttonBuffer;
    private List<MyButton> buttonList;
    private int buttonWidth;
    private List<FamilyInvite> currentList;
    private final GestureDetector gestureDetector;
    private final GestureDetector.SimpleOnGestureListener gestureListener;
    private final View.OnTouchListener onTouchListener;
    private final RecyclerView recyclerView;
    private final Queue<Integer> removeQueue;
    private int swipePosition;
    private float swipeThreshold;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeEscapeVelocity(float defaultValue) {
        return defaultValue * 0.1f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeVelocityThreshold(float defaultValue) {
        return defaultValue * 5.0f;
    }

    public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer, FamilyInvite item) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(item, "item");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeHelper(Context context, RecyclerView recyclerView, int i) {
        super(0, 4);
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.currentList = CollectionsKt.emptyList();
        this.buttonList = new ArrayList();
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.SwipeHelper$gestureListener$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                Iterator it = this.this$0.buttonList.iterator();
                while (it.hasNext() && !((MyButton) it.next()).onClick(e.getX(), e.getY())) {
                }
                return true;
            }
        };
        this.gestureListener = simpleOnGestureListener;
        this.gestureDetector = new GestureDetector(context, simpleOnGestureListener);
        this.swipePosition = -1;
        this.swipeThreshold = 0.5f;
        this.buttonBuffer = new HashMap();
        this.removeQueue = new LinkedList<Integer>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.SwipeHelper$removeQueue$1
            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public /* bridge */ /* synthetic */ boolean add(Object obj) {
                return add(((Number) obj).intValue());
            }

            public /* bridge */ boolean contains(Integer num) {
                return super.contains((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Integer) {
                    return contains((Integer) obj);
                }
                return false;
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ int indexOf(Integer num) {
                return super.indexOf((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Integer) {
                    return indexOf((Integer) obj);
                }
                return -1;
            }

            public /* bridge */ int lastIndexOf(Integer num) {
                return super.lastIndexOf((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Integer) {
                    return lastIndexOf((Integer) obj);
                }
                return -1;
            }

            public /* bridge */ boolean remove(Integer num) {
                return super.remove((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public final /* bridge */ boolean remove(Object obj) {
                if (obj == null ? true : obj instanceof Integer) {
                    return remove((Integer) obj);
                }
                return false;
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public final /* bridge */ int size() {
                return getSize();
            }

            public boolean add(int integer) {
                if (contains((Object) Integer.valueOf(integer))) {
                    return false;
                }
                return super.add((SwipeHelper$removeQueue$1) Integer.valueOf(integer));
            }
        };
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.adapter.SwipeHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SwipeHelper.onTouchListener$lambda$0(this.f$0, view, motionEvent);
            }
        };
        this.onTouchListener = onTouchListener;
        recyclerView.setOnTouchListener(onTouchListener);
        this.buttonWidth = i;
        attachSwipe();
    }

    public final void updateList(List<FamilyInvite> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.currentList = list;
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTouchListener$lambda$0(SwipeHelper this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.swipePosition < 0) {
            return false;
        }
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this$0.recyclerView.findViewHolderForAdapterPosition(this$0.swipePosition);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View itemView = viewHolderFindViewHolderForAdapterPosition.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            Rect rect = new Rect();
            itemView.getGlobalVisibleRect(rect);
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 2) {
                int i = rect.top;
                int i2 = point.y;
                if (i < i2 && rect.bottom > i2) {
                    this$0.gestureDetector.onTouchEvent(motionEvent);
                } else {
                    this$0.removeQueue.add(Integer.valueOf(this$0.swipePosition));
                    this$0.swipePosition = -1;
                    this$0.recoverSwipedItem();
                }
            }
        }
        return false;
    }

    private final void attachSwipe() {
        new ItemTouchHelper(this).attachToRecyclerView(this.recyclerView);
    }

    private final synchronized void recoverSwipedItem() {
        while (!this.removeQueue.isEmpty()) {
            Integer numPoll = this.removeQueue.poll();
            Intrinsics.checkNotNull(numPoll);
            if (numPoll.intValue() > -1) {
                RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter);
                adapter.notifyItemChanged(numPoll.intValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int adapterPosition = viewHolder.getAdapterPosition();
        int i = this.swipePosition;
        if (i != adapterPosition) {
            this.removeQueue.add(Integer.valueOf(i));
        }
        this.swipePosition = adapterPosition;
        if (this.buttonBuffer.containsKey(Integer.valueOf(adapterPosition))) {
            List<MyButton> list = this.buttonBuffer.get(Integer.valueOf(this.swipePosition));
            Intrinsics.checkNotNull(list);
            this.buttonList = list;
        } else {
            this.buttonList.clear();
        }
        this.buttonBuffer.clear();
        this.swipeThreshold = this.buttonList.size() * this.buttonWidth;
        recoverSwipedItem();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return this.swipeThreshold;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        float f;
        List<MyButton> list;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int adapterPosition = viewHolder.getAdapterPosition();
        FamilyInvite familyInvite = this.currentList.get(adapterPosition);
        View itemView = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        if (adapterPosition < 0) {
            this.swipePosition = adapterPosition;
            return;
        }
        if (actionState != 1 || dX >= 0.0f) {
            f = dX;
        } else {
            ArrayList arrayList = new ArrayList();
            if (!this.buttonBuffer.containsKey(Integer.valueOf(adapterPosition))) {
                instantiateMyButton(viewHolder, arrayList, familyInvite);
                this.buttonBuffer.put(Integer.valueOf(adapterPosition), arrayList);
                list = arrayList;
            } else {
                List<MyButton> list2 = this.buttonBuffer.get(Integer.valueOf(adapterPosition));
                Intrinsics.checkNotNull(list2);
                list = list2;
            }
            float size = ((list.size() * dX) * this.buttonWidth) / itemView.getWidth();
            drawButton(c, itemView, list, adapterPosition, size);
            f = size;
        }
        super.onChildDraw(c, recyclerView, viewHolder, f, dY, actionState, isCurrentlyActive);
    }

    private final void drawButton(Canvas c, View itemView, List<MyButton> buffer, int pos, float translationX) {
        float right = itemView.getRight();
        float size = ((-1) * translationX) / buffer.size();
        Iterator<MyButton> it = buffer.iterator();
        while (it.hasNext()) {
            float f = right - size;
            it.next().onDraw(c, new RectF(f, itemView.getTop(), right, itemView.getBottom()), pos);
            right = f;
        }
    }
}
