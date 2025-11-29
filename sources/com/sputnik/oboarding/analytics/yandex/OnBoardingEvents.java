package com.sputnik.oboarding.analytics.yandex;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OnBoardingEvents.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0018\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0018\u001f !\"#$%&'()*+,-./0123456¨\u00067"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ChooseLanguageDoneEvent", "RegistrationAddressRejoinEvent", "RegistrationChangeFlatNumberEvent", "RegistrationChangeNumberEvent", "RegistrationFinishEvent", "RegistrationLinkLicenceEvent", "RegistrationLinkRulesEvent", "RegistrationSetupLaterEvent", "RegistrationSpecifyAddressNextStepEvent", "RegistrationStartEvent", "RegistrationStepOneNextEvent", "RegistrationStepThreeCheckEvent", "RegistrationStepThreeLaterEvent", "RegistrationStepTwoJoinEvent", "RegistrationStepTwoNextEvent", "RegistrationUserHasAccEvent", "RegistrationWrongAddressEvent", "RegistrationWrongAddressTpEvent", "StartStoryEvent", "StoryFinishEvent", "StoryPressedEvent", "StoryShareEvent", "StoryTapLeftEvent", "StoryTapRightEvent", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$ChooseLanguageDoneEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationAddressRejoinEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationChangeFlatNumberEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationChangeNumberEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationFinishEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationLinkLicenceEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationLinkRulesEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationSetupLaterEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationSpecifyAddressNextStepEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStartEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepOneNextEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepThreeCheckEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepThreeLaterEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepTwoJoinEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepTwoNextEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationUserHasAccEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationWrongAddressEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationWrongAddressTpEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StartStoryEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryFinishEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryPressedEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryShareEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryTapLeftEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryTapRightEvent;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class OnBoardingEvents extends AnalyticsTracker.Event {
    public /* synthetic */ OnBoardingEvents(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private OnBoardingEvents(String str, String str2) {
        super("Onboarding", str, str2);
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$ChooseLanguageDoneEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ChooseLanguageDoneEvent extends OnBoardingEvents {
        public ChooseLanguageDoneEvent() {
            super("Choose_lang", "done", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StartStoryEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StartStoryEvent extends OnBoardingEvents {
        public StartStoryEvent() {
            super("Start", "start", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryShareEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StoryShareEvent extends OnBoardingEvents {
        public StoryShareEvent() {
            super("Story", "Share", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryTapLeftEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StoryTapLeftEvent extends OnBoardingEvents {
        public StoryTapLeftEvent() {
            super("Story", "tap_left", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryTapRightEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StoryTapRightEvent extends OnBoardingEvents {
        public StoryTapRightEvent() {
            super("Story", "tap_right", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryPressedEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StoryPressedEvent extends OnBoardingEvents {
        public StoryPressedEvent() {
            super("Story", "pressed", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$StoryFinishEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StoryFinishEvent extends OnBoardingEvents {
        public StoryFinishEvent() {
            super("Story", "finish", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStartEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationStartEvent extends OnBoardingEvents {
        public RegistrationStartEvent() {
            super("Registration", "start", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepOneNextEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationStepOneNextEvent extends OnBoardingEvents {
        public RegistrationStepOneNextEvent() {
            super("Registration", "step_one_next", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationUserHasAccEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationUserHasAccEvent extends OnBoardingEvents {
        public RegistrationUserHasAccEvent() {
            super("Registration", "user_has_acc", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationLinkRulesEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationLinkRulesEvent extends OnBoardingEvents {
        public RegistrationLinkRulesEvent() {
            super("Registration", "external_link_rules", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationLinkLicenceEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationLinkLicenceEvent extends OnBoardingEvents {
        public RegistrationLinkLicenceEvent() {
            super("Registration", "external_link_licence", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationChangeNumberEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationChangeNumberEvent extends OnBoardingEvents {
        public RegistrationChangeNumberEvent() {
            super("Registration", "change_number", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepTwoNextEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationStepTwoNextEvent extends OnBoardingEvents {
        public RegistrationStepTwoNextEvent() {
            super("Registration", "step_two_next", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepTwoJoinEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationStepTwoJoinEvent extends OnBoardingEvents {
        public RegistrationStepTwoJoinEvent() {
            super("Registration", "step_two_join", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationSetupLaterEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationSetupLaterEvent extends OnBoardingEvents {
        public RegistrationSetupLaterEvent() {
            super("Registration", "setup_later", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepThreeCheckEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationStepThreeCheckEvent extends OnBoardingEvents {
        public RegistrationStepThreeCheckEvent() {
            super("Registration", "step_three_check", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationStepThreeLaterEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationStepThreeLaterEvent extends OnBoardingEvents {
        public RegistrationStepThreeLaterEvent() {
            super("Registration", "step_three_later", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationSpecifyAddressNextStepEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationSpecifyAddressNextStepEvent extends OnBoardingEvents {
        public RegistrationSpecifyAddressNextStepEvent() {
            super("Registration", "specify_adress_next_step", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationWrongAddressEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationWrongAddressEvent extends OnBoardingEvents {
        public RegistrationWrongAddressEvent() {
            super("Registration", "wrong_adress", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationAddressRejoinEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationAddressRejoinEvent extends OnBoardingEvents {
        public RegistrationAddressRejoinEvent() {
            super("Registration", "wrong_adress_rejoin", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationWrongAddressTpEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationWrongAddressTpEvent extends OnBoardingEvents {
        public RegistrationWrongAddressTpEvent() {
            super("Registration", "wrong_adress_tp", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationFinishEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationFinishEvent extends OnBoardingEvents {
        public RegistrationFinishEvent() {
            super("Registration", "finish", null);
        }
    }

    /* compiled from: OnBoardingEvents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents$RegistrationChangeFlatNumberEvent;", "Lcom/sputnik/oboarding/analytics/yandex/OnBoardingEvents;", "()V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RegistrationChangeFlatNumberEvent extends OnBoardingEvents {
        public RegistrationChangeFlatNumberEvent() {
            super("Registration", "pop_up_error_change_number", null);
        }
    }
}
