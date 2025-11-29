package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import java.util.HashMap;
import org.pjsip.pjsua2.pjmedia_echo_flag;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.yandex.metrica.impl.ob.a1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC0787a1 {
    EVENT_TYPE_UNDEFINED(-1, "Unrecognized action"),
    EVENT_TYPE_INIT(0, "First initialization event"),
    EVENT_TYPE_REGULAR(1, "Regular event"),
    EVENT_TYPE_UPDATE_FOREGROUND_TIME(3, "Update foreground time"),
    EVENT_TYPE_EXCEPTION_USER(5, "Error from developer"),
    EVENT_TYPE_ALIVE(7, "App is still alive"),
    EVENT_TYPE_SET_USER_INFO(9, "User info"),
    EVENT_TYPE_REPORT_USER_INFO(10, "Report user info"),
    EVENT_TYPE_SEND_USER_PROFILE(40961, "Send user profile"),
    EVENT_TYPE_SET_USER_PROFILE_ID(40962, "Set user profile ID"),
    EVENT_TYPE_SEND_REVENUE_EVENT(40976, "Send revenue event"),
    EVENT_TYPE_SEND_AD_REVENUE_EVENT(40977, "Send ad revenue event"),
    EVENT_TYPE_SEND_ECOMMERCE_EVENT(41000, "Send e-commerce event"),
    EVENT_TYPE_PURGE_BUFFER(256, "Forcible buffer clearing"),
    EVENT_TYPE_PREV_SESSION_NATIVE_CRASH(768, "Native crash of app, read from file"),
    EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH(769, "Native crash of app, caught by FileObserver"),
    EVENT_TYPE_STARTUP(1536, "Sending the startup due to lack of data"),
    EVENT_TYPE_IDENTITY(1792, "System identification"),
    EVENT_TYPE_IDENTITY_LIGHT(1793, "Identity light"),
    EVENT_TYPE_DIAGNOSTIC(2048, "Diagnostic event"),
    EVENT_TYPE_DIAGNOSTIC_STATBOX(2049, "Diagnostic statbox event"),
    EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING(2050, "Disable stat send"),
    EVENT_TYPE_STATBOX(2304, "Event with statistical data"),
    EVENT_TYPE_SEND_REFERRER(4097, "Send referrer"),
    EVENT_TYPE_REQUEST_REFERRER(4098, "Request referrer"),
    EVENT_TYPE_APP_ENVIRONMENT_UPDATED(5376, "App Environment Updated"),
    EVENT_TYPE_APP_ENVIRONMENT_CLEARED(5632, "App Environment Cleared"),
    EVENT_TYPE_EXCEPTION_UNHANDLED(5888, "Crash of App"),
    EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE(5889, "Crash of App, read from file"),
    EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT(5890, "Crash of App, passed to server via intent"),
    EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF(5891, "Crash of App"),
    EVENT_TYPE_EXCEPTION_USER_PROTOBUF(5892, "Error from developer"),
    EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF(5893, "Native crash of app, read from file"),
    EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF(5894, "Native crash of app, caught by FileObserver"),
    EVENT_TYPE_API_NATIVE_CRASH_PROTOBUF(5895, "Native crash of app, passed to public API"),
    EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF(5896, "Error from developer with payload"),
    EVENT_TYPE_CURRENT_SESSION_CRASHPAD_CRASH_PROTOBUF(5897, "Crashpad crash of app from socket"),
    EVENT_TYPE_ANR(5968, "ANR"),
    EVENT_TYPE_ACTIVATION(6144, "Activation of metrica"),
    EVENT_TYPE_FIRST_ACTIVATION(6145, "First activation of metrica"),
    EVENT_TYPE_START(6400, "Start of new session"),
    EVENT_TYPE_CUSTOM_EVENT(8192, "Custom event"),
    EVENT_TYPE_SET_SESSION_EXTRA(8193, "Set session extra"),
    EVENT_TYPE_APP_OPEN(8208, "App open event"),
    EVENT_TYPE_APP_UPDATE(8224, "App update event"),
    EVENT_TYPE_PERMISSIONS(pjmedia_echo_flag.PJMEDIA_ECHO_AGGRESSIVENESS_AGGRESSIVE, "Permissions changed event"),
    EVENT_TYPE_APP_FEATURES(12289, "Features, required by application"),
    EVENT_TYPE_UPDATE_PRE_ACTIVATION_CONFIG(16384, "Update pre-activation config"),
    EVENT_TYPE_CLEANUP(12290, "Cleanup database"),
    EVENT_TYPE_VIEW_TREE(12291, "View tree event"),
    EVENT_TYPE_RAW_VIEW_TREE(12292, "Raw view tree event"),
    EVENT_TYPE_APPMETRICA_DIAGNOSTICS(12300, "AppMetrica diagnostics event"),
    EVENT_TYPE_STATBOX_EXP(12310, "AppMetrica experimental statbox event"),
    EVENT_TYPE_WEBVIEW_SYNC(12320, "Counter init event");

    static final HashMap<Integer, EnumC0787a1> e0 = new HashMap<>();
    private final int a;
    private final String b;

    static {
        EnumC0787a1[] enumC0787a1ArrValues = values();
        for (int i = 0; i < 54; i++) {
            EnumC0787a1 enumC0787a1 = enumC0787a1ArrValues[i];
            e0.put(Integer.valueOf(enumC0787a1.a), enumC0787a1);
        }
    }

    EnumC0787a1(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public static EnumC0787a1 a(int i) {
        EnumC0787a1 enumC0787a1 = e0.get(Integer.valueOf(i));
        return enumC0787a1 == null ? EVENT_TYPE_UNDEFINED : enumC0787a1;
    }
}
