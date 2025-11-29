package sputnik.axmor.com.sputnik.mappers.family;

import com.redmadrobot.inputmask.model.CaretString;
import com.sputnik.common.AndroidConstants;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.family.DomainFamily;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.family.Family;

/* compiled from: DomainFamilyToFamilyMapper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/family/DomainFamilyToFamilyMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/family/DomainFamily;", "Lsputnik/axmor/com/sputnik/entities/family/Family;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "(Lcom/sputnik/data/local/PrefManager;)V", "getPhone", "", "input", "map", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainFamilyToFamilyMapper implements Mapper<DomainFamily, Family> {
    private final PrefManager prefManager;

    public DomainFamilyToFamilyMapper(PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.prefManager = prefManager;
    }

    @Override // com.sputnik.domain.common.Mapper
    public Family map(DomainFamily input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new Family(input.getId(), input.getFullName(), input.getAvatar(), input.getIsAdmin(), Intrinsics.areEqual(this.prefManager.getPhone(), input.getPhone()), false, getPhone(input), 32, null);
    }

    private final String getPhone(DomainFamily input) {
        if (Intrinsics.areEqual(this.prefManager.getPhone(), input.getPhone())) {
            String phone = input.getPhone();
            if (phone != null) {
                return AndroidConstants.INSTANCE.getMask().apply(new CaretString(phone, phone.length(), new CaretString.CaretGravity.FORWARD(true))).getFormattedText().getString();
            }
            return null;
        }
        String phone2 = input.getPhone();
        if (phone2 != null) {
            return AndroidConstants.INSTANCE.getFamilyMask().apply(new CaretString(phone2, phone2.length(), new CaretString.CaretGravity.FORWARD(true))).getFormattedText().getString();
        }
        return null;
    }
}
