package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.common.entities.localization.CountryPickerBody;
import com.sputnik.common.entities.localization.CountryPickerLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.LoginViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.databinding.FragmentChooseCountryPhoneCodeBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.ui.registration.adapter.CountryCodeAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: CountryPickerFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/CountryPickerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "initSearch", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentChooseCountryPhoneCodeBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentChooseCountryPhoneCodeBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "viewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CountryPickerFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CountryPickerFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentChooseCountryPhoneCodeBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentChooseCountryPhoneCodeBinding getBinding() {
        return (FragmentChooseCountryPhoneCodeBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
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
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        initView();
        initSearch();
        EditText editText = getBinding().etSearchCountryCode;
        editText.requestFocus();
        Intrinsics.checkNotNull(editText);
        ViewKt.showKeyboard(editText);
        LoginViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        viewModel.observeState(viewLifecycleOwner, new Function1<LoginViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.CountryPickerFragment.onViewCreated.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LoginViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
                invoke2(loginViewState);
                return Unit.INSTANCE;
            }
        });
    }

    private final void initView() {
        FragmentChooseCountryPhoneCodeBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        Toolbar toolbar2 = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar2, FragmentKt.findNavController(this), null, 2, null);
        RecyclerView recyclerView = binding.rvCountryCodesList;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        CountryCodeAdapter countryCodeAdapter = new CountryCodeAdapter(new Function1<CountryCode, Unit>() { // from class: com.sputnik.oboarding.ui.registration.CountryPickerFragment$initView$1$1$1
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CountryCode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getViewModel().handleCountryCode(it.getCode());
                EditText etSearchCountryCode = this.this$0.getBinding().etSearchCountryCode;
                Intrinsics.checkNotNullExpressionValue(etSearchCountryCode, "etSearchCountryCode");
                ViewKt.hideKeyboard(etSearchCountryCode);
                FragmentKt.findNavController(this.this$0).navigateUp();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CountryCode countryCode) {
                invoke2(countryCode);
                return Unit.INSTANCE;
            }
        });
        countryCodeAdapter.submitList(getViewModel().getCurrentState().getCountryCodeList());
        recyclerView.setAdapter(countryCodeAdapter);
        Intrinsics.checkNotNull(recyclerView);
        ViewKt.addSystemWindowInsetToPadding$default(recyclerView, true, false, true, true, 2, null);
    }

    private final void initSearch() {
        final List<CountryCode> countryCodeList = getViewModel().getCurrentState().getCountryCodeList();
        EditText etSearchCountryCode = getBinding().etSearchCountryCode;
        Intrinsics.checkNotNullExpressionValue(etSearchCountryCode, "etSearchCountryCode");
        etSearchCountryCode.addTextChangedListener(new TextWatcher() { // from class: com.sputnik.oboarding.ui.registration.CountryPickerFragment$initSearch$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ArrayList arrayList;
                String string = this.this$0.getBinding().etSearchCountryCode.getText().toString();
                if (string.length() <= 0) {
                    RecyclerView.Adapter adapter = this.this$0.getBinding().rvCountryCodesList.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.sputnik.oboarding.ui.registration.adapter.CountryCodeAdapter");
                    ((CountryCodeAdapter) adapter).submitList(countryCodeList);
                    return;
                }
                List list = countryCodeList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (Object obj : list) {
                        CountryCode countryCode = (CountryCode) obj;
                        if (StringsKt.startsWith(countryCode.getName(), string, true) || StringsKt.startsWith(countryCode.getCode(), string, true)) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                RecyclerView.Adapter adapter2 = this.this$0.getBinding().rvCountryCodesList.getAdapter();
                Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.sputnik.oboarding.ui.registration.adapter.CountryCodeAdapter");
                ((CountryCodeAdapter) adapter2).submitList(arrayList);
            }
        });
    }

    private final void localize() {
        CountryPickerLocale countryPicker;
        TextPlaceHolder searchField;
        FragmentChooseCountryPhoneCodeBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (countryPicker = data.getCountryPicker()) == null) {
            return;
        }
        Toolbar toolbar = binding.toolbar;
        TextTitle navigation = countryPicker.getNavigation();
        String placeholder = null;
        toolbar.setTitle(navigation != null ? navigation.getTitle() : null);
        TextView textView = binding.tvTitleSearchCountryCode;
        CountryPickerBody body = countryPicker.getBody();
        if (body != null && (searchField = body.getSearchField()) != null) {
            placeholder = searchField.getPlaceholder();
        }
        textView.setText(placeholder);
    }

    public CountryPickerFragment() {
        super(R$layout.fragment_choose_country_phone_code);
        this.binding = new ViewBindingFragmentDelegate(this, CountryPickerFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.CountryPickerFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.CountryPickerFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.CountryPickerFragment$viewModel$2
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
