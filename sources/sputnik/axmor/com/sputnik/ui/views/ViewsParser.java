package sputnik.axmor.com.sputnik.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sputnik.common.entities.instructions.Instruction;
import com.sputnik.common.entities.views.BaseButtonView;
import com.sputnik.common.entities.views.BaseView;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions;

/* compiled from: ViewsParser.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/ViewsParser;", "", "<init>", "()V", "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/ViewGroup;", "rootLayout", "Lcom/sputnik/common/entities/instructions/Instruction;", "instruction", "Landroid/widget/TextView;", "toolbar", "layoutViews", "layoutButtons", "Lkotlin/Function1;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions;", "", "onClickAction", "attachViews", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Lcom/sputnik/common/entities/instructions/Instruction;Landroid/widget/TextView;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewsParser {
    public void attachViews(LayoutInflater layoutInflater, ViewGroup rootLayout, Instruction instruction, TextView toolbar, ViewGroup layoutViews, ViewGroup layoutButtons, final Function1<? super ClickActions, Unit> onClickAction) {
        View view;
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(layoutViews, "layoutViews");
        Intrinsics.checkNotNullParameter(layoutButtons, "layoutButtons");
        Intrinsics.checkNotNullParameter(onClickAction, "onClickAction");
        layoutViews.removeAllViews();
        layoutButtons.removeAllViews();
        toolbar.setText(instruction.getToolbarTitle());
        StringsKt.isBlank(instruction.getToolbarTitle());
        toolbar.setText(instruction.getToolbarTitle());
        ViewKt.visible(toolbar);
        final BaseView baseView = (BaseView) CollectionsKt.lastOrNull((List) instruction.getViews());
        if (baseView != null && (baseView instanceof BaseButtonView) && ((BaseButtonView) baseView).getNeedSeparateToBottom()) {
            View view2 = baseView.getView(layoutInflater);
            SafeClickListenerKt.setSafeOnClickListener$default(view2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.views.ViewsParser$attachViews$3$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                    invoke2(view3);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2(android.view.View r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        com.sputnik.common.entities.views.BaseView r3 = r1
                        com.sputnik.common.entities.views.BaseButtonView r3 = (com.sputnik.common.entities.views.BaseButtonView) r3
                        java.lang.String r3 = r3.getDeeplink()
                        int r0 = r3.hashCode()
                        r1 = -1273775369(0xffffffffb413baf7, float:-1.3758459E-7)
                        if (r0 == r1) goto L3e
                        r1 = 3377907(0x338af3, float:4.733456E-39)
                        if (r0 == r1) goto L2f
                        r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
                        if (r0 == r1) goto L21
                        goto L46
                    L21:
                        java.lang.String r0 = "close"
                        boolean r3 = r3.equals(r0)
                        if (r3 == 0) goto L46
                        sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$CloseAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$CloseAction
                        r3.<init>()
                        goto L59
                    L2f:
                        java.lang.String r0 = "next"
                        boolean r3 = r3.equals(r0)
                        if (r3 != 0) goto L38
                        goto L46
                    L38:
                        sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$NextAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$NextAction
                        r3.<init>()
                        goto L59
                    L3e:
                        java.lang.String r0 = "previous"
                        boolean r3 = r3.equals(r0)
                        if (r3 != 0) goto L54
                    L46:
                        sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$DeeplinkAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$DeeplinkAction
                        com.sputnik.common.entities.views.BaseView r0 = r1
                        com.sputnik.common.entities.views.BaseButtonView r0 = (com.sputnik.common.entities.views.BaseButtonView) r0
                        java.lang.String r0 = r0.getDeeplink()
                        r3.<init>(r0)
                        goto L59
                    L54:
                        sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$PreviousAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$PreviousAction
                        r3.<init>()
                    L59:
                        kotlin.jvm.functions.Function1<sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions, kotlin.Unit> r0 = r2
                        r0.invoke(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.views.ViewsParser$attachViews$3$1$1.invoke2(android.view.View):void");
                }
            }, 1, null);
            layoutButtons.addView(view2);
        }
        for (final BaseView baseView2 : instruction.getViews()) {
            if (baseView2 instanceof BaseButtonView) {
                if (((BaseButtonView) baseView2).getNeedSeparateToBottom()) {
                    view = null;
                } else {
                    view = baseView2.getView(layoutInflater);
                    SafeClickListenerKt.setSafeOnClickListener$default(view, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.views.ViewsParser$attachViews$4$view$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                            invoke2(view3);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void invoke2(android.view.View r3) {
                            /*
                                r2 = this;
                                java.lang.String r0 = "it"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                com.sputnik.common.entities.views.BaseView r3 = r1
                                com.sputnik.common.entities.views.BaseButtonView r3 = (com.sputnik.common.entities.views.BaseButtonView) r3
                                java.lang.String r3 = r3.getDeeplink()
                                int r0 = r3.hashCode()
                                r1 = -1273775369(0xffffffffb413baf7, float:-1.3758459E-7)
                                if (r0 == r1) goto L3e
                                r1 = 3377907(0x338af3, float:4.733456E-39)
                                if (r0 == r1) goto L2f
                                r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
                                if (r0 == r1) goto L21
                                goto L46
                            L21:
                                java.lang.String r0 = "close"
                                boolean r3 = r3.equals(r0)
                                if (r3 == 0) goto L46
                                sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$CloseAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$CloseAction
                                r3.<init>()
                                goto L59
                            L2f:
                                java.lang.String r0 = "next"
                                boolean r3 = r3.equals(r0)
                                if (r3 != 0) goto L38
                                goto L46
                            L38:
                                sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$NextAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$NextAction
                                r3.<init>()
                                goto L59
                            L3e:
                                java.lang.String r0 = "previous"
                                boolean r3 = r3.equals(r0)
                                if (r3 != 0) goto L54
                            L46:
                                sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$DeeplinkAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$DeeplinkAction
                                com.sputnik.common.entities.views.BaseView r0 = r1
                                com.sputnik.common.entities.views.BaseButtonView r0 = (com.sputnik.common.entities.views.BaseButtonView) r0
                                java.lang.String r0 = r0.getDeeplink()
                                r3.<init>(r0)
                                goto L59
                            L54:
                                sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$PreviousAction r3 = new sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions$PreviousAction
                                r3.<init>()
                            L59:
                                kotlin.jvm.functions.Function1<sputnik.axmor.com.sputnik.ui.views.click_actions.ClickActions, kotlin.Unit> r0 = r2
                                r0.invoke(r3)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.views.ViewsParser$attachViews$4$view$1$1.invoke2(android.view.View):void");
                        }
                    }, 1, null);
                }
            } else {
                view = baseView2.getView(layoutInflater);
            }
            if (view != null) {
                layoutViews.addView(view);
            }
        }
    }
}
