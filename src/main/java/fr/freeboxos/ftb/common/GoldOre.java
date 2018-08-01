package fr.freeboxos.ftb.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoldOre extends Block
{
	public GoldOre(Material rock)
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        return ModFTBModified.goldBrut;
    }
    
    public int quantityDropped(Random rand) 
    {
		
		return 1;
		
	}
}
