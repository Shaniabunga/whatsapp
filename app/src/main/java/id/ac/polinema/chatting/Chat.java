package id.ac.polinema.chatting;

public class Chat {
    private String content;
    private boolean myMessage;

    public Chat(String content, boolean myMessage) {
        this.content = content;
        this.myMessage = myMessage;
    }

    public String getContent() {
        return content;
    }

    public boolean myMessage() {
        return myMessage;
    }

}

