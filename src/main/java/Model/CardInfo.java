package Model;
import Model.CardInfo;
import sun.security.pkcs11.wrapper.CK_INFO;
import sun.security.pkcs11.wrapper.PKCS11;
import sun.security.pkcs11.wrapper.PKCS11Exception;

public class CardInfo {
    private String cryptokiVersion;
    private String manufacturerID;
    private String libraryDescription;

    private String MTokenCertificate;

    public CardInfo(String cryptokiVersion, String manufacturerID, String libraryDescription) {
        this.cryptokiVersion = cryptokiVersion;
        this.manufacturerID = manufacturerID;
        this.libraryDescription = libraryDescription;
    }

    public String getCryptokiVersion() {
        return cryptokiVersion;
    }

    public void setCryptokiVersion(String cryptokiVersion) {
        this.cryptokiVersion = cryptokiVersion;
    }

    public String getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getLibraryDescription() {
        return libraryDescription;
    }

    public void setLibraryDescription(String libraryDescription) {
        this.libraryDescription = libraryDescription;
    }

}
