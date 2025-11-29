package sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.VisitErrorItemBinding;

/* compiled from: CallHistoryStateAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryStateAdapter;", "Landroidx/paging/LoadStateAdapter;", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryStateAdapter$ItemViewHolder;", "errorRequest", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getErrorRequest", "()Lkotlin/jvm/functions/Function0;", "getStateViewType", "", "loadState", "Landroidx/paging/LoadState;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Companion", "ItemViewHolder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallHistoryStateAdapter extends LoadStateAdapter<ItemViewHolder> {
    private final Function0<Unit> errorRequest;

    public final Function0<Unit> getErrorRequest() {
        return this.errorRequest;
    }

    public CallHistoryStateAdapter(Function0<Unit> errorRequest) {
        Intrinsics.checkNotNullParameter(errorRequest, "errorRequest");
        this.errorRequest = errorRequest;
    }

    @Override // androidx.paging.LoadStateAdapter
    public int getStateViewType(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (loadState instanceof LoadState.NotLoading) {
            throw new IllegalStateException("Not supported");
        }
        if (Intrinsics.areEqual(loadState, LoadState.Loading.INSTANCE)) {
            return 0;
        }
        if (loadState instanceof LoadState.Error) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.paging.LoadStateAdapter
    public void onBindViewHolder(ItemViewHolder holder, LoadState loadState) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        holder.bindTo(loadState);
    }

    @Override // androidx.paging.LoadStateAdapter
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, LoadState loadState) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (Intrinsics.areEqual(loadState, LoadState.Loading.INSTANCE)) {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.visit_loading_item, parent, false);
            Intrinsics.checkNotNull(viewDataBindingInflate);
            return new ItemViewHolder(viewDataBindingInflate);
        }
        if (loadState instanceof LoadState.Error) {
            ViewDataBinding viewDataBindingInflate2 = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.visit_error_item, parent, false);
            Intrinsics.checkNotNull(viewDataBindingInflate2, "null cannot be cast to non-null type sputnik.axmor.com.databinding.VisitErrorItemBinding");
            AppCompatButton repeatButton = ((VisitErrorItemBinding) viewDataBindingInflate2).repeatButton;
            Intrinsics.checkNotNullExpressionValue(repeatButton, "repeatButton");
            SafeClickListenerKt.setSafeOnClickListener$default(repeatButton, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.adapter.CallHistoryStateAdapter$onCreateViewHolder$binding$1$1
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
                    this.this$0.getErrorRequest().invoke();
                }
            }, 1, null);
            Intrinsics.checkNotNull(viewDataBindingInflate2);
            return new ItemViewHolder(viewDataBindingInflate2);
        }
        if (loadState instanceof LoadState.NotLoading) {
            throw new IllegalStateException("Not supported");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: CallHistoryStateAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/adapter/CallHistoryStateAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "bindTo", "", "item", "Landroidx/paging/LoadState;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bindTo(LoadState item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.setVariable(1, item);
            this.binding.executePendingBindings();
        }
    }
}
