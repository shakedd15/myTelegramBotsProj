package commants.lsdBot;

public class LSDUser {

    Integer chatId;
    String name;
    boolean isGoldUser;

    public Integer getChatId() {
        return chatId;
    }

    public String getName() {
        return name;
    }

    public boolean isGoldUser() {
        return isGoldUser;
    }

    public LSDUser(Integer chatId, String name, boolean isGoldUser) {
        this.chatId = chatId;
        this.name = name;
        this.isGoldUser = isGoldUser;
    }
}
