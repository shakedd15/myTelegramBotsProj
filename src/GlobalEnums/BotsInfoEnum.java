package GlobalEnums;

public enum BotsInfoEnum {
    SHAKED_MESSAGE_BOT ("ShakedMessegeBot"),
    SHARON_BOT("SharonLuzonBot"),
    SHAKED_MESSAGE_BOT_TOKEN("579939185:AAF1tmwx4UWf1wE0sot0VsA8Pj2AaGPGsHQ"),
    SHARON_BOT_TOKEN("571066645:AAEh9MQPxXMvt1C-deicirUzet1ja2xUks8");


    private final String name;

    private BotsInfoEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
