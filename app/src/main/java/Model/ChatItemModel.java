package Model;

public class ChatItemModel
{
    private int Imageindex;
    private String Name, LastMessage, LastMessageTime;

    public ChatItemModel(int imageindex, String name, String lastMessage, String lastMessageTime) {
        Imageindex = imageindex;
        Name = name;
        LastMessage = lastMessage;
        LastMessageTime = lastMessageTime;
    }

    public int getImageindex() {
        return Imageindex;
    }

    public void setImageindex(int imageindex) {
        Imageindex = imageindex;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;

    }

    public String getLastMessage() {
        return LastMessage;
    }

    public void setLastMessage(String lastMessage) {
        LastMessage = lastMessage;
    }

    public String getLastMessageTime() {
        return LastMessageTime;
    }

    public void setLastMessageTime(String lastMessageTime) {
        LastMessageTime = lastMessageTime;
    }
}
