package fr.freeboxos.ftb.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FTBModifiedCreativeTabs extends CreativeTabs 
{

	public FTBModifiedCreativeTabs(String lable) 
	{
		super(lable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ModFTBModified.netherStarBlock);
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
