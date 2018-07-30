package ovh.ftbmodified.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneration implements IWorldGenerator 
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
		
	}

	private void generateSurface(World world, Random random, int x, int z) 
	{
		this.addOreSpawn(ModFTBModified.ironBrutblock, 0, Blocks.stone, world, random, x, z, 16, 16, 10, 20, 1, 90);
		this.addOreSpawn(ModFTBModified.emeraldBrutblock, 0, Blocks.stone, world, random, x, z, 16, 16, 10, 20, 1, 90);
		this.addOreSpawn(ModFTBModified.goldBrutblock, 0, Blocks.stone, world, random, x, z, 16, 16, 10, 20, 1, 90);
		this.addOreSpawn(ModFTBModified.diamondBrutblock, 0, Blocks.stone, world, random, x, z, 16, 16, 10, 20, 1, 90);
		this.addOreSpawn(ModFTBModified.netherStarOre, 0, Blocks.stone, world, random, x, z, 16, 16, 1, 1, 1, 16);
	}
	
	public void addOreSpawn(Block block, int metadata, Block target, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) 
	{
		assert maxY > minY : "La position Y maximum doit �tre sup�rieure � la position Y minimum.";
        assert maxX > 0 && maxX <= 16 : "X doit se trouver entre 0 et 16.";
        assert minY > 0 : "La position Y minimum doit �tre sup�rieure � 0.";
        assert maxY < 256 && maxY > 0 : "La position Y maximum doit se trouver entre 0 et 256.";
        assert maxZ > 0 && maxZ <= 16 : "Z doit se trouver entre 0 et 16.";
        
        for(int i = 0; i < chanceToSpawn; i++) 
        {
        	int posY = random.nextInt(128);
        	
        	if((posY <= maxY) && (posY >= minY)) 
        	{
        		
        		(new WorldGenMinable(block, metadata, maxVeinSize, target)).generate(world, random, blockXPos + random.nextInt(16), posY, blockZPos + random.nextInt(16));
        		
        	}
        }
		
	}
}
