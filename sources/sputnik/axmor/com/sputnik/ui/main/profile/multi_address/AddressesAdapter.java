package sputnik.axmor.com.sputnik.ui.main.profile.multi_address;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemAddressBinding;

/* compiled from: AddressesAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\rJ\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\rR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/AddressesAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/addresses/UserAddress;", "Lkotlin/Function1;", "", "onItemClicked", "onItemDeleteClicked", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "isEditorModeEnabled", "()Z", "switchEditorMode", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/sputnik/common/base/CustomViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/sputnik/common/base/CustomViewHolder;", "holder", "position", "onBindViewHolder", "(Lcom/sputnik/common/base/CustomViewHolder;I)V", "item", "select", "(Lcom/sputnik/common/entities/addresses/UserAddress;)V", "lockAddresses", "unlockAddresses", "Lkotlin/jvm/functions/Function1;", "inEditorMode", "Z", "isLocked", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddressesAdapter extends BaseAdapter<UserAddress> {
    private boolean inEditorMode;
    private boolean isLocked;
    private final Function1<UserAddress, Unit> onItemClicked;
    private final Function1<UserAddress, Unit> onItemDeleteClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AddressesAdapter(Function1<? super UserAddress, Unit> onItemClicked, Function1<? super UserAddress, Unit> onItemDeleteClicked) {
        super(R.layout.item_address, onItemClicked, 1, new KeysDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onItemDeleteClicked, "onItemDeleteClicked");
        this.onItemClicked = onItemClicked;
        this.onItemDeleteClicked = onItemDeleteClicked;
        this.isLocked = true;
    }

    /* renamed from: isEditorModeEnabled, reason: from getter */
    public final boolean getInEditorMode() {
        return this.inEditorMode;
    }

    public final void switchEditorMode() {
        this.inEditorMode = !this.inEditorMode;
        notifyDataSetChanged();
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder<UserAddress> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<UserAddress> holder, int position) {
        int i;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemAddressBinding");
        ItemAddressBinding itemAddressBinding = (ItemAddressBinding) binding;
        final UserAddress item = getItem(position);
        View root = itemAddressBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        SafeClickListenerKt.setSafeOnClickListener$default(root, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.AddressesAdapter$onBindViewHolder$1$1
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
                UserAddress item2 = item;
                Intrinsics.checkNotNullExpressionValue(item2, "$item");
                function1.invoke(item2);
            }
        }, 1, null);
        ImageView ivChecked = itemAddressBinding.ivChecked;
        Intrinsics.checkNotNullExpressionValue(ivChecked, "ivChecked");
        int i2 = 0;
        ViewBindingUtilsKt.visibilityHideBasedOn(ivChecked, item.getIsSelected() && !this.inEditorMode);
        ImageView btnUnbind = itemAddressBinding.btnUnbind;
        Intrinsics.checkNotNullExpressionValue(btnUnbind, "btnUnbind");
        ViewBindingUtilsKt.visibilityBasedOn(btnUnbind, Boolean.valueOf(this.inEditorMode));
        itemAddressBinding.btnUnbind.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.multi_address.AddressesAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressesAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, item, view);
            }
        });
        ConstraintLayout constraintLayout = itemAddressBinding.layoutItem;
        if (item.getIsSelected() && !this.inEditorMode) {
            i2 = R.drawable.background_card_blue_light;
        }
        constraintLayout.setBackgroundResource(i2);
        if (this.isLocked) {
            i = R.drawable.ic_item_locked;
        } else if (item.isFullyValidated()) {
            i = (!item.getIsSelected() || this.inEditorMode) ? R.drawable.ic_address_inactive : R.drawable.ic_address_active;
        } else {
            i = R.drawable.ic_address_not_verified;
        }
        itemAddressBinding.ivStatus.setImageResource(i);
        itemAddressBinding.tvAddress.setText(item.getFullAddressWithApartment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(AddressesAdapter this$0, UserAddress userAddress, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<UserAddress, Unit> function1 = this$0.onItemDeleteClicked;
        Intrinsics.checkNotNull(userAddress);
        function1.invoke(userAddress);
    }

    public final void select(UserAddress item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.isLocked) {
            return;
        }
        LogUtilsKt.writeLog("SELECT " + item);
        List<UserAddress> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List mutableList = CollectionsKt.toMutableList((Collection) currentList);
        Iterator it = mutableList.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((UserAddress) it.next()).getIsSelected()) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            Object obj = mutableList.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            UserAddress userAddress = (UserAddress) obj;
            mutableList.set(i2, userAddress.copy((479 & 1) != 0 ? userAddress.id : null, (479 & 2) != 0 ? userAddress.fullAddress : null, (479 & 4) != 0 ? userAddress.fullAddressWithApartment : null, (479 & 8) != 0 ? userAddress.addressVerificationRequired : null, (479 & 16) != 0 ? userAddress.apartment : null, (479 & 32) != 0 ? userAddress.isSelected : false, (479 & 64) != 0 ? userAddress.flatUUID : null, (479 & 128) != 0 ? userAddress.entryUUID : null, (479 & 256) != 0 ? userAddress.status : null));
        }
        Iterator it2 = mutableList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((UserAddress) it2.next()).getId(), item.getId())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            Object obj2 = mutableList.get(i);
            Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
            UserAddress userAddress2 = (UserAddress) obj2;
            mutableList.set(i, userAddress2.copy((479 & 1) != 0 ? userAddress2.id : null, (479 & 2) != 0 ? userAddress2.fullAddress : null, (479 & 4) != 0 ? userAddress2.fullAddressWithApartment : null, (479 & 8) != 0 ? userAddress2.addressVerificationRequired : null, (479 & 16) != 0 ? userAddress2.apartment : null, (479 & 32) != 0 ? userAddress2.isSelected : true, (479 & 64) != 0 ? userAddress2.flatUUID : null, (479 & 128) != 0 ? userAddress2.entryUUID : null, (479 & 256) != 0 ? userAddress2.status : null));
        }
        submitList(mutableList);
    }

    public final void lockAddresses() {
        this.isLocked = true;
        notifyDataSetChanged();
    }

    public final void unlockAddresses() {
        this.isLocked = false;
        notifyDataSetChanged();
    }
}
