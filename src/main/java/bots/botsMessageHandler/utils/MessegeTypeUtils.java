package bots.botsMessageHandler.utils;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;


@Immutable
public class MessegeTypeUtils {

    SendMessage sendMessage = null;
    SendAudio sendAudio = null;
    ReplyKeyboardMarkup replyKeyboardMarkup = null;

    public MessegeTypeUtils(SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    public MessegeTypeUtils(SendAudio sendAudio) {
        this.sendAudio = sendAudio;
    }

    public MessegeTypeUtils(ReplyKeyboardMarkup replyKeyboardMarkup) {
        this.replyKeyboardMarkup = replyKeyboardMarkup;
    }

    public MessegeTypeUtils(SendMessage sendMessage, SendAudio sendAudio) {
        this.sendMessage = sendMessage;
        this.sendAudio = sendAudio;
    }

    public MessegeTypeUtils(SendMessage sendMessage, SendAudio sendAudio, ReplyKeyboardMarkup replyKeyboardMarkup) {
        this.sendMessage = sendMessage;
        this.sendAudio = sendAudio;
        this.replyKeyboardMarkup = replyKeyboardMarkup;
    }

    public MessegeTypeUtils(SendMessage sendMessage, ReplyKeyboardMarkup replyKeyboardMarkup) {
        this.sendMessage = sendMessage;
        this.replyKeyboardMarkup = replyKeyboardMarkup;
    }

    public MessegeTypeUtils(SendAudio sendAudio, ReplyKeyboardMarkup replyKeyboardMarkup) {
        this.sendAudio = sendAudio;
        this.replyKeyboardMarkup = replyKeyboardMarkup;
    }

    public SendMessage getSendMessage() {
        return sendMessage;
    }

    public SendAudio getSendAudio() {
        return sendAudio;
    }

    public ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        return replyKeyboardMarkup;
    }
}

