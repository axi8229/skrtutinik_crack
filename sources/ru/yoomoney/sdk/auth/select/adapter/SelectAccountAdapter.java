package ru.yoomoney.sdk.auth.select.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.ui.ItemImageRoundIconServicesView;
import ru.yoomoney.sdk.gui.widget.headline.HeadlinePrimaryLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemImageRoundDetailView;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001B;\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/select/adapter/SelectAccountAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountItem;", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountViewHolder;", "onCreate", "Lkotlin/Function0;", "", "onSelect", "Lkotlin/Function1;", "", "onMigrate", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectAccountAdapter extends ListAdapter<SelectAccountItem, SelectAccountViewHolder<?>> {
    private final Function0<Unit> onCreate;
    private final Function1<String, Unit> onMigrate;
    private final Function1<String, Unit> onSelect;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SelectAccountItemType.values().length];
            try {
                iArr[SelectAccountItemType.NEW_ACCOUNT_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectAccountItemType.HEADER_ITEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SelectAccountItemType.ACCOUNT_ITEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectAccountAdapter(Function0<Unit> onCreate, Function1<? super String, Unit> onSelect, Function1<? super String, Unit> onMigrate) {
        super(new SelectAccountDiffUtil());
        Intrinsics.checkNotNullParameter(onCreate, "onCreate");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Intrinsics.checkNotNullParameter(onMigrate, "onMigrate");
        this.onCreate = onCreate;
        this.onSelect = onSelect;
        this.onMigrate = onMigrate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SelectAccountAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCreate.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(SelectAccountAdapter this$0, SelectAccountItem selectAccountItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onMigrate.invoke(((AccountItem) selectAccountItem).getAccount().getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(SelectAccountAdapter this$0, SelectAccountItem selectAccountItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onSelect.invoke(((AccountItem) selectAccountItem).getAccount().getUid());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        SelectAccountItemType selectAccountItemType;
        SelectAccountItem item = getItem(position);
        if (item instanceof NewAccountItem) {
            selectAccountItemType = SelectAccountItemType.NEW_ACCOUNT_ITEM;
        } else if (item instanceof HeaderItem) {
            selectAccountItemType = SelectAccountItemType.HEADER_ITEM;
        } else {
            if (!(item instanceof AccountItem)) {
                throw new NoWhenBranchMatchedException();
            }
            selectAccountItemType = SelectAccountItemType.ACCOUNT_ITEM;
        }
        return selectAccountItemType.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SelectAccountViewHolder<?> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final SelectAccountItem item = getItem(position);
        if (item instanceof NewAccountItem) {
            ((NewAccountHolder) holder).bind((NewAccountItem) item);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.select.adapter.SelectAccountAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectAccountAdapter.onBindViewHolder$lambda$0(this.f$0, view);
                }
            });
        } else if (item instanceof HeaderItem) {
            ((HeaderHolder) holder).bind((HeaderItem) item);
        } else if (item instanceof AccountItem) {
            AccountItem accountItem = (AccountItem) item;
            ((AccountHolder) holder).bind(accountItem);
            holder.itemView.setOnClickListener(Intrinsics.areEqual(accountItem.getAccount().getMigrationRequired(), Boolean.TRUE) ? new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.select.adapter.SelectAccountAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectAccountAdapter.onBindViewHolder$lambda$1(this.f$0, item, view);
                }
            } : new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.select.adapter.SelectAccountAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectAccountAdapter.onBindViewHolder$lambda$2(this.f$0, item, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectAccountViewHolder<?> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        int i = WhenMappings.$EnumSwitchMapping$0[SelectAccountItemType.values()[viewType].ordinal()];
        if (i == 1) {
            Intrinsics.checkNotNull(context);
            return new NewAccountHolder(new ItemImageRoundDetailView(context, null, 0, 6, null));
        }
        if (i == 2) {
            Intrinsics.checkNotNull(context);
            return new HeaderHolder(new HeadlinePrimaryLargeView(context, null, 0, 6, null));
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(context);
        return new AccountHolder(new ItemImageRoundIconServicesView(context, null, 0, 6, null));
    }
}
