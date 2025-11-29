package spay.sdk.data.dto.response.bnpl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;
import spay.sdk.data.dto.response.DataDtoInterface;
import spay.sdk.domain.model.response.bnpl.ButtonBnplParts;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006!"}, d2 = {"Lspay/sdk/data/dto/response/bnpl/ButtonBnplPartsDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/bnpl/ButtonBnplParts;", "buttonLogo", "", "buttonLogoInactive", "header", "headerInactive", "content", "contentInactive", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonLogo", "()Ljava/lang/String;", "getButtonLogoInactive", "getContent", "getContentInactive", "getHeader", "getHeaderInactive", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ButtonBnplPartsDto implements DataDtoInterface<ButtonBnplParts> {

    @SerializedName("buttonLogo")
    private final String buttonLogo;

    @SerializedName("buttonLogoInactive")
    private final String buttonLogoInactive;

    @SerializedName("content")
    private final String content;

    @SerializedName("contentInactive")
    private final String contentInactive;

    @SerializedName("header")
    private final String header;

    @SerializedName("headerInactive")
    private final String headerInactive;

    public ButtonBnplPartsDto(String buttonLogo, String buttonLogoInactive, String header, String headerInactive, String content, String contentInactive) {
        Intrinsics.checkNotNullParameter(buttonLogo, "buttonLogo");
        Intrinsics.checkNotNullParameter(buttonLogoInactive, "buttonLogoInactive");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(headerInactive, "headerInactive");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentInactive, "contentInactive");
        this.buttonLogo = buttonLogo;
        this.buttonLogoInactive = buttonLogoInactive;
        this.header = header;
        this.headerInactive = headerInactive;
        this.content = content;
        this.contentInactive = contentInactive;
    }

    public static /* synthetic */ ButtonBnplPartsDto copy$default(ButtonBnplPartsDto buttonBnplPartsDto, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buttonBnplPartsDto.buttonLogo;
        }
        if ((i & 2) != 0) {
            str2 = buttonBnplPartsDto.buttonLogoInactive;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = buttonBnplPartsDto.header;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = buttonBnplPartsDto.headerInactive;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = buttonBnplPartsDto.content;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = buttonBnplPartsDto.contentInactive;
        }
        return buttonBnplPartsDto.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getButtonLogo() {
        return this.buttonLogo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getButtonLogoInactive() {
        return this.buttonLogoInactive;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHeaderInactive() {
        return this.headerInactive;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContentInactive() {
        return this.contentInactive;
    }

    public final ButtonBnplPartsDto copy(String buttonLogo, String buttonLogoInactive, String header, String headerInactive, String content, String contentInactive) {
        Intrinsics.checkNotNullParameter(buttonLogo, "buttonLogo");
        Intrinsics.checkNotNullParameter(buttonLogoInactive, "buttonLogoInactive");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(headerInactive, "headerInactive");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentInactive, "contentInactive");
        return new ButtonBnplPartsDto(buttonLogo, buttonLogoInactive, header, headerInactive, content, contentInactive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonBnplPartsDto)) {
            return false;
        }
        ButtonBnplPartsDto buttonBnplPartsDto = (ButtonBnplPartsDto) other;
        return Intrinsics.areEqual(this.buttonLogo, buttonBnplPartsDto.buttonLogo) && Intrinsics.areEqual(this.buttonLogoInactive, buttonBnplPartsDto.buttonLogoInactive) && Intrinsics.areEqual(this.header, buttonBnplPartsDto.header) && Intrinsics.areEqual(this.headerInactive, buttonBnplPartsDto.headerInactive) && Intrinsics.areEqual(this.content, buttonBnplPartsDto.content) && Intrinsics.areEqual(this.contentInactive, buttonBnplPartsDto.contentInactive);
    }

    public final String getButtonLogo() {
        return this.buttonLogo;
    }

    public final String getButtonLogoInactive() {
        return this.buttonLogoInactive;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentInactive() {
        return this.contentInactive;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getHeaderInactive() {
        return this.headerInactive;
    }

    public int hashCode() {
        return this.contentInactive.hashCode() + AbstractC1553e.a(this.content, AbstractC1553e.a(this.headerInactive, AbstractC1553e.a(this.header, AbstractC1553e.a(this.buttonLogoInactive, this.buttonLogo.hashCode() * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ButtonBnplPartsDto(buttonLogo=");
        sb.append(this.buttonLogo);
        sb.append(", buttonLogoInactive=");
        sb.append(this.buttonLogoInactive);
        sb.append(", header=");
        sb.append(this.header);
        sb.append(", headerInactive=");
        sb.append(this.headerInactive);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", contentInactive=");
        return Q1.a(sb, this.contentInactive, ')');
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public ButtonBnplParts toModel() {
        return new ButtonBnplParts(this.buttonLogo, this.buttonLogoInactive, this.header, this.headerInactive, this.content, this.contentInactive);
    }
}
