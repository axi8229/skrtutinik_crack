package com.sputnik.common.mappers.invites;

import com.sputnik.common.entities.invites.FamilyInvite;
import com.sputnik.common.entities.invites.FamilyInvites;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.invites.DomainFamilyInvites;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainFamilyInvitesToFamilyInvitesMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/sputnik/common/mappers/invites/DomainFamilyInvitesToFamilyInvitesMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/invites/DomainFamilyInvites;", "Lcom/sputnik/common/entities/invites/FamilyInvites;", "()V", "map", "input", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainFamilyInvitesToFamilyInvitesMapper implements Mapper<DomainFamilyInvites, FamilyInvites> {

    /* compiled from: DomainFamilyInvitesToFamilyInvitesMapper.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FamilyInvite.FamilyInviteState.values().length];
            try {
                iArr[FamilyInvite.FamilyInviteState.sent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FamilyInvite.FamilyInviteState.accepted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FamilyInvite.FamilyInviteState.denied.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FamilyInvite.FamilyInviteState.unknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.sputnik.domain.common.Mapper
    public FamilyInvites map(DomainFamilyInvites input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.sputnik.common.entities.invites.FamilyInvites map(com.sputnik.domain.entities.invites.DomainFamilyInvites r18, com.sputnik.common.localization.LocalizationStorage r19) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.mappers.invites.DomainFamilyInvitesToFamilyInvitesMapper.map(com.sputnik.domain.entities.invites.DomainFamilyInvites, com.sputnik.common.localization.LocalizationStorage):com.sputnik.common.entities.invites.FamilyInvites");
    }
}
