package sputnik.axmor.com.sputnik.ui.main.profile.notifications;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.notifications.Notification;
import com.sputnik.domain.utils.DateUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemNotificationBinding;

/* compiled from: NotificationsAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/notifications/Notification;", "Lkotlin/Function1;", "", "onItemClick", "onLongItemClick", "", "locale", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "Lcom/sputnik/common/base/CustomViewHolder;", "holder", "", "position", "onBindViewHolder", "(Lcom/sputnik/common/base/CustomViewHolder;I)V", "Lkotlin/jvm/functions/Function1;", "getOnLongItemClick", "()Lkotlin/jvm/functions/Function1;", "Ljava/lang/String;", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsAdapter extends BaseAdapter<Notification> {
    private String locale;
    private final Function1<Notification, Unit> onLongItemClick;

    public /* synthetic */ NotificationsAdapter(Function1 function1, Function1 function12, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, (i & 4) != 0 ? AndroidConstants.INSTANCE.getPhoneLocale() : str);
    }

    public final void setLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.locale = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NotificationsAdapter(Function1<? super Notification, Unit> onItemClick, Function1<? super Notification, Unit> onLongItemClick, String locale) {
        super(R.layout.item_notification, onItemClick, 1, new NotificationsDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onLongItemClick, "onLongItemClick");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.onLongItemClick = onLongItemClick;
        this.locale = locale;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<Notification> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemNotificationBinding");
        ItemNotificationBinding itemNotificationBinding = (ItemNotificationBinding) binding;
        final Notification notification = getCurrentList().get(position);
        View root = holder.getBinding().getRoot();
        if (root != null) {
            root.setOnLongClickListener(new View.OnLongClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return NotificationsAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, notification, view);
                }
            });
        }
        Context context = holder.itemView.getContext();
        ConstraintLayout constraintLayout = itemNotificationBinding.constraintLayout6;
        Intrinsics.areEqual(notification.getIdentifier(), "blue");
        constraintLayout.setBackgroundResource(R.drawable.bg_badge_outline_12_green);
        TextView textView = itemNotificationBinding.tvType;
        Intrinsics.areEqual(notification.getIdentifier(), "blue");
        textView.setTextColor(ContextCompat.getColor(context, R.color.sputnik_green));
        TextView textView2 = itemNotificationBinding.entryPhone;
        String createdAt = notification.getCreatedAt();
        textView2.setText(createdAt != null ? DateUtilsKt.toDMYDigitsFormat(createdAt, this.locale) : null);
        if (Intrinsics.areEqual(notification.getViewed(), Boolean.TRUE)) {
            itemNotificationBinding.view.setBackgroundResource(R.drawable.ic_circle_outline);
            itemNotificationBinding.entryName.setTextColor(ContextCompat.getColor(holder.getBinding().getRoot().getContext(), R.color.track_gray));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$1$lambda$0(NotificationsAdapter this$0, Notification notification, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Notification, Unit> function1 = this$0.onLongItemClick;
        Intrinsics.checkNotNull(notification);
        function1.invoke(notification);
        return true;
    }
}
