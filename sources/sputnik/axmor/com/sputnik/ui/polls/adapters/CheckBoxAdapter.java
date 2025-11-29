package sputnik.axmor.com.sputnik.ui.polls.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: CheckBoxAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007J\u001e\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lsputnik/axmor/com/sputnik/ui/polls/adapters/ReasonItem;", "callback", "Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter$AppPollCallback;", "(Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter$AppPollCallback;)V", "getSelectedItems", "", "onBindViewHolder", "", "holder", "Lcom/sputnik/common/base/CustomViewHolder;", "position", "", "select", "item", "container", "Landroid/view/ViewGroup;", "textView", "Landroid/widget/TextView;", "update", "", "AppPollCallback", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckBoxAdapter extends BaseAdapter<ReasonItem> {
    private final AppPollCallback callback;

    /* compiled from: CheckBoxAdapter.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.polls.adapters.CheckBoxAdapter$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ReasonItem, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, AppPollCallback.class, "onItemClick", "onItemClick(Lsputnik/axmor/com/sputnik/ui/polls/adapters/ReasonItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReasonItem reasonItem) {
            invoke2(reasonItem);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReasonItem p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AppPollCallback) this.receiver).onItemClick(p0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckBoxAdapter(AppPollCallback callback) {
        super(R.layout.item_poll_reason, new AnonymousClass1(callback), 1, new ReasonItemDiffCallback());
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public static /* synthetic */ void select$default(CheckBoxAdapter checkBoxAdapter, ReasonItem reasonItem, ViewGroup viewGroup, TextView textView, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        checkBoxAdapter.select(reasonItem, viewGroup, textView, z);
    }

    public final void select(ReasonItem item, ViewGroup container, TextView textView, boolean update) {
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(textView, "textView");
        List<ReasonItem> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List mutableList = CollectionsKt.toMutableList((Collection) currentList);
        int iIndexOf = mutableList.indexOf(item);
        ReasonItem item2 = getItem(iIndexOf);
        item2.setChecked(!item2.getIsChecked());
        mutableList.set(iIndexOf, item2);
        submitList(mutableList);
        boolean isChecked = item2.getIsChecked();
        BaseOpenDoorWidget.Companion companion = BaseOpenDoorWidget.INSTANCE;
        int color = ContextCompat.getColor(companion.getContext(), isChecked ? R.color.sputnik_blue : R.color.track_gray);
        container.setBackground(ContextCompat.getDrawable(companion.getContext(), isChecked ? R.drawable.bg_poll_reason_blue : R.drawable.bg_poll_reason));
        textView.setTextColor(color);
        if (isChecked) {
            if (Intrinsics.areEqual(item.getIdentifier(), "1")) {
                this.callback.onAction(AppPollCallback.AppPollActions.SHOW_OTHER_REASON);
            }
        } else if (Intrinsics.areEqual(item.getIdentifier(), "1")) {
            this.callback.onAction(AppPollCallback.AppPollActions.HIDE_OTHER_REASON);
        }
        if (update) {
            notifyDataSetChanged();
        }
        Iterator it = mutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((ReasonItem) next).getIsChecked()) {
                    break;
                }
            }
        }
        if (next == null) {
            this.callback.onAction(AppPollCallback.AppPollActions.LOCK_BUTTON);
        } else {
            this.callback.onAction(AppPollCallback.AppPollActions.UNLOCK_BUTTON);
        }
        this.callback.onItemClick(item);
    }

    public final List<ReasonItem> getSelectedItems() {
        List<ReasonItem> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentList) {
            if (((ReasonItem) obj).getIsChecked()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<ReasonItem> holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        final CheckBox checkBox = (CheckBox) holder.itemView.findViewById(R.id.cb_checked);
        final TextView textView = (TextView) holder.itemView.findViewById(R.id.tv_selected_category_title);
        final ConstraintLayout constraintLayout = (ConstraintLayout) holder.itemView.findViewById(R.id.layout_content);
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.polls.adapters.CheckBoxAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckBoxAdapter.onBindViewHolder$lambda$3(this.f$0, position, constraintLayout, checkBox, view);
            }
        });
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.polls.adapters.CheckBoxAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckBoxAdapter.onBindViewHolder$lambda$4(this.f$0, position, constraintLayout, textView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(CheckBoxAdapter this$0, int i, ConstraintLayout constraintLayout, CheckBox checkBox, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReasonItem item = this$0.getItem(i);
        Intrinsics.checkNotNull(item);
        Intrinsics.checkNotNull(constraintLayout);
        Intrinsics.checkNotNull(checkBox);
        select$default(this$0, item, constraintLayout, checkBox, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(CheckBoxAdapter this$0, int i, ConstraintLayout constraintLayout, TextView textView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReasonItem item = this$0.getItem(i);
        Intrinsics.checkNotNull(item);
        Intrinsics.checkNotNull(constraintLayout);
        Intrinsics.checkNotNull(textView);
        this$0.select(item, constraintLayout, textView, true);
    }

    /* compiled from: CheckBoxAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter$AppPollCallback;", "", "onAction", "", "action", "Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter$AppPollCallback$AppPollActions;", "onItemClick", "item", "Lsputnik/axmor/com/sputnik/ui/polls/adapters/ReasonItem;", "AppPollActions", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AppPollCallback {
        void onAction(AppPollActions action);

        void onItemClick(ReasonItem item);

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: CheckBoxAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter$AppPollCallback$AppPollActions;", "", "(Ljava/lang/String;I)V", "LOCK_BUTTON", "UNLOCK_BUTTON", "SHOW_OTHER_REASON", "HIDE_OTHER_REASON", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class AppPollActions {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ AppPollActions[] $VALUES;
            public static final AppPollActions LOCK_BUTTON = new AppPollActions("LOCK_BUTTON", 0);
            public static final AppPollActions UNLOCK_BUTTON = new AppPollActions("UNLOCK_BUTTON", 1);
            public static final AppPollActions SHOW_OTHER_REASON = new AppPollActions("SHOW_OTHER_REASON", 2);
            public static final AppPollActions HIDE_OTHER_REASON = new AppPollActions("HIDE_OTHER_REASON", 3);

            private static final /* synthetic */ AppPollActions[] $values() {
                return new AppPollActions[]{LOCK_BUTTON, UNLOCK_BUTTON, SHOW_OTHER_REASON, HIDE_OTHER_REASON};
            }

            public static AppPollActions valueOf(String str) {
                return (AppPollActions) Enum.valueOf(AppPollActions.class, str);
            }

            public static AppPollActions[] values() {
                return (AppPollActions[]) $VALUES.clone();
            }

            private AppPollActions(String str, int i) {
            }

            static {
                AppPollActions[] appPollActionsArr$values = $values();
                $VALUES = appPollActionsArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(appPollActionsArr$values);
            }
        }
    }
}
