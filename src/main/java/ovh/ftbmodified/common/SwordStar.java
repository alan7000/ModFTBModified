package ovh.ftbmodified.common;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class SwordStar extends ItemSword

{
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving)

	{

		par2EntityLiving.setFire(2);

		par1ItemStack.damageItem(1, par3EntityLiving);

		return true;

	}
	
	public SwordStar(ToolMaterial material) 
	
	{
		super(material);
	}
}
