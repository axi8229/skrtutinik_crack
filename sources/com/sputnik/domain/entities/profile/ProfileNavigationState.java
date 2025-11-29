package com.sputnik.domain.entities.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProfileNavigationState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "", "()V", "Default", "ToActivatedState", "ToEnterFlatNumberState", "ToIntercomState", "ToLoginState", "ToRegistrationState", "ToVerifyAddressState", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState$Default;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToActivatedState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToEnterFlatNumberState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToIntercomState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToLoginState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToRegistrationState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToVerifyAddressState;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ProfileNavigationState {
    public /* synthetic */ ProfileNavigationState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ProfileNavigationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState$Default;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends ProfileNavigationState {
        public Default() {
            super(null);
        }
    }

    private ProfileNavigationState() {
    }

    /* compiled from: ProfileNavigationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToRegistrationState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToRegistrationState extends ProfileNavigationState {
        public ToRegistrationState() {
            super(null);
        }
    }

    /* compiled from: ProfileNavigationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToIntercomState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToIntercomState extends ProfileNavigationState {
        public ToIntercomState() {
            super(null);
        }
    }

    /* compiled from: ProfileNavigationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToVerifyAddressState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToVerifyAddressState extends ProfileNavigationState {
        public ToVerifyAddressState() {
            super(null);
        }
    }

    /* compiled from: ProfileNavigationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToEnterFlatNumberState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToEnterFlatNumberState extends ProfileNavigationState {
        public ToEnterFlatNumberState() {
            super(null);
        }
    }

    /* compiled from: ProfileNavigationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToActivatedState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToActivatedState extends ProfileNavigationState {
        public ToActivatedState() {
            super(null);
        }
    }

    /* compiled from: ProfileNavigationState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/domain/entities/profile/ProfileNavigationState$ToLoginState;", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "()V", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToLoginState extends ProfileNavigationState {
        public ToLoginState() {
            super(null);
        }
    }
}
