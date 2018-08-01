package fr.freeboxos.ftb.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

	public class IronOre extends Block
	{

	    public IronOre(Material rock)
	    {
	        super(Material.rock);
	        this.setCreativeTab(CreativeTabs.tabBlock);
	    }

	    public Item getItemDropped(int metadata, Random rand, int fortune)
	    {
	        return ModFTBModified.ironBrut;
	    }
	    
	    public int quantityDropped(Random rand) 
	    {
			
			return 1;
			
		}
}
