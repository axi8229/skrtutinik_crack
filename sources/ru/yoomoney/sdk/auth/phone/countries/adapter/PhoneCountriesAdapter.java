package ru.yoomoney.sdk.auth.phone.countries.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/adapter/PhoneCountriesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "Lru/yoomoney/sdk/auth/phone/countries/adapter/PhoneCountriesHolder;", "selected", "onItemClick", "Lkotlin/Function1;", "", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneCountriesAdapter extends ListAdapter<CountryCallingCode, PhoneCountriesHolder> {
    private final Function1<CountryCallingCode, Unit> onItemClick;
    private final CountryCallingCode selected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PhoneCountriesAdapter(CountryCallingCode selected, Function1<? super CountryCallingCode, Unit> onItemClick) {
        super(new PhoneCountriesDiffUtil());
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.selected = selected;
        this.onItemClick = onItemClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(PhoneCountriesAdapter this$0, CountryCallingCode countryCallingCode, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<CountryCallingCode, Unit> function1 = this$0.onItemClick;
        Intrinsics.checkNotNull(countryCallingCode);
        function1.invoke(countryCallingCode);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PhoneCountriesHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CountryCallingCode item = getItem(position);
        holder.bind(item.getTitle(), Intrinsics.areEqual(item, this.selected));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.countries.adapter.PhoneCountriesAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneCountriesAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, item, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PhoneCountriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNull(context);
        return new PhoneCountriesHolder(new ItemIconView(context, null, 0, 6, null));
    }
}
