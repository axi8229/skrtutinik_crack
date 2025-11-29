package sputnik.axmor.com.sputnik.ui.main.profile.family.adapter;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.invites.FamilyInvite;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;

/* compiled from: FamilyInvitesAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0010"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/adapter/FamilyInvitesAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/invites/FamilyInvite;", "Lkotlin/Function1;", "", "onItemClicked", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/sputnik/common/base/CustomViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/sputnik/common/base/CustomViewHolder;", "Lkotlin/jvm/functions/Function1;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyInvitesAdapter extends BaseAdapter<FamilyInvite> {
    private final Function1<FamilyInvite, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FamilyInvitesAdapter(Function1<? super FamilyInvite, Unit> onItemClicked) {
        super(R.layout.item_family_invite_list, onItemClicked, 1, new FamilyInviteDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    public CustomViewHolder<FamilyInvite> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CustomViewHolder<FamilyInvite> customViewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
        ViewDataBinding binding = customViewHolderOnCreateViewHolder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemFamilyInviteListBinding");
        return customViewHolderOnCreateViewHolder;
    }
}
