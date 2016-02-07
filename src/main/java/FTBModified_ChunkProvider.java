import java.awt.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.profiler.Profiler.Result;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;



public class FTBModified_ChunkProvider implements IChunkProvider 
{
	//les noises
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private WorldType worldType;
	private final double[] noiseArray;
	private final float[] parabolicField;
	private final boolean mapFeaturesEnabled;
	   
	private MapGenBase caveGenerator = new MapGenCaves();//la génération des caves, remplacer par votre ravin si vous utiliser une autre stone
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();//la génération des mineshaft, ""        ""                     ""
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
	private MapGenBase ravineGenerator = new MapGenRavine();//la structure du ravin,          ""             ""                     ""

	private double[] stoneNoise = new double[256];
	private BiomeGenBase[] biomesForGeneration;
	double[] noiseData1; //les noises data
	double[] noiseData2;
	double[] noiseData3;
	double[] noiseData4;
	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	
	@SuppressWarnings("deprecation")
	{
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
        scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }
}

public FTBModified_ChunkProvider(World world, long seed, boolean features)
{
	 this.worldObj = world;
     this.mapFeaturesEnabled = features;
     this.worldType = world.getWorldInfo().getTerrainType();
     this.rand = new Random(seed);
     this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
     this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
     this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
     this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
     this.noiseArray = new double[825];
     this.parabolicField = new float[25];

     
     for (int j = -2; j <= 2; ++j)
     {
         for (int k = -2; k <= 2; ++k)
         {
             float f = 10.0F / MathHelper.sqrt_float((float)(j * j + k * k) + 0.2F);
             this.parabolicField[j + 2 + (k + 2) * 5] = f;
         }
     }
     
     NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise};
     noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
     this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
     this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
     this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
     this.noiseGen4 = (NoiseGeneratorPerlin)noiseGens[3];
     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
}


public void func_147424_a(int Xchunks, int Zchunks, int i)
{
    byte b0 = 63;
    this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, Xchunks * 4 - 2, Zchunks * 4 - 2, 10, 10);
    this.func_147424_a(Xchunks * 4, 0, Zchunks * 4);

    final Random rand = new Random();
    
    for (int k = 0; k < 4; ++k)
    {
        int l = k * 5;
        int i1 = (k + 1) * 5;

        for (int j1 = 0; j1 < 4; ++j1)
        {
            int k1 = (l + j1) * 33;
            int l1 = (l + j1 + 1) * 33;
            int i2 = (i1 + j1) * 33;
            int j2 = (i1 + j1 + 1) * 33;

            for (int k2 = 0; k2 < 32; ++k2)
            {
                double d0 = 0.105D;
                double d1 = this.noiseArray[k1 + k2];
                double d2 = this.noiseArray[l1 + k2];
                double d3 = this.noiseArray[i2 + k2];
                double d4 = this.noiseArray[j2 + k2];
                double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
                double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
                double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
                double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;

                for (int l2 = 0; l2 < 8; ++l2)
                {
                    double d9 = 0.25D;
                    double d10 = d1;
                    double d11 = d2;
                    double d12 = (d3 - d1) * d9;
                    double d13 = (d4 - d2) * d9;

                    for (int i3 = 0; i3 < 4; ++i3)
                    {
                        int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                        short short1 = 256;
                        j3 -= short1;
                        double d14 = 0.25D;
                        double d16 = (d11 - d10) * d14;
                        double d15 = d10 - d16;

                        for (int k3 = 0; k3 < 4; ++k3)
                        {
                            if ((d15 += d16) > 0.0D)
                            {
                                i[j3 += short1] = Blocks.stone;
                            }
                            else if (k2 * 8 + l2 < b0)
                            {
                                i[j3 += short1] = Blocks.water;
                            }
                            else
                            {
                                i[j3 += short1] = null;
                            }
                        }

                        d10 += d12;
                        d11 += d13;
                    }

                    d1 += d5;
                    d2 += d6;
                    d3 += d7;
                    d4 += d8;
                }
            }
        }
    }
}

