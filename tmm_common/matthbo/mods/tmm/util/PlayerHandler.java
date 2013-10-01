package matthbo.mods.tmm.util;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

import matthbo.mods.tmm.item.Items;
import matthbo.mods.tmm.lib.tools.AbilityHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.IPlayerTracker;

/**
 * Big thanks to mDyo for his code on github, it helped a LOT!
 * 
 * @author Matthbo
 */
public class PlayerHandler implements IPlayerTracker{
	
	 public ConcurrentHashMap<String, PlayerStats> playerStats = new ConcurrentHashMap<String, PlayerStats>();

	@Override
	public void onPlayerLogin(EntityPlayer entityplayer) {
		
		NBTTagCompound tags = entityplayer.getEntityData();
        if (!tags.hasKey("TMM")){
            tags.setCompoundTag("TMM", new NBTTagCompound());
        }
        
        PlayerStats stats = new PlayerStats();
        stats.player = new WeakReference<EntityPlayer>(entityplayer);
        stats.vanillaManual = tags.getCompoundTag("TMM").getBoolean("vanillaManual");
        
        if(!stats.vanillaManual){
        	stats.vanillaManual = true;
            tags.getCompoundTag("TMM").setBoolean("beginnerManual", true);
            
            //maby toggle if you want vanilla book?
            
            ItemStack wiki = new ItemStack(Items.vanillaManual);
            if (!entityplayer.inventory.addItemStackToInventory(wiki))
            {
                AbilityHelper.spawnItemAtPlayer(entityplayer, wiki);
            }
        }
        playerStats.put(entityplayer.username, stats);
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		savePlayerStats(player, true);
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		
	}
	
	public PlayerStats getPlayerStats (String username)
    {
        PlayerStats stats = playerStats.get(username);
        if (stats == null){
            stats = new PlayerStats();
            playerStats.put(username, stats);
        }
        return stats;
    }
	
	public void savePlayerStats (EntityPlayer player, boolean clean)
    {
        if (player != null){
            PlayerStats stats = getPlayerStats(player.username);
            if (clean) playerStats.remove(player.username);
            else{}
        }
    }

}
