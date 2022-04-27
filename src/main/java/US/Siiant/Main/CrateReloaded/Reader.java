package US.Siiant.Main.CrateReloaded;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Reader {

    //Crete a new instanceof the CrateReloaded config reader.
    public Reader() {
        //Yaml Reader
        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        try {
            //Read the file.
            inputStream = new FileInputStream("C:\\Users\\Siiant\\Desktop\\crate.yml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Load the file as a map, String as the header, contents as an object.
        Map<String, Object> obj = yaml.load(inputStream);
        obj.forEach((key,value) -> {
            String fixedCrateConfig = value.toString().replace("{", "%").replace("}","%");
            //Create the CrateReloaded Crate
            Crate crate = new Crate(key);
            //Set Type
            String temp = getContents("type=", "item=", fixedCrateConfig);
            crate.setType(temp.substring(0,temp.length() -1));
            //Set Key
            String item = getContents("item=", "animation=", fixedCrateConfig);
            //Set the Key Item
            crate.setKeyItem(getContents("item=", "name:", fixedCrateConfig));
            //Set the Key Amount needed

           crate.setKeyAmount(Integer.parseInt(item.substring(item.indexOf("name:")  -2, item.indexOf("name:")).replace(" ", "")));
            //Set the Key Display Name
            crate.setKeyDisplayName(getContents("name:", "lore:",item));
            //Set Key Lore
            String keyLore = getContents("lore:", "animation=", fixedCrateConfig);
            if(keyLore.contains("glow:true")){
                //Remove the glow option from lore.
                keyLore = keyLore.replace("glow:true", "");
                //Set Glow
                crate.setKeyGlow(true);
            }
            if(keyLore.contains("\\|")){
                crate.setKeyLore(keyLore.split("\\|"));
            }
            //Set Animation
            temp = getContents("animation=", "display-name=", fixedCrateConfig);
            crate.setAnimation(temp.substring(0,temp.length() - 1));
            //Set DisplayName
            temp = getContents("display-name=", "holographic=", fixedCrateConfig);
            crate.setAnimation(temp.substring(0,temp.length() - 1));
            //Set Holograms
            String hologramRaw = getContents("holographic=", "confirmation=", fixedCrateConfig );
            crate.setHologram(new ArrayList<>(Arrays.asList(hologramRaw.substring(0,hologramRaw.lastIndexOf(",")).split(","))));
            //Get ConfirmationEnabled
            String rawConfirm = getContents("confirmation=","preview=",fixedCrateConfig);
            crate.setConfirmation(rawConfirm.contains("true"));
            //Setup Accept button
            String acceptRaw  = getContents("accept-button=", "decline-button=", rawConfirm);
            //Set the Accept Item
            crate.setAcceptItem(acceptRaw.substring(item.indexOf(" ") - 1));
            //Set the  Amount
            crate.setAcceptAmount(Integer.parseInt(acceptRaw.substring(acceptRaw.indexOf("name:")  -2, acceptRaw.indexOf("name:")).replace(" ", "")));
            //Set the Accept Display Name
            if(acceptRaw.contains("glow:true")){
                //Remove the glow option from lore.
                acceptRaw = acceptRaw.replace("glow:true", "");
                //Set Glow
                crate.setDeclineGlow(true);
            }
            if(acceptRaw.contains("lore:")){
                crate.setDeclineDisplayName(getContents("name:", "lore:",acceptRaw));
                String rawDeclineLore = acceptRaw.substring(acceptRaw.indexOf("lore:"));
                if(acceptRaw.contains("\\|")){
                    crate.setDeclineLore(rawDeclineLore.split("\\|"));
                } else {
                    String[] notSplit = {rawDeclineLore};
                    crate.setDeclineLore(notSplit);
                }
            } else {
                crate.setDeclineDisplayName(acceptRaw.substring(acceptRaw.indexOf("name:")));
            }

            //Setup Decline button
            String declineRaw  = getContents("decline-button=", "preview=", fixedCrateConfig);
           //Set the Decline Item
            crate.setDeclineItem(declineRaw.substring(item.indexOf(" ") - 1));
            //Set the Decline Amount
            crate.setDeclineAmount(Integer.parseInt(declineRaw.substring(declineRaw.indexOf("name:")  -2, declineRaw.indexOf("name:")).replace(" ", "")));
            //Set the Decline Display Name
            if(declineRaw.contains("glow:true")){
                //Remove the glow option from lore.
                declineRaw = declineRaw.replace("glow:true", "");
                //Set Glow
                crate.setDeclineGlow(true);
            }
            if(declineRaw.contains("lore:")){
                crate.setDeclineDisplayName(getContents("name:", "lore:",declineRaw));
                String rawDeclineLore = declineRaw.substring(declineRaw.indexOf("lore:"));
                if(declineRaw.contains("\\|")){
                    crate.setDeclineLore(rawDeclineLore.split("\\|"));
                } else {
                    String[] notSplit = {rawDeclineLore};
                    crate.setDeclineLore(notSplit);
                }
            } else {
                crate.setDeclineDisplayName(declineRaw.substring(declineRaw.indexOf("name:")));
            }

            //Set Preview
            String rawPreview = getContents("preview=","buy=",fixedCrateConfig);
                //Set enabled
            crate.setPreview(rawPreview.contains("true"));
                //Get Rows
            String rows = (rawPreview.substring(rawPreview.indexOf("rows=")).replace("rows=", ""));
            rows = rows.substring(0, rows.length() -2);
            if(rows.contains("%")){
                rows = rows.replace("%", "");
            }
            crate.setRows(Integer.parseInt(rows));

            String rawBuy = getContents("buy=","message=",fixedCrateConfig);
            if (rawBuy.contains("%")){
                rawBuy = rawBuy.replace("%", "");
            }
            if(rawBuy.contains(",")){
                rawBuy = rawBuy.replace(",","");
            }
                //Set enabled
            crate.setBuy(rawBuy.contains("true"));
            //Get Message Open
            String rawCost = rawBuy.substring(rawBuy.indexOf("cost=")).replace(" ", "");
            if(rawCost.contains("cost=")){
                rawCost = rawCost.replace("cost=", "");
            }
            crate.setCost(Integer.parseInt(rawCost));
                //Get Message
            String rawMessage = getContents("message=", "effect=", fixedCrateConfig);
                //Set Player Message
            crate.setMessageOpen(getContents("open=", "broadcast=", rawMessage));
                //Set Broadcast Message
            crate.setBroadcast(rawMessage.substring(rawMessage.indexOf("broadcast=")));

            //Get Effects
                String rawEffects = getContents("effect=","reward=",fixedCrateConfig);
                if(rawEffects.contains("%%")){
                    rawEffects = rawEffects.replace("%%", "%");
                }
                ArrayList<Effect> effects = new ArrayList<>();
                String[] split = rawEffects.split("%,");
                //For each effect there is per crate, this will run.
                // EX 2 Crates x 3 Effects per = 6 Runs total
                for(int i = 0; i < split.length -1; i++){
                    Effect effect = new Effect();
                    if(split[i].toLowerCase().contains("firework")){
                        String rawEffect = split[i].replace(",", "");
                        //Set class
                        effect.setClassType(getContents("class=","category=", rawEffect));
                        //Set Category
                        effect.setCategory(getContents("category=","fireworkType=",rawEffect));
                        //Set firework Type
                        effect.setFireworkType(getContents("fireworkType=", "color=", rawEffect));
                        //Set color1
                        effect.setColor(getContents("color=","color2=",rawEffect));
                        //Set color2
                        effect.setColor2(getContents("color2=","color3=",rawEffect));
                        //Set color3
                        effect.setColor3(getContents("color3=","fadeColor=",rawEffect));
                        //Set Fade Color
                        effect.setFadeColor(getContents("fadeColor=", "trail=",rawEffect));
                        //Set trail
                        effect.setTrail(rawEffect.contains("true"));
                        //Set radius
                        effect.setRadius(getContents("radius=", "power=",rawEffect));
                        //Set Power
                        effect.setPower(Integer.parseInt( rawEffect.substring(rawEffect.indexOf("power=")).replace("power=", "")));
                    } else {
                        String rawEffect = split[i].replace(",", "");
                        //Set class
                        effect.setClassType(getContents("class=","category=", rawEffect));
                        //Set Category
                        effect.setCategory(getContents("category=","particle=",rawEffect));
                        //Set Particle
                        effect.setParticle(getContents("particle=","radius=",rawEffect));
                        //Set radius
                        effect.setRadius(getContents("radius=", "particles=",rawEffect));
                        //Set Particles
                        effect.setParticles(Integer.parseInt(getContents("particles=","period=",rawEffect).replace(" ", "")));
                        //Set Period
                        effect.setPeriod(Integer.parseInt( rawEffect.substring(rawEffect.indexOf("period=")).replace("period=", "")));
                    }
                    //Set the effect in the effects list
                    effects.add(effect);
                }
            //Set the crates effects after reading all of them.
            crate.setEffects(effects);
            //Get Rewards
            //We pass in the raw config for the crate here, as it makes it easier to get the rewards this way.
            crate.setRewards(setupRewards(value.toString()));

            //Completed Crate Message
            System.out.println("Finished reading " + key + " crate from CrateReloaded.");
        });

    }


    private ArrayList<Reward> setupRewards(String rawCrateConfig) {
        String rawRewards = getContents("rewards=[", "]}}", rawCrateConfig);
        ArrayList<Reward> rewards = new ArrayList<>();
        //Replace first case of the string "unique:()" to properly format the strings
        String temp = rawRewards.replaceFirst("unique:\\(\\),", "");
        String[] splitRawRewards = temp.split("unique:\\(\\)");
        for (String splitRawReward : splitRawRewards) {
            //Individualize each reward and prepare the placeholders properly.
            String rawReward = splitRawReward.replace("{", "%").replace("}", "%");
            Reward reward = new Reward();
            reward.setChance(Double.parseDouble(getContents("chance:(", ")", rawReward)));
            if (rawReward.contains("item:(")) {
                //Specialized crates requires the item to be given via command, so we're converting the raw item to a command.
                reward.setAction("give %player%" + getContents("item:(", ")", rawReward));
                String item = getContents("item:(", ")", rawReward);
                //Set the Item
                reward.setItem(item.substring(item.indexOf(" ") - 1));
                //Set the amount
                reward.setItemAmount(Integer.parseInt(item.substring(item.indexOf(" ") + 1)));
            } else {
                //Set the command that will be run when the reward is won.
                reward.setAction(getContents("cmd:(", ")", rawReward));
                //Set the display name in the crate
                reward.setDisplayName(getContents("name:", ")", rawReward));
                //Break the Item up to get the Item and the Amount
                String item = getContents("display:(", " name:", rawReward);
                //Set the Item
                reward.setItem(item.substring(item.indexOf(" ") - 1));
                //Set the amount
                reward.setItemAmount(Integer.parseInt(item.substring(item.indexOf(" ") + 1)));
            }
            //Set the message the player receives when they get that item.
            reward.setMessage(getContents("msg:(", ")", rawReward));
            //Set if the display item should glow.
            reward.setGlow(rawReward.contains("glow:true"));
            rewards.add(reward);
        }
        return rewards;
    }

    private String getContents(String startingPoint, String endingPoint, String rawString){
        int start = rawString.indexOf(startingPoint);
        int end = rawString.indexOf(endingPoint, start);
        return rawString.substring(start,end).replace(startingPoint, "");
    }
}
