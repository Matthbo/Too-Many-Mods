package matthbo.mods.tmm.util;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

import matthbo.mods.tmm.config.ConfigHandler;
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
        if (!tags.hasKey("TMM"))
        {
            tags.setCompoundTag("TMM", new NBTTagCompound());
        }
        PlayerStats stats = new PlayerStats();
        stats.player = new WeakReference<EntityPlayer>(entityplayer);

        stats.vanillaManual = tags.getCompoundTag("TMM").getBoolean("vanillaManual");
        
        if (!stats.vanillaManual)
        {
            stats.vanillaManual = true;
            tags.getCompoundTag("TMM").setBoolean("vanillaManual", true);
            if (ConfigHandler.vanillaManual)
            {
                ItemStack diary = new ItemStack(Items.vanillaManual);
                if (!entityplayer.inventory.addItemStackToInventory(diary))
                {
                    AbilityHelper.spawnItemAtPlayer(entityplayer, diary);
                }
            }
        }

        playerStats.put(entityplayer.username, stats);
        updatePlayerInventory(entityplayer, stats);
    }

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		savePlayerStats(player, true);
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		savePlayerStats(player, false);
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		PlayerStats stats = getPlayerStats(player.username);
        stats.player = new WeakReference<EntityPlayer>(player);
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
	
	void savePlayerStats (EntityPlayer player, boolean clean)
    {
        if (player != null){
            PlayerStats stats = getPlayerStats(player.username);
            if (stats != null){
            	if (clean) playerStats.remove(player.username);
            }
            else{}
            
        }
    }
	
	void updatePlayerInventory (EntityPlayer entityplayer, PlayerStats stats)
    {

    }

}
