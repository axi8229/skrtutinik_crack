package sputnik.axmor.com.sputnik.ui.nointercom;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.AddAddressBody;
import com.sputnik.common.entities.localization.AddAddressLocale;
import com.sputnik.common.entities.localization.AddAddressNavigation;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentNewAdressBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel;
import sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewState;

/* compiled from: SettingsAddress.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/nointercom/SettingsAddress;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewState;)V", "", "isEnabled", "setEnabled", "(Z)V", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/FragmentNewAdressBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentNewAdressBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewModel;", "addressViewModel$delegate", "Lkotlin/Lazy;", "getAddressViewModel", "()Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewModel;", "addressViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsAddress extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SettingsAddress.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentNewAdressBinding;", 0))};

    /* renamed from: addressViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addressViewModel;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    private final FragmentNewAdressBinding getBinding() {
        return (FragmentNewAdressBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddressViewModel getAddressViewModel() {
        return (AddressViewModel) this.addressViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        AddressViewModel addressViewModel = getAddressViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        addressViewModel.observeState(viewLifecycleOwner, new C26991(this));
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        initView();
    }

    /* compiled from: SettingsAddress.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C26991 extends FunctionReferenceImpl implements Function1<AddressViewState, Unit> {
        C26991(Object obj) {
            super(1, obj, SettingsAddress.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AddressViewState addressViewState) {
            invoke2(addressViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AddressViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SettingsAddress) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(AddressViewState data) {
        Resource.Status serverState = data.getServerState();
        Resource.Status status = Resource.Status.SUCCESS;
        setEnabled(serverState == status);
        if (data.getServerState() != status || data.getCustomAddress() == null) {
            return;
        }
        FragmentNewAdressBinding binding = getBinding();
        if (!Intrinsics.areEqual(binding.tvCity.getText().toString(), data.getCity())) {
            binding.tvCity.setText(data.getCity());
        }
        if (!Intrinsics.areEqual(binding.tvStreet.getText().toString(), data.getStreet())) {
            binding.tvStreet.setText(data.getStreet());
        }
        if (!Intrinsics.areEqual(binding.tvHouse.getText().toString(), data.getHouse())) {
            binding.tvHouse.setText(data.getHouse());
        }
        if (Intrinsics.areEqual(binding.tvFlat.getText().toString(), data.getFlat())) {
            return;
        }
        binding.tvFlat.setText(data.getFlat());
    }

    private final void setEnabled(boolean isEnabled) {
        FragmentNewAdressBinding binding = getBinding();
        binding.tvHouse.setEnabled(isEnabled);
        binding.tvCity.setEnabled(isEnabled);
        binding.tvStreet.setEnabled(isEnabled);
        binding.tvFlat.setEnabled(isEnabled);
        binding.btnApply.setEnabled(isEnabled);
    }

    private final void initView() {
        AppCompatButton btnApply = getBinding().btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress.initView.1
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
                SettingsAddress.this.getAddressViewModel().setCustomAddress();
            }
        }, 1, null);
        EditText tvCity = getBinding().tvCity;
        Intrinsics.checkNotNullExpressionValue(tvCity, "tvCity");
        tvCity.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$initView$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getAddressViewModel().handleCity(StringsKt.trim(String.valueOf(s)).toString());
            }
        });
        EditText tvStreet = getBinding().tvStreet;
        Intrinsics.checkNotNullExpressionValue(tvStreet, "tvStreet");
        tvStreet.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$initView$$inlined$addTextChangedListener$default$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getAddressViewModel().handleStreet(StringsKt.trim(String.valueOf(s)).toString());
            }
        });
        EditText tvHouse = getBinding().tvHouse;
        Intrinsics.checkNotNullExpressionValue(tvHouse, "tvHouse");
        tvHouse.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$initView$$inlined$addTextChangedListener$default$3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getAddressViewModel().handleHouse(StringsKt.trim(String.valueOf(s)).toString());
            }
        });
        EditText tvFlat = getBinding().tvFlat;
        Intrinsics.checkNotNullExpressionValue(tvFlat, "tvFlat");
        tvFlat.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$initView$$inlined$addTextChangedListener$default$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getAddressViewModel().handleFlat(StringsKt.trim(String.valueOf(s)).toString());
            }
        });
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
    }

    private final void localize() {
        AddAddressLocale addAddress;
        AddAddressNavigation navigation;
        List<String> titles;
        TextTitle saveButton;
        TextPlaceHolder appartmentLabel;
        TextPlaceHolder appartmentLabel2;
        TextPlaceHolder houseLabel;
        TextPlaceHolder houseLabel2;
        TextPlaceHolder streetLabel;
        TextPlaceHolder streetLabel2;
        TextPlaceHolder cityLabel;
        TextPlaceHolder cityLabel2;
        AddAddressLocale addAddress2;
        AddAddressLocale addAddress3;
        AddAddressNavigation navigation2;
        List<String> titles2;
        FragmentNewAdressBinding binding = getBinding();
        String title = null;
        if (getAddressViewModel().getCurrentState().isBlank()) {
            Toolbar toolbar = binding.toolbar;
            LocalizationLocalModel data = getLocalizationScreen().getData();
            toolbar.setTitle((data == null || (addAddress3 = data.getAddAddress()) == null || (navigation2 = addAddress3.getNavigation()) == null || (titles2 = navigation2.getTitles()) == null) ? null : (String) CollectionsKt.first((List) titles2));
        } else {
            Toolbar toolbar2 = binding.toolbar;
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            toolbar2.setTitle((data2 == null || (addAddress = data2.getAddAddress()) == null || (navigation = addAddress.getNavigation()) == null || (titles = navigation.getTitles()) == null) ? null : (String) CollectionsKt.last((List) titles));
        }
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        AddAddressBody body = (data3 == null || (addAddress2 = data3.getAddAddress()) == null) ? null : addAddress2.getBody();
        binding.tvCityTitle.setText((body == null || (cityLabel2 = body.getCityLabel()) == null) ? null : cityLabel2.getTitle());
        binding.tvCity.setHint((body == null || (cityLabel = body.getCityLabel()) == null) ? null : cityLabel.getPlaceholder());
        binding.tvStreetTitle.setText((body == null || (streetLabel2 = body.getStreetLabel()) == null) ? null : streetLabel2.getTitle());
        binding.tvStreet.setHint((body == null || (streetLabel = body.getStreetLabel()) == null) ? null : streetLabel.getPlaceholder());
        binding.tvHouseTitle.setText((body == null || (houseLabel2 = body.getHouseLabel()) == null) ? null : houseLabel2.getTitle());
        binding.tvHouse.setHint((body == null || (houseLabel = body.getHouseLabel()) == null) ? null : houseLabel.getPlaceholder());
        binding.tvFlatTitle.setText((body == null || (appartmentLabel2 = body.getAppartmentLabel()) == null) ? null : appartmentLabel2.getTitle());
        binding.tvFlat.setHint((body == null || (appartmentLabel = body.getAppartmentLabel()) == null) ? null : appartmentLabel.getPlaceholder());
        AppCompatButton appCompatButton = binding.btnApply;
        if (body != null && (saveButton = body.getSaveButton()) != null) {
            title = saveButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    public SettingsAddress() {
        super(R.layout.fragment_new_adress);
        this.binding = new ViewBindingFragmentDelegate(this, SettingsAddress$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.addressViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AddressViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress$addressViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
    }
}
