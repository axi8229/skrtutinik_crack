package sputnik.axmor.com.sputnik.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.entities.market.MarketItems;
import com.sputnik.common.entities.market.items.ItemsIds;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.viewmodels.BottomNavigationAction;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationTypes;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.entities.subscriptions.Services;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.core.push.PushManagerImpl;
import sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment;

/* compiled from: IntentProcessingUtils.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a>\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0018"}, d2 = {"handleDeeplink", "", "deeplink", "", "bundle", "Landroid/os/Bundle;", "activity", "Landroid/app/Activity;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "navController", "Landroidx/navigation/NavController;", "handleIntent", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "controller", "parseDeeplink", "Lsputnik/axmor/com/sputnik/core/push/PushManagerImpl$Deeplink;", "parseFaqDeeplink", "Lsputnik/axmor/com/sputnik/utils/FaqDeeplinkParams;", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntentProcessingUtilsKt {
    public static final PushManagerImpl.Deeplink parseDeeplink(String deeplink) {
        String str;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.removePrefix(deeplink, "sputnik://"), new String[]{"/"}, false, 0, 6, (Object) null);
        String str2 = (String) CollectionsKt.getOrNull(listSplit$default, 0);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (String) CollectionsKt.getOrNull(listSplit$default, 0);
        String string = null;
        if ((str3 == null || !StringsKt.contains$default((CharSequence) str3, (CharSequence) "faq", false, 2, (Object) null)) && (str = (String) CollectionsKt.getOrNull(listSplit$default, 1)) != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
            string = intOrNull.toString();
        }
        return new PushManagerImpl.Deeplink(str2, string, deeplink);
    }

    public static /* synthetic */ void handleIntent$default(Intent intent, Activity activity, NavigationViewModel navigationViewModel, NavController navController, Analytics analytics, ProfileViewModel profileViewModel, int i, Object obj) {
        if ((i & 8) != 0) {
            navController = null;
        }
        handleIntent(intent, activity, navigationViewModel, navController, analytics, profileViewModel);
    }

    public static final void handleIntent(Intent intent, Activity activity, NavigationViewModel navigationViewModel, NavController navController, Analytics analytics, ProfileViewModel profileViewModel) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(navigationViewModel, "navigationViewModel");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(profileViewModel, "profileViewModel");
        String string = null;
        if ((intent != null ? intent.getDataString() : null) != null) {
            String dataString = intent.getDataString();
            Intrinsics.checkNotNull(dataString);
            if (StringsKt.startsWith$default(dataString, "http", false, 2, (Object) null)) {
                Uri uri = Uri.parse(intent.getDataString());
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "getQueryParameterNames(...)");
                Set<String> set = queryParameterNames;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
                for (Object obj : set) {
                    linkedHashMap.put(obj, uri.getQueryParameter((String) obj));
                }
                String str = (String) linkedHashMap.get("dp");
                if (str != null && !StringsKt.isBlank(str)) {
                    intent.putExtra(PushMessage.Arguments.deeplink.toString(), str);
                }
            }
        }
        if (intent != null && (extras = intent.getExtras()) != null) {
            string = extras.getString(PushMessage.Arguments.deeplink.toString());
        }
        String str2 = string;
        PushManagerImpl.Deeplink deeplink = parseDeeplink(str2 == null ? "" : str2);
        String uri2 = deeplink.getUri();
        if (uri2 == null || StringsKt.isBlank(uri2)) {
            return;
        }
        String raw = deeplink.getRaw();
        if ((raw != null && StringsKt.isBlank(raw)) || intent == null || intent.getExtras() == null) {
            return;
        }
        handleDeeplink(str2, BundleKt.bundleOf(TuplesKt.to("id", deeplink.getId()), TuplesKt.to("url", deeplink.getUri()), TuplesKt.to("product_id", deeplink.getId())), activity, navigationViewModel, profileViewModel, analytics, navController);
    }

    private static final FaqDeeplinkParams parseFaqDeeplink(String str) {
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.removePrefix(str, "sputnik://"), new String[]{"/"}, false, 0, 6, (Object) null);
        if (listSplit$default.isEmpty() || !Intrinsics.areEqual(listSplit$default.get(0), "faq")) {
            return null;
        }
        int size = listSplit$default.size();
        if (size == 2) {
            Long longOrNull = StringsKt.toLongOrNull((String) listSplit$default.get(1));
            if (longOrNull != null) {
                return new FaqDeeplinkParams(longOrNull.longValue(), null, null, 6, null);
            }
            return null;
        }
        if (size == 3) {
            Long longOrNull2 = StringsKt.toLongOrNull((String) listSplit$default.get(1));
            Long longOrNull3 = StringsKt.toLongOrNull((String) listSplit$default.get(2));
            if (longOrNull2 == null || longOrNull3 == null) {
                return null;
            }
            return new FaqDeeplinkParams(longOrNull2.longValue(), longOrNull3, longOrNull3);
        }
        if (size != 4) {
            return null;
        }
        Long longOrNull4 = StringsKt.toLongOrNull((String) listSplit$default.get(1));
        Long longOrNull5 = StringsKt.toLongOrNull((String) listSplit$default.get(2));
        Long longOrNull6 = StringsKt.toLongOrNull((String) listSplit$default.get(3));
        if (longOrNull4 == null || longOrNull5 == null || longOrNull6 == null) {
            return null;
        }
        return new FaqDeeplinkParams(longOrNull4.longValue(), longOrNull5, longOrNull6);
    }

    public static final void handleDeeplink(String str, Bundle bundle, Activity activity, NavigationViewModel navigationViewModel, ProfileViewModel profileViewModel, Analytics analytics, NavController navController) {
        String uri;
        StringBuilder sb;
        String string;
        NavDestination currentDestination;
        NavDestination currentDestination2;
        NavDestination currentDestination3;
        NavDestination currentDestination4;
        NavDestination currentDestination5;
        NavDestination currentDestination6;
        NavDestination currentDestination7;
        NavDestination currentDestination8;
        NavDestination currentDestination9;
        Profile profile;
        Profile profile2;
        Intrinsics.checkNotNullParameter(navigationViewModel, "navigationViewModel");
        Intrinsics.checkNotNullParameter(profileViewModel, "profileViewModel");
        if (str == null || StringsKt.isBlank(str)) {
            LogUtilsKt.writeLog("deeplink is null or blank");
            return;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "http", false, 2, (Object) null)) {
            if (activity != null) {
                IntentUtilsKt.openBrowser(activity, str);
                Unit unit = Unit.INSTANCE;
                return;
            }
            return;
        }
        String str2 = "sputnik://";
        if (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "sputnik://", false, 2, (Object) null)) {
            str2 = "";
        }
        PushManagerImpl.Deeplink deeplink = parseDeeplink(str == null ? "" : str);
        if ((str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "faq", false, 2, (Object) null)) || (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "notifications", false, 2, (Object) null))) {
            string = str2 + deeplink.getUri();
        } else {
            if (deeplink.getId() == null) {
                uri = deeplink.getRaw();
                sb = new StringBuilder();
            } else {
                uri = deeplink.getUri();
                sb = new StringBuilder();
            }
            sb.append(str2);
            sb.append(uri);
            string = sb.toString();
        }
        LogUtilsKt.writeLog("GGGG: DEEPLINK PARSING: deeplink='" + str + "', parsed=" + deeplink + ", resultUri='" + string + "'");
        LogUtilsKt.writeLog("GGGG: DEEPLINK " + deeplink.getRaw() + " | " + deeplink.getId() + " | " + deeplink.getUri() + " | " + string + " | " + bundle);
        if (string != null) {
            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market) : null)) {
                navigationViewModel.addAction(new NavigationScenario(new BottomNavigationAction(null, Integer.valueOf(R.id.navigation_market), 1, null), new LinkedList(CollectionsKt.emptyList()), true));
            } else {
                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_profile) : null)) {
                    navigationViewModel.addAction(new NavigationScenario(new BottomNavigationAction(null, Integer.valueOf(R.id.navigation_profile), 1, null), new LinkedList(CollectionsKt.emptyList()), true));
                } else {
                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_standard_payment) : null)) {
                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_subscriptions_navigation, Subscriptions.standard.toString(), BundleKt.bundleOf(TuplesKt.to("need_show_payment", Boolean.TRUE)), null, 8, null))), false, 4, null));
                    } else {
                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_standard) : null)) {
                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_subscriptions_navigation, Subscriptions.standard.toString(), null, null, 12, null))), false, 4, null));
                        } else {
                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_premium) : null)) {
                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_subscriptions_navigation, Subscriptions.premium.toString(), null, null, 12, null))), false, 4, null));
                            } else {
                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_card) : null)) {
                                    ProfileViewState currentState = profileViewModel.getCurrentState();
                                    if (currentState != null && (profile2 = currentState.getProfile()) != null) {
                                        cardInfo = profile2.getCardInfo();
                                    }
                                    if (cardInfo == null) {
                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_new_card, "", null, null, 12, null))), false, 4, null));
                                    } else {
                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_card, "", null, null, 12, null))), false, 4, null));
                                    }
                                } else {
                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_services) : null)) {
                                        NewMarketFragment.INSTANCE.setDestination(MarketItems.SERVICES);
                                        navigationViewModel.addAction(new NavigationScenario(new BottomNavigationAction(null, Integer.valueOf(R.id.navigation_market), 1, null), new LinkedList(CollectionsKt.emptyList()), true));
                                    } else {
                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_subscriptions) : null)) {
                                            NewMarketFragment.INSTANCE.setDestination(MarketItems.SUBS);
                                            navigationViewModel.addAction(new NavigationScenario(new BottomNavigationAction(null, Integer.valueOf(R.id.navigation_market), 1, null), new LinkedList(CollectionsKt.emptyList()), true));
                                        } else {
                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_about_app) : null)) {
                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_about_app, "", null, null, 12, null))), false, 4, null));
                                            } else {
                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_about_company) : null)) {
                                                    navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_about_company, "", null, null, 12, null))), false, 4, null));
                                                } else {
                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_visits) : null)) {
                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_call_history, "", null, null, 12, null))), false, 4, null));
                                                    } else {
                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_service_payments) : null)) {
                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_service_payments, "", null, null, 12, null))), false, 4, null));
                                                        } else {
                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_our_home) : null)) {
                                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_our_home_update, "", null, null, 12, null))), false, 4, null));
                                                            } else {
                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_faq) : null)) {
                                                                    FaqDeeplinkParams faqDeeplink = parseFaqDeeplink(str != null ? str : "");
                                                                    if (faqDeeplink != null) {
                                                                        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("faq_category_id", Long.valueOf(faqDeeplink.getCategoryId())));
                                                                        Long subcategoryId = faqDeeplink.getSubcategoryId();
                                                                        if (subcategoryId != null) {
                                                                            bundleBundleOf.putLong("faq_subcategory_id", subcategoryId.longValue());
                                                                            Unit unit2 = Unit.INSTANCE;
                                                                        }
                                                                        Long questionId = faqDeeplink.getQuestionId();
                                                                        if (questionId != null) {
                                                                            bundleBundleOf.putLong("faq_question_id", questionId.longValue());
                                                                            Unit unit3 = Unit.INSTANCE;
                                                                        }
                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_faqCategoriesFragment, "", bundleBundleOf, null, 8, null))), false, 4, null));
                                                                    } else {
                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_faqCategoriesFragment, "", null, null, 12, null))), false, 4, null));
                                                                    }
                                                                } else {
                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_card) : null)) {
                                                                        ProfileViewState currentState2 = profileViewModel.getCurrentState();
                                                                        if (currentState2 != null && (profile = currentState2.getProfile()) != null) {
                                                                            cardInfo = profile.getCardInfo();
                                                                        }
                                                                        if (cardInfo == null) {
                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_new_card, "", null, null, 12, null))), false, 4, null));
                                                                        } else {
                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_to_card, "", null, null, 12, null))), false, 4, null));
                                                                        }
                                                                    } else {
                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_family) : null)) {
                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_familyFragment, "", null, null, 12, null))), false, 4, null));
                                                                        } else {
                                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_notifications) : null)) {
                                                                                String id = deeplink.getId();
                                                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_notifications, null, BundleKt.bundleOf(TuplesKt.to("item", id != null ? StringsKt.toIntOrNull(id) : null)), null, 8, null))), false, 4, null));
                                                                            } else {
                                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_back) : null)) {
                                                                                    navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(-1, "", null, null, 12, null))), false, 4, null));
                                                                                } else {
                                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_emergency_code) : null)) {
                                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(-1, String.valueOf(bundle != null ? bundle.getString("code") : null), null, null, 12, null))), false, 4, null));
                                                                                    } else {
                                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_no_permissions) : null)) {
                                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_bottomSheetNoBlePermissions, "", null, null, 12, null))), false, 4, null));
                                                                                        } else {
                                                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_support_chat) : null)) {
                                                                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(666, "", null, null, 12, null))), false, 4, null));
                                                                                            } else {
                                                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_company_contacts) : null)) {
                                                                                                    navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_aboutCompany, "", null, null, 12, null))), false, 4, null));
                                                                                                } else {
                                                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_cameras_gallery) : null)) {
                                                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_cameras_preview, "", null, null, 12, null))), false, 4, null));
                                                                                                    } else {
                                                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_ble) : null)) {
                                                                                                            Integer numValueOf = (navController == null || (currentDestination9 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination9.getId());
                                                                                                            ArrayList arrayList = new ArrayList();
                                                                                                            if ((numValueOf == null || numValueOf.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf == null || numValueOf.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                arrayList.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.ble.toString())), null, 8, null));
                                                                                                            }
                                                                                                            if (numValueOf != null && numValueOf.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                arrayList.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.ble.toString())), NavigationTypes.custom));
                                                                                                            }
                                                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList)), false, 4, null));
                                                                                                        } else {
                                                                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_accelerated_loading) : null)) {
                                                                                                                Integer numValueOf2 = (navController == null || (currentDestination8 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination8.getId());
                                                                                                                ArrayList arrayList2 = new ArrayList();
                                                                                                                if ((numValueOf2 == null || numValueOf2.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf2 == null || numValueOf2.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                    arrayList2.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.accelerated_loading.toString())), null, 8, null));
                                                                                                                }
                                                                                                                if (numValueOf2 != null && numValueOf2.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                    arrayList2.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.accelerated_loading.toString())), NavigationTypes.custom));
                                                                                                                }
                                                                                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList2)), false, 4, null));
                                                                                                            } else {
                                                                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_digital_keys) : null)) {
                                                                                                                    Integer numValueOf3 = (navController == null || (currentDestination7 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination7.getId());
                                                                                                                    ArrayList arrayList3 = new ArrayList();
                                                                                                                    if ((numValueOf3 == null || numValueOf3.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf3 == null || numValueOf3.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                        arrayList3.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.digital_keys.toString())), null, 8, null));
                                                                                                                    }
                                                                                                                    if (numValueOf3 != null && numValueOf3.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                        arrayList3.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.digital_keys.toString())), NavigationTypes.custom));
                                                                                                                    }
                                                                                                                    navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList3)), false, 4, null));
                                                                                                                } else {
                                                                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_history) : null)) {
                                                                                                                        Integer numValueOf4 = (navController == null || (currentDestination6 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination6.getId());
                                                                                                                        ArrayList arrayList4 = new ArrayList();
                                                                                                                        if ((numValueOf4 == null || numValueOf4.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf4 == null || numValueOf4.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                            arrayList4.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.history.toString())), null, 8, null));
                                                                                                                        }
                                                                                                                        if (numValueOf4 != null && numValueOf4.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                            arrayList4.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.history.toString())), NavigationTypes.custom));
                                                                                                                        }
                                                                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList4)), false, 4, null));
                                                                                                                    } else {
                                                                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_archive) : null)) {
                                                                                                                            Integer numValueOf5 = (navController == null || (currentDestination5 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination5.getId());
                                                                                                                            ArrayList arrayList5 = new ArrayList();
                                                                                                                            if ((numValueOf5 == null || numValueOf5.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf5 == null || numValueOf5.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                                arrayList5.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.archive_3.toString())), null, 8, null));
                                                                                                                            }
                                                                                                                            if (numValueOf5 != null && numValueOf5.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                                arrayList5.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.archive_3.toString())), NavigationTypes.custom));
                                                                                                                            }
                                                                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList5)), false, 4, null));
                                                                                                                        } else {
                                                                                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_extra_cameras) : null)) {
                                                                                                                                Integer numValueOf6 = (navController == null || (currentDestination4 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination4.getId());
                                                                                                                                ArrayList arrayList6 = new ArrayList();
                                                                                                                                if ((numValueOf6 == null || numValueOf6.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf6 == null || numValueOf6.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                                    arrayList6.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.extra_cameras.toString())), null, 8, null));
                                                                                                                                }
                                                                                                                                if (numValueOf6 != null && numValueOf6.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                                    arrayList6.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.extra_cameras.toString())), NavigationTypes.custom));
                                                                                                                                }
                                                                                                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList6)), false, 4, null));
                                                                                                                            } else {
                                                                                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_alice) : null)) {
                                                                                                                                    Integer numValueOf7 = (navController == null || (currentDestination3 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination3.getId());
                                                                                                                                    ArrayList arrayList7 = new ArrayList();
                                                                                                                                    if ((numValueOf7 == null || numValueOf7.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf7 == null || numValueOf7.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                                        arrayList7.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.alice.toString())), null, 8, null));
                                                                                                                                    }
                                                                                                                                    if (numValueOf7 != null && numValueOf7.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                                        arrayList7.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.alice.toString())), NavigationTypes.custom));
                                                                                                                                    }
                                                                                                                                    navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList7)), false, 4, null));
                                                                                                                                } else {
                                                                                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_licensed_keys) : null)) {
                                                                                                                                        Integer numValueOf8 = (navController == null || (currentDestination2 = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination2.getId());
                                                                                                                                        ArrayList arrayList8 = new ArrayList();
                                                                                                                                        if ((numValueOf8 == null || numValueOf8.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf8 == null || numValueOf8.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                                            arrayList8.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.licensed_keys.toString())), null, 8, null));
                                                                                                                                        }
                                                                                                                                        if (numValueOf8 != null && numValueOf8.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                                            arrayList8.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.licensed_keys.toString())), NavigationTypes.custom));
                                                                                                                                        }
                                                                                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList8)), false, 4, null));
                                                                                                                                    } else {
                                                                                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_feature_multiaddress) : null)) {
                                                                                                                                            Integer numValueOf9 = (navController == null || (currentDestination = navController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination.getId());
                                                                                                                                            ArrayList arrayList9 = new ArrayList();
                                                                                                                                            if ((numValueOf9 == null || numValueOf9.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf9 == null || numValueOf9.intValue() != R.id.bottomSheetAboutService)) {
                                                                                                                                                arrayList9.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.multiaddress.toString())), null, 8, null));
                                                                                                                                            }
                                                                                                                                            if (numValueOf9 != null && numValueOf9.intValue() == R.id.fragmentSubscriptionDetails) {
                                                                                                                                                arrayList9.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", Services.multiaddress.toString())), NavigationTypes.custom));
                                                                                                                                            }
                                                                                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList9)), false, 4, null));
                                                                                                                                        } else {
                                                                                                                                            if (!Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_system_settings) : null)) {
                                                                                                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_system_settings_apps) : null)) {
                                                                                                                                                    activity.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                                                                                                                                } else {
                                                                                                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_system_settings_apps_all) : null)) {
                                                                                                                                                        activity.startActivity(new Intent("android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS"));
                                                                                                                                                    } else {
                                                                                                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_system_settings_battery_saver) : null)) {
                                                                                                                                                            activity.startActivity(new Intent("android.settings.BATTERY_SAVER_SETTINGS"));
                                                                                                                                                        } else {
                                                                                                                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_system_settings_app) : null)) {
                                                                                                                                                                IntentUtilsKt.openSystemAppSettings(activity);
                                                                                                                                                            } else {
                                                                                                                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_system_settings_whitelist) : null)) {
                                                                                                                                                                    IntentUtilsKt.openIgnoreBatteryOptimisationsSettings(activity);
                                                                                                                                                                } else {
                                                                                                                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_licensed_keys) : null)) {
                                                                                                                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_licensedKeys, "", null, null, 12, null))), false, 4, null));
                                                                                                                                                                    } else {
                                                                                                                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_items) : null)) {
                                                                                                                                                                            NewMarketFragment.INSTANCE.setDestination(MarketItems.ITEMS);
                                                                                                                                                                            navigationViewModel.addAction(new NavigationScenario(new BottomNavigationAction(null, Integer.valueOf(R.id.navigation_market), 1, null), new LinkedList(CollectionsKt.emptyList()), true));
                                                                                                                                                                        } else {
                                                                                                                                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_items_yandex_catalog) : null)) {
                                                                                                                                                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_mainHostFragment_to_webViewFragment, "", BundleKt.bundleOf(TuplesKt.to("url", "https://alice.yandex.ru/store?sid=External_Sputnik"), TuplesKt.to(AppMeasurementSdk.ConditionalUserProperty.NAME, "")), null, 8, null))), false, 4, null));
                                                                                                                                                                            } else {
                                                                                                                                                                                if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_market_items_keys) : null)) {
                                                                                                                                                                                    navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_marketItemDetailsFragment, "", BundleKt.bundleOf(TuplesKt.to("id", ItemsIds.licensed_keys.toString())), null, 8, null))), false, 4, null));
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_services_ble) : null)) {
                                                                                                                                                                                        navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_mainHostFragment_to_ble_navigation, "", null, null, 12, null))), false, 4, null));
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_yandex_connect_alice) : null)) {
                                                                                                                                                                                            navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_yandex_home, "", null, null, 12, null))), false, 4, null));
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (Intrinsics.areEqual(string, activity != null ? activity.getString(R.string.deeplink_address_selection) : null)) {
                                                                                                                                                                                                navigationViewModel.addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_select_address, "", null, null, 12, null))), false, 4, null));
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            } else if (activity != null) {
                                                                                                                                                activity.startActivity(new Intent("android.settings.SETTINGS"));
                                                                                                                                                Unit unit4 = Unit.INSTANCE;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Unit unit5 = Unit.INSTANCE;
        }
    }
}
