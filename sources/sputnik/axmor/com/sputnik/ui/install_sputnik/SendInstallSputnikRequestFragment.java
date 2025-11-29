package sputnik.axmor.com.sputnik.ui.install_sputnik;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.send_install_sputnik.SendInstallSputnik;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSendInstallSputnikRequestBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.utils.textWatchers.MultipleSymbolsRestrictTextWatcher;

/* compiled from: SendInstallSputnikRequestFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0003J!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/install_sputnik/SendInstallSputnikRequestFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "localize", "initViews", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/FragmentSendInstallSputnikRequestBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSendInstallSputnikRequestBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendInstallSputnikRequestFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SendInstallSputnikRequestFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSendInstallSputnikRequestBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;
    public PrefManager prefManager;

    public SendInstallSputnikRequestFragment() {
        super(R.layout.fragment_send_install_sputnik_request);
        this.binding = new ViewBindingFragmentDelegate(this, SendInstallSputnikRequestFragment$binding$2.INSTANCE);
    }

    private final FragmentSendInstallSputnikRequestBinding getBinding() {
        return (FragmentSendInstallSputnikRequestBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
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
        SendInstallSputnik.Description description;
        TextTitle sendButton;
        SendInstallSputnik.FieldsTitles fieldsTitles;
        SendInstallSputnik.FieldsTitles fieldsTitles2;
        SendInstallSputnik.FieldsTitles fieldsTitles3;
        SendInstallSputnik.Description description2;
        SendInstallSputnik.Description description3;
        SendInstallSputnik.FieldsTitles fieldsTitles4;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String notion = null;
        SendInstallSputnik sendInstallSputnik = data != null ? data.getSendInstallSputnik() : null;
        FragmentSendInstallSputnikRequestBinding binding = getBinding();
        binding.tvPhoneTitle.setText((sendInstallSputnik == null || (fieldsTitles4 = sendInstallSputnik.getFieldsTitles()) == null) ? null : fieldsTitles4.getPhone());
        binding.tvPhone.setText("+" + getPrefManager().getPhone());
        binding.tvTitle.setText((sendInstallSputnik == null || (description3 = sendInstallSputnik.getDescription()) == null) ? null : description3.getTitle());
        binding.tvSubtitle.setText((sendInstallSputnik == null || (description2 = sendInstallSputnik.getDescription()) == null) ? null : description2.getText());
        binding.layoutCity.tvTitle.setText((sendInstallSputnik == null || (fieldsTitles3 = sendInstallSputnik.getFieldsTitles()) == null) ? null : fieldsTitles3.getCity());
        binding.layoutStreet.tvTitle.setText((sendInstallSputnik == null || (fieldsTitles2 = sendInstallSputnik.getFieldsTitles()) == null) ? null : fieldsTitles2.getStreet());
        binding.layoutHouse.tvTitle.setText((sendInstallSputnik == null || (fieldsTitles = sendInstallSputnik.getFieldsTitles()) == null) ? null : fieldsTitles.getBuildingNumber());
        binding.btnApply.setText((sendInstallSputnik == null || (sendButton = sendInstallSputnik.getSendButton()) == null) ? null : sendButton.getTitle());
        TextView textView = binding.tvAttention;
        if (sendInstallSputnik != null && (description = sendInstallSputnik.getDescription()) != null) {
            notion = description.getNotion();
        }
        textView.setText(notion);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final FragmentSendInstallSputnikRequestBinding binding = getBinding();
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.install_sputnik.SendInstallSputnikRequestFragment$initViews$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    IntentUtilsKt.sendEmail(activity, "svetlana@sputnik.systems", "Заявка на установку домофона Спутник", ((Object) binding.tvPhone.getText()) + "\n" + ((Object) binding.layoutCity.etData.getText()) + "\n" + ((Object) binding.layoutStreet.etData.getText()) + " " + ((Object) binding.layoutHouse.etData.getText()) + "\n");
                }
            }
        }, 1, null);
        new MultipleSymbolsRestrictTextWatcher(0, CollectionsKt.listOf((Object[]) new EditText[]{binding.layoutCity.etData, binding.layoutStreet.etData, binding.layoutHouse.etData}), new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.install_sputnik.SendInstallSputnikRequestFragment$initViews$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AppCompatButton btnApply2 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                ViewKt.enable(btnApply2);
            }
        }, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.install_sputnik.SendInstallSputnikRequestFragment$initViews$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                AppCompatButton btnApply2 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                ViewKt.disable(btnApply2);
            }
        }, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.install_sputnik.SendInstallSputnikRequestFragment$initViews$1$4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        NestedScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
    }
}
