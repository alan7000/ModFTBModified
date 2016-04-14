package ovh.ftbmodified.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class DiamondOre extends Block
{
	public DiamondOre(Material rock)
    {
        super(Material.rock);
        this.setCreativeTab(ModFTBModified.FTBModifiedCreativeTabs);
    }

    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        return ModFTBModified.diamondNuggets;
    }
    
    public int quantityDropped(Random rand) 
    {
		
		return 1;
		
	}
}
