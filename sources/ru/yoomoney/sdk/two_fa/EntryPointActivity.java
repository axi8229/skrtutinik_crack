package ru.yoomoney.sdk.two_fa;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.view.ComponentActivity;
import androidx.view.compose.ComponentActivityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.Palette;
import ru.yoomoney.sdk.guiCompose.theme.ThemesKt;
import ru.yoomoney.sdk.guiCompose.theme.YooColors;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.two_fa.di.DaggerTwoFaActivityComponent;
import ru.yoomoney.sdk.two_fa.di.TwoFaActivityComponent;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractor;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor;
import ru.yoomoney.sdk.two_fa.parcelable.PaletteParcelable;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractor;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: EntryPointActivity.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/two_fa/EntryPointActivity;", "Landroidx/activity/ComponentActivity;", "()V", EntryPointActivity.KEY_CONFIG, "Lru/yoomoney/sdk/two_fa/Config;", "getConfig", "()Lru/yoomoney/sdk/two_fa/Config;", "config$delegate", "Lkotlin/Lazy;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "initDaggerComponents", "Lru/yoomoney/sdk/two_fa/di/TwoFaActivityComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPointActivity extends ComponentActivity {
    private static final String KEY_CONFIG = "config";

    /* renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config = LazyKt.lazy(new Function0<Config>() { // from class: ru.yoomoney.sdk.two_fa.EntryPointActivity$config$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config invoke() {
            Parcelable parcelableExtra = this.this$0.getIntent().getParcelableExtra("config");
            if (parcelableExtra != null) {
                return (Config) parcelableExtra;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    });
    private final ResourceMapper resourceMapper = new ResourceMapper(this);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public final Config getConfig() {
        return (Config) this.config.getValue();
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TwoFaActivityComponent twoFaActivityComponentInitDaggerComponents = initDaggerComponents();
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(670972132, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.EntryPointActivity.onCreate.1
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
                Palette palette;
                FontFamily FontFamily;
                List<FontResource> fontResources;
                PaletteParcelable palette2;
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670972132, i, -1, "ru.yoomoney.sdk.two_fa.EntryPointActivity.onCreate.<anonymous> (EntryPointActivity.kt:30)");
                    }
                    Style style = EntryPointActivity.this.getConfig().getStyle();
                    if (style == null || (palette2 = style.getPalette()) == null || (palette = palette2.getValue()) == null) {
                        YooColors.Companion companion = YooColors.INSTANCE;
                        palette = new Palette(companion.getDefaultColorsLight(), companion.getDefaultColorsDark());
                    }
                    Palette palette3 = palette;
                    Style style2 = EntryPointActivity.this.getConfig().getStyle();
                    boolean darkTheme = style2 != null ? style2.getDarkTheme() : false;
                    Style style3 = EntryPointActivity.this.getConfig().getStyle();
                    if (style3 == null || (fontResources = style3.getFontResources()) == null) {
                        FontFamily = null;
                    } else {
                        List<FontResource> list = fontResources;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (FontResource fontResource : list) {
                            arrayList.add(FontKt.m1835FontYpTlLL0$default(fontResource.getResId(), new FontWeight(fontResource.getWeight()), 0, 0, 12, null));
                        }
                        FontFamily = FontFamilyKt.FontFamily(arrayList);
                    }
                    FontFamily fontFamily = FontFamily;
                    final TwoFaActivityComponent twoFaActivityComponent = twoFaActivityComponentInitDaggerComponents;
                    final EntryPointActivity entryPointActivity = EntryPointActivity.this;
                    ThemesKt.YooTheme(palette3, darkTheme, null, fontFamily, ComposableLambdaKt.composableLambda(composer, 1457896485, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.EntryPointActivity.onCreate.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) throws Resources.NotFoundException {
                            if ((i2 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1457896485, i2, -1, "ru.yoomoney.sdk.two_fa.EntryPointActivity.onCreate.<anonymous>.<anonymous> (EntryPointActivity.kt:47)");
                                }
                                final int iM996toArgb8_81llA = ColorKt.m996toArgb8_81llA(YooTheme.INSTANCE.getColors(composer2, YooTheme.$stable).getTheme().getTintBg());
                                final EntryPointActivity entryPointActivity2 = entryPointActivity;
                                EffectsKt.SideEffect(new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.EntryPointActivity.onCreate.1.2.1
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
                                        entryPointActivity2.getWindow().setStatusBarColor(iM996toArgb8_81llA);
                                        entryPointActivity2.getWindow().setNavigationBarColor(iM996toArgb8_81llA);
                                        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(entryPointActivity2.getWindow(), entryPointActivity2.getWindow().getDecorView());
                                        insetsController.setAppearanceLightStatusBars(true);
                                        insetsController.setAppearanceLightNavigationBars(true);
                                    }
                                }, composer2, 0);
                                EntryPointInteractor entryPointInteractor = twoFaActivityComponent.getEntryPointInteractor();
                                SmsConfirmInteractor smsConfirmInteractor = twoFaActivityComponent.getSmsConfirmInteractor();
                                PhoneCallInteractor phoneCallInteractor = twoFaActivityComponent.getPhoneCallInteractor();
                                EmailConfirmInteractor emailConfirmInteractor = twoFaActivityComponent.getEmailConfirmInteractor();
                                Config config = entryPointActivity.getConfig();
                                ResourceMapper resourceMapper = entryPointActivity.resourceMapper;
                                AnalyticsLogger twoFaAnalyticsLogger$two_fa_release = YooMoneyTwoFa.INSTANCE.getTwoFaAnalyticsLogger$two_fa_release();
                                final EntryPointActivity entryPointActivity3 = entryPointActivity;
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.EntryPointActivity.onCreate.1.2.2
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
                                        entryPointActivity3.setResult(-1);
                                        entryPointActivity3.finish();
                                    }
                                };
                                final EntryPointActivity entryPointActivity4 = entryPointActivity;
                                TwoFaNavHostKt.TwoFaNavHost(entryPointInteractor, smsConfirmInteractor, phoneCallInteractor, emailConfirmInteractor, config, resourceMapper, twoFaAnalyticsLogger$two_fa_release, function0, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.EntryPointActivity.onCreate.1.2.3
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
                                        entryPointActivity4.finish();
                                    }
                                }, composer2, 294912);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), composer, Palette.$stable | 24576, 4);
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

    private final TwoFaActivityComponent initDaggerComponents() {
        return DaggerTwoFaActivityComponent.builder().context(this).config(getConfig()).build();
    }

    /* compiled from: EntryPointActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/two_fa/EntryPointActivity$Companion;", "", "()V", "KEY_CONFIG", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", EntryPointActivity.KEY_CONFIG, "Lru/yoomoney/sdk/two_fa/Config;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context context, Config config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intent intentPutExtra = new Intent(context, (Class<?>) EntryPointActivity.class).putExtra(EntryPointActivity.KEY_CONFIG, config);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            return intentPutExtra;
        }
    }
}