@SuppressWarnings("deprecation")
public void replaceBlocksForBiome(int coordX, int coordZ, Block[] block, byte[] arrayOfByte, BiomeGenBase[] biomeList)
{
    ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, coordX, coordZ, block, biomeList);
    MinecraftForge.EVENT_BUS.post(event);
    if (event.getResult() == Result.DENY) return;

    double d0 = 0.03125D;
    this.stoneNoise = this.noiseGen4.func_151599_a(this.stoneNoise, (double)(coordX * 16), (double)(coordZ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

    for (int k = 0; k < 16; ++k)
    {
        for (int l = 0; l < 16; ++l)
        {
        	BiomeGenPlains /*TODO ce biome est a remplacer par le votre*/ biomegenbase = (BiomeGenPlains /*TODO ce biome est a remplacer par le votre*/)biomeList[l + k * 16];
			biomegenbase.genTerrainBlocks(this.worldObj, this.rand, block, arrayOfByte, coordX * 16 + k, coordZ * 16 + l, this.stoneNoise[l + k * 16]);
		}
    }
}

public Chunk loadChunk(int par1, int par2)
{
    return this.provideChunk(par1, par2);
}

public Chunk provideChunk(int par1, int par2)
{
    this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
    Block[] ablock = new Block[65536];
    byte[] abyte = new byte[65536];
    this.func_147424_a(par1, par2, ablock);
    this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
    this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
    this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
    this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);

    if (this.mapFeaturesEnabled)
    {
        this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
        this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
    }

    Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
    byte[] abyte1 = chunk.getBiomeArray();

    for (int k = 0; k < abyte1.length; ++k)
    {
        abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
    }

    chunk.generateSkylightMap();
    return chunk;
}


