package ru.yoomoney.sdk.auth.phone.countries;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.databinding.AuthPhoneCountriesBinding;
import ru.yoomoney.sdk.auth.phone.countries.PhoneCountries;
import ru.yoomoney.sdk.auth.phone.countries.adapter.PhoneCountriesAdapter;
import ru.yoomoney.sdk.auth.phone.countries.impl.PhoneCountriesViewModelFactory;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.PaddingItemDecoration;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u001a\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\u001cH\u0002J\u0010\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u001aH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R1\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0019j\u0002`\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$¨\u0006;"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountriesFragment;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBaseBottomSheetDialogFragment;", "()V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPhoneCountriesBinding;", "adapter", "Lru/yoomoney/sdk/auth/phone/countries/adapter/PhoneCountriesAdapter;", "getAdapter", "()Lru/yoomoney/sdk/auth/phone/countries/adapter/PhoneCountriesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPhoneCountriesBinding;", "data", "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "getData", "()Ljava/util/List;", "data$delegate", PhoneCountriesFragment.KEY_SELECTED, "getSelected", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "selected$delegate", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Effect;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountriesViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "viewModelFactory", "Lru/yoomoney/sdk/auth/phone/countries/impl/PhoneCountriesViewModelFactory;", "getViewModelFactory", "()Lru/yoomoney/sdk/auth/phone/countries/impl/PhoneCountriesViewModelFactory;", "viewModelFactory$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onItemSelect", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "showEffect", "effect", "showState", "state", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneCountriesFragment extends YmBaseBottomSheetDialogFragment {
    private static final String KEY_DATA = "data";
    private static final String KEY_SELECTED = "selected";
    private AuthPhoneCountriesBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = PhoneCountriesFragment.class.getName();

    /* renamed from: data$delegate, reason: from kotlin metadata */
    private final Lazy data = LazyKt.lazy(new b());

    /* renamed from: selected$delegate, reason: from kotlin metadata */
    private final Lazy selected = LazyKt.lazy(new f());

    /* renamed from: viewModelFactory$delegate, reason: from kotlin metadata */
    private final Lazy viewModelFactory = LazyKt.lazy(new h());

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountriesFragment$Companion;", "", "()V", "KEY_DATA", "", "KEY_SELECTED", "TAG", "kotlin.jvm.PlatformType", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "data", "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", PhoneCountriesFragment.KEY_SELECTED, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(FragmentManager manager, List<CountryCallingCode> data, CountryCallingCode selected) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(selected, "selected");
            Fragment fragmentFindFragmentByTag = manager.findFragmentByTag(PhoneCountriesFragment.TAG);
            PhoneCountriesFragment phoneCountriesFragment = fragmentFindFragmentByTag instanceof PhoneCountriesFragment ? (PhoneCountriesFragment) fragmentFindFragmentByTag : null;
            if (phoneCountriesFragment == null) {
                phoneCountriesFragment = new PhoneCountriesFragment();
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("data", new ArrayList<>(data));
            bundle.putParcelable(PhoneCountriesFragment.KEY_SELECTED, selected);
            phoneCountriesFragment.setArguments(bundle);
            phoneCountriesFragment.show(manager, PhoneCountriesFragment.TAG);
        }
    }

    public static final class a extends Lambda implements Function0<PhoneCountriesAdapter> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountriesAdapter invoke() {
            return new PhoneCountriesAdapter(PhoneCountriesFragment.this.getSelected(), new ru.yoomoney.sdk.auth.phone.countries.a(PhoneCountriesFragment.this));
        }
    }

    public static final class b extends Lambda implements Function0<List<? extends CountryCallingCode>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends CountryCallingCode> invoke() {
            ArrayList arrayList;
            ArrayList parcelableArrayList;
            Bundle arguments = PhoneCountriesFragment.this.getArguments();
            if (arguments == null || (parcelableArrayList = arguments.getParcelableArrayList("data")) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parcelableArrayList, 10));
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add((CountryCallingCode) it.next());
                }
            }
            if (arrayList != null) {
                return arrayList;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<PhoneCountries.State, Unit> {
        public c(Object obj) {
            super(1, obj, PhoneCountriesFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneCountries.State state) {
            PhoneCountries.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneCountriesFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<PhoneCountries.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, PhoneCountriesFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneCountries.Effect effect) {
            PhoneCountries.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneCountriesFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            LinearLayout parent = PhoneCountriesFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = PhoneCountriesFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<CountryCallingCode> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CountryCallingCode invoke() {
            Bundle arguments = PhoneCountriesFragment.this.getArguments();
            CountryCallingCode countryCallingCode = arguments != null ? (CountryCallingCode) arguments.getParcelable(PhoneCountriesFragment.KEY_SELECTED) : null;
            return countryCallingCode == null ? (CountryCallingCode) CollectionsKt.first(PhoneCountriesFragment.this.getData()) : countryCallingCode;
        }
    }

    public static final class g extends Lambda implements Function0<ViewModelProvider.Factory> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PhoneCountriesFragment.this.getViewModelFactory();
        }
    }

    public static final class h extends Lambda implements Function0<PhoneCountriesViewModelFactory> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountriesViewModelFactory invoke() {
            return new PhoneCountriesViewModelFactory(PhoneCountriesFragment.this.getData());
        }
    }

    public PhoneCountriesFragment() {
        g gVar = new g();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, gVar);
        this.adapter = LazyKt.lazy(new a());
    }

    private final PhoneCountriesAdapter getAdapter() {
        return (PhoneCountriesAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPhoneCountriesBinding getBinding() {
        AuthPhoneCountriesBinding authPhoneCountriesBinding = this._binding;
        Intrinsics.checkNotNull(authPhoneCountriesBinding);
        return authPhoneCountriesBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CountryCallingCode> getData() {
        return (List) this.data.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CountryCallingCode getSelected() {
        return (CountryCallingCode) this.selected.getValue();
    }

    private final RuntimeViewModel<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneCountriesViewModelFactory getViewModelFactory() {
        return (PhoneCountriesViewModelFactory) this.viewModelFactory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemSelect(CountryCallingCode selected) {
        getViewModel().handleAction(new PhoneCountries.Action.PhoneCountrySelected(selected));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PhoneCountries.Effect effect) {
        if (effect instanceof PhoneCountries.Effect.CloseScreen) {
            LifecycleOwner parentFragment = getParentFragment();
            PhoneCountriesListener phoneCountriesListener = parentFragment instanceof PhoneCountriesListener ? (PhoneCountriesListener) parentFragment : null;
            if (phoneCountriesListener != null) {
                phoneCountriesListener.onCountrySelected(((PhoneCountries.Effect.CloseScreen) effect).getSelected());
            }
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PhoneCountries.State state) {
        if (state instanceof PhoneCountries.State.Content) {
            getAdapter().submitList(((PhoneCountries.State.Content) state).getList());
        }
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthPhoneCountriesBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        LifecycleOwner parentFragment = getParentFragment();
        PhoneCountriesListener phoneCountriesListener = parentFragment instanceof PhoneCountriesListener ? (PhoneCountriesListener) parentFragment : null;
        if (phoneCountriesListener != null) {
            phoneCountriesListener.dismiss();
        }
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().list.setAdapter(getAdapter());
        RecyclerView recyclerView = getBinding().list;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ym_spaceM);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNull(contextRequireContext);
        recyclerView.addItemDecoration(new PaddingItemDecoration(contextRequireContext, dimensionPixelSize, 0, 4, null));
        RuntimeViewModel<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new c(this), new d(this), new e());
    }
}
