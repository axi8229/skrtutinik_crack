package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.keys.PhysicalKey;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemKeyBinding;

/* compiled from: KeysAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeysAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/keys/PhysicalKey;", "Lkotlin/Function1;", "", "onItemClicked", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/sputnik/common/base/CustomViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/sputnik/common/base/CustomViewHolder;", "holder", "position", "onBindViewHolder", "(Lcom/sputnik/common/base/CustomViewHolder;I)V", "Lkotlin/jvm/functions/Function1;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeysAdapter extends BaseAdapter<PhysicalKey> {
    private final Function1<PhysicalKey, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KeysAdapter(Function1<? super PhysicalKey, Unit> onItemClicked) {
        super(R.layout.item_key, onItemClicked, 1, new KeysDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder<PhysicalKey> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<PhysicalKey> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemKeyBinding");
        ItemKeyBinding itemKeyBinding = (ItemKeyBinding) binding;
        final PhysicalKey item = getItem(position);
        View root = itemKeyBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        SafeClickListenerKt.setSafeOnClickListener$default(root, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysAdapter$onBindViewHolder$1$1
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
                Function1 function1 = this.this$0.onItemClicked;
                PhysicalKey item2 = item;
                Intrinsics.checkNotNullExpressionValue(item2, "$item");
                function1.invoke(item2);
            }
        }, 1, null);
        itemKeyBinding.ivStatus.setImageResource(Intrinsics.areEqual(item.getBlocked(), Boolean.TRUE) ? R.drawable.ic_key_locked_rounded : R.drawable.ic_key_active_rounded);
    }
}
