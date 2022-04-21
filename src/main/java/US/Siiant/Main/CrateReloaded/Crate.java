package US.Siiant.Main.CrateReloaded;

import java.util.ArrayList;

public class Crate {

    //Crate name
    private String crateName;
    //Key Item
    private String keyItem;
    private int keyAmount;
    private String[] keyLore;
    private String keyDisplayName;
    private boolean keyGlow = false;
    //Type of crate
    private String type;
    //Animation type
    private String animation;
    //Crate Display Name
    private String displayName;
    //Crate Hologram
    private ArrayList<String> hologram = new ArrayList<>();
    //Confirmation Menu
    private boolean confirmation;
    //Accept Button
    private String acceptItem;
    private int acceptAmount;
    private String[] acceptLore;
    private String acceptDisplayName;
    private boolean acceptGlow = false;
    //Decline Button
    private String declineItem;
    private int declineAmount;
    private String[] declineLore;
    private String declineDisplayName;
    private boolean declineGlow = false;
    //Can crate be previewed
    private boolean preview;
    //Amount of rows for the crate
    private int rows;
    //Can the crate be bought
    private boolean buy;
    //Cost if the crate can be bought
    private int cost = 0;
    //Message to send player when crate is opened
    private String messageOpen;
    //Broadcast message when a crate is opened
    private String broadcast;
    //List of effect when crate is opened
    private ArrayList<Effect> effects = new ArrayList<>();
    //Minimum rewards that can be given
    private int rewardMin;
    //Max amount of rewards that can be given
    private int rewardMax;
    //All the rewards that can be inside the crate
    private ArrayList<Reward> rewards = new ArrayList<>();

    public Crate(String crateName){
        this.crateName = crateName;
    }

    public String getAcceptItem() {
        return acceptItem;
    }

    public void setAcceptItem(String acceptItem) {
        this.acceptItem = acceptItem;
    }

    public int getAcceptAmount() {
        return acceptAmount;
    }

    public void setAcceptAmount(int acceptAmount) {
        this.acceptAmount = acceptAmount;
    }

    public String[] getAcceptLore() {
        return acceptLore;
    }

    public void setAcceptLore(String[] acceptLore) {
        this.acceptLore = acceptLore;
    }

    public String getAcceptDisplayName() {
        return acceptDisplayName;
    }

    public void setAcceptDisplayName(String acceptDisplayName) {
        this.acceptDisplayName = acceptDisplayName;
    }

    public boolean isAcceptGlow() {
        return acceptGlow;
    }

    public void setAcceptGlow(boolean acceptGlow) {
        this.acceptGlow = acceptGlow;
    }

    public String getDeclineItem() {
        return declineItem;
    }

    public void setDeclineItem(String declineItem) {
        this.declineItem = declineItem;
    }

    public int getDeclineAmount() {
        return declineAmount;
    }

    public void setDeclineAmount(int declineAmount) {
        this.declineAmount = declineAmount;
    }

    public String[] getDeclineLore() {
        return declineLore;
    }

    public void setDeclineLore(String[] declineLore) {
        this.declineLore = declineLore;
    }

    public String getDeclineDisplayName() {
        return declineDisplayName;
    }

    public void setDeclineDisplayName(String declineDisplayName) {
        this.declineDisplayName = declineDisplayName;
    }

    public boolean isDeclineGlow() {
        return declineGlow;
    }

    public void setDeclineGlow(boolean declineGlow) {
        this.declineGlow = declineGlow;
    }

    public boolean isKeyGlow() {
        return keyGlow;
    }

    public void setKeyGlow(boolean keyGlow) {
        this.keyGlow = keyGlow;
    }

    public String getAnimation() {
        return animation;
    }

    public String getKeyDisplayName() {
        return keyDisplayName;
    }

    public void setKeyDisplayName(String keyDisplayName) {
        this.keyDisplayName = keyDisplayName;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public String getKeyItem() {
        return keyItem;
    }

    public void setKeyItem(String keyItem) {
        this.keyItem = keyItem;
    }

    public int getKeyAmount() {
        return keyAmount;
    }

    public void setKeyAmount(int keyAmount) {
        this.keyAmount = keyAmount;
    }

    public String[] getKeyLore() {
        return keyLore;
    }

    public void setKeyLore(String[] keyLore) {
        this.keyLore = keyLore;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ArrayList<String> getHologram() {
        return hologram;
    }

    public void addHologram(String string) {
        this.hologram.add(string);
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public boolean isPreview() {
        return preview;
    }

    public void setPreview(boolean preview) {
        this.preview = preview;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getMessageOpen() {
        return messageOpen;
    }

    public void setMessageOpen(String messageOpen) {
        this.messageOpen = messageOpen;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public void addEffect(Effect effect) {
        this.effects.add(effect);
    }

    public int getRewardMin() {
        return rewardMin;
    }

    public void setRewardMin(int rewardMin) {
        this.rewardMin = rewardMin;
    }

    public int getRewardMax() {
        return rewardMax;
    }

    public void setRewardMax(int rewardMax) {
        this.rewardMax = rewardMax;
    }

    public ArrayList<Reward> getRewards() {
        return rewards;
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public void setHologram(ArrayList<String> hologram) {
        this.hologram = hologram;
    }

    public void setEffects(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public void setRewards(ArrayList<Reward> rewards){
        this.rewards = rewards;
    }

    public String getCrateName() {
        return crateName;
    }

    public void setCrateName(String crateName) {
        this.crateName = crateName;
    }
}
