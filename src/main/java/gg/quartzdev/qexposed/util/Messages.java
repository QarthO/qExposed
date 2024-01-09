package gg.quartzdev.qexposed.util;

public enum Messages {

//    Prefix
    CONSOLE_PREFIX("<gray>[<red>q<aqua>Exposed<gray>]"),
    CHAT_PREFIX("<red>q<aqua>Exposed <bold><gray>></bold>"),

    //    Generic Plugin
    PLUGIN_INFO("<prefix> <green>Running version <gray><version>"),
    RELOAD_COMPLETE("<prefix> <green>Config reloaded"),
    ERROR_CMD_NOT_FOUND("<prefix> <red>Error: Command not found: <yellow><cmd>"),

    //    Generic File
    FILE_CREATED("<prefix> <green>Created file: <yellow><file>"),
    ERROR_CREATE_FILE("<prefix> Error creating file: <yellow><file>"),
    ERROR_SAVE_FILE("<prefix> Error saving file: <yellow><file>"),
    ERROR_CORRUPT_FILE("<prefix> <red>Error: Corrupt file: <yellow><file></yellow><newline>Please reset the file.");

//    Murderer


    private final String message;
    private String parsedMessage;

    Messages(String msg){
        this.message = msg;
        this.parsedMessage = msg;
    }

    @Override
    public String toString(){
        return this.message;
    }

    public String get(){
        String result = this.parsedMessage;
        this.parsedMessage = this.message;
        return result;
    }

    public Messages parse(String placeholder, String value){
        this.parsedMessage = this.parsedMessage.replaceAll("<" + placeholder + ">", value);
        return this;
    }
}
