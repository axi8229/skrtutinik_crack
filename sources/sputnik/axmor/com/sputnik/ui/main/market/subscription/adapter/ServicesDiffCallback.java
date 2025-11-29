package sputnik.axmor.com.sputnik.ui.main.market.subscription.adapter;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServicesAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J@\u0010\u0006\u001a\u00020\u00072\u001a\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00042\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u0004H\u0016J@\u0010\n\u001a\u00020\u00072\u001a\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00042\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServicesDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lkotlin/Pair;", "", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/adapter/ServiceElem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesDiffCallback extends DiffUtil.ItemCallback<Pair<? extends String, ? extends String>> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areContentsTheSame(Pair<? extends String, ? extends String> pair, Pair<? extends String, ? extends String> pair2) {
        return areContentsTheSame2((Pair<String, String>) pair, (Pair<String, String>) pair2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areItemsTheSame(Pair<? extends String, ? extends String> pair, Pair<? extends String, ? extends String> pair2) {
        return areItemsTheSame2((Pair<String, String>) pair, (Pair<String, String>) pair2);
    }

    /* renamed from: areItemsTheSame, reason: avoid collision after fix types in other method */
    public boolean areItemsTheSame2(Pair<String, String> oldItem, Pair<String, String> newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.getFirst(), newItem.getFirst());
    }

    /* renamed from: areContentsTheSame, reason: avoid collision after fix types in other method */
    public boolean areContentsTheSame2(Pair<String, String> oldItem, Pair<String, String> newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem, newItem);
    }
}
