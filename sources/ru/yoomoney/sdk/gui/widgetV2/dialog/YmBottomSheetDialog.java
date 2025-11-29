package ru.yoomoney.sdk.gui.widgetV2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.gui.R$style;
import ru.yoomoney.sdk.gui.gui.databinding.YmGuiBottomSheetDialogBinding;
import ru.yoomoney.sdk.gui.widget.ContentScrollView;
import ru.yoomoney.sdk.gui.widget.headline.HeadlineSecondaryView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemImageDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemImageRoundDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemValueDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemValueFadeDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemValuePrimaryDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemVectorDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemVectorFadeDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemVectorPrimaryDetailView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemImageDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemImageRoundDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemValueDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemValueFadeDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemValuePrimaryDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemVectorDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemVectorFadeDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemVectorPrimaryDetailLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemImageIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemImageRoundIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemValueFadeIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemValueIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemValuePrimaryIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemVectorFadeIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemVectorIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemVectorPrimaryIconView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemImageIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemImageRoundIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemValueFadeIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemValueIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemValuePrimaryIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemVectorFadeIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemVectorIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemVectorPrimaryIconLargeView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftImage;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasLeftValue;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasRightIcon;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubTitle;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubValue;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasValue;

/* compiled from: YmBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0006CDEFGHB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u00100\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u00101\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u00102\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u00103\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u00104\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u00105\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u00106\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u00107\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u00108\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u00109\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0018\u0010:\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0018\u0010;\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u000e\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020>J\u0016\u0010?\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010@H\u0002J\u0016\u0010A\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010BH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBaseBottomSheetDialogFragment;", "()V", "_binding", "Lru/yoomoney/sdk/gui/gui/databinding/YmGuiBottomSheetDialogBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/gui/gui/databinding/YmGuiBottomSheetDialogBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;", "getListener", "()Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;", "setListener", "(Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;)V", "titleAlertAppearance", "", "titleDefaultAppearance", "createHeadlineView", "Landroid/view/View;", "item", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$Headline;", "createMenuItemView", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$MenuItem;", "createMenuLargeItemView", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$MenuLargeItem;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "parseEmptyLargeView", "parseEmptyView", "parseImageLargeView", "parseImageRoundLargeView", "parseImageRoundView", "parseImageView", "parseValueFadeLargeView", "parseValueFadeView", "parseValueLargeView", "parseValuePrimaryLargeView", "parseValuePrimaryView", "parseValueView", "parseVectorFadeLargeView", "parseVectorFadeView", "parseVectorLargeView", "parseVectorPrimaryLargeView", "parseVectorPrimaryView", "parseVectorView", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "setLeftData", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "setRightData", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "Companion", "Content", "ContentItem", "DialogListener", "LeftElement", "RightElement", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YmBottomSheetDialog extends YmBaseBottomSheetDialogFragment {
    private YmGuiBottomSheetDialogBinding _binding;
    public DialogListener listener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = YmBottomSheetDialog.class.getSimpleName();
    private static final String CONTENT_TAG = Content.class.getSimpleName();
    private final int titleDefaultAppearance = R$style.Text_Body_Medium;
    private final int titleAlertAppearance = R$style.Text_Body_Medium_Alert;

    /* compiled from: YmBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H&¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$DialogListener;", "", "handleDialogClose", "", "itemClick", "itemId", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DialogListener {

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void handleDialogClose(DialogListener dialogListener) {
            }
        }

        void handleDialogClose();

        void itemClick(Object itemId);
    }

    public final DialogListener getListener() {
        DialogListener dialogListener = this.listener;
        if (dialogListener != null) {
            return dialogListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return null;
    }

    public final void setListener(DialogListener dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "<set-?>");
        this.listener = dialogListener;
    }

    private final YmGuiBottomSheetDialogBinding getBinding() {
        YmGuiBottomSheetDialogBinding ymGuiBottomSheetDialogBinding = this._binding;
        Intrinsics.checkNotNull(ymGuiBottomSheetDialogBinding);
        return ymGuiBottomSheetDialogBinding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        DialogListener dialogListener;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof DialogListener) {
            dialogListener = (DialogListener) context;
        } else if (getParentFragment() instanceof DialogListener) {
            LifecycleOwner parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.DialogListener");
            dialogListener = (DialogListener) parentFragment;
        } else {
            throw new IllegalArgumentException(context + " must implement DialogListener");
        }
        setListener(dialogListener);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = YmGuiBottomSheetDialogBinding.inflate(inflater, container, false);
        ContentScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Content content;
        View viewCreateMenuLargeItemView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YmBaseBottomSheetDialogFragment.attachListener$default(this, new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.onViewCreated.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                BottomSheetDialogExtentionsKt.getBehavior(YmBottomSheetDialog.this).setPeekHeight(view.getMeasuredHeight());
            }
        }, null, 2, null);
        Bundle arguments = getArguments();
        if (arguments == null || (content = (Content) arguments.getParcelable(CONTENT_TAG)) == null) {
            return;
        }
        for (ContentItem contentItem : content.getItems()) {
            LinearLayout linearLayout = getBinding().itemsContainer;
            if (contentItem instanceof ContentItem.Headline) {
                viewCreateMenuLargeItemView = createHeadlineView((ContentItem.Headline) contentItem);
            } else if (contentItem instanceof ContentItem.MenuItem) {
                viewCreateMenuLargeItemView = createMenuItemView((ContentItem.MenuItem) contentItem);
            } else {
                if (!(contentItem instanceof ContentItem.MenuLargeItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                viewCreateMenuLargeItemView = createMenuLargeItemView((ContentItem.MenuLargeItem) contentItem);
            }
            linearLayout.addView(viewCreateMenuLargeItemView);
        }
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        getListener().handleDialogClose();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    public final void show(FragmentManager fragmentManager) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (isAdded()) {
            return;
        }
        if (getDialog() == null || !((dialog = getDialog()) == null || dialog.isShowing())) {
            super.showNow(fragmentManager, TAG);
        }
    }

    private final View createHeadlineView(ContentItem.Headline item) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        HeadlineSecondaryView headlineSecondaryView = new HeadlineSecondaryView(contextRequireContext, null, 0, 6, null);
        headlineSecondaryView.setText(item.getTitle());
        return headlineSecondaryView;
    }

    private final View createMenuItemView(final ContentItem.MenuItem item) {
        View valueFadeView;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        LeftElement leftElement = item.getLeftElement();
        if (leftElement instanceof LeftElement.Image) {
            valueFadeView = parseImageView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.ImageRound) {
            valueFadeView = parseImageRoundView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.Vector) {
            valueFadeView = parseVectorView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.VectorPrimary) {
            valueFadeView = parseVectorPrimaryView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.VectorFade) {
            valueFadeView = parseVectorFadeView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.Value) {
            valueFadeView = parseValueView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.ValuePrimary) {
            valueFadeView = parseValuePrimaryView(contextRequireContext, item);
        } else {
            valueFadeView = leftElement instanceof LeftElement.ValueFade ? parseValueFadeView(contextRequireContext, item) : parseEmptyView(contextRequireContext, item);
        }
        setRightData(setLeftData(valueFadeView, item.getLeftElement()), item.getRightElement());
        HasTitle hasTitle = valueFadeView instanceof HasTitle ? (HasTitle) valueFadeView : null;
        if (hasTitle != null) {
            hasTitle.setTitle(item.getTitle());
            hasTitle.setTitleAppearance(item.getAlert() ? this.titleAlertAppearance : this.titleDefaultAppearance);
        }
        valueFadeView.setEnabled(item.getEnable());
        valueFadeView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YmBottomSheetDialog.createMenuItemView$lambda$5$lambda$4(this.f$0, item, view);
            }
        });
        return valueFadeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMenuItemView$lambda$5$lambda$4(YmBottomSheetDialog this$0, ContentItem.MenuItem item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.getListener().itemClick(item.getItemId());
        this$0.dismiss();
    }

    private final View createMenuLargeItemView(final ContentItem.MenuLargeItem item) {
        View valueFadeLargeView;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        LeftElement leftElement = item.getLeftElement();
        if (leftElement instanceof LeftElement.Image) {
            valueFadeLargeView = parseImageLargeView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.ImageRound) {
            valueFadeLargeView = parseImageRoundLargeView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.Vector) {
            valueFadeLargeView = parseVectorLargeView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.VectorPrimary) {
            valueFadeLargeView = parseVectorPrimaryLargeView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.VectorFade) {
            valueFadeLargeView = parseVectorFadeLargeView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.Value) {
            valueFadeLargeView = parseValueLargeView(contextRequireContext, item);
        } else if (leftElement instanceof LeftElement.ValuePrimary) {
            valueFadeLargeView = parseValuePrimaryLargeView(contextRequireContext, item);
        } else {
            valueFadeLargeView = leftElement instanceof LeftElement.ValueFade ? parseValueFadeLargeView(contextRequireContext, item) : parseEmptyLargeView(contextRequireContext, item);
        }
        setRightData(setLeftData(valueFadeLargeView, item.getLeftElement()), item.getRightElement());
        String contentDescription = item.getContentDescription();
        if (contentDescription != null) {
            valueFadeLargeView.setContentDescription(contentDescription);
        }
        HasTitle hasTitle = valueFadeLargeView instanceof HasTitle ? (HasTitle) valueFadeLargeView : null;
        if (hasTitle != null) {
            hasTitle.setTitle(item.getTitle());
            hasTitle.setTitleAppearance(item.getAlert() ? this.titleAlertAppearance : this.titleDefaultAppearance);
        }
        HasSubTitle hasSubTitle = valueFadeLargeView instanceof HasSubTitle ? (HasSubTitle) valueFadeLargeView : null;
        if (hasSubTitle != null) {
            hasSubTitle.setSubTitle(item.getSubTitle());
        }
        valueFadeLargeView.setEnabled(item.getEnable());
        valueFadeLargeView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YmBottomSheetDialog.createMenuLargeItemView$lambda$10$lambda$9(this.f$0, item, view);
            }
        });
        return valueFadeLargeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMenuLargeItemView$lambda$10$lambda$9(YmBottomSheetDialog this$0, ContentItem.MenuLargeItem item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.getListener().itemClick(item.getItemId());
        this$0.dismiss();
    }

    private final View parseImageView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemImageIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemImageDetailView(context, null, 0, 6, null) : new ItemImageIconView(context, null, 0, 6, null);
    }

    private final View parseImageLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemImageIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemImageDetailLargeView(context, null, 0, 6, null) : new ItemImageIconLargeView(context, null, 0, 6, null);
    }

    private final View parseImageRoundView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemImageRoundIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemImageRoundDetailView(context, null, 0, 6, null) : new ItemImageRoundIconView(context, null, 0, 6, null);
    }

    private final View parseImageRoundLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemImageRoundIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemImageRoundDetailLargeView(context, null, 0, 6, null) : new ItemImageRoundIconLargeView(context, null, 0, 6, null);
    }

    private final View parseVectorView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemVectorIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemVectorDetailView(context, null, 0, 6, null) : new ItemVectorIconView(context, null, 0, 6, null);
    }

    private final View parseVectorLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemVectorIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemVectorDetailLargeView(context, null, 0, 6, null) : new ItemVectorIconLargeView(context, null, 0, 6, null);
    }

    private final View parseVectorPrimaryView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemVectorPrimaryIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemVectorPrimaryDetailView(context, null, 0, 6, null) : new ItemVectorPrimaryIconView(context, null, 0, 6, null);
    }

    private final View parseVectorPrimaryLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemVectorPrimaryIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemVectorPrimaryDetailLargeView(context, null, 0, 6, null) : new ItemVectorPrimaryIconLargeView(context, null, 0, 6, null);
    }

    private final View parseVectorFadeView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemVectorFadeIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemVectorFadeDetailView(context, null, 0, 6, null) : new ItemVectorFadeIconView(context, null, 0, 6, null);
    }

    private final View parseVectorFadeLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemVectorFadeIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemVectorFadeDetailLargeView(context, null, 0, 6, null) : new ItemVectorFadeIconLargeView(context, null, 0, 6, null);
    }

    private final View parseValueView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemValueIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemValueDetailView(context, null, 0, 6, null) : new ItemValueIconView(context, null, 0, 6, null);
    }

    private final View parseValueLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemValueIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemValueDetailLargeView(context, null, 0, 6, null) : new ItemValueIconLargeView(context, null, 0, 6, null);
    }

    private final View parseValuePrimaryView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemValuePrimaryIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemValuePrimaryDetailView(context, null, 0, 6, null) : new ItemValuePrimaryIconView(context, null, 0, 6, null);
    }

    private final View parseValuePrimaryLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemValuePrimaryIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemValuePrimaryDetailLargeView(context, null, 0, 6, null) : new ItemValuePrimaryIconLargeView(context, null, 0, 6, null);
    }

    private final View parseValueFadeView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemValueFadeIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemValueFadeDetailView(context, null, 0, 6, null) : new ItemValueFadeIconView(context, null, 0, 6, null);
    }

    private final View parseValueFadeLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemValueFadeIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemValueFadeDetailLargeView(context, null, 0, 6, null) : new ItemValueFadeIconLargeView(context, null, 0, 6, null);
    }

    private final View parseEmptyView(Context context, ContentItem.MenuItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemIconView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemDetailView(context, null, 0, 6, null) : new ItemIconView(context, null, 0, 6, null);
    }

    private final View parseEmptyLargeView(Context context, ContentItem.MenuLargeItem item) {
        RightElement rightElement = item.getRightElement();
        return rightElement instanceof RightElement.Icon ? new ItemIconLargeView(context, null, 0, 6, null) : rightElement instanceof RightElement.Value ? new ItemDetailLargeView(context, null, 0, 6, null) : new ItemIconLargeView(context, null, 0, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View setLeftData(View view, LeftElement leftElement) {
        if (leftElement instanceof LeftElement.HasImage) {
            HasLeftImage hasLeftImage = view instanceof HasLeftImage ? (HasLeftImage) view : null;
            if (hasLeftImage != null) {
                LeftElement.HasImage hasImage = (LeftElement.HasImage) leftElement;
                hasLeftImage.setLeftImage(AppCompatResources.getDrawable(view.getContext(), hasImage.getIconRes()));
                Integer badgeRes = hasImage.getBadgeRes();
                if (badgeRes != null) {
                    hasLeftImage.setBadge(AppCompatResources.getDrawable(view.getContext(), badgeRes.intValue()));
                }
            }
        } else if (leftElement instanceof LeftElement.HasValue) {
            HasLeftValue hasLeftValue = view instanceof HasLeftValue ? (HasLeftValue) view : null;
            if (hasLeftValue != null) {
                LeftElement.HasValue hasValue = (LeftElement.HasValue) leftElement;
                hasLeftValue.setLeftValue(hasValue.getValue());
                Integer badgeRes2 = hasValue.getBadgeRes();
                if (badgeRes2 != null) {
                    hasLeftValue.setBadge(AppCompatResources.getDrawable(view.getContext(), badgeRes2.intValue()));
                }
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View setRightData(View view, RightElement rightElement) {
        if (rightElement instanceof RightElement.Icon) {
            HasRightIcon hasRightIcon = view instanceof HasRightIcon ? (HasRightIcon) view : null;
            if (hasRightIcon != null) {
                RightElement.Icon icon = (RightElement.Icon) rightElement;
                hasRightIcon.setIcon(AppCompatResources.getDrawable(view.getContext(), icon.getIconRes()));
                Integer tintColor = icon.getTintColor();
                hasRightIcon.setRightIconTint(ColorStateList.valueOf(tintColor != null ? tintColor.intValue() : ContextCompat.getColor(view.getContext(), R$color.color_type_primary)));
            }
        } else if (rightElement instanceof RightElement.Value) {
            HasValue hasValue = view instanceof HasValue ? (HasValue) view : null;
            if (hasValue != null) {
                hasValue.setValue(((RightElement.Value) rightElement).getValue());
            }
            HasSubValue hasSubValue = view instanceof HasSubValue ? (HasSubValue) view : null;
            if (hasSubValue != null) {
                hasSubValue.setSubValue(((RightElement.Value) rightElement).getSubValue());
            }
        }
        return view;
    }

    /* compiled from: YmBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Companion;", "", "<init>", "()V", "Landroidx/fragment/app/FragmentManager;", "manager", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Content;", "content", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog;", "getDialog", "(Landroidx/fragment/app/FragmentManager;Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Content;)Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog;", "", "kotlin.jvm.PlatformType", "CONTENT_TAG", "Ljava/lang/String;", "TAG", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final YmBottomSheetDialog getDialog(FragmentManager manager, Content content) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(content, "content");
            Fragment fragmentFindFragmentByTag = manager.findFragmentByTag(YmBottomSheetDialog.TAG);
            YmBottomSheetDialog ymBottomSheetDialog = fragmentFindFragmentByTag instanceof YmBottomSheetDialog ? (YmBottomSheetDialog) fragmentFindFragmentByTag : null;
            if (ymBottomSheetDialog != null) {
                return ymBottomSheetDialog;
            }
            YmBottomSheetDialog ymBottomSheetDialog2 = new YmBottomSheetDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(YmBottomSheetDialog.CONTENT_TAG, content);
            ymBottomSheetDialog2.setArguments(bundle);
            return ymBottomSheetDialog2;
        }
    }

    /* compiled from: YmBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$Content;", "Landroid/os/Parcelable;", "", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem;", "items", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Content implements Parcelable {
        public static final Parcelable.Creator<Content> CREATOR = new Creator();
        private List<? extends ContentItem> items;

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Content> {
            @Override // android.os.Parcelable.Creator
            public final Content createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(Content.class.getClassLoader()));
                }
                return new Content(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            public final Content[] newArray(int i) {
                return new Content[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Content) && Intrinsics.areEqual(this.items, ((Content) other).items);
        }

        public int hashCode() {
            return this.items.hashCode();
        }

        public String toString() {
            return "Content(items=" + this.items + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List<? extends ContentItem> list = this.items;
            parcel.writeInt(list.size());
            Iterator<? extends ContentItem> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), flags);
            }
        }

        public Content(List<? extends ContentItem> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
        }

        public final List<ContentItem> getItems() {
            return this.items;
        }
    }

    /* compiled from: YmBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem;", "Landroid/os/Parcelable;", "()V", "Headline", "MenuItem", "MenuLargeItem", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$Headline;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$MenuItem;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$MenuLargeItem;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class ContentItem implements Parcelable {
        public /* synthetic */ ContentItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ContentItem() {
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$Headline;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "setTitle", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Headline extends ContentItem implements Parcelable {
            public static final Parcelable.Creator<Headline> CREATOR = new Creator();
            private String title;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Headline> {
                @Override // android.os.Parcelable.Creator
                public final Headline createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Headline(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                public final Headline[] newArray(int i) {
                    return new Headline[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Headline) && Intrinsics.areEqual(this.title, ((Headline) other).title);
            }

            public int hashCode() {
                return this.title.hashCode();
            }

            public String toString() {
                return "Headline(title=" + this.title + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.title);
            }

            public final String getTitle() {
                return this.title;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Headline(String title) {
                super(null);
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BE\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0014J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010*\u001a\u0004\b-\u0010,¨\u0006."}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$MenuItem;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem;", "Landroid/os/Parcelable;", "", "itemId", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "leftElement", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "rightElement", "", "enable", "alert", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;ZZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Object;", "getItemId", "()Ljava/lang/Object;", "Ljava/lang/String;", "getTitle", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "getLeftElement", "()Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "getRightElement", "()Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "Z", "getEnable", "()Z", "getAlert", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class MenuItem extends ContentItem implements Parcelable {
            public static final Parcelable.Creator<MenuItem> CREATOR = new Creator();
            private final boolean alert;
            private final boolean enable;
            private final Object itemId;
            private final LeftElement leftElement;
            private final RightElement rightElement;
            private final String title;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<MenuItem> {
                @Override // android.os.Parcelable.Creator
                public final MenuItem createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new MenuItem(parcel.readValue(MenuItem.class.getClassLoader()), parcel.readString(), (LeftElement) parcel.readParcelable(MenuItem.class.getClassLoader()), (RightElement) parcel.readParcelable(MenuItem.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0);
                }

                @Override // android.os.Parcelable.Creator
                public final MenuItem[] newArray(int i) {
                    return new MenuItem[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MenuItem)) {
                    return false;
                }
                MenuItem menuItem = (MenuItem) other;
                return Intrinsics.areEqual(this.itemId, menuItem.itemId) && Intrinsics.areEqual(this.title, menuItem.title) && Intrinsics.areEqual(this.leftElement, menuItem.leftElement) && Intrinsics.areEqual(this.rightElement, menuItem.rightElement) && this.enable == menuItem.enable && this.alert == menuItem.alert;
            }

            public int hashCode() {
                int iHashCode = ((this.itemId.hashCode() * 31) + this.title.hashCode()) * 31;
                LeftElement leftElement = this.leftElement;
                int iHashCode2 = (iHashCode + (leftElement == null ? 0 : leftElement.hashCode())) * 31;
                RightElement rightElement = this.rightElement;
                return ((((iHashCode2 + (rightElement != null ? rightElement.hashCode() : 0)) * 31) + Boolean.hashCode(this.enable)) * 31) + Boolean.hashCode(this.alert);
            }

            public String toString() {
                return "MenuItem(itemId=" + this.itemId + ", title=" + this.title + ", leftElement=" + this.leftElement + ", rightElement=" + this.rightElement + ", enable=" + this.enable + ", alert=" + this.alert + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeValue(this.itemId);
                parcel.writeString(this.title);
                parcel.writeParcelable(this.leftElement, flags);
                parcel.writeParcelable(this.rightElement, flags);
                parcel.writeInt(this.enable ? 1 : 0);
                parcel.writeInt(this.alert ? 1 : 0);
            }

            public /* synthetic */ MenuItem(Object obj, String str, LeftElement leftElement, RightElement rightElement, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, str, (i & 4) != 0 ? null : leftElement, (i & 8) != 0 ? null : rightElement, (i & 16) != 0 ? true : z, (i & 32) != 0 ? false : z2);
            }

            public final Object getItemId() {
                return this.itemId;
            }

            public final String getTitle() {
                return this.title;
            }

            public final LeftElement getLeftElement() {
                return this.leftElement;
            }

            public final RightElement getRightElement() {
                return this.rightElement;
            }

            public final boolean getEnable() {
                return this.enable;
            }

            public final boolean getAlert() {
                return this.alert;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MenuItem(Object itemId, String title, LeftElement leftElement, RightElement rightElement, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(title, "title");
                this.itemId = itemId;
                this.title = title;
                this.leftElement = leftElement;
                this.rightElement = rightElement;
                this.enable = z;
                this.alert = z2;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B]\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0016J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b&\u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b0\u0010/R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b1\u0010\u0013¨\u00062"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem$MenuLargeItem;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$ContentItem;", "Landroid/os/Parcelable;", "", "itemId", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subTitle", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "leftElement", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "rightElement", "", "enable", "alert", "contentDescription", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;ZZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Object;", "getItemId", "()Ljava/lang/Object;", "Ljava/lang/String;", "getTitle", "getSubTitle", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "getLeftElement", "()Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "getRightElement", "()Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "Z", "getEnable", "()Z", "getAlert", "getContentDescription", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class MenuLargeItem extends ContentItem implements Parcelable {
            public static final Parcelable.Creator<MenuLargeItem> CREATOR = new Creator();
            private final boolean alert;
            private final String contentDescription;
            private final boolean enable;
            private final Object itemId;
            private final LeftElement leftElement;
            private final RightElement rightElement;
            private final String subTitle;
            private final String title;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<MenuLargeItem> {
                @Override // android.os.Parcelable.Creator
                public final MenuLargeItem createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new MenuLargeItem(parcel.readValue(MenuLargeItem.class.getClassLoader()), parcel.readString(), parcel.readString(), (LeftElement) parcel.readParcelable(MenuLargeItem.class.getClassLoader()), (RightElement) parcel.readParcelable(MenuLargeItem.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                public final MenuLargeItem[] newArray(int i) {
                    return new MenuLargeItem[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MenuLargeItem)) {
                    return false;
                }
                MenuLargeItem menuLargeItem = (MenuLargeItem) other;
                return Intrinsics.areEqual(this.itemId, menuLargeItem.itemId) && Intrinsics.areEqual(this.title, menuLargeItem.title) && Intrinsics.areEqual(this.subTitle, menuLargeItem.subTitle) && Intrinsics.areEqual(this.leftElement, menuLargeItem.leftElement) && Intrinsics.areEqual(this.rightElement, menuLargeItem.rightElement) && this.enable == menuLargeItem.enable && this.alert == menuLargeItem.alert && Intrinsics.areEqual(this.contentDescription, menuLargeItem.contentDescription);
            }

            public int hashCode() {
                int iHashCode = ((this.itemId.hashCode() * 31) + this.title.hashCode()) * 31;
                String str = this.subTitle;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                LeftElement leftElement = this.leftElement;
                int iHashCode3 = (iHashCode2 + (leftElement == null ? 0 : leftElement.hashCode())) * 31;
                RightElement rightElement = this.rightElement;
                int iHashCode4 = (((((iHashCode3 + (rightElement == null ? 0 : rightElement.hashCode())) * 31) + Boolean.hashCode(this.enable)) * 31) + Boolean.hashCode(this.alert)) * 31;
                String str2 = this.contentDescription;
                return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "MenuLargeItem(itemId=" + this.itemId + ", title=" + this.title + ", subTitle=" + this.subTitle + ", leftElement=" + this.leftElement + ", rightElement=" + this.rightElement + ", enable=" + this.enable + ", alert=" + this.alert + ", contentDescription=" + this.contentDescription + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeValue(this.itemId);
                parcel.writeString(this.title);
                parcel.writeString(this.subTitle);
                parcel.writeParcelable(this.leftElement, flags);
                parcel.writeParcelable(this.rightElement, flags);
                parcel.writeInt(this.enable ? 1 : 0);
                parcel.writeInt(this.alert ? 1 : 0);
                parcel.writeString(this.contentDescription);
            }

            public final Object getItemId() {
                return this.itemId;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getSubTitle() {
                return this.subTitle;
            }

            public final LeftElement getLeftElement() {
                return this.leftElement;
            }

            public final RightElement getRightElement() {
                return this.rightElement;
            }

            public final boolean getEnable() {
                return this.enable;
            }

            public final boolean getAlert() {
                return this.alert;
            }

            public final String getContentDescription() {
                return this.contentDescription;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MenuLargeItem(Object itemId, String title, String str, LeftElement leftElement, RightElement rightElement, boolean z, boolean z2, String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(title, "title");
                this.itemId = itemId;
                this.title = title;
                this.subTitle = str;
                this.leftElement = leftElement;
                this.rightElement = rightElement;
                this.enable = z;
                this.alert = z2;
                this.contentDescription = str2;
            }
        }
    }

    /* compiled from: YmBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Landroid/os/Parcelable;", "()V", "HasImage", "HasValue", "Image", "ImageRound", "Value", "ValueFade", "ValuePrimary", "Vector", "VectorFade", "VectorPrimary", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$Image;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$ImageRound;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$Value;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$ValueFade;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$ValuePrimary;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$Vector;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$VectorFade;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$VectorPrimary;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class LeftElement implements Parcelable {

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasImage;", "", "badgeRes", "", "getBadgeRes", "()Ljava/lang/Integer;", "iconRes", "getIconRes", "()I", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface HasImage {
            Integer getBadgeRes();

            int getIconRes();
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasValue;", "", "badgeRes", "", "getBadgeRes", "()Ljava/lang/Integer;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "getValue", "()Ljava/lang/String;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface HasValue {
            Integer getBadgeRes();

            String getValue();
        }

        public /* synthetic */ LeftElement(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private LeftElement() {
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$Image;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasImage;", "Landroid/os/Parcelable;", "", "iconRes", "badgeRes", "<init>", "(ILjava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getIconRes", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Image extends LeftElement implements HasImage, Parcelable {
            public static final Parcelable.Creator<Image> CREATOR = new Creator();
            private final Integer badgeRes;
            private final int iconRes;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Image> {
                @Override // android.os.Parcelable.Creator
                public final Image createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Image(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final Image[] newArray(int i) {
                    return new Image[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Image)) {
                    return false;
                }
                Image image = (Image) other;
                return this.iconRes == image.iconRes && Intrinsics.areEqual(this.badgeRes, image.badgeRes);
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.iconRes) * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "Image(iconRes=" + this.iconRes + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.iconRes);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public int getIconRes() {
                return this.iconRes;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            public Image(int i, Integer num) {
                super(null);
                this.iconRes = i;
                this.badgeRes = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$ImageRound;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasImage;", "Landroid/os/Parcelable;", "", "iconRes", "badgeRes", "<init>", "(ILjava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getIconRes", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ImageRound extends LeftElement implements HasImage, Parcelable {
            public static final Parcelable.Creator<ImageRound> CREATOR = new Creator();
            private final Integer badgeRes;
            private final int iconRes;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<ImageRound> {
                @Override // android.os.Parcelable.Creator
                public final ImageRound createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ImageRound(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final ImageRound[] newArray(int i) {
                    return new ImageRound[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImageRound)) {
                    return false;
                }
                ImageRound imageRound = (ImageRound) other;
                return this.iconRes == imageRound.iconRes && Intrinsics.areEqual(this.badgeRes, imageRound.badgeRes);
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.iconRes) * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "ImageRound(iconRes=" + this.iconRes + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.iconRes);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public int getIconRes() {
                return this.iconRes;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            public ImageRound(int i, Integer num) {
                super(null);
                this.iconRes = i;
                this.badgeRes = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$Vector;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasImage;", "Landroid/os/Parcelable;", "", "iconRes", "badgeRes", "<init>", "(ILjava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getIconRes", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Vector extends LeftElement implements HasImage, Parcelable {
            public static final Parcelable.Creator<Vector> CREATOR = new Creator();
            private final Integer badgeRes;
            private final int iconRes;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Vector> {
                @Override // android.os.Parcelable.Creator
                public final Vector createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Vector(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final Vector[] newArray(int i) {
                    return new Vector[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Vector)) {
                    return false;
                }
                Vector vector = (Vector) other;
                return this.iconRes == vector.iconRes && Intrinsics.areEqual(this.badgeRes, vector.badgeRes);
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.iconRes) * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "Vector(iconRes=" + this.iconRes + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.iconRes);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public int getIconRes() {
                return this.iconRes;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            public Vector(int i, Integer num) {
                super(null);
                this.iconRes = i;
                this.badgeRes = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$VectorPrimary;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasImage;", "Landroid/os/Parcelable;", "", "iconRes", "badgeRes", "<init>", "(ILjava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getIconRes", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class VectorPrimary extends LeftElement implements HasImage, Parcelable {
            public static final Parcelable.Creator<VectorPrimary> CREATOR = new Creator();
            private final Integer badgeRes;
            private final int iconRes;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<VectorPrimary> {
                @Override // android.os.Parcelable.Creator
                public final VectorPrimary createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new VectorPrimary(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final VectorPrimary[] newArray(int i) {
                    return new VectorPrimary[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VectorPrimary)) {
                    return false;
                }
                VectorPrimary vectorPrimary = (VectorPrimary) other;
                return this.iconRes == vectorPrimary.iconRes && Intrinsics.areEqual(this.badgeRes, vectorPrimary.badgeRes);
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.iconRes) * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "VectorPrimary(iconRes=" + this.iconRes + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.iconRes);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public int getIconRes() {
                return this.iconRes;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            public VectorPrimary(int i, Integer num) {
                super(null);
                this.iconRes = i;
                this.badgeRes = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$VectorFade;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasImage;", "Landroid/os/Parcelable;", "", "iconRes", "badgeRes", "<init>", "(ILjava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getIconRes", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class VectorFade extends LeftElement implements HasImage, Parcelable {
            public static final Parcelable.Creator<VectorFade> CREATOR = new Creator();
            private final Integer badgeRes;
            private final int iconRes;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<VectorFade> {
                @Override // android.os.Parcelable.Creator
                public final VectorFade createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new VectorFade(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final VectorFade[] newArray(int i) {
                    return new VectorFade[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VectorFade)) {
                    return false;
                }
                VectorFade vectorFade = (VectorFade) other;
                return this.iconRes == vectorFade.iconRes && Intrinsics.areEqual(this.badgeRes, vectorFade.badgeRes);
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.iconRes) * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "VectorFade(iconRes=" + this.iconRes + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.iconRes);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public int getIconRes() {
                return this.iconRes;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasImage
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            public VectorFade(int i, Integer num) {
                super(null);
                this.iconRes = i;
                this.badgeRes = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$Value;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasValue;", "Landroid/os/Parcelable;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "badgeRes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getValue", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Value extends LeftElement implements HasValue, Parcelable {
            public static final Parcelable.Creator<Value> CREATOR = new Creator();
            private final Integer badgeRes;
            private final String value;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Value> {
                @Override // android.os.Parcelable.Creator
                public final Value createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Value(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final Value[] newArray(int i) {
                    return new Value[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Value)) {
                    return false;
                }
                Value value = (Value) other;
                return Intrinsics.areEqual(this.value, value.value) && Intrinsics.areEqual(this.badgeRes, value.badgeRes);
            }

            public int hashCode() {
                int iHashCode = this.value.hashCode() * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "Value(value=" + this.value + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.value);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasValue
            public String getValue() {
                return this.value;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasValue
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Value(String value, Integer num) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
                this.badgeRes = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$ValuePrimary;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasValue;", "Landroid/os/Parcelable;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "badgeRes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getValue", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ValuePrimary extends LeftElement implements HasValue, Parcelable {
            public static final Parcelable.Creator<ValuePrimary> CREATOR = new Creator();
            private final Integer badgeRes;
            private final String value;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<ValuePrimary> {
                @Override // android.os.Parcelable.Creator
                public final ValuePrimary createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ValuePrimary(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final ValuePrimary[] newArray(int i) {
                    return new ValuePrimary[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ValuePrimary)) {
                    return false;
                }
                ValuePrimary valuePrimary = (ValuePrimary) other;
                return Intrinsics.areEqual(this.value, valuePrimary.value) && Intrinsics.areEqual(this.badgeRes, valuePrimary.badgeRes);
            }

            public int hashCode() {
                int iHashCode = this.value.hashCode() * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "ValuePrimary(value=" + this.value + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.value);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasValue
            public String getValue() {
                return this.value;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasValue
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ValuePrimary(String value, Integer num) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
                this.badgeRes = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$ValueFade;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$LeftElement$HasValue;", "Landroid/os/Parcelable;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "badgeRes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getValue", "Ljava/lang/Integer;", "getBadgeRes", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ValueFade extends LeftElement implements HasValue, Parcelable {
            public static final Parcelable.Creator<ValueFade> CREATOR = new Creator();
            private final Integer badgeRes;
            private final String value;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<ValueFade> {
                @Override // android.os.Parcelable.Creator
                public final ValueFade createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ValueFade(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final ValueFade[] newArray(int i) {
                    return new ValueFade[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ValueFade)) {
                    return false;
                }
                ValueFade valueFade = (ValueFade) other;
                return Intrinsics.areEqual(this.value, valueFade.value) && Intrinsics.areEqual(this.badgeRes, valueFade.badgeRes);
            }

            public int hashCode() {
                int iHashCode = this.value.hashCode() * 31;
                Integer num = this.badgeRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "ValueFade(value=" + this.value + ", badgeRes=" + this.badgeRes + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.value);
                Integer num = this.badgeRes;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasValue
            public String getValue() {
                return this.value;
            }

            @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBottomSheetDialog.LeftElement.HasValue
            public Integer getBadgeRes() {
                return this.badgeRes;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ValueFade(String value, Integer num) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
                this.badgeRes = num;
            }
        }
    }

    /* compiled from: YmBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "Landroid/os/Parcelable;", "()V", "Icon", "Value", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement$Icon;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement$Value;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class RightElement implements Parcelable {
        public /* synthetic */ RightElement(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private RightElement() {
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement$Icon;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "", "iconRes", "tintColor", "<init>", "(ILjava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getIconRes", "Ljava/lang/Integer;", "getTintColor", "()Ljava/lang/Integer;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Icon extends RightElement {
            public static final Parcelable.Creator<Icon> CREATOR = new Creator();
            private final int iconRes;
            private final Integer tintColor;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Icon> {
                @Override // android.os.Parcelable.Creator
                public final Icon createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Icon(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                @Override // android.os.Parcelable.Creator
                public final Icon[] newArray(int i) {
                    return new Icon[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Icon)) {
                    return false;
                }
                Icon icon = (Icon) other;
                return this.iconRes == icon.iconRes && Intrinsics.areEqual(this.tintColor, icon.tintColor);
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.iconRes) * 31;
                Integer num = this.tintColor;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "Icon(iconRes=" + this.iconRes + ", tintColor=" + this.tintColor + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.iconRes);
                Integer num = this.tintColor;
                if (num == null) {
                    iIntValue = 0;
                } else {
                    parcel.writeInt(1);
                    iIntValue = num.intValue();
                }
                parcel.writeInt(iIntValue);
            }

            public final int getIconRes() {
                return this.iconRes;
            }

            public final Integer getTintColor() {
                return this.tintColor;
            }

            public Icon(int i, Integer num) {
                super(null);
                this.iconRes = i;
                this.tintColor = num;
            }
        }

        /* compiled from: YmBottomSheetDialog.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement$Value;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBottomSheetDialog$RightElement;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "subValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getValue", "getSubValue", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Value extends RightElement {
            public static final Parcelable.Creator<Value> CREATOR = new Creator();
            private final String subValue;
            private final String value;

            /* compiled from: YmBottomSheetDialog.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Value> {
                @Override // android.os.Parcelable.Creator
                public final Value createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Value(parcel.readString(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                public final Value[] newArray(int i) {
                    return new Value[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Value)) {
                    return false;
                }
                Value value = (Value) other;
                return Intrinsics.areEqual(this.value, value.value) && Intrinsics.areEqual(this.subValue, value.subValue);
            }

            public int hashCode() {
                int iHashCode = this.value.hashCode() * 31;
                String str = this.subValue;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "Value(value=" + this.value + ", subValue=" + this.subValue + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.value);
                parcel.writeString(this.subValue);
            }

            public final String getValue() {
                return this.value;
            }

            public final String getSubValue() {
                return this.subValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Value(String value, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
                this.subValue = str;
            }
        }
    }
}
