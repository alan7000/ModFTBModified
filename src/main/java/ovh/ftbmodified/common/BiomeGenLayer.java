package ovh.ftbmodified.common;

import net.minecraft.world.gen.layer.GenLayer;

protected BiomeGenBase[] baseBiome = {BiomeGenBase.BiomeGenOre};

		public TutoBiomeGenLayer(long seed)
		{
			super(seed);
		}
		
		@Override
		public int[] getInts(int coordX, int coordZ, int width, int depth) 
		{
			int[] dest = IntCache.getIntCache(width * depth);
			
			for(int dz = 0; dz < depth; dz++)
			{
				for(int dx = 0; dx < width; dx++)
				{
					this.initChunkSeed(dx + coordX, dz + coordZ);
					dest[(dx + dz * width)] = this.baseBiome[nextInt(this.baseBiome.length)].biomeID;
				}
			}
			return dest;
		}
		}
