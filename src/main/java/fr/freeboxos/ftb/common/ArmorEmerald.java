package fr.freeboxos.ftb.common;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorEmerald extends ItemArmor {

	public ArmorEmerald(ArmorMaterial material, int type)
	{
		super(material, 0, type);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(slot == 2)
		{
			return ModFTBModified.MODID + ":textures/models/armor/emerald_layer_2.png";
		}
		return ModFTBModified.MODID + ":textures/models/armor/emerald_layer_1.png";
	}
}
