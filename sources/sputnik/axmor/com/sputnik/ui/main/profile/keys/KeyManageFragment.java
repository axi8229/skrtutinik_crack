package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.KeysEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.keys.PhysicalKey;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.keys.PhysicalKeysLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.IconButton;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.domain.common.Resource;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentKeyManageBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.utils.textWatchers.ChangedTextWatcher;

/* compiled from: KeyManageFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00109R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00102\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeyManageFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/KeysViewState;", "state", "", "renderUi", "(Lcom/sputnik/common/viewmodels/KeysViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "localize", "initViews", "Lsputnik/axmor/com/databinding/FragmentKeyManageBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentKeyManageBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localization", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalization", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalization", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel$delegate", "Lkotlin/Lazy;", "getKeysViewModel", "()Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/entities/keys/PhysicalKey;", "_key$delegate", "get_key", "()Lcom/sputnik/common/entities/keys/PhysicalKey;", "_key", "key", "Lcom/sputnik/common/entities/keys/PhysicalKey;", "Lsputnik/axmor/com/sputnik/utils/textWatchers/ChangedTextWatcher;", "changedTextObserver$delegate", "getChangedTextObserver", "()Lsputnik/axmor/com/sputnik/utils/textWatchers/ChangedTextWatcher;", "changedTextObserver", "", "textChanged", "Z", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeyManageFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KeyManageFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentKeyManageBinding;", 0))};

    /* renamed from: _key$delegate, reason: from kotlin metadata */
    private final Lazy _key;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: changedTextObserver$delegate, reason: from kotlin metadata */
    private final Lazy changedTextObserver;
    public MultiViewModelFactory factory;
    private PhysicalKey key;

    /* renamed from: keysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy keysViewModel;
    public LocalizationStorage localization;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private boolean textChanged;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentKeyManageBinding getBinding() {
        return (FragmentKeyManageBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalization() {
        LocalizationStorage localizationStorage = this.localization;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localization");
        return null;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
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
    public final KeysViewModel getKeysViewModel() {
        return (KeysViewModel) this.keysViewModel.getValue();
    }

    private final PhysicalKey get_key() {
        return (PhysicalKey) this._key.getValue();
    }

    private final ChangedTextWatcher getChangedTextObserver() {
        return (ChangedTextWatcher) this.changedTextObserver.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        this.key = get_key();
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getAnalytics().trackLogEvent(new KeysEvents.ClickKeySettings());
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        KeysViewModel keysViewModel = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        keysViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        KeysViewModel keysViewModel2 = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        keysViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                KeyManageFragment keyManageFragment = KeyManageFragment.this;
                ConstraintLayout root = keyManageFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(keyManageFragment, root, it);
            }
        });
    }

    /* compiled from: KeyManageFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<KeysViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, KeyManageFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/KeysViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KeysViewState keysViewState) {
            invoke2(keysViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KeysViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((KeyManageFragment) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(KeysViewState state) {
        LocalizationLocalModel data;
        PhysicalKeysLocale physicalKeys;
        PhysicalKeysLocale.EditKey editKey;
        TextTitle blockButton;
        String title;
        PhysicalKeysLocale physicalKeys2;
        PhysicalKeysLocale.EditKey editKey2;
        TextTitle saveButton;
        LocalizationLocalModel data2;
        PhysicalKeysLocale physicalKeys3;
        PhysicalKeysLocale.EditKey editKey3;
        Object next;
        Object obj = null;
        if (state.getLockUnlockKeyServerState() == Resource.Status.SUCCESS) {
            Iterator<T> it = state.getKeys().peekContent().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((PhysicalKey) next).getUuid(), get_key().getUuid())) {
                        break;
                    }
                }
            }
            this.key = (PhysicalKey) next;
        }
        ImageView imageView = getBinding().ivKeyStatus;
        PhysicalKey physicalKey = this.key;
        imageView.setImageResource(physicalKey != null ? Intrinsics.areEqual(physicalKey.getBlocked(), Boolean.TRUE) : false ? R.drawable.ic_key_locked : R.drawable.ic_key_active);
        IconButton iconButton = getBinding().btnBlockUnblock;
        PhysicalKey physicalKey2 = this.key;
        String strOrEmpty = StringUtilsKt.orEmpty((!(physicalKey2 != null ? Intrinsics.areEqual(physicalKey2.getBlocked(), Boolean.TRUE) : false) ? !((data = getLocalization().getData()) == null || (physicalKeys = data.getPhysicalKeys()) == null || (editKey = physicalKeys.getEditKey()) == null || (blockButton = editKey.getBlockButton()) == null) : !((data2 = getLocalization().getData()) == null || (physicalKeys3 = data2.getPhysicalKeys()) == null || (editKey3 = physicalKeys3.getEditKey()) == null || (blockButton = editKey3.getUnblockButton()) == null)) ? null : blockButton.getTitle());
        PhysicalKey physicalKey3 = this.key;
        int i = physicalKey3 != null ? Intrinsics.areEqual(physicalKey3.getBlocked(), Boolean.TRUE) : false ? R.drawable.ic_door_opened_simple : R.drawable.ic_door_closed_simple;
        Context contextRequireContext = requireContext();
        PhysicalKey physicalKey4 = this.key;
        if (physicalKey4 != null) {
            Intrinsics.areEqual(physicalKey4.getBlocked(), Boolean.TRUE);
        }
        iconButton.setData(strOrEmpty, i, ContextCompat.getColor(contextRequireContext, R.color.sputnik_blue), new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$renderUi$1$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PhysicalKey physicalKey5 = this.this$0.key;
                if (physicalKey5 != null ? Intrinsics.areEqual(physicalKey5.getBlocked(), Boolean.TRUE) : false) {
                    this.this$0.getAnalytics().trackLogEvent(new KeysEvents.ClickUnlockKey());
                } else {
                    this.this$0.getAnalytics().trackLogEvent(new KeysEvents.ClickBlockKey());
                }
                PhysicalKey physicalKey6 = this.this$0.key;
                if (physicalKey6 != null) {
                    this.this$0.getKeysViewModel().lockOrUnlockKey(physicalKey6);
                }
            }
        });
        Resource.Status lockUnlockKeyServerState = state.getLockUnlockKeyServerState();
        Resource.Status status = Resource.Status.LOADING;
        if (lockUnlockKeyServerState == status) {
            getBinding().btnBlockUnblock.showProgress();
        } else {
            getBinding().btnBlockUnblock.hideProgress();
        }
        if (state.getDeleteKeyServerState() == status) {
            getBinding().btnDelete.showProgress();
        } else {
            getBinding().btnDelete.hideProgress();
        }
        AppCompatButton btnSave = getBinding().btnSave;
        Intrinsics.checkNotNullExpressionValue(btnSave, "btnSave");
        boolean z = state.getUpdateKeyCommentServerState() == status;
        LocalizationLocalModel data3 = getLocalization().getData();
        if (data3 == null || (physicalKeys2 = data3.getPhysicalKeys()) == null || (editKey2 = physicalKeys2.getEditKey()) == null || (saveButton = editKey2.getSaveButton()) == null || (title = saveButton.getTitle()) == null) {
            title = "";
        }
        ViewBindingUtilsKt.showProgressBasedOn$default(btnSave, z, title, 0, this.textChanged, 4, null);
        EditText etKeyComment = getBinding().etKeyComment;
        Intrinsics.checkNotNullExpressionValue(etKeyComment, "etKeyComment");
        ViewBindingUtilsKt.enableBasedOn(etKeyComment, state.getUpdateKeyCommentServerState() != status);
        if (state.getUpdateKeyCommentServerState() == Resource.Status.SUCCESS) {
            getChangedTextObserver().updateInitialValue(getBinding().etKeyComment.getText().toString());
            this.textChanged = false;
            AppCompatButton btnSave2 = getBinding().btnSave;
            Intrinsics.checkNotNullExpressionValue(btnSave2, "btnSave");
            ViewKt.disable(btnSave2);
        }
        Iterator<T> it2 = state.getKeys().peekContent().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual((PhysicalKey) next2, this.key)) {
                obj = next2;
                break;
            }
        }
        if (obj == null) {
            FragmentKt.findNavController(this).navigateUp();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        PhysicalKeysLocale physicalKeys;
        PhysicalKeysLocale.EditKey editKey;
        FragmentKeyManageBinding binding = getBinding();
        LocalizationLocalModel data = getLocalization().getData();
        if (data == null || (physicalKeys = data.getPhysicalKeys()) == null || (editKey = physicalKeys.getEditKey()) == null) {
            return;
        }
        Toolbar toolbar = binding.toolbar;
        TextTitle navigation = editKey.getNavigation();
        toolbar.setTitle(StringUtilsKt.orEmpty(navigation != null ? navigation.getTitle() : null));
        AppCompatButton appCompatButton = binding.btnSave;
        TextTitle saveButton = editKey.getSaveButton();
        appCompatButton.setText(StringUtilsKt.orEmpty(saveButton != null ? saveButton.getTitle() : null));
        TextView textView = binding.tvKeyCommentHint;
        TextPlaceHolder nameView = editKey.getNameView();
        textView.setText(StringUtilsKt.orEmpty(nameView != null ? nameView.getTitle() : null));
        EditText editText = binding.etKeyComment;
        TextPlaceHolder nameView2 = editKey.getNameView();
        editText.setHint(StringUtilsKt.orEmpty(nameView2 != null ? nameView2.getPlaceholder() : null));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        String title;
        PhysicalKeysLocale physicalKeys;
        PhysicalKeysLocale.EditKey editKey;
        TextTitle deleteButton;
        final FragmentKeyManageBinding binding = getBinding();
        EditText editText = binding.etKeyComment;
        PhysicalKey physicalKey = this.key;
        editText.setText(StringUtilsKt.orEmpty(physicalKey != null ? physicalKey.getComment() : null));
        AppCompatButton btnSave = binding.btnSave;
        Intrinsics.checkNotNullExpressionValue(btnSave, "btnSave");
        ViewKt.disable(btnSave);
        binding.etKeyComment.addTextChangedListener(getChangedTextObserver());
        IconButton iconButton = binding.btnDelete;
        LocalizationLocalModel data = getLocalization().getData();
        if (data == null || (physicalKeys = data.getPhysicalKeys()) == null || (editKey = physicalKeys.getEditKey()) == null || (deleteButton = editKey.getDeleteButton()) == null || (title = deleteButton.getTitle()) == null) {
            title = "";
        }
        iconButton.setData(title, R.drawable.ic_delete, ContextCompat.getColor(requireContext(), R.color.colorRed), new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$initViews$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getAnalytics().trackLogEvent(new KeysEvents.ClickDeleteKey());
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_key_manage_to_delete_key, BundleKt.bundleOf(TuplesKt.to("item", this.this$0.key)), null, 4, null);
            }
        });
        AppCompatButton btnSave2 = binding.btnSave;
        Intrinsics.checkNotNullExpressionValue(btnSave2, "btnSave");
        SafeClickListenerKt.setSafeOnClickListener$default(btnSave2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$initViews$1$2
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
                PhysicalKey physicalKey2 = this.this$0.key;
                if (physicalKey2 != null) {
                    this.this$0.getKeysViewModel().updateKeyComment(physicalKey2, binding.etKeyComment.getText().toString());
                }
            }
        }, 1, null);
        TextView textView = binding.tvKeyComment;
        PhysicalKey physicalKey2 = this.key;
        textView.setText(StringUtilsKt.orEmpty(physicalKey2 != null ? physicalKey2.getComment() : null));
        TextView textView2 = binding.tvKeyHex;
        PhysicalKey physicalKey3 = this.key;
        textView2.setText(StringUtilsKt.orEmpty(physicalKey3 != null ? physicalKey3.getFormattedHex() : null));
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding$default(rootView, true, true, true, false, 8, null);
    }

    public KeyManageFragment() {
        super(R.layout.fragment_key_manage);
        this.binding = new ViewBindingFragmentDelegate(this, KeyManageFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.keysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(KeysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$keysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this._key = LazyKt.lazy(new Function0<PhysicalKey>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$_key$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PhysicalKey invoke() {
                Bundle arguments = this.this$0.getArguments();
                Object obj = arguments != null ? arguments.get("item") : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.sputnik.common.entities.keys.PhysicalKey");
                return (PhysicalKey) obj;
            }
        });
        this.changedTextObserver = LazyKt.lazy(new Function0<ChangedTextWatcher>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$changedTextObserver$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ChangedTextWatcher invoke() {
                String strOrEmpty;
                String comment;
                PhysicalKey physicalKey = this.this$0.key;
                if (physicalKey == null || (comment = physicalKey.getComment()) == null || (strOrEmpty = StringUtilsKt.orEmpty(comment)) == null) {
                    strOrEmpty = "";
                }
                final KeyManageFragment keyManageFragment = this.this$0;
                return new ChangedTextWatcher(strOrEmpty, new Function2<Boolean, String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment$changedTextObserver$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                        invoke(bool.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z, String text) {
                        Intrinsics.checkNotNullParameter(text, "text");
                        keyManageFragment.textChanged = z;
                        AppCompatButton btnSave = keyManageFragment.getBinding().btnSave;
                        Intrinsics.checkNotNullExpressionValue(btnSave, "btnSave");
                        ViewBindingUtilsKt.enableBasedOn(btnSave, z);
                    }
                });
            }
        });
    }
}
