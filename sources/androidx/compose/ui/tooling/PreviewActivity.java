package androidx.compose.ui.tooling;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.view.ComponentActivity;
import androidx.view.compose.ComponentActivityKt;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PreviewActivity.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/tooling/PreviewActivity;", "Landroidx/activity/ComponentActivity;", "()V", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setComposableContent", "composableFqn", "setParameterizedContent", "className", "methodName", "parameterProvider", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreviewActivity extends ComponentActivity {
    private final String TAG = "PreviewActivity";

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String stringExtra;
        super.onCreate(savedInstanceState);
        if ((getApplicationInfo().flags & 2) == 0) {
            Log.d(this.TAG, "Application is not debuggable. Compose Preview not allowed.");
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("composable")) == null) {
            return;
        }
        setComposableContent(stringExtra);
    }

    private final void setComposableContent(String composableFqn) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Log.d(this.TAG, "PreviewActivity has composable " + composableFqn);
        final String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(composableFqn, '.', null, 2, null);
        final String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(composableFqn, '.', (String) null, 2, (Object) null);
        String stringExtra = getIntent().getStringExtra("parameterProviderClassName");
        if (stringExtra != null) {
            setParameterizedContent(strSubstringBeforeLast$default, strSubstringAfterLast$default, stringExtra);
            return;
        }
        Log.d(this.TAG, "Previewing '" + strSubstringAfterLast$default + "' without a parameter provider.");
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-840626948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity.setComposableContent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Exception {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) throws Exception {
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-840626948, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setComposableContent.<anonymous> (PreviewActivity.android.kt:76)");
                    }
                    ComposableInvoker.INSTANCE.invokeComposable(strSubstringBeforeLast$default, strSubstringAfterLast$default, composer, new Object[0]);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 1, null);
    }

    private final void setParameterizedContent(final String className, final String methodName, String parameterProvider) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Log.d(this.TAG, "Previewing '" + methodName + "' with parameter provider: '" + parameterProvider + '\'');
        final Object[] previewProviderParameters = PreviewUtils_androidKt.getPreviewProviderParameters(PreviewUtils_androidKt.asPreviewProviderClass(parameterProvider), getIntent().getIntExtra("parameterProviderIndex", -1));
        if (previewProviderParameters.length > 1) {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-861939235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 3) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-861939235, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:109)");
                    }
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
                    final Object[] objArr = previewProviderParameters;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(958604965, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(958604965, i2, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:123)");
                                }
                                Function2<Composer, Integer, Unit> function2M2072getLambda1$ui_tooling_release = ComposableSingletons$PreviewActivity_androidKt.INSTANCE.m2072getLambda1$ui_tooling_release();
                                boolean zChangedInstance = composer2.changedInstance(objArr);
                                final MutableIntState mutableIntState2 = mutableIntState;
                                final Object[] objArr2 = objArr;
                                Object objRememberedValue2 = composer2.rememberedValue();
                                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            MutableIntState mutableIntState3 = mutableIntState2;
                                            mutableIntState3.setIntValue((mutableIntState3.getIntValue() + 1) % objArr2.length);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue2);
                                }
                                FloatingActionButtonKt.m646ExtendedFloatingActionButtonwqdebIU(function2M2072getLambda1$ui_tooling_release, (Function0) objRememberedValue2, null, null, null, null, 0L, 0L, null, composer2, 6, 508);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composer, 54);
                    final String str = className;
                    final String str2 = methodName;
                    final Object[] objArr2 = previewProviderParameters;
                    ScaffoldKt.m658Scaffold27mzLpw(null, null, null, null, null, composableLambdaRememberComposableLambda, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(57310875, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) throws Exception {
                            invoke(paddingValues, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PaddingValues paddingValues, Composer composer2, int i2) throws Exception {
                            if ((i2 & 6) == 0) {
                                i2 |= composer2.changed(paddingValues) ? 4 : 2;
                            }
                            if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(57310875, i2, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:113)");
                                }
                                Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
                                String str3 = str;
                                String str4 = str2;
                                Object[] objArr3 = objArr2;
                                MutableIntState mutableIntState2 = mutableIntState;
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer composerM727constructorimpl = Updater.m727constructorimpl(composer2);
                                Updater.m728setimpl(composerM727constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m728setimpl(composerM727constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposableInvoker.INSTANCE.invokeComposable(str3, str4, composer2, objArr3[mutableIntState2.getIntValue()]);
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composer, 54), composer, 196608, 12582912, 131039);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 1, null);
        } else {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1901447514, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Exception {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) throws Exception {
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1901447514, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:134)");
                        }
                        ComposableInvoker composableInvoker = ComposableInvoker.INSTANCE;
                        String str = className;
                        String str2 = methodName;
                        Object[] objArr = previewProviderParameters;
                        composableInvoker.invokeComposable(str, str2, composer, Arrays.copyOf(objArr, objArr.length));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), 1, null);
        }
    }
}
