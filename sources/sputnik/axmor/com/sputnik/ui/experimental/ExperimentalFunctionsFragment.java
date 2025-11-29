package sputnik.axmor.com.sputnik.ui.experimental;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.experimental.ExperimentalFunctions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentExperimentalBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: ExperimentalFunctionsFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0003J!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/experimental/ExperimentalFunctionsFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "localize", "initViews", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/FragmentExperimentalBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentExperimentalBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExperimentalFunctionsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ExperimentalFunctionsFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentExperimentalBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;
    public PrefManager prefManager;

    public ExperimentalFunctionsFragment() {
        super(R.layout.fragment_experimental);
        this.binding = new ViewBindingFragmentDelegate(this, ExperimentalFunctionsFragment$binding$2.INSTANCE);
    }

    private final FragmentExperimentalBinding getBinding() {
        return (FragmentExperimentalBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        getBinding();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() throws Resources.NotFoundException {
        FragmentExperimentalBinding binding = getBinding();
        binding.switchWebrtc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.experimental.ExperimentalFunctionsFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ExperimentalFunctionsFragment.initViews$lambda$3$lambda$1(this.f$0, compoundButton, z);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.experimental.ExperimentalFunctionsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperimentalFunctionsFragment.initViews$lambda$3$lambda$2(this.f$0, view);
            }
        });
        SwitchCompat switchCompat = binding.switchWebrtc;
        Boolean webrtcEnabled = getPrefManager().getExperimentalSettings().getWebrtcEnabled();
        switchCompat.setChecked(webrtcEnabled != null ? webrtcEnabled.booleanValue() : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3$lambda$1(ExperimentalFunctionsFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.getPrefManager().updateExperimental(new ExperimentalFunctions(Boolean.TRUE));
        } else {
            this$0.getPrefManager().updateExperimental(new ExperimentalFunctions(Boolean.FALSE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3$lambda$2(ExperimentalFunctionsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewKt.addSystemWindowInsetToPadding(root, true);
    }
}
