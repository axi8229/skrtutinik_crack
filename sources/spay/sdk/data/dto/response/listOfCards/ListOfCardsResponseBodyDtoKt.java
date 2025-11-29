package spay.sdk.data.dto.response.listOfCards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.data.dto.response.listOfCards.ListOfCardsResponseBodyDto;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0000¨\u0006\u0007"}, d2 = {"toButtonsModelList", "", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PromoInfo$BannerData$Buttons;", "Lspay/sdk/data/dto/response/listOfCards/ListOfCardsResponseBodyDto$PromoInfoDto$BannerDataDto$ButtonsDto;", "toModelList", "Lspay/sdk/domain/model/response/listOfCards/ListOfCardsResponseBody$PaymentToolInfo$Tool;", "Lspay/sdk/data/dto/response/listOfCards/ListOfCardsResponseBodyDto$PaymentToolInfoDto$ToolDto;", "SPaySDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ListOfCardsResponseBodyDtoKt {
    public static final List<ListOfCardsResponseBody.PromoInfo.BannerData.Buttons> toButtonsModelList(List<ListOfCardsResponseBodyDto.PromoInfoDto.BannerDataDto.ButtonsDto> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ListOfCardsResponseBodyDto.PromoInfoDto.BannerDataDto.ButtonsDto) it.next()).toModel());
        }
        return arrayList;
    }

    public static final List<ListOfCardsResponseBody.PaymentToolInfo.Tool> toModelList(List<ListOfCardsResponseBodyDto.PaymentToolInfoDto.ToolDto> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ListOfCardsResponseBodyDto.PaymentToolInfoDto.ToolDto) it.next()).toModel());
        }
        return arrayList;
    }
}
