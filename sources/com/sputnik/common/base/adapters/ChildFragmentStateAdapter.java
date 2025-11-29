package com.sputnik.common.base.adapters;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;
import com.sputnik.common.base.adapters.ChildFragmentStateAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChildFragmentStateAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/sputnik/common/base/adapters/ChildFragmentStateAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlin/Function0;", "", "onClickListener", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;)V", "Landroidx/viewpager2/adapter/FragmentViewHolder;", "holder", "", "position", "", "", "payloads", "onBindViewHolder", "(Landroidx/viewpager2/adapter/FragmentViewHolder;ILjava/util/List;)V", "Landroidx/fragment/app/Fragment;", "fragment", "addFragment", "(Landroidx/fragment/app/Fragment;)V", "getItemCount", "()I", "clear", "()V", "createFragment", "(I)Landroidx/fragment/app/Fragment;", "Lkotlin/jvm/functions/Function0;", "mFragments", "Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildFragmentStateAdapter extends FragmentStateAdapter {
    private final List<Fragment> mFragments;
    private Function0<Unit> onClickListener;

    public /* synthetic */ ChildFragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager, lifecycle, (i & 4) != 0 ? null : function0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((FragmentViewHolder) viewHolder, i, (List<Object>) list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChildFragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, Function0<Unit> function0) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.onClickListener = function0;
        this.mFragments = new ArrayList();
        registerFragmentTransactionCallback(new AnonymousClass1());
    }

    public void onBindViewHolder(FragmentViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder((ChildFragmentStateAdapter) holder, position, payloads);
        if (this.onClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.base.adapters.ChildFragmentStateAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChildFragmentStateAdapter.onBindViewHolder$lambda$0(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ChildFragmentStateAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* compiled from: ChildFragmentStateAdapter.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/sputnik/common/base/adapters/ChildFragmentStateAdapter$1", "Landroidx/viewpager2/adapter/FragmentStateAdapter$FragmentTransactionCallback;", "onFragmentMaxLifecyclePreUpdated", "Landroidx/viewpager2/adapter/FragmentStateAdapter$FragmentTransactionCallback$OnPostEventListener;", "fragment", "Landroidx/fragment/app/Fragment;", "maxLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.common.base.adapters.ChildFragmentStateAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends FragmentStateAdapter.FragmentTransactionCallback {
        AnonymousClass1() {
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter.FragmentTransactionCallback
        public FragmentStateAdapter.FragmentTransactionCallback.OnPostEventListener onFragmentMaxLifecyclePreUpdated(final Fragment fragment, Lifecycle.State maxLifecycleState) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(maxLifecycleState, "maxLifecycleState");
            if (maxLifecycleState == Lifecycle.State.RESUMED) {
                return new FragmentStateAdapter.FragmentTransactionCallback.OnPostEventListener() { // from class: com.sputnik.common.base.adapters.ChildFragmentStateAdapter$1$$ExternalSyntheticLambda0
                    @Override // androidx.viewpager2.adapter.FragmentStateAdapter.FragmentTransactionCallback.OnPostEventListener
                    public final void onPost() {
                        ChildFragmentStateAdapter.AnonymousClass1.onFragmentMaxLifecyclePreUpdated$lambda$1(fragment);
                    }
                };
            }
            FragmentStateAdapter.FragmentTransactionCallback.OnPostEventListener onPostEventListenerOnFragmentMaxLifecyclePreUpdated = super.onFragmentMaxLifecyclePreUpdated(fragment, maxLifecycleState);
            Intrinsics.checkNotNull(onPostEventListenerOnFragmentMaxLifecyclePreUpdated);
            return onPostEventListenerOnFragmentMaxLifecyclePreUpdated;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFragmentMaxLifecyclePreUpdated$lambda$1(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "$fragment");
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
            fragmentTransactionBeginTransaction.setPrimaryNavigationFragment(fragment);
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public final void addFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mFragments.add(fragment);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mFragments.size();
    }

    public final void clear() {
        this.mFragments.clear();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        return this.mFragments.get(position);
    }
}
