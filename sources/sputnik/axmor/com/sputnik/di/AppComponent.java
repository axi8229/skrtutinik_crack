package sputnik.axmor.com.sputnik.di;

import android.app.Application;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.di.CommonDeps;
import com.sputnik.oboarding.di.OnBoardingDeps;
import com.sputnik.service_payments.di.ServicePaymentDeps;
import com.sputnik.subscriptions.di.SubscriptionsDeps;
import kotlin.Metadata;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew;
import sputnik.axmor.com.sputnik.core.push.PushIntentService;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService;
import sputnik.axmor.com.sputnik.services.ble_service.RebootBroadcastReceiver;
import sputnik.axmor.com.sputnik.services.call_service.CallNotificationService;
import sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService;
import sputnik.axmor.com.sputnik.services.notification_service.PushProcessorImpl;
import sputnik.axmor.com.sputnik.ui.alerts.BottomSheetUpdateRequired;
import sputnik.axmor.com.sputnik.ui.alerts.FragmentUpdateRequired;
import sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView;
import sputnik.axmor.com.sputnik.ui.beta.BottomSheetAboutBetaProgram;
import sputnik.axmor.com.sputnik.ui.block.BlockedFragment;
import sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment;
import sputnik.axmor.com.sputnik.ui.call.CallActivity;
import sputnik.axmor.com.sputnik.ui.call.ReceivingCallFragment;
import sputnik.axmor.com.sputnik.ui.dialogs.InfoDialog;
import sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet;
import sputnik.axmor.com.sputnik.ui.experimental.ExperimentalFunctionsFragment;
import sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment;
import sputnik.axmor.com.sputnik.ui.faq.FaqFragment;
import sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment;
import sputnik.axmor.com.sputnik.ui.gorserv.BottomSheetGorservRequestSent;
import sputnik.axmor.com.sputnik.ui.gorserv.ChangeGorservUserPhoneDialog;
import sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog;
import sputnik.axmor.com.sputnik.ui.gorserv.SelectGorservCategoryFragment;
import sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment;
import sputnik.axmor.com.sputnik.ui.install_sputnik.SendInstallSputnikRequestFragment;
import sputnik.axmor.com.sputnik.ui.main.MainHostFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.NoCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.BottomSheetAboutCallHistory;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.BottomSheetNoArchive;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryDetails;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.rate_us.RateUsDialog;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFinishFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment;
import sputnik.axmor.com.sputnik.ui.main.help.AboutAppFragment;
import sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment;
import sputnik.axmor.com.sputnik.ui.main.help.HelpFragment;
import sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment;
import sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.ServicesInfoFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.ArchiveServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.FlussonicActivity;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.dialogs.ErrorArchiveDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.BleServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.BottomSheetSetupRssi;
import sputnik.axmor.com.sputnik.ui.main.market.services.ble.NoPermissionsDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.DigitalKeysServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.DeleteCodeDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.UpdatePermCodeDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog.UpdateTempCodeDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrErrorFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrServiceFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrStartScanFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrSuccessFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.ShotFragment;
import sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.dialogs.FrRemoveDialog;
import sputnik.axmor.com.sputnik.ui.main.market.services.partner_dialog.PartnerServiceDialog;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.CancelSubscriptionBottomSheet;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.SubscriptionFragment;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.success_dialog.SuccessSubscriptionDialog;
import sputnik.axmor.com.sputnik.ui.main.permissions.BackgroundWorkFragment;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions;
import sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining;
import sputnik.axmor.com.sputnik.ui.main.permissions.InstructionFragment;
import sputnik.axmor.com.sputnik.ui.main.permissions.PermissionsFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.card.DeletePaymentMethodDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.family.BottomSheetInviteToFamily;
import sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyInfoFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.family.FamilyListFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.family.LeaveFromFamilyDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.family.ResendFamilyInviteDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.family.SendFamilyInviteErrorDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetKeyAddError;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.BottomSheetNeedSubscriptionToAddKey;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.DeleteKeyDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyManageFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeyRegisterFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.keys.KeysFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationListFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ClearCameraPreferencesDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.mobile_pack.MobilePackFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSelectAddress;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.BottomSheetSubscriptionNeededForCalls;
import sputnik.axmor.com.sputnik.ui.main.profile.multi_address.DeleteAddressDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog;
import sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.LogOutDialog;
import sputnik.axmor.com.sputnik.ui.multi_address.BottomSheetMultiAddressAnnounce;
import sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom;
import sputnik.axmor.com.sputnik.ui.nointercom.ProfileNoIntercom;
import sputnik.axmor.com.sputnik.ui.nointercom.SettingsAddress;
import sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog;
import sputnik.axmor.com.sputnik.ui.our_home.OurHomeUpdateFragment;
import sputnik.axmor.com.sputnik.ui.polls.BottomSheetPollSuccess;
import sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoriesFragment;
import sputnik.axmor.com.sputnik.ui.popups.PopupStoryFragment;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;
import sputnik.axmor.com.sputnik.ui.settings.BleSettingsActivity;
import sputnik.axmor.com.sputnik.ui.settings.SettingsActivity;
import sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity;
import sputnik.axmor.com.sputnik.ui.splash.CustomEmptySplashActivity;
import sputnik.axmor.com.sputnik.ui.splash.CustomSplashFragment;
import sputnik.axmor.com.sputnik.ui.subscriptions.BottomSheetAboutSubscription;
import sputnik.axmor.com.sputnik.ui.subscriptions.SubscriptionDetailsFragment;
import sputnik.axmor.com.sputnik.ui.vpn.AboutVpnDialog;
import sputnik.axmor.com.sputnik.ui.yandex.BottomSheetNeedSubscriptionToAddDeviceForYandexAlice;
import sputnik.axmor.com.sputnik.ui.yandex.YandexHomeFragment;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: AppComponent.kt */
@Metadata(d1 = {"\u0000Ê\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u009a\u0002J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\b\u0010\u000eJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000fH&¢\u0006\u0004\b\b\u0010\u0010J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\b\u0010\u0013J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0014H&¢\u0006\u0004\b\b\u0010\u0015J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\b\u0010\u0018J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0019H&¢\u0006\u0004\b\b\u0010\u001aJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001bH&¢\u0006\u0004\b\b\u0010\u001cJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001dH&¢\u0006\u0004\b\b\u0010\u001eJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001fH&¢\u0006\u0004\b\b\u0010 J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020!H&¢\u0006\u0004\b\b\u0010\"J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020#H&¢\u0006\u0004\b\b\u0010$J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020%H&¢\u0006\u0004\b\b\u0010&J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020'H&¢\u0006\u0004\b\b\u0010(J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020)H&¢\u0006\u0004\b\b\u0010*J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020+H&¢\u0006\u0004\b\b\u0010,J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020-H&¢\u0006\u0004\b\b\u0010.J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020/H&¢\u0006\u0004\b\b\u00100J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u000201H&¢\u0006\u0004\b\b\u00102J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u000203H&¢\u0006\u0004\b\b\u00104J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u000205H&¢\u0006\u0004\b\b\u00106J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u000207H&¢\u0006\u0004\b\b\u00108J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u000209H&¢\u0006\u0004\b\b\u0010:J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020;H&¢\u0006\u0004\b\b\u0010<J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020=H&¢\u0006\u0004\b\b\u0010>J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020?H&¢\u0006\u0004\b\b\u0010@J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020AH&¢\u0006\u0004\b\b\u0010BJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020CH&¢\u0006\u0004\b\b\u0010DJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020EH&¢\u0006\u0004\b\b\u0010FJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020GH&¢\u0006\u0004\b\b\u0010HJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020IH&¢\u0006\u0004\b\b\u0010JJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020KH&¢\u0006\u0004\b\b\u0010LJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020MH&¢\u0006\u0004\b\b\u0010NJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020OH&¢\u0006\u0004\b\b\u0010PJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020QH&¢\u0006\u0004\b\b\u0010RJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020SH&¢\u0006\u0004\b\b\u0010TJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020UH&¢\u0006\u0004\b\b\u0010VJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020WH&¢\u0006\u0004\b\b\u0010XJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020YH&¢\u0006\u0004\b\b\u0010ZJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020[H&¢\u0006\u0004\b\b\u0010\\J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020]H&¢\u0006\u0004\b\b\u0010^J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020_H&¢\u0006\u0004\b\b\u0010`J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020aH&¢\u0006\u0004\b\b\u0010bJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020cH&¢\u0006\u0004\b\b\u0010dJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020eH&¢\u0006\u0004\b\b\u0010fJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020gH&¢\u0006\u0004\b\b\u0010hJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020iH&¢\u0006\u0004\b\b\u0010jJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020kH&¢\u0006\u0004\b\b\u0010lJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020mH&¢\u0006\u0004\b\b\u0010nJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020oH&¢\u0006\u0004\b\b\u0010pJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010r\u001a\u00020qH&¢\u0006\u0004\b\b\u0010sJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010u\u001a\u00020tH&¢\u0006\u0004\b\b\u0010vJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010u\u001a\u00020wH&¢\u0006\u0004\b\b\u0010xJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010u\u001a\u00020yH&¢\u0006\u0004\b\b\u0010zJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010u\u001a\u00020{H&¢\u0006\u0004\b\b\u0010|J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010u\u001a\u00020}H&¢\u0006\u0004\b\b\u0010~J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u007fH&¢\u0006\u0005\b\b\u0010\u0080\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u0081\u0001H&¢\u0006\u0005\b\b\u0010\u0082\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u0083\u0001H&¢\u0006\u0005\b\b\u0010\u0084\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u0085\u0001H&¢\u0006\u0005\b\b\u0010\u0086\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u0087\u0001H&¢\u0006\u0005\b\b\u0010\u0088\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\u0006\u001a\u00030\u0089\u0001H&¢\u0006\u0005\b\b\u0010\u008a\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\u0006\u001a\u00030\u008b\u0001H&¢\u0006\u0005\b\b\u0010\u008c\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\u0006\u001a\u00030\u008d\u0001H&¢\u0006\u0005\b\b\u0010\u008e\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u008f\u0001H&¢\u0006\u0005\b\b\u0010\u0090\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0091\u0001H&¢\u0006\u0005\b\b\u0010\u0092\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0093\u0001H&¢\u0006\u0005\b\b\u0010\u0094\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030\u0095\u0001H&¢\u0006\u0005\b\b\u0010\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030\u0097\u0001H&¢\u0006\u0005\b\b\u0010\u0098\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0099\u0001H&¢\u0006\u0005\b\b\u0010\u009a\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030\u009b\u0001H&¢\u0006\u0005\b\b\u0010\u009c\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030\u009d\u0001H&¢\u0006\u0005\b\b\u0010\u009e\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u009f\u0001H&¢\u0006\u0005\b\b\u0010 \u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030¡\u0001H&¢\u0006\u0005\b\b\u0010¢\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030£\u0001H&¢\u0006\u0005\b\b\u0010¤\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030¥\u0001H&¢\u0006\u0005\b\b\u0010¦\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030§\u0001H&¢\u0006\u0005\b\b\u0010¨\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ª\u0001\u001a\u00030©\u0001H&¢\u0006\u0005\b\b\u0010«\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030¬\u0001H&¢\u0006\u0005\b\b\u0010\u00ad\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030®\u0001H&¢\u0006\u0005\b\b\u0010¯\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030°\u0001H&¢\u0006\u0005\b\b\u0010±\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030²\u0001H&¢\u0006\u0005\b\b\u0010³\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030´\u0001H&¢\u0006\u0005\b\b\u0010µ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030¶\u0001H&¢\u0006\u0005\b\b\u0010·\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030¸\u0001H&¢\u0006\u0005\b\b\u0010¹\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030º\u0001H&¢\u0006\u0005\b\b\u0010»\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030¼\u0001H&¢\u0006\u0005\b\b\u0010½\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030¾\u0001H&¢\u0006\u0005\b\b\u0010¿\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030À\u0001H&¢\u0006\u0005\b\b\u0010Á\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030Â\u0001H&¢\u0006\u0005\b\b\u0010Ã\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030Ä\u0001H&¢\u0006\u0005\b\b\u0010Å\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030Æ\u0001H&¢\u0006\u0005\b\b\u0010Ç\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030È\u0001H&¢\u0006\u0005\b\b\u0010É\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030Ê\u0001H&¢\u0006\u0005\b\b\u0010Ë\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030Ì\u0001H&¢\u0006\u0005\b\b\u0010Í\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030Î\u0001H&¢\u0006\u0005\b\b\u0010Ï\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030Ð\u0001H&¢\u0006\u0005\b\b\u0010Ñ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030Ò\u0001H&¢\u0006\u0005\b\b\u0010Ó\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030Ô\u0001H&¢\u0006\u0005\b\b\u0010Õ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030Ö\u0001H&¢\u0006\u0005\b\b\u0010×\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030Ø\u0001H&¢\u0006\u0005\b\b\u0010Ù\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030Ú\u0001H&¢\u0006\u0005\b\b\u0010Û\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030Ü\u0001H&¢\u0006\u0005\b\b\u0010Ý\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010r\u001a\u00030Þ\u0001H&¢\u0006\u0005\b\b\u0010ß\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010á\u0001\u001a\u00030à\u0001H&¢\u0006\u0005\b\b\u0010â\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ä\u0001\u001a\u00030ã\u0001H&¢\u0006\u0005\b\b\u0010å\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030æ\u0001H&¢\u0006\u0005\b\b\u0010è\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030é\u0001H&¢\u0006\u0005\b\b\u0010ê\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030ë\u0001H&¢\u0006\u0005\b\b\u0010ì\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030í\u0001H&¢\u0006\u0005\b\b\u0010î\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030ï\u0001H&¢\u0006\u0005\b\b\u0010ð\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030ñ\u0001H&¢\u0006\u0005\b\b\u0010ò\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030ó\u0001H&¢\u0006\u0005\b\b\u0010ô\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030õ\u0001H&¢\u0006\u0005\b\b\u0010ö\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030÷\u0001H&¢\u0006\u0005\b\b\u0010ø\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030ù\u0001H&¢\u0006\u0005\b\b\u0010ú\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030û\u0001H&¢\u0006\u0005\b\b\u0010ü\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030ý\u0001H&¢\u0006\u0005\b\b\u0010þ\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030ÿ\u0001H&¢\u0006\u0005\b\b\u0010\u0080\u0002J\u001a\u0010\b\u001a\u00020\u00072\b\u0010ç\u0001\u001a\u00030\u0081\u0002H&¢\u0006\u0005\b\b\u0010\u0082\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0083\u0002H&¢\u0006\u0005\b\b\u0010\u0084\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u0085\u0002H&¢\u0006\u0005\b\b\u0010\u0086\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\u0012\u001a\u00030\u0087\u0002H&¢\u0006\u0005\b\b\u0010\u0088\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u0089\u0002H&¢\u0006\u0005\b\b\u0010\u008a\u0002J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u008c\u0002\u001a\u00030\u008b\u0002H&¢\u0006\u0005\b\b\u0010\u008d\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010u\u001a\u00030\u008e\u0002H&¢\u0006\u0005\b\b\u0010\u008f\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0090\u0002H&¢\u0006\u0005\b\b\u0010\u0091\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0092\u0002H&¢\u0006\u0005\b\b\u0010\u0093\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0094\u0002H&¢\u0006\u0005\b\b\u0010\u0095\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0096\u0002H&¢\u0006\u0005\b\b\u0010\u0097\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0007\u0010\r\u001a\u00030\u0098\u0002H&¢\u0006\u0005\b\b\u0010\u0099\u0002¨\u0006\u009b\u0002"}, d2 = {"Lsputnik/axmor/com/sputnik/di/AppComponent;", "Lcom/sputnik/oboarding/di/OnBoardingDeps;", "Lcom/sputnik/service_payments/di/ServicePaymentDeps;", "Lcom/sputnik/subscriptions/di/SubscriptionsDeps;", "Lcom/sputnik/common/di/CommonDeps;", "Lsputnik/axmor/com/sputnik/ui/root/SputnikRootActivity;", "activity", "", "inject", "(Lsputnik/axmor/com/sputnik/ui/root/SputnikRootActivity;)V", "Lsputnik/axmor/com/sputnik/ui/call/CallActivity;", "(Lsputnik/axmor/com/sputnik/ui/call/CallActivity;)V", "Lcom/sputnik/common/base/BaseFragment;", "fragment", "(Lcom/sputnik/common/base/BaseFragment;)V", "Lsputnik/axmor/com/sputnik/ui/splash/CustomEmptySplashActivity;", "(Lsputnik/axmor/com/sputnik/ui/splash/CustomEmptySplashActivity;)V", "Lsputnik/axmor/com/sputnik/services/call_service/CallNotificationService;", "service", "(Lsputnik/axmor/com/sputnik/services/call_service/CallNotificationService;)V", "Lsputnik/axmor/com/sputnik/core/push/PushIntentService;", "(Lsputnik/axmor/com/sputnik/core/push/PushIntentService;)V", "Lsputnik/axmor/com/sputnik/widgets/BaseOpenDoorWidget;", "widget", "(Lsputnik/axmor/com/sputnik/widgets/BaseOpenDoorWidget;)V", "Lsputnik/axmor/com/sputnik/ui/nointercom/ProfileNoIntercom;", "(Lsputnik/axmor/com/sputnik/ui/nointercom/ProfileNoIntercom;)V", "Lsputnik/axmor/com/sputnik/ui/splash/CustomSplashFragment;", "(Lsputnik/axmor/com/sputnik/ui/splash/CustomSplashFragment;)V", "Lsputnik/axmor/com/sputnik/ui/block/BlockedFragment;", "(Lsputnik/axmor/com/sputnik/ui/block/BlockedFragment;)V", "Lsputnik/axmor/com/sputnik/ui/call/AnswerCallFragment;", "(Lsputnik/axmor/com/sputnik/ui/call/AnswerCallFragment;)V", "Lsputnik/axmor/com/sputnik/ui/call/ReceivingCallFragment;", "(Lsputnik/axmor/com/sputnik/ui/call/ReceivingCallFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/MainHostFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/MainHostFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCamerasFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCamerasFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/CallHistoryFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/history/CallHistoryFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/NoCamerasFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/NoCamerasFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/CallHistoryDetails;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/history/CallHistoryDetails;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyCommentFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyCommentFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyFinishFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyFinishFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/help/AboutAppFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/help/AboutAppFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/help/AboutCompanyFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/help/AboutCompanyFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/help/HelpFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/help/HelpFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/ServicesInfoFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/ServicesInfoFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/SelectArchiveBottomSheet;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/SelectArchiveBottomSheet;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrErrorFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrErrorFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrServiceFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrServiceFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrStartScanFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrStartScanFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrSuccessFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrSuccessFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/ShotFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/ShotFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/CancelSubscriptionBottomSheet;", "(Lsputnik/axmor/com/sputnik/ui/main/market/subscription/CancelSubscriptionBottomSheet;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/SubscriptionFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/subscription/SubscriptionFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/SettingsProfileFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/SettingsProfileFragment;)V", "Lsputnik/axmor/com/sputnik/ui/nointercom/SettingsAddress;", "(Lsputnik/axmor/com/sputnik/ui/nointercom/SettingsAddress;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/CamerasPreviewFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/CamerasPreviewFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasDetails;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasDetails;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationSplash;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationSplash;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationListFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationListFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationBottomSheet;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationBottomSheet;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/intercom_settings/IntercomSettingsFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/intercom_settings/IntercomSettingsFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/FamilyListFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/FamilyListFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/FamilyInfoFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/FamilyInfoFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/card/NewCardFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/card/NewCardFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/card/CardFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/card/CardFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/ProfileFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/ProfileFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/FlussonicActivity;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/FlussonicActivity;)V", "Lsputnik/axmor/com/sputnik/ui/nointercom/MainHostNoIntercom;", "(Lsputnik/axmor/com/sputnik/ui/nointercom/MainHostNoIntercom;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/DigitalKeysServiceFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/DigitalKeysServiceFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/ArchiveServiceFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/ArchiveServiceFragment;)V", "Lsputnik/axmor/com/sputnik/ui/emergency_code/EmergencyCodeBottomSheet;", "bottomSheet", "(Lsputnik/axmor/com/sputnik/ui/emergency_code/EmergencyCodeBottomSheet;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/dialogs/ErrorArchiveDialog;", "dialog", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/dialogs/ErrorArchiveDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/rate_us/RateUsDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/rate_us/RateUsDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/dialog/DeleteCodeDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/dialog/DeleteCodeDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/dialog/UpdatePermCodeDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/dialog/UpdatePermCodeDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/dialog/UpdateTempCodeDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/dialog/UpdateTempCodeDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/dialogs/FrRemoveDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/dialogs/FrRemoveDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/partner_dialog/PartnerServiceDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/partner_dialog/PartnerServiceDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/success_dialog/SuccessSubscriptionDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/market/subscription/success_dialog/SuccessSubscriptionDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/dialog/LogOutDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/dialog/LogOutDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/dialog/DeleteAccountDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/dialog/DeleteAccountDialog;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsActivity;", "(Lsputnik/axmor/com/sputnik/ui/settings/SettingsActivity;)V", "Lsputnik/axmor/com/sputnik/ui/settings/push/PushSettingsActivity;", "(Lsputnik/axmor/com/sputnik/ui/settings/push/PushSettingsActivity;)V", "Lsputnik/axmor/com/sputnik/ui/settings/BleSettingsActivity;", "(Lsputnik/axmor/com/sputnik/ui/settings/BleSettingsActivity;)V", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService;", "(Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/NewMarketFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/NewMarketFragment;)V", "Lsputnik/axmor/com/sputnik/ui/subscriptions/SubscriptionDetailsFragment;", "(Lsputnik/axmor/com/sputnik/ui/subscriptions/SubscriptionDetailsFragment;)V", "Lsputnik/axmor/com/sputnik/ui/subscriptions/BottomSheetAboutSubscription;", "(Lsputnik/axmor/com/sputnik/ui/subscriptions/BottomSheetAboutSubscription;)V", "Lsputnik/axmor/com/sputnik/ui/alerts/BottomSheetUpdateRequired;", "(Lsputnik/axmor/com/sputnik/ui/alerts/BottomSheetUpdateRequired;)V", "Lsputnik/axmor/com/sputnik/ui/alerts/FragmentUpdateRequired;", "(Lsputnik/axmor/com/sputnik/ui/alerts/FragmentUpdateRequired;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/BottomSheetAboutCallHistory;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/history/BottomSheetAboutCallHistory;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/BottomSheetNoArchive;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/history/BottomSheetNoArchive;)V", "Lsputnik/axmor/com/sputnik/ui/install_sputnik/SendInstallSputnikRequestFragment;", "(Lsputnik/axmor/com/sputnik/ui/install_sputnik/SendInstallSputnikRequestFragment;)V", "Lsputnik/axmor/com/sputnik/ui/our_home/OurHomeUpdateFragment;", "(Lsputnik/axmor/com/sputnik/ui/our_home/OurHomeUpdateFragment;)V", "Lsputnik/axmor/com/sputnik/ui/our_home/AboutOurHomeDialog;", "(Lsputnik/axmor/com/sputnik/ui/our_home/AboutOurHomeDialog;)V", "Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetRatePoll;", "(Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetRatePoll;)V", "Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetPollSuccess;", "(Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetPollSuccess;)V", "Lsputnik/axmor/com/sputnik/services/notification_service/PushProcessorImpl;", "pushProcessorImpl", "(Lsputnik/axmor/com/sputnik/services/notification_service/PushProcessorImpl;)V", "Lsputnik/axmor/com/sputnik/ui/experimental/ExperimentalFunctionsFragment;", "(Lsputnik/axmor/com/sputnik/ui/experimental/ExperimentalFunctionsFragment;)V", "Lsputnik/axmor/com/sputnik/ui/dialogs/InfoDialog;", "(Lsputnik/axmor/com/sputnik/ui/dialogs/InfoDialog;)V", "Lsputnik/axmor/com/sputnik/ui/beta/BottomSheetAboutBetaProgram;", "(Lsputnik/axmor/com/sputnik/ui/beta/BottomSheetAboutBetaProgram;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsDetailsFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsDetailsFragment;)V", "Lsputnik/axmor/com/sputnik/ui/faq/FaqFragment;", "(Lsputnik/axmor/com/sputnik/ui/faq/FaqFragment;)V", "Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesFragment;", "(Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesFragment;)V", "Lsputnik/axmor/com/sputnik/ui/faq/FaqSubcategoriesFragment;", "(Lsputnik/axmor/com/sputnik/ui/faq/FaqSubcategoriesFragment;)V", "Lsputnik/axmor/com/sputnik/ui/vpn/AboutVpnDialog;", "(Lsputnik/axmor/com/sputnik/ui/vpn/AboutVpnDialog;)V", "Lsputnik/axmor/com/sputnik/ui/gorserv/SelectGorservCategoryFragment;", "(Lsputnik/axmor/com/sputnik/ui/gorserv/SelectGorservCategoryFragment;)V", "Lsputnik/axmor/com/sputnik/ui/gorserv/SendGorservRequestFragment;", "(Lsputnik/axmor/com/sputnik/ui/gorserv/SendGorservRequestFragment;)V", "Lsputnik/axmor/com/sputnik/ui/gorserv/BottomSheetGorservRequestSent;", "(Lsputnik/axmor/com/sputnik/ui/gorserv/BottomSheetGorservRequestSent;)V", "Lsputnik/axmor/com/sputnik/ui/gorserv/ChangeGorservUserPhoneDialog;", "(Lsputnik/axmor/com/sputnik/ui/gorserv/ChangeGorservUserPhoneDialog;)V", "Lsputnik/axmor/com/sputnik/ui/gorserv/GorservErrorDialog;", "(Lsputnik/axmor/com/sputnik/ui/gorserv/GorservErrorDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/mobile_pack/MobilePackFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/mobile_pack/MobilePackFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/ResendFamilyInviteDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/ResendFamilyInviteDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/BottomSheetInviteToFamily;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/BottomSheetInviteToFamily;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/SendFamilyInviteErrorDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/SendFamilyInviteErrorDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/RemoveFromFamilyDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/RemoveFromFamilyDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/LeaveFromFamilyDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/LeaveFromFamilyDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/BleServiceFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/BleServiceFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/NoPermissionsDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/NoPermissionsDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/permissions/PermissionsFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/permissions/PermissionsFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetPermissionExplaining;", "(Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetPermissionExplaining;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/BottomSheetSetupRssi;", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/ble/BottomSheetSetupRssi;)V", "Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetNoBlePermissions;", "(Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetNoBlePermissions;)V", "Lsputnik/axmor/com/sputnik/services/ble_service/RebootBroadcastReceiver;", "broadcastReceiver", "(Lsputnik/axmor/com/sputnik/services/ble_service/RebootBroadcastReceiver;)V", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "manager", "(Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;)V", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew;", "player", "(Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew;)V", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImpl;", "(Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImpl;)V", "Lsputnik/axmor/com/sputnik/ui/popups/PopupStoriesFragment;", "(Lsputnik/axmor/com/sputnik/ui/popups/PopupStoriesFragment;)V", "Lsputnik/axmor/com/sputnik/ui/popups/PopupStoryFragment;", "(Lsputnik/axmor/com/sputnik/ui/popups/PopupStoryFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetBackgroundWork;", "(Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetBackgroundWork;)V", "Lsputnik/axmor/com/sputnik/ui/main/permissions/BackgroundWorkFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/permissions/BackgroundWorkFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/permissions/InstructionFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/permissions/InstructionFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeysFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeysFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeyManageFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeyManageFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeyRegisterFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/keys/KeyRegisterFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/BottomSheetKeyAddError;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/keys/BottomSheetKeyAddError;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/DeleteKeyDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/keys/DeleteKeyDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/items/ItemDetailsFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/market/items/ItemDetailsFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/keys/BottomSheetNeedSubscriptionToAddKey;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/keys/BottomSheetNeedSubscriptionToAddKey;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/CameraStreamFragment;", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/CameraStreamFragment;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/card/DeletePaymentMethodDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/card/DeletePaymentMethodDialog;)V", "Lsputnik/axmor/com/sputnik/services/call_service/CheckCallStateService;", "(Lsputnik/axmor/com/sputnik/services/call_service/CheckCallStateService;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ClearCameraPreferencesDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ClearCameraPreferencesDialog;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/BottomSheetSelectAddress;", "sheet", "(Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/BottomSheetSelectAddress;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/DeleteAddressDialog;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/DeleteAddressDialog;)V", "Lsputnik/axmor/com/sputnik/ui/yandex/YandexHomeFragment;", "(Lsputnik/axmor/com/sputnik/ui/yandex/YandexHomeFragment;)V", "Lsputnik/axmor/com/sputnik/ui/yandex/BottomSheetNeedSubscriptionToAddDeviceForYandexAlice;", "(Lsputnik/axmor/com/sputnik/ui/yandex/BottomSheetNeedSubscriptionToAddDeviceForYandexAlice;)V", "Lsputnik/axmor/com/sputnik/ui/multi_address/BottomSheetMultiAddressAnnounce;", "(Lsputnik/axmor/com/sputnik/ui/multi_address/BottomSheetMultiAddressAnnounce;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/BottomSheetSubscriptionNeededForCalls;", "(Lsputnik/axmor/com/sputnik/ui/main/profile/multi_address/BottomSheetSubscriptionNeededForCalls;)V", "Lsputnik/axmor/com/sputnik/ui/archive/ArchiveWebView;", "(Lsputnik/axmor/com/sputnik/ui/archive/ArchiveWebView;)V", "Builder", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AppComponent extends OnBoardingDeps, ServicePaymentDeps, SubscriptionsDeps, CommonDeps {

    /* compiled from: AppComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/di/AppComponent$Builder;", "", "applicationContext", "application", "Landroid/app/Application;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lsputnik/axmor/com/sputnik/di/AppComponent;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        Builder applicationContext(Application application);

        AppComponent build();
    }

    void inject(BaseFragment fragment);

    void inject(WebRtcPlayerImpl player);

    void inject(WebRtcPlayerImplNew player);

    void inject(PushIntentService service);

    void inject(BeaconServiceManager manager);

    void inject(BeaconTrackingService dialog);

    void inject(RebootBroadcastReceiver broadcastReceiver);

    void inject(CallNotificationService service);

    void inject(CheckCallStateService service);

    void inject(PushProcessorImpl pushProcessorImpl);

    void inject(BottomSheetUpdateRequired bottomSheet);

    void inject(FragmentUpdateRequired fragment);

    void inject(ArchiveWebView fragment);

    void inject(BottomSheetAboutBetaProgram bottomSheet);

    void inject(BlockedFragment fragment);

    void inject(AnswerCallFragment fragment);

    void inject(CallActivity activity);

    void inject(ReceivingCallFragment fragment);

    void inject(InfoDialog dialog);

    void inject(EmergencyCodeBottomSheet bottomSheet);

    void inject(ExperimentalFunctionsFragment fragment);

    void inject(FaqCategoriesFragment fragment);

    void inject(FaqFragment fragment);

    void inject(FaqSubcategoriesFragment fragment);

    void inject(BottomSheetGorservRequestSent bottomSheet);

    void inject(ChangeGorservUserPhoneDialog dialog);

    void inject(GorservErrorDialog dialog);

    void inject(SelectGorservCategoryFragment fragment);

    void inject(SendGorservRequestFragment fragment);

    void inject(SendInstallSputnikRequestFragment fragment);

    void inject(MainHostFragment fragment);

    void inject(CameraStreamFragment fragment);

    void inject(GlobalCameraFragment fragment);

    void inject(GlobalCamerasFragment fragment);

    void inject(NoCamerasFragment fragment);

    void inject(BottomSheetAboutCallHistory bottomSheet);

    void inject(BottomSheetNoArchive bottomSheet);

    void inject(CallHistoryDetails fragment);

    void inject(CallHistoryFragment fragment);

    void inject(RateUsDialog dialog);

    void inject(SurveyCommentFragment fragment);

    void inject(SurveyFinishFragment fragment);

    void inject(SurveyFragment fragment);

    void inject(AboutAppFragment fragment);

    void inject(AboutCompanyFragment fragment);

    void inject(HelpFragment fragment);

    void inject(NewMarketFragment fragment);

    void inject(ItemDetailsFragment player);

    void inject(ServicesInfoFragment fragment);

    void inject(ArchiveServiceFragment fragment);

    void inject(FlussonicActivity fragment);

    void inject(SelectArchiveBottomSheet fragment);

    void inject(ErrorArchiveDialog dialog);

    void inject(BleServiceFragment fragment);

    void inject(BottomSheetSetupRssi bottomSheet);

    void inject(NoPermissionsDialog dialog);

    void inject(DigitalKeysServiceFragment fragment);

    void inject(DeleteCodeDialog dialog);

    void inject(UpdatePermCodeDialog dialog);

    void inject(UpdateTempCodeDialog dialog);

    void inject(FrErrorFragment fragment);

    void inject(FrServiceFragment fragment);

    void inject(FrStartScanFragment fragment);

    void inject(FrSuccessFragment fragment);

    void inject(ShotFragment fragment);

    void inject(FrRemoveDialog dialog);

    void inject(PartnerServiceDialog dialog);

    void inject(CancelSubscriptionBottomSheet fragment);

    void inject(SubscriptionFragment fragment);

    void inject(SuccessSubscriptionDialog dialog);

    void inject(BackgroundWorkFragment player);

    void inject(BottomSheetBackgroundWork player);

    void inject(BottomSheetNoBlePermissions bottomSheet);

    void inject(BottomSheetPermissionExplaining bottomSheet);

    void inject(InstructionFragment player);

    void inject(PermissionsFragment fragment);

    void inject(ProfileFragment fragment);

    void inject(CardFragment fragment);

    void inject(DeletePaymentMethodDialog dialog);

    void inject(NewCardFragment fragment);

    void inject(BottomSheetInviteToFamily bottomSheet);

    void inject(FamilyInfoFragment fragment);

    void inject(FamilyListFragment fragment);

    void inject(LeaveFromFamilyDialog dialog);

    void inject(RemoveFromFamilyDialog dialog);

    void inject(ResendFamilyInviteDialog dialog);

    void inject(SendFamilyInviteErrorDialog dialog);

    void inject(IntercomSettingsFragment fragment);

    void inject(BottomSheetKeyAddError player);

    void inject(BottomSheetNeedSubscriptionToAddKey player);

    void inject(DeleteKeyDialog player);

    void inject(KeyManageFragment player);

    void inject(KeyRegisterFragment player);

    void inject(KeysFragment player);

    void inject(LocalizationBottomSheet fragment);

    void inject(LocalizationListFragment fragment);

    void inject(LocalizationSplash fragment);

    void inject(CamerasPreviewFragment fragment);

    void inject(ClearCameraPreferencesDialog dialog);

    void inject(ManageCamerasDetails fragment);

    void inject(ManageCamerasFragment fragment);

    void inject(MobilePackFragment fragment);

    void inject(BottomSheetSelectAddress sheet);

    void inject(BottomSheetSubscriptionNeededForCalls fragment);

    void inject(DeleteAddressDialog dialog);

    void inject(NotificationsDetailsFragment fragment);

    void inject(NotificationsFragment fragment);

    void inject(SettingsProfileFragment fragment);

    void inject(DeleteAccountDialog dialog);

    void inject(LogOutDialog dialog);

    void inject(BottomSheetMultiAddressAnnounce fragment);

    void inject(MainHostNoIntercom fragment);

    void inject(ProfileNoIntercom fragment);

    void inject(SettingsAddress fragment);

    void inject(AboutOurHomeDialog dialog);

    void inject(OurHomeUpdateFragment fragment);

    void inject(BottomSheetPollSuccess bottomSheet);

    void inject(BottomSheetRatePoll bottomSheet);

    void inject(PopupStoriesFragment fragment);

    void inject(PopupStoryFragment fragment);

    void inject(SputnikRootActivity activity);

    void inject(BleSettingsActivity activity);

    void inject(SettingsActivity activity);

    void inject(PushSettingsActivity activity);

    void inject(CustomEmptySplashActivity fragment);

    void inject(CustomSplashFragment fragment);

    void inject(BottomSheetAboutSubscription bottomSheet);

    void inject(SubscriptionDetailsFragment fragment);

    void inject(AboutVpnDialog dialog);

    void inject(BottomSheetNeedSubscriptionToAddDeviceForYandexAlice fragment);

    void inject(YandexHomeFragment fragment);

    void inject(BaseOpenDoorWidget widget);
}
