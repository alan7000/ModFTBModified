package fr.freeboxos.ftb.common;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenOre extends BiomeGenBase 
{
	public BiomeGenOre()
	{
		super(40);
		this.setBiomeName("Biome Ore");
		this.topBlock = Blocks.diamond_block;
		this.fillerBlock = Blocks.emerald_block;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}
	
}
