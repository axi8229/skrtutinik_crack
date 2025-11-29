package sputnik.axmor.com.sputnik.ui.main.market.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bumptech.glide.Glide;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GorservEvents;
import com.sputnik.common.base.BaseViewHolder;
import com.sputnik.common.entities.services.OuterService;
import com.sputnik.common.entities.services.OuterServiceAppearance;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.domain.entities.market.OuterServiceTypes;
import com.sputnik.domain.entities.market.services.OriginType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.InsuranceServiceItemBinding;
import sputnik.axmor.com.databinding.ItemServiceGorservBinding;
import sputnik.axmor.com.sputnik.entities.company.Company;

/* compiled from: ServicesAdapter.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0004)*+,B[\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0014\u0010\u0018\u001a\u00060\u0019R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0014\u0010\u001c\u001a\u00060\u001dR\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0014\u0010\u001e\u001a\u00060\u001fR\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010 \u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\nH\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/sputnik/common/entities/services/OuterService;", "Lcom/sputnik/common/base/BaseViewHolder;", "company", "Lsputnik/axmor/com/sputnik/entities/company/Company;", "partner", "", "onItemClicked", "Lkotlin/Function2;", "", "", "url", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "(Lsputnik/axmor/com/sputnik/entities/company/Company;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/LifecycleOwner;Lcom/sputnik/common/analytics/Analytics;)V", "getOnItemClicked", "()Lkotlin/jvm/functions/Function2;", "getItemViewType", "position", "initBillViewHolder", "Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter$BillViewHolder;", "parent", "Landroid/view/ViewGroup;", "initCustomViewHolder", "Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter$CustomViewHolder;", "initGorservViewHolder", "Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter$GorservViewHolder;", "onBindViewHolder", "holder", "onCreateViewHolder", "viewType", "onViewHolderCreated", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "BillViewHolder", "Companion", "CustomViewHolder", "GorservViewHolder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesAdapter extends ListAdapter<OuterService, BaseViewHolder<OuterService>> {
    private final Analytics analytics;
    private final FragmentManager childFragmentManager;
    private final Company company;
    private final LifecycleOwner lifecycleOwner;
    private final Function2<OuterService, Integer, Unit> onItemClicked;
    private final String partner;
    private final String url;

    /* compiled from: ServicesAdapter.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OuterServiceTypes.values().length];
            try {
                iArr[OuterServiceTypes.bill.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OuterServiceTypes.customization_product.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OuterServiceTypes.our_service.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OuterServiceTypes.gorserv_product.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ ServicesAdapter(Company company, String str, Function2 function2, String str2, FragmentManager fragmentManager, LifecycleOwner lifecycleOwner, Analytics analytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : company, (i & 2) != 0 ? null : str, function2, (i & 8) != 0 ? null : str2, fragmentManager, lifecycleOwner, analytics);
    }

    public final Function2<OuterService, Integer, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ServicesAdapter(Company company, String str, Function2<? super OuterService, ? super Integer, Unit> onItemClicked, String str2, FragmentManager childFragmentManager, LifecycleOwner lifecycleOwner, Analytics analytics) {
        super(new OuterServiceDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(childFragmentManager, "childFragmentManager");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.company = company;
        this.partner = str;
        this.onItemClicked = onItemClicked;
        this.url = str2;
        this.childFragmentManager = childFragmentManager;
        this.lifecycleOwner = lifecycleOwner;
        this.analytics = analytics;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<OuterService> onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder<OuterService> baseViewHolderInitBillViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1 || viewType == 2) {
            baseViewHolderInitBillViewHolder = initBillViewHolder(parent);
        } else if (viewType == 111) {
            baseViewHolderInitBillViewHolder = initGorservViewHolder(parent);
        } else {
            baseViewHolderInitBillViewHolder = initCustomViewHolder(parent);
        }
        onViewHolderCreated(baseViewHolderInitBillViewHolder, baseViewHolderInitBillViewHolder.getBinding());
        return baseViewHolderInitBillViewHolder;
    }

    private final BillViewHolder initBillViewHolder(ViewGroup parent) {
        InsuranceServiceItemBinding insuranceServiceItemBindingInflate = InsuranceServiceItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(insuranceServiceItemBindingInflate, "inflate(...)");
        return new BillViewHolder(this, insuranceServiceItemBindingInflate);
    }

    private final CustomViewHolder initCustomViewHolder(ViewGroup parent) {
        InsuranceServiceItemBinding insuranceServiceItemBindingInflate = InsuranceServiceItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(insuranceServiceItemBindingInflate, "inflate(...)");
        return new CustomViewHolder(this, insuranceServiceItemBindingInflate);
    }

    private final GorservViewHolder initGorservViewHolder(ViewGroup parent) {
        this.analytics.trackLogEvent(new GorservEvents.ShowSlider());
        ItemServiceGorservBinding itemServiceGorservBindingInflate = ItemServiceGorservBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemServiceGorservBindingInflate, "inflate(...)");
        return new GorservViewHolder(this, itemServiceGorservBindingInflate);
    }

    private final void onViewHolderCreated(final RecyclerView.ViewHolder viewHolder, ViewBinding binding) {
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.adapter.ServicesAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServicesAdapter.onViewHolderCreated$lambda$1(this.f$0, viewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewHolderCreated$lambda$1(ServicesAdapter this$0, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        OuterService item = this$0.getItem(viewHolder.getBindingAdapterPosition());
        Function2<OuterService, Integer, Unit> function2 = this$0.onItemClicked;
        Intrinsics.checkNotNull(item);
        function2.invoke(item, Integer.valueOf(this$0.getItemViewType(viewHolder.getBindingAdapterPosition())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        OuterServiceTypes type = getItem(position).getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 3;
        }
        return i != 4 ? 2 : 111;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder<OuterService> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        OuterService item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bindTo(item);
    }

    /* compiled from: ServicesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter$BillViewHolder;", "Lcom/sputnik/common/base/BaseViewHolder;", "Lcom/sputnik/common/entities/services/OuterService;", "binding", "Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;", "(Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter;Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;)V", "getBinding", "()Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;", "bindTo", "", "item", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class BillViewHolder extends BaseViewHolder<OuterService> {
        private final InsuranceServiceItemBinding binding;
        final /* synthetic */ ServicesAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public BillViewHolder(ServicesAdapter servicesAdapter, InsuranceServiceItemBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = servicesAdapter;
            View root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.binding = binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public InsuranceServiceItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public void bindTo(OuterService item) {
            Intrinsics.checkNotNullParameter(item, "item");
            InsuranceServiceItemBinding binding = getBinding();
            TextView tvLabel = binding.tvLabel;
            Intrinsics.checkNotNullExpressionValue(tvLabel, "tvLabel");
            ViewBindingUtilsKt.visibilityBasedOn(tvLabel, Boolean.FALSE);
            if (item.getAppearance() != null) {
                TextView textView = binding.tvLabel;
                OuterServiceAppearance appearance = item.getAppearance();
                textView.setText(appearance != null ? appearance.getTitle() : null);
                binding.tvLabel.setBackgroundTintList(ContextCompat.getColorStateList(this.itemView.getContext(), R.color.sputnik_blue));
            }
            TextView textView2 = binding.serviceName;
            OuterServiceAppearance appearance2 = item.getAppearance();
            textView2.setText(appearance2 != null ? appearance2.getTitle() : null);
            TextView textView3 = binding.serviceDescription;
            OuterServiceAppearance appearance3 = item.getAppearance();
            textView3.setText(appearance3 != null ? appearance3.getDescription() : null);
            TextView textView4 = binding.serviceAction;
            OuterServiceAppearance appearance4 = item.getAppearance();
            textView4.setText(appearance4 != null ? appearance4.getFinale() : null);
        }
    }

    /* compiled from: ServicesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter$CustomViewHolder;", "Lcom/sputnik/common/base/BaseViewHolder;", "Lcom/sputnik/common/entities/services/OuterService;", "binding", "Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;", "(Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter;Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;)V", "getBinding", "()Lsputnik/axmor/com/databinding/InsuranceServiceItemBinding;", "bindTo", "", "item", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class CustomViewHolder extends BaseViewHolder<OuterService> {
        private final InsuranceServiceItemBinding binding;
        final /* synthetic */ ServicesAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public CustomViewHolder(ServicesAdapter servicesAdapter, InsuranceServiceItemBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = servicesAdapter;
            View root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.binding = binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public InsuranceServiceItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public void bindTo(OuterService item) {
            Intrinsics.checkNotNullParameter(item, "item");
            InsuranceServiceItemBinding binding = getBinding();
            ServicesAdapter servicesAdapter = this.this$0;
            TextView tvLabel = binding.tvLabel;
            Intrinsics.checkNotNullExpressionValue(tvLabel, "tvLabel");
            ViewKt.gone(tvLabel);
            TextView textView = binding.serviceName;
            OuterServiceAppearance appearance = item.getAppearance();
            textView.setText(appearance != null ? appearance.getTitle() : null);
            TextView textView2 = binding.serviceDescription;
            OuterServiceAppearance appearance2 = item.getAppearance();
            textView2.setText(appearance2 != null ? appearance2.getDescription() : null);
            TextView textView3 = binding.serviceAction;
            OuterServiceAppearance appearance3 = item.getAppearance();
            textView3.setText(appearance3 != null ? appearance3.getFinale() : null);
            binding.tvPartnerLabel.setText(servicesAdapter.partner);
            if (OriginType.company != null && servicesAdapter.url != null) {
                Glide.with(this.itemView.getContext()).load(servicesAdapter.url).circleCrop().into(binding.ivPartner);
                ImageView ivPartner = binding.ivPartner;
                Intrinsics.checkNotNullExpressionValue(ivPartner, "ivPartner");
                ViewKt.visible(ivPartner);
            }
            TextView tvPartnerLabel = binding.tvPartnerLabel;
            Intrinsics.checkNotNullExpressionValue(tvPartnerLabel, "tvPartnerLabel");
            ViewBindingUtilsKt.visibilityBasedOn(tvPartnerLabel, Boolean.valueOf(!Intrinsics.areEqual(item.getIdentifier(), AndroidConstants.ServicesNames.INSTANCE.getINSTALL_SPUTNIK_IDENTIFIER())));
        }
    }

    /* compiled from: ServicesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter$GorservViewHolder;", "Lcom/sputnik/common/base/BaseViewHolder;", "Lcom/sputnik/common/entities/services/OuterService;", "binding", "Lsputnik/axmor/com/databinding/ItemServiceGorservBinding;", "(Lsputnik/axmor/com/sputnik/ui/main/market/adapter/ServicesAdapter;Lsputnik/axmor/com/databinding/ItemServiceGorservBinding;)V", "getBinding", "()Lsputnik/axmor/com/databinding/ItemServiceGorservBinding;", "bindTo", "", "item", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GorservViewHolder extends BaseViewHolder<OuterService> {
        private final ItemServiceGorservBinding binding;
        final /* synthetic */ ServicesAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public GorservViewHolder(ServicesAdapter servicesAdapter, ItemServiceGorservBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = servicesAdapter;
            ConstraintLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.binding = binding;
        }

        @Override // com.sputnik.common.base.BaseViewHolder
        public ItemServiceGorservBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0112  */
        @Override // com.sputnik.common.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void bindTo(final com.sputnik.common.entities.services.OuterService r14) {
            /*
                Method dump skipped, instructions count: 434
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.market.adapter.ServicesAdapter.GorservViewHolder.bindTo(com.sputnik.common.entities.services.OuterService):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindTo$lambda$5$lambda$4(ServicesAdapter this$0, OuterService item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.getOnItemClicked().invoke(item, 111);
        }
    }
}
