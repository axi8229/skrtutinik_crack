package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.entities.demo.DemoModeLocale;
import com.sputnik.common.entities.localization.entities.authorization.AuthorizationNeedHelpBodyLocale;
import com.sputnik.common.entities.localization.entities.ble.BleLocale;
import com.sputnik.common.entities.localization.entities.blocking.AboutServiceCompanyLocale;
import com.sputnik.common.entities.localization.entities.blocking.ArguePopupLocale;
import com.sputnik.common.entities.localization.entities.blocking.DebtPopupLocale;
import com.sputnik.common.entities.localization.entities.blocking.PromisePopupLocale;
import com.sputnik.common.entities.localization.entities.blocking.PromiseSuccessPopupLocale;
import com.sputnik.common.entities.localization.entities.blocking.ServicePaymentDetailLocale;
import com.sputnik.common.entities.localization.entities.blocking.ServicePaymentLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithSubtitle;
import com.sputnik.common.entities.localization.entities.family_invites.FamilyInvitesLocale;
import com.sputnik.common.entities.localization.entities.faq.FaqLocale;
import com.sputnik.common.entities.localization.entities.help.CompanyContactsLocale;
import com.sputnik.common.entities.localization.entities.invites.InvitesBodyLocale;
import com.sputnik.common.entities.localization.entities.keys.PhysicalKeysLocale;
import com.sputnik.common.entities.localization.entities.login.AboutCodeLocale;
import com.sputnik.common.entities.localization.entities.login.ConfirmAddressLocale;
import com.sputnik.common.entities.localization.entities.login.DomofonLocale;
import com.sputnik.common.entities.localization.entities.login.EnterCodeLocale;
import com.sputnik.common.entities.localization.entities.login.PhoneLoginLocale;
import com.sputnik.common.entities.localization.entities.login.RegisterLocale;
import com.sputnik.common.entities.localization.entities.login.RegisterPopupLocale;
import com.sputnik.common.entities.localization.entities.notifications.NotificationsBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationLimitExceededBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.ChooseLanguageLocale;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.OnBoardingLanguageLoaderLocale;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.StartLanguageLocale;
import com.sputnik.common.entities.localization.entities.our_home.OurHomePreUpdatePopup;
import com.sputnik.common.entities.localization.entities.our_home.OurHomeUpdate;
import com.sputnik.common.entities.localization.entities.our_home.OurHomeUpdatePlate;
import com.sputnik.common.entities.localization.entities.our_home.OurHomeUpdatePopup;
import com.sputnik.common.entities.localization.entities.payment.PaymentBottomSheet;
import com.sputnik.common.entities.localization.entities.payment_methods.DeletePaymentMethodLocale;
import com.sputnik.common.entities.localization.entities.permissions.PermissionsLocale;
import com.sputnik.common.entities.localization.entities.polls.PollSentPopup;
import com.sputnik.common.entities.localization.entities.registration.AccountsLocale;
import com.sputnik.common.entities.localization.entities.registration.StartRegistrationLocale;
import com.sputnik.common.entities.localization.entities.service_payment.NoContractPopupLocale;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentAboutPopupLocale;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentCancelPopupLocale;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentPayLocale;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentSuccessLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SettingsSubscriptionLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionChangedPopupLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionPayedPopupLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionPopupLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionStopBody;
import com.sputnik.common.entities.localization.entities.subscriptions.UnSubscriptionPopUpLocale;
import com.sputnik.common.entities.localization.entities.vpn.VpnBodyLocale;
import com.sputnik.common.entities.send_install_sputnik.SendInstallSputnik;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000³\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0003\bÄ\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bâ\n\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010]\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010e\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010i\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010m\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010o\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010s\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010u\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010w\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010y\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010}\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f\u0012\f\b\u0002\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001\u0012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\f\b\u0002\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u0012\f\b\u0002\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u0012\f\b\u0002\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u0001\u0012\f\b\u0002\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u0001\u0012\f\b\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001\u0012\f\b\u0002\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u0001\u0012\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u0001\u0012\f\b\u0002\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001\u0012\f\b\u0002\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001\u0012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u0001\u0012\f\b\u0002\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u0001\u0012\f\b\u0002\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001\u0012\f\b\u0002\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001\u0012\f\b\u0002\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u0001\u0012\f\b\u0002\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u0001\u0012\f\b\u0002\u0010¤\u0001\u001a\u0005\u0018\u00010£\u0001\u0012\f\b\u0002\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001\u0012\f\b\u0002\u0010¨\u0001\u001a\u0005\u0018\u00010§\u0001\u0012\f\b\u0002\u0010©\u0001\u001a\u0005\u0018\u00010§\u0001\u0012\f\b\u0002\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001\u0012\f\b\u0002\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u0001\u0012\f\b\u0002\u0010¯\u0001\u001a\u0005\u0018\u00010®\u0001\u0012\f\b\u0002\u0010±\u0001\u001a\u0005\u0018\u00010°\u0001\u0012\f\b\u0002\u0010³\u0001\u001a\u0005\u0018\u00010²\u0001\u0012\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u0001\u0012\n\u0010·\u0001\u001a\u0005\u0018\u00010¶\u0001\u0012\n\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u0001\u0012\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001\u0012\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001\u0012\n\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u0001\u0012\n\u0010Á\u0001\u001a\u0005\u0018\u00010À\u0001\u0012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u0001\u0012\n\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u0001\u0012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u0001\u0012\n\u0010É\u0001\u001a\u0005\u0018\u00010È\u0001\u0012\n\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u0001\u0012\n\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u0001\u0012\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u0001\u0012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u0001\u0012\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u0001\u0012\n\u0010Õ\u0001\u001a\u0005\u0018\u00010Ô\u0001\u0012\n\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u0001\u0012\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u0001¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u0013\u0010Ü\u0001\u001a\u00020\u0002HÖ\u0001¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u0014\u0010ß\u0001\u001a\u00030Þ\u0001HÖ\u0001¢\u0006\u0006\bß\u0001\u0010à\u0001J \u0010ä\u0001\u001a\u00030ã\u00012\n\u0010â\u0001\u001a\u0005\u0018\u00010á\u0001HÖ\u0003¢\u0006\u0006\bä\u0001\u0010å\u0001J\u0014\u0010æ\u0001\u001a\u00030Þ\u0001HÖ\u0001¢\u0006\u0006\bæ\u0001\u0010à\u0001J(\u0010ë\u0001\u001a\u00030ê\u00012\b\u0010è\u0001\u001a\u00030ç\u00012\b\u0010é\u0001\u001a\u00030Þ\u0001HÖ\u0001¢\u0006\u0006\bë\u0001\u0010ì\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010í\u0001\u001a\u0006\bî\u0001\u0010Ý\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u000f\n\u0005\b\u0004\u0010í\u0001\u001a\u0006\bï\u0001\u0010Ý\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u000f\n\u0005\b\u0005\u0010í\u0001\u001a\u0006\bð\u0001\u0010Ý\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\u000f\n\u0005\b\u0007\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001R\u001f\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\t\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001R\u001f\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u000b\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001R\u001f\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\r\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001R\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u000f\u0010ý\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001R\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u0011\u0010\u0080\u0002\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\u000f\n\u0005\b\u0013\u0010\u0083\u0002\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u0015\u0010\u0086\u0002\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u0017\u0010\u0089\u0002\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u0019\u0010\u008c\u0002\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002R\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u001b\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u001d\u0010\u0092\u0002\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002R\u001d\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u001f\u0010\u0095\u0002\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006¢\u0006\u000f\n\u0005\b!\u0010\u0098\u0002\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002R\u001f\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b#\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002R\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006¢\u0006\u000f\n\u0005\b%\u0010\u009e\u0002\u001a\u0006\b\u009f\u0002\u0010 \u0002R\u001f\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b'\u0010¡\u0002\u001a\u0006\b¢\u0002\u0010£\u0002R\u001f\u0010(\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b(\u0010¡\u0002\u001a\u0006\b¤\u0002\u0010£\u0002R\u001f\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b*\u0010¥\u0002\u001a\u0006\b¦\u0002\u0010§\u0002R\u001f\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b,\u0010¨\u0002\u001a\u0006\b©\u0002\u0010ª\u0002R\u001f\u0010.\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b.\u0010«\u0002\u001a\u0006\b¬\u0002\u0010\u00ad\u0002R\u001c\u00100\u001a\u0004\u0018\u00010/8\u0006¢\u0006\u000f\n\u0005\b0\u0010®\u0002\u001a\u0006\b¯\u0002\u0010°\u0002R\u001f\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b2\u0010±\u0002\u001a\u0006\b²\u0002\u0010³\u0002R\u001f\u00104\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b4\u0010´\u0002\u001a\u0006\bµ\u0002\u0010¶\u0002R\u001f\u00106\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b6\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002R\u001f\u00108\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b8\u0010º\u0002\u001a\u0006\b»\u0002\u0010¼\u0002R\u001f\u0010:\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b:\u0010½\u0002\u001a\u0006\b¾\u0002\u0010¿\u0002R\u001f\u0010<\u001a\u0004\u0018\u00010;8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b<\u0010À\u0002\u001a\u0006\bÁ\u0002\u0010Â\u0002R\u001f\u0010>\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b>\u0010Ã\u0002\u001a\u0006\bÄ\u0002\u0010Å\u0002R\u001f\u0010@\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b@\u0010Æ\u0002\u001a\u0006\bÇ\u0002\u0010È\u0002R\u001f\u0010B\u001a\u0004\u0018\u00010A8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bB\u0010É\u0002\u001a\u0006\bÊ\u0002\u0010Ë\u0002R\u001f\u0010D\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bD\u0010Ì\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002R\u001f\u0010F\u001a\u0004\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bF\u0010Ï\u0002\u001a\u0006\bÐ\u0002\u0010Ñ\u0002R\u001c\u0010H\u001a\u0004\u0018\u00010G8\u0006¢\u0006\u000f\n\u0005\bH\u0010Ò\u0002\u001a\u0006\bÓ\u0002\u0010Ô\u0002R\u001f\u0010J\u001a\u0004\u0018\u00010I8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bJ\u0010Õ\u0002\u001a\u0006\bÖ\u0002\u0010×\u0002R\u001f\u0010L\u001a\u0004\u0018\u00010K8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bL\u0010Ø\u0002\u001a\u0006\bÙ\u0002\u0010Ú\u0002R\u001f\u0010N\u001a\u0004\u0018\u00010M8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bN\u0010Û\u0002\u001a\u0006\bÜ\u0002\u0010Ý\u0002R\u001f\u0010P\u001a\u0004\u0018\u00010O8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bP\u0010Þ\u0002\u001a\u0006\bß\u0002\u0010à\u0002R\u001f\u0010R\u001a\u0004\u0018\u00010Q8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bR\u0010á\u0002\u001a\u0006\bâ\u0002\u0010ã\u0002R\u001f\u0010T\u001a\u0004\u0018\u00010S8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bT\u0010ä\u0002\u001a\u0006\bå\u0002\u0010æ\u0002R\u001f\u0010V\u001a\u0004\u0018\u00010U8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bV\u0010ç\u0002\u001a\u0006\bè\u0002\u0010é\u0002R\u001f\u0010X\u001a\u0004\u0018\u00010W8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bX\u0010ê\u0002\u001a\u0006\bë\u0002\u0010ì\u0002R\u001f\u0010Z\u001a\u0004\u0018\u00010Y8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bZ\u0010í\u0002\u001a\u0006\bî\u0002\u0010ï\u0002R\u001f\u0010\\\u001a\u0004\u0018\u00010[8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\\\u0010ð\u0002\u001a\u0006\bñ\u0002\u0010ò\u0002R\u001f\u0010^\u001a\u0004\u0018\u00010]8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b^\u0010ó\u0002\u001a\u0006\bô\u0002\u0010õ\u0002R\u001c\u0010`\u001a\u0004\u0018\u00010_8\u0006¢\u0006\u000f\n\u0005\b`\u0010ö\u0002\u001a\u0006\b÷\u0002\u0010ø\u0002R\u001c\u0010b\u001a\u0004\u0018\u00010a8\u0006¢\u0006\u000f\n\u0005\bb\u0010ù\u0002\u001a\u0006\bú\u0002\u0010û\u0002R\u001f\u0010d\u001a\u0004\u0018\u00010c8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bd\u0010ü\u0002\u001a\u0006\bý\u0002\u0010þ\u0002R\u001f\u0010f\u001a\u0004\u0018\u00010e8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bf\u0010ÿ\u0002\u001a\u0006\b\u0080\u0003\u0010\u0081\u0003R\u001c\u0010h\u001a\u0004\u0018\u00010g8\u0006¢\u0006\u000f\n\u0005\bh\u0010\u0082\u0003\u001a\u0006\b\u0083\u0003\u0010\u0084\u0003R\u001f\u0010j\u001a\u0004\u0018\u00010i8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bj\u0010\u0085\u0003\u001a\u0006\b\u0086\u0003\u0010\u0087\u0003R\u001c\u0010l\u001a\u0004\u0018\u00010k8\u0006¢\u0006\u000f\n\u0005\bl\u0010\u0088\u0003\u001a\u0006\b\u0089\u0003\u0010\u008a\u0003R\u001f\u0010n\u001a\u0004\u0018\u00010m8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bn\u0010\u008b\u0003\u001a\u0006\b\u008c\u0003\u0010\u008d\u0003R\u001f\u0010p\u001a\u0004\u0018\u00010o8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bp\u0010\u008e\u0003\u001a\u0006\b\u008f\u0003\u0010\u0090\u0003R\u001f\u0010r\u001a\u0004\u0018\u00010q8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\br\u0010\u0091\u0003\u001a\u0006\b\u0092\u0003\u0010\u0093\u0003R\u001c\u0010t\u001a\u0004\u0018\u00010s8\u0006¢\u0006\u000f\n\u0005\bt\u0010\u0094\u0003\u001a\u0006\b\u0095\u0003\u0010\u0096\u0003R\u001f\u0010v\u001a\u0004\u0018\u00010u8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bv\u0010\u0097\u0003\u001a\u0006\b\u0098\u0003\u0010\u0099\u0003R\u001c\u0010x\u001a\u0004\u0018\u00010w8\u0006¢\u0006\u000f\n\u0005\bx\u0010\u009a\u0003\u001a\u0006\b\u009b\u0003\u0010\u009c\u0003R\u001c\u0010z\u001a\u0004\u0018\u00010y8\u0006¢\u0006\u000f\n\u0005\bz\u0010\u009d\u0003\u001a\u0006\b\u009e\u0003\u0010\u009f\u0003R\u001c\u0010|\u001a\u0004\u0018\u00010{8\u0006¢\u0006\u000f\n\u0005\b|\u0010 \u0003\u001a\u0006\b¡\u0003\u0010¢\u0003R\u001f\u0010~\u001a\u0004\u0018\u00010}8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b~\u0010£\u0003\u001a\u0006\b¤\u0003\u0010¥\u0003R\u001e\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0006¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010¦\u0003\u001a\u0006\b§\u0003\u0010¨\u0003R\"\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010©\u0003\u001a\u0006\bª\u0003\u0010«\u0003R\"\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010¬\u0003\u001a\u0006\b\u00ad\u0003\u0010®\u0003R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010¯\u0003\u001a\u0006\b°\u0003\u0010±\u0003R\"\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010²\u0003\u001a\u0006\b³\u0003\u0010´\u0003R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010µ\u0003\u001a\u0006\b¶\u0003\u0010·\u0003R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010¸\u0003\u001a\u0006\b¹\u0003\u0010º\u0003R\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010»\u0003\u001a\u0006\b¼\u0003\u0010½\u0003R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010¾\u0003\u001a\u0006\b¿\u0003\u0010À\u0003R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010Á\u0003\u001a\u0006\bÂ\u0003\u0010Ã\u0003R\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010Ä\u0003\u001a\u0006\bÅ\u0003\u0010Æ\u0003R\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010Ç\u0003\u001a\u0006\bÈ\u0003\u0010É\u0003R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010Ê\u0003\u001a\u0006\bË\u0003\u0010Ì\u0003R\"\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010Í\u0003\u001a\u0006\bÎ\u0003\u0010Ï\u0003R\"\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010Ð\u0003\u001a\u0006\bÑ\u0003\u0010Ò\u0003R\"\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010Ó\u0003\u001a\u0006\bÔ\u0003\u0010Õ\u0003R\"\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b \u0001\u0010Ö\u0003\u001a\u0006\b×\u0003\u0010Ø\u0003R\"\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¢\u0001\u0010Ù\u0003\u001a\u0006\bÚ\u0003\u0010Û\u0003R\"\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¤\u0001\u0010Ü\u0003\u001a\u0006\bÝ\u0003\u0010Þ\u0003R\"\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¦\u0001\u0010ß\u0003\u001a\u0006\bà\u0003\u0010á\u0003R\"\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¨\u0001\u0010â\u0003\u001a\u0006\bã\u0003\u0010ä\u0003R\"\u0010©\u0001\u001a\u0005\u0018\u00010§\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b©\u0001\u0010â\u0003\u001a\u0006\bå\u0003\u0010ä\u0003R\"\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b«\u0001\u0010æ\u0003\u001a\u0006\bç\u0003\u0010è\u0003R\"\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u00ad\u0001\u0010é\u0003\u001a\u0006\bê\u0003\u0010ë\u0003R\"\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¯\u0001\u0010ì\u0003\u001a\u0006\bí\u0003\u0010î\u0003R\u001f\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0006¢\u0006\u0010\n\u0006\b±\u0001\u0010ï\u0003\u001a\u0006\bð\u0003\u0010ñ\u0003R\"\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b³\u0001\u0010ò\u0003\u001a\u0006\bó\u0003\u0010ô\u0003R\"\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bµ\u0001\u0010õ\u0003\u001a\u0006\bö\u0003\u0010÷\u0003R\"\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b·\u0001\u0010ø\u0003\u001a\u0006\bù\u0003\u0010ú\u0003R\"\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¹\u0001\u0010û\u0003\u001a\u0006\bü\u0003\u0010ý\u0003R\"\u0010»\u0001\u001a\u0005\u0018\u00010º\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b»\u0001\u0010þ\u0003\u001a\u0006\bÿ\u0003\u0010\u0080\u0004R\"\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b½\u0001\u0010\u0081\u0004\u001a\u0006\b\u0082\u0004\u0010\u0083\u0004R\"\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¿\u0001\u0010\u0084\u0004\u001a\u0006\b\u0085\u0004\u0010\u0086\u0004R\"\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÁ\u0001\u0010\u0087\u0004\u001a\u0006\b\u0088\u0004\u0010\u0089\u0004R\"\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÃ\u0001\u0010\u008a\u0004\u001a\u0006\b\u008b\u0004\u0010\u008c\u0004R\"\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÅ\u0001\u0010\u008d\u0004\u001a\u0006\b\u008e\u0004\u0010\u008f\u0004R\u001f\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0006¢\u0006\u0010\n\u0006\bÇ\u0001\u0010\u0090\u0004\u001a\u0006\b\u0091\u0004\u0010\u0092\u0004R\u001f\u0010É\u0001\u001a\u0005\u0018\u00010È\u00018\u0006¢\u0006\u0010\n\u0006\bÉ\u0001\u0010\u0093\u0004\u001a\u0006\b\u0094\u0004\u0010\u0095\u0004R\"\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bË\u0001\u0010\u0096\u0004\u001a\u0006\b\u0097\u0004\u0010\u0098\u0004R\u001f\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0006¢\u0006\u0010\n\u0006\bÍ\u0001\u0010\u0099\u0004\u001a\u0006\b\u009a\u0004\u0010\u009b\u0004R\"\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÏ\u0001\u0010\u009c\u0004\u001a\u0006\b\u009d\u0004\u0010\u009e\u0004R\u001f\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0006¢\u0006\u0010\n\u0006\bÑ\u0001\u0010\u009f\u0004\u001a\u0006\b \u0004\u0010¡\u0004R\"\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÓ\u0001\u0010¢\u0004\u001a\u0006\b£\u0004\u0010¤\u0004R\"\u0010Õ\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÕ\u0001\u0010¥\u0004\u001a\u0006\b¦\u0004\u0010§\u0004R\"\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b×\u0001\u0010¨\u0004\u001a\u0006\b©\u0004\u0010ª\u0004R\u001f\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0006¢\u0006\u0010\n\u0006\bÙ\u0001\u0010«\u0004\u001a\u0006\b¬\u0004\u0010\u00ad\u0004¨\u0006®\u0004"}, d2 = {"Lcom/sputnik/common/entities/localization/LocalizationLocalModel;", "Landroid/os/Parcelable;", "", RemoteMessageConst.Notification.TAG, FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "platform", "Lcom/sputnik/common/entities/localization/SplashLocale;", "splash", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageLocale;", "chooseLanguage", "Lcom/sputnik/common/entities/localization/CountryPickerLocale;", "countryPicker", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderLocale;", "onBoardingLanguageLoader", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/StartLanguageLocale;", "startLanguageLocale", "Lcom/sputnik/common/entities/localization/entities/registration/StartRegistrationLocale;", "startRegistration", "Lcom/sputnik/common/entities/localization/entities/registration/AccountsLocale;", "accounts", "Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginLocale;", "phoneLogin", "Lcom/sputnik/common/entities/localization/entities/login/EnterCodeLocale;", "enterCode", "Lcom/sputnik/common/entities/localization/entities/login/AboutCodeLocale;", "aboutCode", "Lcom/sputnik/common/entities/localization/entities/login/RegisterPopupLocale;", "registerPopup", "Lcom/sputnik/common/entities/localization/entities/login/DomofonLocale;", "domofon", "Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressLocale;", "confirmAddress", "Lcom/sputnik/common/entities/localization/entities/login/RegisterLocale;", "register", "Lcom/sputnik/common/entities/localization/CamerasLocale;", "cameraList", "Lcom/sputnik/common/entities/localization/VisitsLocale;", "visits", "Lcom/sputnik/common/entities/localization/VisitsArchiveInfoPopup;", "visitsArchiveInfoPopup", "visitsNoArchiveDataPopup", "Lcom/sputnik/common/entities/localization/FeedBackLocale;", "feedbackMain", "Lcom/sputnik/common/entities/localization/FeedbackCommentLocale;", "feedbackComment", "Lcom/sputnik/common/entities/localization/FeedbackDoneLocale;", "feedbackDone", "Lcom/sputnik/common/entities/localization/SettingsLocale;", "settings", "Lcom/sputnik/common/entities/localization/ProfileSettingsLocale;", "profileSettings", "Lcom/sputnik/common/entities/localization/DomofonSettingsLocale;", "domofonSettings", "Lcom/sputnik/common/entities/localization/FamilyListLocale;", "familyList", "Lcom/sputnik/common/entities/localization/FamilyMemberLocale;", "familyMember", "Lcom/sputnik/common/entities/localization/AddAddressLocale;", "addAddress", "Lcom/sputnik/common/entities/localization/ManageCamerasLocale;", "manageCameras", "Lcom/sputnik/common/entities/localization/CameraGalleryLocale;", "cameraGallery", "Lcom/sputnik/common/entities/localization/CamerasSettingsLocale;", "cameraSettings", "Lcom/sputnik/common/entities/localization/LanguageListLocale;", "languageList", "Lcom/sputnik/common/entities/localization/ChangeLanguagePopUpLocale;", "changeLanguagePopup", "Lcom/sputnik/common/entities/localization/LanguageLoaderLocale;", "languageLoader", "Lcom/sputnik/common/entities/localization/MarketLocale;", "market", "Lcom/sputnik/common/entities/localization/PaymentWaitingLocale;", "paymentWaiting", "Lcom/sputnik/common/entities/localization/SubscriptionBuyLocale;", "subscriptionBuy", "Lcom/sputnik/common/entities/localization/FaceRecognitionStartLocale;", "faceRecognitionStart", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainLocale;", "faceRecognitionMain", "Lcom/sputnik/common/entities/localization/FaceRecognitionSettingsLocale;", "faceRecognitionSettings", "Lcom/sputnik/common/entities/localization/FaceRecognitionUploadLocale;", "faceRecognitionUpload", "Lcom/sputnik/common/entities/localization/FaceRecognitionErrorLocale;", "faceRecognitionError", "Lcom/sputnik/common/entities/localization/ArchiveMainLocale;", "archiveMain", "Lcom/sputnik/common/entities/localization/ArchivePopUpLocale;", "archivePopUp", "Lcom/sputnik/common/entities/localization/FlussonicCameraPicker;", "flussonicCameraPicker", "Lcom/sputnik/common/entities/localization/DigitalKeysMainLocale;", "digitalKeysMain", "Lcom/sputnik/common/entities/localization/HelpLocale;", "help", "Lcom/sputnik/common/entities/localization/AboutLocale;", "about", "Lcom/sputnik/common/entities/localization/AboutCompanyLocale;", "aboutCompany", "Lcom/sputnik/common/entities/localization/InternetErrorLocale;", "internetError", "Lcom/sputnik/common/entities/localization/BlockLocale;", "block", "Lcom/sputnik/common/entities/localization/BlockMain;", "blockMain", "Lcom/sputnik/common/entities/localization/CallLocale;", "call", "Lcom/sputnik/common/entities/localization/ArchiveDownloadLocale;", "archiveDownloader", "Lcom/sputnik/common/entities/localization/ImageViewerLocale;", "visitor", "Lcom/sputnik/common/entities/localization/ServicePopupLocale;", "servicePopup", "Lcom/sputnik/common/entities/localization/AlertLocale;", "alert", "Lcom/sputnik/common/entities/localization/AddNewCardLocale;", "addNewCard", "Lcom/sputnik/common/entities/localization/CardLocale;", "card", "Lcom/sputnik/common/entities/localization/CommonLocale;", "common", "Lcom/sputnik/common/entities/localization/IntercomLocale;", "intercom", "Lcom/sputnik/common/entities/localization/CallNotificationLocale;", "callNotification", "Lcom/sputnik/common/entities/localization/WidgetsLocale;", "widgets", "Lcom/sputnik/common/entities/localization/EmergencyCodeLocale;", "emergencyCodeLocale", "Lcom/sputnik/common/entities/localization/NotificationLocale;", RemoteMessageConst.NOTIFICATION, "Lcom/sputnik/common/entities/localization/BottomSheetStandardPromo;", "bottomSheetStandardPromo", "Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentLocale;", "servicePaymentLocale", "Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentDetailLocale;", "servicePaymentDetail", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentSuccessLocale;", "servicePaymentSuccess", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentAboutPopupLocale;", "servicePaymentAboutPopup", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentCancelPopupLocale;", "servicePaymentCancelPopup", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentPayLocale;", "servicePaymentPay", "Lcom/sputnik/common/entities/localization/entities/service_payment/NoContractPopupLocale;", "noContractPopup", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "viewPaymentInProgress", "Lcom/sputnik/common/entities/localization/entities/blocking/PromiseSuccessPopupLocale;", "promiseSuccessPopup", "Lcom/sputnik/common/entities/localization/entities/blocking/PromisePopupLocale;", "promisePopup", "Lcom/sputnik/common/entities/localization/entities/blocking/DebtPopupLocale;", "debtPopup", "Lcom/sputnik/common/entities/localization/entities/blocking/ArguePopupLocale;", "arguePopup", "Lcom/sputnik/common/entities/localization/entities/blocking/AboutServiceCompanyLocale;", "aboutCompanyPopup", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPayedPopupLocale;", "subscriptionTariffPopup", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionChangedPopupLocale;", "subscriptionChangedTariffPopup", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionLocale;", "subscriptionSettings", "Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpLocale;", "unsubscriptionPopup", "stopSubscriptionPopup", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPopupLocale;", "subscriptionPopUp", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;", "subscriptionCancel", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionStopBody;", "subscriptionStopBody", "Lcom/sputnik/common/entities/demo/DemoModeLocale;", "demo", "Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik;", "sendInstallSputnik", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomePreUpdatePopup;", "ourHomePreUpdatePopup", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePopup;", "ourHomeUpdatePopup", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdate;", "ourHomeUpdate", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePlate;", "ourHomeUpdatePlate", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationBody;", "authorizationCode", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationLimitExceededBody;", "authorizationLimitExceeded", "Lcom/sputnik/common/entities/localization/entities/polls/PollSentPopup;", "pollSentPopup", "Lcom/sputnik/common/entities/localization/entities/payment/PaymentBottomSheet;", "paymentBottomSheet", "Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpBodyLocale;", "authNeedHelp", "Lcom/sputnik/common/entities/localization/entities/notifications/NotificationsBody;", "notifications", "Lcom/sputnik/common/entities/localization/entities/faq/FaqLocale;", "faq", "Lcom/sputnik/common/entities/localization/entities/vpn/VpnBodyLocale;", "vpnView", "Lcom/sputnik/common/entities/localization/entities/invites/InvitesBodyLocale;", "invites", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale;", "physicalKeys", "Lcom/sputnik/common/entities/localization/entities/help/CompanyContactsLocale;", "contacts", "Lcom/sputnik/common/entities/localization/entities/payment_methods/DeletePaymentMethodLocale;", "deletePaymentMethod", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale;", "familyInvites", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale;", "ble", "Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale;", "permissions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/SplashLocale;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageLocale;Lcom/sputnik/common/entities/localization/CountryPickerLocale;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderLocale;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/StartLanguageLocale;Lcom/sputnik/common/entities/localization/entities/registration/StartRegistrationLocale;Lcom/sputnik/common/entities/localization/entities/registration/AccountsLocale;Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginLocale;Lcom/sputnik/common/entities/localization/entities/login/EnterCodeLocale;Lcom/sputnik/common/entities/localization/entities/login/AboutCodeLocale;Lcom/sputnik/common/entities/localization/entities/login/RegisterPopupLocale;Lcom/sputnik/common/entities/localization/entities/login/DomofonLocale;Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressLocale;Lcom/sputnik/common/entities/localization/entities/login/RegisterLocale;Lcom/sputnik/common/entities/localization/CamerasLocale;Lcom/sputnik/common/entities/localization/VisitsLocale;Lcom/sputnik/common/entities/localization/VisitsArchiveInfoPopup;Lcom/sputnik/common/entities/localization/VisitsArchiveInfoPopup;Lcom/sputnik/common/entities/localization/FeedBackLocale;Lcom/sputnik/common/entities/localization/FeedbackCommentLocale;Lcom/sputnik/common/entities/localization/FeedbackDoneLocale;Lcom/sputnik/common/entities/localization/SettingsLocale;Lcom/sputnik/common/entities/localization/ProfileSettingsLocale;Lcom/sputnik/common/entities/localization/DomofonSettingsLocale;Lcom/sputnik/common/entities/localization/FamilyListLocale;Lcom/sputnik/common/entities/localization/FamilyMemberLocale;Lcom/sputnik/common/entities/localization/AddAddressLocale;Lcom/sputnik/common/entities/localization/ManageCamerasLocale;Lcom/sputnik/common/entities/localization/CameraGalleryLocale;Lcom/sputnik/common/entities/localization/CamerasSettingsLocale;Lcom/sputnik/common/entities/localization/LanguageListLocale;Lcom/sputnik/common/entities/localization/ChangeLanguagePopUpLocale;Lcom/sputnik/common/entities/localization/LanguageLoaderLocale;Lcom/sputnik/common/entities/localization/MarketLocale;Lcom/sputnik/common/entities/localization/PaymentWaitingLocale;Lcom/sputnik/common/entities/localization/SubscriptionBuyLocale;Lcom/sputnik/common/entities/localization/FaceRecognitionStartLocale;Lcom/sputnik/common/entities/localization/FaceRecognitionMainLocale;Lcom/sputnik/common/entities/localization/FaceRecognitionSettingsLocale;Lcom/sputnik/common/entities/localization/FaceRecognitionUploadLocale;Lcom/sputnik/common/entities/localization/FaceRecognitionErrorLocale;Lcom/sputnik/common/entities/localization/ArchiveMainLocale;Lcom/sputnik/common/entities/localization/ArchivePopUpLocale;Lcom/sputnik/common/entities/localization/FlussonicCameraPicker;Lcom/sputnik/common/entities/localization/DigitalKeysMainLocale;Lcom/sputnik/common/entities/localization/HelpLocale;Lcom/sputnik/common/entities/localization/AboutLocale;Lcom/sputnik/common/entities/localization/AboutCompanyLocale;Lcom/sputnik/common/entities/localization/InternetErrorLocale;Lcom/sputnik/common/entities/localization/BlockLocale;Lcom/sputnik/common/entities/localization/BlockMain;Lcom/sputnik/common/entities/localization/CallLocale;Lcom/sputnik/common/entities/localization/ArchiveDownloadLocale;Lcom/sputnik/common/entities/localization/ImageViewerLocale;Lcom/sputnik/common/entities/localization/ServicePopupLocale;Lcom/sputnik/common/entities/localization/AlertLocale;Lcom/sputnik/common/entities/localization/AddNewCardLocale;Lcom/sputnik/common/entities/localization/CardLocale;Lcom/sputnik/common/entities/localization/CommonLocale;Lcom/sputnik/common/entities/localization/IntercomLocale;Lcom/sputnik/common/entities/localization/CallNotificationLocale;Lcom/sputnik/common/entities/localization/WidgetsLocale;Lcom/sputnik/common/entities/localization/EmergencyCodeLocale;Lcom/sputnik/common/entities/localization/NotificationLocale;Lcom/sputnik/common/entities/localization/BottomSheetStandardPromo;Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentLocale;Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentDetailLocale;Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentSuccessLocale;Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentAboutPopupLocale;Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentCancelPopupLocale;Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentPayLocale;Lcom/sputnik/common/entities/localization/entities/service_payment/NoContractPopupLocale;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/blocking/PromiseSuccessPopupLocale;Lcom/sputnik/common/entities/localization/entities/blocking/PromisePopupLocale;Lcom/sputnik/common/entities/localization/entities/blocking/DebtPopupLocale;Lcom/sputnik/common/entities/localization/entities/blocking/ArguePopupLocale;Lcom/sputnik/common/entities/localization/entities/blocking/AboutServiceCompanyLocale;Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPayedPopupLocale;Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionChangedPopupLocale;Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionLocale;Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpLocale;Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpLocale;Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPopupLocale;Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionStopBody;Lcom/sputnik/common/entities/demo/DemoModeLocale;Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik;Lcom/sputnik/common/entities/localization/entities/our_home/OurHomePreUpdatePopup;Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePopup;Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdate;Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePlate;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationBody;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationLimitExceededBody;Lcom/sputnik/common/entities/localization/entities/polls/PollSentPopup;Lcom/sputnik/common/entities/localization/entities/payment/PaymentBottomSheet;Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpBodyLocale;Lcom/sputnik/common/entities/localization/entities/notifications/NotificationsBody;Lcom/sputnik/common/entities/localization/entities/faq/FaqLocale;Lcom/sputnik/common/entities/localization/entities/vpn/VpnBodyLocale;Lcom/sputnik/common/entities/localization/entities/invites/InvitesBodyLocale;Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale;Lcom/sputnik/common/entities/localization/entities/help/CompanyContactsLocale;Lcom/sputnik/common/entities/localization/entities/payment_methods/DeletePaymentMethodLocale;Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTag", "getLanguage", "getPlatform", "Lcom/sputnik/common/entities/localization/SplashLocale;", "getSplash", "()Lcom/sputnik/common/entities/localization/SplashLocale;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageLocale;", "getChooseLanguage", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageLocale;", "Lcom/sputnik/common/entities/localization/CountryPickerLocale;", "getCountryPicker", "()Lcom/sputnik/common/entities/localization/CountryPickerLocale;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderLocale;", "getOnBoardingLanguageLoader", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/OnBoardingLanguageLoaderLocale;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/StartLanguageLocale;", "getStartLanguageLocale", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/StartLanguageLocale;", "Lcom/sputnik/common/entities/localization/entities/registration/StartRegistrationLocale;", "getStartRegistration", "()Lcom/sputnik/common/entities/localization/entities/registration/StartRegistrationLocale;", "Lcom/sputnik/common/entities/localization/entities/registration/AccountsLocale;", "getAccounts", "()Lcom/sputnik/common/entities/localization/entities/registration/AccountsLocale;", "Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginLocale;", "getPhoneLogin", "()Lcom/sputnik/common/entities/localization/entities/login/PhoneLoginLocale;", "Lcom/sputnik/common/entities/localization/entities/login/EnterCodeLocale;", "getEnterCode", "()Lcom/sputnik/common/entities/localization/entities/login/EnterCodeLocale;", "Lcom/sputnik/common/entities/localization/entities/login/AboutCodeLocale;", "getAboutCode", "()Lcom/sputnik/common/entities/localization/entities/login/AboutCodeLocale;", "Lcom/sputnik/common/entities/localization/entities/login/RegisterPopupLocale;", "getRegisterPopup", "()Lcom/sputnik/common/entities/localization/entities/login/RegisterPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/login/DomofonLocale;", "getDomofon", "()Lcom/sputnik/common/entities/localization/entities/login/DomofonLocale;", "Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressLocale;", "getConfirmAddress", "()Lcom/sputnik/common/entities/localization/entities/login/ConfirmAddressLocale;", "Lcom/sputnik/common/entities/localization/entities/login/RegisterLocale;", "getRegister", "()Lcom/sputnik/common/entities/localization/entities/login/RegisterLocale;", "Lcom/sputnik/common/entities/localization/CamerasLocale;", "getCameraList", "()Lcom/sputnik/common/entities/localization/CamerasLocale;", "Lcom/sputnik/common/entities/localization/VisitsLocale;", "getVisits", "()Lcom/sputnik/common/entities/localization/VisitsLocale;", "Lcom/sputnik/common/entities/localization/VisitsArchiveInfoPopup;", "getVisitsArchiveInfoPopup", "()Lcom/sputnik/common/entities/localization/VisitsArchiveInfoPopup;", "getVisitsNoArchiveDataPopup", "Lcom/sputnik/common/entities/localization/FeedBackLocale;", "getFeedbackMain", "()Lcom/sputnik/common/entities/localization/FeedBackLocale;", "Lcom/sputnik/common/entities/localization/FeedbackCommentLocale;", "getFeedbackComment", "()Lcom/sputnik/common/entities/localization/FeedbackCommentLocale;", "Lcom/sputnik/common/entities/localization/FeedbackDoneLocale;", "getFeedbackDone", "()Lcom/sputnik/common/entities/localization/FeedbackDoneLocale;", "Lcom/sputnik/common/entities/localization/SettingsLocale;", "getSettings", "()Lcom/sputnik/common/entities/localization/SettingsLocale;", "Lcom/sputnik/common/entities/localization/ProfileSettingsLocale;", "getProfileSettings", "()Lcom/sputnik/common/entities/localization/ProfileSettingsLocale;", "Lcom/sputnik/common/entities/localization/DomofonSettingsLocale;", "getDomofonSettings", "()Lcom/sputnik/common/entities/localization/DomofonSettingsLocale;", "Lcom/sputnik/common/entities/localization/FamilyListLocale;", "getFamilyList", "()Lcom/sputnik/common/entities/localization/FamilyListLocale;", "Lcom/sputnik/common/entities/localization/FamilyMemberLocale;", "getFamilyMember", "()Lcom/sputnik/common/entities/localization/FamilyMemberLocale;", "Lcom/sputnik/common/entities/localization/AddAddressLocale;", "getAddAddress", "()Lcom/sputnik/common/entities/localization/AddAddressLocale;", "Lcom/sputnik/common/entities/localization/ManageCamerasLocale;", "getManageCameras", "()Lcom/sputnik/common/entities/localization/ManageCamerasLocale;", "Lcom/sputnik/common/entities/localization/CameraGalleryLocale;", "getCameraGallery", "()Lcom/sputnik/common/entities/localization/CameraGalleryLocale;", "Lcom/sputnik/common/entities/localization/CamerasSettingsLocale;", "getCameraSettings", "()Lcom/sputnik/common/entities/localization/CamerasSettingsLocale;", "Lcom/sputnik/common/entities/localization/LanguageListLocale;", "getLanguageList", "()Lcom/sputnik/common/entities/localization/LanguageListLocale;", "Lcom/sputnik/common/entities/localization/ChangeLanguagePopUpLocale;", "getChangeLanguagePopup", "()Lcom/sputnik/common/entities/localization/ChangeLanguagePopUpLocale;", "Lcom/sputnik/common/entities/localization/LanguageLoaderLocale;", "getLanguageLoader", "()Lcom/sputnik/common/entities/localization/LanguageLoaderLocale;", "Lcom/sputnik/common/entities/localization/MarketLocale;", "getMarket", "()Lcom/sputnik/common/entities/localization/MarketLocale;", "Lcom/sputnik/common/entities/localization/PaymentWaitingLocale;", "getPaymentWaiting", "()Lcom/sputnik/common/entities/localization/PaymentWaitingLocale;", "Lcom/sputnik/common/entities/localization/SubscriptionBuyLocale;", "getSubscriptionBuy", "()Lcom/sputnik/common/entities/localization/SubscriptionBuyLocale;", "Lcom/sputnik/common/entities/localization/FaceRecognitionStartLocale;", "getFaceRecognitionStart", "()Lcom/sputnik/common/entities/localization/FaceRecognitionStartLocale;", "Lcom/sputnik/common/entities/localization/FaceRecognitionMainLocale;", "getFaceRecognitionMain", "()Lcom/sputnik/common/entities/localization/FaceRecognitionMainLocale;", "Lcom/sputnik/common/entities/localization/FaceRecognitionSettingsLocale;", "getFaceRecognitionSettings", "()Lcom/sputnik/common/entities/localization/FaceRecognitionSettingsLocale;", "Lcom/sputnik/common/entities/localization/FaceRecognitionUploadLocale;", "getFaceRecognitionUpload", "()Lcom/sputnik/common/entities/localization/FaceRecognitionUploadLocale;", "Lcom/sputnik/common/entities/localization/FaceRecognitionErrorLocale;", "getFaceRecognitionError", "()Lcom/sputnik/common/entities/localization/FaceRecognitionErrorLocale;", "Lcom/sputnik/common/entities/localization/ArchiveMainLocale;", "getArchiveMain", "()Lcom/sputnik/common/entities/localization/ArchiveMainLocale;", "Lcom/sputnik/common/entities/localization/ArchivePopUpLocale;", "getArchivePopUp", "()Lcom/sputnik/common/entities/localization/ArchivePopUpLocale;", "Lcom/sputnik/common/entities/localization/FlussonicCameraPicker;", "getFlussonicCameraPicker", "()Lcom/sputnik/common/entities/localization/FlussonicCameraPicker;", "Lcom/sputnik/common/entities/localization/DigitalKeysMainLocale;", "getDigitalKeysMain", "()Lcom/sputnik/common/entities/localization/DigitalKeysMainLocale;", "Lcom/sputnik/common/entities/localization/HelpLocale;", "getHelp", "()Lcom/sputnik/common/entities/localization/HelpLocale;", "Lcom/sputnik/common/entities/localization/AboutLocale;", "getAbout", "()Lcom/sputnik/common/entities/localization/AboutLocale;", "Lcom/sputnik/common/entities/localization/AboutCompanyLocale;", "getAboutCompany", "()Lcom/sputnik/common/entities/localization/AboutCompanyLocale;", "Lcom/sputnik/common/entities/localization/InternetErrorLocale;", "getInternetError", "()Lcom/sputnik/common/entities/localization/InternetErrorLocale;", "Lcom/sputnik/common/entities/localization/BlockLocale;", "getBlock", "()Lcom/sputnik/common/entities/localization/BlockLocale;", "Lcom/sputnik/common/entities/localization/BlockMain;", "getBlockMain", "()Lcom/sputnik/common/entities/localization/BlockMain;", "Lcom/sputnik/common/entities/localization/CallLocale;", "getCall", "()Lcom/sputnik/common/entities/localization/CallLocale;", "Lcom/sputnik/common/entities/localization/ArchiveDownloadLocale;", "getArchiveDownloader", "()Lcom/sputnik/common/entities/localization/ArchiveDownloadLocale;", "Lcom/sputnik/common/entities/localization/ImageViewerLocale;", "getVisitor", "()Lcom/sputnik/common/entities/localization/ImageViewerLocale;", "Lcom/sputnik/common/entities/localization/ServicePopupLocale;", "getServicePopup", "()Lcom/sputnik/common/entities/localization/ServicePopupLocale;", "Lcom/sputnik/common/entities/localization/AlertLocale;", "getAlert", "()Lcom/sputnik/common/entities/localization/AlertLocale;", "Lcom/sputnik/common/entities/localization/AddNewCardLocale;", "getAddNewCard", "()Lcom/sputnik/common/entities/localization/AddNewCardLocale;", "Lcom/sputnik/common/entities/localization/CardLocale;", "getCard", "()Lcom/sputnik/common/entities/localization/CardLocale;", "Lcom/sputnik/common/entities/localization/CommonLocale;", "getCommon", "()Lcom/sputnik/common/entities/localization/CommonLocale;", "Lcom/sputnik/common/entities/localization/IntercomLocale;", "getIntercom", "()Lcom/sputnik/common/entities/localization/IntercomLocale;", "Lcom/sputnik/common/entities/localization/CallNotificationLocale;", "getCallNotification", "()Lcom/sputnik/common/entities/localization/CallNotificationLocale;", "Lcom/sputnik/common/entities/localization/WidgetsLocale;", "getWidgets", "()Lcom/sputnik/common/entities/localization/WidgetsLocale;", "Lcom/sputnik/common/entities/localization/EmergencyCodeLocale;", "getEmergencyCodeLocale", "()Lcom/sputnik/common/entities/localization/EmergencyCodeLocale;", "Lcom/sputnik/common/entities/localization/NotificationLocale;", "getNotification", "()Lcom/sputnik/common/entities/localization/NotificationLocale;", "Lcom/sputnik/common/entities/localization/BottomSheetStandardPromo;", "getBottomSheetStandardPromo", "()Lcom/sputnik/common/entities/localization/BottomSheetStandardPromo;", "Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentLocale;", "getServicePaymentLocale", "()Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentLocale;", "Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentDetailLocale;", "getServicePaymentDetail", "()Lcom/sputnik/common/entities/localization/entities/blocking/ServicePaymentDetailLocale;", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentSuccessLocale;", "getServicePaymentSuccess", "()Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentSuccessLocale;", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentAboutPopupLocale;", "getServicePaymentAboutPopup", "()Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentAboutPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentCancelPopupLocale;", "getServicePaymentCancelPopup", "()Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentCancelPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentPayLocale;", "getServicePaymentPay", "()Lcom/sputnik/common/entities/localization/entities/service_payment/ServicePaymentPayLocale;", "Lcom/sputnik/common/entities/localization/entities/service_payment/NoContractPopupLocale;", "getNoContractPopup", "()Lcom/sputnik/common/entities/localization/entities/service_payment/NoContractPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getViewPaymentInProgress", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/entities/blocking/PromiseSuccessPopupLocale;", "getPromiseSuccessPopup", "()Lcom/sputnik/common/entities/localization/entities/blocking/PromiseSuccessPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/blocking/PromisePopupLocale;", "getPromisePopup", "()Lcom/sputnik/common/entities/localization/entities/blocking/PromisePopupLocale;", "Lcom/sputnik/common/entities/localization/entities/blocking/DebtPopupLocale;", "getDebtPopup", "()Lcom/sputnik/common/entities/localization/entities/blocking/DebtPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/blocking/ArguePopupLocale;", "getArguePopup", "()Lcom/sputnik/common/entities/localization/entities/blocking/ArguePopupLocale;", "Lcom/sputnik/common/entities/localization/entities/blocking/AboutServiceCompanyLocale;", "getAboutCompanyPopup", "()Lcom/sputnik/common/entities/localization/entities/blocking/AboutServiceCompanyLocale;", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPayedPopupLocale;", "getSubscriptionTariffPopup", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPayedPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionChangedPopupLocale;", "getSubscriptionChangedTariffPopup", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionChangedPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionLocale;", "getSubscriptionSettings", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/SettingsSubscriptionLocale;", "Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpLocale;", "getUnsubscriptionPopup", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/UnSubscriptionPopUpLocale;", "getStopSubscriptionPopup", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPopupLocale;", "getSubscriptionPopUp", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionPopupLocale;", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;", "getSubscriptionCancel", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithSubtitle;", "Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionStopBody;", "getSubscriptionStopBody", "()Lcom/sputnik/common/entities/localization/entities/subscriptions/SubscriptionStopBody;", "Lcom/sputnik/common/entities/demo/DemoModeLocale;", "getDemo", "()Lcom/sputnik/common/entities/demo/DemoModeLocale;", "Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik;", "getSendInstallSputnik", "()Lcom/sputnik/common/entities/send_install_sputnik/SendInstallSputnik;", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomePreUpdatePopup;", "getOurHomePreUpdatePopup", "()Lcom/sputnik/common/entities/localization/entities/our_home/OurHomePreUpdatePopup;", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePopup;", "getOurHomeUpdatePopup", "()Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePopup;", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdate;", "getOurHomeUpdate", "()Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdate;", "Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePlate;", "getOurHomeUpdatePlate", "()Lcom/sputnik/common/entities/localization/entities/our_home/OurHomeUpdatePlate;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationBody;", "getAuthorizationCode", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationBody;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationLimitExceededBody;", "getAuthorizationLimitExceeded", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationLimitExceededBody;", "Lcom/sputnik/common/entities/localization/entities/polls/PollSentPopup;", "getPollSentPopup", "()Lcom/sputnik/common/entities/localization/entities/polls/PollSentPopup;", "Lcom/sputnik/common/entities/localization/entities/payment/PaymentBottomSheet;", "getPaymentBottomSheet", "()Lcom/sputnik/common/entities/localization/entities/payment/PaymentBottomSheet;", "Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpBodyLocale;", "getAuthNeedHelp", "()Lcom/sputnik/common/entities/localization/entities/authorization/AuthorizationNeedHelpBodyLocale;", "Lcom/sputnik/common/entities/localization/entities/notifications/NotificationsBody;", "getNotifications", "()Lcom/sputnik/common/entities/localization/entities/notifications/NotificationsBody;", "Lcom/sputnik/common/entities/localization/entities/faq/FaqLocale;", "getFaq", "()Lcom/sputnik/common/entities/localization/entities/faq/FaqLocale;", "Lcom/sputnik/common/entities/localization/entities/vpn/VpnBodyLocale;", "getVpnView", "()Lcom/sputnik/common/entities/localization/entities/vpn/VpnBodyLocale;", "Lcom/sputnik/common/entities/localization/entities/invites/InvitesBodyLocale;", "getInvites", "()Lcom/sputnik/common/entities/localization/entities/invites/InvitesBodyLocale;", "Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale;", "getPhysicalKeys", "()Lcom/sputnik/common/entities/localization/entities/keys/PhysicalKeysLocale;", "Lcom/sputnik/common/entities/localization/entities/help/CompanyContactsLocale;", "getContacts", "()Lcom/sputnik/common/entities/localization/entities/help/CompanyContactsLocale;", "Lcom/sputnik/common/entities/localization/entities/payment_methods/DeletePaymentMethodLocale;", "getDeletePaymentMethod", "()Lcom/sputnik/common/entities/localization/entities/payment_methods/DeletePaymentMethodLocale;", "Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale;", "getFamilyInvites", "()Lcom/sputnik/common/entities/localization/entities/family_invites/FamilyInvitesLocale;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale;", "getBle", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale;", "Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale;", "getPermissions", "()Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LocalizationLocalModel implements Parcelable {
    public static final Parcelable.Creator<LocalizationLocalModel> CREATOR = new Creator();
    private final AboutLocale about;

    @SerializedName("about_code")
    private final AboutCodeLocale aboutCode;

    @SerializedName("about_company")
    private final AboutCompanyLocale aboutCompany;

    @SerializedName("about_company_popup")
    private final AboutServiceCompanyLocale aboutCompanyPopup;
    private final AccountsLocale accounts;

    @SerializedName("add_address")
    private final AddAddressLocale addAddress;

    @SerializedName("add_new_card")
    private final AddNewCardLocale addNewCard;
    private final AlertLocale alert;

    @SerializedName("archive_downloader_popup")
    private final ArchiveDownloadLocale archiveDownloader;

    @SerializedName("archive_main")
    private final ArchiveMainLocale archiveMain;

    @SerializedName("archive_popup")
    private final ArchivePopUpLocale archivePopUp;

    @SerializedName("argue_popup")
    private final ArguePopupLocale arguePopup;

    @SerializedName("auth_need_help")
    private final AuthorizationNeedHelpBodyLocale authNeedHelp;

    @SerializedName("authorization_code")
    private final AuthorizationBody authorizationCode;

    @SerializedName("authorization_limit_exceed")
    private final AuthorizationLimitExceededBody authorizationLimitExceeded;

    @SerializedName("ble")
    private final BleLocale ble;
    private final BlockLocale block;

    @SerializedName("block_main")
    private final BlockMain blockMain;

    @SerializedName("popup_standard_promo")
    private final BottomSheetStandardPromo bottomSheetStandardPromo;
    private final CallLocale call;

    @SerializedName("call_notification")
    private final CallNotificationLocale callNotification;

    @SerializedName("camera_gallery")
    private final CameraGalleryLocale cameraGallery;

    @SerializedName("camera_list")
    private final CamerasLocale cameraList;

    @SerializedName("camera_settings")
    private final CamerasSettingsLocale cameraSettings;
    private final CardLocale card;

    @SerializedName("change_language_popup")
    private final ChangeLanguagePopUpLocale changeLanguagePopup;

    @SerializedName("choose_language")
    private final ChooseLanguageLocale chooseLanguage;
    private final CommonLocale common;

    @SerializedName("confirm_address")
    private final ConfirmAddressLocale confirmAddress;
    private final CompanyContactsLocale contacts;

    @SerializedName("country_picker")
    private final CountryPickerLocale countryPicker;

    @SerializedName("debt_popup")
    private final DebtPopupLocale debtPopup;

    @SerializedName("delete_payment_method")
    private final DeletePaymentMethodLocale deletePaymentMethod;
    private final DemoModeLocale demo;

    @SerializedName("digital_keys_main")
    private final DigitalKeysMainLocale digitalKeysMain;

    @SerializedName("domofon")
    private final DomofonLocale domofon;

    @SerializedName("domofon_settings")
    private final DomofonSettingsLocale domofonSettings;

    @SerializedName("open_door_error_popup")
    private final EmergencyCodeLocale emergencyCodeLocale;

    @SerializedName("enter_code")
    private final EnterCodeLocale enterCode;

    @SerializedName("face_recognizer_error")
    private final FaceRecognitionErrorLocale faceRecognitionError;

    @SerializedName("face_recognizer_main")
    private final FaceRecognitionMainLocale faceRecognitionMain;

    @SerializedName("face_recognizer_settings")
    private final FaceRecognitionSettingsLocale faceRecognitionSettings;

    @SerializedName("face_recognizer_start")
    private final FaceRecognitionStartLocale faceRecognitionStart;

    @SerializedName("face_recognizer_upload")
    private final FaceRecognitionUploadLocale faceRecognitionUpload;

    @SerializedName("family_invites")
    private final FamilyInvitesLocale familyInvites;

    @SerializedName("family_list")
    private final FamilyListLocale familyList;

    @SerializedName("family_member")
    private final FamilyMemberLocale familyMember;
    private final FaqLocale faq;

    @SerializedName("feedback_comment")
    private final FeedbackCommentLocale feedbackComment;

    @SerializedName("feedback_done")
    private final FeedbackDoneLocale feedbackDone;

    @SerializedName("feedback_main")
    private final FeedBackLocale feedbackMain;

    @SerializedName("flussonic_camera_picker")
    private final FlussonicCameraPicker flussonicCameraPicker;
    private final HelpLocale help;
    private final IntercomLocale intercom;

    @SerializedName("error")
    private final InternetErrorLocale internetError;
    private final InvitesBodyLocale invites;
    private final String language;

    @SerializedName("language_list")
    private final LanguageListLocale languageList;

    @SerializedName("language_loader")
    private final LanguageLoaderLocale languageLoader;

    @SerializedName("camera_list_settings")
    private final ManageCamerasLocale manageCameras;
    private final MarketLocale market;

    @SerializedName("no_contract_popup")
    private final NoContractPopupLocale noContractPopup;

    @SerializedName(RemoteMessageConst.NOTIFICATION)
    private final NotificationLocale notification;
    private final NotificationsBody notifications;

    @SerializedName("onboarding_language_loader")
    private final OnBoardingLanguageLoaderLocale onBoardingLanguageLoader;

    @SerializedName("our_home_pre_update_popup")
    private final OurHomePreUpdatePopup ourHomePreUpdatePopup;

    @SerializedName("our_home_update")
    private final OurHomeUpdate ourHomeUpdate;

    @SerializedName("our_home_update_plate")
    private final OurHomeUpdatePlate ourHomeUpdatePlate;

    @SerializedName("our_home_update_popup")
    private final OurHomeUpdatePopup ourHomeUpdatePopup;

    @SerializedName("payment_bottom_sheet")
    private final PaymentBottomSheet paymentBottomSheet;

    @SerializedName("payment_waiting")
    private final PaymentWaitingLocale paymentWaiting;
    private final PermissionsLocale permissions;

    @SerializedName("phone_login")
    private final PhoneLoginLocale phoneLogin;

    @SerializedName("physical_keys")
    private final PhysicalKeysLocale physicalKeys;
    private final String platform;

    @SerializedName("poll_sent_popup")
    private final PollSentPopup pollSentPopup;

    @SerializedName("profile_edit")
    private final ProfileSettingsLocale profileSettings;

    @SerializedName("promise_popup")
    private final PromisePopupLocale promisePopup;

    @SerializedName("promise_success_popup")
    private final PromiseSuccessPopupLocale promiseSuccessPopup;
    private final RegisterLocale register;

    @SerializedName("register_popup")
    private final RegisterPopupLocale registerPopup;

    @SerializedName("application_for_installation")
    private final SendInstallSputnik sendInstallSputnik;

    @SerializedName("service_payment_about_popup")
    private final ServicePaymentAboutPopupLocale servicePaymentAboutPopup;

    @SerializedName("service_payment_cancel_popup")
    private final ServicePaymentCancelPopupLocale servicePaymentCancelPopup;

    @SerializedName("service_payment_detail")
    private final ServicePaymentDetailLocale servicePaymentDetail;

    @SerializedName("service_payment")
    private final ServicePaymentLocale servicePaymentLocale;

    @SerializedName("service_payment_pay")
    private final ServicePaymentPayLocale servicePaymentPay;

    @SerializedName("service_payment_success")
    private final ServicePaymentSuccessLocale servicePaymentSuccess;

    @SerializedName("service_popup")
    private final ServicePopupLocale servicePopup;
    private final SettingsLocale settings;
    private final SplashLocale splash;

    @SerializedName("start")
    private final StartLanguageLocale startLanguageLocale;

    @SerializedName("start_registration")
    private final StartRegistrationLocale startRegistration;

    @SerializedName("stop_subscription_popup")
    private final UnSubscriptionPopUpLocale stopSubscriptionPopup;

    @SerializedName("subscription_buy")
    private final SubscriptionBuyLocale subscriptionBuy;

    @SerializedName("subscription_cancel")
    private final TitleWithSubtitle subscriptionCancel;

    @SerializedName("subscription_changed_tariff_popup")
    private final SubscriptionChangedPopupLocale subscriptionChangedTariffPopup;

    @SerializedName("subscription_popup")
    private final SubscriptionPopupLocale subscriptionPopUp;

    @SerializedName("subscription_settings")
    private final SettingsSubscriptionLocale subscriptionSettings;

    @SerializedName("subscription_deactivate")
    private final SubscriptionStopBody subscriptionStopBody;

    @SerializedName("subscription_tariff_popup")
    private final SubscriptionPayedPopupLocale subscriptionTariffPopup;
    private final String tag;

    @SerializedName("unsubscription_popup")
    private final UnSubscriptionPopUpLocale unsubscriptionPopup;

    @SerializedName("view_payment_in_progress")
    private final TextTitle viewPaymentInProgress;

    @SerializedName("image_viewer")
    private final ImageViewerLocale visitor;
    private final VisitsLocale visits;

    @SerializedName("visits_archive_info_popup")
    private final VisitsArchiveInfoPopup visitsArchiveInfoPopup;

    @SerializedName("visits_no_archive_data_popup")
    private final VisitsArchiveInfoPopup visitsNoArchiveDataPopup;

    @SerializedName("vpn_view")
    private final VpnBodyLocale vpnView;
    private final WidgetsLocale widgets;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LocalizationLocalModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LocalizationLocalModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LocalizationLocalModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : SplashLocale.CREATOR.createFromParcel(parcel), (ChooseLanguageLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), parcel.readInt() == 0 ? null : CountryPickerLocale.CREATOR.createFromParcel(parcel), (OnBoardingLanguageLoaderLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (StartLanguageLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (StartRegistrationLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (AccountsLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (PhoneLoginLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (EnterCodeLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (AboutCodeLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (RegisterPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (DomofonLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (ConfirmAddressLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (RegisterLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), parcel.readInt() == 0 ? null : CamerasLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : VisitsLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : VisitsArchiveInfoPopup.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : VisitsArchiveInfoPopup.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FeedBackLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FeedbackCommentLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FeedbackDoneLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : SettingsLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ProfileSettingsLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DomofonSettingsLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FamilyListLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FamilyMemberLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AddAddressLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ManageCamerasLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CameraGalleryLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CamerasSettingsLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : LanguageListLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ChangeLanguagePopUpLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : LanguageLoaderLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MarketLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PaymentWaitingLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : SubscriptionBuyLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FaceRecognitionStartLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FaceRecognitionMainLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FaceRecognitionSettingsLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FaceRecognitionUploadLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FaceRecognitionErrorLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ArchiveMainLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ArchivePopUpLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : FlussonicCameraPicker.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DigitalKeysMainLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : HelpLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AboutLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AboutCompanyLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : InternetErrorLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : BlockLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : BlockMain.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CallLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ArchiveDownloadLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ImageViewerLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ServicePopupLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AlertLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AddNewCardLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CardLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CommonLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : IntercomLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CallNotificationLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : WidgetsLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : EmergencyCodeLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : NotificationLocale.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : BottomSheetStandardPromo.CREATOR.createFromParcel(parcel), (ServicePaymentLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (ServicePaymentDetailLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (ServicePaymentSuccessLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (ServicePaymentAboutPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (ServicePaymentCancelPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (ServicePaymentPayLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (NoContractPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (TextTitle) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (PromiseSuccessPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (PromisePopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (DebtPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (ArguePopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (AboutServiceCompanyLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (SubscriptionPayedPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (SubscriptionChangedPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (SettingsSubscriptionLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (UnSubscriptionPopUpLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (UnSubscriptionPopUpLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (SubscriptionPopupLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (TitleWithSubtitle) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (SubscriptionStopBody) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (DemoModeLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (SendInstallSputnik) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (OurHomePreUpdatePopup) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (OurHomeUpdatePopup) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (OurHomeUpdate) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (OurHomeUpdatePlate) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (AuthorizationBody) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (AuthorizationLimitExceededBody) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (PollSentPopup) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (PaymentBottomSheet) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (AuthorizationNeedHelpBodyLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (NotificationsBody) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (FaqLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (VpnBodyLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (InvitesBodyLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (PhysicalKeysLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (CompanyContactsLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (DeletePaymentMethodLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (FamilyInvitesLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (BleLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()), (PermissionsLocale) parcel.readParcelable(LocalizationLocalModel.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LocalizationLocalModel[] newArray(int i) {
            return new LocalizationLocalModel[i];
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
        if (!(other instanceof LocalizationLocalModel)) {
            return false;
        }
        LocalizationLocalModel localizationLocalModel = (LocalizationLocalModel) other;
        return Intrinsics.areEqual(this.tag, localizationLocalModel.tag) && Intrinsics.areEqual(this.language, localizationLocalModel.language) && Intrinsics.areEqual(this.platform, localizationLocalModel.platform) && Intrinsics.areEqual(this.splash, localizationLocalModel.splash) && Intrinsics.areEqual(this.chooseLanguage, localizationLocalModel.chooseLanguage) && Intrinsics.areEqual(this.countryPicker, localizationLocalModel.countryPicker) && Intrinsics.areEqual(this.onBoardingLanguageLoader, localizationLocalModel.onBoardingLanguageLoader) && Intrinsics.areEqual(this.startLanguageLocale, localizationLocalModel.startLanguageLocale) && Intrinsics.areEqual(this.startRegistration, localizationLocalModel.startRegistration) && Intrinsics.areEqual(this.accounts, localizationLocalModel.accounts) && Intrinsics.areEqual(this.phoneLogin, localizationLocalModel.phoneLogin) && Intrinsics.areEqual(this.enterCode, localizationLocalModel.enterCode) && Intrinsics.areEqual(this.aboutCode, localizationLocalModel.aboutCode) && Intrinsics.areEqual(this.registerPopup, localizationLocalModel.registerPopup) && Intrinsics.areEqual(this.domofon, localizationLocalModel.domofon) && Intrinsics.areEqual(this.confirmAddress, localizationLocalModel.confirmAddress) && Intrinsics.areEqual(this.register, localizationLocalModel.register) && Intrinsics.areEqual(this.cameraList, localizationLocalModel.cameraList) && Intrinsics.areEqual(this.visits, localizationLocalModel.visits) && Intrinsics.areEqual(this.visitsArchiveInfoPopup, localizationLocalModel.visitsArchiveInfoPopup) && Intrinsics.areEqual(this.visitsNoArchiveDataPopup, localizationLocalModel.visitsNoArchiveDataPopup) && Intrinsics.areEqual(this.feedbackMain, localizationLocalModel.feedbackMain) && Intrinsics.areEqual(this.feedbackComment, localizationLocalModel.feedbackComment) && Intrinsics.areEqual(this.feedbackDone, localizationLocalModel.feedbackDone) && Intrinsics.areEqual(this.settings, localizationLocalModel.settings) && Intrinsics.areEqual(this.profileSettings, localizationLocalModel.profileSettings) && Intrinsics.areEqual(this.domofonSettings, localizationLocalModel.domofonSettings) && Intrinsics.areEqual(this.familyList, localizationLocalModel.familyList) && Intrinsics.areEqual(this.familyMember, localizationLocalModel.familyMember) && Intrinsics.areEqual(this.addAddress, localizationLocalModel.addAddress) && Intrinsics.areEqual(this.manageCameras, localizationLocalModel.manageCameras) && Intrinsics.areEqual(this.cameraGallery, localizationLocalModel.cameraGallery) && Intrinsics.areEqual(this.cameraSettings, localizationLocalModel.cameraSettings) && Intrinsics.areEqual(this.languageList, localizationLocalModel.languageList) && Intrinsics.areEqual(this.changeLanguagePopup, localizationLocalModel.changeLanguagePopup) && Intrinsics.areEqual(this.languageLoader, localizationLocalModel.languageLoader) && Intrinsics.areEqual(this.market, localizationLocalModel.market) && Intrinsics.areEqual(this.paymentWaiting, localizationLocalModel.paymentWaiting) && Intrinsics.areEqual(this.subscriptionBuy, localizationLocalModel.subscriptionBuy) && Intrinsics.areEqual(this.faceRecognitionStart, localizationLocalModel.faceRecognitionStart) && Intrinsics.areEqual(this.faceRecognitionMain, localizationLocalModel.faceRecognitionMain) && Intrinsics.areEqual(this.faceRecognitionSettings, localizationLocalModel.faceRecognitionSettings) && Intrinsics.areEqual(this.faceRecognitionUpload, localizationLocalModel.faceRecognitionUpload) && Intrinsics.areEqual(this.faceRecognitionError, localizationLocalModel.faceRecognitionError) && Intrinsics.areEqual(this.archiveMain, localizationLocalModel.archiveMain) && Intrinsics.areEqual(this.archivePopUp, localizationLocalModel.archivePopUp) && Intrinsics.areEqual(this.flussonicCameraPicker, localizationLocalModel.flussonicCameraPicker) && Intrinsics.areEqual(this.digitalKeysMain, localizationLocalModel.digitalKeysMain) && Intrinsics.areEqual(this.help, localizationLocalModel.help) && Intrinsics.areEqual(this.about, localizationLocalModel.about) && Intrinsics.areEqual(this.aboutCompany, localizationLocalModel.aboutCompany) && Intrinsics.areEqual(this.internetError, localizationLocalModel.internetError) && Intrinsics.areEqual(this.block, localizationLocalModel.block) && Intrinsics.areEqual(this.blockMain, localizationLocalModel.blockMain) && Intrinsics.areEqual(this.call, localizationLocalModel.call) && Intrinsics.areEqual(this.archiveDownloader, localizationLocalModel.archiveDownloader) && Intrinsics.areEqual(this.visitor, localizationLocalModel.visitor) && Intrinsics.areEqual(this.servicePopup, localizationLocalModel.servicePopup) && Intrinsics.areEqual(this.alert, localizationLocalModel.alert) && Intrinsics.areEqual(this.addNewCard, localizationLocalModel.addNewCard) && Intrinsics.areEqual(this.card, localizationLocalModel.card) && Intrinsics.areEqual(this.common, localizationLocalModel.common) && Intrinsics.areEqual(this.intercom, localizationLocalModel.intercom) && Intrinsics.areEqual(this.callNotification, localizationLocalModel.callNotification) && Intrinsics.areEqual(this.widgets, localizationLocalModel.widgets) && Intrinsics.areEqual(this.emergencyCodeLocale, localizationLocalModel.emergencyCodeLocale) && Intrinsics.areEqual(this.notification, localizationLocalModel.notification) && Intrinsics.areEqual(this.bottomSheetStandardPromo, localizationLocalModel.bottomSheetStandardPromo) && Intrinsics.areEqual(this.servicePaymentLocale, localizationLocalModel.servicePaymentLocale) && Intrinsics.areEqual(this.servicePaymentDetail, localizationLocalModel.servicePaymentDetail) && Intrinsics.areEqual(this.servicePaymentSuccess, localizationLocalModel.servicePaymentSuccess) && Intrinsics.areEqual(this.servicePaymentAboutPopup, localizationLocalModel.servicePaymentAboutPopup) && Intrinsics.areEqual(this.servicePaymentCancelPopup, localizationLocalModel.servicePaymentCancelPopup) && Intrinsics.areEqual(this.servicePaymentPay, localizationLocalModel.servicePaymentPay) && Intrinsics.areEqual(this.noContractPopup, localizationLocalModel.noContractPopup) && Intrinsics.areEqual(this.viewPaymentInProgress, localizationLocalModel.viewPaymentInProgress) && Intrinsics.areEqual(this.promiseSuccessPopup, localizationLocalModel.promiseSuccessPopup) && Intrinsics.areEqual(this.promisePopup, localizationLocalModel.promisePopup) && Intrinsics.areEqual(this.debtPopup, localizationLocalModel.debtPopup) && Intrinsics.areEqual(this.arguePopup, localizationLocalModel.arguePopup) && Intrinsics.areEqual(this.aboutCompanyPopup, localizationLocalModel.aboutCompanyPopup) && Intrinsics.areEqual(this.subscriptionTariffPopup, localizationLocalModel.subscriptionTariffPopup) && Intrinsics.areEqual(this.subscriptionChangedTariffPopup, localizationLocalModel.subscriptionChangedTariffPopup) && Intrinsics.areEqual(this.subscriptionSettings, localizationLocalModel.subscriptionSettings) && Intrinsics.areEqual(this.unsubscriptionPopup, localizationLocalModel.unsubscriptionPopup) && Intrinsics.areEqual(this.stopSubscriptionPopup, localizationLocalModel.stopSubscriptionPopup) && Intrinsics.areEqual(this.subscriptionPopUp, localizationLocalModel.subscriptionPopUp) && Intrinsics.areEqual(this.subscriptionCancel, localizationLocalModel.subscriptionCancel) && Intrinsics.areEqual(this.subscriptionStopBody, localizationLocalModel.subscriptionStopBody) && Intrinsics.areEqual(this.demo, localizationLocalModel.demo) && Intrinsics.areEqual(this.sendInstallSputnik, localizationLocalModel.sendInstallSputnik) && Intrinsics.areEqual(this.ourHomePreUpdatePopup, localizationLocalModel.ourHomePreUpdatePopup) && Intrinsics.areEqual(this.ourHomeUpdatePopup, localizationLocalModel.ourHomeUpdatePopup) && Intrinsics.areEqual(this.ourHomeUpdate, localizationLocalModel.ourHomeUpdate) && Intrinsics.areEqual(this.ourHomeUpdatePlate, localizationLocalModel.ourHomeUpdatePlate) && Intrinsics.areEqual(this.authorizationCode, localizationLocalModel.authorizationCode) && Intrinsics.areEqual(this.authorizationLimitExceeded, localizationLocalModel.authorizationLimitExceeded) && Intrinsics.areEqual(this.pollSentPopup, localizationLocalModel.pollSentPopup) && Intrinsics.areEqual(this.paymentBottomSheet, localizationLocalModel.paymentBottomSheet) && Intrinsics.areEqual(this.authNeedHelp, localizationLocalModel.authNeedHelp) && Intrinsics.areEqual(this.notifications, localizationLocalModel.notifications) && Intrinsics.areEqual(this.faq, localizationLocalModel.faq) && Intrinsics.areEqual(this.vpnView, localizationLocalModel.vpnView) && Intrinsics.areEqual(this.invites, localizationLocalModel.invites) && Intrinsics.areEqual(this.physicalKeys, localizationLocalModel.physicalKeys) && Intrinsics.areEqual(this.contacts, localizationLocalModel.contacts) && Intrinsics.areEqual(this.deletePaymentMethod, localizationLocalModel.deletePaymentMethod) && Intrinsics.areEqual(this.familyInvites, localizationLocalModel.familyInvites) && Intrinsics.areEqual(this.ble, localizationLocalModel.ble) && Intrinsics.areEqual(this.permissions, localizationLocalModel.permissions);
    }

    public int hashCode() {
        String str = this.tag;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.language;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.platform;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SplashLocale splashLocale = this.splash;
        int iHashCode4 = (iHashCode3 + (splashLocale == null ? 0 : splashLocale.hashCode())) * 31;
        ChooseLanguageLocale chooseLanguageLocale = this.chooseLanguage;
        int iHashCode5 = (iHashCode4 + (chooseLanguageLocale == null ? 0 : chooseLanguageLocale.hashCode())) * 31;
        CountryPickerLocale countryPickerLocale = this.countryPicker;
        int iHashCode6 = (iHashCode5 + (countryPickerLocale == null ? 0 : countryPickerLocale.hashCode())) * 31;
        OnBoardingLanguageLoaderLocale onBoardingLanguageLoaderLocale = this.onBoardingLanguageLoader;
        int iHashCode7 = (iHashCode6 + (onBoardingLanguageLoaderLocale == null ? 0 : onBoardingLanguageLoaderLocale.hashCode())) * 31;
        StartLanguageLocale startLanguageLocale = this.startLanguageLocale;
        int iHashCode8 = (iHashCode7 + (startLanguageLocale == null ? 0 : startLanguageLocale.hashCode())) * 31;
        StartRegistrationLocale startRegistrationLocale = this.startRegistration;
        int iHashCode9 = (iHashCode8 + (startRegistrationLocale == null ? 0 : startRegistrationLocale.hashCode())) * 31;
        AccountsLocale accountsLocale = this.accounts;
        int iHashCode10 = (iHashCode9 + (accountsLocale == null ? 0 : accountsLocale.hashCode())) * 31;
        PhoneLoginLocale phoneLoginLocale = this.phoneLogin;
        int iHashCode11 = (iHashCode10 + (phoneLoginLocale == null ? 0 : phoneLoginLocale.hashCode())) * 31;
        EnterCodeLocale enterCodeLocale = this.enterCode;
        int iHashCode12 = (iHashCode11 + (enterCodeLocale == null ? 0 : enterCodeLocale.hashCode())) * 31;
        AboutCodeLocale aboutCodeLocale = this.aboutCode;
        int iHashCode13 = (iHashCode12 + (aboutCodeLocale == null ? 0 : aboutCodeLocale.hashCode())) * 31;
        RegisterPopupLocale registerPopupLocale = this.registerPopup;
        int iHashCode14 = (iHashCode13 + (registerPopupLocale == null ? 0 : registerPopupLocale.hashCode())) * 31;
        DomofonLocale domofonLocale = this.domofon;
        int iHashCode15 = (((iHashCode14 + (domofonLocale == null ? 0 : domofonLocale.hashCode())) * 31) + this.confirmAddress.hashCode()) * 31;
        RegisterLocale registerLocale = this.register;
        int iHashCode16 = (iHashCode15 + (registerLocale == null ? 0 : registerLocale.hashCode())) * 31;
        CamerasLocale camerasLocale = this.cameraList;
        int iHashCode17 = (iHashCode16 + (camerasLocale == null ? 0 : camerasLocale.hashCode())) * 31;
        VisitsLocale visitsLocale = this.visits;
        int iHashCode18 = (iHashCode17 + (visitsLocale == null ? 0 : visitsLocale.hashCode())) * 31;
        VisitsArchiveInfoPopup visitsArchiveInfoPopup = this.visitsArchiveInfoPopup;
        int iHashCode19 = (iHashCode18 + (visitsArchiveInfoPopup == null ? 0 : visitsArchiveInfoPopup.hashCode())) * 31;
        VisitsArchiveInfoPopup visitsArchiveInfoPopup2 = this.visitsNoArchiveDataPopup;
        int iHashCode20 = (iHashCode19 + (visitsArchiveInfoPopup2 == null ? 0 : visitsArchiveInfoPopup2.hashCode())) * 31;
        FeedBackLocale feedBackLocale = this.feedbackMain;
        int iHashCode21 = (iHashCode20 + (feedBackLocale == null ? 0 : feedBackLocale.hashCode())) * 31;
        FeedbackCommentLocale feedbackCommentLocale = this.feedbackComment;
        int iHashCode22 = (iHashCode21 + (feedbackCommentLocale == null ? 0 : feedbackCommentLocale.hashCode())) * 31;
        FeedbackDoneLocale feedbackDoneLocale = this.feedbackDone;
        int iHashCode23 = (iHashCode22 + (feedbackDoneLocale == null ? 0 : feedbackDoneLocale.hashCode())) * 31;
        SettingsLocale settingsLocale = this.settings;
        int iHashCode24 = (iHashCode23 + (settingsLocale == null ? 0 : settingsLocale.hashCode())) * 31;
        ProfileSettingsLocale profileSettingsLocale = this.profileSettings;
        int iHashCode25 = (iHashCode24 + (profileSettingsLocale == null ? 0 : profileSettingsLocale.hashCode())) * 31;
        DomofonSettingsLocale domofonSettingsLocale = this.domofonSettings;
        int iHashCode26 = (iHashCode25 + (domofonSettingsLocale == null ? 0 : domofonSettingsLocale.hashCode())) * 31;
        FamilyListLocale familyListLocale = this.familyList;
        int iHashCode27 = (iHashCode26 + (familyListLocale == null ? 0 : familyListLocale.hashCode())) * 31;
        FamilyMemberLocale familyMemberLocale = this.familyMember;
        int iHashCode28 = (iHashCode27 + (familyMemberLocale == null ? 0 : familyMemberLocale.hashCode())) * 31;
        AddAddressLocale addAddressLocale = this.addAddress;
        int iHashCode29 = (iHashCode28 + (addAddressLocale == null ? 0 : addAddressLocale.hashCode())) * 31;
        ManageCamerasLocale manageCamerasLocale = this.manageCameras;
        int iHashCode30 = (iHashCode29 + (manageCamerasLocale == null ? 0 : manageCamerasLocale.hashCode())) * 31;
        CameraGalleryLocale cameraGalleryLocale = this.cameraGallery;
        int iHashCode31 = (iHashCode30 + (cameraGalleryLocale == null ? 0 : cameraGalleryLocale.hashCode())) * 31;
        CamerasSettingsLocale camerasSettingsLocale = this.cameraSettings;
        int iHashCode32 = (iHashCode31 + (camerasSettingsLocale == null ? 0 : camerasSettingsLocale.hashCode())) * 31;
        LanguageListLocale languageListLocale = this.languageList;
        int iHashCode33 = (iHashCode32 + (languageListLocale == null ? 0 : languageListLocale.hashCode())) * 31;
        ChangeLanguagePopUpLocale changeLanguagePopUpLocale = this.changeLanguagePopup;
        int iHashCode34 = (iHashCode33 + (changeLanguagePopUpLocale == null ? 0 : changeLanguagePopUpLocale.hashCode())) * 31;
        LanguageLoaderLocale languageLoaderLocale = this.languageLoader;
        int iHashCode35 = (iHashCode34 + (languageLoaderLocale == null ? 0 : languageLoaderLocale.hashCode())) * 31;
        MarketLocale marketLocale = this.market;
        int iHashCode36 = (iHashCode35 + (marketLocale == null ? 0 : marketLocale.hashCode())) * 31;
        PaymentWaitingLocale paymentWaitingLocale = this.paymentWaiting;
        int iHashCode37 = (iHashCode36 + (paymentWaitingLocale == null ? 0 : paymentWaitingLocale.hashCode())) * 31;
        SubscriptionBuyLocale subscriptionBuyLocale = this.subscriptionBuy;
        int iHashCode38 = (iHashCode37 + (subscriptionBuyLocale == null ? 0 : subscriptionBuyLocale.hashCode())) * 31;
        FaceRecognitionStartLocale faceRecognitionStartLocale = this.faceRecognitionStart;
        int iHashCode39 = (iHashCode38 + (faceRecognitionStartLocale == null ? 0 : faceRecognitionStartLocale.hashCode())) * 31;
        FaceRecognitionMainLocale faceRecognitionMainLocale = this.faceRecognitionMain;
        int iHashCode40 = (iHashCode39 + (faceRecognitionMainLocale == null ? 0 : faceRecognitionMainLocale.hashCode())) * 31;
        FaceRecognitionSettingsLocale faceRecognitionSettingsLocale = this.faceRecognitionSettings;
        int iHashCode41 = (iHashCode40 + (faceRecognitionSettingsLocale == null ? 0 : faceRecognitionSettingsLocale.hashCode())) * 31;
        FaceRecognitionUploadLocale faceRecognitionUploadLocale = this.faceRecognitionUpload;
        int iHashCode42 = (iHashCode41 + (faceRecognitionUploadLocale == null ? 0 : faceRecognitionUploadLocale.hashCode())) * 31;
        FaceRecognitionErrorLocale faceRecognitionErrorLocale = this.faceRecognitionError;
        int iHashCode43 = (iHashCode42 + (faceRecognitionErrorLocale == null ? 0 : faceRecognitionErrorLocale.hashCode())) * 31;
        ArchiveMainLocale archiveMainLocale = this.archiveMain;
        int iHashCode44 = (iHashCode43 + (archiveMainLocale == null ? 0 : archiveMainLocale.hashCode())) * 31;
        ArchivePopUpLocale archivePopUpLocale = this.archivePopUp;
        int iHashCode45 = (iHashCode44 + (archivePopUpLocale == null ? 0 : archivePopUpLocale.hashCode())) * 31;
        FlussonicCameraPicker flussonicCameraPicker = this.flussonicCameraPicker;
        int iHashCode46 = (iHashCode45 + (flussonicCameraPicker == null ? 0 : flussonicCameraPicker.hashCode())) * 31;
        DigitalKeysMainLocale digitalKeysMainLocale = this.digitalKeysMain;
        int iHashCode47 = (iHashCode46 + (digitalKeysMainLocale == null ? 0 : digitalKeysMainLocale.hashCode())) * 31;
        HelpLocale helpLocale = this.help;
        int iHashCode48 = (iHashCode47 + (helpLocale == null ? 0 : helpLocale.hashCode())) * 31;
        AboutLocale aboutLocale = this.about;
        int iHashCode49 = (iHashCode48 + (aboutLocale == null ? 0 : aboutLocale.hashCode())) * 31;
        AboutCompanyLocale aboutCompanyLocale = this.aboutCompany;
        int iHashCode50 = (iHashCode49 + (aboutCompanyLocale == null ? 0 : aboutCompanyLocale.hashCode())) * 31;
        InternetErrorLocale internetErrorLocale = this.internetError;
        int iHashCode51 = (iHashCode50 + (internetErrorLocale == null ? 0 : internetErrorLocale.hashCode())) * 31;
        BlockLocale blockLocale = this.block;
        int iHashCode52 = (iHashCode51 + (blockLocale == null ? 0 : blockLocale.hashCode())) * 31;
        BlockMain blockMain = this.blockMain;
        int iHashCode53 = (iHashCode52 + (blockMain == null ? 0 : blockMain.hashCode())) * 31;
        CallLocale callLocale = this.call;
        int iHashCode54 = (iHashCode53 + (callLocale == null ? 0 : callLocale.hashCode())) * 31;
        ArchiveDownloadLocale archiveDownloadLocale = this.archiveDownloader;
        int iHashCode55 = (iHashCode54 + (archiveDownloadLocale == null ? 0 : archiveDownloadLocale.hashCode())) * 31;
        ImageViewerLocale imageViewerLocale = this.visitor;
        int iHashCode56 = (iHashCode55 + (imageViewerLocale == null ? 0 : imageViewerLocale.hashCode())) * 31;
        ServicePopupLocale servicePopupLocale = this.servicePopup;
        int iHashCode57 = (iHashCode56 + (servicePopupLocale == null ? 0 : servicePopupLocale.hashCode())) * 31;
        AlertLocale alertLocale = this.alert;
        int iHashCode58 = (iHashCode57 + (alertLocale == null ? 0 : alertLocale.hashCode())) * 31;
        AddNewCardLocale addNewCardLocale = this.addNewCard;
        int iHashCode59 = (iHashCode58 + (addNewCardLocale == null ? 0 : addNewCardLocale.hashCode())) * 31;
        CardLocale cardLocale = this.card;
        int iHashCode60 = (iHashCode59 + (cardLocale == null ? 0 : cardLocale.hashCode())) * 31;
        CommonLocale commonLocale = this.common;
        int iHashCode61 = (iHashCode60 + (commonLocale == null ? 0 : commonLocale.hashCode())) * 31;
        IntercomLocale intercomLocale = this.intercom;
        int iHashCode62 = (iHashCode61 + (intercomLocale == null ? 0 : intercomLocale.hashCode())) * 31;
        CallNotificationLocale callNotificationLocale = this.callNotification;
        int iHashCode63 = (iHashCode62 + (callNotificationLocale == null ? 0 : callNotificationLocale.hashCode())) * 31;
        WidgetsLocale widgetsLocale = this.widgets;
        int iHashCode64 = (iHashCode63 + (widgetsLocale == null ? 0 : widgetsLocale.hashCode())) * 31;
        EmergencyCodeLocale emergencyCodeLocale = this.emergencyCodeLocale;
        int iHashCode65 = (iHashCode64 + (emergencyCodeLocale == null ? 0 : emergencyCodeLocale.hashCode())) * 31;
        NotificationLocale notificationLocale = this.notification;
        int iHashCode66 = (iHashCode65 + (notificationLocale == null ? 0 : notificationLocale.hashCode())) * 31;
        BottomSheetStandardPromo bottomSheetStandardPromo = this.bottomSheetStandardPromo;
        int iHashCode67 = (iHashCode66 + (bottomSheetStandardPromo == null ? 0 : bottomSheetStandardPromo.hashCode())) * 31;
        ServicePaymentLocale servicePaymentLocale = this.servicePaymentLocale;
        int iHashCode68 = (iHashCode67 + (servicePaymentLocale == null ? 0 : servicePaymentLocale.hashCode())) * 31;
        ServicePaymentDetailLocale servicePaymentDetailLocale = this.servicePaymentDetail;
        int iHashCode69 = (iHashCode68 + (servicePaymentDetailLocale == null ? 0 : servicePaymentDetailLocale.hashCode())) * 31;
        ServicePaymentSuccessLocale servicePaymentSuccessLocale = this.servicePaymentSuccess;
        int iHashCode70 = (iHashCode69 + (servicePaymentSuccessLocale == null ? 0 : servicePaymentSuccessLocale.hashCode())) * 31;
        ServicePaymentAboutPopupLocale servicePaymentAboutPopupLocale = this.servicePaymentAboutPopup;
        int iHashCode71 = (iHashCode70 + (servicePaymentAboutPopupLocale == null ? 0 : servicePaymentAboutPopupLocale.hashCode())) * 31;
        ServicePaymentCancelPopupLocale servicePaymentCancelPopupLocale = this.servicePaymentCancelPopup;
        int iHashCode72 = (iHashCode71 + (servicePaymentCancelPopupLocale == null ? 0 : servicePaymentCancelPopupLocale.hashCode())) * 31;
        ServicePaymentPayLocale servicePaymentPayLocale = this.servicePaymentPay;
        int iHashCode73 = (iHashCode72 + (servicePaymentPayLocale == null ? 0 : servicePaymentPayLocale.hashCode())) * 31;
        NoContractPopupLocale noContractPopupLocale = this.noContractPopup;
        int iHashCode74 = (iHashCode73 + (noContractPopupLocale == null ? 0 : noContractPopupLocale.hashCode())) * 31;
        TextTitle textTitle = this.viewPaymentInProgress;
        int iHashCode75 = (iHashCode74 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        PromiseSuccessPopupLocale promiseSuccessPopupLocale = this.promiseSuccessPopup;
        int iHashCode76 = (iHashCode75 + (promiseSuccessPopupLocale == null ? 0 : promiseSuccessPopupLocale.hashCode())) * 31;
        PromisePopupLocale promisePopupLocale = this.promisePopup;
        int iHashCode77 = (iHashCode76 + (promisePopupLocale == null ? 0 : promisePopupLocale.hashCode())) * 31;
        DebtPopupLocale debtPopupLocale = this.debtPopup;
        int iHashCode78 = (iHashCode77 + (debtPopupLocale == null ? 0 : debtPopupLocale.hashCode())) * 31;
        ArguePopupLocale arguePopupLocale = this.arguePopup;
        int iHashCode79 = (iHashCode78 + (arguePopupLocale == null ? 0 : arguePopupLocale.hashCode())) * 31;
        AboutServiceCompanyLocale aboutServiceCompanyLocale = this.aboutCompanyPopup;
        int iHashCode80 = (iHashCode79 + (aboutServiceCompanyLocale == null ? 0 : aboutServiceCompanyLocale.hashCode())) * 31;
        SubscriptionPayedPopupLocale subscriptionPayedPopupLocale = this.subscriptionTariffPopup;
        int iHashCode81 = (iHashCode80 + (subscriptionPayedPopupLocale == null ? 0 : subscriptionPayedPopupLocale.hashCode())) * 31;
        SubscriptionChangedPopupLocale subscriptionChangedPopupLocale = this.subscriptionChangedTariffPopup;
        int iHashCode82 = (iHashCode81 + (subscriptionChangedPopupLocale == null ? 0 : subscriptionChangedPopupLocale.hashCode())) * 31;
        SettingsSubscriptionLocale settingsSubscriptionLocale = this.subscriptionSettings;
        int iHashCode83 = (iHashCode82 + (settingsSubscriptionLocale == null ? 0 : settingsSubscriptionLocale.hashCode())) * 31;
        UnSubscriptionPopUpLocale unSubscriptionPopUpLocale = this.unsubscriptionPopup;
        int iHashCode84 = (iHashCode83 + (unSubscriptionPopUpLocale == null ? 0 : unSubscriptionPopUpLocale.hashCode())) * 31;
        UnSubscriptionPopUpLocale unSubscriptionPopUpLocale2 = this.stopSubscriptionPopup;
        int iHashCode85 = (iHashCode84 + (unSubscriptionPopUpLocale2 == null ? 0 : unSubscriptionPopUpLocale2.hashCode())) * 31;
        SubscriptionPopupLocale subscriptionPopupLocale = this.subscriptionPopUp;
        int iHashCode86 = (iHashCode85 + (subscriptionPopupLocale == null ? 0 : subscriptionPopupLocale.hashCode())) * 31;
        TitleWithSubtitle titleWithSubtitle = this.subscriptionCancel;
        int iHashCode87 = (iHashCode86 + (titleWithSubtitle == null ? 0 : titleWithSubtitle.hashCode())) * 31;
        SubscriptionStopBody subscriptionStopBody = this.subscriptionStopBody;
        int iHashCode88 = (iHashCode87 + (subscriptionStopBody == null ? 0 : subscriptionStopBody.hashCode())) * 31;
        DemoModeLocale demoModeLocale = this.demo;
        int iHashCode89 = (iHashCode88 + (demoModeLocale == null ? 0 : demoModeLocale.hashCode())) * 31;
        SendInstallSputnik sendInstallSputnik = this.sendInstallSputnik;
        int iHashCode90 = (iHashCode89 + (sendInstallSputnik == null ? 0 : sendInstallSputnik.hashCode())) * 31;
        OurHomePreUpdatePopup ourHomePreUpdatePopup = this.ourHomePreUpdatePopup;
        int iHashCode91 = (iHashCode90 + (ourHomePreUpdatePopup == null ? 0 : ourHomePreUpdatePopup.hashCode())) * 31;
        OurHomeUpdatePopup ourHomeUpdatePopup = this.ourHomeUpdatePopup;
        int iHashCode92 = (iHashCode91 + (ourHomeUpdatePopup == null ? 0 : ourHomeUpdatePopup.hashCode())) * 31;
        OurHomeUpdate ourHomeUpdate = this.ourHomeUpdate;
        int iHashCode93 = (iHashCode92 + (ourHomeUpdate == null ? 0 : ourHomeUpdate.hashCode())) * 31;
        OurHomeUpdatePlate ourHomeUpdatePlate = this.ourHomeUpdatePlate;
        int iHashCode94 = (iHashCode93 + (ourHomeUpdatePlate == null ? 0 : ourHomeUpdatePlate.hashCode())) * 31;
        AuthorizationBody authorizationBody = this.authorizationCode;
        int iHashCode95 = (iHashCode94 + (authorizationBody == null ? 0 : authorizationBody.hashCode())) * 31;
        AuthorizationLimitExceededBody authorizationLimitExceededBody = this.authorizationLimitExceeded;
        int iHashCode96 = (iHashCode95 + (authorizationLimitExceededBody == null ? 0 : authorizationLimitExceededBody.hashCode())) * 31;
        PollSentPopup pollSentPopup = this.pollSentPopup;
        int iHashCode97 = (iHashCode96 + (pollSentPopup == null ? 0 : pollSentPopup.hashCode())) * 31;
        PaymentBottomSheet paymentBottomSheet = this.paymentBottomSheet;
        int iHashCode98 = (iHashCode97 + (paymentBottomSheet == null ? 0 : paymentBottomSheet.hashCode())) * 31;
        AuthorizationNeedHelpBodyLocale authorizationNeedHelpBodyLocale = this.authNeedHelp;
        int iHashCode99 = (iHashCode98 + (authorizationNeedHelpBodyLocale == null ? 0 : authorizationNeedHelpBodyLocale.hashCode())) * 31;
        NotificationsBody notificationsBody = this.notifications;
        int iHashCode100 = (iHashCode99 + (notificationsBody == null ? 0 : notificationsBody.hashCode())) * 31;
        FaqLocale faqLocale = this.faq;
        int iHashCode101 = (iHashCode100 + (faqLocale == null ? 0 : faqLocale.hashCode())) * 31;
        VpnBodyLocale vpnBodyLocale = this.vpnView;
        int iHashCode102 = (iHashCode101 + (vpnBodyLocale == null ? 0 : vpnBodyLocale.hashCode())) * 31;
        InvitesBodyLocale invitesBodyLocale = this.invites;
        int iHashCode103 = (iHashCode102 + (invitesBodyLocale == null ? 0 : invitesBodyLocale.hashCode())) * 31;
        PhysicalKeysLocale physicalKeysLocale = this.physicalKeys;
        int iHashCode104 = (iHashCode103 + (physicalKeysLocale == null ? 0 : physicalKeysLocale.hashCode())) * 31;
        CompanyContactsLocale companyContactsLocale = this.contacts;
        int iHashCode105 = (iHashCode104 + (companyContactsLocale == null ? 0 : companyContactsLocale.hashCode())) * 31;
        DeletePaymentMethodLocale deletePaymentMethodLocale = this.deletePaymentMethod;
        int iHashCode106 = (iHashCode105 + (deletePaymentMethodLocale == null ? 0 : deletePaymentMethodLocale.hashCode())) * 31;
        FamilyInvitesLocale familyInvitesLocale = this.familyInvites;
        int iHashCode107 = (iHashCode106 + (familyInvitesLocale == null ? 0 : familyInvitesLocale.hashCode())) * 31;
        BleLocale bleLocale = this.ble;
        int iHashCode108 = (iHashCode107 + (bleLocale == null ? 0 : bleLocale.hashCode())) * 31;
        PermissionsLocale permissionsLocale = this.permissions;
        return iHashCode108 + (permissionsLocale != null ? permissionsLocale.hashCode() : 0);
    }

    public String toString() {
        return "LocalizationLocalModel(tag=" + this.tag + ", language=" + this.language + ", platform=" + this.platform + ", splash=" + this.splash + ", chooseLanguage=" + this.chooseLanguage + ", countryPicker=" + this.countryPicker + ", onBoardingLanguageLoader=" + this.onBoardingLanguageLoader + ", startLanguageLocale=" + this.startLanguageLocale + ", startRegistration=" + this.startRegistration + ", accounts=" + this.accounts + ", phoneLogin=" + this.phoneLogin + ", enterCode=" + this.enterCode + ", aboutCode=" + this.aboutCode + ", registerPopup=" + this.registerPopup + ", domofon=" + this.domofon + ", confirmAddress=" + this.confirmAddress + ", register=" + this.register + ", cameraList=" + this.cameraList + ", visits=" + this.visits + ", visitsArchiveInfoPopup=" + this.visitsArchiveInfoPopup + ", visitsNoArchiveDataPopup=" + this.visitsNoArchiveDataPopup + ", feedbackMain=" + this.feedbackMain + ", feedbackComment=" + this.feedbackComment + ", feedbackDone=" + this.feedbackDone + ", settings=" + this.settings + ", profileSettings=" + this.profileSettings + ", domofonSettings=" + this.domofonSettings + ", familyList=" + this.familyList + ", familyMember=" + this.familyMember + ", addAddress=" + this.addAddress + ", manageCameras=" + this.manageCameras + ", cameraGallery=" + this.cameraGallery + ", cameraSettings=" + this.cameraSettings + ", languageList=" + this.languageList + ", changeLanguagePopup=" + this.changeLanguagePopup + ", languageLoader=" + this.languageLoader + ", market=" + this.market + ", paymentWaiting=" + this.paymentWaiting + ", subscriptionBuy=" + this.subscriptionBuy + ", faceRecognitionStart=" + this.faceRecognitionStart + ", faceRecognitionMain=" + this.faceRecognitionMain + ", faceRecognitionSettings=" + this.faceRecognitionSettings + ", faceRecognitionUpload=" + this.faceRecognitionUpload + ", faceRecognitionError=" + this.faceRecognitionError + ", archiveMain=" + this.archiveMain + ", archivePopUp=" + this.archivePopUp + ", flussonicCameraPicker=" + this.flussonicCameraPicker + ", digitalKeysMain=" + this.digitalKeysMain + ", help=" + this.help + ", about=" + this.about + ", aboutCompany=" + this.aboutCompany + ", internetError=" + this.internetError + ", block=" + this.block + ", blockMain=" + this.blockMain + ", call=" + this.call + ", archiveDownloader=" + this.archiveDownloader + ", visitor=" + this.visitor + ", servicePopup=" + this.servicePopup + ", alert=" + this.alert + ", addNewCard=" + this.addNewCard + ", card=" + this.card + ", common=" + this.common + ", intercom=" + this.intercom + ", callNotification=" + this.callNotification + ", widgets=" + this.widgets + ", emergencyCodeLocale=" + this.emergencyCodeLocale + ", notification=" + this.notification + ", bottomSheetStandardPromo=" + this.bottomSheetStandardPromo + ", servicePaymentLocale=" + this.servicePaymentLocale + ", servicePaymentDetail=" + this.servicePaymentDetail + ", servicePaymentSuccess=" + this.servicePaymentSuccess + ", servicePaymentAboutPopup=" + this.servicePaymentAboutPopup + ", servicePaymentCancelPopup=" + this.servicePaymentCancelPopup + ", servicePaymentPay=" + this.servicePaymentPay + ", noContractPopup=" + this.noContractPopup + ", viewPaymentInProgress=" + this.viewPaymentInProgress + ", promiseSuccessPopup=" + this.promiseSuccessPopup + ", promisePopup=" + this.promisePopup + ", debtPopup=" + this.debtPopup + ", arguePopup=" + this.arguePopup + ", aboutCompanyPopup=" + this.aboutCompanyPopup + ", subscriptionTariffPopup=" + this.subscriptionTariffPopup + ", subscriptionChangedTariffPopup=" + this.subscriptionChangedTariffPopup + ", subscriptionSettings=" + this.subscriptionSettings + ", unsubscriptionPopup=" + this.unsubscriptionPopup + ", stopSubscriptionPopup=" + this.stopSubscriptionPopup + ", subscriptionPopUp=" + this.subscriptionPopUp + ", subscriptionCancel=" + this.subscriptionCancel + ", subscriptionStopBody=" + this.subscriptionStopBody + ", demo=" + this.demo + ", sendInstallSputnik=" + this.sendInstallSputnik + ", ourHomePreUpdatePopup=" + this.ourHomePreUpdatePopup + ", ourHomeUpdatePopup=" + this.ourHomeUpdatePopup + ", ourHomeUpdate=" + this.ourHomeUpdate + ", ourHomeUpdatePlate=" + this.ourHomeUpdatePlate + ", authorizationCode=" + this.authorizationCode + ", authorizationLimitExceeded=" + this.authorizationLimitExceeded + ", pollSentPopup=" + this.pollSentPopup + ", paymentBottomSheet=" + this.paymentBottomSheet + ", authNeedHelp=" + this.authNeedHelp + ", notifications=" + this.notifications + ", faq=" + this.faq + ", vpnView=" + this.vpnView + ", invites=" + this.invites + ", physicalKeys=" + this.physicalKeys + ", contacts=" + this.contacts + ", deletePaymentMethod=" + this.deletePaymentMethod + ", familyInvites=" + this.familyInvites + ", ble=" + this.ble + ", permissions=" + this.permissions + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.tag);
        parcel.writeString(this.language);
        parcel.writeString(this.platform);
        SplashLocale splashLocale = this.splash;
        if (splashLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            splashLocale.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.chooseLanguage, flags);
        CountryPickerLocale countryPickerLocale = this.countryPicker;
        if (countryPickerLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            countryPickerLocale.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.onBoardingLanguageLoader, flags);
        parcel.writeParcelable(this.startLanguageLocale, flags);
        parcel.writeParcelable(this.startRegistration, flags);
        parcel.writeParcelable(this.accounts, flags);
        parcel.writeParcelable(this.phoneLogin, flags);
        parcel.writeParcelable(this.enterCode, flags);
        parcel.writeParcelable(this.aboutCode, flags);
        parcel.writeParcelable(this.registerPopup, flags);
        parcel.writeParcelable(this.domofon, flags);
        parcel.writeParcelable(this.confirmAddress, flags);
        parcel.writeParcelable(this.register, flags);
        CamerasLocale camerasLocale = this.cameraList;
        if (camerasLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            camerasLocale.writeToParcel(parcel, flags);
        }
        VisitsLocale visitsLocale = this.visits;
        if (visitsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsLocale.writeToParcel(parcel, flags);
        }
        VisitsArchiveInfoPopup visitsArchiveInfoPopup = this.visitsArchiveInfoPopup;
        if (visitsArchiveInfoPopup == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsArchiveInfoPopup.writeToParcel(parcel, flags);
        }
        VisitsArchiveInfoPopup visitsArchiveInfoPopup2 = this.visitsNoArchiveDataPopup;
        if (visitsArchiveInfoPopup2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsArchiveInfoPopup2.writeToParcel(parcel, flags);
        }
        FeedBackLocale feedBackLocale = this.feedbackMain;
        if (feedBackLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            feedBackLocale.writeToParcel(parcel, flags);
        }
        FeedbackCommentLocale feedbackCommentLocale = this.feedbackComment;
        if (feedbackCommentLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            feedbackCommentLocale.writeToParcel(parcel, flags);
        }
        FeedbackDoneLocale feedbackDoneLocale = this.feedbackDone;
        if (feedbackDoneLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            feedbackDoneLocale.writeToParcel(parcel, flags);
        }
        SettingsLocale settingsLocale = this.settings;
        if (settingsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            settingsLocale.writeToParcel(parcel, flags);
        }
        ProfileSettingsLocale profileSettingsLocale = this.profileSettings;
        if (profileSettingsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profileSettingsLocale.writeToParcel(parcel, flags);
        }
        DomofonSettingsLocale domofonSettingsLocale = this.domofonSettings;
        if (domofonSettingsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            domofonSettingsLocale.writeToParcel(parcel, flags);
        }
        FamilyListLocale familyListLocale = this.familyList;
        if (familyListLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            familyListLocale.writeToParcel(parcel, flags);
        }
        FamilyMemberLocale familyMemberLocale = this.familyMember;
        if (familyMemberLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            familyMemberLocale.writeToParcel(parcel, flags);
        }
        AddAddressLocale addAddressLocale = this.addAddress;
        if (addAddressLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            addAddressLocale.writeToParcel(parcel, flags);
        }
        ManageCamerasLocale manageCamerasLocale = this.manageCameras;
        if (manageCamerasLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            manageCamerasLocale.writeToParcel(parcel, flags);
        }
        CameraGalleryLocale cameraGalleryLocale = this.cameraGallery;
        if (cameraGalleryLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            cameraGalleryLocale.writeToParcel(parcel, flags);
        }
        CamerasSettingsLocale camerasSettingsLocale = this.cameraSettings;
        if (camerasSettingsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            camerasSettingsLocale.writeToParcel(parcel, flags);
        }
        LanguageListLocale languageListLocale = this.languageList;
        if (languageListLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            languageListLocale.writeToParcel(parcel, flags);
        }
        ChangeLanguagePopUpLocale changeLanguagePopUpLocale = this.changeLanguagePopup;
        if (changeLanguagePopUpLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            changeLanguagePopUpLocale.writeToParcel(parcel, flags);
        }
        LanguageLoaderLocale languageLoaderLocale = this.languageLoader;
        if (languageLoaderLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            languageLoaderLocale.writeToParcel(parcel, flags);
        }
        MarketLocale marketLocale = this.market;
        if (marketLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            marketLocale.writeToParcel(parcel, flags);
        }
        PaymentWaitingLocale paymentWaitingLocale = this.paymentWaiting;
        if (paymentWaitingLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            paymentWaitingLocale.writeToParcel(parcel, flags);
        }
        SubscriptionBuyLocale subscriptionBuyLocale = this.subscriptionBuy;
        if (subscriptionBuyLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            subscriptionBuyLocale.writeToParcel(parcel, flags);
        }
        FaceRecognitionStartLocale faceRecognitionStartLocale = this.faceRecognitionStart;
        if (faceRecognitionStartLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionStartLocale.writeToParcel(parcel, flags);
        }
        FaceRecognitionMainLocale faceRecognitionMainLocale = this.faceRecognitionMain;
        if (faceRecognitionMainLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionMainLocale.writeToParcel(parcel, flags);
        }
        FaceRecognitionSettingsLocale faceRecognitionSettingsLocale = this.faceRecognitionSettings;
        if (faceRecognitionSettingsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionSettingsLocale.writeToParcel(parcel, flags);
        }
        FaceRecognitionUploadLocale faceRecognitionUploadLocale = this.faceRecognitionUpload;
        if (faceRecognitionUploadLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionUploadLocale.writeToParcel(parcel, flags);
        }
        FaceRecognitionErrorLocale faceRecognitionErrorLocale = this.faceRecognitionError;
        if (faceRecognitionErrorLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            faceRecognitionErrorLocale.writeToParcel(parcel, flags);
        }
        ArchiveMainLocale archiveMainLocale = this.archiveMain;
        if (archiveMainLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            archiveMainLocale.writeToParcel(parcel, flags);
        }
        ArchivePopUpLocale archivePopUpLocale = this.archivePopUp;
        if (archivePopUpLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            archivePopUpLocale.writeToParcel(parcel, flags);
        }
        FlussonicCameraPicker flussonicCameraPicker = this.flussonicCameraPicker;
        if (flussonicCameraPicker == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            flussonicCameraPicker.writeToParcel(parcel, flags);
        }
        DigitalKeysMainLocale digitalKeysMainLocale = this.digitalKeysMain;
        if (digitalKeysMainLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            digitalKeysMainLocale.writeToParcel(parcel, flags);
        }
        HelpLocale helpLocale = this.help;
        if (helpLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            helpLocale.writeToParcel(parcel, flags);
        }
        AboutLocale aboutLocale = this.about;
        if (aboutLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            aboutLocale.writeToParcel(parcel, flags);
        }
        AboutCompanyLocale aboutCompanyLocale = this.aboutCompany;
        if (aboutCompanyLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            aboutCompanyLocale.writeToParcel(parcel, flags);
        }
        InternetErrorLocale internetErrorLocale = this.internetError;
        if (internetErrorLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            internetErrorLocale.writeToParcel(parcel, flags);
        }
        BlockLocale blockLocale = this.block;
        if (blockLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            blockLocale.writeToParcel(parcel, flags);
        }
        BlockMain blockMain = this.blockMain;
        if (blockMain == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            blockMain.writeToParcel(parcel, flags);
        }
        CallLocale callLocale = this.call;
        if (callLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            callLocale.writeToParcel(parcel, flags);
        }
        ArchiveDownloadLocale archiveDownloadLocale = this.archiveDownloader;
        if (archiveDownloadLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            archiveDownloadLocale.writeToParcel(parcel, flags);
        }
        ImageViewerLocale imageViewerLocale = this.visitor;
        if (imageViewerLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            imageViewerLocale.writeToParcel(parcel, flags);
        }
        ServicePopupLocale servicePopupLocale = this.servicePopup;
        if (servicePopupLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            servicePopupLocale.writeToParcel(parcel, flags);
        }
        AlertLocale alertLocale = this.alert;
        if (alertLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            alertLocale.writeToParcel(parcel, flags);
        }
        AddNewCardLocale addNewCardLocale = this.addNewCard;
        if (addNewCardLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            addNewCardLocale.writeToParcel(parcel, flags);
        }
        CardLocale cardLocale = this.card;
        if (cardLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            cardLocale.writeToParcel(parcel, flags);
        }
        CommonLocale commonLocale = this.common;
        if (commonLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            commonLocale.writeToParcel(parcel, flags);
        }
        IntercomLocale intercomLocale = this.intercom;
        if (intercomLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            intercomLocale.writeToParcel(parcel, flags);
        }
        CallNotificationLocale callNotificationLocale = this.callNotification;
        if (callNotificationLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            callNotificationLocale.writeToParcel(parcel, flags);
        }
        WidgetsLocale widgetsLocale = this.widgets;
        if (widgetsLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            widgetsLocale.writeToParcel(parcel, flags);
        }
        EmergencyCodeLocale emergencyCodeLocale = this.emergencyCodeLocale;
        if (emergencyCodeLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            emergencyCodeLocale.writeToParcel(parcel, flags);
        }
        NotificationLocale notificationLocale = this.notification;
        if (notificationLocale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            notificationLocale.writeToParcel(parcel, flags);
        }
        BottomSheetStandardPromo bottomSheetStandardPromo = this.bottomSheetStandardPromo;
        if (bottomSheetStandardPromo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bottomSheetStandardPromo.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.servicePaymentLocale, flags);
        parcel.writeParcelable(this.servicePaymentDetail, flags);
        parcel.writeParcelable(this.servicePaymentSuccess, flags);
        parcel.writeParcelable(this.servicePaymentAboutPopup, flags);
        parcel.writeParcelable(this.servicePaymentCancelPopup, flags);
        parcel.writeParcelable(this.servicePaymentPay, flags);
        parcel.writeParcelable(this.noContractPopup, flags);
        parcel.writeParcelable(this.viewPaymentInProgress, flags);
        parcel.writeParcelable(this.promiseSuccessPopup, flags);
        parcel.writeParcelable(this.promisePopup, flags);
        parcel.writeParcelable(this.debtPopup, flags);
        parcel.writeParcelable(this.arguePopup, flags);
        parcel.writeParcelable(this.aboutCompanyPopup, flags);
        parcel.writeParcelable(this.subscriptionTariffPopup, flags);
        parcel.writeParcelable(this.subscriptionChangedTariffPopup, flags);
        parcel.writeParcelable(this.subscriptionSettings, flags);
        parcel.writeParcelable(this.unsubscriptionPopup, flags);
        parcel.writeParcelable(this.stopSubscriptionPopup, flags);
        parcel.writeParcelable(this.subscriptionPopUp, flags);
        parcel.writeParcelable(this.subscriptionCancel, flags);
        parcel.writeParcelable(this.subscriptionStopBody, flags);
        parcel.writeParcelable(this.demo, flags);
        parcel.writeParcelable(this.sendInstallSputnik, flags);
        parcel.writeParcelable(this.ourHomePreUpdatePopup, flags);
        parcel.writeParcelable(this.ourHomeUpdatePopup, flags);
        parcel.writeParcelable(this.ourHomeUpdate, flags);
        parcel.writeParcelable(this.ourHomeUpdatePlate, flags);
        parcel.writeParcelable(this.authorizationCode, flags);
        parcel.writeParcelable(this.authorizationLimitExceeded, flags);
        parcel.writeParcelable(this.pollSentPopup, flags);
        parcel.writeParcelable(this.paymentBottomSheet, flags);
        parcel.writeParcelable(this.authNeedHelp, flags);
        parcel.writeParcelable(this.notifications, flags);
        parcel.writeParcelable(this.faq, flags);
        parcel.writeParcelable(this.vpnView, flags);
        parcel.writeParcelable(this.invites, flags);
        parcel.writeParcelable(this.physicalKeys, flags);
        parcel.writeParcelable(this.contacts, flags);
        parcel.writeParcelable(this.deletePaymentMethod, flags);
        parcel.writeParcelable(this.familyInvites, flags);
        parcel.writeParcelable(this.ble, flags);
        parcel.writeParcelable(this.permissions, flags);
    }

    public LocalizationLocalModel(String str, String str2, String str3, SplashLocale splashLocale, ChooseLanguageLocale chooseLanguageLocale, CountryPickerLocale countryPickerLocale, OnBoardingLanguageLoaderLocale onBoardingLanguageLoaderLocale, StartLanguageLocale startLanguageLocale, StartRegistrationLocale startRegistrationLocale, AccountsLocale accountsLocale, PhoneLoginLocale phoneLoginLocale, EnterCodeLocale enterCodeLocale, AboutCodeLocale aboutCodeLocale, RegisterPopupLocale registerPopupLocale, DomofonLocale domofonLocale, ConfirmAddressLocale confirmAddress, RegisterLocale registerLocale, CamerasLocale camerasLocale, VisitsLocale visitsLocale, VisitsArchiveInfoPopup visitsArchiveInfoPopup, VisitsArchiveInfoPopup visitsArchiveInfoPopup2, FeedBackLocale feedBackLocale, FeedbackCommentLocale feedbackCommentLocale, FeedbackDoneLocale feedbackDoneLocale, SettingsLocale settingsLocale, ProfileSettingsLocale profileSettingsLocale, DomofonSettingsLocale domofonSettingsLocale, FamilyListLocale familyListLocale, FamilyMemberLocale familyMemberLocale, AddAddressLocale addAddressLocale, ManageCamerasLocale manageCamerasLocale, CameraGalleryLocale cameraGalleryLocale, CamerasSettingsLocale camerasSettingsLocale, LanguageListLocale languageListLocale, ChangeLanguagePopUpLocale changeLanguagePopUpLocale, LanguageLoaderLocale languageLoaderLocale, MarketLocale marketLocale, PaymentWaitingLocale paymentWaitingLocale, SubscriptionBuyLocale subscriptionBuyLocale, FaceRecognitionStartLocale faceRecognitionStartLocale, FaceRecognitionMainLocale faceRecognitionMainLocale, FaceRecognitionSettingsLocale faceRecognitionSettingsLocale, FaceRecognitionUploadLocale faceRecognitionUploadLocale, FaceRecognitionErrorLocale faceRecognitionErrorLocale, ArchiveMainLocale archiveMainLocale, ArchivePopUpLocale archivePopUpLocale, FlussonicCameraPicker flussonicCameraPicker, DigitalKeysMainLocale digitalKeysMainLocale, HelpLocale helpLocale, AboutLocale aboutLocale, AboutCompanyLocale aboutCompanyLocale, InternetErrorLocale internetErrorLocale, BlockLocale blockLocale, BlockMain blockMain, CallLocale callLocale, ArchiveDownloadLocale archiveDownloadLocale, ImageViewerLocale imageViewerLocale, ServicePopupLocale servicePopupLocale, AlertLocale alertLocale, AddNewCardLocale addNewCardLocale, CardLocale cardLocale, CommonLocale commonLocale, IntercomLocale intercomLocale, CallNotificationLocale callNotificationLocale, WidgetsLocale widgetsLocale, EmergencyCodeLocale emergencyCodeLocale, NotificationLocale notificationLocale, BottomSheetStandardPromo bottomSheetStandardPromo, ServicePaymentLocale servicePaymentLocale, ServicePaymentDetailLocale servicePaymentDetailLocale, ServicePaymentSuccessLocale servicePaymentSuccessLocale, ServicePaymentAboutPopupLocale servicePaymentAboutPopupLocale, ServicePaymentCancelPopupLocale servicePaymentCancelPopupLocale, ServicePaymentPayLocale servicePaymentPayLocale, NoContractPopupLocale noContractPopupLocale, TextTitle textTitle, PromiseSuccessPopupLocale promiseSuccessPopupLocale, PromisePopupLocale promisePopupLocale, DebtPopupLocale debtPopupLocale, ArguePopupLocale arguePopupLocale, AboutServiceCompanyLocale aboutServiceCompanyLocale, SubscriptionPayedPopupLocale subscriptionPayedPopupLocale, SubscriptionChangedPopupLocale subscriptionChangedPopupLocale, SettingsSubscriptionLocale settingsSubscriptionLocale, UnSubscriptionPopUpLocale unSubscriptionPopUpLocale, UnSubscriptionPopUpLocale unSubscriptionPopUpLocale2, SubscriptionPopupLocale subscriptionPopupLocale, TitleWithSubtitle titleWithSubtitle, SubscriptionStopBody subscriptionStopBody, DemoModeLocale demoModeLocale, SendInstallSputnik sendInstallSputnik, OurHomePreUpdatePopup ourHomePreUpdatePopup, OurHomeUpdatePopup ourHomeUpdatePopup, OurHomeUpdate ourHomeUpdate, OurHomeUpdatePlate ourHomeUpdatePlate, AuthorizationBody authorizationBody, AuthorizationLimitExceededBody authorizationLimitExceededBody, PollSentPopup pollSentPopup, PaymentBottomSheet paymentBottomSheet, AuthorizationNeedHelpBodyLocale authorizationNeedHelpBodyLocale, NotificationsBody notificationsBody, FaqLocale faqLocale, VpnBodyLocale vpnBodyLocale, InvitesBodyLocale invitesBodyLocale, PhysicalKeysLocale physicalKeysLocale, CompanyContactsLocale companyContactsLocale, DeletePaymentMethodLocale deletePaymentMethodLocale, FamilyInvitesLocale familyInvitesLocale, BleLocale bleLocale, PermissionsLocale permissionsLocale) {
        Intrinsics.checkNotNullParameter(confirmAddress, "confirmAddress");
        this.tag = str;
        this.language = str2;
        this.platform = str3;
        this.splash = splashLocale;
        this.chooseLanguage = chooseLanguageLocale;
        this.countryPicker = countryPickerLocale;
        this.onBoardingLanguageLoader = onBoardingLanguageLoaderLocale;
        this.startLanguageLocale = startLanguageLocale;
        this.startRegistration = startRegistrationLocale;
        this.accounts = accountsLocale;
        this.phoneLogin = phoneLoginLocale;
        this.enterCode = enterCodeLocale;
        this.aboutCode = aboutCodeLocale;
        this.registerPopup = registerPopupLocale;
        this.domofon = domofonLocale;
        this.confirmAddress = confirmAddress;
        this.register = registerLocale;
        this.cameraList = camerasLocale;
        this.visits = visitsLocale;
        this.visitsArchiveInfoPopup = visitsArchiveInfoPopup;
        this.visitsNoArchiveDataPopup = visitsArchiveInfoPopup2;
        this.feedbackMain = feedBackLocale;
        this.feedbackComment = feedbackCommentLocale;
        this.feedbackDone = feedbackDoneLocale;
        this.settings = settingsLocale;
        this.profileSettings = profileSettingsLocale;
        this.domofonSettings = domofonSettingsLocale;
        this.familyList = familyListLocale;
        this.familyMember = familyMemberLocale;
        this.addAddress = addAddressLocale;
        this.manageCameras = manageCamerasLocale;
        this.cameraGallery = cameraGalleryLocale;
        this.cameraSettings = camerasSettingsLocale;
        this.languageList = languageListLocale;
        this.changeLanguagePopup = changeLanguagePopUpLocale;
        this.languageLoader = languageLoaderLocale;
        this.market = marketLocale;
        this.paymentWaiting = paymentWaitingLocale;
        this.subscriptionBuy = subscriptionBuyLocale;
        this.faceRecognitionStart = faceRecognitionStartLocale;
        this.faceRecognitionMain = faceRecognitionMainLocale;
        this.faceRecognitionSettings = faceRecognitionSettingsLocale;
        this.faceRecognitionUpload = faceRecognitionUploadLocale;
        this.faceRecognitionError = faceRecognitionErrorLocale;
        this.archiveMain = archiveMainLocale;
        this.archivePopUp = archivePopUpLocale;
        this.flussonicCameraPicker = flussonicCameraPicker;
        this.digitalKeysMain = digitalKeysMainLocale;
        this.help = helpLocale;
        this.about = aboutLocale;
        this.aboutCompany = aboutCompanyLocale;
        this.internetError = internetErrorLocale;
        this.block = blockLocale;
        this.blockMain = blockMain;
        this.call = callLocale;
        this.archiveDownloader = archiveDownloadLocale;
        this.visitor = imageViewerLocale;
        this.servicePopup = servicePopupLocale;
        this.alert = alertLocale;
        this.addNewCard = addNewCardLocale;
        this.card = cardLocale;
        this.common = commonLocale;
        this.intercom = intercomLocale;
        this.callNotification = callNotificationLocale;
        this.widgets = widgetsLocale;
        this.emergencyCodeLocale = emergencyCodeLocale;
        this.notification = notificationLocale;
        this.bottomSheetStandardPromo = bottomSheetStandardPromo;
        this.servicePaymentLocale = servicePaymentLocale;
        this.servicePaymentDetail = servicePaymentDetailLocale;
        this.servicePaymentSuccess = servicePaymentSuccessLocale;
        this.servicePaymentAboutPopup = servicePaymentAboutPopupLocale;
        this.servicePaymentCancelPopup = servicePaymentCancelPopupLocale;
        this.servicePaymentPay = servicePaymentPayLocale;
        this.noContractPopup = noContractPopupLocale;
        this.viewPaymentInProgress = textTitle;
        this.promiseSuccessPopup = promiseSuccessPopupLocale;
        this.promisePopup = promisePopupLocale;
        this.debtPopup = debtPopupLocale;
        this.arguePopup = arguePopupLocale;
        this.aboutCompanyPopup = aboutServiceCompanyLocale;
        this.subscriptionTariffPopup = subscriptionPayedPopupLocale;
        this.subscriptionChangedTariffPopup = subscriptionChangedPopupLocale;
        this.subscriptionSettings = settingsSubscriptionLocale;
        this.unsubscriptionPopup = unSubscriptionPopUpLocale;
        this.stopSubscriptionPopup = unSubscriptionPopUpLocale2;
        this.subscriptionPopUp = subscriptionPopupLocale;
        this.subscriptionCancel = titleWithSubtitle;
        this.subscriptionStopBody = subscriptionStopBody;
        this.demo = demoModeLocale;
        this.sendInstallSputnik = sendInstallSputnik;
        this.ourHomePreUpdatePopup = ourHomePreUpdatePopup;
        this.ourHomeUpdatePopup = ourHomeUpdatePopup;
        this.ourHomeUpdate = ourHomeUpdate;
        this.ourHomeUpdatePlate = ourHomeUpdatePlate;
        this.authorizationCode = authorizationBody;
        this.authorizationLimitExceeded = authorizationLimitExceededBody;
        this.pollSentPopup = pollSentPopup;
        this.paymentBottomSheet = paymentBottomSheet;
        this.authNeedHelp = authorizationNeedHelpBodyLocale;
        this.notifications = notificationsBody;
        this.faq = faqLocale;
        this.vpnView = vpnBodyLocale;
        this.invites = invitesBodyLocale;
        this.physicalKeys = physicalKeysLocale;
        this.contacts = companyContactsLocale;
        this.deletePaymentMethod = deletePaymentMethodLocale;
        this.familyInvites = familyInvitesLocale;
        this.ble = bleLocale;
        this.permissions = permissionsLocale;
    }

    public final String getTag() {
        return this.tag;
    }

    public final SplashLocale getSplash() {
        return this.splash;
    }

    public final ChooseLanguageLocale getChooseLanguage() {
        return this.chooseLanguage;
    }

    public final CountryPickerLocale getCountryPicker() {
        return this.countryPicker;
    }

    public final OnBoardingLanguageLoaderLocale getOnBoardingLanguageLoader() {
        return this.onBoardingLanguageLoader;
    }

    public final StartLanguageLocale getStartLanguageLocale() {
        return this.startLanguageLocale;
    }

    public final StartRegistrationLocale getStartRegistration() {
        return this.startRegistration;
    }

    public final AccountsLocale getAccounts() {
        return this.accounts;
    }

    public final PhoneLoginLocale getPhoneLogin() {
        return this.phoneLogin;
    }

    public final EnterCodeLocale getEnterCode() {
        return this.enterCode;
    }

    public final AboutCodeLocale getAboutCode() {
        return this.aboutCode;
    }

    public final RegisterPopupLocale getRegisterPopup() {
        return this.registerPopup;
    }

    public final DomofonLocale getDomofon() {
        return this.domofon;
    }

    public final ConfirmAddressLocale getConfirmAddress() {
        return this.confirmAddress;
    }

    public final RegisterLocale getRegister() {
        return this.register;
    }

    public final CamerasLocale getCameraList() {
        return this.cameraList;
    }

    public final VisitsLocale getVisits() {
        return this.visits;
    }

    public final VisitsArchiveInfoPopup getVisitsArchiveInfoPopup() {
        return this.visitsArchiveInfoPopup;
    }

    public final VisitsArchiveInfoPopup getVisitsNoArchiveDataPopup() {
        return this.visitsNoArchiveDataPopup;
    }

    public final FeedBackLocale getFeedbackMain() {
        return this.feedbackMain;
    }

    public final FeedbackCommentLocale getFeedbackComment() {
        return this.feedbackComment;
    }

    public final FeedbackDoneLocale getFeedbackDone() {
        return this.feedbackDone;
    }

    public final SettingsLocale getSettings() {
        return this.settings;
    }

    public final ProfileSettingsLocale getProfileSettings() {
        return this.profileSettings;
    }

    public final DomofonSettingsLocale getDomofonSettings() {
        return this.domofonSettings;
    }

    public final FamilyListLocale getFamilyList() {
        return this.familyList;
    }

    public final FamilyMemberLocale getFamilyMember() {
        return this.familyMember;
    }

    public final AddAddressLocale getAddAddress() {
        return this.addAddress;
    }

    public final ManageCamerasLocale getManageCameras() {
        return this.manageCameras;
    }

    public final CameraGalleryLocale getCameraGallery() {
        return this.cameraGallery;
    }

    public final CamerasSettingsLocale getCameraSettings() {
        return this.cameraSettings;
    }

    public final LanguageListLocale getLanguageList() {
        return this.languageList;
    }

    public final ChangeLanguagePopUpLocale getChangeLanguagePopup() {
        return this.changeLanguagePopup;
    }

    public final LanguageLoaderLocale getLanguageLoader() {
        return this.languageLoader;
    }

    public final MarketLocale getMarket() {
        return this.market;
    }

    public final PaymentWaitingLocale getPaymentWaiting() {
        return this.paymentWaiting;
    }

    public final SubscriptionBuyLocale getSubscriptionBuy() {
        return this.subscriptionBuy;
    }

    public final FaceRecognitionStartLocale getFaceRecognitionStart() {
        return this.faceRecognitionStart;
    }

    public final FaceRecognitionMainLocale getFaceRecognitionMain() {
        return this.faceRecognitionMain;
    }

    public final FaceRecognitionSettingsLocale getFaceRecognitionSettings() {
        return this.faceRecognitionSettings;
    }

    public final FaceRecognitionUploadLocale getFaceRecognitionUpload() {
        return this.faceRecognitionUpload;
    }

    public final FaceRecognitionErrorLocale getFaceRecognitionError() {
        return this.faceRecognitionError;
    }

    public final ArchiveMainLocale getArchiveMain() {
        return this.archiveMain;
    }

    public final ArchivePopUpLocale getArchivePopUp() {
        return this.archivePopUp;
    }

    public final FlussonicCameraPicker getFlussonicCameraPicker() {
        return this.flussonicCameraPicker;
    }

    public final DigitalKeysMainLocale getDigitalKeysMain() {
        return this.digitalKeysMain;
    }

    public final HelpLocale getHelp() {
        return this.help;
    }

    public final AboutLocale getAbout() {
        return this.about;
    }

    public final AboutCompanyLocale getAboutCompany() {
        return this.aboutCompany;
    }

    public final InternetErrorLocale getInternetError() {
        return this.internetError;
    }

    public final BlockLocale getBlock() {
        return this.block;
    }

    public final BlockMain getBlockMain() {
        return this.blockMain;
    }

    public final CallLocale getCall() {
        return this.call;
    }

    public final ArchiveDownloadLocale getArchiveDownloader() {
        return this.archiveDownloader;
    }

    public final ImageViewerLocale getVisitor() {
        return this.visitor;
    }

    public final ServicePopupLocale getServicePopup() {
        return this.servicePopup;
    }

    public final AlertLocale getAlert() {
        return this.alert;
    }

    public final AddNewCardLocale getAddNewCard() {
        return this.addNewCard;
    }

    public final CardLocale getCard() {
        return this.card;
    }

    public final CommonLocale getCommon() {
        return this.common;
    }

    public final IntercomLocale getIntercom() {
        return this.intercom;
    }

    public final CallNotificationLocale getCallNotification() {
        return this.callNotification;
    }

    public final WidgetsLocale getWidgets() {
        return this.widgets;
    }

    public final EmergencyCodeLocale getEmergencyCodeLocale() {
        return this.emergencyCodeLocale;
    }

    public final NotificationLocale getNotification() {
        return this.notification;
    }

    public final BottomSheetStandardPromo getBottomSheetStandardPromo() {
        return this.bottomSheetStandardPromo;
    }

    public final ServicePaymentLocale getServicePaymentLocale() {
        return this.servicePaymentLocale;
    }

    public final ServicePaymentDetailLocale getServicePaymentDetail() {
        return this.servicePaymentDetail;
    }

    public final ServicePaymentSuccessLocale getServicePaymentSuccess() {
        return this.servicePaymentSuccess;
    }

    public final ServicePaymentAboutPopupLocale getServicePaymentAboutPopup() {
        return this.servicePaymentAboutPopup;
    }

    public final ServicePaymentCancelPopupLocale getServicePaymentCancelPopup() {
        return this.servicePaymentCancelPopup;
    }

    public final ServicePaymentPayLocale getServicePaymentPay() {
        return this.servicePaymentPay;
    }

    public final TextTitle getViewPaymentInProgress() {
        return this.viewPaymentInProgress;
    }

    public final PromiseSuccessPopupLocale getPromiseSuccessPopup() {
        return this.promiseSuccessPopup;
    }

    public final PromisePopupLocale getPromisePopup() {
        return this.promisePopup;
    }

    public final DebtPopupLocale getDebtPopup() {
        return this.debtPopup;
    }

    public final ArguePopupLocale getArguePopup() {
        return this.arguePopup;
    }

    public final AboutServiceCompanyLocale getAboutCompanyPopup() {
        return this.aboutCompanyPopup;
    }

    public final SubscriptionPayedPopupLocale getSubscriptionTariffPopup() {
        return this.subscriptionTariffPopup;
    }

    public final SubscriptionChangedPopupLocale getSubscriptionChangedTariffPopup() {
        return this.subscriptionChangedTariffPopup;
    }

    public final SettingsSubscriptionLocale getSubscriptionSettings() {
        return this.subscriptionSettings;
    }

    public final UnSubscriptionPopUpLocale getUnsubscriptionPopup() {
        return this.unsubscriptionPopup;
    }

    public final UnSubscriptionPopUpLocale getStopSubscriptionPopup() {
        return this.stopSubscriptionPopup;
    }

    public final SubscriptionPopupLocale getSubscriptionPopUp() {
        return this.subscriptionPopUp;
    }

    public final TitleWithSubtitle getSubscriptionCancel() {
        return this.subscriptionCancel;
    }

    public final SubscriptionStopBody getSubscriptionStopBody() {
        return this.subscriptionStopBody;
    }

    public final DemoModeLocale getDemo() {
        return this.demo;
    }

    public final SendInstallSputnik getSendInstallSputnik() {
        return this.sendInstallSputnik;
    }

    public final OurHomeUpdatePopup getOurHomeUpdatePopup() {
        return this.ourHomeUpdatePopup;
    }

    public final OurHomeUpdate getOurHomeUpdate() {
        return this.ourHomeUpdate;
    }

    public final OurHomeUpdatePlate getOurHomeUpdatePlate() {
        return this.ourHomeUpdatePlate;
    }

    public final AuthorizationBody getAuthorizationCode() {
        return this.authorizationCode;
    }

    public final AuthorizationLimitExceededBody getAuthorizationLimitExceeded() {
        return this.authorizationLimitExceeded;
    }

    public final PollSentPopup getPollSentPopup() {
        return this.pollSentPopup;
    }

    public final PaymentBottomSheet getPaymentBottomSheet() {
        return this.paymentBottomSheet;
    }

    public final AuthorizationNeedHelpBodyLocale getAuthNeedHelp() {
        return this.authNeedHelp;
    }

    public final NotificationsBody getNotifications() {
        return this.notifications;
    }

    public final FaqLocale getFaq() {
        return this.faq;
    }

    public final VpnBodyLocale getVpnView() {
        return this.vpnView;
    }

    public final InvitesBodyLocale getInvites() {
        return this.invites;
    }

    public final PhysicalKeysLocale getPhysicalKeys() {
        return this.physicalKeys;
    }

    public final CompanyContactsLocale getContacts() {
        return this.contacts;
    }

    public final DeletePaymentMethodLocale getDeletePaymentMethod() {
        return this.deletePaymentMethod;
    }

    public final FamilyInvitesLocale getFamilyInvites() {
        return this.familyInvites;
    }

    public final BleLocale getBle() {
        return this.ble;
    }

    public final PermissionsLocale getPermissions() {
        return this.permissions;
    }
}
