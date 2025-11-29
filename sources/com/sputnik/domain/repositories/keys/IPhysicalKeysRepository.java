package com.sputnik.domain.repositories.keys;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.keys.DomainPhysicalKey;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IPhysicalKeysRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J,\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u00040\u00032\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&¨\u0006\u0012"}, d2 = {"Lcom/sputnik/domain/repositories/keys/IPhysicalKeysRepository;", "", "blockKey", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/keys/DomainPhysicalKey;", "uuid", "", "createKey", "addressId", "", "hex", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "deleteKey", "getKeys", "", "unblockKey", "updateComment", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IPhysicalKeysRepository {
    Flow<Resource<DomainPhysicalKey>> blockKey(String uuid);

    Flow<Resource<DomainPhysicalKey>> createKey(int addressId, String hex, String comment);

    Flow<Resource<DomainPhysicalKey>> deleteKey(String uuid);

    Flow<Resource<List<DomainPhysicalKey>>> getKeys(int addressId);

    Flow<Resource<DomainPhysicalKey>> unblockKey(String uuid);

    Flow<Resource<DomainPhysicalKey>> updateComment(String uuid, String comment);
}
