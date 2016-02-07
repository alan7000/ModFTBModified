package ovh.ftbmodified.common;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;

public class WorldChunkManager extends net.minecraft.world.biome.WorldChunkManager 
{
	/**
	 * GenLayer = classe de GenLayer si vous utiliser un GenLayer qui n’hérite
	 * pas de la classe GenLayer alors il faut changer par votre classe
	 */
	private GenLayer genBiomes;
	private GenLayer biomeIndexLayer;
	/** L'objet du BiomeCache pour le monde */
	private BiomeCache biomeCache;
	/** List des biome ou le joueur peu spawn */
	private List<BiomeGenBase> biomesToSpawnIn;
	private ArrayList<BiomeGenBase> biomesToSpawnIn;

	@SuppressWarnings("unchecked")
	protected WorldChunkManager()
	{
		this.biomeCache = new BiomeCache(this);
		// liste des biomes ou nous spawons
		net.minecraft.world.biome.WorldChunkManager.allowedBiomes = new ArrayList<BiomeGenBase>();
		// Ce biome n'est pas le biome ou vous spawner forcement, mais dans
		// toute les classes il devra être mis
		this.getBiomesToSpawnIn().add(BiomeGenBase.forest);
	}

	public TutoWorldChunkManager(long par1, WorldType worldType)
	{
		this();
		/**
		 * Appele la fonction makeTheWorld dans la classe TutoGenLayer, la
		 * fonction est la fonction de génération de nos biome
		 */
		GenLayer[] agenlayer = GenLayer.makeTheWorld(par1);
		this.genBiomes = agenlayer[0];
		this.biomeIndexLayer = agenlayer[1];
	}

	public TutoWorldChunkManager(World world)
	{

	}

	/** Permet d'obtenir la list des biomes ou le joueur peut apparaitre */
	public List<BiomeGenBase> getBiomesToSpawnIn()
	{

	}

	/** Renvoie au BiomeGenBase a la position x, z relative dans le monde */
	public BiomeGenBase getBiomeGenAt(int x, int z)
	{

	}

	/**
	 * Retourne a la list des valeurs pour la pluis... ... pour en fonction de
	 * blocs spésifier
	 */
	public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
	{

	}

	/** Retourne a une température donner par raport au y */
	@SideOnly(Side.CLIENT)
	public float getTemperatureAtHeight(float par1, int par2)
	{

	}

	/** Retourne à un tableau pour les biomes a générer */
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
	{

	}

	/** Retourne au biome et charge les données pour les blocs */
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
	{
	
	}

	/**
	 * Retourne a une liste de biome pour les blocs spécifiés argument : x, y,
	 * largeur, longueur, cache.
	 */
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] arrayOfBiomeGenBase, int x, int y, int width, int length, boolean cacheFlag)
	{
	
	}

	/** Verifie les données du chunk */
	public boolean areBiomesViable(int x, int y, int z, List par4List)
	{
	
	}

	/** Trouve un biome dans un chunk */
	public ChunkPosition findBiomePosition(int x, int y, int z, List list, Random rand)
	{
		
	}

	/** Supprime le biome dans les 30s. si il n'est pas vérifier dans la temps */
	public void cleanupCache()
	{

	}
}
}