private void func_147423_a(int x, int y, int z)
{
double d0 = 684.412D;
double d1 = 684.412D;
double d2 = 512.0D;
double d3 = 512.0D;
this.noiseData4 = this.noiseGen6.generateNoiseOctaves(this.noiseData4, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
boolean flag1 = false;
boolean flag = false;
int l = 0;
int i1 = 0;
double d4 = 8.5D;

for (int j1 = 0; j1 < 5; ++j1)
{
 for (int k1 = 0; k1 < 5; ++k1)
 {
     float f = 0.0F;
     float f1 = 0.0F;
     float f2 = 0.0F;
     byte b0 = 2;
     BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

     for (int l1 = -b0; l1 <= b0; ++l1)
     {
         for (int i2 = -b0; i2 <= b0; ++i2)
         {
             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
             float f3 = biomegenbase1.rootHeight;
             float f4 = biomegenbase1.heightVariation;

             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

             if (biomegenbase1.rootHeight > biomegenbase.rootHeight)
             {
                 f5 /= 2.0F;
             }

             f += f4 * f5;
             f1 += f3 * f5;
             f2 += f5;
         }
     }

     f /= f2;
     f1 /= f2;
     f = f * 0.9F + 0.1F;
     f1 = (f1 * 4.0F - 1.0F) / 8.0F;
     double d13 = this.noiseData4[i1] / 8000.0D;

     if (d13 < 0.0D)
     {
         d13 = -d13 * 0.3D;
     }

     d13 = d13 * 3.0D - 2.0D;

     if (d13 < 0.0D)
     {
         d13 /= 2.0D;

         if (d13 < -1.0D)
         {
             d13 = -1.0D;
         }

         d13 /= 1.4D;
         d13 /= 2.0D;
     }
     else
     {
         if (d13 > 1.0D)
         {
             d13 = 1.0D;
         }

         d13 /= 8.0D;
     }

     ++i1;
     double d12 = (double)f1;
     double d14 = (double)f;
     d12 += d13 * 0.2D;
     d12 = d12 * 8.5D / 8.0D;
     double d5 = 8.5D + d13 * 4.0D;

     for (int j2 = 0; j2 < 33; ++j2)
     {
         double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

         if (d6 < 0.0D)
         {
             d6 *= 4.0D;
         }

         double d7 = this.noiseData2[l] / 512.0D;
         double d8 = this.noiseData3[l] / 512.0D;
         double d9 = (this.noiseData1[l] / 10.0D + 1.0D) / 2.0D;
         double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

         if (j2 > 29)
         {
             double d11 = (double)((float)(j2 - 29) / 3.0F);
             d10 = d10 * (1.0D - d11) + -10.0D * d11;
         }

         this.noiseArray[l] = d10;
         ++l;
     }
 }
}
}

public boolean chunkExists(int par1, int par2)
{
    return true;
}

public void populate(IChunkProvider chunkProvider, int x, int z)
{
    BlockFalling.fallInstantly = true;
    int x1 = x * 16;
    int z1 = z * 16;
    BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(x1 + 16, z1 + 16);
    this.rand.setSeed(this.worldObj.getSeed());
    long i1 = this.rand.nextLong() / 2L * 2L + 1L;
    long j1 = this.rand.nextLong() / 2L * 2L + 1L;
    this.rand.setSeed((long)x * i1 + (long)z * j1 ^ this.worldObj.getSeed());
    boolean flag = false;

    MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(chunkProvider, worldObj, rand, x, z, flag));
   
    
    // si l'option de génération des structures est activer alors nous générons le mineshaft et l'autre structure
     
    if (this.mapFeaturesEnabled)
    {
        this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, x, z);
        this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, x, z);
    }

    int x2;
    int z2;
    int i2;
    
    //si le biome n'est pas un désert, une montagne du désert, et que la rand.nextIn(4) ne fait pas 0 alors nous avons un lac
    if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0
        && TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, LAKE))
    {
        x2 = x1 + this.rand.nextInt(16) + 8;
        z2 = this.rand.nextInt(256);
        i2 = z1 + this.rand.nextInt(16) + 8;
        					//Le blocs de génération du lac
        (new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, x2, z2, i2);
    }
    
    //la condition est la même que en haut, sans les biomes 
    if (TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, LAVA) && !flag && this.rand.nextInt(8) == 0)
    {
        x2 = x1 + this.rand.nextInt(16) + 8;
        //nous définissons les x, y, z
        z2 = this.rand.nextInt(this.rand.nextInt(248) + 8);
        i2 = z1 + this.rand.nextInt(16) + 8;

        if (z2 < 63 || this.rand.nextInt(10) == 0)
        {						//changer le par le blocs de votre choix
            (new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, x2, z2, i2);
        }
    }
    
    //sa nous permet de générer des donjons, comme plus haut changer la classe par la votre pour générer vos donjons
    boolean doGen = TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, DUNGEON);
    for (x2 = 0; doGen && x2 < 8; ++x2)
    {
        z2 = x1 + this.rand.nextInt(16) + 8;
        i2 = this.rand.nextInt(256);
        int j2 = z1 + this.rand.nextInt(16) + 8;
        //changer la classe par votre classe
        (new WorldGenDungeons()).generate(this.worldObj, this.rand, z2, i2, j2);
    }

    biomegenbase.decorate(this.worldObj, this.rand, x1, z1);
    //sa ajoute des mobs
    if (TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, ANIMALS))
    {
    SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, x1 + 8, z1 + 8, 16, 16, this.rand);
    }
    x1 += 8;
    z1 += 8;
    
    //sa remplace la génération de l'eau par de la glasse, et ajoute la tomber de neige
    doGen = TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, ICE);
    for (x2 = 0; doGen && x2 < 16; ++x2)
    {
        for (z2 = 0; z2 < 16; ++z2)
        {
            i2 = this.worldObj.getPrecipitationHeight(x1 + x2, z1 + z2);

            if (this.worldObj.isBlockFreezable(x2 + x1, i2 - 1, z2 + z1))
            {
                this.worldObj.setBlock(x2 + x1, i2 - 1, z2 + z1, Blocks.ice, 0, 2);
            }

            if (this.worldObj.func_147478_e(x2 + x1, i2, z2 + z1, true))
            {
                this.worldObj.setBlock(x2 + x1, i2, z2 + z1, Blocks.snow_layer, 0, 2);
            }
        }
    }

    MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(chunkProvider, worldObj, rand, x, z, flag));

    BlockFalling.fallInstantly = false;
}

public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
{
    return true;
}

public void saveExtraData() {}

public boolean unloadQueuedChunks()
{
    return false;
}

public boolean canSave()
{
    return true;
}

public String makeString()
{
    return "RandomLevelSource";
}

@SuppressWarnings("rawtypes")
public java.util.List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
{
	/*TODO*/BiomeGenPlains biomegenbase = (/*TODO*/BiomeGenPlains)this.worldObj.getBiomeGenForCoords(par2, par4);
	return par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4) ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() : biomegenbase.getSpawnableList(par1EnumCreatureType);
}

public ChunkPosition func_147416_a(World world, String strg, int x, int y, int z)
{
    return null;
}

public int getLoadedChunkCount()
{
    return 0;
}

public void recreateStructures(int par1, int par2)
{
    if (this.mapFeaturesEnabled)
    {
        this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
        this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
    }
}
}