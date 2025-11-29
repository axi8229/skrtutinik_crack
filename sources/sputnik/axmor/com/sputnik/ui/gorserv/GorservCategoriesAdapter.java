package sputnik.axmor.com.sputnik.ui.gorserv;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.gorserv.GorservCatalog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemGorservCategoryBinding;
import sputnik.axmor.com.sputnik.entities.gorserv.GorservCategoriesKt;

/* compiled from: GorservCategoriesAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/gorserv/GorservCategoriesAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/gorserv/GorservCatalog;", "Lkotlin/Function1;", "", "onItemClick", "", "locale", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "Lsputnik/axmor/com/databinding/ItemGorservCategoryBinding;", "binding", "item", "handleClick", "(Lsputnik/axmor/com/databinding/ItemGorservCategoryBinding;Lcom/sputnik/common/entities/gorserv/GorservCatalog;)V", "Lcom/sputnik/common/base/CustomViewHolder;", "holder", "", "position", "onBindViewHolder", "(Lcom/sputnik/common/base/CustomViewHolder;I)V", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/String;", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "GorservCategoryDiffCallback", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GorservCategoriesAdapter extends BaseAdapter<GorservCatalog> {
    private String locale;
    private final Function1<GorservCatalog, Unit> onItemClick;

    public /* synthetic */ GorservCategoriesAdapter(Function1 function1, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? AndroidConstants.INSTANCE.getPhoneLocale() : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GorservCategoriesAdapter(Function1<? super GorservCatalog, Unit> onItemClick, String locale) {
        super(R.layout.item_gorserv_category, onItemClick, 1, new GorservCategoryDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.onItemClick = onItemClick;
        this.locale = locale;
    }

    private final void handleClick(ItemGorservCategoryBinding binding, GorservCatalog item) {
        this.onItemClick.invoke(item);
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final CustomViewHolder<GorservCatalog> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemGorservCategoryBinding");
        final GorservCatalog gorservCatalog = getCurrentList().get(position);
        ((ItemGorservCategoryBinding) binding).ivIcon.setImageResource(GorservCategoriesKt.getIconForCategory(String.valueOf(gorservCatalog.getId())));
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.GorservCategoriesAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GorservCategoriesAdapter.onBindViewHolder$lambda$2$lambda$1(this.f$0, holder, gorservCatalog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$1(GorservCategoriesAdapter this$0, CustomViewHolder holder, GorservCatalog gorservCatalog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemGorservCategoryBinding");
        Intrinsics.checkNotNull(gorservCatalog);
        this$0.handleClick((ItemGorservCategoryBinding) binding, gorservCatalog);
    }

    /* compiled from: GorservCategoriesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/gorserv/GorservCategoriesAdapter$GorservCategoryDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/sputnik/common/entities/gorserv/GorservCatalog;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GorservCategoryDiffCallback extends DiffUtil.ItemCallback<GorservCatalog> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(GorservCatalog oldItem, GorservCatalog newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(GorservCatalog oldItem, GorservCatalog newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
