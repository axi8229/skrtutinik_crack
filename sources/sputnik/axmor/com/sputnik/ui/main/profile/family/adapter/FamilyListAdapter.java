package sputnik.axmor.com.sputnik.ui.main.profile.family.adapter;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemFamilyListBinding;
import sputnik.axmor.com.sputnik.entities.family.Family;

/* compiled from: FamilyListAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/adapter/FamilyListAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lsputnik/axmor/com/sputnik/entities/family/Family;", "selfTitle", "", "adminTitle", "onItemClicked", "Lkotlin/Function1;", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "Lcom/sputnik/common/base/CustomViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyListAdapter extends BaseAdapter<Family> {
    private final String adminTitle;
    private final String selfTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyListAdapter(String str, String str2, Function1<? super Family, Unit> onItemClicked) {
        super(R.layout.item_family_list, onItemClicked, 1, new FamilyDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.selfTitle = str;
        this.adminTitle = str2;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    public CustomViewHolder<Family> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CustomViewHolder<Family> customViewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
        ViewDataBinding binding = customViewHolderOnCreateViewHolder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemFamilyListBinding");
        ItemFamilyListBinding itemFamilyListBinding = (ItemFamilyListBinding) binding;
        itemFamilyListBinding.isSelf.setText("(" + this.selfTitle + ")");
        itemFamilyListBinding.isAdmin.setText("(" + this.adminTitle + ")");
        return customViewHolderOnCreateViewHolder;
    }
}
