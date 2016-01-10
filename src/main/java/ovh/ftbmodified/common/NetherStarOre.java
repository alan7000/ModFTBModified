package ovh.ftbmodified.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

	public class NetherStarOre extends Block
		{
		
		protected NetherStarOre(Material rock) 
		{
			super(rock);
			this.setCreativeTab(CreativeTabs.tabBlock);
		}
		public Item getItemDropped(int metadata, Random rand, int fortune)
	    {
	        return ModFTBModified.netherStardust;
	    }
	    
	    public int quantityDropped(Random rand) 
	    {
			
			return 1;
			
		}

}
