package ovh.ftbmodified.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class NetherStarBlock extends Block
{

	protected NetherStarBlock(Material iron) {
		super(iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
}
