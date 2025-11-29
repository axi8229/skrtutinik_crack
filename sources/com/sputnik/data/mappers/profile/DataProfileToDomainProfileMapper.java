package com.sputnik.data.mappers.profile;

import com.sputnik.data.entities.profile.DataProfile;
import com.sputnik.data.entities.profile.DataProfileCardInfo;
import com.sputnik.data.entities.profile.DataSplashScreen;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.auth.StateType;
import com.sputnik.domain.entities.profile.DomainProfile;
import com.sputnik.domain.entities.profile.DomainProfileCardInfo;
import com.sputnik.domain.entities.profile.DomainSplashScreen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: DataProfileToDomainProfileMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/profile/DataProfileToDomainProfileMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/profile/DataProfile;", "Lcom/sputnik/domain/entities/profile/DomainProfile;", "mapper", "Lcom/sputnik/data/mappers/profile/DataProfileCardInfoToDomainProfileCardInfoMapper;", "(Lcom/sputnik/data/mappers/profile/DataProfileCardInfoToDomainProfileCardInfoMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataProfileToDomainProfileMapper implements Mapper<DataProfile, DomainProfile> {
    private final DataProfileCardInfoToDomainProfileCardInfoMapper mapper;

    public DataProfileToDomainProfileMapper(DataProfileCardInfoToDomainProfileCardInfoMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainProfile map(DataProfile input) {
        DomainSplashScreen domainSplashScreen;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(input, "input");
        StateType state = input.getState();
        Boolean addressVerificationRequired = input.getAddressVerificationRequired();
        String apartment = input.getApartment();
        Boolean callEnabled = input.getCallEnabled();
        String firstName = input.getFirstName();
        String avatar = input.getAvatar();
        Boolean feedbackNeed = input.getFeedbackNeed();
        DataProfileCardInfo cardInfo = input.getCardInfo();
        DomainProfileCardInfo map = cardInfo != null ? this.mapper.map(cardInfo) : null;
        Boolean faceRecognitionDataUploaded = input.getFaceRecognitionDataUploaded();
        Boolean servicesPaidByPartner = input.getServicesPaidByPartner();
        Boolean blocked = input.getBlocked();
        String blockingReason = input.getBlockingReason();
        String localization = input.getLocalization();
        String fullAddress = input.getFullAddress();
        String fullAddressWithApartment = input.getFullAddressWithApartment();
        Integer blockLevel = input.getBlockLevel();
        Boolean historyAvailable = input.getHistoryAvailable();
        String pushToken = input.getPushToken();
        String timezone = input.getTimezone();
        if (input.getSplashScreen() != null) {
            DataSplashScreen splashScreen = input.getSplashScreen();
            String title = splashScreen != null ? splashScreen.getTitle() : null;
            DataSplashScreen splashScreen2 = input.getSplashScreen();
            domainSplashScreen = new DomainSplashScreen(title, splashScreen2 != null ? splashScreen2.getBackgroundUrl() : null);
        } else {
            domainSplashScreen = null;
        }
        Boolean loadingVideo = input.getLoadingVideo();
        Boolean richFunctionalityAvailable = input.getRichFunctionalityAvailable();
        String paymentMethod = input.getPaymentMethod();
        List<DataProfile.DataAddress> addresses = input.getAddresses();
        if (addresses == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            List<DataProfile.DataAddress> list = addresses;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                DataProfile.DataAddress dataAddress = (DataProfile.DataAddress) it.next();
                arrayList.add(new DomainProfile.DomainAddress(dataAddress.getId(), dataAddress.getFullAddress(), dataAddress.getFullAddressWithApartment(), dataAddress.getAddressVerificationRequired(), dataAddress.getApartment(), dataAddress.getFlatUUID(), dataAddress.getEntryUUID(), dataAddress.getStatus()));
            }
            listEmptyList = arrayList;
        }
        return new DomainProfile(state, addressVerificationRequired, apartment, callEnabled, firstName, avatar, feedbackNeed, map, faceRecognitionDataUploaded, servicesPaidByPartner, blocked, blockingReason, localization, fullAddress, fullAddressWithApartment, null, blockLevel, historyAvailable, pushToken, timezone, domainSplashScreen, loadingVideo, richFunctionalityAvailable, paymentMethod, listEmptyList, pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP, null);
    }
}
