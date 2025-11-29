package ru.yoomoney.sdk.kassa.payments.ui.view;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.card.MaterialCardView;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.kassa.payments.R$color;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.contract.C2245o0;
import ru.yoomoney.sdk.kassa.payments.extensions.l;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.a;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.b;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.c;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.d;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.e;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.f;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.g;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.h;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.i;
import ru.yoomoney.sdk.kassa.payments.metrics.bankCard.j;
import ru.yoomoney.sdk.kassa.payments.model.K;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView;
import ru.yoomoney.sdk.kassa.payments.utils.m;
import ru.yoomoney.sdk.kassa.payments.utils.n;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0006\u0095\u0001\u0096\u0001\u0097\u0001B.\b\u0007\u0012\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001\u0012\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001\u0012\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u0011¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J!\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u000e\u0010\u0007J+\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0017\u0010\u0007J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001fJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010\u001dJ\u0017\u0010\"\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010$J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b%\u0010\u001dJ\u0015\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010!J#\u0010,\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020\u0018H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010!J\u000f\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u0010!J\u000f\u00100\u001a\u00020\u0018H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0018H\u0002¢\u0006\u0004\b2\u00101J\u000f\u00103\u001a\u00020\u0018H\u0002¢\u0006\u0004\b3\u00101J\u0019\u00105\u001a\u00020\u00112\b\b\u0001\u00104\u001a\u00020\u0011H\u0003¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010!J\u0013\u00109\u001a\u00020\u0004*\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u0013\u0010;\u001a\u00020\u0004*\u000208H\u0002¢\u0006\u0004\b;\u0010:J7\u0010A\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u0002082\b\b\u0001\u0010?\u001a\u00020\u00112\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00180\bH\u0002¢\u0006\u0004\bA\u0010BJ!\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u0002082\b\b\u0001\u0010?\u001a\u00020\u0011H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\u00042\u0006\u0010C\u001a\u000208H\u0002¢\u0006\u0004\bF\u0010:J\u0013\u0010H\u001a\u00020\u0004*\u00020GH\u0002¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00020\u0004*\u00020GH\u0002¢\u0006\u0004\bJ\u0010IJ\u0017\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010XR\u0014\u0010Z\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010XR\u0014\u0010[\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010XR\u0014\u0010\\\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010]R\u0014\u0010_\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010]R\u0014\u0010`\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010]R\u0014\u0010b\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010d\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010]R\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010gR\u0014\u0010i\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010gR\u0014\u0010j\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010gR\u001c\u0010m\u001a\n l*\u0004\u0018\u00010k0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\"\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\"\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010sR\"\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010sR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010xR$\u0010{\u001a\u00020y2\u0006\u0010z\u001a\u00020y8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b{\u0010|\"\u0004\b}\u0010~R%\u0010\u007f\u001a\u00020y2\u0006\u0010z\u001a\u00020y8\u0002@BX\u0082\u000e¢\u0006\r\n\u0004\b\u007f\u0010|\"\u0005\b\u0080\u0001\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010|R\u0019\u0010\u0082\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0084\u0001\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R\u0017\u0010\u0085\u0001\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u0017\u0010\u0086\u0001\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0083\u0001R\u0017\u0010\u0087\u0001\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0083\u0001R\u0017\u0010\u0088\u0001\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0089\u0001R\u001a\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0098\u0001"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function1;", "Lru/yoomoney/sdk/kassa/payments/model/K;", "", "onBankCardReady", "setOnBankCardReadyListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "onBankCardNotReady", "setOnBankCardNotReadyListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Intent;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnBankCardScanListener", "", BankCardViewKt.EXTRA_CARD_NUMBER, "", BankCardViewKt.EXTRA_EXPIRY_YEAR, BankCardViewKt.EXTRA_EXPIRY_MONTH, "setBankCardInfo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onPresetBankCardReady", "setOnPresetBankCardReadyListener", "", "isAvailable", "setChangeCardAvailable", "(Z)V", "setCardData", "(Ljava/lang/String;)V", "cardName", "(Ljava/lang/String;Ljava/lang/String;)V", "hideAdditionalInfo", "()V", "showBankLogo", "bankLogo", "(I)V", "presetBankCardInfo", "Lru/yoomoney/sdk/kassa/payments/metrics/bankCard/a;", "bankCardAnalyticsLogger", "setBankCardAnalyticsLogger", "(Lru/yoomoney/sdk/kassa/payments/metrics/bankCard/a;)V", "setUpCardNumber", "shouldIgnoreUnknown", "setBankCardIcon", "(IZ)V", "setUpExpiry", "setUpCvc", "isCardNumberCorrect", "()Z", "isExpiryCorrect", "isAllFieldsCorrect", "colorRes", "getColor", "(I)I", "checkBankCardReady", "Landroid/widget/TextView;", "makeActive", "(Landroid/widget/TextView;)V", "makeInActive", "Landroid/widget/EditText;", "editText", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "errorRes", "errorPredicate", "setOnFocusChangeListenerForTitleAndEditWithErrorPredicate", "(Landroid/widget/EditText;Landroid/widget/TextView;ILkotlin/jvm/functions/Function0;)V", "textView", "onError", "(Landroid/widget/TextView;I)V", "clearErrors", "Landroid/view/View;", "fadeIn", "(Landroid/view/View;)V", "fadeOut", "Lru/yoomoney/sdk/kassa/payments/metrics/bankCard/b;", "event", "report", "(Lru/yoomoney/sdk/kassa/payments/metrics/bankCard/b;)V", "Lcom/google/android/material/card/MaterialCardView;", "cardView", "Lcom/google/android/material/card/MaterialCardView;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "J", "bankCardConstraint", "Landroidx/constraintlayout/widget/ConstraintLayout;", "cardNumberEditText", "Landroid/widget/EditText;", "cardNumberEditDone", "expiryEditText", "cvcEditText", "cardNumberFullText", "Landroid/widget/TextView;", "cardNumberTitle", "expiryTitle", "cvcTitle", "Landroidx/constraintlayout/widget/Group;", "detailsGroup", "Landroidx/constraintlayout/widget/Group;", "errorTextView", "Landroid/widget/ImageView;", "bankCardLogo", "Landroid/widget/ImageView;", "cardScanView", "continueWithCardView", "clearCardNumberView", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "minExpiry", "Ljava/util/Calendar;", "Ljava/text/SimpleDateFormat;", "expiryFormat", "Ljava/text/SimpleDateFormat;", "onBankCardReadyListener", "Lkotlin/jvm/functions/Function1;", "onBankCardNotReadyListener", "Lkotlin/jvm/functions/Function0;", "onBankCardScanListener", "onPresetBankCardReadyListener", "Lru/yoomoney/sdk/kassa/payments/metrics/bankCard/a;", "Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$CorrectnessState;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "expiryCorrectnessState", "Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$CorrectnessState;", "setExpiryCorrectnessState", "(Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$CorrectnessState;)V", "cardCorrectnessState", "setCardCorrectnessState", "cvcCorrectnessState", "cardImageDrawable", "I", "inActiveColor", "activeColor", "errorColor", "primaryColor", "isScanBankCardAvailable", "Z", "isChangeCardAvailable", "Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$Mode;", "mode", "Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$Mode;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AutoProceedWatcher", "CorrectnessState", "Mode", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class BankCardView extends ConstraintLayout {
    public static final int $stable = 8;
    private final int activeColor;
    private a bankCardAnalyticsLogger;
    private final ConstraintLayout bankCardConstraint;
    private final ImageView bankCardLogo;
    private CorrectnessState cardCorrectnessState;
    private int cardImageDrawable;
    private final EditText cardNumberEditDone;
    private final EditText cardNumberEditText;
    private final TextView cardNumberFullText;
    private final TextView cardNumberTitle;
    private final ImageView cardScanView;
    private final MaterialCardView cardView;
    private final ImageView clearCardNumberView;
    private final ImageView continueWithCardView;
    private CorrectnessState cvcCorrectnessState;
    private final EditText cvcEditText;
    private final TextView cvcTitle;
    private final Group detailsGroup;
    private final long duration;
    private final int errorColor;
    private final TextView errorTextView;
    private CorrectnessState expiryCorrectnessState;
    private final EditText expiryEditText;
    private final SimpleDateFormat expiryFormat;
    private final TextView expiryTitle;
    private final int inActiveColor;
    private boolean isChangeCardAvailable;
    private final boolean isScanBankCardAvailable;
    private final Calendar minExpiry;
    private Mode mode;
    private Function0<Unit> onBankCardNotReadyListener;
    private Function1<? super K, Unit> onBankCardReadyListener;
    private Function1<? super Intent, Unit> onBankCardScanListener;
    private Function1<? super String, Unit> onPresetBankCardReadyListener;
    private final int primaryColor;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n\u0012\b\b\u0001\u0010\r\u001a\u00020\n\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$AutoProceedWatcher;", "", "Landroid/text/Editable;", "s", "", "afterTextChanged", "(Landroid/text/Editable;)V", "Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "", "errorRes", "I", "minLength", "Lkotlin/Function0;", "onDone", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "", "isCorrect", "lastValue", "Ljava/lang/String;", "<init>", "(Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView;Landroid/widget/TextView;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
    public final class AutoProceedWatcher implements TextWatcher {
        private final Function1<String, Unit> afterTextChanged;
        private final int errorRes;
        private final Function0<Boolean> isCorrect;
        private String lastValue;
        private final int minLength;
        private final Function0<Unit> onDone;
        private final TextView textView;
        final /* synthetic */ BankCardView this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AutoProceedWatcher(BankCardView bankCardView, TextView textView, int i, int i2, Function0<Unit> onDone, Function1<? super String, Unit> afterTextChanged, Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(onDone, "onDone");
            Intrinsics.checkNotNullParameter(afterTextChanged, "afterTextChanged");
            this.this$0 = bankCardView;
            this.textView = textView;
            this.errorRes = i;
            this.minLength = i2;
            this.onDone = onDone;
            this.afterTextChanged = afterTextChanged;
            this.isCorrect = function0;
            this.lastValue = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(s, "s");
            if (Intrinsics.areEqual(this.lastValue, s.toString())) {
                return;
            }
            this.this$0.clearErrors(this.textView);
            this.afterTextChanged.invoke(s.toString());
            this.lastValue = s.toString();
            if (s.length() >= this.minLength) {
                Function0<Boolean> function0 = this.isCorrect;
                if (function0 == null || function0.invoke().booleanValue()) {
                    this.onDone.invoke();
                } else {
                    this.this$0.onError(this.textView, this.errorRes);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        public /* synthetic */ AutoProceedWatcher(BankCardView bankCardView, TextView textView, int i, int i2, Function0 function0, Function1 function1, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(bankCardView, textView, i, i2, function0, (i3 & 16) != 0 ? new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView.AutoProceedWatcher.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : function1, (i3 & 32) != 0 ? null : function02);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$CorrectnessState;", "", "(Ljava/lang/String;I)V", "NA", "CORRECT", "INCORRECT", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CorrectnessState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CorrectnessState[] $VALUES;
        public static final CorrectnessState NA = new CorrectnessState("NA", 0);
        public static final CorrectnessState CORRECT = new CorrectnessState("CORRECT", 1);
        public static final CorrectnessState INCORRECT = new CorrectnessState("INCORRECT", 2);

        private static final /* synthetic */ CorrectnessState[] $values() {
            return new CorrectnessState[]{NA, CORRECT, INCORRECT};
        }

        static {
            CorrectnessState[] correctnessStateArr$values = $values();
            $VALUES = correctnessStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(correctnessStateArr$values);
        }

        private CorrectnessState(String str, int i) {
        }

        public static EnumEntries<CorrectnessState> getEntries() {
            return $ENTRIES;
        }

        public static CorrectnessState valueOf(String str) {
            return (CorrectnessState) Enum.valueOf(CorrectnessState.class, str);
        }

        public static CorrectnessState[] values() {
            return (CorrectnessState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/view/BankCardView$Mode;", "", "(Ljava/lang/String;I)V", "EDIT", "PRESET", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode EDIT = new Mode("EDIT", 0);
        public static final Mode PRESET = new Mode("PRESET", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{EDIT, PRESET};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(modeArr$values);
        }

        private Mode(String str, int i) {
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CorrectnessState.values().length];
            try {
                iArr[CorrectnessState.CORRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CorrectnessState.INCORRECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(BankCardView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.report(e.a);
        this$0.cardNumberEditText.getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkBankCardReady() throws IOException {
        if (!isAllFieldsCorrect() || this.mode != Mode.EDIT) {
            if (this.cvcEditText.length() < 3 || this.mode != Mode.PRESET) {
                this.onBankCardNotReadyListener.invoke();
                return;
            } else {
                this.cardView.requestFocus();
                this.onPresetBankCardReadyListener.invoke(this.cvcEditText.getText().toString());
                return;
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.expiryFormat.parse(this.expiryEditText.getText().toString()));
        String string = this.cardNumberEditText.getText().toString();
        StringBuilder sb = new StringBuilder();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%tm", Arrays.copyOf(new Object[]{calendar}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        K k = new K(string2, str, String.valueOf(calendar.get(1)), this.cvcEditText.getText().toString());
        l.a(this);
        this.cardView.requestFocus();
        this.onBankCardReadyListener.invoke(k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearErrors(TextView textView) {
        TextView textView2 = this.errorTextView;
        Intrinsics.checkNotNullParameter(textView2, "<this>");
        textView2.setVisibility(4);
        makeActive(textView);
        this.cardView.setStrokeColor(getColor(R$color.ym_bank_card_stroke_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fadeIn(View view) {
        view.setAlpha(0.0f);
        ViewExtensions.show(view);
        view.animate().alpha(1.0f).setDuration(this.duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fadeOut(View view) {
        view.animate().alpha(0.0f).setDuration(this.duration);
        Intrinsics.checkNotNullParameter(view, "<this>");
        m.a(view, false);
    }

    private final int getColor(int colorRes) {
        return ContextCompat.getColor(getContext(), colorRes);
    }

    private final boolean isAllFieldsCorrect() {
        return isCardNumberCorrect() && isExpiryCorrect() && this.cvcEditText.length() >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isCardNumberCorrect() throws java.io.IOException {
        /*
            r8 = this;
            r0 = 1
            android.widget.EditText r1 = r8.cardNumberEditText
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r1.length()
            r4 = 0
            r5 = r4
        L16:
            if (r5 >= r3) goto L27
            char r6 = r1.charAt(r5)
            boolean r7 = java.lang.Character.isDigit(r6)
            if (r7 == 0) goto L25
            r2.append(r6)
        L25:
            int r5 = r5 + r0
            goto L16
        L27:
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.ranges.IntRange r2 = ru.yoomoney.sdk.kassa.payments.paymentOptionInfo.b.a
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.length()
            r2.<init>(r3)
            r3 = r4
        L41:
            int r5 = r1.length()
            if (r3 >= r5) goto L58
            char r5 = r1.charAt(r3)
            int r5 = java.lang.Character.getNumericValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2.add(r5)
            int r3 = r3 + r0
            goto L41
        L58:
            kotlin.ranges.IntRange r1 = ru.yoomoney.sdk.kassa.payments.paymentOptionInfo.b.b
            int r3 = r1.getFirst()
            int r1 = r1.getLast()
            int r5 = r2.size()
            if (r3 > r5) goto La7
            if (r5 > r1) goto La7
            kotlin.ranges.IntRange r1 = ru.yoomoney.sdk.kassa.payments.paymentOptionInfo.b.a
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L73
            goto L8e
        L73:
            java.util.Iterator r3 = r2.iterator()
        L77:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L8e
            java.lang.Object r5 = r3.next()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            boolean r5 = r1.contains(r5)
            if (r5 != 0) goto L77
            goto La7
        L8e:
            java.util.List r1 = kotlin.collections.CollectionsKt.asReversed(r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            kotlin.sequences.Sequence r1 = kotlin.collections.CollectionsKt.asSequence(r1)
            ru.yoomoney.sdk.kassa.payments.paymentOptionInfo.a r2 = ru.yoomoney.sdk.kassa.payments.paymentOptionInfo.a.a
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt.mapIndexed(r1, r2)
            int r1 = kotlin.sequences.SequencesKt.sumOfInt(r1)
            int r1 = r1 % 10
            if (r1 != 0) goto La7
            goto La8
        La7:
            r0 = r4
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView.isCardNumberCorrect():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isExpiryCorrect() {
        if (this.expiryEditText.length() == 5) {
            try {
                if (this.expiryFormat.parse(this.expiryEditText.getText().toString()).compareTo(this.expiryFormat.parse(BankCardViewKt.MIN_EXPIRY_DATE)) >= 0) {
                    return true;
                }
            } catch (ParseException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$4$lambda$3$lambda$2(BankCardView this$0, Intent intent, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        this$0.report(j.a);
        this$0.onBankCardScanListener.invoke(intent);
    }

    private final void makeActive(TextView textView) {
        textView.setTextColor(this.activeColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void makeInActive(TextView textView) {
        textView.setTextColor(this.inActiveColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onError(TextView textView, int errorRes) {
        textView.setTextColor(this.errorColor);
        this.cardView.setStrokeColor(this.errorColor);
        this.errorTextView.setText(errorRes);
        ViewExtensions.show(this.errorTextView);
    }

    private final void report(b event) {
        a aVar = this.bankCardAnalyticsLogger;
        if (aVar != null) {
            Intrinsics.checkNotNullParameter(event, "event");
            F f = ((C2245o0) aVar).a.e;
            if (f == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reporter");
                f = null;
            }
            f.a("actionBankCardForm", event.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBankCardIcon(int bankLogo, boolean shouldIgnoreUnknown) {
        if (bankLogo == ru.yoomoney.sdk.kassa.payments.utils.b.a && !shouldIgnoreUnknown) {
            this.bankCardLogo.animate().translationX(-100.0f).alpha(0.0f).setDuration(this.duration);
            this.cardNumberEditText.animate().translationX(-1.0f).setDuration(this.duration);
            this.cardNumberFullText.animate().translationX(-1.0f).setDuration(this.duration);
            this.cardImageDrawable = -1;
            return;
        }
        if (this.cardImageDrawable != bankLogo) {
            this.cardImageDrawable = bankLogo;
            ImageView imageView = this.bankCardLogo;
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), bankLogo));
            imageView.setAlpha(0.0f);
            ViewPropertyAnimator viewPropertyAnimatorAlpha = imageView.animate().alpha(1.0f);
            int i = R$dimen.ym_spaceXL;
            ViewPropertyAnimator viewPropertyAnimatorTranslationX = viewPropertyAnimatorAlpha.translationX(ViewExtensions.getDimensionPixelOffset(imageView, i));
            Long lValueOf = Long.valueOf(this.duration);
            if (this.mode != Mode.EDIT) {
                lValueOf = null;
            }
            viewPropertyAnimatorTranslationX.setDuration(lValueOf != null ? lValueOf.longValue() : 0L);
            this.cardNumberEditText.animate().translationX(ViewExtensions.getDimensionPixelOffset(this, i)).setDuration(this.duration);
            this.cardNumberFullText.animate().translationX(ViewExtensions.getDimensionPixelOffset(this, i)).setDuration(this.duration);
        }
    }

    public static /* synthetic */ void setBankCardIcon$default(BankCardView bankCardView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        bankCardView.setBankCardIcon(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCardCorrectnessState(CorrectnessState correctnessState) {
        int i = WhenMappings.$EnumSwitchMapping$0[correctnessState.ordinal()];
        b bVar = i != 1 ? i != 2 ? null : g.a : h.a;
        if (bVar != null) {
            report(bVar);
        }
        this.cardCorrectnessState = correctnessState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setExpiryCorrectnessState(CorrectnessState correctnessState) {
        BankCardView bankCardView = correctnessState == CorrectnessState.INCORRECT ? this : null;
        if (bankCardView != null) {
            bankCardView.report(d.a);
        }
        this.expiryCorrectnessState = correctnessState;
    }

    private final void setOnFocusChangeListenerForTitleAndEditWithErrorPredicate(final EditText editText, final TextView title, final int errorRes, final Function0<Boolean> errorPredicate) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$$ExternalSyntheticLambda7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                BankCardView.setOnFocusChangeListenerForTitleAndEditWithErrorPredicate$lambda$24(errorPredicate, this, title, errorRes, editText, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnFocusChangeListenerForTitleAndEditWithErrorPredicate$lambda$24(Function0 errorPredicate, BankCardView this$0, TextView title, int i, EditText editText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(errorPredicate, "$errorPredicate");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(editText, "$editText");
        if (((Boolean) errorPredicate.invoke()).booleanValue()) {
            this$0.onError(title, i);
            Intrinsics.checkNotNullParameter(editText, "<this>");
            editText.setSelection(editText.getText().length());
        } else {
            if (!z) {
                this$0.makeInActive(title);
                return;
            }
            Intrinsics.checkNotNullParameter(editText, "<this>");
            editText.setSelection(editText.getText().length());
            this$0.makeActive(title);
        }
    }

    private final void setUpCardNumber() {
        final EditText editText = this.cardNumberEditText;
        final Function0<Boolean> function0 = new Function0<Boolean>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCardNumber$1$cardNumberInputDone$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.this$0.fadeOut(editText);
                EditText editText2 = this.this$0.cardNumberEditDone;
                BankCardView bankCardView = this.this$0;
                bankCardView.fadeIn(editText2);
                editText2.setText("•••• " + StringsKt.takeLast(StringsKt.replace$default(bankCardView.cardNumberEditText.getText().toString(), " ", "", false, 4, (Object) null), 4));
                ViewExtensions.show(this.this$0.detailsGroup);
                List listListOf = CollectionsKt.listOf((Object[]) new TextView[]{this.this$0.expiryTitle, this.this$0.expiryEditText, this.this$0.cvcTitle, this.this$0.cvcEditText});
                BankCardView bankCardView2 = this.this$0;
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    bankCardView2.fadeIn((TextView) it.next());
                }
                BankCardView bankCardView3 = this.this$0;
                bankCardView3.makeInActive(bankCardView3.cardNumberTitle);
                BankCardView bankCardView4 = this.this$0;
                bankCardView4.fadeOut(bankCardView4.cardScanView);
                BankCardView bankCardView5 = this.this$0;
                bankCardView5.fadeOut(bankCardView5.continueWithCardView);
                BankCardView bankCardView6 = this.this$0;
                bankCardView6.fadeOut(bankCardView6.clearCardNumberView);
                this.this$0.setBankCardIcon(ru.yoomoney.sdk.kassa.payments.utils.b.a(editText.getText().toString()), true);
                return Boolean.valueOf((this.this$0.expiryCorrectnessState == BankCardView.CorrectnessState.CORRECT ? this.this$0.cvcEditText : this.this$0.expiryEditText).requestFocus());
            }
        };
        TextView textView = this.cardNumberTitle;
        int i = R$string.ym_check_card_number_error;
        editText.addTextChangedListener(new AutoProceedWatcher(this, textView, i, 19, new Function0<Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCardNumber$1$1
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
                function0.invoke();
            }
        }, new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCardNumber$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) throws IOException {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) throws IOException {
                ImageView imageView;
                Intrinsics.checkNotNullParameter(it, "it");
                String string = it.toString();
                StringBuilder sb = new StringBuilder();
                int length = string.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt = string.charAt(i2);
                    if (Character.isDigit(cCharAt)) {
                        sb.append(cCharAt);
                    }
                }
                String string2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                if (it.length() == 0) {
                    BankCardView bankCardView = this.this$0;
                    bankCardView.fadeOut(bankCardView.clearCardNumberView);
                    BankCardView bankCardView2 = this.this$0;
                    bankCardView2.fadeOut(bankCardView2.continueWithCardView);
                    return;
                }
                int length2 = string2.length();
                if (13 <= length2 && length2 < 16) {
                    ImageView imageView2 = this.this$0.continueWithCardView;
                    Intrinsics.checkNotNullParameter(imageView2, "<this>");
                    imageView = imageView2.getVisibility() != 0 ? imageView2 : null;
                    if (imageView != null) {
                        this.this$0.fadeIn(imageView);
                    }
                    BankCardView bankCardView3 = this.this$0;
                    bankCardView3.fadeOut(bankCardView3.clearCardNumberView);
                    return;
                }
                BankCardView bankCardView4 = this.this$0;
                bankCardView4.fadeOut(bankCardView4.continueWithCardView);
                BankCardView bankCardView5 = this.this$0;
                bankCardView5.fadeOut(bankCardView5.cardScanView);
                ImageView imageView3 = this.this$0.clearCardNumberView;
                Intrinsics.checkNotNullParameter(imageView3, "<this>");
                imageView = imageView3.getVisibility() != 0 ? imageView3 : null;
                if (imageView != null) {
                    this.this$0.fadeIn(imageView);
                }
            }
        }, new Function0<Boolean>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCardNumber$1$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws IOException {
                boolean zIsCardNumberCorrect = this.this$0.isCardNumberCorrect();
                Boolean boolValueOf = Boolean.valueOf(zIsCardNumberCorrect);
                this.this$0.setCardCorrectnessState(zIsCardNumberCorrect ? BankCardView.CorrectnessState.CORRECT : BankCardView.CorrectnessState.INCORRECT);
                return boolValueOf;
            }
        }));
        Intrinsics.checkNotNullParameter(editText, "<this>");
        new MaskFormatWatcher(MaskImpl.createTerminated(new UnderscoreDigitSlotsParser().parseSlots("____ ____ ____ ____ ___"))).installOn(editText);
        InputFilter[] filters = editText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) ArraysKt.plus((ru.yoomoney.sdk.kassa.payments.utils.g[]) filters, new ru.yoomoney.sdk.kassa.payments.utils.g()));
        this.cardNumberEditDone.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                BankCardView.setUpCardNumber$lambda$11$lambda$8(this.f$0, editText, view, z);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCardNumber$1$5
            private String lastValue = "";

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) throws IOException {
                Intrinsics.checkNotNullParameter(s, "s");
                if ((!Intrinsics.areEqual(s.toString(), this.lastValue) ? this : null) != null) {
                    BankCardView bankCardView = this.this$0;
                    this.lastValue = s.toString();
                    ImageView imageView = bankCardView.cardScanView;
                    if (s.length() != 0 || !bankCardView.isScanBankCardAvailable) {
                        imageView = null;
                    }
                    if (imageView != null) {
                        bankCardView.fadeIn(imageView);
                    }
                    BankCardView.setBankCardIcon$default(bankCardView, ru.yoomoney.sdk.kassa.payments.utils.b.a(s.toString()), false, 2, null);
                    bankCardView.checkBankCardReady();
                }
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                return BankCardView.setUpCardNumber$lambda$11$lambda$9(this.f$0, function0, textView2, i2, keyEvent);
            }
        });
        setOnFocusChangeListenerForTitleAndEditWithErrorPredicate(editText, this.cardNumberTitle, i, new Function0<Boolean>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCardNumber$1$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.cardCorrectnessState == BankCardView.CorrectnessState.INCORRECT);
            }
        });
        this.continueWithCardView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankCardView.setUpCardNumber$lambda$11$lambda$10(this.f$0, function0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpCardNumber$lambda$11$lambda$10(BankCardView this$0, Function0 cardNumberInputDone, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardNumberInputDone, "$cardNumberInputDone");
        this$0.report(f.a);
        cardNumberInputDone.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpCardNumber$lambda$11$lambda$8(BankCardView this$0, EditText this_with, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        if (z) {
            Group group = this$0.detailsGroup;
            Intrinsics.checkNotNullParameter(group, "<this>");
            m.a(group, false);
            this$0.fadeOut(this$0.cardNumberEditDone);
            this$0.fadeIn(this$0.cardNumberEditText);
            this$0.cardNumberEditText.requestFocus();
            this$0.fadeIn(this$0.continueWithCardView);
            this$0.clearErrors(this$0.cardNumberTitle);
            setBankCardIcon$default(this$0, ru.yoomoney.sdk.kassa.payments.utils.b.a(this_with.getText().toString()), false, 2, null);
            this$0.report(i.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setUpCardNumber$lambda$11$lambda$9(BankCardView this$0, Function0 cardNumberInputDone, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardNumberInputDone, "$cardNumberInputDone");
        if ((i != 6 && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) || !this$0.isCardNumberCorrect()) {
            return true;
        }
        cardNumberInputDone.invoke();
        return true;
    }

    private final void setUpCvc() {
        final EditText editText = this.cvcEditText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$$ExternalSyntheticLambda6
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return BankCardView.setUpCvc$lambda$16$lambda$15(editText, this, textView, i, keyEvent);
            }
        });
        TextView textView = this.cvcTitle;
        int i = R$string.ym_check_cvc;
        editText.addTextChangedListener(new AutoProceedWatcher(this, textView, i, 3, new Function0<Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCvc$1$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        }, null, null, 48, null));
        editText.addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCvc$1$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) throws IOException {
                Intrinsics.checkNotNullParameter(s, "s");
                BankCardView bankCardView = this.this$0;
                bankCardView.clearErrors(bankCardView.cvcTitle);
                BankCardView bankCardView2 = this.this$0;
                int length = s.length();
                bankCardView2.cvcCorrectnessState = (1 > length || length >= 3) ? BankCardView.CorrectnessState.CORRECT : BankCardView.CorrectnessState.INCORRECT;
                if (this.this$0.expiryCorrectnessState == BankCardView.CorrectnessState.INCORRECT) {
                    BankCardView bankCardView3 = this.this$0;
                    bankCardView3.onError(bankCardView3.expiryTitle, R$string.ym_check_expiry_error);
                }
                this.this$0.checkBankCardReady();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(s, "s");
            }
        });
        setOnFocusChangeListenerForTitleAndEditWithErrorPredicate(this.cvcEditText, this.cvcTitle, i, new Function0<Boolean>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpCvc$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.cvcCorrectnessState == BankCardView.CorrectnessState.INCORRECT || (editText.length() != 0 && editText.length() < 3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setUpCvc$lambda$16$lambda$15(EditText this_with, BankCardView this$0, TextView textView, int i, KeyEvent keyEvent) throws IOException {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 6 && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return true;
        }
        if (this_with.length() >= 3) {
            this$0.checkBankCardReady();
            return true;
        }
        this$0.cvcCorrectnessState = CorrectnessState.INCORRECT;
        this$0.report(c.a);
        this$0.onError(this$0.cvcTitle, R$string.ym_check_cvc);
        return true;
    }

    private final void setUpExpiry() {
        int i = this.minExpiry.get(1);
        int i2 = this.minExpiry.get(2);
        this.minExpiry.clear();
        this.minExpiry.set(i, i2, 1);
        this.minExpiry.add(5, -1);
        EditText editText = this.expiryEditText;
        TextView textView = this.expiryTitle;
        int i3 = R$string.ym_check_expiry_error;
        editText.addTextChangedListener(new AutoProceedWatcher(this, textView, i3, 5, new Function0<Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpExpiry$1$1
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
                this.this$0.cvcEditText.requestFocus();
            }
        }, new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpExpiry$1$2
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
                this.this$0.setExpiryCorrectnessState(BankCardView.CorrectnessState.NA);
            }
        }, new Function0<Boolean>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpExpiry$1$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean zIsExpiryCorrect = this.this$0.isExpiryCorrect();
                Boolean boolValueOf = Boolean.valueOf(zIsExpiryCorrect);
                this.this$0.setExpiryCorrectnessState(zIsExpiryCorrect ? BankCardView.CorrectnessState.CORRECT : BankCardView.CorrectnessState.INCORRECT);
                return boolValueOf;
            }
        }));
        editText.addTextChangedListener(new n());
        editText.addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpExpiry$1$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) throws IOException {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.this$0.expiryCorrectnessState == BankCardView.CorrectnessState.NA) {
                    BankCardView bankCardView = this.this$0;
                    bankCardView.clearErrors(bankCardView.expiryTitle);
                }
                BankCardView.CorrectnessState correctnessState = this.this$0.cvcCorrectnessState;
                BankCardView.CorrectnessState correctnessState2 = BankCardView.CorrectnessState.INCORRECT;
                if (correctnessState == correctnessState2 && this.this$0.expiryCorrectnessState != correctnessState2) {
                    BankCardView bankCardView2 = this.this$0;
                    bankCardView2.onError(bankCardView2.cvcTitle, R$string.ym_check_cvc);
                }
                this.this$0.checkBankCardReady();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s, "s");
            }
        });
        setOnFocusChangeListenerForTitleAndEditWithErrorPredicate(editText, this.expiryTitle, i3, new Function0<Boolean>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$setUpExpiry$1$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.expiryCorrectnessState == BankCardView.CorrectnessState.INCORRECT);
            }
        });
    }

    public final void hideAdditionalInfo() {
        EditText editText = this.cardNumberEditText;
        Intrinsics.checkNotNullParameter(editText, "<this>");
        m.a(editText, false);
        ImageView imageView = this.cardScanView;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        m.a(imageView, false);
        ImageView imageView2 = this.continueWithCardView;
        Intrinsics.checkNotNullParameter(imageView2, "<this>");
        m.a(imageView2, false);
        ImageView imageView3 = this.clearCardNumberView;
        Intrinsics.checkNotNullParameter(imageView3, "<this>");
        m.a(imageView3, false);
    }

    public final void presetBankCardInfo(String cardNumber) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        this.mode = Mode.PRESET;
        this.cardNumberEditText.setText(cardNumber);
        EditText editText = this.cardNumberEditText;
        Intrinsics.checkNotNullParameter(editText, "<this>");
        m.a(editText, false);
        ImageView imageView = this.cardScanView;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        m.a(imageView, false);
        ImageView imageView2 = this.clearCardNumberView;
        Intrinsics.checkNotNullParameter(imageView2, "<this>");
        m.a(imageView2, false);
        makeInActive(this.cardNumberTitle);
        ViewExtensions.show(this.bankCardLogo);
        EditText editText2 = this.cardNumberEditDone;
        editText2.setText(new Regex("....").replace(cardNumber, "$0 "));
        makeActive(editText2);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.bankCardConstraint);
        constraintSet.constrainWidth(R$id.cardNumberDone, 0);
        constraintSet.applyTo(this.bankCardConstraint);
        fadeIn(editText2);
        ViewExtensions.show(this.cvcEditText);
        ViewExtensions.show(this.cvcTitle);
        TextView textView = this.expiryTitle;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        m.a(textView, false);
        EditText editText3 = this.expiryEditText;
        Intrinsics.checkNotNullParameter(editText3, "<this>");
        m.a(editText3, false);
        this.cardNumberEditDone.setEnabled(false);
    }

    public final void setBankCardAnalyticsLogger(a bankCardAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(bankCardAnalyticsLogger, "bankCardAnalyticsLogger");
        this.bankCardAnalyticsLogger = bankCardAnalyticsLogger;
    }

    public final void setBankCardInfo(String cardNumber, Integer expiryYear, Integer expiryMonth) {
        if (cardNumber != null) {
            this.cardNumberEditText.setText(cardNumber);
        }
        if (expiryMonth != null && expiryYear != null) {
            EditText editText = this.expiryEditText;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02d%02d", Arrays.copyOf(new Object[]{expiryMonth, expiryYear}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            editText.setText(str);
        }
        (!isCardNumberCorrect() ? this.cardNumberEditText : this.cvcEditText).requestFocus();
    }

    public final void setCardData(String cardNumber) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        TextView textView = this.cardNumberFullText;
        ViewExtensions.show(textView);
        l.a(textView, true);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setText(new Regex("....").replace(StringsKt.replace$default(cardNumber, "*", "•", false, 4, (Object) null), "$0 "));
        makeInActive(this.cardNumberTitle);
    }

    public final void setChangeCardAvailable(boolean isAvailable) {
        this.isChangeCardAvailable = isAvailable;
    }

    public final void setOnBankCardNotReadyListener(Function0<Unit> onBankCardNotReady) {
        Intrinsics.checkNotNullParameter(onBankCardNotReady, "onBankCardNotReady");
        this.onBankCardNotReadyListener = onBankCardNotReady;
    }

    public final void setOnBankCardReadyListener(Function1<? super K, Unit> onBankCardReady) {
        Intrinsics.checkNotNullParameter(onBankCardReady, "onBankCardReady");
        this.onBankCardReadyListener = onBankCardReady;
    }

    public final void setOnBankCardScanListener(Function1<? super Intent, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onBankCardScanListener = listener;
    }

    public final void setOnPresetBankCardReadyListener(Function1<? super String, Unit> onPresetBankCardReady) {
        Intrinsics.checkNotNullParameter(onPresetBankCardReady, "onPresetBankCardReady");
        this.onPresetBankCardReadyListener = onPresetBankCardReady;
        checkBankCardReady();
    }

    public final void showBankLogo(int bankLogo) {
        ViewExtensions.show(this.bankCardLogo);
        setBankCardIcon(bankLogo, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setCardData(String cardNumber, String cardName) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        TextView textView = this.cardNumberFullText;
        ViewExtensions.show(textView);
        l.a(textView, true);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setText(new Regex("....").replace(StringsKt.replace$default(cardNumber, "*", "•", false, 4, (Object) null), "$0 "));
        this.cardNumberTitle.setText(cardName);
        this.cardNumberTitle.setTextColor(getColor(ru.yoomoney.sdk.gui.gui.R$color.color_type_primary));
    }

    public final void showBankLogo(String cardNumber) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        ViewExtensions.show(this.bankCardLogo);
        setBankCardIcon(ru.yoomoney.sdk.kassa.payments.utils.b.a(cardNumber), true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardView(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Resources resources;
        int i2;
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.minExpiry = Calendar.getInstance();
        this.expiryFormat = new SimpleDateFormat("MM/yy", Locale.US);
        this.onBankCardReadyListener = new Function1<K, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$onBankCardReadyListener$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(K k) {
                invoke2(k);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(K it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        this.onBankCardNotReadyListener = new Function0<Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$onBankCardNotReadyListener$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.onBankCardScanListener = new Function1<Intent, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$onBankCardScanListener$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        this.onPresetBankCardReadyListener = new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$onPresetBankCardReadyListener$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        CorrectnessState correctnessState = CorrectnessState.NA;
        this.expiryCorrectnessState = correctnessState;
        this.cardCorrectnessState = correctnessState;
        this.cvcCorrectnessState = correctnessState;
        this.cardImageDrawable = -1;
        int primaryColor = InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor();
        this.primaryColor = primaryColor;
        boolean z = true;
        this.isChangeCardAvailable = true;
        this.mode = Mode.EDIT;
        ru.yoomoney.sdk.kassa.payments.di.a.a(this);
        View.inflate(context, R$layout.ym_bank_card_view, this);
        this.duration = getResources().getInteger(R.integer.config_shortAnimTime);
        this.inActiveColor = getColor(ru.yoomoney.sdk.gui.gui.R$color.color_type_ghost);
        this.activeColor = getColor(ru.yoomoney.sdk.gui.gui.R$color.color_type_secondary);
        this.errorColor = getColor(ru.yoomoney.sdk.gui.gui.R$color.color_type_alert);
        View viewFindViewById = findViewById(R$id.bankCardConstraint);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        this.bankCardConstraint = constraintLayout;
        if (Build.VERSION.SDK_INT >= 26) {
            constraintLayout.setDefaultFocusHighlightEnabled(false);
        }
        View viewFindViewById2 = findViewById(R$id.cardView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.cardView = (MaterialCardView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.cardNumber);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.cardNumberEditText = (EditText) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.cardNumberDone);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.cardNumberEditDone = (EditText) viewFindViewById4;
        View viewFindViewById5 = findViewById(R$id.expiry);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.expiryEditText = (EditText) viewFindViewById5;
        View viewFindViewById6 = findViewById(R$id.cvc);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.cvcEditText = (EditText) viewFindViewById6;
        View viewFindViewById7 = findViewById(R$id.cardNumberFull);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.cardNumberFullText = (TextView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R$id.cardNumberTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.cardNumberTitle = (TextView) viewFindViewById8;
        View viewFindViewById9 = findViewById(R$id.expiryTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.expiryTitle = (TextView) viewFindViewById9;
        View viewFindViewById10 = findViewById(R$id.cvcTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.cvcTitle = (TextView) viewFindViewById10;
        View viewFindViewById11 = findViewById(R$id.error);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.errorTextView = (TextView) viewFindViewById11;
        View viewFindViewById12 = findViewById(R$id.detailsGroup);
        Group group = (Group) viewFindViewById12;
        Intrinsics.checkNotNull(group);
        m.a(group);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "apply(...)");
        this.detailsGroup = group;
        View viewFindViewById13 = findViewById(R$id.bankCard);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.bankCardLogo = (ImageView) viewFindViewById13;
        View viewFindViewById14 = findViewById(R$id.cardScan);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById14;
        this.cardScanView = imageView;
        final Intent intent = new Intent("ru.yoomoney.sdk.kassa.payments.action.SCAN_BANK_CARD");
        ActivityInfo activityInfoA = ru.yoomoney.sdk.kassa.payments.extensions.g.a(context, intent);
        if (activityInfoA != null) {
            intent.setComponent(new ComponentName(activityInfoA.packageName, activityInfoA.name));
            imageView.setColorFilter(primaryColor);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BankCardView.lambda$4$lambda$3$lambda$2(this.f$0, intent, view);
                }
            });
            ViewExtensions.show(imageView);
        } else {
            z = false;
        }
        this.isScanBankCardAvailable = z;
        View viewFindViewById15 = findViewById(R$id.continueWithCard);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById15;
        this.continueWithCardView = imageView2;
        View viewFindViewById16 = findViewById(R$id.clear);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById16;
        this.clearCardNumberView = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankCardView._init_$lambda$5(this.f$0, view);
            }
        });
        Iterator it = CollectionsKt.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3}).iterator();
        while (it.hasNext()) {
            ((ImageView) it.next()).setColorFilter(this.primaryColor);
        }
        Iterator it2 = CollectionsKt.listOf((Object[]) new EditText[]{this.cardNumberEditText, this.cardNumberEditDone, this.expiryEditText, this.cvcEditText}).iterator();
        while (it2.hasNext()) {
            ru.yoomoney.sdk.kassa.payments.utils.e.a((EditText) it2.next(), this.primaryColor);
        }
        EditText editText = this.cardNumberEditText;
        if (this.isScanBankCardAvailable) {
            resources = getResources();
            i2 = R$string.ym_card_number_hint;
        } else {
            resources = getResources();
            i2 = R$string.ym_card_number_only_enter_hint;
        }
        editText.setHint(resources.getString(i2));
        if (this.isChangeCardAvailable) {
            setUpCardNumber();
            setUpExpiry();
            setUpCvc();
        }
    }

    public /* synthetic */ BankCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
