package com.sputnik.oboarding.ui.registration.adapter;

import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.sessions.LocalSession;
import com.sputnik.oboarding.BR;
import com.sputnik.oboarding.R$drawable;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.databinding.ItemAccountBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AccountsAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/adapter/AccountsAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/sessions/LocalSession;", "onItemClick", "Lkotlin/Function1;", "", "onItemDeleteClick", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "Lcom/sputnik/common/base/CustomViewHolder;", "position", "", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AccountsAdapter extends BaseAdapter<LocalSession> {
    private final Function1<LocalSession, Unit> onItemDeleteClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AccountsAdapter(Function1<? super LocalSession, Unit> onItemClick, Function1<? super LocalSession, Unit> onItemDeleteClick) {
        super(R$layout.item_account, onItemClick, BR.item, new AccountsDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemDeleteClick, "onItemDeleteClick");
        this.onItemDeleteClick = onItemDeleteClick;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<LocalSession> holder, int position) {
        String phone;
        byte[] bArrDecode;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.sputnik.oboarding.databinding.ItemAccountBinding");
        ItemAccountBinding itemAccountBinding = (ItemAccountBinding) binding;
        final LocalSession localSession = getCurrentList().get(position);
        TextView textView = itemAccountBinding.tvPhone;
        if (StringsKt.isBlank(localSession.getCountryCode())) {
            phone = localSession.getPhone();
        } else {
            phone = localSession.getCountryCode() + " " + localSession.getPhone();
        }
        textView.setText(phone);
        itemAccountBinding.ivDelete.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.adapter.AccountsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountsAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, localSession, view);
            }
        });
        try {
            bArrDecode = Base64.decode(localSession.getImage(), 0);
        } catch (Exception unused) {
            bArrDecode = null;
        }
        Glide.with(itemAccountBinding.getRoot()).load(bArrDecode).circleCrop().transform(new CenterInside(), new CenterCrop(), new RoundedCorners((int) ((12 * itemAccountBinding.getRoot().getContext().getResources().getDisplayMetrics().density) + 0.5f))).placeholder(R$drawable.ic_empty_account).into(itemAccountBinding.ivProfilePhoto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(AccountsAdapter this$0, LocalSession localSession, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<LocalSession, Unit> function1 = this$0.onItemDeleteClick;
        Intrinsics.checkNotNull(localSession);
        function1.invoke(localSession);
    }
}
