package ru.yoomoney.sdk.auth.phone.countries.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.phone.countries.PhoneCountries;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/impl/PhoneCountriesViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", RemoteMessageConst.DATA, "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Ljava/util/List;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneCountriesViewModelFactory implements ViewModelProvider.Factory {
    private static final String FEATURE_NAME = "PhoneCountries";
    private final List<CountryCallingCode> data;

    public static final class a extends Lambda implements Function1<RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect>, Out<? extends PhoneCountries.State, ? extends PhoneCountries.Action>> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Out<? extends PhoneCountries.State, ? extends PhoneCountries.Action> invoke(RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return Out.INSTANCE.invoke(new PhoneCountries.State.Content(PhoneCountriesViewModelFactory.this.data), new c(RuntimeViewModel));
        }
    }

    public static final class b extends Lambda implements Function1<RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect>, Function2<? super PhoneCountries.State, ? super PhoneCountries.Action, ? extends Out<? extends PhoneCountries.State, ? extends PhoneCountries.Action>>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function2<? super PhoneCountries.State, ? super PhoneCountries.Action, ? extends Out<? extends PhoneCountries.State, ? extends PhoneCountries.Action>> invoke(RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> runtimeViewModelDependencies) {
            RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> RuntimeViewModel = runtimeViewModelDependencies;
            Intrinsics.checkNotNullParameter(RuntimeViewModel, "$this$RuntimeViewModel");
            return new PhoneCountriesBusinessLogic(RuntimeViewModel.getShowState(), RuntimeViewModel.getShowEffect(), RuntimeViewModel.getSource());
        }
    }

    public PhoneCountriesViewModelFactory(List<CountryCallingCode> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default(FEATURE_NAME, new a(), b.a, null, null, null, null, null, null, null, null, 2040, null);
        Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.auth.phone.countries.impl.PhoneCountriesViewModelFactory.create");
        return runtimeViewModelRuntimeViewModel$default;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return super.create(cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return super.create(kClass, creationExtras);
    }
}
