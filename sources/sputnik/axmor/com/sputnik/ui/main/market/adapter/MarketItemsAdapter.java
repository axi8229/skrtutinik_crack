package sputnik.axmor.com.sputnik.ui.main.market.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bumptech.glide.Glide;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseViewHolder;
import com.sputnik.common.entities.market.items.MarketItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.ItemMarketElementBinding;
import sputnik.axmor.com.databinding.ItemMarketKeyBinding;

/* compiled from: MarketKeysAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0003\u0016\u0017\u0018B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/MarketItemsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/sputnik/common/entities/market/items/MarketItem;", "Lcom/sputnik/common/base/BaseViewHolder;", "onItemClicked", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewHolderCreated", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "ItemTypes", "MarketElementViewHolder", "MarketKeyViewHolder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MarketItemsAdapter extends ListAdapter<MarketItem, BaseViewHolder<MarketItem>> {
    private final Function1<MarketItem, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MarketItemsAdapter(Function1<? super MarketItem, Unit> onItemClicked) {
        super(new MarketKeysDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<MarketItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder<MarketItem> marketKeyViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == ItemTypes.GENERAL.getValue()) {
            ItemMarketElementBinding itemMarketElementBindingInflate = ItemMarketElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(itemMarketElementBindingInflate, "inflate(...)");
            marketKeyViewHolder = new MarketElementViewHolder(this, itemMarketElementBindingInflate);
        } else {
            ItemMarketKeyBinding itemMarketKeyBindingInflate = ItemMarketKeyBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(itemMarketKeyBindingInflate, "inflate(...)");
            marketKeyViewHolder = new MarketKeyViewHolder(this, itemMarketKeyBindingInflate);
        }
        onViewHolderCreated(marketKeyViewHolder, marketKeyViewHolder.getBinding());
        return marketKeyViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return (Intrinsics.areEqual(getCurrentList().get(position).getIdentifier(), "licensed_keys") ? ItemTypes.LICENSED_KEYS : ItemTypes.GENERAL).getValue();
    }

    private final void onViewHolderCreated(final RecyclerView.ViewHolder viewHolder, ViewBinding binding) {
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.adapter.MarketItemsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MarketItemsAdapter.onViewHolderCreated$lambda$1(this.f$0, viewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewHolderCreated$lambda$1(MarketItemsAdapter this$0, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        MarketItem item = this$0.getItem(viewHolder.getBindingAdapterPosition());
        Function1<MarketItem, Unit> function1 = this$0.onItemClicked;
        Intrinsics.checkNotNull(item);
        function1.invoke(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder<MarketItem> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MarketItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bindTo(item);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: MarketKeysAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/MarketItemsAdapter$ItemTypes;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "GENERAL", "LICENSED_KEYS", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ItemTypes {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ItemTypes[] $VALUES;
        public static final ItemTypes GENERAL = new ItemTypes("GENERAL", 0, 0);
        public static final ItemTypes LICENSED_KEYS = new ItemTypes("LICENSED_KEYS", 1, 1);
        private final int value;

        private static final /* synthetic */ ItemTypes[] $values() {
            return new ItemTypes[]{GENERAL, LICENSED_KEYS};
        }

        public static ItemTypes valueOf(String str) {
            return (ItemTypes) Enum.valueOf(ItemTypes.class, str);
        }

        public static ItemTypes[] values() {
            return (ItemTypes[]) $VALUES.clone();
        }

        private ItemTypes(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            ItemTypes[] itemTypesArr$values = $values();
            $VALUES = itemTypesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(itemTypesArr$values);
        }
    }

    /* compiled from: MarketKeysAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/MarketItemsAdapter$MarketKeyViewHolder;", "Lcom/sputnik/common/base/BaseViewHolder;", "Lcom/sputnik/common/entities/market/items/MarketItem;", "binding", "Lsputnik/axmor/com/databinding/ItemMarketKeyBinding;", "(Lsputnik/axmor/com/sputnik/ui/main/market/adapter/MarketItemsAdapter;Lsputnik/axmor/com/databinding/ItemMarketKeyBinding;)V", "getBinding", "()Lsputnik/axmor/com/databinding/ItemMarketKeyBinding;", "bindTo", "", "item", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class MarketKeyViewHolder extends BaseViewHolder<MarketItem> {
        private final ItemMarketKeyBinding binding;
        final /* synthetic */ MarketItemsAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public MarketKeyViewHolder(MarketItemsAdapter marketItemsAdapter, ItemMarketKeyBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = marketItemsAdapter;
            View root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.binding = binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public ItemMarketKeyBinding getBinding() {
            return this.binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public void bindTo(MarketItem item) {
            MarketItem.MarketItemAppearance.TextTitle finale;
            String title;
            List<String> featuresList;
            String title2;
            Intrinsics.checkNotNullParameter(item, "item");
            ItemMarketKeyBinding binding = getBinding();
            MarketItem.MarketItemAppearance appearance = item.getAppearance();
            if (appearance != null && (title2 = appearance.getTitle()) != null) {
                binding.tvTitle.setText(title2);
            }
            MarketItem.MarketItemAppearance appearance2 = item.getAppearance();
            if (appearance2 != null && (featuresList = appearance2.getFeaturesList()) != null) {
                binding.tvSubtitle.setText(CollectionsKt.joinToString$default(featuresList, "\n• ", "• ", null, 0, null, null, 60, null));
            }
            MarketItem.MarketItemAppearance appearance3 = item.getAppearance();
            if (appearance3 == null || (finale = appearance3.getFinale()) == null || (title = finale.getTitle()) == null) {
                return;
            }
            binding.tvOpenCatalog.setText(title);
        }
    }

    /* compiled from: MarketKeysAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/MarketItemsAdapter$MarketElementViewHolder;", "Lcom/sputnik/common/base/BaseViewHolder;", "Lcom/sputnik/common/entities/market/items/MarketItem;", "binding", "Lsputnik/axmor/com/databinding/ItemMarketElementBinding;", "(Lsputnik/axmor/com/sputnik/ui/main/market/adapter/MarketItemsAdapter;Lsputnik/axmor/com/databinding/ItemMarketElementBinding;)V", "getBinding", "()Lsputnik/axmor/com/databinding/ItemMarketElementBinding;", "bindTo", "", "item", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class MarketElementViewHolder extends BaseViewHolder<MarketItem> {
        private final ItemMarketElementBinding binding;
        final /* synthetic */ MarketItemsAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public MarketElementViewHolder(MarketItemsAdapter marketItemsAdapter, ItemMarketElementBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = marketItemsAdapter;
            View root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.binding = binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public ItemMarketElementBinding getBinding() {
            return this.binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public void bindTo(MarketItem item) {
            String imageLink;
            MarketItem.MarketItemAppearance.TextTitle finale;
            String title;
            String title2;
            Intrinsics.checkNotNullParameter(item, "item");
            ItemMarketElementBinding binding = getBinding();
            MarketItem.MarketItemAppearance appearance = item.getAppearance();
            if (appearance != null && (title2 = appearance.getTitle()) != null) {
                binding.tvTitle.setText(title2);
            }
            MarketItem.MarketItemAppearance appearance2 = item.getAppearance();
            if (appearance2 != null && (finale = appearance2.getFinale()) != null && (title = finale.getTitle()) != null) {
                binding.tvOpenCatalog.setText(title);
            }
            MarketItem.MarketItemAppearance appearance3 = item.getAppearance();
            if (appearance3 == null || (imageLink = appearance3.getImageLink()) == null) {
                return;
            }
            Glide.with(this.itemView.getContext()).load(imageLink).into(binding.imageView23);
        }
    }
}
