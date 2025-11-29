package sputnik.axmor.com.sputnik.ui.faq;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.faq.FaqItem;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemFaqCategoryBinding;

/* compiled from: FaqCategoriesAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/faq/FaqItem;", "onItemClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "handleClick", "item", "onBindViewHolder", "holder", "Lcom/sputnik/common/base/CustomViewHolder;", "position", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaqCategoriesAdapter extends BaseAdapter<FaqItem> {
    private final Function1<FaqItem, Unit> onItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaqCategoriesAdapter(Function1<? super FaqItem, Unit> onItemClick) {
        super(R.layout.item_faq_category, onItemClick, 1, new FaqCategoriesDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleClick(FaqItem item) {
        this.onItemClick.invoke(item);
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<FaqItem> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        final FaqItem faqItem = getCurrentList().get(position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemFaqCategoryBinding");
        View root = holder.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        SafeClickListenerKt.setSafeOnClickListener$default(root, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesAdapter$onBindViewHolder$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FaqCategoriesAdapter faqCategoriesAdapter = this.this$0;
                FaqItem item = faqItem;
                Intrinsics.checkNotNullExpressionValue(item, "$item");
                faqCategoriesAdapter.handleClick(item);
            }
        }, 1, null);
        ((ItemFaqCategoryBinding) binding).tvQuestion.setText(faqItem.getTitle());
    }
}
