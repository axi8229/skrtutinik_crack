package npi.spay;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.BiometricSuggestionModel;
import spay.sdk.domain.model.response.ErrorEntity;
import timber.log.Timber;

/* renamed from: npi.spay.m0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1753m0 extends Lambda implements Function1 {
    public final /* synthetic */ mo a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1753m0(mo moVar) {
        super(1);
        this.a = moVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String str;
        mo moVar;
        Z7 c2017wf;
        mo moVar2;
        Z7 nb;
        int i;
        int i2;
        H6 h6;
        Bundle bundle;
        C1784n6 c1784n6 = (C1784n6) obj;
        Timber.INSTANCE.i("onViewState: " + c1784n6.a, new Object[0]);
        Z2 z2 = c1784n6.a;
        if (z2 instanceof L2) {
            moVar2 = this.a;
            int i3 = mo.$r8$clinit;
            moVar2.getClass();
            nb = new C1761m8();
            str = "NoInternetFragment";
        } else {
            str = "NoCardFragment";
            if (z2 instanceof P2) {
                moVar = this.a;
                P2 p2 = (P2) z2;
                int i4 = mo.$r8$clinit;
                moVar.getClass();
                if (p2.b) {
                    c2017wf = new D();
                } else {
                    InterfaceC1850pm interfaceC1850pm = p2.a;
                    if (interfaceC1850pm instanceof C1800nm) {
                        c2017wf = new C1888rb();
                        str = "BnplOrderFragment";
                    } else if (interfaceC1850pm instanceof C1775mm) {
                        c2017wf = new I5();
                        str = "BnplAgreementFragment";
                    } else {
                        c2017wf = new C1940td();
                        str = "OrderFragment";
                    }
                }
            } else {
                if (!(z2 instanceof O2)) {
                    if (z2 instanceof R2) {
                        moVar = this.a;
                        Z6 z6 = ((R2) z2).a;
                        int i5 = mo.$r8$clinit;
                        moVar.getClass();
                        if (z6 instanceof W6) {
                            ErrorEntity errorEntity = ((W6) z6).a;
                            if (errorEntity instanceof ErrorEntity.NoBnplResponse) {
                                i = R$string.spay_no_bnpl_response_exception_title;
                                i2 = R$string.spay_default_client_exception_message_error_subtitle_text;
                                h6 = new H6();
                                bundle = new Bundle();
                            } else if (errorEntity instanceof ErrorEntity.PayBnplPartsFail) {
                                i = R$string.spay_cant_pay_bnpl_parts_exception_title;
                                i2 = R$string.spay_top_card_and_try_again;
                                h6 = new H6();
                                bundle = new Bundle();
                            } else {
                                i = R$string.spay_default_client_exception_message_error_title_text;
                                i2 = R$string.spay_default_client_exception_message_error_subtitle_text;
                                h6 = new H6();
                                bundle = new Bundle();
                            }
                            bundle.putInt(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, i);
                            bundle.putInt("subTitle", i2);
                            h6.setArguments(bundle);
                            moVar2 = moVar;
                            str = "FailurePaymentFragment";
                            nb = h6;
                        } else if (z6 instanceof X6) {
                            c2017wf = new Pg();
                            str = "ProcessingPaymentFragment";
                        } else if (z6 instanceof Y6) {
                            c2017wf = new Pl();
                            str = "SuccessPaymentFragment";
                        }
                    } else if (z2 instanceof W2) {
                        moVar2 = this.a;
                        int i6 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new C1930t3();
                        str = "LoadingFragment";
                    } else if (z2 instanceof X2) {
                        moVar2 = this.a;
                        int i7 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new C1486b7();
                        str = "RetryWithoutBnplFragment";
                    } else if (z2 instanceof Q2) {
                        moVar2 = this.a;
                        int i8 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new Ab();
                        str = "CardSelectionFragment";
                    } else if (z2 instanceof H2) {
                        moVar2 = this.a;
                        int i9 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new Mb();
                        str = "FakeBankFragment";
                    } else if (z2 instanceof U2) {
                        mo moVar3 = this.a;
                        BiometricSuggestionModel biometricSuggestionModel = ((U2) z2).a;
                        int i10 = mo.$r8$clinit;
                        moVar3.a(biometricSuggestionModel);
                    } else if (z2 instanceof V2) {
                        mo moVar4 = this.a;
                        List list = ((V2) z2).a;
                        int i11 = mo.$r8$clinit;
                        moVar4.getClass();
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(moVar4), null, null, new P0(moVar4, list, null), 3, null);
                    } else if (z2 instanceof M2) {
                        moVar2 = this.a;
                        int i12 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new C1579f0();
                        str = "OneTimePasswordFragment";
                    } else if (z2 instanceof N2) {
                        moVar2 = this.a;
                        int i13 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new C1623gj();
                        str = "OTPErrorFragment";
                    } else if (z2 instanceof Y2) {
                        moVar2 = this.a;
                        int i14 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new C1464aa();
                        str = "UserProfileFragment";
                    } else if (z2 instanceof S2) {
                        moVar2 = this.a;
                        int i15 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new C1520cg();
                        str = "SdkVersionDeprecatedFragment";
                    } else if (z2 instanceof I2) {
                        moVar2 = this.a;
                        int i16 = mo.$r8$clinit;
                        moVar2.getClass();
                        nb = new Nb();
                        str = "FraudMonReviewFragment";
                    } else if (z2 instanceof J2) {
                        moVar = this.a;
                        S6 s6 = ((J2) z2).a;
                        int i17 = mo.$r8$clinit;
                        moVar.getClass();
                        if (Intrinsics.areEqual(s6, O6.b) || (s6 instanceof P6)) {
                            c2017wf = new C1591fc();
                            str = "NoMatchingCardsFragment";
                        } else if (Intrinsics.areEqual(s6, Q6.b)) {
                            c2017wf = new D();
                        } else if (s6 instanceof R6) {
                            c2017wf = new C2017wf();
                            str = "HelpersFragment";
                        }
                    }
                    return Unit.INSTANCE;
                }
                moVar2 = this.a;
                int i18 = mo.$r8$clinit;
                moVar2.getClass();
                nb = new C1771mi();
                str = "BnplPartsOrderFragment";
            }
            mo moVar5 = moVar;
            nb = c2017wf;
            moVar2 = moVar5;
        }
        moVar2.a(nb, str);
        return Unit.INSTANCE;
    }
}
