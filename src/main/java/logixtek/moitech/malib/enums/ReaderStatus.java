package logixtek.moitech.malib.enums;

public enum ReaderStatus {
    ACTIVE("Hoạt Động"),
    INACTIVE("Không Hoạt Động");

    public final String desc;

    ReaderStatus(String desc) {
        this.desc = desc;
    }
}
