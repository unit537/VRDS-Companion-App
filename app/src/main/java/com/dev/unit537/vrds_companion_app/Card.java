package com.dev.unit537.vrds_companion_app;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card implements Serializable
{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("thumbnail_path")
    @Expose
    private String thumbnailPath;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("price_low")
    @Expose
    private Object priceLow;
    @SerializedName("price_avg")
    @Expose
    private Object priceAvg;
    @SerializedName("price_high")
    @Expose
    private Object priceHigh;
    @SerializedName("tcgplayer_link")
    @Expose
    private String tcgplayerLink;
    @SerializedName("is_monster")
    @Expose
    private Boolean isMonster;
    @SerializedName("is_spell")
    @Expose
    private Boolean isSpell;
    @SerializedName("is_illegal")
    @Expose
    private Boolean isIllegal;
    @SerializedName("is_trap")
    @Expose
    private Boolean isTrap;
    @SerializedName("has_name_condition")
    @Expose
    private Boolean hasNameCondition;
    @SerializedName("property")
    @Expose
    private String property;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("monster_types")
    @Expose
    private List<String> monsterTypes = null;
    @SerializedName("attack")
    @Expose
    private String attack;
    @SerializedName("defense")
    @Expose
    private String defense;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("attribute")
    @Expose
    private String attribute;
    @SerializedName("is_pendulum")
    @Expose
    private Boolean isPendulum;
    @SerializedName("is_xyz")
    @Expose
    private Boolean isXyz;
    @SerializedName("is_synchro")
    @Expose
    private Boolean isSynchro;
    @SerializedName("is_fusion")
    @Expose
    private Boolean isFusion;
    @SerializedName("is_link")
    @Expose
    private Boolean isLink;
    @SerializedName("is_extra_deck")
    @Expose
    private Boolean isExtraDeck;
    @SerializedName("has_materials")
    @Expose
    private Boolean hasMaterials;
    @SerializedName("pendulum_left")
    @Expose
    private String pendulumLeft;
    @SerializedName("pendulum_right")
    @Expose
    private String pendulumRight;
    @SerializedName("pendulum_text")
    @Expose
    private String pendulumText;
    @SerializedName("materials")
    @Expose
    private String materials;
    @SerializedName("link_markers")
    @Expose
    private List<String> linkMarkers = null;
    @SerializedName("link_number")
    @Expose
    private String linkNumber;

    /**
     * No args constructor for use in serialization
     *
     */
    public Card() {}

    public Card(String name, String imagePath, String thumbnailPath, String text, String type, String number, Object priceLow, Object priceAvg, Object priceHigh, String tcgplayerLink, Boolean isMonster, Boolean isSpell, Boolean isIllegal, Boolean isTrap, Boolean hasNameCondition, String property, String species, List<String> monsterTypes, String attack, String defense, String stars, String attribute, Boolean isPendulum, Boolean isXyz, Boolean isSynchro, Boolean isFusion, Boolean isLink, Boolean isExtraDeck, Boolean hasMaterials, String pendulumLeft, String pendulumRight, String pendulumText, String materials, List<String> linkMarkers, String linkNumber) {
        this.name = name;
        this.imagePath = imagePath;
        this.thumbnailPath = thumbnailPath;
        this.text = text;
        this.type = type;
        this.number = number;
        this.priceLow = priceLow;
        this.priceAvg = priceAvg;
        this.priceHigh = priceHigh;
        this.tcgplayerLink = tcgplayerLink;
        this.isMonster = isMonster;
        this.isSpell = isSpell;
        this.isIllegal = isIllegal;
        this.isTrap = isTrap;
        this.hasNameCondition = hasNameCondition;
        this.property = property;
        this.species = species;
        this.monsterTypes = monsterTypes;
        this.attack = attack;
        this.defense = defense;
        this.stars = stars;
        this.attribute = attribute;
        this.isPendulum = isPendulum;
        this.isXyz = isXyz;
        this.isSynchro = isSynchro;
        this.isFusion = isFusion;
        this.isLink = isLink;
        this.isExtraDeck = isExtraDeck;
        this.hasMaterials = hasMaterials;
        this.pendulumLeft = pendulumLeft;
        this.pendulumRight = pendulumRight;
        this.pendulumText = pendulumText;
        this.materials = materials;
        this.linkMarkers = linkMarkers;
        this.linkNumber = linkNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Object getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(Object priceLow) {
        this.priceLow = priceLow;
    }

    public Object getPriceAvg() {
        return priceAvg;
    }

    public void setPriceAvg(Object priceAvg) {
        this.priceAvg = priceAvg;
    }

    public Object getPriceHigh() {
        return priceHigh;
    }

    public void setPriceHigh(Object priceHigh) {
        this.priceHigh = priceHigh;
    }

    public String getTcgplayerLink() {
        return tcgplayerLink;
    }

    public void setTcgplayerLink(String tcgplayerLink) {
        this.tcgplayerLink = tcgplayerLink;
    }

    public Boolean getIsMonster() {
        return isMonster;
    }

    public void setIsMonster(Boolean isMonster) {
        this.isMonster = isMonster;
    }

    public Boolean getIsSpell() {
        return isSpell;
    }

    public void setIsSpell(Boolean isSpell) {
        this.isSpell = isSpell;
    }

    public Boolean getIsIllegal() {
        return isIllegal;
    }

    public void setIsIllegal(Boolean isIllegal) {
        this.isIllegal = isIllegal;
    }

    public Boolean getIsTrap() {
        return isTrap;
    }

    public void setIsTrap(Boolean isTrap) {
        this.isTrap = isTrap;
    }

    public Boolean getHasNameCondition() {
        return hasNameCondition;
    }

    public void setHasNameCondition(Boolean hasNameCondition) {
        this.hasNameCondition = hasNameCondition;
    }

    public String getProperty(){
        return property;
    }

    public void setProperty(String property){
        this.property = property;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<String> getMonsterTypes() {
        return monsterTypes;
    }

    public void setMonsterTypes(List<String> monsterTypes) {
        this.monsterTypes = monsterTypes;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Boolean getIsPendulum() {
        return isPendulum;
    }

    public void setIsPendulum(Boolean isPendulum) {
        this.isPendulum = isPendulum;
    }

    public Boolean getIsXyz() {
        return isXyz;
    }

    public void setIsXyz(Boolean isXyz) {
        this.isXyz = isXyz;
    }

    public Boolean getIsSynchro() {
        return isSynchro;
    }

    public void setIsSynchro(Boolean isSynchro) {
        this.isSynchro = isSynchro;
    }

    public Boolean getIsFusion() {
        return isFusion;
    }

    public void setIsFusion(Boolean isFusion) {
        this.isFusion = isFusion;
    }

    public Boolean getIsLink() {
        return isLink;
    }

    public void setIsLink(Boolean isLink) {
        this.isLink = isLink;
    }

    public Boolean getIsExtraDeck() {
        return isExtraDeck;
    }

    public void setIsExtraDeck(Boolean isExtraDeck) {
        this.isExtraDeck = isExtraDeck;
    }

    public Boolean getHasMaterials() {
        return hasMaterials;
    }

    public void setHasMaterials(Boolean hasMaterials) {
        this.hasMaterials = hasMaterials;
    }

    public String getPendulumLeft() {
        return pendulumLeft;
    }

    public void setPendulumLeft(String pendulumLeft) {
        this.pendulumLeft = pendulumLeft;
    }

    public String getPendulumRight() {
        return pendulumRight;
    }

    public void setPendulumRight(String pendulumRight) {
        this.pendulumRight = pendulumRight;
    }

    public String getPendulumText() {
        return pendulumText;
    }

    public void setPendulumText(String pendulumText) {
        this.pendulumText = pendulumText;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public List<String> getLinkMarkers(){
        return linkMarkers;
    }

    public void setLinkMarkers(List<String> linkMarkers){
        this.linkMarkers = linkMarkers;
    }

    public String getLinkNumber(){
        return linkNumber;
    }

    public void setLinkNumber(String linkNumber){
        this.linkNumber = linkNumber;
    }

    public String getCardTexts(){
        String card_string = "";

        if(this.type == null){
            return "Null Card Type";
        }
        else if(this.type.equals("Monster")){
            // ---
            card_string = card_string.concat(this.species);
            for(String type : this.monsterTypes){
                card_string = card_string.concat("/" + type);
            }
            card_string = card_string.concat("\n");
            if (this.hasMaterials){
                card_string = card_string.concat(this.materials + "\n");
            }
            if (this.isPendulum) {
                card_string = card_string.concat("[Pendulum Text]\n" + this.pendulumText + "\n");
            }
            card_string = card_string.concat("[Text]\n" + this.text);
            // ---
        } else if (this.type.equals("Spell")){
            // ---
            card_string = card_string.concat("[Text]\n" + this.text);
            // ---
        } else if (this.type.equals("Trap")) {
            // ---
            card_string = card_string.concat("[Text]\n" + this.text);
            // ---
        } else {
            return "Unknown Card Type";
        }

        return card_string.trim();
    }

    public String getCardStats(){
        String card_string = "";

        card_string = card_string.concat(this.name + "\n");
        if(this.type == null){
            return "Null Card Type";
        }
        else if(this.type.equals("Monster")){
            // ---
            if (!this.isXyz && !this.isLink) {
                card_string = card_string.concat("Level: " + this.stars + "\n");
            } else if (this.isXyz) {
                card_string = card_string.concat("Rank: " + this.stars + "\n");
            }
            card_string = card_string.concat("Attribute: " + this.attribute + "\n");
            card_string = card_string.concat("Types: " + this.species);
            for(String type : this.monsterTypes){
                card_string = card_string.concat("/" + type);
            }
            card_string = card_string.concat("\n");
            card_string = card_string.concat("ATK: " + this.attack + "\n");
            if (!this.isLink) {
                card_string = card_string.concat("DEF: " + this.defense + "\n");
            }
            if (this.isPendulum) {
                card_string = card_string.concat("Pendulum Scales: " + this.pendulumLeft + " < --- > " + this.pendulumRight + "\n");
            }
            if (this.isLink) {
                card_string = card_string.concat("LINK-" + this.linkNumber + "\n");
                card_string = card_string.concat("Link Markers: ");
                for(int i = 0; i < this.linkMarkers.size(); i++){
                    if(i > 0){
                        card_string = card_string.concat(", ");
                    }
                    card_string = card_string.concat(this.linkMarkers.get(i));
                }
                card_string = card_string.concat("\n");
            }
            // ---
        } else if (this.type.equals("Spell")){
            // ---
            card_string = card_string.concat(this.property + " Spell");
            // ---
        } else if (this.type.equals("Trap")) {
            // ---
            card_string = card_string.concat(this.property + " Trap");
            // ---
        } else {
            return "Unknown Card Type";
        }
        card_string = card_string.concat("\n");

        if(this.getNumber() != null){
            card_string = card_string.concat("Passcode: " + this.number + "\n");
        }

        return card_string.trim();
    }

    public String toString(){
        String card_string = "";

        card_string = card_string.concat(this.name + "\n");
        if(this.type == null){
            return "Null Card Type";
        }
        else if(this.type.equals("Monster")){
            // ---
            if (!this.isXyz && !this.isLink) {
                card_string = card_string.concat("Level: " + this.stars + "\n");
            } else if (this.isXyz) {
                card_string = card_string.concat("Rank: " + this.stars + "\n");
            }
            card_string = card_string.concat("Attribute: " + this.attribute + "\n");
            card_string = card_string.concat("Types: " + this.species);
            for(String type : this.monsterTypes){
                card_string = card_string.concat("/" + type);
            }
            card_string = card_string.concat("\n");
            if (this.hasMaterials){
                card_string = card_string.concat(this.materials + "\n");
            }
            card_string = card_string.concat("ATK: " + this.attack + "\n");
            if (!this.isLink) {
                card_string = card_string.concat("DEF: " + this.defense + "\n");
            }
            if (this.isPendulum) {
                card_string = card_string.concat("Pendulum Scales: " + this.pendulumLeft + " < --- > " + this.pendulumRight + "\n");
                card_string = card_string.concat("[Pendulum Text]\n" + this.pendulumText + "\n");
            }
            if (this.isLink) {
                card_string = card_string.concat("LINK-" + this.linkNumber + "\n");
                card_string = card_string.concat("Link Markers: ");
                for(int i = 0; i < this.linkMarkers.size(); i++){
                    if(i > 0){
                        card_string = card_string.concat(", ");
                    }
                    card_string = card_string.concat(this.linkMarkers.get(i));
                }
                card_string = card_string.concat("\n");
            }
            card_string = card_string.concat("[Text]\n" + this.text);
            // ---
        } else if (this.type.equals("Spell")){
            // ---
            card_string = card_string.concat(this.property + " Spell");
            card_string = card_string.concat("[Text]\n" + this.text);
            // ---
        } else if (this.type.equals("Trap")) {
            // ---
            card_string = card_string.concat(this.property + " Trap");
            card_string = card_string.concat("[Text]\n" + this.text);
            // ---
        } else {
            return "Unknown Card Type";
        }
        card_string = card_string.concat("\n");

        if(this.getNumber() != null){
            card_string = card_string.concat("Passcode: " + this.number + "\n");
        }

        return card_string.trim();
    }
}