package ovh.ftbmodified.common;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class FTBModified_Genlayer extends GenLayer {

	public FTBModified_Genlayer(long par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	
	public static GenLayer[] makeTheWorld(long l)
	{
		GenLayer biomes = new FTBModified_Genlayer(1L);

		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);

		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
		biomes.initWorldGenSeed(l);
		genlayervoronoizoom.initWorldGenSeed(l);

		return new GenLayer[] {biomes, genlayervoronoizoom};
	}

}
